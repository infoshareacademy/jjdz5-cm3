<!DOCTYPE html>
<html lang="pl-PL">
<head>
    <title>Main menu</title>
     <#include "include/headAndMeta.ftlh">
</head>
<body style="font-family: 'Open Sans', sans-serif">
<#include "include/navbarHeaderTemplate.ftlh">
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <form action="acceptServlet" method="get">
                 <#if delegations?size == 0>
                     Brak delegacji do wyświetlenia <br/>

                         <a href="/delegations-web/mainMenu"> <button class="btn btn-secondary" type="button" lang="pl-PL" style="margin-top: 5px">powrót</button></a>

                 <#else >
                     <#list delegations as d>
                         <div class="form-check">
                             <input class="form-check-input" type="radio" name="wybor" id="lista"
                                    value="${d.getFileLineNumber()}">
                             <label class="form-check-label" for="lista">
                                 ${d}
                             </label>
                         </div>
                     </#list>
                     <button class="btn btn-primary" type="submit" lang="pl-PL" value="accept" name="button">Akceptuj
                     </button>
                <button class="btn btn-primary" type="submit" lang="pl-PL" value="discard" name="button">Odrzuć</button>
                 </#if>
            </form>

        </div>
    </div>
</div>
<#include "include/footer.ftlh">
<#include "include/scripts.ftlh">
</body>
</html>