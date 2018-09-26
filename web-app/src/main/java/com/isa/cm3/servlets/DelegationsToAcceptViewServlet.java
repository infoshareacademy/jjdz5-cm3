package com.isa.cm3.servlets;

import com.isa.cm3.delegations.Delegation;
import com.isa.cm3.delegations.DelegationRepository;
import com.isa.cm3.delegations.DelegationStatus;
import com.isa.cm3.delegations.DelegationsLoadFromFile;
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
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = {"/toAccept"})
public class DelegationsToAcceptViewServlet extends HttpServlet {

    @Inject
    TemplateProvider templateProvider;
    @Inject
    DelegationRepository delegationRepository;
    @Inject
    DelegationsLoadFromFile delegationsLoadFromFile;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8 pageEncoding=\"UTF-8");

       delegationsLoadFromFile.loadDelegationsFromFile();
        List<Delegation> test = delegationRepository.getList();
        Map<String,Object> model   = new HashMap<>();
        model.put("delegations",delegationRepository.getList().stream()
                .sorted((d1,d2)-> d1.getFileLineNumber() - d2.getFileLineNumber() )
                .collect(Collectors.toList()));
        Template template = templateProvider
                .getTemplate(getServletContext(), "delegationsToAcceptViewTemplate");

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }
}
