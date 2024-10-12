<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <title>Etiquetas JSTL</title>
</head>
<body>
<div class="container">
    <div class="row">
        &nbsp;
    </div>
    <div class="panel panel-primary">
        <div class="panel-heading">Resultado de verambito</div>
        <div class="panel-body">
            <p>${variableDePagina}</p>
            <p><c:out value="${variableDeSesion}"/></p>
            <p><c:out value="${variableDeAplicacion}"/><br></p>
            <p><c:out value="${cuatro}"/></p>
        </div>
    </div>
</div>
</body>
</html>
