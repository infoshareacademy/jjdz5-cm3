package com.isa.cm3.delegations;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

@RequestScoped
public class DictionaryDestinationCountryAddition {

    @Inject
    private DelegationRepository delegationRepository;

    private Set<String> dictionaryDestinationCountries = new HashSet<>();

    public Set<String> getDictionaryDestinationCountries() {
        return dictionaryDestinationCountries;
    }

    public void addDictionaryDestinationCountries() {
        add("");
        delegationRepository.getList().stream().map(i -> i.getDestination().getDestinationCountry()).forEach(this::add);
    }

    private void add(String destinationCountry) {
        this.dictionaryDestinationCountries.add(destinationCountry);
    }
}
