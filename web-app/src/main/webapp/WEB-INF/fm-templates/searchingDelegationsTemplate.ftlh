<!DOCTYPE html>
<html lang="pl-PL">
<head>
    <title>Main menu</title>
    <#include "include/headAndMeta.ftlh">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
</head>

<body style="font-family: 'Open Sans', sans-serif">
    <#include "include/navbarHeaderTemplate.ftlh">
<div class="container">
    <div class="row">
    <div class="col-md-12">

         <#if delegations?size == 0>
              Brak delegacji do wyświetlenia <br/>
              <a href="/delegations-web/mainMenu">
                  <button class="btn btn-secondary" type="button" lang="pl-PL" style="margin-top: 5px">
                      powrót
                  </button>
              </a>

         <#else >


<div class="row">
    <div class="col">
         <form action="/delegations-web/searchDelegations" method="POST">
             <button class="btn btn-info" type="submit" lang="pl-PL" value="SAVED" name="status">Delegacje zapisane</button>
         </form>
    </div>
        <div class="col">
         <form action="/delegations-web/searchDelegations" method="POST">
             <button class="btn btn-warning" type="submit" lang="pl-PL" value="TOACCEPT" name="status">Delegacje do akceptacji</button>
         </form>
        </div>
            <div class="col">
         <form action="/delegations-web/searchDelegations" method="POST">
             <button class="btn btn-success" type="submit" lang="pl-PL" value="ACCEPTED" name="status">Delegacje zaakceptowane</button>
         </form>
            </div>
                <div class="col">
         <form action="/delegations-web/searchDelegations" method="POST">
             <button class="btn btn-danger" type="submit" lang="pl-PL" value="DISCARTED" name="status">Delegacje odrzucone</button>
         </form>
                </div>
    </div>

         </div>

              <table class="table table-bordered">
                 <thead class="thead-dark">
                 <tr>
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
                     <th scope="col">Status</th>

                 </tr>
                 </thead>

                 <tbody>
             <#list delegations as d>
                 <#switch d.getDelegationStatus()>
                     <#case "SAVED">
              <tr class="info">
                         <#break>
                     <#case "TOACCEPT">
              <tr class="warning">
                         <#break>
                     <#case "ACCEPTED">
              <tr class="success">
                         <#break>
                     <#case "DISCARTED">
              <tr class="danger">
                         <#break>
                     <#default>
              <tr>
                 </#switch>

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
                 <td>${d.getDelegationStatus()  }</td>

             </tr>
              </div>
             </#list>
             </tbody>
             </table>

         </#if>
        </form>
    </div>
</div>
</div>

    <#include "include/footer.ftlh">
    <#include "include/scripts.ftlh">
</body>
</html>
