package com.isa.cm3.delegations;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

@RequestScoped
public class DictionarySurnameAddition {

    @Inject
    private DelegationRepository delegationRepository;

    private Set<String> dictionarySurnames = new HashSet<>();

    public Set<String> getDictionarySurnames() {
        return dictionarySurnames;
    }

    public void addDictionarySurnames() {
        add("");
        delegationRepository.getList().stream().map(i -> i.getEmployee().getEmployeeSurname()).forEach(this::add);
    }

    private void add(String surname) {
        this.dictionarySurnames.add(surname);
    }
}
