package com.jachin.sell.enums;

import lombok.Getter;

/**
 *
 * @Author: JachinDo
 * @Date: 2019/07/16 17:15
 */
@Getter
public enum ProductStatusEnum {

    UP(0,"在架"),
    DOWN(1,"下架");

    private Integer state;
    private String message;

    ProductStatusEnum(Integer state, String message) {
        this.state = state;
        this.message = message;
    }

    /**
     * 根据枚举值获取信息
     * @param index 枚举值
     * @return 枚举信息
     */
    public static ProductStatusEnum stateOf(int index) {
        for (ProductStatusEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}
