package com.isa.cm3.delegations;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RequestScoped
public class DelegationAcceptDiscardSaveToFile {

    @Inject
    DelegationsLoadFromFile delegationsLoadFromFile;

    @Inject
    DelegationRepository delegationRepository;

    @Inject
    DelegationSaveToFile delegationSaveToFile;


    public void decisionSaving (Integer id, String button, Delegation delegation){

        delegationsLoadFromFile.loadDelegationsFromFile();

        int index = delegationRepository.getList().indexOf(delegation);

        delegationRepository.getList().remove(index);

        delegationSaveToFile.saveToFile(delegation);


    }


}
