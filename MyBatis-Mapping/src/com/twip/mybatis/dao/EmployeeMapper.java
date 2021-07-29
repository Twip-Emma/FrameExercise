package com.twip.mybatis.dao;

import com.twip.mybatis.entity.Employee;

public interface EmployeeMapper {
    public Employee getEmpById(Integer id);
}
