package com.tzeho.plaza.common.util;

import jakarta.annotation.Resource;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Map;

/* @description RedisTemplate 封装 自动序列化版
 * @author tzeho */
@Component
@SuppressWarnings(value = {"unchecked", "rawtypes"})
public class RedisV2Utils {

    @Resource
    private RedisTemplate redisTemplate;

    public void setValue(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public void setHash(String key, String hashKey, Object value) {
        redisTemplate.opsForHash().put(key, hashKey, value);
    }

    public <T> T getValue(String key) {
        ValueOperations<String, T> value = redisTemplate.opsForValue();
        return value.get(key);
    }

    public <T> Map<String, T> getMap(String key) {
        HashOperations<String, String, T> hash = redisTemplate.opsForHash();
        return hash.entries(key);
    }

    public <T> T getMapValue(String key, String hashKey) {
        Map<String, T> map = this.getMap(key);
        return map.get(hashKey);
    }

}
