package com.lbcoding.springboot.thymeleafApp.service;

import com.lbcoding.springboot.thymeleafApp.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);

}
