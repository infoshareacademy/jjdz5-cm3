package com.isa.cm3.servlets;

import com.isa.cm3.dao.DelegationDao;

import com.isa.cm3.dao.DestinationDao;
import com.isa.cm3.dao.EmployeeDao;
import com.isa.cm3.delegations.Delegation;
import com.isa.cm3.delegations.DelegationStatus;
import com.isa.cm3.delegations.Destination;
import com.isa.cm3.delegations.Employee;
import com.isa.cm3.services.DelegationInstanceGeneratorService;
import com.isa.cm3.services.DelegationAddToFileService;
import com.isa.cm3.freemarker.MapModelGenerator;
import com.isa.cm3.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(urlPatterns = "/delegation-save")
public class DelegationSaveServlet extends HttpServlet {

    @PersistenceContext
    EntityManager em;

    @Inject
    private DelegationInstanceGeneratorService delegationInstanceGeneratorService;

    @Inject
    private DelegationAddToFileService delegationSaveToFile;

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private MapModelGenerator mapModelGenerator;

    @Inject
    DelegationDao delegationDao;

    @Inject
    DestinationDao destinationDao;
    
    @Inject
    EmployeeDao employeeDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8 pageEncoding=\"UTF-8");

//        Employee employee = new Employee("Marek","Kalkowski");
//        employeeDao.save(employee);
//        Destination destination = new Destination("Polska","Gdansk","Firma","Firma");
//        destinationDao.save(destination);
//        Delegation delegation = new Delegation(LocalDate.now(),employee,LocalDate.now(),LocalDate.now(),destination,"cos",DelegationStatus.ACCEPTED,"Gdansk","test");
//        delegationDao.save(delegation);
       
        //delegationSaveToFile.saveToFile(delegationInstanceGeneratorService.generateDelegationInstance());
        Delegation delegation = delegationInstanceGeneratorService.generateDelegationInstance();

        Template template = templateProvider
                .getTemplate(getServletContext(), "addDelegationTemplates/addDelegationAfterSaveAndRedirectTemplate");
        try {
            template.process(mapModelGenerator, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    private void saveDelegation (Delegation delegation) {
        Employee employee = delegation.getEmployee();
        Destination destination = delegation.getDestination();

        employeeDao.findAll();

    }
}

