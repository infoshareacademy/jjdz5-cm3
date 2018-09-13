<!DOCTYPE html>
<html lang="pl-PL">
<head>

    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Dodaj delegację</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <link rel="stylesheet" href="/style.css">

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
        <#if data_model == "mapa">
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
        <#else>

            <div class="alert alert-info" role="alert">

            </div>
        </#if>



    </div>

    <button class="btn btn-primary" type="submit" lang="pl-PL" >Zapisz</button>
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
