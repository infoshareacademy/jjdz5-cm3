package com.isa.cm3.delegations;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

@RequestScoped
public class DictionaryNameAddition {

    @Inject
    private DelegationRepository delegationRepository;

    private Set<String> dictionaryNames = new HashSet<>();

    public Set<String> getDictionaryNames() {
        return dictionaryNames;
    }

    public void addDictionaryNames() {
        add("");
        delegationRepository.getList().stream().map(delegation -> delegation.getEmployee().getEmployeeName()).forEach(this::add);
    }

    private void add(String name) {
        this.dictionaryNames.add(name);
    }
}
