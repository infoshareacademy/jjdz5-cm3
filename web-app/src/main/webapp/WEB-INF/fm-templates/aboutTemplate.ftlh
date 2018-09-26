<!DOCTYPE html>
<html lang="pl-PL">
<head>
    <title>Main menu</title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
<#--bootstrap
    -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
</head>
<body style="font-family: 'Open Sans', sans-serif">
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse-2">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/delegations-web/mainMenu"> &#9992 delegations-web.com</a>
        </div>
        <div class="collapse navbar-collapse" id="navbar-collapse-2">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/delegations-web/myDelegations">Moje delegacje</a></li>
                <li><a href="/delegations-web/addForm">Dodaj delegację</a></li>
                <li><a href="/delegations-web/searchDelegations">Szukaj delegacji</a></li>
                <li><a href="/delegations-web/manageDelegations">Zarządzaj delegacjami</a></li>
                <li><a href="/delegations-web/contact">Kontakt</a></li>
                <li><a href="/delegations-web/about">O nas</a></li>
                <li>
                    <a href="/delegations-web/sign-in" class="btn btn-default btn-outline btn-circle">Wyloguj się</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div div class="container" style="width: 600px; text-align: center; margin-top: 25px">
    <div class="panel-group" id="accordion">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse2" style="color: #676767">O programie</a>
                </h4>
            </div>
            <div id="collapse2" class="panel-collapse collapse">
                <div class="panel-body">Strona ta ma przede wszystkim pomóc w wygodniejszy sposób zaplanować podróż delegacyjną.
                Ma ona ułatwić pracownikowi składanie wniosku, od dzisiaj może on wystawić wniosek nie odchodząc od komputera.
                Co więcej, wniosek ten zostaje przejrzany przez odpowiadającego mu kierownika i zatwierdzony lub odrzucony.
                W przypadku odrzucenia - wymagany jest komentarz, dzięki czemu pracownik wie, co musi poprawić.
                Kierownikowi pozwoli ona na wyciąganie statystyk, kontrolę nad dyspozycyjnością zespołu.</div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse3" style="color: #676767">Dla kogo?</a>
                </h4>
            </div>
            <div id="collapse3" class="panel-collapse collapse">
                <div class="panel-body">Dla małych i dużych firm. Jest to strona skierowana zarówno dla stanowisk kierowniczych,
                jak i dla każdego pracownika będącego członkiem zespołu. Wystarczy tylko zarejestrować firmę!</div>
            </div>
        </div>
    </div>
</div>
<#include "footer.ftlh">
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