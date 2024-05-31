package com.ArtCompany.ArtCompanyProduction;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Employee {
    @JsonProperty("Имя")
    private final String employeeFirstName;
    @JsonProperty("Фамилия")
    private final String employeeLastName;
    @JsonProperty("Отчество")
    private final String employeeMiddleName;
    @JsonProperty("Департамент ID")
    private int department;
    @JsonProperty("Зарплата")
    private float employeeSalary;

    public Employee(int department, String employeeLastName, String employeeFirstName,
                    String employeeMiddleName, float employeeSalary) {
        this.department = department;
        this.employeeLastName = employeeLastName;
        this.employeeFirstName = employeeFirstName;
        this.employeeMiddleName = employeeMiddleName;
        this.employeeSalary = employeeSalary;
    }

    // Геттеры
    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public String getEmployeeFirstName() {
        return this.employeeFirstName;
    }

    public String getEmployeeMiddleName() {
        return this.employeeMiddleName;
    }

    @JsonProperty("ФИО")
    public String getFullName() {
        return employeeLastName + " " + employeeFirstName + " " + employeeMiddleName;
    }

    public int getDepartmentId() {
        return this.department;
    }

    public float getEmployeeSalary() {
        return this.employeeSalary;
    }

    // Equals и hascode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee emploee = (Employee) o;
        return employeeSalary == emploee.employeeSalary && Objects.equals(employeeFirstName,
                emploee.employeeFirstName) && Objects.equals(employeeLastName, emploee.employeeLastName)
                && Objects.equals(employeeMiddleName, emploee.employeeMiddleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeFirstName, employeeLastName, employeeMiddleName, employeeSalary);
    }
}
