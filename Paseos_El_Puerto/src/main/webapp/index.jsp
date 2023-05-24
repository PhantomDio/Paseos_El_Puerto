<%@ page import="model.Embarcaciones" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Barcos</title>
</head>
<body>
<h1>Lista de Barcos</h1>

<table>
    <tr>
        <th>Nombre</th>
        <th>Largo</th>
        <th>Propietario</th>
    </tr>
    <%-- Iterar sobre una lista de objetos Barco obtenidos desde el Servlet --%>
    <%// for (Embarcaciones barco : listaBarcos) { %>
    <tr>
        <%Embarcaciones barco = null; %>
        <td><%= barco.getModelo() %></td>
        <td><%= barco.getLongitud() %></td>
        <td><%= barco.getIdPropietario() %></td>
    </tr>
    <% //} %>
</table>

</body>
</html>