package com.jachin.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @description: 商品（包含类目）
 * @Author: JachinDo
 * @Date: 2019/07/17 22:43
 */

@Data
public class ProductVO implements Serializable {


    private static final long serialVersionUID = -8546545908391231046L;
    @JsonProperty("name")
    private String categoryName;

    // 对象中要写详细名称以免混淆
    // 利用JsonProperty注解可以返回给指定名字供前端使用
    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;

}
