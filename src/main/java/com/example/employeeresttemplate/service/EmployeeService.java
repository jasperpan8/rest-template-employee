package com.example.employeeresttemplate.service;

import com.example.employeeresttemplate.entity.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    List<Employee> findEmployeesLagerThan(int age);

    Map<Integer, List<Employee>> groupEmployeeByAge();

}
