<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodawanie delegacji</title>
</head>
<body>
<div id="container">
    
    <div id="menu"></div>
    <div class="form">

        <label>Data delegacji</label>
        <form action="./delegation-add" method="get">
            Podaj imię <input type="text" name="name"> &nbsp&nbsp&nbsp &nbsp&nbsp&nbspPodaj nazwisko <input type="text" name="surname"><br><br>
           Podaj datę wyjazdu: <input type="date" name="startDate"> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Podaj datę powrotu:<input type="date" name="endDate"><br><br>
            Wybierz kraj
            <select name="country">
                <option value="Polska" selected>Polska</option>
                <option value="Niemcy">Niemcy</option>
                <option value="Anglia">Anglia</option>
            </select><br>
            Podaj miasto<input type="text" name="city"><br>
            Nazwa firmy<input type="text" name="company"><br>
            Adres firmy<input type="text" name="companyAdres"><br>
            Podaj cel<input type="text" name="purpose"><br>
            Wyjazd z miasta<input type="text" name="startPoint"><br>
            <input type="submit" value="Dodaj delegację">
        </form>
    </div>
    
</div>
</body>
</html>
