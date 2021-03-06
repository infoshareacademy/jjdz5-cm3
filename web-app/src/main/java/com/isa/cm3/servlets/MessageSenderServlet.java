package com.isa.cm3.servlets;

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

@WebServlet(urlPatterns = "/messageSender")
public class MessageSenderServlet extends HttpServlet {

    private static final Logger LOG = LogManager.getLogger(MessageSenderServlet.class);
    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setHeader("Content-Type", "text/html; charset=utf-8");
        resp.setContentType("text/html;charset=UTF-8 pageEncoding=\"UTF-8");

        Template template = templateProvider
                .getTemplate(getServletContext(), "messageSenderTemplate");
        try {
            template.process(new HashMap<>(), resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        LOG.debug("Wyświetlenie formularza kontaktowego (Sekcja kontakt)");
    }
}