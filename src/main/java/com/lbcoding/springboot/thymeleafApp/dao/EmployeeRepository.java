package com.lbcoding.springboot.thymeleafApp.dao;

import com.lbcoding.springboot.thymeleafApp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // sort by lastName
    public List<Employee> findAllByOrderByLastNameAsc();
}
