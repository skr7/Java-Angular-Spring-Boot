package com.tskr.emp.service;

import com.tskr.emp.entity.Employee;
import com.tskr.emp.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository repository;
    @Override
    public Employee getEmployeeByEmpId(int empId) {

        log.info("new Employee is added into DB with EmpID : {} ",empId);
        return repository.getEmployeeByEmpId(empId);
    }

    @Override
    public List<Employee> getAllEmployees() {
        log.debug("Getting the all employees ");

        return repository.findAll();
    }

    @Override
    public Employee addEmployee(Employee employee) {

        log.info("addEmployee()");
        log.debug("Saving the employee with {} ",employee.getEmpName()+" into DB ");
        return repository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee,int empId) {
        Employee updateEmployee=repository.getReferenceById(empId);
        if(employee !=null){
            updateEmployee.setEmpId(empId);
            updateEmployee.setEmpName(employee.getEmpName());
            updateEmployee.setDesignation(employee.getDesignation());
            updateEmployee.setGrade(employee.getGrade());
        }
        log.info("Employee Details updated successfully ");

        return repository.save(updateEmployee);
    }

    @Override
    public void deleteEmployee(int empId) {
        Employee employee=repository.getReferenceById(empId);
        log.debug("Employee with ID {} is deleted successfully ",empId);
        repository.delete(employee);

    }
}
