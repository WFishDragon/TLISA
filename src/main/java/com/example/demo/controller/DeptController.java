package com.example.demo.controller;

import com.example.demo.pojo.Dept;
import com.example.demo.pojo.Result;
import com.example.demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理Controller
 */
@RestController
public class DeptController {
    /**
     * 查询所有部门信息
     */
    @Autowired
    private DeptService deptService;

    @GetMapping("/depts")
    public Result list(){
        List<Dept> list =  deptService.list();
        return Result.success(list);
    }
    /**
     * 删除部门信息
     */
    @DeleteMapping("/depts/{id}")
    public Result delete(@PathVariable Integer id){
        deptService.delete(id);
        return Result.success();
    }

    /**
     * 添加部门信息
     * @param dept
     * @return
     */
    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept){
        deptService.add(dept);
        return Result.success();
    }
    /**
     * 根据id查询部门
     */
    @GetMapping("/depts/{id}")
    public Result get(@PathVariable Integer id){
        Dept dept = deptService.findById(id);
        return Result.success(dept);
    }

    /**
     * 修改部门信息
     * @param dept
     * @return
     */
    @PutMapping("/depts")
    public Result update(@RequestBody Dept dept){
        deptService.update(dept);
        return Result.success();
    }
}
