package com.jachin.sell.VO;

import lombok.Data;

/**
 * @description: http请求返回的最外层对象
 * @Author: JachinDo
 * @Date: 2019/07/17 22:32
 */

@Data
public class ResultVO<T> {

    // 错误码
    private Integer code;
    // 提示信息
    private String msg;
    // 返回的具体内容
    private T data;
}
