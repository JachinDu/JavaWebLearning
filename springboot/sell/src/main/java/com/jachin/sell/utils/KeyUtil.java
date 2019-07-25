package com.jachin.sell.utils;

import java.util.Random;

/**
 * @description: 生成随机key
 * @Author: JachinDo
 * @Date: 2019/07/20 15:46
 */

public class KeyUtil {


    /**
     * 生成唯一主键
     * 格式：时间+随机数
     * @return
     * synchronized：在同一时刻最多只有一个线程可以进入
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        // 生成6位随机数
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis()+String.valueOf(number);
    }
}
