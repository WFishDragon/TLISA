package com.example.demo.service.impl;

import com.example.demo.mapper.DeptMapper;
import com.example.demo.pojo.Dept;
import com.example.demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    /**
     * 查询所有部门
     * @return
     */
    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    /**
     * 删除部门
     * @param id
     */
    @Override
    public void delete(Integer id) {
        deptMapper.delete(id);
    }

    /**
     * 添加部门
     * @param dept
     */
    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    /**
     * 根据id查询部门
     * @param id
     * @return
     */
    @Override
    public Dept findById(Integer id) {
        Dept dept = deptMapper.findById(id);
        return dept;
    }

    /**
     * 修改部门信息
     *
     * @param dept
     */
    @Override
    public void update(Dept dept) {
        System.out.println("啊啊啊");
        System.out.println(dept);
        deptMapper.update(dept);
    }
}
