package com.example.demo.controller;

import com.example.demo.mapper.EmpMapper;
import com.example.demo.pojo.Emp;
import com.example.demo.pojo.Result;
import com.example.demo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        Emp e = empService.login(emp);
        return e != null?Result.success():Result.error("用户名或密码错误");
    }
}
