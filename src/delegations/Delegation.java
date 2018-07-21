package delegations;

import java.time.LocalDate;

public class Delegation {

    private LocalDate creationDate ;
    private LocalDate startDate ;
    private LocalDate endDate ;
    private String purpose ;
    private String status ;
    private String startPoint ;


    /*Obiekty z klas zawierających pola i metody */
    private Employee employee = new Employee();
    private Destination destination = new Destination();


    private DelegationAccept delegationAccept = new DelegationAccept();
    private DelegationDiscard delegationDiscard = new DelegationDiscard ();
    private DelegationPreview delegationPreview = new DelegationPreview();

    public Delegation(LocalDate creationDate,
                      LocalDate startDate,
                      LocalDate endDate,
                      String purpose,
                      String status,
                      String startPoint,
                      Employee employee,
                      Destination destination) {
        this.creationDate = creationDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.purpose = purpose;
        this.status = status;
        this.startPoint = startPoint;
        this.employee = employee;
        this.destination = destination;
    }

    public Delegation() {
    }


    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    @Override
    public String toString() {
        return creationDate + "," + startDate + "," + endDate + "," + purpose + "," + status + "," +
                startPoint + "," + employee + "," + destination;

    }



}
