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

    public List<Delegation> getFilteredList(String choiceCreationDate, String choiceName, String choiceSurname, String choiceCountry, DelegationStatus choiceStatus) {

        List<Delegation> filtered;

        filtered = delegationRepository.getList();

        if(!choiceStatus.toString().isEmpty()) {
            filtered = filtered.stream()
                    .filter(delegation -> delegation.getDelegationStatus().equals(choiceStatus))
                    .collect(Collectors.toList());
        }

        if(!choiceCreationDate.isEmpty()) {
            filtered = filtered.stream()
                    .filter(delegation -> delegation.getCreationDate()
                            .format(settings.getFormater()).equalsIgnoreCase(choiceCreationDate))
                    .collect(Collectors.toList());
        }

        if(!choiceName.isEmpty()) {
            filtered = filtered.stream()
                    .filter(delegation -> delegation.getEmployee().getEmployeeName().equals(choiceName))
                    .collect(Collectors.toList());
        }

        if(!choiceSurname.isEmpty()) {
            filtered = filtered.stream()
                    .filter(delegation -> delegation.getEmployee().getEmployeeSurname().equals(choiceSurname))
                    .collect(Collectors.toList());
        }

        if(!choiceCountry.isEmpty()) {
            filtered = filtered.stream()
                    .filter(delegation -> delegation.getDestination().getDestinationCountry().equals(choiceCountry))
                    .collect(Collectors.toList());
        }

        return filtered.stream()
                .sorted(Comparator.comparingInt(Delegation::getFileLineNumber))
                .collect(Collectors.toList());
    }
    public List<Delegation> getFilteredList(String choiceCreationDate, String choiceName, String choiceSurname, String choiceCountry) {

        List<Delegation> filtered;

        filtered = delegationRepository.getList();

        if(!choiceCreationDate.isEmpty()) {
            filtered = filtered.stream()
                    .filter(delegation -> delegation.getCreationDate()
                            .format(settings.getFormater()).equalsIgnoreCase(choiceCreationDate))
                    .collect(Collectors.toList());
        }

        if(!choiceName.isEmpty()) {
            filtered = filtered.stream()
                    .filter(delegation -> delegation.getEmployee().getEmployeeName().equals(choiceName))
                    .collect(Collectors.toList());
        }

        if(!choiceSurname.isEmpty()) {
            filtered = filtered.stream()
                    .filter(delegation -> delegation.getEmployee().getEmployeeSurname().equals(choiceSurname))
                    .collect(Collectors.toList());
        }

        if(!choiceCountry.isEmpty()) {
            filtered = filtered.stream()
                    .filter(delegation -> delegation.getDestination().getDestinationCountry().equals(choiceCountry))
                    .collect(Collectors.toList());
        }

        return filtered.stream()
                .sorted(Comparator.comparingInt(Delegation::getFileLineNumber))
                .collect(Collectors.toList());
    }
}
