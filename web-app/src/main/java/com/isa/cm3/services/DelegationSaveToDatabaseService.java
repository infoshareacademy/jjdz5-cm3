package com.isa.cm3.services;

import com.isa.cm3.dao.DelegationDao;
import com.isa.cm3.dao.DestinationDao;
import com.isa.cm3.dao.EmployeeDao;
import com.isa.cm3.delegations.*;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Transactional
@RequestScoped
public class DelegationSaveToDatabaseService {

    @Inject
    private Settings settings;
    @Inject
    private EmployeeDao employeeDao;
    @Inject
    private DestinationDao destinationDao;
    @Inject
    private DelegationDao delegationDao;
    @Inject
    private DelegationMapForValidation delegationMapForValidation;

    public void saveDelegationToDatabase() {

        Map<String, String> map = delegationMapForValidation.getParametrMap();

        Employee employeeToCheck = new Employee(
                map.get("name"),
                map.get("surname"));

        Destination destinationToCheck = new Destination(
                map.get("country"),
                map.get("city"),
                map.get("company"),
                map.get("companyAdres"));

        Employee employee = employeeDao.findIfExist(employeeToCheck);
        Destination destination = destinationDao.findIfExist(destinationToCheck);

        Delegation delegation = new Delegation(
                LocalDate.now(),
                employee,
                LocalDate.parse(map.get("startDate"), settings.getFormater()),
                LocalDate.parse(map.get("endDate"), settings.getFormater()),
                destination,
                map.get("purpose"),
                DelegationStatus.TOACCEPT,
                map.get("startPoint")
        );

        employeeDao.save(employee);
        destinationDao.save(destination);
        delegationDao.save(delegation);
    }
}