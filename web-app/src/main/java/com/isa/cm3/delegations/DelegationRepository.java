package com.isa.cm3.delegations;

import javax.enterprise.context.RequestScoped;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequestScoped
public class DelegationRepository {

    private List<Delegation> list = new ArrayList<>();

    private Set<String> nameList = new HashSet<>();
    private Set<String> surnameList = new HashSet<>();
    private Set<String> destinationCountryList = new HashSet<>();

    public List<Delegation> getList() {
        return list;
    }

    public Set<String> getNameList(){
        return nameList;
    }

    public Set<String> getSurnameList() {
        return surnameList;
    }

    public Set<String> getDestinationCountryList() {
        return destinationCountryList;
    }

        public void setList(Delegation delegation) {
        this.list.add(delegation);
    }

    public void setNameList(String nameList){
        this.nameList.add(nameList);
    }

    public void setSurNameList(String surNamesList){
        this.surnameList.add(surNamesList);
    }

    public void setDestinationCountryList(String destinationCountryList){
        this.destinationCountryList.add(destinationCountryList);
    }
}

