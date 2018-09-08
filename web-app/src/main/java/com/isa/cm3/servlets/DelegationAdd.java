package com.isa.cm3.servlets;


import com.isa.cm3.delegations.*;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;


@WebServlet("/delegation-add")
public class DelegationAdd extends HttpServlet {

    @Inject
    DelegationRepository delegationRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        resp.setHeader("Content-Type", "text/html; charset=UTF-8");
        req.getParameterMap();
        resp.setContentType("text/html;charset=UTF-8 pageEncoding=\"UTF-8");
        PrintWriter writer = resp.getWriter();

        String nameReq = req.getParameter("name");
        String surNameReq = req.getParameter("surname");
        String startDateReq = req.getParameter("startDate");
        String endDateReq = req.getParameter("endDate");
        String countryReq = req.getParameter("country");
        String cityReq = req.getParameter("city");
        String companyReq = req.getParameter("company");
        String companyAdresReq = req.getParameter("companyAdres");
        String purposeReq = req.getParameter("purpose");
        String startPointReq = req.getParameter("startPoint");


        resp.setContentType("text/html;charset=UTF-8");
        writer.println(nameReq + " " + surNameReq + " " + startDateReq + " " + endDateReq + " " + countryReq + " " + cityReq + " " + companyReq + " " + companyAdresReq + " " + startPointReq + " "
                + purposeReq);
        //getServletContext().getResourcePaths("delegations.txt");
        //writer.println("<br>" + );
        //tworzenie obiektu
        Delegation delegation = new Delegation();
        Employee employee = new Employee();
        Destination destination = new Destination();



        delegation.setFileLineNumber(delegationRepository.getDelegationId());
        delegation.setCreationDate(LocalDate.now());
        employee.setEmployeeName(nameReq);
        employee.setEmployeeSurname(surNameReq);
        delegation.setEmployee(employee);
        delegation.setStartDate(LocalDate.parse(startDateReq));
        delegation.setEndDate(LocalDate.parse(endDateReq));
        destination.setDestinationCountry(countryReq);
        destination.setDestinationCity(cityReq);
        destination.setDestinationCompany(companyReq);
        destination.setDestinationCompanyAddress(companyAdresReq);
        delegation.setDestination(destination);
        delegation.setPurpose(purposeReq);
        delegation.setStartPoint(startPointReq);
        delegation.setDelegationStatus(DelegationStatus.SAVED);

        DelegationSaveToFile delegationSaveToFile = new DelegationSaveToFile();

       delegationSaveToFile.saveToFile(delegation);
       delegationRepository.setDelegationId(delegationRepository.getDelegationId());
       writer.println("Delegacja zapisana <br><br>");





    }
}
