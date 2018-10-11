package com.isa.cm3.delegations;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

@RequestScoped
public class DictionaryCreationDate {

    @Inject
    private DelegationRepository delegationRepository;

    @Inject
    private Settings settings;

    private Set<String> creationDates = new HashSet<>();

    public Set<String> getCreationDate() {
        return creationDates;
    }

    public void addOptionDateCreation() {
        add("");
        delegationRepository.getList().stream().map(i -> i.getCreationDate().format(settings.getFormater())).forEach(this::add);
    }

    private void add(String creationDateList) {
        this.creationDates.add(creationDateList);
    }
}
