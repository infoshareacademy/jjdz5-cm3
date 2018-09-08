<%@ page import="com.isa.cm3.delegations.DelegationRepository" %>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Tytul</title>
</head>
<body onload="<% DelegationRepository.loadId();%>">
<h1>STRONA STARTOWA DELEGACJI</h1>


<a href="/delegations-web/DelegationAddForm">Dodanie delegacji</a>

</body>
</html>
