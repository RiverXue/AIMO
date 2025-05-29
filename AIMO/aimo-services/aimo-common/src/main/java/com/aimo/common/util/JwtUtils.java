package com.aimo.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtils {

    private static final long EXPIRE = 1000 * 60 * 60 * 24; // 过期时间，单位为毫秒，这里设置为1天
    private static final String SECRET = "AIMORIVERXhamberger1234567890123456"; // 密钥，用于加密和解密JWT
    private static final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

    public static String createToken(String userId, String username) {
        return Jwts.builder()
                .setSubject("AIMO-USERS") // 设置主题
                .claim("userId", userId) // 设置自定义声明，这里使用用户ID
                .claim("username", username) // 设置自定义声明，这里使用用户名
                .setIssuedAt(new Date()) // 设置签发时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE)) // 设置过期时间
                .signWith(key, SignatureAlgorithm.HS256) // 使用密钥进行签名, 这里使用HS256算法
                .compact(); // 生成JWT字符串
    }

    // 解析 Token
    public static Claims parseToken(String token) {
        return Jwts.parserBuilder()
               .setSigningKey(key) // 设置密钥
               .build()  // 构建解析器
               .parseClaimsJws(token) // 解析JWT字符串
               .getBody(); // 获取JWT的主体部分，即声明
    }

    // 验证 Token
    public static boolean isExpired(String token) {
        try {
            // 解析 Token 并验证过期时间
            Date exp = parseToken(token).getExpiration();
            return exp.before(new Date()); // 验证过期时间
        } catch (Exception e) {
            return true;
        }
    }
}

