package com.combat.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {
    private static String signKey = "ithth";
    private static Long expire = 43200000L;


    /**
     * 生成jwt令牌，并设置有效期为1小时
     * @param claims
     * @return
     */
    public static String get_jwt(Map<String,Object> claims){
        String jwt = Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256, signKey)//签名算法
                .setExpiration(new Date(System.currentTimeMillis() + expire))//有效时间为1小时
                .compact();//返回值
        return jwt;
    }

    /**
     * 解析jwt令牌
     * @param jwt
     * @return
     */
    public static Claims parse_jwt(String jwt){
        Claims claims = Jwts.parser()
                .setSigningKey(signKey)//检查签名
                .parseClaimsJws(jwt)//解析
                .getBody();//返回值
        return claims;
    }

}
