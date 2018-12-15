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

<#--<#include "../include/navbarLogoHeaderTemplate.ftlh">-->
<#include "../include/settingNavBarRole.ftlh">
<div class="container">
<div class="row">
<div class="col-md-12" style="width: 300px">
                <#if mapa?is_hash>
                    <ul class="list-group">
                        <li class="list-group-item">Imię: ${mapa.name}</li>
                        <li class="list-group-item">Nazwisko: ${mapa.surname}</li>
                        <li class="list-group-item">Email ${mapa.email}</li>
                        <li class="list-group-item">Manager: ${mapa.manager}</li>
                        <li class="list-group-item">Administrator ${mapa.admin}</li>

                    </ul>
                </div>
            </div>
        </div>

        <div class="container" style="width: 100%; text-align: center">

                <form class="needs-validation" action="/delegations-web/userSave" method="POST" novalidate>
                    <button class="btn btn-secondary" type="submit" lang="pl-PL">Zatwierdź</button>
                </form>
                    <form class="needs-validation" action="/delegations-web/admin" method="GET" novalidate>
                        <button class="btn btn-secondary" type="submit" lang="pl-PL" style="margin: 5px">powrót</button>
                    </form>
                <#else>
                <div class="alert alert-secondary" role="alert" style="margin-top: 115px; text-align: center">
                    <h4>${mapa}</h4>
                </div>
                <form class="needs-validation" action="/delegations-web/admin" method="GET" novalidate>
                    <button class="btn btn-secondary" type="submit" lang="pl-PL" style="margin: 5px">Powrót</button>
                </form>
                </#if>


<#include "../include/footer.ftlh">
<#include "../include/scripts.ftlh">

</body>
</html>