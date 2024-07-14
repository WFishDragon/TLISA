package com.example.demo.controller;

import com.example.demo.pojo.Result;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {
//    设置Cookie
    @GetMapping("/c1")
    public Result cookie1(HttpServletResponse response) {
        response.addCookie(new Cookie("login_username","wyl"));
        return Result.success();
    }
//    获取cookie
    @GetMapping("/c2")
    public Result cookie2(HttpServletRequest request){
        Cookie cookies[] = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("login_username")){
                System.out.println("Cookie为："+cookie.getValue());
            }
        }
        return Result.success();
    }
//    往HttpSession中存值
    @GetMapping("/s1")
    public Result s1(HttpSession session){
        System.out.println(session.hashCode());
        session.setAttribute("loginUser","wyl");
        return Result.success();
    }
//    往HttpSession中获取值
    @GetMapping("/s2")
    public Result s2(HttpServletRequest request){
        HttpSession session = request.getSession();
        System.out.println(session.hashCode());
        Object loginUser = session.getAttribute("loginUser");
        return Result.success(loginUser);
    }
}
