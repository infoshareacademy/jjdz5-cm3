<#-- navbarHeaderTemplate.ftlh -->

<nav class="navbar navbar-default">
    <div class="container" style="display: inline-block;">
        <div class="navbar-header">

            <a class="navbar-brand"
               href="/delegations-web/mainMenu">
                &#9992 delegations-web.com
            </a>

            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#navbar-collapse-2">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

        </div>

        <script>
            function signOut() {
                console.log("logging out ...");
                gapi.auth.authorize(
                        {
                            'client_id': "714386444263-rduec7llk6q3odjpqf6ong5tp4kqb4n1.apps.googleusercontent.com",
                            'scope': "profile email",
                            'immediate': false,
                            cookie_policy: 'single_host_origin',
                            response_type: 'token id_token'
                        },
                        function (authResult) {
                            gapi.auth.signOut();
                            gapi.auth.disconnect();
                        }
                );
                window.location.href = '/delegations-web/logout';
            }
        </script>

        <div class="collapse navbar-collapse justify-content-center" id="navbar-collapse-2">
            <ul class="nav navbar-nav navbar-right" style="display: inline-block;">
                <li><a href="/delegations-web/addForm">Dodaj delegację</a></li>
                <li><a href="/delegations-web/searchDelegations?date=&name=&surname=&country=&status=">Szukaj
                    delegacji</a></li>
                <li><a href="/delegations-web/manageDelegations?date=&name=&surname=&country=">Zarządzaj delegacjami</a>
                </li>
                <li><a href="/delegations-web/import">Importuj delegacje</a></li>
                <li><a href="/delegations-web/contact">Kontakt</a></li>
                <li><a href="/delegations-web/about">O nas</a></li>
                <li>
                    <a href="javascript:signOut()">Wyloguj się</a>

                </li>
            </ul>
        </div>
    </div>
</nav>
