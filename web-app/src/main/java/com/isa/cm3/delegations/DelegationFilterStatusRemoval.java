package com.isa.cm3.delegations;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class DelegationFilterStatusRemoval {

    @Inject
    private DelegationRepository delegationRepository;

    public void remove(DelegationStatus choiceName) {
        if(!choiceName.toString().isEmpty()) {
            delegationRepository.getList().removeIf(delegation -> !delegation.getDelegationStatus().equals(DelegationStatus.TOACCEPT));
        }
    }
}
