package com.isa.cm3.delegations;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class DelegationFilterSurnameRemoval {

    @Inject
    private DelegationRepository delegationRepository;

    public void remove(String choiceSurname) {
        if(!choiceSurname.isEmpty()) {
            delegationRepository.getList().removeIf(delegation -> !delegation.getEmployee().getEmployeeSurname().equalsIgnoreCase(choiceSurname));
        }
    }
}
