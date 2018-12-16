<!DOCTYPE html>
<html lang="pl-PL">

<head>
    <meta http-equiv="refresh"
          content="2;url=http://localhost:8080/delegations-web/manageDelegations?date=&name=&surname=&country="/>

    <title>Delegacje</title>

<#include "../include/headAndMeta.ftlh">

</head>

<body style="font-family: 'Open Sans', sans-serif">

<#--<#include "../include/navbarLogoHeaderTemplate.ftlh">-->
<#include "../include/settingNavBarRole.ftlh">

<div class="container" style="margin-top: 115px">
    <div class="row">
        <div class="col">
             <#if mapa == "accept" >
                 <div class="alert alert-secondary" role="alert" style="width:60%;margin: auto; text-align: center">
                     <h4 class="alert-heading"><b>ZAAKCEPTOWANO</b><br/>Nastąpi przekierowanie zarządzania
                         delegacjami. </h4>
                 </div>
             <#elseif mapa == "discard">
            <div class="alert alert-secondary" role="alert" style="width:60%;margin: auto; text-align: center;">
                <h4 class="alert-heading"><b>ODRZUCONO</b><br/>Nastąpi przekierowanie zarządzania
                    delegacjami. </h4>
            </div>
             <#else>
            <div class="alert alert-secondary" role="alert" style="width:60%;margin: auto; text-align: center">
                <h4 class="alert-heading"><b>BRAK ZAZNACZENIA</b><br/> Spróbuj jeszcze raz.... </h4>
            </div>
             </#if>
        </div>
    </div>
</div>

<#include "../include/scripts.ftlh">
<#include "../include/footer.ftlh">

</body>
</html>