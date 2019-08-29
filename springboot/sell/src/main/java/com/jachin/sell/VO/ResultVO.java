package com.jachin.sell.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: http请求返回的最外层对象
 * @Author: JachinDo
 * @Date: 2019/07/17 22:32
 */

@Data
public class ResultVO<T> implements Serializable {



    // 利用插件保证序列化时唯一id
    private static final long serialVersionUID = -1712970983658219564L;

    // 错误码
    private Integer code;
    // 提示信息
    private String msg;
    // 返回的具体内容
    private T data;
}
