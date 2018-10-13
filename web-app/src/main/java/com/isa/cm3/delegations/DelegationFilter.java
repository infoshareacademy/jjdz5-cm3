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
    private DelegationFilterCreationDateRemoval delegationFilterCreationDateRemoval;

    @Inject
    private DelegationFilterNameRemoval delegationFilterNameRemoval;

    @Inject
    private DelegationFilterSurnameRemoval delegationFilterRemoveSurname;

    @Inject
    private DelegationFilterStatusRemoval delegationFilterStatusRemoval;

    @Inject
    private DelegationFilterDestinationCountryRemoval delegationFilterDestinationCountryRemoval;

    public List<Delegation> getFilteredList(String choiceCreationDate, String choiceName, String choiceSurname, String choiceCountry, DelegationStatus choiceStatus) {

        if(!choiceStatus.toString().isEmpty()) {
            delegationFilterStatusRemoval.remove(choiceStatus);
        }

        if(!choiceCreationDate.isEmpty()) {
            delegationFilterCreationDateRemoval.remove(choiceCreationDate);
        }

        if(!choiceName.isEmpty()) {
            delegationFilterNameRemoval.remove(choiceName);
        }

        if(!choiceSurname.isEmpty()) {
            delegationFilterRemoveSurname.remove(choiceSurname);
        }

        if(!choiceCountry.isEmpty()) {
            delegationFilterDestinationCountryRemoval.remove(choiceCountry);
        }

        return delegationRepository.getList().stream()
                .sorted(Comparator.comparingInt(Delegation::getFileLineNumber))
                .collect(Collectors.toList());

    }

}
