<!DOCTYPE html>
<html lang="pl-PL">
<head>
    <title>Main menu</title>
     <#include "../include/headAndMeta.ftlh">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

</head>
<body style="font-family: 'Open Sans', sans-serif">
    <#include "../include/navbarHeaderTemplate.ftlh">

<div class="container">
    <div class="row">
                <#if names?size != 0>
                <div class="col-sm-12">
                    <form action="/delegations-web/manageDelegations" method="get">

                        <label>Data utworzenia:</label>
                        <select name="date">
                             <#list dates as d>
                                 <option>${d}</option>
                             </#list>
                        </select>

                        <label>Imię:</label>
                        <select name="name">
                             <#list names as n>
                                 <option>${n}</option>
                             </#list>
                        </select>

                        <label>Nazwisko:</label>
                        <select name="surname">
                             <#list surnames as s>
                                 <option>${s}</option>
                             </#list>
                        </select>

                        <label>Kraj wyjazdu:</label>
                        <select name="country">
                             <#list countries as s>
                                 <option>${s}</option>
                             </#list>
                        </select>



                        <button class="btn btn-primary" type="submit" lang="pl-PL" >Filtruj</button>

                    </form>
                </div >
                </#if>
    </div>
</div>


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
                                         <input class="form-check-input" type="radio" name="wybor" id="lista"
                                                value="${d.getFileLineNumber()}">
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
                                 <td><input type="text" name="discardReason" placeholder="Jeżeli odrzucasz podaj powód" required ></td>

                             </tr>
                                    </div>
                     </#list>
                        </tbody>
                 </table>
                     <button class="btn btn-primary" type="submit" lang="pl-PL" value="accept" name="button">Akceptuj
                     </button>
                <button class="btn btn-primary" type="submit" lang="pl-PL" value="discard" name="button" id="btn">Odrzuć</button>
                 * Jak odrzucasz koniecznie podaj powód!!!!
                 </#if>
            </form>
    </div>
</div>
</div>

    <#include "../include/footer.ftlh">
    <#include "../include/scripts.ftlh">
</body>
</html>