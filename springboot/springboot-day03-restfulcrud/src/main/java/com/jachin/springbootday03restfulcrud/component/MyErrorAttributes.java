package com.jachin.springbootday03restfulcrud.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;


//给容器中加入我们自己定义的MyErrorAttributes
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    //返回值map就是页面和json能获取的所有字段
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {

        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("company", "Jachin");

        //获取自己的异常处理中携带的数据（0代表从request域获取）
        Map<String, Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", 0);
        map.put("ext", ext);
        return map;
    }
}
