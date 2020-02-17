package com.jachincloud.product.utils;

import com.jachincloud.product.VO.ResultVO;

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

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {

        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;

    }
}
