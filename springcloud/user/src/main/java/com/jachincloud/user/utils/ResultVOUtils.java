package com.jachincloud.user.utils;

import com.jachincloud.user.VO.ResultVO;
import com.jachincloud.user.enums.ResultEnum;

/**
 * @description: ResultVO工具
 * @Author: JachinDo
 * @Date: 2019/07/18 21:11
 */

public class ResultVOUtils {
    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

//    public static ResultVO success() {
//        return success(null);
//    }

    public static ResultVO error(ResultEnum resultEnum) {

        ResultVO resultVO = new ResultVO();
        resultVO.setCode(resultEnum.getCode());
        resultVO.setMsg(resultEnum.getMessage());
        return resultVO;

    }

    public static ResultVO success() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }
}
