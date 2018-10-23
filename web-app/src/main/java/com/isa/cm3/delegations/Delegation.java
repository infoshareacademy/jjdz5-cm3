package com.isa.cm3.delegations;

import javax.enterprise.context.SessionScoped;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


@SessionScoped
@Entity
@Table(name = "delegations")
public class Delegation implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "creation_date", nullable = false)
    private LocalDate creationDate;
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;
    @Column(name = "purpose", nullable = false)
    private String purpose;
    @Column(name = "delegation_status", nullable = false)
    private DelegationStatus delegationStatus;
    @Column(name = "start_point", nullable = false)
    private String startPoint;
    @Column(name = "discard_reason", nullable = false)
    private String discardReason;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee = new Employee();

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Destination destination = new Destination();


    public Delegation(int id,
                      LocalDate creationDate,
                      Employee employee,
                      LocalDate startDate,
                      LocalDate endDate,
                      Destination destination,
                      String purpose,
                      DelegationStatus delegationStatus,
                      String startPoint,
                      String discardReason) {
        this.id = id;
        this.creationDate = creationDate;
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.destination = destination;
        this.purpose = purpose;
        this.delegationStatus = delegationStatus;
        this.startPoint = startPoint;
        this.discardReason = discardReason;


    }

    public Delegation() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public DelegationStatus getDelegationStatus() {
        return delegationStatus;
    }

    public void setDelegationStatus(DelegationStatus delegationStatus) {
        this.delegationStatus = delegationStatus;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getDiscardReason() {
        return discardReason;
    }

    public void setDiscardReason(String discardReason) {
        this.discardReason = discardReason;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delegation that = (Delegation) o;
        return id == that.id &&
                Objects.equals(creationDate, that.creationDate) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(purpose, that.purpose) &&
                delegationStatus == that.delegationStatus &&
                Objects.equals(startPoint, that.startPoint) &&
                Objects.equals(discardReason, that.discardReason) &&
                Objects.equals(employee, that.employee) &&
                Objects.equals(destination, that.destination);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, creationDate, startDate, endDate, purpose, delegationStatus, startPoint, discardReason, employee, destination);
    }

    @Override
    public String toString() {
        return id + "," + creationDate + "," + employee + "," + startDate + "," + endDate + "," + destination + "," +
                purpose + "," + delegationStatus + "," + startPoint + "," + discardReason;
    }


}
