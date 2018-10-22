package com.isa.cm3.delegations;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RequestScoped
public class DictionaryDestinationCountryAddition {

    @Inject
    private DelegationRepository delegationRepository;

    private List<String> dictionaryDestinationCountries = new ArrayList<>();

    public List<String> getDictionaryDestinationCountries() {
        return dictionaryDestinationCountries;
    }

    public void addDictionaryDestinationCountries() {
        add("");
        addAll();
        sort();
    }

    private void add(String destinationCountry) {
        this.dictionaryDestinationCountries.add(destinationCountry);
    }

    private void addAll() {
        delegationRepository.getList().stream()
                .map(i -> i.getDestination().getDestinationCountry())
                .forEach(this::add);
    }

    private void sort() {

        dictionaryDestinationCountries = dictionaryDestinationCountries.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());

    }
}
