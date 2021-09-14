package com.hwh.common.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author HwH
 * @date 2021/9/13 21:53
 * @description redis工具类
 */
@Component
public class RedisUtils {

    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 给指定的key设置过期时间
     * @param key 键名
     * @param time 过期时间
     * @param timeUnit 时间单位
     * @return 是否成功
     * */
    public Boolean expire(String key, long time, TimeUnit timeUnit){
        redisTemplate.expire(key, time, timeUnit);
        return true;
    }

    /**
     * 给指定的key设置过期时间
     * @param key 键名
     * @return 是否成功
     * */
    public Long expire(String key){
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * 判断 key 是否存在
     * @param key 键名
     * @return boolean
     * */
    public Boolean hasKey(String key){
        return redisTemplate.hasKey(key);
    }

    /**
     * 删除指定键，允许多个删除
     * @param key 键名
     * @return 是否删除
     * */
    public Boolean del(String... key){
        if(key != null && key.length > 0){
            //只有单个情况
            if(key.length == 1){
                redisTemplate.delete(key[0]);
            }
            else {
                //多个情况
                List keys = CollectionUtils.arrayToList(key);
                redisTemplate.delete(keys);
            }
            return true;
        }
        return false;
    }

    /**
     * 获取指定Key的value
     * @param key 键名
     * @return 内容
     */
    public Object get(String key){
        if(key != null){
            return redisTemplate.opsForValue().get(key);
        }
        return null;
    }

    /**
     * 新增字符串键值对
     * @param key 键名
     * @param value 值
     * @return 是否成功
     */
    public Boolean set(String key,Object value){
        redisTemplate.opsForValue().set(key,value);
        return true;
    }

    /**
     * 新增字符串键值对并设置过期时间，如果过期时间小于0,则不设置
     * @param key 键名
     * @param value 值
     * @param time 过期时间（秒）
     * @param timeUnit 时间单位
     * @return 是否成功
     */
    public boolean set(String key, Object value, long time, TimeUnit timeUnit){
        if(time > 0){
            redisTemplate.opsForValue().set(key, value, time, timeUnit);
        }else{
            redisTemplate.opsForValue().set(key,value);
        }
        return true;
    }


}
