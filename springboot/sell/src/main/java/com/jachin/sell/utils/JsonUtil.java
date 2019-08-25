package com.jachin.sell.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/08/12 11:04
 */

public class JsonUtil {

    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
