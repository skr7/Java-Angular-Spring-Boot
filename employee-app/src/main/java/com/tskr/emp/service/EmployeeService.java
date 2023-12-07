package com.tskr.emp.service;

import com.tskr.emp.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee getEmployeeByEmpId(int empId);
    public List<Employee> getAllEmployees();

    public Employee addEmployee(Employee employee);

    public Employee updateEmployee(Employee employee,int empId);

    public void deleteEmployee(int empId);
}
