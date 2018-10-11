package com.isa.cm3.delegations;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequestScoped
public class DelegationFilter {

    @Inject
    private DelegationsLoadFromFile delegationsLoadFromFile;

    @Inject
    private DelegationRepository delegationRepository;

    Settings formatter = new Settings();

    private Set<String> creationDateList = new HashSet<>();
    private Set<String> nameList = new HashSet<>();
    private Set<String> surnameList = new HashSet<>();
    private Set<String> destinationCountryList = new HashSet<>();

    public List<Delegation> getFilteredList(String choiceCreationDate, String choiceName, String choiceSurname, String choiceCountry) {

        delegationRepository.getList().stream()
                .filter(delegation -> delegation.getDelegationStatus().equals(DelegationStatus.TOACCEPT))
                .sorted(Comparator.comparingInt(Delegation::getFileLineNumber))
                .collect(Collectors.toList());

        setOptionDateCreation();
        setOptionName();
        setOptionSurname();
        setOptionDestinationCountry();

        if(!choiceCreationDate.isEmpty()) {
            getFilteredListByCreationDate(choiceCreationDate);
        }

        if(!choiceName.isEmpty()) {
            getFilteredListByName(choiceName);
        }

        if(!choiceSurname.isEmpty()) {
            getFilteredListBySurname(choiceSurname);
        }

        if(!choiceCountry.isEmpty()) {
            getFilteredListByDestinationCountry(choiceCountry);
        }
        return delegationRepository.getList().stream().collect(Collectors.toList());
    }

    private void getFilteredListByCreationDate(String choiceCreationDate) {

        if(!choiceCreationDate.isEmpty()) {
            delegationRepository.getList().removeIf(cd -> !cd.getCreationDate().format(formatter.getFormater()).equalsIgnoreCase(choiceCreationDate));
        }

    }

    private void getFilteredListByName(String choiceName) {

        if(!choiceName.isEmpty()) {
            delegationRepository.getList().removeIf(delegation -> !delegation.getEmployee().getEmployeeName().equalsIgnoreCase(choiceName));
        }
    }

    private void getFilteredListBySurname(String choiceSurname) {

        if(!choiceSurname.isEmpty()) {
            delegationRepository.getList().removeIf(delegation -> !delegation.getEmployee().getEmployeeSurname().equalsIgnoreCase(choiceSurname));
        }
    }

    private void getFilteredListByDestinationCountry(String choiceCountry) {

        if(!choiceCountry.isEmpty()) {
            delegationRepository.getList().removeIf(delegation -> !delegation.getDestination().getDestinationCountry().equals(choiceCountry));
        }
    }

    private void setOptionDateCreation() {
        setCreationDateList("");
        delegationRepository.getList().stream().map(i -> i.getCreationDate().format(formatter.getFormater())).forEach(this::setCreationDateList);
    }

    private void setOptionName() {
        setNameList("");
        delegationRepository.getList().stream().map(i -> i.getEmployee().getEmployeeName()).forEach(this::setNameList);
    }

    private void setOptionSurname() {
        setSurNameList("");
        delegationRepository.getList().stream().map(i -> i.getEmployee().getEmployeeSurname()).forEach(this::setSurNameList);
    }

    private void setOptionDestinationCountry() {
        setDestinationCountryList("");
        delegationRepository.getList().stream().map(i -> i.getDestination().getDestinationCountry()).forEach(this::setDestinationCountryList);
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

    private void setCreationDateList(String creationDateList) {
        this.creationDateList.add(creationDateList);
    }

    private void setNameList(String nameList) {
        this.nameList.add(nameList);
    }

    private void setSurNameList(String surNamesList) {
        this.surnameList.add(surNamesList);
    }

    private void setDestinationCountryList(String destinationCountryList) {
        this.destinationCountryList.add(destinationCountryList);
    }
}
