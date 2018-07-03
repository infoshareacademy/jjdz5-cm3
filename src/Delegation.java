package src;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Delegation{
    private String creationDate ;
    private String employeeName ;
    private String employeeSurname ;
    private String startDate ;
    private String endDate ;
    private String destinationCountry ;
    private String destinationCity ;
    private String destinationCompany ;
    private String destinationCompanyAddress ;
    private String destinationSleepAddress ;
    private String purpose ;
    private String status ;
    private String startPoint ;
    private String vehicle ;
    private String numberOfDays ;
    private String idNumber ;

    private static final int MAX_FIELDS = 16;
    private static final String FIELDS_SEPARATOR = ",";

    List<Delegation> myDelegation = new ArrayList<>() ;

    public Delegation(
            String creationDate ,
            String employeeName ,
            String employeeSurname ,
            String startDate ,
            String endDate ,
            String destinationCountry ,
            String destinationCity ,
            String destinationCompany ,
            String destinationCompanyAddress ,
            String destinationSleepAddress ,
            String purpose ,
            String status ,
            String startPoint ,
            String vehicle ,
            String numberOfDays ,
            String idNumber
    ){
        this.creationDate = creationDate ;
        this.employeeName = employeeName  ;
        this.employeeSurname = employeeSurname ;
        this.startDate = startDate  ;
        this.endDate = endDate   ;
        this.destinationCountry = destinationCountry ;
        this.destinationCity = destinationCity  ;
        this.destinationCompany = destinationCompany  ;
        this.destinationCompanyAddress = destinationCompanyAddress  ;
        this.destinationSleepAddress = destinationSleepAddress   ;
        this.purpose = purpose  ;
        this.status = status  ;
        this.startPoint = startPoint  ;
        this.vehicle = vehicle  ;
        this.numberOfDays = numberOfDays   ;
        this.idNumber = idNumber;
    }

    public Delegation () {}

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
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

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getDestinationCompany() {
        return destinationCompany;
    }

    public void setDestinationCompany(String destinationCompany) {
        this.destinationCompany = destinationCompany;
    }

    public String getDestinationCompanyAddress() {
        return destinationCompanyAddress;
    }

    public void setDestinationCompanyAddress(String destinationCompanyAddress) {
        this.destinationCompanyAddress = destinationCompanyAddress;
    }

    public String getDestinationSleepAddress() {
        return destinationSleepAddress;
    }

    public void setDestinationSleepAddress(String destinationSleepAddress) {
        this.destinationSleepAddress = destinationSleepAddress;
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

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(String numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void addDelegation ( Delegation p ){
        myDelegation.add ( p );
    }

    public void acceptDelegation () {

    }

    public void discardDelegation () {

    }

    public void  previewDelegation () {

        System.out.println( "[01/16] Data rejestracji..........:" );
        System.out.println( "[02/16] imię pracownika...........:" );
        System.out.println( "[03/16] nazwisko pracownika.......:" );
        System.out.println( "[04/16] delegacja od (rrrrmmdd)...:" );
        System.out.println( "[05/16] delegacja do (rrrrmmdd....:" );
        System.out.println( "[06/16] kraj......................:" );
        System.out.println( "[07/16]   miasto..................:" );
        System.out.println( "[08/16] Firma.....................:" );
        System.out.println( "[09/16]   adres...................:" );
        System.out.println( "[10/16] Adres noclegu.............:" );
        System.out.println( "[11/16] cel, powód................:" );
        System.out.println( "[12/16] STATUS....................:" );
        System.out.println( "[13/16] od miejsca................:" );
        System.out.println( "[14/16] sposób podróży............:" );
        System.out.println( "[15/16] ilość dni.................:" );
        System.out.println( "[16/16] ID pracownika.............:" );

    }

    public void selectDelegation ( int nDeclaration ) {

    }

    public void showDelegation () {

    }


}

