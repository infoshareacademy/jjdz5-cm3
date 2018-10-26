<#-- addDelegationConfirmAndSaveTemplate.ftlh -->

<!DOCTYPE html>
<html lang="pl-PL">

    <head>

        <title>Delegacje</title>

        <meta http-equiv="refresh" content="2;url=http://localhost:8080/delegations-web/mainMenu"/>

<#include "../include/headAndMeta.ftlh">

    </head>

    <body style="font-family: 'Open Sans', sans-serif">
<#--
        <header>
            <nav class="navbar navbar-default">
                <div class="container">
                    <div class="navbar-header">
                        <h4 style="color: gray">Delegacja wysłana do akceptacji</h4>
                    </div>
                </div>
            </nav>
        </header>
-->
<#include "../include/navbarLogoHeaderTemplate.ftlh">
        <h4 style="color: black; alignment: center; text-align: center;">Delegacja wysłana do akceptacji</h4>
            <div class="alert alert-success" role="alert" style="width:60%;margin: auto">
                <h4 class="alert-heading" style="text-align: center">Nastąpi przekierowanie na stronę główną.</h4>
            </div>

<#include "../include/scripts.ftlh">
<#include "../include/footer.ftlh">

    </body>
</html>
