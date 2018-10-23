package com.isa.cm3.delegations;

import javax.enterprise.context.RequestScoped;
import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

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

    @OneToMany(mappedBy = "employee",fetch = FetchType.EAGER)
    private Set<Delegation> delegations;

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
