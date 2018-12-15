package com.isa.cm3.servlets;

import com.isa.cm3.delegations.DelegationMapForValidation;
import com.isa.cm3.freemarker.MapModelGenerator;
import com.isa.cm3.freemarker.TemplateProvider;
import com.isa.cm3.services.DelegationsValidationServices;
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

@WebServlet("/delegation-add")
public class DelegationAddProcesServlet extends HttpServlet {

    private static final Logger LOG = LogManager.getLogger(DelegationAddProcesServlet.class);
    @Inject
    private DelegationMapForValidation delegationMapForValidation;
    @Inject
    private DelegationsValidationServices delegationsValidationServices;
    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private MapModelGenerator mapModelGenerator;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setHeader("Content-Type", "text/html; charset=UTF-8");
        resp.setContentType("text/html;charset=UTF-8 pageEncoding=\"UTF-8");
        req.setCharacterEncoding("UTF-8");

        for (String s : req.getParameterMap().keySet()) {
            String[] str = req.getParameterMap().get(s);
            for (String s1 : str) {
                delegationMapForValidation.setParametrMap(s, s1);
            }
        }

        String validationInfo = delegationsValidationServices.requestValidation(delegationMapForValidation.getParametrMap());

        if (!validationInfo.equalsIgnoreCase("ok")) {
            mapModelGenerator.setModel("mapa", validationInfo);
        } else {
            mapModelGenerator.setModel("mapa", delegationMapForValidation.getParametrMap());
        }

        Template template = templateProvider
                .getTemplate(getServletContext(), "addDelegationTemplates/addDelegationConfirmAndSaveTemplate");
        try {
            template.process(mapModelGenerator.getModel(), resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        LOG.debug("Wyświetlenie podsumowania dodawanej delegacji");
    }
}
