package com.isa.cm3.servlets;

import com.isa.cm3.delegations.DelegationListSaveToFile;
import com.isa.cm3.delegations.DelegationRepository;
import com.isa.cm3.delegations.DelegationUploadProcess;
import com.isa.cm3.delegations.Settings;
import com.isa.cm3.freemarker.MapModelGenerator;
import com.isa.cm3.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet(urlPatterns = "/import")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class DelegationImportServlet extends HttpServlet {

    @Inject
    TemplateProvider templateProvider;
    @Inject
    MapModelGenerator mapModelGenerator;

    @Inject
    DelegationUploadProcess delegationUploadProcess;

    @Inject
    DelegationListSaveToFile delegationListSaveToFile;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setHeader("Content-Type", "text/html; charset=UTF-8");
        resp.setContentType("text/html;charset=UTF-8 pageEncoding=\"UTF-8");

        Template template = templateProvider
                .getTemplate(getServletContext(), "importTemplates/importTemplate");
        try {
            template.process(mapModelGenerator.getModel(), resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        resp.setHeader("Content-Type", "text/html; charset=UTF-8");
        resp.setContentType("text/html;charset=UTF-8 pageEncoding=\"UTF-8");
        req.setCharacterEncoding("UTF-8");
        //        final String path = settings.getUploadDir().toString();
//        final File uploadDir = new File(path);
//        if (!uploadDir.exists()) {
//            uploadDir.mkdir();
//        }
        Part filePart = req.getPart("file");

        if (delegationUploadProcess.uploadFromFileProcess(filePart).equals("ok")) {
            delegationListSaveToFile.saveToFile();
            mapModelGenerator.setModel("mapa", "zapisano do pliku");
        } else {
            mapModelGenerator.setModel("mapa", delegationUploadProcess.uploadFromFileProcess(filePart));
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

