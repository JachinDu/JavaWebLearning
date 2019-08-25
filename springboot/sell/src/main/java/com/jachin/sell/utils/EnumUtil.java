package com.jachin.sell.utils;

import com.jachin.sell.enums.CodeEnum;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/08/23 16:09
 */

public class EnumUtil {
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
