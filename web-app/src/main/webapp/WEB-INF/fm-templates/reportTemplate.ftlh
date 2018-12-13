<!DOCTYPE html>
<html lang="pl-PL">

<head>

    <title>Delegacje</title>

<#include "include/headAndMeta.ftlh">

</head>

<body style="font-family: 'Open Sans', sans-serif">

<#include "include/navbarLogoHeaderTemplate.ftlh">

<h4 style="color: black; alignment: center; text-align: center;">Raport</h4>

    <table class="table">
        <thead>
            <tr>
                <th scope="col">Imię</th>
                <th scope="col">Nazwisko</th>
                <th scope="col">Data <br/> od</th>
                <th scope="col">Data <br/> do</th>
                <th scope="col">Kraj <br/> wyjazdu</th>
                <th scope="col">Miasto</th>
                <th scope="col">Firma</th>
                <th scope="col">Cel <br/> wyjazdu</th>
                <th scope="col">Status</th>
            </tr>
        </thead>
        <tbody>
            <#list delegations as d>
                <td>${d.getEmployee().getEmployeeName()}</td>
                <td>${d.getEmployee().getEmployeeSurname()}</td>
                <td>${d.getStartDate()}</td>
                <td>${d.getEndDate()}</td>
                <td>${d.getDestination().getDestinationCountry()}</td>
                <td>${d.getDestination().getDestinationCity()}</td>
                <td>${d.getDestination().getDestinationCompany()}</td>
                <td>${d.getPurpose()}</td>
                <td>${d.getDelegationStatus().statusType()}</td>
                </tr>
            </#list>
        </tbody>
    </table>
<hr/>
    <#include "include/footer.ftlh">
    <#include "include/scripts.ftlh">
</body>
</html>