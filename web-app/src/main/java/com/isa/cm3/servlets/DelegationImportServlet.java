package com.isa.cm3.servlets;


import com.isa.cm3.freemarker.MapModelGenerator;
import com.isa.cm3.freemarker.TemplateProvider;
import com.isa.cm3.services.DelegationImportService;
import com.isa.cm3.services.DelegationsAfterUploadSaveToDatabaseService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.transaction.Transactional;
import java.io.IOException;

@Transactional
@WebServlet(urlPatterns = "/import")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class DelegationImportServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private MapModelGenerator mapModelGenerator;
    @Inject
    private DelegationImportService delegationUploadProcess;
    @Inject
    private DelegationsAfterUploadSaveToDatabaseService delegationsAfterUploadSaveToDatabaseService;

    private static final Logger LOG = LogManager.getLogger(DelegationImportServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setHeader("Content-Type", "text/html; charset=UTF-8");
        resp.setContentType("text/html;charset=UTF-8 pageEncoding=\"UTF-8");
        mapModelGenerator.setModel("whoIs",req.getSession().getAttribute("whoIs").toString());
        Template template = templateProvider
                .getTemplate(getServletContext(), "importTemplates/importTemplate");
        try {
            template.process(mapModelGenerator.getModel(), resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        LOG.debug("Wyświetlenie strony do importu pliku z delegacjami (sekcja Importuj delegacje)");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setHeader("Content-Type", "text/html; charset=UTF-8");
        resp.setContentType("text/html;charset=UTF-8 pageEncoding=\"UTF-8");
        req.setCharacterEncoding("UTF-8");

        Part filePart = req.getPart("file");

        String importMessage = delegationUploadProcess.uploadFromFileProcess(filePart);

        if (importMessage.equals("ok")) {

            delegationsAfterUploadSaveToDatabaseService.savingImportedDelegationsToDabase();

            mapModelGenerator.setModel("mapa", "Zapisano do bazy");
            LOG.info("Żądany plik z delegacjami pomyślnie zaimportowano do bazy danych.");
        } else {

            mapModelGenerator.setModel("mapa", importMessage);
            LOG.info("Żądany plik z delegacjami nie zaimportowano do bazy danych");
        }

        Template template = templateProvider
                .getTemplate(getServletContext(), "importTemplates/afterImportTemplate");
        try {
            template.process(mapModelGenerator.getModel(), resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}