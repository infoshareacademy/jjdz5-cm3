package com.isa.cm3.delegations;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

@RequestScoped
public class DictionarySurname {

    @Inject
    private DelegationRepository delegationRepository;

    private Set<String> surnames = new HashSet<>();

    public Set<String> dictionarySurnames() {
        return surnames;
    }

    public void addDictionarySurnames() {
        add("");
        delegationRepository.getList().stream().map(i -> i.getEmployee().getEmployeeSurname()).forEach(this::add);
    }

    private void add(String surNamesList) {
        this.surnames.add(surNamesList);
    }
}
