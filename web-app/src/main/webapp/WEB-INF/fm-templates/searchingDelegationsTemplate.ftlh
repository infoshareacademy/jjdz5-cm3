<#-- previewMyDelegations.ftlh -->

<!DOCTYPE html>
<html lang="pl-PL">

    <head>

    <title>Delegacje</title>

<#include "include/headAndMeta.ftlh">

    </head>


    <body style="font-family: 'Open Sans', sans-serif">

<#include "include/navbarHeaderTemplate.ftlh">

    <h4 style="color: black; alignment: center; text-align: center;">Wyszukiwanie delegacji</h4>

<#include "include/filterDelegations.ftlh">

        <div class="container">
            <div class="row">

                    <div class="table-responsive-sm" style="width: 100%;">

                    <table class="table col-sm-12 table-bordered table-striped table-condensed cf"
                           style="width: 100%; border: 0px; border-collapse: collapse;">

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
                        <th scope="col" colspan="2">Cel wyjazdu</th>

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

<#include "include/filterDelegationsStatus.ftlh">

                        <tr style="border-bottom: 2pt solid black;">
                        <td>&nbsp;</td>
                        <td>${d.getStartDate()}&nbsp-&nbsp${d.getEndDate()}</td>
                        <td>${d.getDestination().getDestinationCountry()}</td>
                        <td>${d.getDestination().getDestinationCity()}</td>
                        <td>${d.getDestination().getDestinationCompany()}</td>
                        <td>${d.getDestination().getDestinationCompanyAddress()}</td>
                        <td>${d.getPurpose()}</td>

                        </tr>
                        </#list>

                    </table>

                </div>
            </div>
        </div>

        <hr />

    <#include "include/footer.ftlh">
    <#include "include/scripts.ftlh">

    </body>
</html>
