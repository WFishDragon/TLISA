package com.example.demo.mapper;

import com.example.demo.pojo.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {

    /**
     * 条件分页查询用xml文件配置
     *
     * @param name
     * @param gender
     * @param begin
     * @param end
     * @return
     */
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

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
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "value (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void addEmp(Emp emp);

    /**
     * 根据id查询员工信息
     *
     * @param id
     * @return
     */
    @Select("select * from emp where id = #{id}")
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
    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp login(Emp emp);
}
