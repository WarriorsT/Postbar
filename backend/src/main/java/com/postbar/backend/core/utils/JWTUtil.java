package com.postbar.backend.core.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JWTUtil {
    /**
     * 过期时间--->7天
     */
    public static final long TIME = 7 * 24 * 60 * 60 * 1000;
    public static final String headerParam = "POSTBAR";

    public static final String secret = "E66559580A1ADF48CDD928516062F12E";
    public static SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    /**
     * 获取JWT
     * @param subject 此处设置为用户id
     * @return
     */
    public static String getJWTToken(String subject){
        Date exp = new Date(System.currentTimeMillis() + TIME);
        return Jwts.builder()
                .setHeaderParam("headerParam", headerParam)
                .setSubject(subject)
                //.signWith(key)
                .signWith(Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8)))
                .setExpiration(exp)
                .compact();
    }

    /**
     * 解析jwt返回用户id
     * @param JWTToken
     * @return
     */
    public static int parseToken(String JWTToken){
        Jws<Claims> jws;
        try {
            jws = Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8)))
                    .build()
                    .parseClaimsJws(JWTToken);
            return Integer.parseInt(jws.getBody().getSubject());
        }
        catch (JwtException ex) {
            throw new JwtException("JWT解析失败");
        }
    }
}
