package com.isa.cm3.delegations;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequestScoped
public class DictionaryCreationDateAddition {

    @Inject
    private DelegationRepository delegationRepository;

    @Inject
    private Settings settings;

    private List<String> dictionaryCreationDates = new ArrayList<>();

    public List<String> getDictionaryCreationDates() {
        return dictionaryCreationDates;
    }

    public void addDictionaryCreationDates() {
        add("");
        addAll();
        sort();
    }

    private void add(String creationDate) {
        this.dictionaryCreationDates.add(creationDate);
    }

    private void addAll() {
        delegationRepository.getList().stream()
                .map(i -> i.getCreationDate().format(settings.getFormater()))
                .forEach(this::add);
    }

    private void sort() {
        dictionaryCreationDates = dictionaryCreationDates.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}
