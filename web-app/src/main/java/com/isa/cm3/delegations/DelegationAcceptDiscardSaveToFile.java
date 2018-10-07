package com.isa.cm3.delegations;

import com.isa.cm3.services.DelegationListSaveToFileService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class DelegationAcceptDiscardSaveToFile {

    @Inject
    private DelegationsLoadFromFile delegationsLoadFromFile;

    @Inject
    private DelegationRepository delegationRepository;

    @Inject
    private DelegationListSaveToFileService delegationListSaveToFileService;


    public void decisionSaving(Integer id, String button, String discardReason) {

        String reason;
        DelegationStatus status;

        if (button.equals("accept")) {
            status = DelegationStatus.ACCEPTED;
        } else {
            status = DelegationStatus.DISCARTED;
        }

        if (discardReason.length() == 0) {
            reason = "brak";
        } else {
            reason = discardReason;
        }

        delegationsLoadFromFile.loadDelegationsFromFile();

        delegationRepository.getList().stream()
                .filter(delegation -> delegation.getFileLineNumber().equals(id))
                .peek(delegation -> {
                            if (delegation.getFileLineNumber().equals(id)) {
                                delegation.setDelegationStatus(status);
                                delegation.setDiscardReason(reason);
                            }
                        }
                ).findFirst();

        delegationListSaveToFileService.saveToFile();
    }
}
