package com.jachin.sell.utils.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 * @description: 返回前段时将Date类型数据转换为Long
 * @Author: JachinDo
 * @Date: 2019/07/24 16:43
 */

public class Date2LongSerializer extends JsonSerializer<Date> {
    @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        // 直接返回Date类型给前端，前端显示会在末尾多3个0
        gen.writeNumber(value.getTime() / 1000);
    }
}
