<%--
  Created by IntelliJ IDEA.
  User: kalkowski.m
  Date: 13.08.2018
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodawanie delegacji</title>
</head>
<body>
<div id="container">
    
    <div id="menu"></div>
    <div class="form">
        Podaj imię <input type="text" name="name"> &nbsp&nbsp&nbsp &nbsp&nbsp&nbspPodaj nazwisko <input type="text" name="surname"><br><br>
        <label>Data delegacji</label>
        <form action="./delegation-add" method="get">
           Podaj datę wyjazdu: <input type="date" name="startDate"> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Podaj datę powrotu:<input type="date" name="endDate"><br><br>
            Wybierz kraj
            <select name="country">
                <option value="Polska" selected>Polska</option>
                <option value="Niemcy">Niemcy</option>
                <option value="Anglia">Anglia</option>
            </select><br>
            Podaj miasto<input type="text" name="city"><br>
           Podaj cel<input type="text" name="purpose"><br>
            <input type="submit" value="Dodaj delegację">
        </form>
    </div>
    
</div>
</body>
</html>
