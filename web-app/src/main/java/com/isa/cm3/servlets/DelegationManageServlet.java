package com.isa.cm3.servlets;

import com.isa.cm3.delegations.*;
import com.isa.cm3.freemarker.MapModelGenerator;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.stream.Collectors;

@WebServlet("/manageDelegations")
public class DelegationManageServlet extends HttpServlet {

    @Inject
    private MapModelGenerator mapModelGenerator;
    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private DelegationRepository delegationRepository;
    @Inject
    private DelegationsLoadFromFile delegationsLoadFromFile;
    @Inject
    private DelegationAcceptDiscardSaveToFile delegationAcceptDiscardSaveToFile;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        resp.setHeader("Content-Type", "text/html; charset=UTF-8");
        resp.setContentType("text/html;charset=UTF-8 pageEncoding=\"UTF-8");

        delegationsLoadFromFile.loadDelegationsFromFile();

        final String wyborName = req.getParameter ("name").trim();
        final String wyborSurname = req.getParameter ("surname").trim();
        final String wyborCountry = req.getParameter ("country").trim();
        final String wyborCreationDate = req.getParameter ("created").trim();

        System.out.println("Wybór: "+wyborName);
        System.out.println("Wybór: "+wyborSurname);
        System.out.println("Wybór: "+wyborCountry);
        System.out.println("Wybór: "+wyborCreationDate);
        
        System.out.println(delegationRepository.getCreationDateList());
        System.out.println(String.format(wyborCreationDate,formatter ));

        if ( wyborName.isEmpty() && wyborSurname.isEmpty() && wyborCountry.isEmpty() && wyborCreationDate.isEmpty() ){
            mapModelGenerator.setModel("delegations", delegationRepository.getList().stream()
                    .filter(delegation -> delegation.getDelegationStatus().equals(DelegationStatus.TOACCEPT))
                    .sorted(Comparator.comparingInt(Delegation::getFileLineNumber))
                    .collect(Collectors.toList()));
            System.out.println("W1");
        }

        if ( wyborName.isEmpty() && wyborSurname.isEmpty() && !wyborCountry.isEmpty() && !wyborCreationDate.isEmpty() ){
            mapModelGenerator.setModel("delegations", delegationRepository.getList().stream()
                    .filter( delegation -> delegation.getDelegationStatus().equals(DelegationStatus.TOACCEPT) )
                    .filter(  delegation -> delegation.getDestination().getDestinationCountry().equals(wyborCountry) )
                    .filter(  delegation -> delegation.getCreationDate().equals(String.format(wyborCreationDate,formatter )) )
                    .sorted(Comparator.comparingInt(Delegation::getFileLineNumber))
                    .collect(Collectors.toList()));
            System.out.println("W2");
        }

        if ( wyborName.isEmpty() && wyborSurname.isEmpty() && !wyborCountry.isEmpty() && wyborCreationDate.isEmpty() ){
            mapModelGenerator.setModel("delegations", delegationRepository.getList().stream()
                    .filter( delegation -> delegation.getDelegationStatus().equals(DelegationStatus.TOACCEPT) )
                    .filter( delegation -> delegation.getDestination().getDestinationCountry().equals(wyborCountry) )
                    .sorted(Comparator.comparingInt(Delegation::getFileLineNumber))
                    .collect(Collectors.toList()));
            System.out.println("W3");
        }

        if ( wyborName.isEmpty() && wyborSurname.isEmpty() && !wyborCountry.isEmpty() ){
            mapModelGenerator.setModel("delegations", delegationRepository.getList().stream()
                    .filter( delegation -> delegation.getDelegationStatus().equals(DelegationStatus.TOACCEPT) )
                    .filter(  delegation -> delegation.getDestination().getDestinationCountry().equals(wyborCountry) )
                    .sorted(Comparator.comparingInt(Delegation::getFileLineNumber))
                    .collect(Collectors.toList()));
        }

        if ( wyborName.isEmpty() && !wyborSurname.isEmpty() && wyborCountry.isEmpty() ){
            mapModelGenerator.setModel("delegations", delegationRepository.getList().stream()
                    .filter( delegation -> delegation.getDelegationStatus().equals(DelegationStatus.TOACCEPT) )
                    .filter(  delegation -> delegation.getEmployee().getEmployeeSurname().equals(wyborSurname) )
                    .sorted(Comparator.comparingInt(Delegation::getFileLineNumber))
                    .collect(Collectors.toList()));
        }

        if ( !wyborName.isEmpty() && wyborSurname.isEmpty() && wyborCountry.isEmpty() ){
            mapModelGenerator.setModel("delegations", delegationRepository.getList().stream()
                    .filter( delegation -> delegation.getDelegationStatus().equals(DelegationStatus.TOACCEPT) )
                    .filter(  delegation -> delegation.getEmployee().getEmployeeName().equals(wyborName) )
                    .sorted(Comparator.comparingInt(Delegation::getFileLineNumber))
                    .collect(Collectors.toList()));
        }

        if ( wyborName.isEmpty() && !wyborSurname.isEmpty() && !wyborCountry.isEmpty() ) {
            mapModelGenerator.setModel("delegations", delegationRepository.getList().stream()
                    .filter(delegation -> delegation.getDelegationStatus().equals(DelegationStatus.TOACCEPT))
                    .filter(delegation -> delegation.getEmployee().getEmployeeSurname().equals(wyborSurname))
                    .filter(delegation -> delegation.getDestination().getDestinationCountry().equals(wyborCountry))
                    .sorted(Comparator.comparingInt(Delegation::getFileLineNumber))
                    .collect(Collectors.toList()));
        }

        if ( !wyborName.isEmpty() && wyborSurname.isEmpty() && !wyborCountry.isEmpty() ) {
            mapModelGenerator.setModel("delegations", delegationRepository.getList().stream()
                    .filter(delegation -> delegation.getDelegationStatus().equals(DelegationStatus.TOACCEPT))
                    .filter(  delegation -> delegation.getEmployee().getEmployeeName().equals(wyborName) )
                    .filter(delegation -> delegation.getDestination().getDestinationCountry().equals(wyborCountry))
                    .sorted(Comparator.comparingInt(Delegation::getFileLineNumber))
                    .collect(Collectors.toList()));
        }

        if ( !wyborName.isEmpty() && !wyborSurname.isEmpty() && wyborCountry.isEmpty() ) {
            mapModelGenerator.setModel("delegations", delegationRepository.getList().stream()
                    .filter(delegation -> delegation.getDelegationStatus().equals(DelegationStatus.TOACCEPT))
                    .filter(  delegation -> delegation.getEmployee().getEmployeeName().equals(wyborName) )
                    .filter(delegation -> delegation.getEmployee().getEmployeeSurname().equals(wyborSurname))
                    .sorted(Comparator.comparingInt(Delegation::getFileLineNumber))
                    .collect(Collectors.toList()));
        }

        if ( !wyborName.isEmpty() && !wyborSurname.isEmpty() && !wyborCountry.isEmpty() ) {
            mapModelGenerator.setModel("delegations", delegationRepository.getList().stream()
                    .filter(delegation -> delegation.getDelegationStatus().equals(DelegationStatus.TOACCEPT))
                    .filter(  delegation -> delegation.getEmployee().getEmployeeName().equals(wyborName) )
                    .filter(delegation -> delegation.getEmployee().getEmployeeSurname().equals(wyborSurname))
                    .filter(delegation -> delegation.getDestination().getDestinationCountry().equals(wyborCountry))
                    .sorted(Comparator.comparingInt(Delegation::getFileLineNumber))
                    .collect(Collectors.toList()));
        }

        mapModelGenerator.setModel("names", delegationRepository.getNameList().stream()
                .collect(Collectors.toList()));

        mapModelGenerator.setModel("surnames", delegationRepository.getSurnameList().stream()
                .collect(Collectors.toList()));

        mapModelGenerator.setModel("countries", delegationRepository.getDestinationCountryList().stream()
                .collect(Collectors.toList()));

        Template template = templateProvider.getTemplate(getServletContext(), "manageTemplates/manageDelegationsTemplate");

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

        Template template = templateProvider
                .getTemplate(getServletContext(), "manageTemplates/delegationAfterManageRedirectTemplate");

        String wybor = req.getParameter("wybor");
        if (wybor != null && !wybor.isEmpty()) {
            String button = req.getParameter("button");
            String discardReason = req.getParameter("discardReason");
            Integer id = Integer.parseInt(wybor);

            delegationAcceptDiscardSaveToFile.decisionSaving(id, button, discardReason);
            mapModelGenerator.setModel("mapa", button);

        } else {
            mapModelGenerator.setModel("mapa", "test");
        }

        try {
            template.process(mapModelGenerator.getModel(), resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}