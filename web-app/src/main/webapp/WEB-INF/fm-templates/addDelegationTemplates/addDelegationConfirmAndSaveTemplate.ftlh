<#-- addDelegationConfirmAndSaveTemplate.ftlh -->

<!DOCTYPE html>
<html lang="pl-PL">

    <head>

        <title>Delegacje</title>

<#include "../include/headAndMeta.ftlh">

        <style>
            body {
                width: 100%;
                text-align:center;
                display:inline-block;
            }
            li {
                height: 35px;
            }
        </style>

    </head>

    <body style="font-family: 'Open Sans', sans-serif">

<#include "../include/navbarLogoHeaderTemplate.ftlh">
        <div class="container">
            <div class="row">
                <div class="col-md-12" style="width: 300px">
                <#if mapa?is_hash>
                    <ul class="list-group">
                        <li class="list-group-item">Imię: ${mapa.name}</li>
                        <li class="list-group-item">Nazwisko: ${mapa.surname}</li>
                        <li class="list-group-item">Data od: ${mapa.startDate}</li>
                        <li class="list-group-item">Data do: ${mapa.endDate}</li>
                        <li class="list-group-item">Kraj: ${mapa.country}</li>
                        <li class="list-group-item">Miasto: ${mapa.city}</li>
                        <li class="list-group-item">Firma: ${mapa.company}</li>
                        <li class="list-group-item">Adres Firm: ${mapa.companyAdres}</li>
                        <li class="list-group-item">Cel wyjazdu: ${mapa.purpose}</li>
                        <li class="list-group-item">Miejsce startu: ${mapa.startPoint}</li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="container" style="width: 100%; text-align: center">

                <form class="needs-validation" action="delegation-save" method="POST" novalidate>
                    <button class="btn btn-secondary" type="submit" lang="pl-PL">Wyślij do akceptacji kierownika</button>
                </form>
                <form class="needs-validation" action="/delegations-web/DelegationAddForm" method="GET" novalidate>
                    <button class="btn btn-secondary" type="submit" lang="pl-PL" style="margin: 5px">powrót</button>
                </form>
                <#else>
                <div class="alert alert-secondary" role="alert" style="margin-top: 115px; text-align: center">
                   <h4>${mapa}</h4>
                </div>
                <form class="needs-validation" action="/delegations-web/DelegationAddForm" method="GET" novalidate>
                    <button class="btn btn-secondary" type="submit" lang="pl-PL" style="margin: 5px">Powrót</button>
                </form>
                </#if>
        </div>

<#include "../include/footer.ftlh">
<#include "../include/scripts.ftlh">

    </body>
</html>