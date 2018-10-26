<#-- aboutTemplate.ftlh -->

<!DOCTYPE html>
<html lang="pl-PL">

    <head>

        <title>Delegacje</title>

<#include "include/headAndMeta.ftlh">

    </head>

    <body style="font-family: 'Open Sans', sans-serif">

<#include "include/navbarHeaderTemplate.ftlh">

        <div class="container" style="width: 600px; text-align: center; margin-top: 25px">
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

<#include "include/footer.ftlh">
<#include "include/scripts.ftlh">

    </body>
</html>
