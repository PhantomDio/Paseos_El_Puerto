<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.Clientes" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Administración de Clientes</title>
</head>
<body>
<h1>Administración de Clientes</h1>

<%-- Mostrar mensaje de éxito o error si existe --%>
<% if (request.getAttribute("mensaje") != null) { %>
<p><%= request.getAttribute("mensaje") %></p>
<% } %>

<h2>Registrar nuevo cliente</h2>

<form action="ServletCliente" method="POST">
    <label for="nombre">Nombre:</label>
    <input type="text" id="nombre" name="nombre" required><br><br>

    <label for="correo">Correo electrónico:</label>
    <input type="email" id="correo" name="correo" required><br><br>

    <label for="telefono">Teléfono:</label>
    <input type="text" id="telefono" name="telefono" required><br><br>

    <input type="submit" value="Registrar">
</form>

<h2>Listado de clientes</h2>

<table>
    <%-- Obtener el atributo "listaClientes" de la solicitud --%>
    <% List<Clientes> listaClientes = (List<Clientes>) request.getAttribute("listaClientes"); %>
    <%-- Verificar si la lista de clientes es nula antes de iterar --%>
    <% if (listaClientes == null) { %>
    <h2>No hay clientes a mostrar</h2>
    <% } else { %>
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Apellido Paterno</th>
        <th>Apellido Materno</th>
        <th>Dirección</th>
        <th>Teléfono</th>
        <th>E-mail</th>
        <th>Fecha de nacimiento</th>
    </tr>

    <%-- Iterar sobre la lista de clientes --%>
    <% for (Clientes cliente : listaClientes) { %>
    <tr>
        <td><%= cliente.getIdCliente() %></td>
        <td><%= cliente.getNombre() %></td>
        <td><%= cliente.getApellidoP() %></td>
        <td><%= cliente.getApellidoM() %></td>
        <td><%= cliente.getDireccion() %></td>
        <td><%= cliente.getTelefono() %></td>
        <td><%= cliente.getEmail() %></td>
        <td><%= cliente.getFecha_nac() %></td>
    </tr>
    <% } %>
    <% } %>
</table>

</body>
</html>
