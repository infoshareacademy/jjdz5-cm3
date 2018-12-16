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


                </li>


                <li><a href="/delegations-web/about" style="color: #a9a9a9">O nas</a></li>
                <li><a href="/delegations-web/logout" onclick="signOut();">Wyloguj się</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
