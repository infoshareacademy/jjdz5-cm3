<#-- addDelegationTemplate.ftlh -->

<!DOCTYPE html>
<html lang="pl-PL">

    <head>

        <title>Dodaj delegację</title>

        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">

<#include "../include/headAndMeta.ftlh">

    <#--bootstrap

        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
                integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
                crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
              integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        -->
        <style>
            form {
                text-align: center;
                display: inline-block;
            }
        </style>

    </head>

    <body style="font-family: 'Open Sans', sans-serif">

        <header>
            <nav class="navbar navbar-default">
                <div class="container">
                    <div class="navbar-header">
                        <h4 style="color: gray">Dodaj delegację</h4>
                    </div>
                </div>
            </nav>
        </header>

        <div class="container" style="width: 100%; text-align: center">
            <form class="needs-validation" action="delegation-add" method="POST" novalidate>
                <div class="form-row">
                    <div class="col-md-6">
                        <label for="validationCustom01">Imię</label>
                        <input type="text" class="form-control" id="validationCustom01" placeholder="Imię"
                               name="name" value="Cmtrzy" required>
<#include "../include/formValidationDivCode.ftlh">
                    </div>
                    <div class="col-md-6">
                        <label for="validationCustom02">Nazwisko</label>
                        <input type="text" class="form-control" id="validationCustom02" placeholder="Nazwisko"
                               name="surname" value="ToZgranaPaka" required>
<#include "../include/formValidationDivCode.ftlh">
                    </div>
                </div>
                <div class="alert alert-secondary" role="alert" style="margin-top: 15px">
                    Dane wyjazdu
                </div>

                <div class="form-row">
                    <div class="col-md-6">
                        <label for="validationCustom01">Data wyjazdu</label>
                        <input type="date" class="form-control" id="validationCustom01" placeholder="Data od"
                               name="startDate" pattern="[0-9]{2}-[0-9]{2}-[0-9]{4}" required>
<#include "../include/formValidationDivCode.ftlh">
                    </div>
                    <div class="col-md-6">
                        <label for="validationCustom02">Data powrotu</label>
                        <input type="date" class="form-control" id="validationCustom02" placeholder="Data do"
                               name="endDate" required>
<#include "../include/formValidationDivCode.ftlh">
                    </div>
                </div>

                <div class="form-row">
                    <div class="col-md-6">
                        <label for="validationCustomCity">Kraj</label>
<#include "../include/countryList.ftlh">
<#include "../include/formValidationDivCode.ftlh">
                    </div>
                    <div class="col-md-6">
                        <label for="validationCustom03">Miasto</label>
                        <input type="text" class="form-control" id="validationCustom03" placeholder="Miasto"
                               name="city" value="Gdańsk" required>
<#include "../include/formValidationDivCode.ftlh">
                    </div>
                </div>

                <div class="form-row">
                    <div class="col-md-6">
                        <label for="validationCustom04">Firma</label>
                        <input type="text" class="form-control" id="validationCustom04" placeholder="Firma"
                               name="company" value="InfoShareAcademy" required>
<#include "../include/formValidationDivCode.ftlh">
                    </div>

                    <div class="col-md-6">
                        <label for="validationCustom05">Adres firmy</label>
                        <input type="text" class="form-control" id="validationCustom05" placeholder="Adres firmy"
                               name="companyAdres" value="OliwiaBusinesCenter" required>
<#include "../include/formValidationDivCode.ftlh">
                    </div>
                </div>
                <div class="form-row">
                    <div class="col-md-6">
                        <label for="validationCustom04">Cel wyjazdu</label>
                        <input type="text" class="form-control" id="validationCustom04" placeholder="Cel wyjazdu"
                               name="purpose" value="Prezentacja" required>
<#include "../include/formValidationDivCode.ftlh">
                    </div>

                    <div class="col-md-6">
                        <label for="validationCustom05">Miejsce startu</label>
                        <input type="text" class="form-control" id="validationCustom05" placeholder="Miejsce startu"
                               name="startPoint" value="Gdańsk" required>
<#include "../include/formValidationDivCode.ftlh">
                    </div>
                </div>
                <button class="btn btn-secondary" type="submit" lang="pl-PL" style="margin-top: 5px">Zatwierdź</button>
            </form>
        </div>

        <div class="container" style="width: 100%; text-align: center">
            <div class="row">
                <div class="col-md-12">
                    <form action="/delegations-web/mainMenu">
                        <button class="btn btn-secondary" type="submit" lang="pl-PL" style="margin-top: 5px">powrót</button>
                    </form>
                </div>
            </div>
        </div>



<#include "../include/footer.ftlh">
<#include "../include/scripts.ftlh">

    </body>
</html>
