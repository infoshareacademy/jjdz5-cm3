package com.isa.cm3.delegations;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

@RequestScoped
public class DictionaryCreationDate {

    @Inject
    private DelegationRepository delegationRepository;

    private Set<String> creationDates = new HashSet<>();

    Settings formatter = new Settings();

    public Set<String> getCreationDate() {
        return creationDates;
    }

    public void addOptionDateCreation() {
        add("");
        delegationRepository.getList().stream().map(i -> i.getCreationDate().format(formatter.getFormater())).forEach(this::add);
    }

    private void add(String creationDateList) {
        this.creationDates.add(creationDateList);
    }
}
