<#-- welcomeTemplate.ftlh -->

<!DOCTYPE html>
<html lang="pl-PL">

<head>

    <title>Delegacje</title>

<#include "./include/headAndMeta.ftlh">

    <style>
        p.text-center {
            font-style: italic;
            font-family: 'Open Sans', sans-serif;
        }
    </style>

</head>

<body style="font-family: 'Open Sans', sans-serif">

<#include "include/navbarLoginHeaderTemplate.ftlh">

<div class="container" style="margin-top: 50px; width: 60%">
    <div class="row">
        <div class="col-md-4">
            <div class="thumbnail">
                <img src="images/comfortable.png" alt="comfortable" style="width:100%">
                <div class="caption">
                    <p class="text-center">Wygoda</p>
                </div>
                </a>
            </div>
        </div>

        <div class="col-md-4">
            <div class="thumbnail">
                <img src="images/ontime.png" alt="ontime" style="width:100%">
                <div class="caption">
                    <p class="text-center">Punktualność</p>
                </div>
                </a>
            </div>
        </div>

        <div class="col-md-4">
            <div class="thumbnail">
                <img src="images/fast.png" alt="fast" style="width:100%">
                <div class="caption">
                    <p class="text-center">Szybkość</p>
                </div>
                </a>
            </div>
        </div>
    </div>
</div>

<#include "include/footer.ftlh">
<#include "include/scripts.ftlh">

</body>
</html>
