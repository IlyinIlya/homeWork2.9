import java.util.Objects;

public class Employee {
    private final String employeeFirstName;
    private final String employeeLastName;
    private final String employeeMiddleName;
    private int department;
    private float employeeSalary;
    private final int id;
    private static int idCounter = 0;

    public Employee(int department, String employeeLastName, String employeeFirstName,
                    String employeeMiddleName, float employeeSalary) {
        this.department = department;
        this.employeeLastName = employeeLastName;
        this.employeeFirstName = employeeFirstName;
        this.employeeMiddleName = employeeMiddleName;
        this.employeeSalary = employeeSalary;
        id = ++idCounter;
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

    public String getFullName() {
        return employeeLastName + " " + employeeFirstName + " " + employeeMiddleName;
    }

    public int getDepartmentId() {
        return this.department;
    }

    public float getEmployeeSalary() {
        return this.employeeSalary;
    }

    public int getId() {
        return this.id;
    }

    // Сеттеры
    public void setDepartment(int department) {
        this.department = department;
    }

    public void setEmployeeSalary(float employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    //String
    public String toString() {
        return "ID: " + id + " | Отдел: " + department + " | ФИО: "
                + getFullName() + " | Зарплата: " + employeeSalary;
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
