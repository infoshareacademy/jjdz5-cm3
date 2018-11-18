package com.isa.cm3.delegations;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Entity
@Stateless
@Table(name = "destinations")
public class Destination {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "destination_country")
    @NotNull
    private String destinationCountry;

    @Column(name = "destination_city")
    @NotNull
    private String destinationCity;

    @Column(name = "destination_company")
    @NotNull
    private String destinationCompany;

    @Column(name = "destination_company_adress")
    @NotNull
    private String destinationCompanyAddress;

    @OneToMany(mappedBy = "destination", fetch = FetchType.EAGER)
    private Set<Delegation> delegations;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return id + ","
                + destinationCountry + ","
                + destinationCity + ","
                + destinationCompany + ","
                + destinationCompanyAddress;
    }
}