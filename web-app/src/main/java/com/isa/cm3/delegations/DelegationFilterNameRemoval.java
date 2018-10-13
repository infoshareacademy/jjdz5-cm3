package com.isa.cm3.delegations;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class DelegationFilterNameRemoval {

    @Inject
    private DelegationRepository delegationRepository;

    public void remove(String choiceName) {
        if(!choiceName.isEmpty()) {
            delegationRepository.getList().removeIf(delegation -> !delegation.getEmployee().getEmployeeName().equalsIgnoreCase(choiceName));
        }
    }
}
