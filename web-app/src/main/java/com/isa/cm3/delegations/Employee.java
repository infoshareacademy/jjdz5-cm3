package com.isa.cm3.delegations;

import javax.enterprise.context.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@RequestScoped
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    private int id;
    @Column(name = "employee_name", nullable = false)
    private String employeeName;
    @Column(name = "employee_surname", nullable = false)
    private String employeeSurname;

    public Employee(String employeeName, String employeeSurname) {
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
    }

    public Employee() { }

    public Employee(String trim) { }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public void setEmployeeSurname(String employeeSurname) {
        this.employeeSurname = employeeSurname;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Objects.equals(employeeName, employee.employeeName) &&
                Objects.equals(employeeSurname, employee.employeeSurname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, employeeName, employeeSurname);
    }

    @Override
    public String toString() {
        return id + "," + employeeName + "," + employeeSurname;
    }
}
