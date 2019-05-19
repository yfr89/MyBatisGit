package com.mybatis.dao;
import com.mybatis.bean.Employee;
//接口
public interface EmployeeMapper {
    //根据ID来查询员工
    public Employee  getEmpById(Employee employee);
}
