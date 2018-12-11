<#-- addDelegationTemplate.ftlh -->

<!DOCTYPE html>
<html lang="pl-PL">

<head>

    <title>Dodaj delegację</title>

<#include "../include/headAndMeta.ftlh">

    <style>
        form {
            text-align: center;
            display: inline-block;
        }
    </style>


    <script>
        function setup() {
            var dp = $('.base').datepicker().data('datepicker');
            dp.focusDate = new Date(Date.UTC(2013, 7, 14));
            dp.update();
            $('.date').datepicker({
                format: 'yyyy-mm-dd'
            });
            $('.inline').datepicker();
        }
    </script>

</head>

<body data-capture=".base, .date, .datepicker" style="font-family: 'Open Sans', sans-serif">

<#include "../include/navbarLogoHeaderTemplate.ftlh">
<h4 style="color: black; alignment: center; text-align: center;">Dodaj delegację</h4>

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
                <input type="date" class="form-control" id="validationCustom01"
                       name="startDate" required>
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
