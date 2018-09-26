package com.isa.cm3.servlets;

import com.isa.cm3.delegations.DelegationRepository;
import com.isa.cm3.delegations.DelegationStatus;
import com.isa.cm3.delegations.DelegationsLoadFromFile;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/acceptServlet")
public class DelegationAcceptDiscardServlet extends HttpServlet {

    @Inject
    DelegationRepository delegationRepository;

    @Inject
    DelegationsLoadFromFile delegationsLoadFromFile;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8 pageEncoding=\"UTF-8");
        req.getContentType();
        PrintWriter writer = resp.getWriter();


        String wybor = req.getParameter("wybor");
        String button = req.getParameter("button");
        Integer id = Integer.parseInt(wybor);
        DelegationStatus choice;
        if (button.equals("accept")) {
            choice = DelegationStatus.ACCEPTED;
        } else {
            choice = DelegationStatus.DISCARTED;
        }

        delegationsLoadFromFile.loadDelegationsFromFile();
        writer.println(delegationRepository.getList().stream().filter(delegation -> delegation.getFileLineNumber().equals(id)).peek(delegation -> delegation.setDelegationStatus(choice)).collect(Collectors.toSet()));


    }
}
