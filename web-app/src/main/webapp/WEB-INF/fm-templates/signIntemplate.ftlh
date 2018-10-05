 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html lang="pl-PL">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

        <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="https://apis.google.com/js/platform.js" async defer></script>
        <meta name="google-signin-scope" content="profile email">
        <meta name="google-signin-client_id"
              content="589731494851-gnjn3gne68h4fnch3j9d0molr53p0ftf.apps.googleusercontent.com">

        <title>Sign in</title>
    </head>
    <body>
    <h2>Sign in</h2>
    <br>
    <div class="g-signin2" data-onsuccess="onSignIn"></div>

    <script>
        function onSignIn(googleUser) {
            var profile = googleUser.getBasicProfile();
            console.log('ID: ' + profile.getId());
            console.log('Name: ' + profile.getName());
            console.log('Image URL: ' + profile.getImageUrl());
            console.log('Email: ' + profile.getEmail());
            console.log('id_token: ' + googleUser.getAuthResponse().id_token);

            var redirectUrl = 'login';

            var form = $('<form action="' + redirectUrl + '" method="post">' +
                    '<input type="text" name="id_token" value="' +
                    googleUser.getAuthResponse().id_token + '" />' +
                    '</form>');
            $('body').append(form);
            form.submit();
        }

    </script>
    </body>
    </html>

<#--<!DOCTYPE html>
<html lang="pl-PL">
<head>
    <meta name="google-signin-client_id" content="589731494851-gnjn3gne68h4fnch3j9d0molr53p0ftf.apps.googleusercontent.com">

    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://apis.google.com/js/platform.js" async defer></script>

    <meta name="google-signin-scope" content="profile email">
    <meta name="589731494851-gnjn3gne68h4fnch3j9d0molr53p0ftf.apps.googleusercontent.com"


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
            <div class="g-signin2" data-onsuccess="onSignIn"></div>
        </div>
    </div>
</div>
<#include "include/footer.ftlh">
<#include "include/scripts.ftlh">
</body>
</html>&ndash;&gt;-->
