package com.isa.cm3.services;

import com.isa.cm3.dao.DelegationDao;
import com.isa.cm3.delegations.Delegation;
import com.isa.cm3.delegations.DelegationStatus;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class DelegationAcceptDiscardSaveToDatabaseService {

    @Inject
    private DelegationDao delegationDao;
    @Inject
    private Delegation delegation;

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