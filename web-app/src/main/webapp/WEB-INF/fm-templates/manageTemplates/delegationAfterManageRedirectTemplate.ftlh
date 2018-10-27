<#-- delegationAfterManageRedirectTemplate.ftlh -->

<!DOCTYPE html>
<html lang="pl-PL">

    <head>
        <meta http-equiv="refresh" content="2;url=http://localhost:8080/delegations-web/manageDelegations?date=&name=&surname=&country="/>

        <title>Delegacje</title>

<#include "../include/headAndMeta.ftlh">

    </head>

    <body style="font-family: 'Open Sans', sans-serif">
<#--
    <header>
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <h4 style="color: gray"> Status operacji</h4>
                </div>
            </div>
        </nav>
    </header>
-->

<#include "../include/navbarLogoHeaderTemplate.ftlh">

    <h4 style="color: black; alignment: center; text-align: center;">Status operacji</h4>

    <#if mapa == "accept" >
            <div class="alert alert-success" role="alert" style="width:60%;margin: auto; text-align: center">
                <h4 class="alert-heading">SUPER delegacja zaakceptowana! <br/>Nastąpi przekierowanie zarządzania delegacjami. </h4>
            </div>
    <#elseif mapa == "discard">
            <div class="alert alert-success" role="alert" style="width:60%;margin: auto; text-align: center;">
                <h4 class="alert-heading">Szkoda Delegacja odrzucona! <br/>Nastąpi przekierowanie zarządzania delegacjami. </h4>
            </div>
    <#else>
            <div class="alert alert-primary" role="alert" style="width:60%;margin: auto; text-align: center">
                <h4 class="alert-heading">Ups!! Nic nie zaznaczyłeś!!! <br/> Spróbuj jeszcze raz.... </h4>
            </div>
    </#if>

<#include "../include/scripts.ftlh">
<#include "../include/footer.ftlh">

    </body>
</html>
