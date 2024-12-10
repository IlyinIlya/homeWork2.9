package com.ArtCompany.ArtCompanyProduction;

import Exceptions.WrongNamesException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DepartmentService {
    private List<Employee> employees = new ArrayList<>(List.of(
            new Employee(1, "Булгакова",
                    "София", "Леоновна", 32890.45f),
            new Employee(2, "Родина",
                    "Александра", "Артемьевна", 31575.25f),
            new Employee(3, "Зайцева",
                    "Елизавета", "Ивановна", 34099.09f),
            new Employee(5, "Демин",
                    "Матвей", "Андреевич", 27829.36f),
            new Employee(4, "Румянцев",
                    "Илья", "Никитич", 32547.41f),
            new Employee(2, "Лопатин",
                    "Тимофей", "Викторович", 30776.91f),
            new Employee(1, "Котова",
                    "Сафия", "Михайловна", 29791.22f),
            new Employee(5, "Федосеев",
                    "Алексей", "Львович", 35112.69f),
            new Employee(4, "Смирнов",
                    "Александр", "Александрович", 33001.15f),
            new Employee(3, "Кузьмина",
                    "Мария", "Максимовна", 33553.82f)
    ));

    public Employee addNewEmployee(Employee employee) {
        if (!checkNames(employee.getEmployeeLastName(),
                employee.getEmployeeFirstName(),
                employee.getEmployeeMiddleName()))
            throw new WrongNamesException();
        employees.add(employee);
        return employee;
    }

    public Employee findMaxSalary(int departmentId) {
        return employees.stream()
                .filter(emp -> emp.getDepartmentId() == departmentId)
                .max(Comparator.comparing(Employee::getEmployeeSalary))
                .orElseThrow(() -> new RuntimeException("Wrong department"));
    }

    public Employee findMinSalary(int departmentId) {
        return employees.stream()
                .filter(emp -> emp.getDepartmentId() == departmentId)
                .min(Comparator.comparing(Employee::getEmployeeSalary))
                .orElseThrow(() -> new RuntimeException("Wrong department"));
    }

    public List<Employee> printEmployee(int departmentId) {
        return employees.stream()
                .filter(emp -> emp.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> printAllEmployee() {

        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }

    public boolean checkNames(String lastName, String firstName, String middleName) {
        return StringUtils.isAlpha(lastName) &&
                StringUtils.isAlpha(firstName) &&
                StringUtils.isAlpha(middleName);
    }
}