<!DOCTYPE html>
<html lang="pl-PL">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Dodaj delegację</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">


<#--bootstrap
    -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <style>
       form {
             text-align:center;
            display:inline-block;
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
        <form class="needs-validation" action="delegation-add" method="GET"  novalidate>
            <div class="form-row">
                <div class="col-md-6">
                    <label for="validationCustom01">Imię</label>
                    <input type="text" class="form-control" id="validationCustom01" placeholder="Imię"
                           name="name" value="Marek" required>
                    <#include "include/formValidationDivCode.ftlh">
                </div>
                <div class="col-md-6">
                    <label for="validationCustom02">Nazwisko</label>
                    <input type="text" class="form-control" id="validationCustom02" placeholder="Nazwisko"
                           name="surname" value="Kalkowski" required>
                    <#include "include/formValidationDivCode.ftlh">
                </div>
            </div>
            <div class="alert alert-secondary" role="alert" style="margin-top: 15px">
                Dane wyjazdu
            </div>
            <div class="form-row">
                <div class="col-md-6">
                    <label for="validationCustom01">Data wyjazdu</label>
                    <input type="date" class="form-control" id="validationCustom01" placeholder="Data od"
                           name="startDate" pattern="[0-9]{2}-[0-9]{2}-[0-9]{4}" value="12.10.2018" required>
                    <#include "include/formValidationDivCode.ftlh">
                </div>
                <div class="col-md-6">
                    <label for="validationCustom02">Data powrotu</label>
                    <input type="date" class="form-control" id="validationCustom02" placeholder="Data do"
                           name="endDate" value="14.10.2018" required>
                    <#include "include/formValidationDivCode.ftlh">
                </div>
            </div>
            <div class="form-row">
                <div class="col-md-6">
                    <label for="validationCustomCity">Kraj</label>
                    <#include "include/countryList.ftlh">
                <#--<input type="text" class="form-control" id="validationCustomCity" placeholder="Kraj dokoąd jedziesz"-->
                <#--name="country" value="Polska" required>-->
                        <#include "include/formValidationDivCode.ftlh">
                </div>
                <div class="col-md-6">
                    <label for="validationCustom03">Miasto</label>
                    <input type="text" class="form-control" id="validationCustom03" placeholder="Miasto"
                           name="city" value="Elbląg" required>
                   <#include "include/formValidationDivCode.ftlh">
                </div>
            </div>
            <div class="form-row">
                <div class="col-md-6">
                    <label for="validationCustom04">Firma</label>
                    <input type="text" class="form-control" id="validationCustom04" placeholder="Firma"
                           name="company" value="StacjaNatura" required>
                    <#include "include/formValidationDivCode.ftlh">
                </div>

                <div class="col-md-6">
                    <label for="validationCustom05">Adres firmy</label>
                    <input type="text" class="form-control" id="validationCustom05" placeholder="Adres firmy"
                           name="companyAdres" value="Elbląg" required>
                         <#include "include/formValidationDivCode.ftlh">
                </div>
            </div>
            <div class="form-row">
                <div class="col-md-6">
                    <label for="validationCustom04">Cel wyjazdu</label>
                    <input type="text" class="form-control" id="validationCustom04" placeholder="Cel wyjazdu"
                           name="purpose" value="Tak sobie" required>
                    <#include "include/formValidationDivCode.ftlh">
                </div>

                <div class="col-md-6">
                    <label for="validationCustom05">Miejsce startu</label>
                    <input type="text" class="form-control" id="validationCustom05" placeholder="Miejsce startu"
                           name="startPoint" value="Gdańsk" required>
                         <#include "include/formValidationDivCode.ftlh">
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
<#include "include/footer.ftlh">
<script>
    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (function () {
        'use strict';
        window.addEventListener('load', function () {
            // Fetch all the forms we want to apply custom Bootstrap validation styles to
            var forms = document.getElementsByClassName('needs-validation');
            // Loop over them and prevent submission
            var validation = Array.prototype.filter.call(forms, function (form) {
                form.addEventListener('submit', function (event) {
                    if (form.checkValidity() === false) {
                        event.preventDefault();
                        event.stopPropagation();
                    }
                    form.classList.add('was-validated');
                }, false);
            });
        }, false);
    })();
</script>
<#include "include/scripts.ftlh">
</body>
</html>