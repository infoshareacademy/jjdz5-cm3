<#-- signIntemplate.ftlh -->

<!DOCTYPE html>
<html lang="pl-PL">

<head>

<#include "./include/headAndMeta.ftlh">

    <title>Delegacje</title>

</head>

<body style="font-family: 'Open Sans', sans-serif">


<h2>Delegacje: zaloguj się</h2>
<br>

<div id="my-signin2"></div>
<script>
    function onSuccess(googleUser) {
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
        googleUser.disconnect();
        form.submit();
    }
    function onFailure(error) {
        console.log(error);
    }
    function renderButton() {
                gapi.signin2.render('my-signin2', {
            'scope': 'profile email',
            'width': 240,
            'height': 50,
            'longtitle': true,
            'theme': 'dark',
            'onsuccess': onSuccess,
            'onfailure': onFailure
        });
    }
</script>

<script src="https://apis.google.com/js/platform.js?onload=renderButton" async defer></script>

<#include "include/footer.ftlh">

</body>
</html>