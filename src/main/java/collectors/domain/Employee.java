package collectors.domain;

import java.util.Objects;

public class Employee {

    private Integer id;
    private Double salary;
    private Long leaves;
    private String department;

    public Employee(Integer id, Double salary, Long leaves, String department) {
        this.id = id;
        this.salary = salary;
        this.leaves = leaves;
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Long getLeaves() {
        return leaves;
    }

    public void setLeaves(Long leaves) {
        this.leaves = leaves;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id.equals(employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
