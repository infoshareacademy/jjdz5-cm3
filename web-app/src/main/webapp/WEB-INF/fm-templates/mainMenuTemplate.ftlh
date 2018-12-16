<#-- mainMenuTemplate.ftlh -->

<!DOCTYPE html>

<html lang="pl-PL">

<head>

    <title>Delegacje</title>

<#include "include/headAndMeta.ftlh">

</head>

<body style="font-family: 'Open Sans', sans-serif; text-align: center">

<#include "include/settingNavBarRole.ftlh">

<div class="container" style="width: 30%; text-align: center; margin-top: 100px">
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading">Witaj użytkowniku!</div>
                <div class="panel-body">
                    <table class="table table-borderless">
                        <thead>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">Imię i nazwisko</th>
                            <td>${mapa}</td>
                        </tr>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<#include "include/footer.ftlh">
<#include "include/scripts.ftlh">

</body>
</html>
