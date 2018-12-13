package com.isa.cm3.servlets;

import com.isa.cm3.dao.EmployeeDao;
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
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/addForm")
public class DelegationAddFormServlet extends HttpServlet {

    @Inject
    private MapModelGenerator mapModelGenerator;

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private EmployeeDao employeeDao;

    private static final Logger LOG = LogManager.getLogger(DelegationAddFormServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setHeader("Content-Type", "text/html; charset=utf-8");
        resp.setContentType("text/html;charset=UTF-8 pageEncoding=\"UTF-8");

        String userName = employeeDao.findByEmail((String) req.getSession().getAttribute("email")).getEmployeeName();
        mapModelGenerator.setModel
                ("userName",userName);
        mapModelGenerator.setModel
                ("userSureName",employeeDao.findByEmail((String) req.getSession().getAttribute("email")).getEmployeeSurname());
        mapModelGenerator.setModel("","");
        Template template = templateProvider
                .getTemplate(getServletContext(), "addDelegationTemplates/addDelegationTemplate");

        try {
            template.process(mapModelGenerator.getModel(), resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        LOG.debug("Wyświetlenie formularza do dodawania delegacji (sekcja Dodaj delegacje)");
    }
}
