<#-- mainMenuTemplate.ftlh -->

<!DOCTYPE html>

<html lang="pl-PL">

<head>

    <title>Delegacje</title>

<#include "include/headAndMeta.ftlh">

</head>

<body style="font-family: 'Open Sans', sans-serif; text-align: center">

<#include "include/navbarHeaderTemplate.ftlh">

<div class="container" style="width: 50%; text-align: center; margin-top: 100px">
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
                        <tr>
                            <th scope="row">Stanowisko</th>
                            <td>Kierownik działu HR</td>
                        </tr>
                        <tr>
                            <th scope="row">Nazwa firmy</th>
                            <td>Firma A</td>
                        </tr>
                        <tr>
                            <th scope="row">Adres firmy</th>
                            <td>adres firmy A</td>
                        </tr>
                        <tr>
                            <th scope="row">Ilość wniosków:</th>
                            <td>0</td>
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
