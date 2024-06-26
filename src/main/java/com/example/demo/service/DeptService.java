package com.example.demo.service;

import com.example.demo.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 */
public interface DeptService {
    /**
     * 查询所有部门
     * @return
     */
    List<Dept> list();

    /**
     * 删除部门
     * @param id
     */
    void delete(Integer id);

    /**
     * 添加部门
     * @param dept
     */
    void add(Dept dept);

    /**
     * 根据id查询部门
     * @param id
     * @return
     */
    Dept findById(Integer id);

    /**
     * 修改部门信息
     *
     * @param dept
     */
    void update(Dept dept);
}
