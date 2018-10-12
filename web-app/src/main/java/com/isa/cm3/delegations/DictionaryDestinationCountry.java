package com.isa.cm3.delegations;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

@RequestScoped
public class DictionaryDestinationCountry {

    @Inject
    private DelegationRepository delegationRepository;

    private Set<String> destinationCountries = new HashSet<>();

    public Set<String> dictionaryDestinationCountries() {
        return destinationCountries;
    }

    public void addDictionaryDestinationCountries() {
        add("");
        delegationRepository.getList().stream().map(i -> i.getDestination().getDestinationCountry()).forEach(this::add);
    }

    private void add(String destinationCountryList) {
        this.destinationCountries.add(destinationCountryList);
    }
}
