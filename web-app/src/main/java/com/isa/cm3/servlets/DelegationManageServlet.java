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
import java.util.Comparator;
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

        delegationsLoadFromFile.loadDelegationsFromFile();

        mapModelGenerator.setModel("delegations", delegationRepository.getList().stream()
                .sorted(Comparator.comparingInt(Delegation::getFileLineNumber))
                .filter(delegation -> delegation.getDelegationStatus().equals(DelegationStatus.SAVED))
                .collect(Collectors.toList()));

        Template template = templateProvider.getTemplate(getServletContext(), "manageTemplates/manageDelegationsTemplate");

        try {
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

        String wybor = req.getParameter("wybor");
        if (wybor != null && !wybor.isEmpty()) {
            String button = req.getParameter("button");
            String discardReason = req.getParameter("discardReason");
            Integer id = Integer.parseInt(wybor);

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