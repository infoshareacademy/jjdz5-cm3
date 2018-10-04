package com.isa.cm3.delegations;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@RequestScoped
public class DelegationInstanceGenerator {

    private final DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @Inject
    private DelegationMapForValidation delegationMapForValidation;
    @Inject
    private Delegation delegation;
    @Inject
    private Destination destination;
    @Inject
    private Employee employee;
    @Inject
    private DelegationAutoincrementId delegationAutoincrementId;

    public Delegation generateDelegationInstance() {

        Map<String, String> map = delegationMapForValidation.getParametrMap();
        for (String key : map.keySet()) {

            String value = map.get(key);

            if (key.equals("country")) {
                destination.setDestinationCountry(value);
            } else if (key.equals("purpose")) {
                delegation.setPurpose(value);
            } else if (key.equals("name")) {
                employee.setEmployeeName(value);
            } else if (key.equals("surname")) {
                employee.setEmployeeSurname(value);
            } else if (key.equals("startDate")) {
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

        delegation.setFileLineNumber(delegationAutoincrementId.loadId());
        delegation.setDestination(destination);
        delegation.setEmployee(employee);
        delegation.setDelegationStatus(DelegationStatus.TOACCEPT);
        delegation.setCreationDate(LocalDate.now());

        return delegation;
    }
}
