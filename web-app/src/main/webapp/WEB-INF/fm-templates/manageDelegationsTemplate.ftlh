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
                 <#if delegations?is_string>
                     alskdaskldjlsak
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