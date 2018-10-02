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
            <form method="POST" action="import" enctype="multipart/form-data" >
                File:
                <input type="file" name="file" id="file" /> <br/>
                <input type="submit" value="Upload" name="upload" id="upload" />
            </form>
        </div>
    </div>
</div>
<#include "include/footer.ftlh">
<#include "include/scripts.ftlh">
</body>
</html>