package com.isa.cm3.services;

import com.isa.cm3.dao.EmployeeDao;
import com.isa.cm3.delegations.DelegationMapForValidation;
import com.isa.cm3.delegations.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.inject.Inject;
import java.util.Map;

public class EmployeeSaveToDatabaseService {


    private static final Logger LOGGER = LoggerFactory.getLogger(DelegationSaveToDatabaseService.class);
    @Inject
    private EmployeeDao employeeDao;
    @Inject
    private DelegationMapForValidation delegationMapForValidation;

    public void saveDelegationToDatabase() {

        Map<String, String> map = delegationMapForValidation.getParametrMap();

        boolean manager;
        boolean admin;
        if (map.get("manager").equalsIgnoreCase("true")) {
            manager = true;
        } else {
            manager = false;
        }

        if (map.get("admin").equalsIgnoreCase("true")) {
            admin = true;
        } else {
            admin = false;
        }
        Employee employee = new Employee(
                map.get("name"),
                map.get("surname"),
                map.get("email"),
                manager,
                admin, 0);

        employeeDao.save(employee);

        LOGGER.info("Nastąpiło zapisanie do bazy pracownika");
    }
}

