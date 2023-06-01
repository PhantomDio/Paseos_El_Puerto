<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Propietarios" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <title>Lista Propietarios</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="/paseos_el_puerto/styles.css">
    <link rel="stylesheet" type="text/css" href="/paseos_el_puerto/navbar.css">
    <script src="/paseos_el_puerto/animaciones.js"></script>
</head>
<body class="container_body">
<header>
    <nav class="navigation">
        <ul>
            <li><a href="/paseos_el_puerto/index.jsp" class="logo-nav-container"><img src="/paseos_el_puerto/logo.png" alt="Logo"></a></li>
            <li class="dropdown">
                <a href="#" class="navigation-link">Embarcaciones</a>
                <ul class="dropdown-menu">
                    <li><a href="#">Lista</a></li>
                    <li><a href="#">Registrar</a></li>
                    <li><a href="#">Modificar</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="navigation-link">Propietarios</a>
                <ul class="dropdown-menu">
                    <li><a href="#">Lista</a></li>
                    <li><a href="#">Registrar</a></li>
                    <li><a href="#">Modificar</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="navigation-link">Alquileres</a>
                <ul class="dropdown-menu">
                    <li><a href="#">Lista</a></li>
                    <li><a href="#">Registrar</a></li>
                    <li><a href="#">Modificar</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="navigation-link">Propietarios</a>
                <ul class="dropdown-menu">
                    <li><a href="/paseos_el_puerto/ServletPropietario?op=lista" methods="GET">Lista</a></li>
                    <li><a href="/paseos_el_puerto/Propietarios/inserta_cliente.jsp">Registrar</a></li>
                    <li><a href="/paseos_el_puerto/Propietarios/actualiza_cliente.jsp">Modificar</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="navigation-link">Personal</a>
                <ul class="dropdown-menu">
                    <li><a href="#">Lista</a></li>
                    <li><a href="#">Registrar</a></li>
                    <li><a href="#">Modificar</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="navigation-link">Mantenimiento</a>
                <ul class="dropdown-menu">
                    <li><a href="#">Lista</a></li>
                    <li><a href="#">Registrar</a></li>
                    <li><a href="#">Modificar</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="navigation-link">Reparación</a>
                <ul class="dropdown-menu">
                    <li><a href="#">Lista</a></li>
                    <li><a href="#">Registrar</a></li>
                    <li><a href="#">Modificar</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="navigation-link">Equipamiento</a>
                <ul class="dropdown-menu">
                    <li><a href="#">Lista</a></li>
                    <li><a href="#">Registrar</a></li>
                    <li><a href="#">Modificar</a></li>
                </ul>
            </li>
        </ul>
    </nav>
</header>

<style>
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    form {
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    p {
        display: flex;
        justify-content: flex-end;
        align-items: center;
        margin: 10px 0;
    }


    p input[type="text"] {
        padding: 5px;
        border: 1px solid #ccc;
        border-radius: 5px;
        font-size: 14px;
        margin-left: 9px;
        margin-top: 5px;
        margin-right: 9px;
        width: 90px; /* Ajusta el ancho según sea necesario */
    }
    .button-container{
        margin-bottom: 9px;
    }
</style>

<section class="container">
    <div class="parallax-content">
        <form method="get" action="/paseos_el_puerto/ServletPropietario">
            <p>ID:<input type="text" name = "id_propietario"></p>
            <input type="submit" class="button-minimal button-container" value="Buscar" name="op">
            <input type="submit" class="button-minimal" value="Eliminar" name="op">
        </form>
        <a href="/paseos_el_puerto/ServletPropietario">Mostrar lista completa</a>
        <div class="table-container">
            <table>
                <thead>
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
                </thead>
                <tbody>
                <%
                    Propietarios propietario = (Propietarios) request.getAttribute("propietario");
                    List<Propietarios> lista = (List<Propietarios>) request.getAttribute("lista");

                    if (propietario != null) {
                %>
                <tr>
                    <td><%= propietario.getIdPropietario() %></td>
                    <td><%= propietario.getNombre() %></td>
                    <td><%= propietario.getApellidoP() %></td>
                    <td><%= propietario.getApellidoM() %></td>
                    <td><%= propietario.getDireccion() %></td>
                    <td><%= propietario.getTelefono() %></td>
                    <td><%= propietario.getEmail() %></td>
                    <td><%= propietario.getFecha_nac() %></td>
                </tr>
                <% } else if (lista != null && !lista.isEmpty()) {
                    for (Propietarios prop : lista) {
                %>
                <tr>
                    <td><%= prop.getIdPropietario() %></td>
                    <td><%= prop.getNombre() %></td>
                    <td><%= prop.getApellidoP() %></td>
                    <td><%= prop.getApellidoM() %></td>
                    <td><%= prop.getDireccion() %></td>
                    <td><%= prop.getTelefono() %></td>
                    <td><%= prop.getEmail() %></td>
                    <td><%= prop.getFecha_nac() %></td>
                </tr>
                <% }
                } else {
                        session.removeAttribute("lista");
                        session.removeAttribute("propietario");
                %>
                <tr>
                    <td colspan="8"><h1>No hay propietarios a mostrar</h1></td>
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>
    </div>
</section>
</body>
</html>