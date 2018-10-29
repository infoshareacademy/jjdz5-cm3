<!-- filterDelegations.ftlh -->

<div class="container">
    <div class="row">

        <div class="card" style="width: 100%; height: 100%; background-color: lightgrey; alignment: center;">
            <h4 class="card-title"
                style="width: 100%; height: 100%; background-color: slategrey; alignment: center; text-align: center;">
                Filtrowanie</h4>

            <div class="card-body" style="background-color: lightgrey;">

                <div class="card-text">

                    <form action="${actionForm}" method="get">

                        <div class="col-sm-12" style="width: 100%;">

                            <div class="col-md-2">
                                <label>Data utworzenia:</label><br>
                                <select name="date" style="width: 100%;">
                                 <#list dates as d>
                                     <#if datesOption == d >
                                     <option selected>${d}</option>
                                     <#else>
                                     <option>${d}</option>
                                     </#if>
                                 </#list>
                                </select>
                            </div>

                            <div class="col-md-2">
                                <label>Imię:</label><br>
                                <select name="name" style="width: 100%;">
                                 <#list names as n>
                                     <#if namesOption == n >
                                     <option selected>${n}</option>
                                     <#else>
                                     <option>${n}</option>
                                     </#if>
                                 </#list>
                                </select>
                            </div>

                            <div class="col-md-2">
                                <label>Nazwisko:</label><br>
                                <select name="surname" style="width: 100%;">
                                 <#list surnames as s>
                                     <#if surnamesOption == s >
                                     <option selected>${s}</option>
                                     <#else>
                                     <option>${s}</option>
                                     </#if>
                                 </#list>
                                </select>
                            </div>

                            <div class="col-md-3">
                                <label>Kraj wyjazdu:</label><br>
                                <select name="country" style="width: 100%;">
                                 <#list countries as s>
                                     <#if countriesOption == s >
                                         <option selected>${s}</option>
                                     <#else>
                                         <option>${s}</option>
                                     </#if>
                                 </#list>
                                </select>
                            </div>

<#if statusOption??>
    <#include "filterDelegationsStatusOption.ftlh">

                            <div class="col-md-1">
                                <a href="/delegations-web/searchDelegations?date=&name=&surname=&country=&status="
                                   class="btn btn-dark"
                                   style="width: 100%; height: 100%; font-size: medium; background-color: slategrey; color: white;">
                                    Usuń<br>
                                    filtry
                                </a>
                            </div>

<#else>
                            <div class="col-md-2">
                            </div>

                            <div class="col-md-1">
                                <a href="/delegations-web/manageDelegations?date=&name=&surname=&country=&status="
                                   class="btn btn-dark"
                                   style="width: 100%; height: 100%; font-size: medium; background-color: slategrey; color: white;">
                                    Usuń<br>
                                    filtry
                                </a>
                            </div>
</#if>

                        </div>


                        <div class="col-sm-12">
                            <br>
                        </div>

                        <div class="col-sm-12">
                            <div class="col-md-1">
                            </div>
                            <div class="col-md-10">
                                <button class="btn btn-primary" type="submit" lang="pl-PL" style="width: 100%;">Szukaj
                                </button>
                                <br>
                            </div>
                            <div class="col-md-1">
                            </div>
                        </div>

                    </form>

                </div>
            </div>

            <h4 class="card-title">&nbsp;</h4>

        </div>
    </div>
</div>