package com.isa.cm3.servlets;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.isa.cm3.dao.EmployeeDao;
import com.isa.cm3.delegations.Employee;
import com.isa.cm3.delegations.IdTokenVerifierAndParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private static final Logger LOG = LogManager.getLogger(LoginServlet.class);

    @Inject
    private EmployeeDao employeeDao;

    @Override
    public void init() throws ServletException {


        Employee employee = new Employee("Luke", "Skywalker", "manager@marekkalkowski.pl", true, false, 0);
        employeeDao.save(employee);
        Employee employee1 = new Employee("Mistrz", "Joda", "fullwypas@marekkalkowski.pl", true, true, 0);
        employeeDao.save(employee1);
        Employee employee2 = new Employee("Obi-Wan", "Kenobi", "admin@marekkalkowski.pl", false, true, 0);
        employeeDao.save(employee2);
        Employee employee3 = new Employee("Jar", "Binks", "szeregowy@marekkalkowski.pl", false, false, 0);
        employeeDao.save(employee3);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setHeader("Content-Type", "text/html; charset=utf-8");
        resp.setContentType("text/html;charset=UTF-8 pageEncoding=\"UTF-8");

        try {
            String idToken = req.getParameter("id_token");
            GoogleIdToken.Payload payLoad = IdTokenVerifierAndParser.getPayload(idToken);
            String name = (String) payLoad.get("name");
            String email = payLoad.getEmail();

            if (employeeDao.findIfExistByEmail(email)) {
                LOG.debug("Odnaleziono użytkownika w bazie ");
                HttpSession session = req.getSession(true);
                LOG.debug("Utworzono sesję dla " + email);
                session.setAttribute("userName", name);
                session.setAttribute("email", email);
                String whoIs = String.valueOf(employeeDao.isAdminOrManager(email));
                LOG.debug("Wartość parametru whoIs: " + whoIs);
                LOG.debug("Jezeli jeden to 2 to admin, 1 to manager, 0 zwykły pracownik ");
                session.setAttribute("whoIs", whoIs);
                session.setAttribute("employeeId", employeeDao.findByEmail(email).getId());
                LOG.debug("teraz bedzie redirect");
                resp.sendRedirect("/delegations-web/mainMenu");
            }else {
                resp.getWriter().write("<!DOCTYPE html>\n" +
                                "<html>\n" +
                                "<body onload=\"myFunction()\">\n" +

                                "\n" +
                                "<script>\n" +
                                "function myFunction() {\n" +
                                "    alert(\"Logowanie nie możliwe skontaktuj się z administratorem.\");\n" +
                                "    window.location='http://localhost:8080/delegations-web/';\n" +
                                "}\n" +
                                "</script>\n" +
                                "\n" +
                                "</body>\n" +
                                "</html>");
               // resp.sendRedirect("/delegations-web/");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}