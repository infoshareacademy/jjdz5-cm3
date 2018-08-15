package com.isa.cm3.servlets;


import com.isa.cm3.delegations.Delegation;
import com.isa.cm3.delegations.Destination;
import com.isa.cm3.delegations.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;


@WebServlet("/delegation-add")
public class DelegationAdd extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        resp.setContentType("text/html;charset=UTF-8 pageEncoding=\"UTF-8");
        PrintWriter writer = resp.getWriter();

        String nameReq = getInitParameter("name");
        String surNameReq = getInitParameter("surname");
        String startDateReq = req.getParameter("startDate");
        String endDateReq = req.getParameter("endDate");
        String countryReq = req.getParameter("country");
        String cityReq = req.getParameter("city");
        String purposeReq = req.getParameter("purpose");

        writer.println(startDateReq + " " + endDateReq + " " + countryReq + " " + cityReq + " " + purposeReq);

        //tworzenie obiektu
        Delegation delegation = new Delegation();
        Employee employee = new Employee();
        Destination destination = new Destination();
        delegation.setCreationDate(LocalDate.now());
    }
}
