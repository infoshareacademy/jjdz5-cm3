<!DOCTYPE html>
<html lang="pl-PL">
<head>
   <title>Main menu</title>
 <#include "../include/headAndMeta.ftlh">
</head>
<body style="font-family: 'Open Sans', sans-serif">
<#include "../include/navbarHeaderTemplate.ftlh">
<div class="container">
    <div class="row">
        <div class="col-md-12" style="width= 100%;margin-left: 30%;margin-right: 30%">
            <div style="text-align: left">
                Plik z delegacjami powinien być:
                <ul>
                    <li>w formacie "txt"</li>
                    <li>dane oddzielone przecinkiem</li>
                    <li>format dat YYYY-MM-DD </li>
                    <li>o określonej strukturze:<br>
                        data utworzenia, Imię, Nazwisko, data od, data do, Kraj wyjazdu, Miasto, Firma, Adres Firmy, Cel wyjazdu, skąd wyjazd
                    </li>
                            </ul>
                Przykładowe dane: <br>
                2018-10-05,Marek,Kalkowski,2018-10-12,2018-10-27,Poland,Elbląg,StacjaNatura,Elbląg,Tak sobie,Gdańsk<br><br>
            </div>
            <form method="POST" action="import" enctype="multipart/form-data" >
                File:
                <input type="file" name="file" id="file" /> <br/>
                <input type="submit" value="Upload" name="upload" id="upload" />
            </form>
        </div>
    </div>
</div>
<#include "../include/footer.ftlh">
<#include "../include/scripts.ftlh">
</body>
</html>