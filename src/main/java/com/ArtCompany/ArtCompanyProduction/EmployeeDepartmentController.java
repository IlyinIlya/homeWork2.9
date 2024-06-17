package com.ArtCompany.ArtCompanyProduction;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/departments")
public class EmployeeDepartmentController {
    private final DepartmentService departmentService;

    public EmployeeDepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping(path = "/add")
    public Employee addEmployee(@RequestParam("departmentId") Integer departmentId,
                                @RequestParam("LastName") String employeeLastName,
                                @RequestParam("firstName") String employeeFirstName,
                                @RequestParam("middleName") String employeeMiddleName,
                                @RequestParam("salary") Float employeeSalary) {
        return departmentService.addNewEmployee(new Employee(departmentId, employeeLastName,
                employeeFirstName, employeeMiddleName, employeeSalary));
    }

    @RequestMapping(path = "/max-salary")
    public Employee maxSalaryDepartment(@RequestParam("departmentId") Integer departmentId) {
        return departmentService.findMaxSalary(departmentId);
    }

    @RequestMapping(path = "/min-salary")
    public Employee minSalaryDepartment(@RequestParam("departmentId") Integer departmentId) {
        return departmentService.findMinSalary(departmentId);
    }

    @RequestMapping(path = "/all", params = "departmentId")
    public List<Employee> printEmployeeDepartment(@RequestParam(value = "departmentId", required = false) Integer departmentId) {
        return departmentService.printEmployee(departmentId);
    }

    @RequestMapping(path = "/all")
    public Map<Integer, List<Employee>> printSortEmployeeDepartment() {
        return departmentService.printAllEmployee();
    }

}