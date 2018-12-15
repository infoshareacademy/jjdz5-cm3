package com.isa.cm3.delegations;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Stateless
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_name", length = 30)
    @NotNull
    private String employeeName;

    @Column(name = "employee_surname", length = 30)
    @NotNull
    private String employeeSurname;

    @Column(name = "email", length = 30, unique = true)
    @NotNull
    private String email;

    @Column(name = "manager")
    @NotNull
    boolean manager;

    @Column(name = "administrator")
    @NotNull
    boolean admininistrator;

    @Column(name = "managerId")
    long managerId;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private Set<Delegation> delegations;

    public Employee() {
    }

    public Employee(String employeeName, String employeeSurname) {
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
    }

    public Employee(String employeeName, String employeeSurname, String email, boolean manager, boolean admininistrator, long managerId) {
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
        this.email = email;
        this.manager = manager;
        this.admininistrator = admininistrator;
        this.managerId = managerId;
    }
    public Employee(String employeeName, String employeeSurname, String email, boolean manager, boolean admininistrator) {
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
        this.email = email;
        this.manager = manager;
        this.admininistrator = admininistrator;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }

    public boolean isAdmininistrator() {
        return admininistrator;
    }

    public void setAdmininistrator(boolean admininistrator) {
        this.admininistrator = admininistrator;
    }

    public long getManagerId() {
        return managerId;
    }

    public void setManagerId(long managerId) {
        this.managerId = managerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return manager == employee.manager &&
                admininistrator == employee.admininistrator &&
                managerId == employee.managerId &&
                Objects.equals(id, employee.id) &&
                Objects.equals(employeeName, employee.employeeName) &&
                Objects.equals(employeeSurname, employee.employeeSurname) &&
                Objects.equals(email, employee.email) &&
                Objects.equals(delegations, employee.delegations);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, employeeName, employeeSurname, email, manager, admininistrator, managerId, delegations);
    }

    @Override
    public String toString() {

        return id + ","
                + employeeName + ","
                + employeeSurname;
    }
}