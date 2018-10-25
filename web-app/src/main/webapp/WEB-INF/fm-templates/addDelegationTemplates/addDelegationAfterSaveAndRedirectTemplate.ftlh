<#-- addDelegationConfirmAndSaveTemplate.ftlh -->

<!DOCTYPE html>
<html lang="pl-PL">

    <head>

        <title>Zapisywanie delegacji</title>

        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">

        <meta http-equiv="refresh" content="2;url=http://localhost:8080/delegations-web/mainMenu"/>
        <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" href="/WEB-INF/fm-templates/css/custom.css">

    <#--bootstrap
        -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    </head>

    <body style="font-family: 'Open Sans', sans-serif">

        <header>
            <nav class="navbar navbar-default">
                <div class="container">
                    <div class="navbar-header">
                        <h4 style="color: gray">Delegacja wysłana do akceptacji</h4>
                    </div>
                </div>
            </nav>

            <div class="alert alert-success" role="alert" style="width:60%;margin: auto">
                <h4 class="alert-heading" style="text-align: center">Nastąpi przekierowanie na stronę główną.</h4>
            </div>
        </header>

<#include "../include/scripts.ftlh">
<#include "../include/footer.ftlh">

    </body>
</html>
