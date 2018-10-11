package com.isa.cm3.delegations;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class DelegationFilter {

    @Inject
    private DelegationsLoadFromFile delegationsLoadFromFile;

    @Inject
    private DelegationRepository delegationRepository;

    @Inject
    private RemoveCreationDate removeCreationDate;

    @Inject
    private RemoveName removeName;

    @Inject
    private RemoveSurname removeSurname;

    @Inject
    private RemoveDestinationCountry removeDestinationCountry;

    Settings formatter = new Settings();

    public List<Delegation> getFilteredList(String choiceCreationDate, String choiceName, String choiceSurname, String choiceCountry) {

        delegationRepository.getList().stream()
                .filter(delegation -> delegation.getDelegationStatus().equals(DelegationStatus.TOACCEPT))
                .sorted(Comparator.comparingInt(Delegation::getFileLineNumber))
                .collect(Collectors.toList());

        if(!choiceCreationDate.isEmpty()) {
            removeCreationDate.remove(choiceCreationDate);
        }

        if(!choiceName.isEmpty()) {
            removeName.remove(choiceName);
        }

        if(!choiceSurname.isEmpty()) {
            removeSurname.remove(choiceSurname);
        }

        if(!choiceCountry.isEmpty()) {
            removeDestinationCountry.remove(choiceCountry);
        }

        return delegationRepository.getList();
    }

}
