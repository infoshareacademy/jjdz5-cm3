package com.isa.cm3.delegations;

import javax.enterprise.context.RequestScoped;
import java.util.Objects;

@RequestScoped
public class Destination {

    private String destinationCountry;
    private String destinationCity;
    private String destinationCompany;
    private String destinationCompanyAddress;

    public Destination(String destinationCountry,
                       String destinationCity,
                       String destinationCompany,
                       String destinationCompanyAddress) {
        this.destinationCountry = destinationCountry;
        this.destinationCity = destinationCity;
        this.destinationCompany = destinationCompany;
        this.destinationCompanyAddress = destinationCompanyAddress;
    }

    public Destination() {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destination that = (Destination) o;
        return Objects.equals(destinationCountry, that.destinationCountry) &&
                Objects.equals(destinationCity, that.destinationCity) &&
                Objects.equals(destinationCompany, that.destinationCompany) &&
                Objects.equals(destinationCompanyAddress, that.destinationCompanyAddress);
    }

    @Override
    public int hashCode() {

        return Objects.hash(destinationCountry, destinationCity, destinationCompany, destinationCompanyAddress);
    }

    @Override
    public String toString() {
        return destinationCountry + "," + destinationCity + "," + destinationCompany + "," + destinationCompanyAddress;

    }
}
