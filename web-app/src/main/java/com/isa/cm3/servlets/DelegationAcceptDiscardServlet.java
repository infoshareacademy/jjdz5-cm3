package com.isa.cm3.servlets;

import com.isa.cm3.delegations.DelegationRepository;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/acceptServlet")
public class DelegationAcceptDiscardServlet extends HttpServlet {

    @Inject
    DelegationRepository delegationRepository;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8 pageEncoding=\"UTF-8");
        req.getContentType();
        PrintWriter writer = resp.getWriter();


        String param1 = req.getParameter("wybor");
        Integer id = Integer.parseInt(param1);



        writer.println(delegationRepository.getList().stream().filter(delegation -> delegation.getFileLineNumber().equals(id)).collect(Collectors.toSet()));


    }
}
