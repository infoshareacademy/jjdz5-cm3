package com.isa.cm3.delegations;

import java.time.LocalDate;


public class Delegation {
    private Integer fileLineNumber;
    private LocalDate creationDate;
    private LocalDate startDate;
    private LocalDate endDate;
    private String purpose;
    private DelegationStatus delegationStatus;
    private String startPoint;


    /*Obiekty z klas zawierających pola i metody */
    private Employee employee = new Employee();
    private Destination destination = new Destination();


    public Delegation(Integer fileLineNumber,
                      LocalDate creationDate,
                      Employee employee,
                      LocalDate startDate,
                      LocalDate endDate,
                      Destination destination,
                      String purpose,
                      DelegationStatus delegationStatus,
                      String startPoint) {
        this.fileLineNumber = fileLineNumber;
        this.creationDate = creationDate;
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.destination = destination;
        this.purpose = purpose;
        this.delegationStatus = delegationStatus;
        this.startPoint = startPoint;

    }

    public Delegation() {
    }

    public Integer getFileLineNumber() {
        return fileLineNumber;
    }

    public void setFileLineNumber(Integer fileLineNumber) {
        this.fileLineNumber = fileLineNumber;
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

    @Override
    public String toString() {
        return fileLineNumber + "," + creationDate + "," + employee + "," + startDate + "," + endDate + "," + destination + "," +
                purpose + "," + delegationStatus + "," + startPoint;
    }
}
