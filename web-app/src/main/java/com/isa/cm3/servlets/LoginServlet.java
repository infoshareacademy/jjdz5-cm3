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


        Employee employee = new Employee("Marek", "Kalkowski", "kontakt@marekkalkowski.pl", true, true, 0);
        employeeDao.save(employee);
        Employee employee1 = new Employee("Testowy", "Tester", "marek@marekkalkowski.pl", false, false, 0);
        employeeDao.save(employee1);

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
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}