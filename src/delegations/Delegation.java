package delegations;

public class Delegation {

    private String creationDate ;
    private String startDate ;
    private String endDate ;
    private String purpose ;
    private String status ;
    private String startPoint ;


    /*Obiekty z klas zawierających pola i metody */
    private Employee employee = new Employee();
    private Destination destination = new Destination();

  //  private AddDelegation addDelegation = new AddDelegation();
  //  private AcceptDelegation acceptDelegation = new AcceptDelegation();
  //  private DiscardDelegation discardDelegation = new DiscardDelegation();
  //  private PreviewDelegation previewDelegation = new PreviewDelegation();


    public Delegation(String creationDate, String startDate, String endDate, String purpose, String status, String startPoint, Employee employee, Destination destination) {
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

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
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
        return "Delegation{" +
                "creationDate='" + creationDate + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", purpose='" + purpose + '\'' +
                ", status='" + status + '\'' +
                ", startPoint='" + startPoint + '\'' +
                ", employee=" + employee +
                ", destination=" + destination +
                '}' + '\n';
    }
}
