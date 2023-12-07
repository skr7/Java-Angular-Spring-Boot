package com.tskr.emp.repository;

import com.tskr.emp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    public Employee getEmployeeByEmpId(int empId);
}
