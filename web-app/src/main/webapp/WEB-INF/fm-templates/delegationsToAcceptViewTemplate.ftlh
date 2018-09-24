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
         <#list delegations as d>

         <div class="form-check">
             <input class="form-check-input" type="radio" name="wybor" id="lista" value="${d.getFileLineNumber()}">
             <label class="form-check-label" for="lista">
                 ${d}
             </label>
         </div>


         <#--<div class="input-group mb-3">-->
             <#--<div class="input-group-prepend">-->
                 <#--<div class="input-group-text">-->
                     <#--<input type="checkbox" name="${d.getFileLineNumber}" value="${d.getFileLineNumber}">-->
                 <#--</div>-->
             <#--</div>-->
             <#--<input type="text" class="form-control" value="${d} ">-->
         <#--</div>-->




             <#--<div class="form-check">-->
                 <#--<label class="form-check-label" for="check1">-->
                     <#--<input type="checkbox" class="form-check-input" id="check1" name="${d.getFileLineNumber()}"-->
                            <#--value="${d.getFileLineNumber()}"> ${d}-->
                 <#--</label>-->
             <#--</div>-->

         </#list>
        <button class="btn btn-primary" type="submit" lang="pl-PL" value="accept">Akceptuj</button>
        <button class="btn btn-primary" type="submit" lang="pl-PL" value="discard">odrzuć </button>

    </form>

</div>
</body>
</html>