package com.isa.cm3.servlets;

import com.isa.cm3.daoService.DelegationService;
import com.isa.cm3.delegations.DelegationFilter;
import com.isa.cm3.delegations.DelegationRepository;
import com.isa.cm3.delegations.DelegationStatus;
import com.isa.cm3.delegations.DelegationsCreateOptions;
import com.isa.cm3.freemarker.MapModelGenerator;
import com.isa.cm3.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/report")
public class DelegationReportServlet extends HttpServlet {

    @Inject
    private DelegationRepository delegationRepository;
    @Inject
    private DelegationService delegationService;
    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private MapModelGenerator mapModelGenerator;
    @Inject
    private DelegationFilter delegationFilter;
    @Inject
    private DelegationsCreateOptions delegationsCreateOptions;

    private static final Logger LOG = LogManager.getLogger(DelegationSearchServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setHeader("Content-Type", "text/html; charset=UTF-8");
        resp.setContentType("text/html;charset=UTF-8 pageEncoding=\"UTF-8");

        try {
            prepareValues(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

        delegationsCreateOptions.createOptionsTemplate();

        try {
            Template template = templateProvider.getTemplate(getServletContext(), "reportTemplate");
            template.process(mapModelGenerator.getModel(), resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        LOG.debug("Wyświetlenie raportu delegacji");
    }

    private void prepareValues (HttpServletRequest request, HttpServletResponse response) {

        final String choiceStatus = request.getParameter("status").trim();
        final String choiceCreationDate = request.getParameter("date").trim();
        final String choiceName = request.getParameter("name").trim();
        final String choiceSurname = request.getParameter("surname").trim();
        final String choiceCountry = request.getParameter("country").trim();

        delegationRepository.setListDao(delegationService.getReport());

        delegationsCreateOptions.createDefaultOptionTemplate(choiceCreationDate, choiceName, choiceSurname, choiceCountry, choiceStatus);

        delegationsCreateOptions.addOptionsTemplate();
        mapModelGenerator.setModel("actionForm", "/delegations-web/report");

        DelegationStatus myStatus = checkStatus(choiceStatus);

        if (myStatus == null || myStatus.statusType().isEmpty()) {
            mapModelGenerator.setModel("delegations",
                    delegationFilter.filterDelegation(choiceCreationDate, choiceName, choiceSurname, choiceCountry, null));
        } else {
            mapModelGenerator.setModel("delegations",
                    delegationFilter.filterDelegation(choiceCreationDate, choiceName, choiceSurname, choiceCountry, myStatus));
        }

    }

    private DelegationStatus checkStatus(String status){

        DelegationStatus myStatus = null;

        try {
            myStatus = DelegationStatus.valueOf(status);
        } catch (Exception e) {
            System.out.println("choiceStatus is empty");
        }
        return myStatus;
    }
}