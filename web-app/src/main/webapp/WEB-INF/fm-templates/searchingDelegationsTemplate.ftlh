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

<div class="container">
    <div class="row">

        <div class="col-sm-12">

            <form action="/delegations-web/searchDelegations" method="get">

                <label>Data utworzenia:</label>
                <select name="date">
                     <#list dates as d>
                         <#if datesOption == d >
                         <option selected>${d}</option>
                         <#else>
                         <option>${d}</option>
                         </#if>
                     </#list>
                </select>

                <label>Imię:</label>
                <select name="name">
                     <#list names as n>
                         <#if namesOption == n >
                         <option selected>${n}</option>
                         <#else>
                         <option>${n}</option>
                         </#if>
                     </#list>
                </select>

                <label>Nazwisko:</label>
                <select name="surname">
                     <#list surnames as s>
                         <#if surnamesOption == s >
                         <option selected>${s}</option>
                         <#else>
                         <option>${s}</option>
                         </#if>
                     </#list>
                </select>

                <label>Kraj wyjazdu:</label>
                <select name="country">
                     <#list countries as s>
                         <#if countriesOption == s >
                             <option selected>${s}</option>
                         <#else>
                             <option>${s}</option>
                         </#if>
                     </#list>
                </select>

                <br>

                <label>Status delegacji:</label>
                <select name="status">

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

                <button class="btn btn-primary" type="submit" lang="pl-PL" >Szukaj</button>


            </form>

        </div >

    </div>
</div>



<div class="container">
    <div class="row">
        <div class="col-md-12">

            <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Data <br/> utworzenia</th>
                <th scope="col">Imię</th>
                <th scope="col">Nazwisko</th>
                <th scope="col">Data <br/> od</th>
                <th scope="col">Data <br/> do</th>
                <th scope="col">Kraj <br/> wyjazdu</th>
                <th scope="col">Miasto</th>
                <th scope="col">Firma</th>
                <th scope="col">Adres <br/> firmy</th>
                <th scope="col">Cel <br/> wyjazdu</th>
                <th scope="col">Wyjazd z</th>
                <th scope="col">Status</th>
                <th scope="col">Komentarz</th>

            </tr>
            </thead>

                <tbody>
                <#list delegations as d>
                <#switch d.getDelegationStatus()>
                    <#case "SAVED">
                    <tr class="info">
                        <#break>
                    <#case "TOACCEPT">
                    <tr class="warning">
                        <#break>
                    <#case "ACCEPTED">
                    <tr class="success">
                        <#break>
                    <#case "DISCARTED">
                    <tr class="danger">
                        <#break>
                    <#default>
                    <tr>
                </#switch>

                        <td>${d.getFileLineNumber()}</td>
                        <td>${d.getCreationDate()}</td>
                        <td>${d.getEmployee().getEmployeeName()}</td>
                        <td>${d.getEmployee().getEmployeeSurname()}</td>
                        <td>${d.getStartDate()}</td>
                        <td>${d.getEndDate()}</td>
                        <td>${d.getDestination().getDestinationCountry()}</td>
                        <td>${d.getDestination().getDestinationCity()}</td>
                        <td>${d.getDestination().getDestinationCompany()}</td>
                        <td>${d.getDestination().getDestinationCompanyAddress()}</td>
                        <td>${d.getPurpose()}</td>
                        <td>${d.getStartPoint()}</td>
                        <td>${d.getDelegationStatus().statusType()  }</td>
                        <td>

                        <#if d.getDiscardReason()!="null">
                            ${d.getDiscardReason()}
                        <#else>
                        </#if>

                        </td>

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
