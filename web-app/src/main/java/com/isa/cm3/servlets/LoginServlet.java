package com.isa.cm3.servlets;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.isa.cm3.delegations.IdTokenVerifierAndParser;
import com.isa.cm3.freemarker.TemplateProvider;
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
    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setHeader("Content-Type", "text/html; charset=utf-8");
        resp.setContentType("text/html;charset=UTF-8 pageEncoding=\"UTF-8");

        try {
            String idToken = req.getParameter("id_token");
            System.out.println(idToken);
            GoogleIdToken.Payload payLoad = IdTokenVerifierAndParser.getPayload(idToken);
            String name = (String) payLoad.get("name");
            String email = payLoad.getEmail();
            System.out.println("User name: " + name);
            System.out.println("User email: " + email);

               HttpSession session = req.getSession(true);
            session.setAttribute("userName", name);
            session.setAttribute("token", idToken);
            resp.sendRedirect("/delegations-web/mainMenu");
            req.getServletContext()
                    .getRequestDispatcher("mainMenu").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}