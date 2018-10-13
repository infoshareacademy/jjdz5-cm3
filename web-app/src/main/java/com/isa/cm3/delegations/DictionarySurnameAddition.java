package com.isa.cm3.delegations;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class DictionarySurnameAddition {

    @Inject
    private DelegationRepository delegationRepository;

    private List<String> dictionarySurnames = new ArrayList<>();

    public List<String> getDictionarySurnames() {
        return dictionarySurnames;
    }

    public void addDictionarySurnames() {
        add("");
        addAll();
        sort();
    }

    private void add(String surname) {
        this.dictionarySurnames.add(surname);
    }

    private void addAll() {
        delegationRepository.getList().stream()
                .map(i -> i.getEmployee().getEmployeeSurname())
                .forEach(this::add);
    }

    private void sort() {
        dictionarySurnames = dictionarySurnames.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}
