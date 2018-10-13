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
    private DictionaryCreationDateAddition dictionaryCreationDateAddition;

    @Inject
    private DictionaryNameAddition dictionaryNameAddition;

    @Inject
    private DictionarySurnameAddition dictionarySurnameAddition;

    @Inject
    private DictionaryDestinationCountryAddition dictionaryDestinationCountryAddition;

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

            mapModelGenerator.setModel("datesOption", choiceCreationDate);
            mapModelGenerator.setModel("namesOption", choiceName);
            mapModelGenerator.setModel("surnamesOption", choiceSurname);
            mapModelGenerator.setModel("countriesOption", choiceCountry);

            mapModelGenerator.setModel("delegations",
                    delegationFilter.getFilteredList("", "", "", "", DelegationStatus.TOACCEPT));

            dictionaryCreationDateAddition.addDictionaryCreationDates();
            dictionaryNameAddition.addDictionaryNames();
            dictionarySurnameAddition.addDictionarySurnames();
            dictionaryDestinationCountryAddition.addDictionaryDestinationCountries();

            mapModelGenerator.setModel("delegations",
                    delegationFilter.getFilteredList(choiceCreationDate, choiceName, choiceSurname, choiceCountry, DelegationStatus.TOACCEPT));

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            mapModelGenerator.setModel("dates", dictionaryCreationDateAddition.getDictionaryCreationDates());
            mapModelGenerator.setModel("names", dictionaryNameAddition.getDictionaryNames());
            mapModelGenerator.setModel("surnames", dictionarySurnameAddition.getDictionarySurnames());
            mapModelGenerator.setModel("countries", dictionaryDestinationCountryAddition.getDictionaryDestinationCountries());

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

        String choiceStatus = req.getParameter("choicestatus");

        if(choiceStatus != null && !choiceStatus.isEmpty()) {
            String button = req.getParameter("button");
            String discardReason = req.getParameter("discardReason");
            Integer id = Integer.parseInt(choiceStatus);

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
