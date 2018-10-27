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

    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
    private Set<Delegation> delegations;

    public Employee() {
    }

    public Employee(String employeeName, String employeeSurname) {
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
    }


//    public Employee(String trim) {
//    }

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeName, employee.employeeName) &&
                Objects.equals(employeeSurname, employee.employeeSurname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(employeeName, employeeSurname);
    }

    @Override
    public String toString() {
        return id + "," + employeeName + "," + employeeSurname;
    }
}
