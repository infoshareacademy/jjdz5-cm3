package com.isa.cm3.delegations;

import javax.enterprise.context.RequestScoped;
import javax.persistence.*;
import java.util.Objects;

@Entity
@RequestScoped
@Table(name = "destinations")
public class Destination {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "destination_country", nullable = false)
    private String destinationCountry;
    @Column(name = "destination_city", nullable = false)
    private String destinationCity;
    @Column(name = "destination_company", nullable = false)
    private String destinationCompany;
    @Column(name = "destination_company_adress", nullable = false)
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

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }

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
        return id == that.id &&
                Objects.equals(destinationCountry, that.destinationCountry) &&
                Objects.equals(destinationCity, that.destinationCity) &&
                Objects.equals(destinationCompany, that.destinationCompany) &&
                Objects.equals(destinationCompanyAddress, that.destinationCompanyAddress);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, destinationCountry, destinationCity, destinationCompany, destinationCompanyAddress);
    }

    @Override
    public String toString() {
        return id + "," + destinationCountry + "," + destinationCity + "," + destinationCompany + "," + destinationCompanyAddress;

    }
}
