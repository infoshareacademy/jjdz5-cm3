package com.isa.cm3.services;

import com.isa.cm3.dao.DelegationDao;
import com.isa.cm3.dao.DestinationDao;
import com.isa.cm3.dao.EmployeeDao;
import com.isa.cm3.delegations.*;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Optional;

@RequestScoped
public class DelegationSaveToDatabaseService {

    private final DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @Inject
    EmployeeDao employeeDao;
    @Inject
    DestinationDao destinationDao;
    @Inject
    DelegationDao delegationDao;
    @Inject
    private DelegationMapForValidation delegationMapForValidation;

    public void saveDelegationToDatabase() {

        Map<String, String> map = delegationMapForValidation.getParametrMap();

       Employee employee = new Employee(map.get("name"),map.get("surname"));
        Destination destination = new Destination();
        Delegation delegation = new Delegation();

        for (String key : map.keySet()) {

            String value = map.get(key);

            if (key.equals("country")) {
                destination.setDestinationCountry(value);
            } else if (key.equals("purpose")) {
                delegation.setPurpose(value);
//            } else if (key.equals("name")) {
//                employee.setEmployeeName(value);
//            } else if (key.equals("surname")) {
//                employee.setEmployeeSurname(value);
//            }
            }else if (key.equals("startDate")) {
                delegation.setStartDate(LocalDate.parse(value, formater));
            } else if (key.equals("endDate")) {
                delegation.setEndDate(LocalDate.parse(value, formater));
            } else if (key.equals("city")) {
                destination.setDestinationCity(value);
            } else if (key.equals("company")) {
                destination.setDestinationCompany(value);
            } else if (key.equals("companyAdres")) {
                destination.setDestinationCompanyAddress(value);
            } else if (key.equals("startPoint")) {
                delegation.setStartPoint(value);
            }
        }
        delegation.setDelegationStatus(DelegationStatus.TOACCEPT);
        delegation.setCreationDate(LocalDate.now());
        delegation.setDestination(destination);


        saveEmployeeToDatabase(employee, delegation);


        destinationDao.save(destination);
        delegationDao.save(delegation);
    }

    private void saveEmployeeToDatabase(Employee employee, Delegation delegation) {
        if (isEmployeeInDatabase(employee)){
                    Long id = employeeDao.findAll().stream()
                    .filter(e->e.equals(employee))
                    .map(e1->e1.getId())
                    .count();
            Employee employee1 = employeeDao.findById(id);
            delegation.setEmployee(employee1);
            employeeDao.update(employee1);

        }else{

            employeeDao.save(employee);
            delegation.setEmployee(employee);}
    }

    private boolean isEmployeeInDatabase (Employee employee){
        Optional<Employee> isTrue = employeeDao.findAll().stream()
                .filter(e->e.getEmployeeName().equals(employee.getEmployeeName()))
                .filter(e1->e1.getEmployeeSurname().equals(employee.getEmployeeSurname()))
                .findFirst();

       return isTrue.isPresent();
    }
}
