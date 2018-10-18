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
    private Settings settings;

    List<Delegation> filteredDelegations;

    public List<Delegation> getFilteredList(String choiceCreationDate, String choiceName, String choiceSurname, String choiceCountry, DelegationStatus choiceStatus) {

        filteredDelegations = delegationRepository.getList();

        getFilteredListByCreationDate(choiceCreationDate);
        getFilteredListByEmployeeName(choiceName);
        getFilteredListByEmployeeSurname(choiceSurname);
        getFilteredListByDestinationCountry(choiceCountry);
        getFilteredListByStatus(choiceStatus);

        return filteredDelegations.stream()
                .sorted(Comparator.comparingInt(Delegation::getFileLineNumber))
                .collect(Collectors.toList());
    }

    private void getFilteredListByCreationDate(String choiceCreationDate) {
        if(!choiceCreationDate.isEmpty()) {
            filteredDelegations = filteredDelegations.stream()
                    .filter(delegation -> delegation.getCreationDate()
                            .format(settings.getFormater()).equalsIgnoreCase(choiceCreationDate))
                    .collect(Collectors.toList());
        }
    }

    private void getFilteredListByEmployeeName(String choiceName) {
        if(!choiceName.isEmpty()) {
            filteredDelegations = filteredDelegations.stream()
                    .filter(delegation -> delegation.getEmployee().getEmployeeName().equals(choiceName))
                    .collect(Collectors.toList());
        }
    }

    private void getFilteredListByEmployeeSurname(String choiceSurname) {
        if(!choiceSurname.isEmpty()) {
            filteredDelegations = filteredDelegations.stream()
                    .filter(delegation -> delegation.getEmployee().getEmployeeSurname().equals(choiceSurname))
                    .collect(Collectors.toList());
        }
    }

    private void getFilteredListByDestinationCountry(String choiceCountry) {
        if(!choiceCountry.isEmpty()) {
            filteredDelegations = filteredDelegations.stream()
                    .filter(delegation -> delegation.getDestination().getDestinationCountry().equals(choiceCountry))
                    .collect(Collectors.toList());
        }
    }

    private void getFilteredListByStatus(DelegationStatus choiceStatus) {
        if(choiceStatus != null) {
            if(!choiceStatus.toString().isEmpty())

            {
                filteredDelegations = filteredDelegations.stream()
                        .filter(delegation -> delegation.getDelegationStatus().equals(choiceStatus))
                        .collect(Collectors.toList());
            }
        }
    }
}

