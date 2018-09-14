package com.isa.cm3.servlets;

import com.isa.cm3.delegations.DelegationMapForValidation;
import com.isa.cm3.delegations.DelegationSaveToFile;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DelegationSaveServlet extends HttpServlet {

    @Inject
    DelegationMapForValidation delegationMapForValidation;

    @Inject
    DelegationSaveToFile delegationSaveToFile;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8 pageEncoding=\"UTF-8");


    }
}
