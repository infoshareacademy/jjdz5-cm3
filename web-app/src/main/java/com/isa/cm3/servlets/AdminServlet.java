package com.isa.cm3.servlets;

import com.isa.cm3.dao.DestinationDao;
import com.isa.cm3.delegations.GeoLocation;
import com.isa.cm3.freemarker.MapModelGenerator;
import com.isa.cm3.freemarker.TemplateProvider;
import com.isa.cm3.services.GoogleService;
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
import java.util.List;

@WebServlet(urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {

    private static final Logger LOG = LogManager.getLogger(AdminServlet.class);
    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private MapModelGenerator mapModelGenerator;
    @Inject
    private GoogleService googleService;
    @Inject
    private DestinationDao destinationDao;

    private List<GeoLocation> locations = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setHeader("Content-Type", "text/html; charset=utf-8");
        resp.setContentType("application/json;charset=UTF-8 pageEncoding=\"UTF-8\"");

        mapModelGenerator.setModel("whoIs", req.getSession().getAttribute("whoIs").toString());
        LOG.debug("Pobranie wartości whoIs z sesji: " + req.getSession().getAttribute("whoIs").toString());

        for (String s : destinationDao.cityList()) {
            LOG.debug(s);
           locations.add(googleService.parseJson(s));
        }

        mapModelGenerator.setModel("locations",locations);
        Template template = templateProvider
                .getTemplate(getServletContext(), "/googleMaps/markerCluster");
        try {
            template.process(mapModelGenerator.getModel(), resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        LOG.debug("Wyświetlenie formularza administracji (sekcja Kontakt)");
    }
}