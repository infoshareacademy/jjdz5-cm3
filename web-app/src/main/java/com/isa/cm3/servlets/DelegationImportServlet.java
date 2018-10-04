package com.isa.cm3.servlets;

import com.isa.cm3.delegations.Settings;
import com.isa.cm3.freemarker.MapModelGenerator;
import com.isa.cm3.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import sun.plugin.dom.html.HTMLTableCaptionElement;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static jdk.nashorn.internal.objects.NativeError.getFileName;

@WebServlet (urlPatterns = "/import")
@MultipartConfig( fileSizeThreshold=1024*1024,
        maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
public class DelegationImportServlet extends HttpServlet {

    @Inject
    TemplateProvider templateProvider;
    @Inject
    MapModelGenerator mapModelGenerator;
    @Inject
    Settings settings;


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

        String message = "";

        final String path = settings.getUploadDir().toString();
        final File uploadDir = new File(path);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        final Part filePart = req.getPart("file");
        if (filePart.getSize() == 0) {
            message = "nie podałeś pliku do wczytania";
        }
        
        String fileName = "delegationsImported.txt";
        // filePart.getHeader("content-disposition");
        for (Part part : req.getParts()) {
//            fileName = part.getSubmittedFileName();
            filePart.write(path + File.separator + fileName);
//        }
//       final Part filePart = req.getPart("file");
            // String uploadPath = getServletContext().getRealPath("");

            mapModelGenerator.setModel("mapa", "Plik został zaimportowany");


            Template template = templateProvider
                    .getTemplate(getServletContext(), "importTemplates/afterImportTemplate");
            try {
                template.process(mapModelGenerator.getModel(), resp.getWriter());
            } catch (TemplateException e) {
                e.printStackTrace();
            }


        }

    }
}
