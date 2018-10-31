package com.isa.cm3.delegations;

import com.isa.cm3.dao.DelegationDao;
import com.isa.cm3.services.DelegationListSaveToFileService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class DelegationAcceptDiscardSaveToDatabase {

    @Inject
    DelegationDao delegationDao;
    @Inject
    Delegation delegation;

    public void decisionSaving(Long id, String button, String discardReason) {

        String reason;
        DelegationStatus status;

        status = button.equals("accept") ? DelegationStatus.ACCEPTED : DelegationStatus.DISCARTED;
        reason = (discardReason.length() == 0) ? "brak" : discardReason;

        delegation = delegationDao.findById((id));
        delegation.setDiscardReason(reason);
        delegation.setDelegationStatus(status);
        delegationDao.update(delegation);
    }
}