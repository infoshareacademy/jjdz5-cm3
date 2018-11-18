package com.isa.cm3.services;

import com.isa.cm3.dao.DelegationDao;
import com.isa.cm3.dao.DestinationDao;
import com.isa.cm3.dao.EmployeeDao;
import com.isa.cm3.delegations.Delegation;
import com.isa.cm3.delegations.DelegationRepository;
import com.isa.cm3.delegations.Destination;
import com.isa.cm3.delegations.Employee;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
@Transactional
public class DelegationsAfterUploadSaveToDatabaseService {

    @Inject
    private DelegationDao delegationDao;
    @Inject
    private EmployeeDao employeeDao;
    @Inject
    private DestinationDao destinationDao;
    @Inject
    private DelegationRepository delegationRepository;

    public void savingImportedDelegationsToDabase() {

        List<Delegation> delegationListToImport = delegationRepository.getList();
        for (Delegation delegation : delegationListToImport) {
            Employee employee = employeeDao.findIfExist(delegation.getEmployee());
            Destination destination = destinationDao.findIfExist(delegation.getDestination());

            delegation.setEmployee(employee);
            delegation.setDestination(destination);

            employeeDao.save(employee);
            destinationDao.save(destination);
            delegationDao.save(delegation);
        }
    }
}