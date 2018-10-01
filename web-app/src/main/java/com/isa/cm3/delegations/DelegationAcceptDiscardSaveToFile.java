package com.isa.cm3.delegations;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class DelegationAcceptDiscardSaveToFile {

    @Inject
    private DelegationsLoadFromFile delegationsLoadFromFile;

    @Inject
    private DelegationRepository delegationRepository;

    @Inject
    private DelegationListSaveToFile delegationListSaveToFile;


    public void decisionSaving(Integer id, String button, String discardReason) {

        DelegationStatus status;

        if (button.equals("accept")) {
            status = DelegationStatus.ACCEPTED;
        } else {
            status = DelegationStatus.DISCARTED;
        }

        delegationsLoadFromFile.loadDelegationsFromFile();

        delegationRepository.getList().forEach(delegation1 -> {
                    if (delegation1.getFileLineNumber().equals(id)) {
                        delegation1.setDelegationStatus(status);
                        delegation1.setDiscardReason(discardReason);
                    }
                }
        );

        delegationListSaveToFile.saveToFile();
    }
}
