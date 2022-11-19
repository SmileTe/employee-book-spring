package com.skypro.employee1.service;

import com.skypro.employee1.model.Employee;
import com.skypro.employee1.record.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private final Map<Integer, Employee> employees = new HashMap<>();

    public Collection<Employee> getAllEmployees() {
        return this.employees.values();
    }
    public Employee addEmployee(EmployeeRequest employeeRequest) {
        if (employeeRequest.getFirstName() == null || employeeRequest.getLastName() == null) {
            throw new IllegalArgumentException("Employee name should be set");
        }
        Employee employee = new Employee(employeeRequest.getFirstName() ,
                employeeRequest.getLastName(),
                employeeRequest.getDepartment(),
                employeeRequest.getSalary());
        this.employees.put(employee.getId(),employee);
        return employee;

    }

    public int getSalarySum() {
        return employees.values().stream()
                .mapToInt(Employee::getSalary)
                .sum();
    }

    public Employee getEmployeeWithMinSalary() {
        int minSalary = employees.values().stream()
                .mapToInt(Employee::getSalary)
                .min().getAsInt();

        return employees.values().stream().filter(v->v.getSalary()==minSalary).findFirst().get();
    }

    public Employee getEmployeeWithMaxSalary() {
        int maxSalary = employees.values().stream()
                .mapToInt(Employee::getSalary)
                .max().getAsInt();
        return employees.values().stream().filter(v->v.getSalary()==maxSalary).findFirst().get();

    }

    public Collection<Employee> getEmployeesAboveAverageSalaries() {
        Double averageSalary = employees.values().stream()
                .mapToInt(Employee::getSalary)
                .average().getAsDouble();
        int average =  averageSalary.intValue();
      return employees.values().stream().filter(v->v.getSalary()>average).toList();

    }
}
