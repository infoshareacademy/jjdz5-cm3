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
                    <a href="/delegations-web/logout" onclick="signOut();">Wyloguj się</a>
                    <#--<script>
                        function signOut(googleUser) {
                            var profile = googleUser.disconnect();
                            /*console.log('ID: ' + profile.getId());
                            console.log('Name: ' + profile.getName());
                            console.log('Image URL: ' + profile.getImageUrl());
                            console.log('Email: ' + profile.getEmail());
                            console.log('id_token: ' + googleUser.getAuthResponse().id_token);*/

                            var redirectUrl = 'login';

                            var form = $('<form action="' + redirectUrl + '" method="post">' +
                                    '<input type="text" name="id_token" value="' +
                                    googleUser.getAuthResponse().id_token + '" />' +
                                    '</form>');
                            $('body').append(form);
                            form.submit();
                        }
                    </script>-->
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
