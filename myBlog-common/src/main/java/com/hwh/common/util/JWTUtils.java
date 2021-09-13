package com.hwh.common.util;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HwH
 * @date 2021/9/13 20:46
 * @description jwt工具类
 */
public class JWTUtils {
    private static final String jwtToken = "123456myblog!@#$$";

    /**
     * 创建 token
     * @param userId 用户id
     * @return token
     * */
    public static String createToken(Long userId){
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId",userId);
        JwtBuilder jwtBuilder = Jwts.builder()
                //签发算法
                .signWith(SignatureAlgorithm.HS512, jwtToken)
                // body数据，需要唯一
                .setClaims(claims)
                //设置签发时间
                .setIssuedAt(new Date())
                //一天的有效期
                .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 60 * 1000));
        return jwtBuilder.compact();
    }

    /**
     * 检查token
     * */
    public static Map<String, Object> checkToken(String token){
        try{
            Jwt parse = Jwts.parser().setSigningKey(jwtToken).parse(token);
            return (Map<String, Object>) parse.getBody();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
