package com.example.demo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class DemoApplicationTests {
    /**
     * 生成Jwt令牌
     */
    @Test
    public void testGenJwt() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("name","test");
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "WFishDragon")   //设置签名算法
                .setClaims(claims)      //设置自定义数据(载荷)
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))    //有效期1个小时
                .compact();             //设置令牌
        System.out.println(jwt);
    }

    /**
     * 解析Jwt令牌
     */
    @Test
    public void testParseJwt(){
        Claims claims = Jwts.parser()
                .setSigningKey("WFishDragon")   //设置签名的方式
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidGVzdCIsImlkIjoxLCJleHAiOjE3MjA5ODE2ODN9.7jU7THFXbdQdmNBs4KEYiR4RC_p8QZodrLv1v65Rloc")
                .getBody();
        System.out.println(claims);
    }
}
