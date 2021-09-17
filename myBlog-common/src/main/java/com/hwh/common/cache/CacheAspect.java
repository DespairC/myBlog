package com.hwh.common.cache;

import com.alibaba.fastjson.JSON;
import com.hwh.common.domain.enums.CodeEnum;
import com.hwh.common.util.RedisUtils;
import com.hwh.common.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @author HwH
 * @date 2021/9/17 9:10
 * @description 统一缓存处理
 */

@Aspect
@Component
@Slf4j
public class CacheAspect {

    @Autowired
    private RedisUtils redisUtils;

    @Pointcut("@annotation(com.hwh.common.cache.Cache)")
    public void pt(){}

    @Around("pt()")
    public Object around(ProceedingJoinPoint pjp){
        try{
            Signature signature = pjp.getSignature();
            //类名
            String className = pjp.getTarget().getClass().getSimpleName();
            //调用的方法名
            String methodName = signature.getName();

            Class[] parameterTypes = new Class[pjp.getArgs().length];
            Object[] args = pjp.getArgs();
            //参数
            String param = "";
            for (int i = 0; i < args.length; i++) {
                if(args[i] != null){
                    param += JSON.toJSONString(args[i]);
                    parameterTypes[i] = args[i].getClass();
                }
                else{
                    parameterTypes[i] = null;
                }
            }

            if(StringUtils.isNotEmpty(param)){
                //加密 以防止出现key过长以及字符转义获取不到的情况
                param = DigestUtils.md5Hex(param);
            }

            Method method = pjp.getSignature().getDeclaringType().getMethod(methodName, parameterTypes);
            //获取Cache注解
            Cache annotation = method.getAnnotation(Cache.class);
            //缓存过期时间
            long expire = annotation.expire();
            //缓存名字
            String name = annotation.name();
            //先从redis中获取
            String redisKey = name + "::" + className + "::" + methodName + "::" + param;
            String redisValue = (String) redisUtils.get(redisKey);
            if(StringUtils.isNotEmpty(redisValue)){
                log.info("缓存中获取了值,{},{}",className, methodName);
                return JSON.parseObject(redisValue, Result.class);
            }
            Object proceed = pjp.proceed();
            redisUtils.set(redisKey, JSON.toJSONString(proceed), expire, TimeUnit.SECONDS);
            log.info("存入缓存:{},{}",className, methodName);
            return proceed;

        }catch (Throwable throwable){
            throwable.printStackTrace();

        }
        return Result.error(CodeEnum.SYSTEM_ERROR);

    }

}
