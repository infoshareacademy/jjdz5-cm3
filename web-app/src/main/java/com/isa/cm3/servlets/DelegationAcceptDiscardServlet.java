package com.isa.cm3.servlets;

import com.isa.cm3.delegations.DelegationAcceptDiscardSaveToFile;
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
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/acceptServlet")
public class DelegationAcceptDiscardServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private DelegationAcceptDiscardSaveToFile delegationAcceptDiscardSaveToFile;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8 pageEncoding=\"UTF-8");
        req.getContentType();

        String wybor = req.getParameter("wybor");
        String button = req.getParameter("button");
        Integer id = Integer.parseInt(wybor);

        delegationAcceptDiscardSaveToFile.decisionSaving(id, button);

        Map<String, Object> model = new HashMap<>();

        model.put("mapa", button);
        Template template = templateProvider
                .getTemplate(getServletContext(), "delefationAfterManageRedirectTemplate");

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}

