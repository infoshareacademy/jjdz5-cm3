<!DOCTYPE html>
<html lang="pl-PL">
<head>

    <title>Main menu</title>

<#include "../include/headAndMeta.ftlh">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
</head>

<body style="font-family: 'Open Sans', sans-serif">
<#include "../include/navbarHeaderTemplate.ftlh">

<h4 style="color: black; alignment: center; text-align: center;">Zarządzaj delegacjami do akceptacji</h4>
<#include "../include/filterDelegations.ftlh">

<div class="container">
    <div class="row">
        <div class="table-responsive-sm" >
            <form action="manageDelegations" method="POST">

                <table class="table col-sm-12 table-bordered table-striped table-condensed cf" style="width: 100%; border: 0px; border-collapse: collapse;">

                    <tr style="border: 0px; border-top: 2pt solid black;">

                        <th scope="col">ID</th>
                        <th scope="col">Data utworzenia</th>
                        <th scope="col">Imię i Nazwisko</th>
                        <th scope="col">Wyjazd z</th>
                        <th colspan="3" scope="col">Komentarz</th>
                    </tr>
                    <tr style="border: 0px; border-bottom: 2pt solid black;">
                        <th>&nbsp;</th>
                        <th scope="col">Termin</th>
                        <th scope="col">Kraj wyjazdu</th>
                        <th scope="col">Miasto</th>
                        <th scope="col">Firma</th>
                        <th scope="col">Adres firmy</th>
                        <th scope="col" colspan="2">Cel wyjazdu</th>

                    </tr>

                    <#if delegations?size != 0>

                        <tbody>
                            <#list delegations as d>
                            <tr class="warning" style="border-top: 2pt solid black;">


                                    <td>${d.getFileLineNumber()}</td>
                                    <td>${d.getCreationDate()}</td>
                                    <td>${d.getEmployee().getEmployeeName()}&nbsp;${d.getEmployee().getEmployeeSurname()}</td>
                                    <td>${d.getStartPoint()}</td>
                                    <td colspan="3" scope="col"><input type="text" name="discardReason" placeholder="Jeżeli odrzucasz podaj powód" style="width: 100%"></td>

                            </tr>
                            <tr class="warning" style="border-bottom: 2pt solid black;">

                                    <td>
                                        <input class="form-check-input" type="radio" name="choiceDelegation" id="lista"
                                               value="${d.getFileLineNumber()}">
                                    </td>

                                    <td>${d.getStartDate()}&nbsp-&nbsp${d.getEndDate()}</td>
                                    <td>${d.getDestination().getDestinationCountry()}</td>
                                    <td>${d.getDestination().getDestinationCity()}</td>
                                    <td>${d.getDestination().getDestinationCompany()}</td>
                                    <td>${d.getDestination().getDestinationCompanyAddress()}</td>
                                    <td>${d.getPurpose()}</td>

                            </tr>

                            </#list>
                        </tbody>
                    </#if>
                </table>

                <#if delegations?size != 0>

                <button class="btn btn-primary" type="submit" lang="pl-PL" value="accept" name="choiceButton">
                    Akceptuj
                </button>

                <button class="btn btn-primary" type="submit" lang="pl-PL" value="discard" name="choiceButton" id="btn">
                    Odrzuć
                </button>
                 * Jak odrzucasz koniecznie podaj powód!!!!
                </#if>
            </form>
        </div>
    </div>
</div>
<hr />
<#include "../include/footer.ftlh">
<#include "../include/scripts.ftlh">

</body>

</html>
