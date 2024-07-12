package com.example.demo.service;

import com.example.demo.pojo.Emp;
import com.example.demo.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
public interface EmpService {
    /**
     * 分页查询
     *
     * @param page
     * @param pageSize
     * @return
     */
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 批量删除员工信息
     *
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 添加员工信息
     *
     * @param emp
     */
    void addEmp(Emp emp);

    /**
     * 根据id查询员工信息
     *
     * @param id
     * @return
     */
    Emp getById(Integer id);

    /**
     * 根据id更新员工信息
     *
     * @param emp
     */
    void update(Emp emp);

    /**
     * 登录校验
     * @return
     */
    Emp login(Emp emp);
}
