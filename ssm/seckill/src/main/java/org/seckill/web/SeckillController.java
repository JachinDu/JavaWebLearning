package org.seckill.web;


import org.apache.ibatis.annotations.ResultMap;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.dto.SeckillResult;
import org.seckill.entity.Seckill;
import org.seckill.enums.SeckillStateEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/seckill")//url:/模块/资源/{id}/细分
public class SeckillController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;


    /*
    * 列表页
    * */
    @RequestMapping(path="/list",method = RequestMethod.GET)
    public String list(Model model) {

        //获取列表页
        List<Seckill> list = seckillService.getSeckillList();
        model.addAttribute("list", list);

        return "list";
    }


    /*
    * 商品详情页
    * */
    //PathVariable注解获取路径上的参数
    @RequestMapping(value = "/{seckillId}/detail",method = RequestMethod.GET)
    public String detail(@PathVariable("seckillId") Long seckillId, Model model) {

        if (seckillId == null) {
            //重定向到list请求
            return "redirect:/seckill/list";
        }
        Seckill seckill = seckillService.getById(seckillId);
        if (seckill == null) {
            return "forward:/seckill/list";
        }
        model.addAttribute("seckill", seckill);
        System.out.println(seckill);
        return "detail";
    }


    /*
     * 输出秒杀地址页
     * ajax请求   返回json
     * */
    @ResponseBody  //告诉springmvc返回类型是json
    @RequestMapping(value = "/{seckillId}/exposer",
                            method = RequestMethod.POST,
                            produces = {"application/json;charset=UTF-8"})
    public SeckillResult<Exposer> exposer(@PathVariable("seckillId") Long seckillId) {

        SeckillResult<Exposer> result;
        try {
            Exposer exposer = seckillService.exportSeckillUrl(seckillId);
            result = new SeckillResult<Exposer>( true,exposer);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            //失败
            result = new SeckillResult<Exposer>(false, e.getMessage());
        }
        return result;
    }


    /*
     * 执行秒杀
     * */
    @RequestMapping(value = "/{seckillId}/{md5}/execution",
                            method = RequestMethod.POST,
                            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    //注意参数中，phone从cookie中获取，false意为参数phone不必须
    public SeckillResult<SeckillExecution> execution(@PathVariable("seckillId") Long seckillId,
                                                     @PathVariable("md5") String md5,
                                                     @CookieValue(value = "killPhone",required = false) Long phone) {

        if (phone == null) {
            return new SeckillResult<SeckillExecution>(false, "未注册");
        }

        SeckillResult<SeckillExecution> result;

        try {
//            SeckillExecution execution = seckillService.executeSeckill(seckillId, phone, md5);
            //存储过程调用
            SeckillExecution execution = seckillService.executeSeckillProcedure(seckillId, phone, md5);
            return new SeckillResult<SeckillExecution>(true, execution);
        } catch (RepeatKillException e) {
            SeckillExecution execution = new SeckillExecution(seckillId, SeckillStateEnum.REPEAT_KILL);
            return new SeckillResult<SeckillExecution>(true,execution);
        } catch (SeckillCloseException e) {
            SeckillExecution execution = new SeckillExecution(seckillId, SeckillStateEnum.END);
            return new SeckillResult<SeckillExecution>(true,execution);
        } catch (SeckillException e) {
            logger.error(e.getMessage(), e);
            SeckillExecution execution = new SeckillExecution(seckillId, SeckillStateEnum.INNER_ERROR);
            return new SeckillResult<SeckillExecution>(true,execution);
        }
    }


    @RequestMapping(value = "/time/now",method = RequestMethod.GET)
    @ResponseBody
    public SeckillResult<Long> time() {
        Date now = new Date();
        return new SeckillResult<>(true, now.getTime());
    }
}
