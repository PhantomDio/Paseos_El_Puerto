<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Clientes" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <title>Lista Clientes</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="/paseos_el_puerto/styles.css">
    <script src="/paseos_el_puerto/animaciones.js"></script>
</head>
<body class="container_body">

<header class="navigation">
    <div class="container">
        <nav class="scrolled">
            <ul>
                <li><a href="/paseos_el_puerto/index.jsp" class="logo-nav-container"><img src="/paseos_el_puerto/logo.png"/></a></li>
                <li><a href="" class="navigation-link">Embarcaciones</a></li>
                <li><a href="" class="navigation-link">Propietarios</a></li>
                <li><a href="" class="navigation-link">Alquileres</a></li>
                <li><a href="/paseos_el_puerto/Clientes/menu_cliente.jsp" class="navigation-link">Clientes</a></li>
                <li><a href="" class="navigation-link">Personal</a></li>
                <li><a href="" class="navigation-link">Mantenimiento</a></li>
                <li><a href="" class="navigation-link">Reparación</a></li>
                <li><a href="" class="navigation-link">Equipamiento</a></li>
            </ul>
        </nav>
    </div>
</header>

<section class="container">
    <div class="parallax-content">
        <a href="/paseos_el_puerto/ServletCliente"><input type="submit" class="button-minimal" value="Actualizar lista"/></a>
        <div class="table-container">
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Apellido Paterno</th>
                <th>Apellido Materno</th>
                <th>Dirección</th>
                <th>Telefono</th>
                <th>E-mail</th>
                <th>Fecha de nacimiento</th>
            </tr>
            </thead>
            <%List<Clientes> listaClientes = (List<Clientes>) request.getAttribute("listaClientes");
                if (listaClientes != null){
                    for (Clientes cliente : listaClientes){
            %>
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
            <%
                    }
            }
            else
            session.removeAttribute("listaClientes");
        %>
        </table>
        </div>
        <br/><form action="/paseos_el_puerto/Clientes/menu_cliente.jsp">
            <input  type="submit" class="button-minimal" value="Regresar"/>
        </form>
    </div>
</section>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</body>
</html>