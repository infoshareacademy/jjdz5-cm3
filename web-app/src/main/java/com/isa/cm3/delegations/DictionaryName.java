package com.isa.cm3.delegations;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

@RequestScoped
public class DictionaryName {

    @Inject
    private DelegationRepository delegationRepository;

    private Set<String> names = new HashSet<>();

    public Set<String> getName() {
        return names;
    }

    public void addOptionName() {
        add("");
        delegationRepository.getList().stream().map(delegation -> delegation.getEmployee().getEmployeeName()).forEach(this::add);
    }

    private void add(String nameList) {
        this.names.add(nameList);
    }
}
