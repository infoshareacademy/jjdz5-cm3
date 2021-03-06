package com.isa.cm3.servlets;

import com.isa.cm3.dao.DelegationDao;
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

@WebServlet(urlPatterns = "/searchDelegations")
public class DelegationSearchServlet extends HttpServlet {

    private static final Logger LOG = LogManager.getLogger(DelegationSearchServlet.class);
    @Inject
    private DelegationRepository delegationRepository;
    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private MapModelGenerator mapModelGenerator;
    @Inject
    private DelegationFilter delegationFilter;
    @Inject
    private DelegationsCreateOptions delegationsCreateOptions;
    @Inject
    private DelegationDao delegationDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setHeader("Content-Type", "text/html; charset=UTF-8");
        resp.setContentType("text/html;charset=UTF-8 pageEncoding=\"UTF-8");

        try {
            LOG.debug("Wejście w try chatch w wyszukiwaniu delegacji");
            final String choiceStatus = req.getParameter("status").trim();
            final String choiceCreationDate = req.getParameter("date").trim();
            final String choiceName = req.getParameter("name").trim();
            final String choiceSurname = req.getParameter("surname").trim();
            final String choiceCountry = req.getParameter("country").trim();
            String employeeId = String.valueOf(req.getSession().getAttribute("employeeId"));
            LOG.info("Przypisanie danych do wyszukiwania zakończone");
            delegationRepository.setListDao(delegationDao.findAll());
            LOG.info("Lista ustawiona");
            LOG.info("Tworzenie domyslnej templati wyszukiwania");
            delegationsCreateOptions.createDefaultOptionTemplate(choiceCreationDate, choiceName, choiceSurname, choiceCountry, choiceStatus);
            LOG.info("Utworzone templatkę ");
            delegationsCreateOptions.addOptionsTemplate();
            mapModelGenerator.setModel("actionForm", "/delegations-web/searchDelegations");

            DelegationStatus myStatus = null;

            try {
                myStatus = DelegationStatus.valueOf(choiceStatus);
            } catch (Exception e) {
                System.out.println("choiceStatus is empty");
            }

            if (myStatus == null || myStatus.statusType().isEmpty()) {
                mapModelGenerator.setModel("delegations",
                        delegationFilter.filterDelegation(choiceCreationDate, choiceName, choiceSurname, choiceCountry, null));
            } else {
                mapModelGenerator.setModel("delegations",
                        delegationFilter.filterDelegation(choiceCreationDate, choiceName, choiceSurname, choiceCountry, myStatus));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        mapModelGenerator.setModel("whoIs", req.getSession().getAttribute("whoIs").toString());
        delegationsCreateOptions.createOptionsTemplate();

        try {
            Template template = templateProvider.getTemplate(getServletContext(), "searchingDelegationsTemplate");

            template.process(mapModelGenerator.getModel(), resp.getWriter());

        } catch (TemplateException e) {
            e.printStackTrace();
        }
        LOG.debug("Wyświetlenie wszystkich delegacji (sekcja Szukaj delegacji)");
    }
}