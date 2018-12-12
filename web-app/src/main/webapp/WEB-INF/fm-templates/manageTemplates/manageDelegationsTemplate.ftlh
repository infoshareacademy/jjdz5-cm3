<#-- manageDelegationsTemplate.ftlh -->

<!DOCTYPE html>
<html lang="pl-PL">

<head>

    <title>Delegacje</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script>

        $(function () {
            const $allReasons = $('input[name="discardReason"]');

            $("tbody tr").each(function () {
                const $row = $(this);
                const $radio = $row.find('input[type="radio"]');
                const $reason = $row.find('input[name="discardReason"]');

                $radio.on("change", function () {
                    $allReasons.prop("required", false);
                    $reason.prop("required", true);
                });
            });
        });

    </script>
<#include "../include/headAndMeta.ftlh">


</head>

<body style="font-family: 'Open Sans', sans-serif">

<#--<#include "../include/navbarHeaderTemplate.ftlh">-->
<#include "../include/settingNavBarRole.ftlh">

<h4 style="color: black; alignment: center; text-align: center;">Zarządzaj delegacjami do akceptacji</h4>
<#include "../include/filterDelegations.ftlh">

<div class="container-fluid">
    <div class="row">
    <div class="table" style="width: 100%;">
    <form action="manageDelegations" method="POST">

    <table class="table col-sm-12 table-bordered table-striped table-condensed cf"
           style="width: 100%; border: 0px; border-collapse: collapse;">

        <tr style="border: 0px; border-top: 2pt solid black; border-bottom: 2pt solid black;">
            <th scope="col">&nbsp;&nbsp;</th>
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
            <th scope="col">Powód <br/>odrzucenia</th>
        </tr>

                <#if delegations?size != 0>
                <tbody>
                    <#list delegations as d>
                        <tr style="border-top: 2pt solid black; border-bottom: 2pt solid black;>
                            <div class=" form-check">
                                <td><input class="form-check-input" type="radio" name="choiceDelegation" id="lista" value="${d.getId()}"></td>
                                <td>${d.getId()}</td>
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
                                <td><input type="text" name="discardReason" placeholder="podaj powód"></td>
                            </div>
                        </tr>
                    </#list>
                    </tbody>
                </#if>
        </table>

                        <#if delegations?size != 0>

                        <button class="btn btn-primary" type="submit" lang="pl-PL" value="accept" name="choiceButton">
                            Akceptuj
                        </button>

                        <button class="btn btn-primary" type="submit" lang="pl-PL" value="discard" name="choiceButton"
                                id="btn">
                            Odrzuć
                        </button>
                         * Jak odrzucasz koniecznie podaj powód!!!!
                        </#if>
        </form>
    </div>
</div>
</div>

<hr/>

<#include "../include/footer.ftlh">
<#include "../include/scripts.ftlh">

</body>
</html>
