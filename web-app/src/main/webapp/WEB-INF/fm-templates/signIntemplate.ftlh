<#-- signIntemplate.ftlh -->

<!DOCTYPE html>
<html lang="pl-PL">

<head>

<#include "./include/headAndMeta.ftlh">

    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://apis.google.com/js/platform.js" async defer></script>
    <meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id"
          content="714386444263-rduec7llk6q3odjpqf6ong5tp4kqb4n1.apps.googleusercontent.com">

    <title>Delegacje</title>

</head>

<body style="font-family: 'Open Sans', sans-serif">

<#include "include/navbarLogoHeaderTemplate.ftlh">

<h2>Delegacje: zaloguj się</h2>
<br>

<div class="g-signin2" data-onsuccess="onSignIn">

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

</div>

<#include "include/footer.ftlh">

</body>
</html>
