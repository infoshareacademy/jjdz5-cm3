<#-- afterImportTemplate.ftlh -->

<!DOCTYPE html>
<html lang="pl-PL">

<head>

    <title>Delegacje</title>

    <meta http-equiv="refresh" content="2;url=http://localhost:8080/delegations-web/mainMenu"/>

<#include "../include/headAndMeta.ftlh">

</head>

<body style="font-family: 'Open Sans', sans-serif">

<#include "../include/navbarHeaderTemplate.ftlh">

<div class="container" style="margin-top: 115px">
    <div class="row">
        <div class="col-md-12" style="text-align: center">
            <div class="alert alert-secondary" role="alert" style="width:60%;margin: auto">
                <h4 class="alert-heading" style="text-align: center"><b>${mapa}. Zostaniesz przekierowany na stronę
                    główną.</b></h4>
            </div>

        </div>
    </div>
</div>

<#include "../include/footer.ftlh">
<#include "../include/scripts.ftlh">

</body>
</html>
