package com.isa.cm3.daoService;

import com.isa.cm3.dao.EmployeeDao;
import com.isa.cm3.delegations.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/")
public class EmployeeService {

    private Logger LOG = LoggerFactory.getLogger(EmployeeService .class);

    @Inject
    EmployeeDao employeeDao = new EmployeeDao();
}
