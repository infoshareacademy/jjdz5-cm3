package com.isa.cm3.servlets;


import com.isa.cm3.delegations.Delegation;
import com.isa.cm3.delegations.DelegationRepository;
import com.isa.cm3.delegations.DelegationsValidation;
import com.isa.cm3.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/delegation-add")
public class DelegationAddProces extends HttpServlet {

    @Inject
    DelegationRepository delegationRepository;

    @Inject
    DelegationsValidation delegationsValidation;

    @Inject
    Delegation delegation;

    @Inject
    TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setHeader("Content-Type", "text/html; charset=UTF-8");
        Map<String, String> parameterMap = new HashMap<>();
        Map<String, Object> model = new HashMap<>();

        resp.setContentType("text/html;charset=UTF-8 pageEncoding=\"UTF-8");
        PrintWriter writer = resp.getWriter();

        for (String s : req.getParameterMap().keySet()) {
            String[] str = req.getParameterMap().get(s);
            for (String s1 : str) {
//                writer.println("klucz: " + s + " , value: " + s1);
                parameterMap.put(s, s1);
            }
        }

        String validationInfo = delegationsValidation.requestValidation(parameterMap);

        if (!validationInfo.equalsIgnoreCase("ok")) {

            model.put("mapa", validationInfo);
        } else {
            model.put("mapa", parameterMap);
        }

        Template template = templateProvider
                .getTemplate(getServletContext(), "addDelegationConfirmTemplate");
        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }


//        writer.println("##########################");
//        for (Map.Entry<String, String[]> entry : req.getParameterMap().entrySet()) {
//            String key = entry.getKey();
//            String str = String.valueOf(Arrays.toString(entry.getValue())).replace('[', ' ').replace(']', ' ').trim();
//            parameterMap.put(key, str);


//        writer.println(parameterMap.toString());
//
//        String nameReq = req.getParameter("name");
//        String surNameReq = req.getParameter("surname");
//        String startDateReq = req.getParameter("startDate");
//        String endDateReq = req.getParameter("endDate");
//        String countryReq = req.getParameter("country");
//        String cityReq = req.getParameter("city");
//        String companyReq = req.getParameter("company");
//        String companyAdresReq = req.getParameter("companyAdres");
//        String purposeReq = req.getParameter("purpose");
//        String startPointReq = req.getParameter("startPoint");
//
//
//        resp.setContentType("text/html;charset=UTF-8");
//        writer.println(nameReq + " " + surNameReq + " " + startDateReq + " " + endDateReq + " " + countryReq + " " + cityReq + " " + companyReq + " " + companyAdresReq + " " + startPointReq + " "
//                + purposeReq);
//        //getServletContext().getResourcePaths("delegations.txt");
//        //writer.println("<br>" + );
//        //tworzenie obiektu
//        Delegation delegation = new Delegation();
//        Employee employee = new Employee();
//        Destination destination = new Destination();
//
//
//
//        delegation.setFileLineNumber(delegationRepository.getDelegationId());
//        delegation.setCreationDate(LocalDate.now());
//        employee.setEmployeeName(nameReq);
//        employee.setEmployeeSurname(surNameReq);
//        delegation.setEmployee(employee);
//        delegation.setStartDate(LocalDate.parse(startDateReq));
//        delegation.setEndDate(LocalDate.parse(endDateReq));
//        destination.setDestinationCountry(countryReq);
//        destination.setDestinationCity(cityReq);
//        destination.setDestinationCompany(companyReq);
//        destination.setDestinationCompanyAddress(companyAdresReq);
//        delegation.setDestination(destination);
//        delegation.setPurpose(purposeReq);
//        delegation.setStartPoint(startPointReq);
//        delegation.setDelegationStatus(DelegationStatus.SAVED);
//
//        DelegationSaveToFile delegationSaveToFile = new DelegationSaveToFile();
//
//       delegationSaveToFile.saveToFile(delegation);
//       delegationRepository.setDelegationId(delegationRepository.getDelegationId());
//       writer.println("Delegacja zapisana <br><br>");


    }
}
