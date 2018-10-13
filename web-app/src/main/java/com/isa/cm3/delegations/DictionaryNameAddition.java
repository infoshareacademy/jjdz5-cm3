package com.isa.cm3.delegations;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class DictionaryNameAddition {

    @Inject
    private DelegationRepository delegationRepository;

    private List<String> dictionaryNames = new ArrayList<>();

    public List<String> getDictionaryNames() {
        return dictionaryNames;
    }

    public void addDictionaryNames() {
        add("");
        addAll();
        sort();
    }

    private void add(String name) {
        this.dictionaryNames.add(name);
    }

    private void addAll() {
        delegationRepository.getList().stream()
                .map(delegation -> delegation.getEmployee().getEmployeeName())
                .forEach(this::add);
    }

    private void sort() {
        dictionaryNames = dictionaryNames.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}
