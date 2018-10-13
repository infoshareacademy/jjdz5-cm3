package com.isa.cm3.delegations;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class DelegationFilter {

    @Inject
    private DelegationRepository delegationRepository;

    @Inject
    private DelegationFilterCreationDateRemoval filterCreationDateRemoval;

    @Inject
    private DelegationFilterNameRemoval delegationFilterDictionaryNameRemoval;

    @Inject
    private DelegationFilterSurnameRemoval removeSurname;

    @Inject
    private DelegationFilterStatusRemoval dictionaryStatusRemoval;

    @Inject
    private DelegationFilterDestinationCountryRemoval filterDestinationCountryRemoval;

    public List<Delegation> getFilteredList(String choiceCreationDate, String choiceName, String choiceSurname, String choiceCountry, DelegationStatus choiceStatus) {

        if(!choiceStatus.toString().isEmpty()) {
            dictionaryStatusRemoval.remove(choiceStatus);
        }

        if(!choiceCreationDate.isEmpty()) {
            filterCreationDateRemoval.remove(choiceCreationDate);
        }

        if(!choiceName.isEmpty()) {
            delegationFilterDictionaryNameRemoval.remove(choiceName);
        }

        if(!choiceSurname.isEmpty()) {
            removeSurname.remove(choiceSurname);
        }

        if(!choiceCountry.isEmpty()) {
            filterDestinationCountryRemoval.remove(choiceCountry);
        }

        return delegationRepository.getList().stream()
                .sorted(Comparator.comparingInt(Delegation::getFileLineNumber))
                .collect(Collectors.toList());

    }

}
