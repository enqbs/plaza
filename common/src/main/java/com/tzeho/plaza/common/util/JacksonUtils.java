package com.tzeho.plaza.common.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

/* @description json 解析工具
 * @author tzeho */
public class JacksonUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static final TimeZone TIME_ZONE = TimeZone.getTimeZone("Asia/Shanghai");

    static {
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // JSON 字段有 Java 对象没有的字段不报错
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true); // 基本类型不允许为 NULL
        OBJECT_MAPPER.configure(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN, true); // BigDecimal 类型不使用科学计数法
        OBJECT_MAPPER.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL); // 空字段不返回 JSON
        OBJECT_MAPPER.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE); // JSON 统一格式为"蛇形"
        OBJECT_MAPPER.setDateFormat(DATE_FORMAT); // 日期时间输出格式
        OBJECT_MAPPER.setTimeZone(TIME_ZONE); // 时区
    }

    public static String toJson(Object src) {
        try {
            return OBJECT_MAPPER.writeValueAsString(src);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T toBean(String json, Class<T> clazz) {
        try {
            return OBJECT_MAPPER.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> List<T> toList(String json, TypeReference<List<T>> typeReference) {
        try {
            return OBJECT_MAPPER.readValue(json, typeReference);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
