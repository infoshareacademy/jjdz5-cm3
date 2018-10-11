package com.isa.cm3.delegations;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class RemoveCreationDate {

    @Inject
    private DelegationRepository delegationRepository;

    @Inject
    private Settings settings;


    public void remove(String choiceCreationDate) {
        if(!choiceCreationDate.isEmpty()) {
            delegationRepository.getList().removeIf(delegation -> !delegation.getCreationDate().format(settings.getFormater()).equalsIgnoreCase(choiceCreationDate));
        }
    }
}
