package com.twip.mybatis.dao;

import com.twip.mybatis.entity.Employee;
import org.apache.ibatis.annotations.Select;

public interface EmployeeAnnotation {
    @Select("select id,last_name lastName,gender,email from tb1_employee where id = #{id}")
    public Employee getEmpById(Integer id);
}
