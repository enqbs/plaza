package com.tzeho.plaza.common.util;

import org.springframework.data.redis.core.StringRedisTemplate;

/* @description RedisTemplate 封装
 * @author tzeho */
public class RedisUtils {

    private static final StringRedisTemplate STRING_REDIS_TEMPLATE = SpringContextUtils.getBean("stringRedisTemplate", StringRedisTemplate.class);

    public static void setValue(String key, String value) { STRING_REDIS_TEMPLATE.opsForValue().set(key, value); }

    public static String getValue(String key) { return STRING_REDIS_TEMPLATE.opsForValue().get(key); }

}
