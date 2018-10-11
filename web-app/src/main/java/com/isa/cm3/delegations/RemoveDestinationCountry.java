package com.isa.cm3.delegations;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class RemoveDestinationCountry {

    @Inject
    private DelegationRepository delegationRepository;

    public void remove(String choiceCountry) {
        if(!choiceCountry.isEmpty()) {
            delegationRepository.getList().removeIf(delegation -> !delegation.getDestination().getDestinationCountry().equals(choiceCountry));
        }
    }
}
