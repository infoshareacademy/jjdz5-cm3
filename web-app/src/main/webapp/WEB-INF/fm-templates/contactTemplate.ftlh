<#-- contactTemplate.ftlh -->

<!DOCTYPE html>
<html lang="pl-PL">

<head>

    <title>Delegacje</title>

<#include "include/headAndMeta.ftlh">

</head>

<body style="font-family: 'Open Sans', sans-serif">

<#include "include/navbarHeaderTemplate.ftlh">

<h4 style="color: black; alignment: center; text-align: center;">Kontakt</h4>

<div class="container" style="width: 600px; text-align: center; margin-top: 25px">
    <form>
        <div class="form-group">
            <label for="exampleFormControlInput1">Wpisz swój adres email</label>
            <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com">
        </div>

        <div class="form-group">
            <label for="exampleFormControlSelect1">Wybierz rodzaj wiadomości</label>
            <select class="form-control" id="exampleFormControlSelect1">
                <option>Zapytanie</option>
                <option>Chęć nawiązania współpracy</option>
                <option>Prośba o kontakt</option>
                <option>Skarga</option>
            </select>
        </div>

        <div class="form-group">
            <label for="exampleFormControlTextarea1">Wpisz treść wiadomości</label>
            <textarea class="form-control" id="exampleFormControlTextarea1" rows="10"></textarea>
        </div>
    </form>
</div>

<div class="container" style="width: 100%; text-align: center">
    <div class="row">
        <div class="col-md-12">
            <form action="/delegations-web/messageSender">
                <button class="btn btn-secondary" type="submit" lang="pl-PL" style="margin-top: 5px">Wyślij</button>
            </form>
        </div>
    </div>
</div>

<#include "include/footer.ftlh">
<#include "include/scripts.ftlh">

</body>
</html>
