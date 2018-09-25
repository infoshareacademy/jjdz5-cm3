<!DOCTYPE html>
<html lang="pl-PL">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Podsumowanie delegacji</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <link rel="stylesheet" href="/WEB-INF/fm-templates/css/custom.css">
<#--bootstrap
    -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <style>
        .footer {
            position: absolute;
            right: 0;
            bottom: 0;
            left: 0;
            padding: 2px;
            background-color: #efefef;
            text-align: center;
            height: 25px;
        }
        body {
            width: 100%;
            text-align:center;
            display:inline-block;
        }
        li {
            height: 35px;
        }
    </style>
</head>
<body style="font-family: 'Open Sans', sans-serif">
<header>
    <nav class="navbar navbar-default">
        <div class="container">
            <div class="navbar-header">
                <h4 style="color: gray">Podsumowanie delegacji</h4>
            </div>
        </div>
    </nav>
</header>
<div class="container">
    <div class="row">
        <div class="col-md-12" style="width: 300px">
        <#if mapa?is_hash>
            <ul class="list-group">
                <li class="list-group-item">Imię: ${mapa.name}</li>
                <li class="list-group-item">Nazwisko: ${mapa.surname}</li>
                <li class="list-group-item">Data od: ${mapa.startDate}</li>
                <li class="list-group-item">Data do: ${mapa.endDate}</li>
                <li class="list-group-item">Kraj: ${mapa.country}</li>
                <li class="list-group-item">Miasto: ${mapa.city}</li>
                <li class="list-group-item">Firma: ${mapa.company}</li>
                <li class="list-group-item">Adres Firm: ${mapa.companyAdres}</li>
                <li class="list-group-item">Cel wyjazdu: ${mapa.purpose}</li>
                <li class="list-group-item">Miejsce startu: ${mapa.startPoint}</li>
            </ul>
        </div>
    </div>
</div>
<div class="container" style="width: 100%; text-align: center">
        <form class="needs-validation" action="delegation-save" method="POST" novalidate>
            <button class="btn btn-secondary" type="submit" lang="pl-PL">Zapisz</button>
        </form>
        <form class="needs-validation" action="/delegations-web/DelegationAddForm" method="GET" novalidate>
            <button class="btn btn-secondary" type="submit" lang="pl-PL" style="margin: 5px">powrót</button>
        </form>
        <#else>
        <div class="alert alert-info" role="alert">
            ${mapa}
        </div>
        <form class="needs-validation" action="/delegations-web/DelegationAddForm" method="GET" novalidate>
            <button class="btn btn-secondary" type="submit" lang="pl-PL" style="margin: 5px">Powrót</button>
        </form>
        </#if>
</div>
<footer class="footer">
    <p class="float">&copy; 2018 Kurs InfoShare Academy &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
</footer>
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
