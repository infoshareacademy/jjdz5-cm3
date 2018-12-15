<!DOCTYPE html>
<html lang="pl-PL">

<head>

    <title>Dodaj delegację</title>

<#include "../include/headAndMeta.ftlh">

    <style>
        .signup_txt {
            display: none;
        }

        #MyForm {
            display: none;
            width: 600px;
            border: 1px solid #ccc;
            padding: 14px;
            background: #ececec;
        }

        button {
            margin-bottom: 10px;
        }

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
    <script>


        $(document).ready(function () {
            $('#Mybtn').click(function () {
                $('#MyForm').toggle(500);
            });
        });

    </script>

</head>

<body data-capture=".base, .date, .datepicker" style="font-family: 'Open Sans', sans-serif">


<#include "../include/settingNavBarRole.ftlh">
<div class="container" style="width: 100%; text-align: center">
    <button id="Mybtn" class="btn btn-primary" style="text-align: center">Dodaj pracownika</button>
</div>
<div class="container" style="width: 100%; text-align: center" id="MyForm">
    <form class="needs-validation" action="userAdd" method="POST" novalidate>
        <div class="form-row">
            <div class="col-md-4">
                <label for="validationCustom01">Imię</label>
                <input type="text" class="form-control " id="validationCustom01" placeholder="Imię"
                       name="name">
<#include "../include/formValidationDivCode.ftlh">
            </div>
            <div class="col-md-4">
                <label for="validationCustom02">Nazwisko</label>
                <input type="text" class="form-control" id="validationCustom02" placeholder="Nazwisko"
                       name="surname">
<#include "../include/formValidationDivCode.ftlh">
            </div>


            <div class="col-md-4">
                <label for="validationCustom01">Email</label>
                <input type="email" class="form-control" id="validationCustom01" placeholder="Email"
                       name="email" required>
<#include "../include/formValidationDivCode.ftlh">
            </div>
        </div>

        <div class="form-row">
            <div class="col-md-6"><br>
                <label for="validationCustom02">Manager</label>
                <input type="checkbox" id="validationCustom02"
                       name="manager" value="true">
<#include "../include/formValidationDivCode.ftlh">
            </div>

            <div class="col-md-6"><br>
                <label for="validationCustom03">Administrator</label>
                <input type="checkbox" id="validationCustom03"
                       name="admin" value="true">
<#include "../include/formValidationDivCode.ftlh">
            </div>
        </div>

        <button class="btn btn-secondary" type="submit" lang="pl-PL" style="margin-top: 5px">Zatwierdź</button>
</div>
</form>
</div>
<#include "../include/footer.ftlh">
<#include "../include/scripts.ftlh">

</body>
</html>