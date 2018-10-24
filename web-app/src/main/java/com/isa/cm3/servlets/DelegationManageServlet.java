package com.isa.cm3.servlets;

import com.isa.cm3.delegations.*;
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

@WebServlet("/manageDelegations")
public class DelegationManageServlet extends HttpServlet {

    @Inject
    private MapModelGenerator mapModelGenerator;

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private DelegationFilter delegationFilter;

    @Inject
    private DelegationsCreateOptions delegationsCreateOptions;

    @Inject
    private DelegationsLoadFromFile delegationsLoadFromFile;

    @Inject
    private DelegationAcceptDiscardSaveToFile delegationAcceptDiscardSaveToFile;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setHeader("Content-Type", "text/html; charset=UTF-8");
        resp.setContentType("text/html;charset=UTF-8 pageEncoding=\"UTF-8");

        try {
            final String choiceCreationDate = req.getParameter("date").trim();
            final String choiceName = req.getParameter("name").trim();
            final String choiceSurname = req.getParameter("surname").trim();
            final String choiceCountry = req.getParameter("country").trim();

            delegationsLoadFromFile.loadDelegationsFromFile();

            delegationsCreateOptions.createDefaultOptionTemplate(choiceCreationDate, choiceName, choiceSurname, choiceCountry, null);

            delegationsCreateOptions.addOptionsTemplate();
            mapModelGenerator.setModel("actionForm", "/delegations-web/manageDelegations");

            mapModelGenerator.setModel("delegations",
                    delegationFilter.filterDelegation(choiceCreationDate, choiceName, choiceSurname, choiceCountry, DelegationStatus.TOACCEPT));

        } catch (Exception e) {
            e.printStackTrace();
        }


        delegationsCreateOptions.createOptionsTemplate();

        try {
            Template template = templateProvider.getTemplate(getServletContext(), "manageTemplates/manageDelegationsTemplate");

            template.process(mapModelGenerator.getModel(), resp.getWriter());

        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setHeader("Content-Type", "text/html; charset=UTF-8");
        resp.setContentType("text/html;charset=UTF-8 pageEncoding=\"UTF-8");
        req.setCharacterEncoding("UTF-8");

        Template template = templateProvider
                .getTemplate(getServletContext(), "manageTemplates/delegationAfterManageRedirectTemplate");

        String choiceButton = req.getParameter("choiceButton");
        String choiceDelegation = req.getParameter("choiceDelegation");

        if (choiceButton != null && !choiceButton.isEmpty()) {
            String button = req.getParameter("choiceButton");
            String discardReason = req.getParameter("discardReason");
            Integer id = Integer.parseInt(choiceDelegation);

            delegationAcceptDiscardSaveToFile.decisionSaving(id, button, discardReason);
            mapModelGenerator.setModel("mapa", button);

        } else {
            mapModelGenerator.setModel("mapa", "test");
        }

        try {
            template.process(mapModelGenerator.getModel(), resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
