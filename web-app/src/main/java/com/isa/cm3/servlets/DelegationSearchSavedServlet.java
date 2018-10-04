package com.isa.cm3.servlets;

import com.isa.cm3.delegations.Delegation;
import com.isa.cm3.delegations.DelegationRepository;
import com.isa.cm3.delegations.DelegationStatus;
import com.isa.cm3.delegations.DelegationsLoadFromFile;
import com.isa.cm3.freemarker.MapModelGenerator;
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
import java.util.Comparator;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/searchDelegationsSaved")
public class DelegationSearchSavedServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private MapModelGenerator mapModelGenerator;
    @Inject
    private DelegationRepository delegationRepository;
    @Inject
    private DelegationsLoadFromFile delegationsLoadFromFile;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setHeader ("Content-Type", "text/html; charset=UTF-8");
        resp.setContentType ("text/html;charset=UTF-8 pageEncoding=\"UTF-8");

        delegationsLoadFromFile.loadDelegationsFromFile ();


            mapModelGenerator.setModel ("delegations", delegationRepository.getList ().stream ()
                    .filter(delegation -> delegation.getDelegationStatus().equals(DelegationStatus.SAVED))
                    .sorted (Comparator.comparingInt (Delegation::getFileLineNumber))
                    .collect (Collectors.toList ()));

            Template template = templateProvider.getTemplate (getServletContext (), "searchingDelegationsTemplate");

            try {
                template.process (mapModelGenerator.getModel (), resp.getWriter ());
            } catch (TemplateException e) {
                e.printStackTrace ();
            }

    }



}
