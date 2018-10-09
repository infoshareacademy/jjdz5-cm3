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
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@WebServlet("/manageDelegations")
public class DelegationManageServlet extends HttpServlet {

    @Inject
    private MapModelGenerator mapModelGenerator;

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private DelegationRepository delegationRepository;

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

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            delegationsLoadFromFile.loadDelegationsFromFile();

            mapModelGenerator.setModel("datesOption", choiceCreationDate );
            mapModelGenerator.setModel("namesOption", choiceName );
            mapModelGenerator.setModel("surnamesOption", choiceSurname );
            mapModelGenerator.setModel("countriesOption", choiceCountry );

            mapModelGenerator.setModel("delegations",
                    delegationRepository.getFilteredList(choiceCreationDate, choiceName, choiceSurname, choiceCountry));

        } catch(Exception e) {
            e.printStackTrace();
        }

        try {
            mapModelGenerator.setModel("dates", delegationRepository.getCreationDateList());

            mapModelGenerator.setModel("names", delegationRepository.getNameList());

            mapModelGenerator.setModel("surnames", delegationRepository.getSurnameList());

            mapModelGenerator.setModel("countries", delegationRepository.getDestinationCountryList());

            Template template = templateProvider.getTemplate(getServletContext(), "manageTemplates/manageDelegationsTemplate");

            template.process(mapModelGenerator.getModel(), resp.getWriter());

        } catch(TemplateException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setHeader ("Content-Type", "text/html; charset=UTF-8");
        resp.setContentType ("text/html;charset=UTF-8 pageEncoding=\"UTF-8");
        req.setCharacterEncoding ("UTF-8");

        Template template = templateProvider
                .getTemplate(getServletContext(), "manageTemplates/delegationAfterManageRedirectTemplate");

        String choiceStatus = req.getParameter("test");

        if(choiceStatus != null && !choiceStatus.isEmpty()) {
            String button = req.getParameter("button");
            String discardReason = req.getParameter("discardReason");
            Integer id = Integer.parseInt(choiceStatus);

            delegationAcceptDiscardSaveToFile.decisionSaving(id, button, discardReason);
            mapModelGenerator.setModel("mapa", button);

        } else {
            mapModelGenerator.setModel ("mapa", "test");
        }

        try {
            template.process(mapModelGenerator.getModel(), resp.getWriter());
        } catch(TemplateException e) {
            e.printStackTrace();
        }
    }
}
