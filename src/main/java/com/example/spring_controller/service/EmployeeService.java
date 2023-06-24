package com.example.spring_controller.service;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class EmployeeService {
    private static final int MAX_SIZE = 100;
    private final List<Employee> employees = new ArrayList<>(MAX_SIZE);
    public Employee add(String firstName, String lastName){
        if (employees.size() > MAX_SIZE) {
            throw new EmployeeStoragesFullExeption();
        }
        var employee = new Employee(firstName, lastName, department, salary);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedExeption();
        }
        employees.add(employee);
        return employee;
    }
    public Employee delete(String firstName, String lastName){
        var employee = new Employee(firstName,lastName, department, salary);
        if (!employees.remove(employee)){
            throw new EmployeeNotFoundExeption();
        }
        return employee;
    }
    public Employee find(String firstName, String lastName){
        var employee = new Employee(firstName,lastName, department, salary);
        for (Employee emp : employees) {
            if (emp.equals(employee)){
                return emp;
            }
        }
        throw new EmployeeNotFoundExeption();
    }

    public Arrays getEmployess() {
    }
}
