/*
package com.isa.cm3.servlets;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;

import com.isa.cm3.delegations.IdTokenVerifierAndParser;
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
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/sign-in")
public class SignInServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
                         throws ServletException, IOException {

        resp.setHeader("Content-Type", "text/html; charset=utf-8");
        resp.setContentType("text/html;charset=UTF-8 pageEncoding=\"UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "signIntemplate");
        try {
            String idToken = req.getParameter("id_token");
            GoogleIdToken.Payload payLoad = IdTokenVerifierAndParser.getPayload(idToken);
            String name = (String) payLoad.get("name");
            String email = payLoad.getEmail();
            System.out.println("User name: " + name);
            System.out.println("User email: " + email);

            HttpSession session = req.getSession(true);
            session.setAttribute("userName", name);
            req.getServletContext()
                    .getRequestDispatcher("/mainMenu").forward(req, resp);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }try
        {
                template.process(new HashMap<>(), resp.getWriter());
            } catch (TemplateException e1) {
                e1.printStackTrace();
            }
        }
    }
*/
