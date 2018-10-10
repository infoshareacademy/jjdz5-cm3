<!DOCTYPE html>
<html lang="pl-PL">
<head>
    <title>Main menu</title>
     <#include "../include/headAndMeta.ftlh">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<script>

function f(x) {

    var radios = document.getElementsByTagName("form")[0];
    var idRadio = x-100;
    var idRadiostr = idRadio.toString();
    var s = x.toString();
    var t = document.getElementById(s);

    for (var i=0 ; i<radios.length; i++) {
        var r = radios[i]; // current radio button

        if (r.id === idRadiostr){

            t.required = true;

        }


            <#--if ( r.id === '${d.getFileLineNumber()}' ) { // standard shipping-->
                <#--r.checked = true; // set checked-->
            <#--} else { // not standard shipping-->
                <#--r.checked = false; // unchecked-->
                <#--r.disabled = true; // disable-->
            <#--}-->

        <#--} else { // hazard not checked-->
            <#--r.disabled = false; // no radios disabled-->

}

    
//     function myFunction(x,y) {
<#--//onclick="myFunction(${d.getFileLineNumber()},${d.getFileLineNumber()+100})" onabort="f(${d.getFileLineNumber()},${d.getFileLineNumber()+100})-->
//         var s = x.toString();
//         var s1 = y.toString();
//
//     var v = document.getElementById(s);
//     var t = document.getElementById(s1);
//
//     t.required=true;
//
//     // if (v.checked === true) {t.required = true;}
//     //
//     // else {t.required = false;}
//
//     }
// function f(x1,y1) {
//         var s2 = x1.toString();
//         var s3 = y1.toString();
//
//         var on =  document.getElementById(s2).;
//         var on1 =  document.getElementById(s3);
//    s3.required = false;
// }

</script>
</head>
<body style="font-family: 'Open Sans', sans-serif">
    <#include "../include/navbarHeaderTemplate.ftlh">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <form action="manageDelegations" method="POST">
                 <#if delegations?size == 0>
                     Brak delegacji do wyświetlenia <br/>

                         <a href="/delegations-web/mainMenu">
                             <button class="btn btn-secondary" type="button" lang="pl-PL" style="margin-top: 5px">
                                 powrót
                             </button>
                         </a>

                 <#else >
                    <table class="table">
                        <thead class="thead-dark">
                        <tr>
                            <th scope="col"></th>
                            <th scope="col">ID</th>
                            <th scope="col">Data <br/> utworzenia</th>
                            <th scope="col">Imię</th>
                            <th scope="col">Nazwisko</th>
                            <th scope="col">Data <br/> od</th>
                            <th scope="col">Data <br/> do</th>
                            <th scope="col">Kraj <br/> wyjazdu</th>
                            <th scope="col">Miasto</th>
                            <th scope="col">Firma</th>
                            <th scope="col">Adres <br/> firmy</th>
                            <th scope="col">Cel <br/> wyjazdu</th>
                            <th scope="col">Wyjazd z</th>
                            <th scope="col">Powód <br/>odrzucenia</th>

                        </tr>
                        </thead>
                        <tbody>
                            <#list delegations as d>
                             <tr>
                                 <td>
                                     <div class="form-check">

                                         <input class="form-check-input" type="radio" name="wybor"
                                                id="${d.getFileLineNumber()}"
                                                value="${d.getFileLineNumber()}" onclick="f(${d.getFileLineNumber()+100})">

                                 </td>
                                 <td>${d.getFileLineNumber()}</td>
                                 <td>${d.getCreationDate()}</td>
                                 <td>${d.getEmployee().getEmployeeName()}</td>
                                 <td>${d.getEmployee().getEmployeeSurname()}</td>
                                 <td>${d.getStartDate()}</td>
                                 <td>${d.getEndDate()}</td>
                                 <td>${d.getDestination().getDestinationCountry()}</td>
                                 <td>${d.getDestination().getDestinationCity()}</td>
                                 <td>${d.getDestination().getDestinationCompany()}</td>
                                 <td>${d.getDestination().getDestinationCompanyAddress()}</td>
                                 <td>${d.getPurpose()}</td>
                                 <td>${d.getStartPoint()}</td>
                                 <td><input type="text" name="discardReason" placeholder="Jeżeli odrzucasz podaj powód" id="${d.getFileLineNumber()+100}" ></td>

                             </tr>
                                    </div>
                     </#list>
                        </tbody>
                 </table>
                     <button class="btn btn-primary" type="submit" lang="pl-PL" value="accept" name="button">Akceptuj
                     </button>
                <button class="btn btn-primary" type="submit" lang="pl-PL" value="discard" name="button" id="btn"  >Odrzuć</button>
                 * Jak odrzucasz koniecznie podaj powód!!!!
                 </#if>
            </form>
    </div>
</div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>

    <#include "../include/footer.ftlh">
    <#--<#include "../include/scripts.ftlh">-->
</body>
</html>