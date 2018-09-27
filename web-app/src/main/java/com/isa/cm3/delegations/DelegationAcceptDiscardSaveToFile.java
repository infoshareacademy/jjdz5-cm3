package com.isa.cm3.delegations;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class DelegationAcceptDiscardSaveToFile {

    @Inject
    DelegationsLoadFromFile delegationsLoadFromFile;

    @Inject
    DelegationRepository delegationRepository;

    @Inject
    DelegationAddToFile delegationSaveToFile;


    public void decisionSaving(Integer id, String button, Delegation delegation) {

        DelegationStatus status;

        if (button.equals("accept")) {
            status = DelegationStatus.ACCEPTED;
        } else {
            status = DelegationStatus.DISCARTED;
        }

        delegationsLoadFromFile.loadDelegationsFromFile();

        delegationRepository.getList().forEach(delegation1 -> {
                    if (delegation.getFileLineNumber().equals(id)) {
                        delegation.setDelegationStatus(status);
                    }
                }
        );








    }


}
