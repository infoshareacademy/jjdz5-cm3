package com.isa.cm3.delegations;

import javax.enterprise.context.RequestScoped;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@RequestScoped
public class DelegationRepository {

    private List<Delegation> list = new ArrayList<>();
    private List<Delegation> filteredDelegations = new ArrayList<>();

  //  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    Settings formater = new Settings();


    private Set<String> creationDateList = new HashSet<>();
    private Set<String> nameList = new HashSet<>();
    private Set<String> surnameList = new HashSet<>();
    private Set<String> destinationCountryList = new HashSet<>();

    public List<Delegation> getList() {
        return list;
    }

    public Set<String> getCreationDateList() {
        return creationDateList;
    }

    public Set<String> getNameList() {
        return nameList;
    }

    public Set<String> getSurnameList() {
        return surnameList;
    }

    public Set<String> getDestinationCountryList() {
        return destinationCountryList;
    }

    public void setCreationDateList(String creationDateList) {
        this.creationDateList.add(creationDateList);
    }

    public void setList(Delegation delegation) {
        this.list.add(delegation);
    }

    public void setNameList(String nameList) {
        this.nameList.add(nameList);
    }

    public void setSurNameList(String surNamesList) {
        this.surnameList.add(surNamesList);
    }

    public void setDestinationCountryList(String destinationCountryList) {
        this.destinationCountryList.add(destinationCountryList);
    }

    public List<Delegation> getFilteredList(String choiceCreationDate, String choiceName, String choiceSurname, String choiceCountry) {

        filteredDelegations = getList().stream()
                .filter(delegation -> delegation.getDelegationStatus().equals(DelegationStatus.TOACCEPT))
                .sorted(Comparator.comparingInt(Delegation::getFileLineNumber))
                .collect(Collectors.toList());

        setOptionDateCreation();
        setOptionName();
        setOptionSurname();
        setOptionDestinationCountry();

        if(!choiceCreationDate.isEmpty()) {
            filteredDelegations = getFilteredListByCreationDate(choiceCreationDate);
        }

        if(!choiceName.isEmpty()) {
            filteredDelegations = getFilteredListByName(choiceName);
        }

        if(!choiceSurname.isEmpty()) {
            filteredDelegations = getFilteredListBySurname(choiceSurname);
        }

        if(!choiceCountry.isEmpty()) {
            filteredDelegations = getFilteredListByDestinationCountry(choiceCountry);
        }

        return filteredDelegations;
    }

    public List<Delegation> getFilteredListByCreationDate(String choiceCreationDate) {

        if(!choiceCreationDate.isEmpty()) {
            filteredDelegations.removeIf(cd -> !cd.getCreationDate().format(formater.getFormater()).equalsIgnoreCase(choiceCreationDate));
        }
        return filteredDelegations;
    }

    public List<Delegation> getFilteredListByName(String choiceName) {

        if(!choiceName.isEmpty()) {
            filteredDelegations.removeIf(n -> !n.getEmployee().getEmployeeName().equalsIgnoreCase(choiceName));
        }
        return filteredDelegations;
    }

    public List<Delegation> getFilteredListBySurname(String choiceSurname) {

        if(!choiceSurname.isEmpty()) {
            filteredDelegations.removeIf(sn -> !sn.getEmployee().getEmployeeSurname().equalsIgnoreCase(choiceSurname));
        }
        return filteredDelegations;
    }

    public List<Delegation> getFilteredListByDestinationCountry(String choiceCountry) {

        if(!choiceCountry.isEmpty()) {
            filteredDelegations.removeIf(dc -> !dc.getDestination().getDestinationCountry().equals(choiceCountry));
        }
        return filteredDelegations;
    }

    public void setOptionDateCreation() {
        setCreationDateList("");
        filteredDelegations.stream().map(i -> i.getCreationDate().format(formater.getFormater())).forEach(this::setCreationDateList);
    }

    public void setOptionName() {
        setNameList("");
        filteredDelegations.stream().map(i -> i.getEmployee().getEmployeeName()).forEach(this::setNameList);
    }

    public void setOptionSurname() {
        setSurNameList("");
        filteredDelegations.stream().map(i -> i.getEmployee().getEmployeeSurname()).forEach(this::setSurNameList);
    }

    public void setOptionDestinationCountry() {
        setDestinationCountryList("");
        filteredDelegations.stream().map(i -> i.getDestination().getDestinationCountry()).forEach(this::setDestinationCountryList);
    }
}