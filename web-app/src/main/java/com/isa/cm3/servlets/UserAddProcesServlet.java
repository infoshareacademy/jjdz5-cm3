package com.isa.cm3.servlets;

import com.isa.cm3.freemarker.MapModelGenerator;
import com.isa.cm3.freemarker.TemplateProvider;
import com.isa.cm3.services.DelegationSaveToDatabaseService;
import com.isa.cm3.services.EmployeeSaveToDatabaseService;
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

@WebServlet(urlPatterns = "/userSave")
public class UserAddProcesServlet extends HttpServlet {

    private static final Logger LOG = LogManager.getLogger(DelegationSaveServlet.class);
    @Inject
    private EmployeeSaveToDatabaseService employeeSaveToDatabaseService;
    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private MapModelGenerator mapModelGenerator;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8 pageEncoding=\"UTF-8");

        employeeSaveToDatabaseService.saveDelegationToDatabase();

        Template template = templateProvider
                .getTemplate(getServletContext(), "addUser/addEmployeeAfterSaveAndRedirectTemplate");
        try {
            template.process(mapModelGenerator, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        LOG.debug("Zapisywanie delegacji...");
    }
}
