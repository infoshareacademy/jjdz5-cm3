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


@WebServlet(urlPatterns = "/searchDelegations")
public class DelegationSearchServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private MapModelGenerator mapModelGenerator;

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setHeader("Content-Type", "text/html; charset=UTF-8");
        resp.setContentType("text/html;charset=UTF-8 pageEncoding=\"UTF-8");

        try {
            final String choiceStatus = req.getParameter("status").trim();
            final String choiceCreationDate = req.getParameter("date").trim();
            final String choiceName = req.getParameter("name").trim();
            final String choiceSurname = req.getParameter("surname").trim();
            final String choiceCountry = req.getParameter("country").trim();

            delegationsLoadFromFile.loadDelegationsFromFile();

            mapModelGenerator.setModel("datesOption", choiceCreationDate);
            mapModelGenerator.setModel("namesOption", choiceName);
            mapModelGenerator.setModel("surnamesOption", choiceSurname);
            mapModelGenerator.setModel("countriesOption", choiceCountry);
            mapModelGenerator.setModel("statusOption", choiceStatus);

            mapModelGenerator.setModel("delegations",
                    delegationFilter.getFilteredList("", "", "", ""));

            dictionaryCreationDateAddition.addDictionaryCreationDates();
            dictionaryNameAddition.addDictionaryNames();
            dictionarySurnameAddition.addDictionarySurnames();
            dictionaryDestinationCountryAddition.addDictionaryDestinationCountries();

            DelegationStatus myStatus = null;

            try {
                myStatus = DelegationStatus.valueOf(choiceStatus);
            } catch (Exception e) {
                System.out.println("choiceStatus is empty");;
            }

            if(myStatus == null || myStatus.statusType().isEmpty()) {
                mapModelGenerator.setModel("delegations",
                        delegationFilter.getFilteredList(choiceCreationDate, choiceName, choiceSurname, choiceCountry));
            } else {
                mapModelGenerator.setModel("delegations",
                        delegationFilter.getFilteredList(choiceCreationDate, choiceName, choiceSurname, choiceCountry, myStatus));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            mapModelGenerator.setModel("dates", dictionaryCreationDateAddition.getDictionaryCreationDates());
            mapModelGenerator.setModel("names", dictionaryNameAddition.getDictionaryNames());
            mapModelGenerator.setModel("surnames", dictionarySurnameAddition.getDictionarySurnames());
            mapModelGenerator.setModel("countries", dictionaryDestinationCountryAddition.getDictionaryDestinationCountries());

            Template template = templateProvider.getTemplate(getServletContext(), "searchingDelegationsTemplate");

            template.process(mapModelGenerator.getModel(), resp.getWriter());

        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
