package com.example.demo.controller;

import com.example.demo.pojo.Emp;
import com.example.demo.pojo.Result;
import com.example.demo.pojo.PageBean;
import com.example.demo.service.EmpService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理Controller
 */
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    /**
     * 条件分页查询员工列表
     *
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/emps")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }

    /**
     * 批量删除员工信息
     *
     * @param ids
     * @return
     */
    @DeleteMapping("/emps/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        empService.delete(ids);
        return Result.success();
    }

    /**
     * 添加员工信息
     *
     * @param emp
     * @return
     */
    @PostMapping("/emps")
    public Result add(@RequestBody Emp emp) {
        empService.addEmp(emp);
        return Result.success();
    }

    /**
     * 根据id查询员工信息
     *
     * @param id
     * @return
     */
    @GetMapping("/emps/{id}")
    public Result getById(@PathVariable Integer id) {
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    /**
     * 根据id更新员工信息
     * @param emp
     * @return
     */
    @PutMapping("/emps")
    public Result update(@RequestBody Emp emp) {
        empService.update(emp);
        return Result.success();
    }
}
