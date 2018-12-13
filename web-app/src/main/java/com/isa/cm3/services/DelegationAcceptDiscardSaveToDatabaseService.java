package com.isa.cm3.services;

import com.isa.cm3.dao.DelegationDao;
import com.isa.cm3.delegations.Delegation;
import com.isa.cm3.delegations.DelegationStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.ArrayList;

@RequestScoped
public class DelegationAcceptDiscardSaveToDatabaseService {

    @Inject
    private DelegationDao delegationDao;
    @Inject
    private Delegation delegation;

    private static final Logger LOG = LogManager.getLogger(DelegationAcceptDiscardSaveToDatabaseService.class);

    public void decisionSaving(Long id, String button, String discardReason) {

        String reason;
        DelegationStatus status;

        status = button.equals("accept") ? DelegationStatus.ACCEPTED : DelegationStatus.DISCARTED;
        reason = (discardReason.length() == 0) ? "brak" : discardReason;

        delegation = delegationDao.findById((id));
        delegation.setDiscardReason(reason);
        delegation.setDelegationStatus(status);
        delegationDao.update(delegation);

        LOG.info("Wniosek o id {} został {}",delegation.getId(), delegation.getDelegationStatus());
    }
}