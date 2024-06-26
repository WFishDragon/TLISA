package com.example.demo.mapper;

import com.example.demo.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 部门管理
 */
@Mapper
public interface DeptMapper {
    /**
     * 查询部门
     * @return
     */
    @Select("select * from dept")
    List<Dept> list();
    /**
     * 删除部门
     * @param id
     */
    @Delete("delete from dept where id = #{id}")
    void delete(Integer id);
    /**
     * 插入部门
     * @param dept
     */
    @Insert("insert into dept(name,create_time,update_time) values(#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    /**
     * 根据id查询部门
     * @param id
     * @return
     */
    @Select("select * from dept where id = #{id}")
    Dept findById(Integer id);

    /**
     * 修改部门信息
     */
    @Update("update dept set name = #{name} where id = #{id}")
    void update(Dept dept);
}
