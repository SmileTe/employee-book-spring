package com.skypro.employee1.controller;

import com.skypro.employee1.model.Employee;
import com.skypro.employee1.record.EmployeeRequest;
import com.skypro.employee1.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public Collection<Employee> getAllEmployees(){
    return this.employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody EmployeeRequest employeeRequest){
        return this.employeeService.addEmployee(employeeRequest);
    }
    @GetMapping("employees/salary/sum")
    public int getSalarySum(){
        return this.employeeService.getSalarySum();
    }
    @GetMapping("employees/salary/min")
    public Employee getEmployeeWithMinSalary(){
        return this.employeeService.getEmployeeWithMinSalary();
    }
    @GetMapping("employees/salary/max")
    public Employee getEmployeeWithMaxSalary(){
        return this.employeeService.getEmployeeWithMaxSalary();
    }

    @GetMapping("employees/high-salary")
    public Collection<Employee> getEmployeesAboveAverageSalaries(){
        return this.employeeService.getEmployeesAboveAverageSalaries();
    }
}
