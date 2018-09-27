<!DOCTYPE html>
<html lang="pl-PL">
<head>

    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">

    <title>Dodaj delegację</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <link rel="stylesheet" href="/style.css">

</head>

<body>
<header>

</header>
<div style="width: 1100px; margin-left: auto;margin-right: auto">
    <div class="jumbotron jumbotron-fluid bg-info text-white text-center">
        <div class="container">
            <h1 class="display-1">Delegacja do akceptacji</h1>
            <p class="lead"> by CM3</p>
        </div>
    </div>
    <form action="acceptServlet" method="get">

        <#if delegations?is_string>
            alskdaskldjlsak
        <#else >


        <#list delegations as d>


         <div class="form-check">
             <input class="form-check-input" type="radio" name="wybor" id="lista" value="${d.getFileLineNumber()}">
             <label class="form-check-label" for="lista">
                 ${d}
             </label>
         </div>


        </#list>
        <button class="btn btn-primary" type="submit" lang="pl-PL" value="accept" name="button">Akceptuj</button>
        <button class="btn btn-primary" type="submit" lang="pl-PL" value="discard" name="button">Odrzuć</button>
</#if>
    </form>

</div>
</body>
</html>