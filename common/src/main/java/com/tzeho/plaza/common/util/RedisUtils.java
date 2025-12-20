package com.tzeho.plaza.common.util;

import jakarta.annotation.Resource;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

/* @description RedisTemplate 封装
 * @author tzeho */
@Component
public class RedisUtils {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public void setValue(String key, Object value) {
        stringRedisTemplate.opsForValue().set(key, JacksonUtils.toJson(value));
    }

    public void setHash(String key, String hashKey, Object value) {
        stringRedisTemplate.opsForHash().put(key, hashKey, JacksonUtils.toJson(value));
    }

    public String getString(String key) {
        return this.getValue(key, String.class);
    }

    public <T> T getValue(String key, Class<T> clazz) {
        return JacksonUtils.toBean(stringRedisTemplate.opsForValue().get(key), clazz);
    }

    public Map<String, String> getMap(String key) {
        HashOperations<String, String, String> hash = stringRedisTemplate.opsForHash();
        return hash.entries(key);
    }

    public <T> T getMapValue(String key, String hashKey, Class<T> clazz) {
        return JacksonUtils.toBean(this.getMap(key).get(hashKey), clazz);
    }

}
