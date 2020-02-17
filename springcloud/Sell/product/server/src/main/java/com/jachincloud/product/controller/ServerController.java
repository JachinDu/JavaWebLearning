package com.jachincloud.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/09/12 17:05
 */
@RestController
public class ServerController {

    @GetMapping("/msg")
    public String msg() {
        return "this is product msg 2";
    }
}
