package com.isa.cm3.servlets;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet(urlPatterns = "/mainMenu")
public class MainMenuServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private MapModelGenerator mapModelGenerator;

    private static final Logger LOG = LogManager.getLogger(MainMenuServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setHeader("Content-Type", "text/html; charset=utf-8");
        resp.setContentType("text/html;charset=UTF-8 pageEncoding=\"UTF-8");

        mapModelGenerator.setModel(
                "mapa",
                req.getSession().getAttribute("userName").toString() //todo handla nullpointer
        );
        Template template = templateProvider
                .getTemplate(getServletContext(), "mainMenuTemplate");
        try {
            template.process(mapModelGenerator.getModel(), resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        LOG.debug("Wyświetlenie głównego menu");
    }
}