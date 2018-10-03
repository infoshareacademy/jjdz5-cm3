<!DOCTYPE html>
<html lang="pl-PL">
<head>
    <title>Sign in</title>
     <#include "include/headAndMeta.ftlh">
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
            <a class="navbar-brand" href="/delegations-web/"> &#9992 delegations-web.com</a>
        </div>
    </div>
</nav>
<div class="container" style="width: 500px">
    <div class="row" style="margin: 15px">
        <div class="col-md-12">
            <p align="center">
                <img src="images/globe.jpg" alt="logo" style="width:30%">
            </p>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <form action="">
                <div class="form-group">
                    <label for="exampleInputEmail1">Nazwa użytkownika</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Wpisz nazwę użytkownika">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Hasło</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Wpisz Hasło">
                    <small id="passwordHelp" class="form-text text-muted">Zapomniałeś nazwy użytkownika bądź hasła?</small>
                </div>
                <div class="form-group form-check">
                    <input type="checkbox" class="form-check-input" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1">Zapamiętaj mnie</label>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="container" style="width: 100%; text-align: center">
    <div class="row">
        <div class="col-md-12">
            <form action="/delegations-web/mainMenu">
                <button class="btn btn-secondary" type="submit" lang="pl-PL" style="margin-top: 5px">Zaloguj się</button>
            </form>
        </div>
    </div>
</div>
<#include "include/footer.ftlh">
<#include "include/scripts.ftlh">
</body>
</html>