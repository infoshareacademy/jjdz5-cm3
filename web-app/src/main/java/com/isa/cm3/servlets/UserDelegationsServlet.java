package com.isa.cm3.servlets;

import com.isa.cm3.dao.DelegationDao;
import com.isa.cm3.dao.EmployeeDao;
import com.isa.cm3.delegations.DelegationFilter;
import com.isa.cm3.delegations.DelegationRepository;
import com.isa.cm3.delegations.DelegationsCreateOptions;
import com.isa.cm3.delegations.Employee;
import com.isa.cm3.freemarker.MapModelGenerator;
import com.isa.cm3.freemarker.TemplateProvider;
import com.isa.cm3.services.DelegationAcceptDiscardSaveToDatabaseService;
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

@WebServlet(urlPatterns = "/userDelegations")
public class UserDelegationsServlet extends HttpServlet {

    private static final Logger LOG = LogManager.getLogger(DelegationManageServlet.class);
    @Inject
    private DelegationRepository delegationRepository;
    @Inject
    private EmployeeDao employeeDao;
    @Inject
    private DelegationDao delegationDao;
    @Inject
    private MapModelGenerator mapModelGenerator;
    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private DelegationFilter delegationFilter;
    @Inject
    private DelegationsCreateOptions delegationsCreateOptions;
    @Inject
    private DelegationAcceptDiscardSaveToDatabaseService delegationAcceptDiscardSaveToDatabaseService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setHeader("Content-Type", "text/html; charset=UTF-8");
        resp.setContentType("text/html;charset=UTF-8 pageEncoding=\"UTF-8");

        Employee employee = employeeDao.findByEmail(req.getSession().getAttribute("email").toString());
        mapModelGenerator.setModel("whoIs", req.getSession().getAttribute("whoIs").toString());
        mapModelGenerator.setModel
                ("delegationsList", delegationDao.findAllForCurentEmployee(String.valueOf(employee.getId())));

        try {
            Template template = templateProvider.getTemplate(getServletContext(), "previewMyDelegations");

            template.process(mapModelGenerator.getModel(), resp.getWriter());

        } catch (TemplateException e) {
            e.printStackTrace();
        }
        LOG.debug("Wyświetlenie wszystkich delegacji usera: "
                + employee.getEmployeeName() + " " + employee.getEmployeeSurname());
    }
}
