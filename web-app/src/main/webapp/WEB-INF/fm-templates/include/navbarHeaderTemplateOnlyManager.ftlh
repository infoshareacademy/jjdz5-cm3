<#-- navbarHeaderTemplate.ftlh -->

<nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark">
    <div class="container" style="display: inline-block;">
        <div class="navbar-header">

            <a class="navbar-brand"
               href="/delegations-web/mainMenu">
                &#9992 delegacje.com
            </a>

            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#navbar-collapse-2">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

        </div>

        <div class="collapse navbar-collapse justify-content-center" id="navbar-collapse-2">
            <ul class="nav navbar-nav navbar-right" style="display: inline-block;">
                <li><a href="/delegations-web/userDelegations" style="color: #a9a9a9">Moje delegacje</a></li>
                <li><a href="/delegations-web/addForm" style="color: #a9a9a9">Dodaj delegację</a></li>
                <li><a href="/delegations-web/searchDelegations?date=&name=&surname=&country=&status=" style="color: #a9a9a9">Szukaj
                    delegacji</a></li>
                <li><a href="/delegations-web/manageDelegations?date=&name=&surname=&country=" style="color: #a9a9a9">Zarządzaj delegacjami</a>
                </li>
                <li><a href="/delegations-web/reports" style="color: #a9a9a9">Raporty</a></li>

                <li><a href="/delegations-web/about" style="color: #a9a9a9">O nas</a></li>
                <li>
                    <a href="/delegations-web/logout" onclick="signOut();">Wyloguj się</a>
                <#--<a href="/delegations-web/logout" onclick="signOut();">Wyloguj się</a>-->
                <#--<script>-->
                <#--function signOut() {-->
                <#--var auth2 = gapi.auth2.getAuthInstance();-->
                <#--auth2.signOut().then(function () {-->
                <#--console.log('USER SIGNED OUT');-->
                <#--});-->
                <#--}-->
                <#--</script>-->
                </li>
            </ul>
        </div>
    </div>
</nav>
