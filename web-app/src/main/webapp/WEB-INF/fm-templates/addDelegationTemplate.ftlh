<!DOCTYPE html>
<html lang="pl-PL">
<head>

    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Dodaj delegację</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <link rel="stylesheet" href="style.css">

</head>

<body>
<header>

</header>
<div style="width: 1100px; margin-left: auto;margin-right: auto">
    <div class="jumbotron jumbotron-fluid bg-info text-white text-center">
        <div class="container">
            <h1 class="display-1">Dodawanie delegacji </h1>
            <p class="lead"> by CM3</p>
        </div>
    </div>
    <div id="container-fluid">
        <form class="needs-validation" action="delegation-add" method="GET" novalidate>
            <div class="form-row">

                <div class="col-md-4 mb-3 lg-4">
                    <label for="validationCustom01">Imię</label>
                    <input type="text" class="form-control" id="validationCustom01" placeholder="Imię"
                           name="name" value="Marek" required>
                    <#include "formValidationDivCode.ftlh">
                </div>

                <div class="col-md-4 mb-3 lg-4">
                    <label for="validationCustom02">Nazwisko</label>
                    <input type="text" class="form-control" id="validationCustom02" placeholder="Nazwisko"
                           name="surname" value="Kalkowski" required>
                    <#include "formValidationDivCode.ftlh">
                </div>
            </div>

            <div class="alert alert-info" role="alert">
                Dane wyjazdu
            </div>

            <div class="form-row">

                <div class="col-md-4 mb-3">
                    <label for="validationCustom01">Data wyjazdu</label>
                    <input type="date" class="form-control" id="validationCustom01" placeholder="Data od"
                           name="startDate" pattern="[0-9]{2}-[0-9]{2}-[0-9]{4}" value="12.10.2018" required>
                    <#include "formValidationDivCode.ftlh">
                </div>

                <div class="col-md-4 mb-3">
                    <label for="validationCustom02">Data powrotu</label>
                    <input type="date" class="form-control" id="validationCustom02" placeholder="Data do"
                           name="endDate" value="14.10.2018" required>
                    <#include "formValidationDivCode.ftlh">
                </div>
            </div>


            <div class="form-row">
                <div class="col-md-4 mb-3">
                    <label for="validationCustomCity">Kraj</label>

                    <input type="text" class="form-control" id="validationCustomCity" placeholder="Kraj dokoąd jedziesz"
                           name="country" value="Polska" required>
                        <#include "formValidationDivCode.ftlh">

                </div>
                <div class="col-md-4 mb-3">
                    <label for="validationCustom03">Miasto</label>
                    <input type="text" class="form-control" id="validationCustom03" placeholder="Miasto"
                           name="city" value="Elbląg" required>
                   <#include "formValidationDivCode.ftlh">
                </div>
            </div>

            <div class="form-row">
                <div class="col-md-4 mb-3">
                    <label for="validationCustom04">Firma</label>
                    <input type="text" class="form-control" id="validationCustom04" placeholder="Firma"
                           name="company" value="StacjaNatura" required>
                    <#include "formValidationDivCode.ftlh">
                </div>

                <div class="col-md-4 mb-3">
                    <label for="validationCustom05">Adres firmy</label>
                    <input type="text" class="form-control" id="validationCustom05" placeholder="Adres firmy"
                           name="companyAdres" value="Elbląg" required>
                         <#include "formValidationDivCode.ftlh">
                </div>
            </div>

            <div class="form-row">
                <div class="col-md-4 mb-3">
                    <label for="validationCustom04">Cel wyjazdu</label>
                    <input type="text" class="form-control" id="validationCustom04" placeholder="Cel wyjazdu"
                           name="purpose" value="Tak sobie" required>
                    <#include "formValidationDivCode.ftlh">
                </div>

                <div class="col-md-4 mb-3">
                    <label for="validationCustom05">Miejsce startu</label>
                    <input type="text" class="form-control" id="validationCustom05" placeholder="Miejsce startu"
                           name="startPoint" value="Gdańsk" required>
                         <#include "formValidationDivCode.ftlh">
                </div>
            </div>

    </div>

    <button class="btn btn-primary" type="submit" lang="pl-PL" >Zatwierdź</button>
    </form>
</div>
</div>

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


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>
