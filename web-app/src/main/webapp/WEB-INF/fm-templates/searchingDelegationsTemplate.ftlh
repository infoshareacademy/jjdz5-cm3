<!DOCTYPE html>
<html lang="pl-PL">
<head>

    <title>Main menu</title>

<#include "include/headAndMeta.ftlh">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
</head>

<body style="font-family: 'Open Sans', sans-serif">
<#include "include/navbarHeaderTemplate.ftlh">

<h4 style="color: black; alignment: center; text-align: center;">Wyszukiwanie delegacji</h4>

<div class="container">
    <div class="row">

        <div class="card" style="width: 100%; height: 100%; background-color: lightgrey; alignment: center;">
            <h4 class="card-title" style="width: 100%; height: 100%; background-color: slategrey; alignment: center; text-align: center;">Filtrowanie</h4>

            <div class="card-body" style="background-color: lightgrey;">

                <div class="card-text">

                    <form action="/delegations-web/searchDelegations" method="get">

                        <div class="col-sm-12" style="width: 100%;">

                            <div class="col-md-2">
                            <label>Data utworzenia:</label><br>
                            <select name="date" style="width: 100%;">
                                 <#list dates as d>
                                     <#if datesOption == d >
                                     <option selected>${d}</option>
                                     <#else>
                                     <option>${d}</option>
                                     </#if>
                                 </#list>
                            </select>
                            </div>

                            <div class="col-md-2">
                            <label>Imię:</label><br>
                            <select name="name" style="width: 100%;">
                                 <#list names as n>
                                     <#if namesOption == n >
                                     <option selected>${n}</option>
                                     <#else>
                                     <option>${n}</option>
                                     </#if>
                                 </#list>
                            </select>
                            </div>

                            <div class="col-md-2">
                            <label>Nazwisko:</label><br>
                            <select name="surname" style="width: 100%;">
                                 <#list surnames as s>
                                     <#if surnamesOption == s >
                                     <option selected>${s}</option>
                                     <#else>
                                     <option>${s}</option>
                                     </#if>
                                 </#list>
                            </select>
                            </div>

                            <div class="col-md-3">
                            <label>Kraj wyjazdu:</label><br>
                            <select name="country" style="width: 100%;">
                                 <#list countries as s>
                                     <#if countriesOption == s >
                                         <option selected>${s}</option>
                                     <#else>
                                         <option>${s}</option>
                                     </#if>
                                 </#list>
                            </select>
                            </div>

                            <div class="col-md-2">

                            <label>Status delegacji:</label><br>
                            <select name="status" style="width: 100%;">

                            <#if statusOption == "">
                            <option selected value="">
                                wszystkie
                            </option>>
                            <#else >
                             <option value="">
                                 wszystkie
                             </option>>
                            </#if>

                            <#if statusOption == "TOACCEPT">
                            <option selected value="TOACCEPT">
                                do akceptacji
                            </option>>
                            <#else>
                            <option value="TOACCEPT">
                                do akceptacji
                            </option>>
                            </#if>

                            <#if statusOption == "ACCEPTED">
                            <option selected value="ACCEPTED">
                                zaakceptowano
                            </option>>
                            <#else>
                            <option value="ACCEPTED">
                                zaakceptowano
                            </option>>
                            </#if>

                            <#if statusOption == "DISCARTED">
                            <option selected value="DISCARTED">
                                brak akceptacji
                            </option>>
                            <#else>
                            <option value="DISCARTED">
                                brak akceptacji
                            </option>>
                            </#if>

                            </select>
                            </div>

                            <div class="col-md-1">
                            <a href="/delegations-web/searchDelegations?date=&name=&surname=&country=&status="
                               class="btn btn-dark" style="width: 100%; height: 100%; font-size: medium; background-color: darkred; color: yellow;" >
                               nie<br>
                               filtruj
                            </a>
                            </div>

                         </div >


                        <div class="col-sm-12">
                            <br>
                        </div>

                        <div class="col-sm-12">
                            <div class="col-md-1">
                            </div>
                            <div class="col-md-10">
                                <button class="btn btn-primary" type="submit" lang="pl-PL" style="width: 100%;">Szukaj</button><br>
                            </div>
                            <div class="col-md-1">
                            </div>
                        </div >

                    </form>

                </div>
            </div>

        <h4 class="card-title">&nbsp;</h4>

        </div>
    </div>
</div>


<div class="container">
    <div class="row">

            <div class="table-responsive-sm" >

            <table class="table col-sm-12 table-bordered table-striped table-condensed cf" style="width: 100%; border: 0px; border-collapse: collapse;">

            <tr style="border: 0px; border-top: 2pt solid black;">
                <th scope="col">ID</th>
                <th scope="col">Data utworzenia</th>
                <th scope="col">Imię i Nazwisko</th>
                <th scope="col">Wyjazd z</th>
                <th scope="col">Status</th>
                <th colspan="2" scope="col">Komentarz</th>
            </tr>
            <tr style="border: 0px; border-bottom: 2pt solid black;">
                <th>&nbsp;</th>
                <th scope="col">Termin</th>
                <th scope="col">Kraj wyjazdu</th>
                <th scope="col">Miasto</th>
                <th scope="col">Firma</th>
                <th scope="col">Adres firmy</th>
                <th scope="col"  colspan="2">Cel wyjazdu</th>


                <tbody>
                <#list delegations as d>
                <#switch d.getDelegationStatus()>
                    <#case "SAVED">
                    <tr class="info" style="border-top: 2pt solid black;">
                        <#break>
                    <#case "TOACCEPT">
                    <tr class="warning" style="border-top: 2pt solid black;">
                        <#break>
                    <#case "ACCEPTED">
                    <tr class="success" style="border-top: 2pt solid black;">
                        <#break>
                    <#case "DISCARTED">
                    <tr class="danger" style="border-top: 2pt solid black;">
                        <#break>
                    <#default>
                    <tr>
                </#switch>

                        <td>${d.getFileLineNumber()}</td>
                        <td>${d.getCreationDate()}</td>
                        <td>${d.getEmployee().getEmployeeName()}&nbsp;${d.getEmployee().getEmployeeSurname()}</td>
                    <td>${d.getStartPoint()}</td>
                    <td>${d.getDelegationStatus().statusType()  }</td>
                    <td colspan="2">

                        <#if d.getDiscardReason()!="null">
                            ${d.getDiscardReason()}
                        <#else>
                        </#if>

                    </td>
                </tr>
                <#switch d.getDelegationStatus()>
                    <#case "SAVED">
                    <tr class="info" style="border-bottom: 2pt solid black;">
                        <#break>
                    <#case "TOACCEPT">
                    <tr class="warning" style="border-bottom: 2pt solid black;">
                        <#break>
                    <#case "ACCEPTED">
                    <tr class="success" style="border-bottom: 2pt solid black;">
                        <#break>
                    <#case "DISCARTED">
                    <tr class="danger" style="border-bottom: 2pt solid black;">
                        <#break>
                    <#default>
                    <tr>
                </#switch>
                <td>&nbsp;</td>
                        <td>${d.getStartDate()}&nbsp-&nbsp${d.getEndDate()}</td>
                        <td>${d.getDestination().getDestinationCountry()}</td>
                        <td>${d.getDestination().getDestinationCity()}</td>
                        <td>${d.getDestination().getDestinationCompany()}</td>
                        <td>${d.getDestination().getDestinationCompanyAddress()}</td>
                        <td>${d.getPurpose()}</td>

                     </tr>

                </#list>
                </tbody>
            </table>

        </div>
    </div>
</div>

<#include "include/footer.ftlh">
<#include "include/scripts.ftlh">

</body>
</html>
