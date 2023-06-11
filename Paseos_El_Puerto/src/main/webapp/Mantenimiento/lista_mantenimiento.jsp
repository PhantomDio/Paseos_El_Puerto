<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Mantenimiento" %>

<html>
<head>
    <title>Lista Mantenimiento</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="/paseos_el_puerto/styles.css">
    <link rel="stylesheet" type="text/css" href="/paseos_el_puerto/navbar.css">
    <script src="/paseos_el_puerto/animaciones.js"></script>
</head>
<body class="body_color">
<header class="navigation">
    <ul class="cont_ul">
        <li class="logo-nav-container"><a href="/paseos_el_puerto/index.jsp"><img src="/paseos_el_puerto/logo.png" alt="Logo">
        </a>
        </li>
        <li class="dropdown">
            <a href="#">Mantenimiento</a>
            <ul class="dropdown-menu">
                <li><a href="/paseos_el_puerto/ServletEmbarcacion?op=lista">Lista</a></li>
                <li><a href="/paseos_el_puerto/Propietarios/inserta_embarcacion.jsp">Registrar</a></li>
                <li><a href="/paseos_el_puerto/Propietarios/actualiza_embarcacion.jsp">Modificar</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a href="#">Propietarios</a>
            <ul class="dropdown-menu">
                <li><a href="/paseos_el_puerto/ServletPropietario?op=lista">Lista</a></li>
                <li><a href="/paseos_el_puerto/Propietarios/inserta_propietario.jsp">Registrar</a></li>
                <li><a href="/paseos_el_puerto/Propietarios/actualiza_propietario.jsp">Modificar</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a href="#">Alquileres</a>
            <ul class="dropdown-menu">
                <li><a href="#">Lista</a></li>
                <li><a href="#">Registrar</a></li>
                <li><a href="#">Modificar</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a href="#">Clientes</a>
            <ul class="dropdown-menu">
                <li><a href="/paseos_el_puerto/ServletCliente?op=lista" methods="GET">Lista</a></li>
                <li><a href="/paseos_el_puerto/Clientes/inserta_cliente.jsp">Registrar</a></li>
                <li><a href="/paseos_el_puerto/Clientes/actualiza_cliente.jsp">Modificar</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a href="#">Personal</a>
            <ul class="dropdown-menu">
                <li><a href="#">Lista</a></li>
                <li><a href="#">Registrar</a></li>
                <li><a href="#">Modificar</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a href="#">Mantenimiento</a>
            <ul class="dropdown-menu">
                <li><a href="#">Lista</a></li>
                <li><a href="#">Registrar</a></li>
                <li><a href="#">Modificar</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a href="#">Reparación</a>
            <ul class="dropdown-menu">
                <li><a href="#">Lista</a></li>
                <li><a href="#">Registrar</a></li>
                <li><a href="#">Modificar</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a href="#">Equipamiento</a>
            <ul class="dropdown-menu">
                <li><a href="#">Lista</a></li>
                <li><a href="#">Registrar</a></li>
                <li><a href="#">Modificar</a></li>
            </ul>
        </li>
    </ul>
</header>

<style>

    form{
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

<br>
<br>
<section class="container">
    <div class="parallax-content">
        <br>
        <form method="get" action="/paseos_el_puerto/ServletMantenimiento">
            <p>ID:<input type="text" name = "id_mantenimiento"></p>
            <input type="submit" class="button-minimal button-container" value="Buscar" name="op">
            <input type="submit" class="button-minimal" value="Eliminar" name="op">
            <input type="submit" class="button-minimal" style="margin-top: 9px" value="Finalizar" name="op">
        </form>
        <br>
        <a method="get" href="/paseos_el_puerto/ServletMantenimiento?op=listActivos">Mostrar mantenimientos activos</a>
        <div class="table-container">
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>ID Embarcación</th>
                    <th>Descripcion</th>
                    <th>Costo</th>
                    <th>Fecha_inicio</th>
                    <th>Fecha_fin</th>
                </tr>
                </thead>
                <tbody>
                <%
                    Mantenimiento mantenimiento = (Mantenimiento) request.getAttribute("mantenimiento");
                    ArrayList<Mantenimiento> lista = (ArrayList<Mantenimiento>) request.getAttribute("lista");

                    if (mantenimiento != null) {
                %>
                <tr>
                    <td><%= mantenimiento.getIdMantenimiento() %></td>
                    <td><%= mantenimiento.getIdEmbarcacion() %></td>
                    <td><%= mantenimiento.getDescripcion() %></td>
                    <td><%= mantenimiento.getCosto() %></td>
                    <td><%= mantenimiento.getFechaInicio() %></td>
                    <td><%= mantenimiento.getFechaFin() %></td>
                </tr>
                <% } else if (lista != null && !lista.isEmpty()) {
                    for (Mantenimiento manten : lista) {
                %>
                <tr>
                    <td><%= manten.getIdMantenimiento() %></td>
                    <td><%= manten.getIdEmbarcacion() %></td>
                    <td><%= manten.getDescripcion() %></td>
                    <td><%= manten.getCosto() %></td>
                    <td><%= manten.getFechaInicio() %></td>
                    <td><%= manten.getFechaFin() %></td>
                </tr>
                <% }
                } else { %>
                <tr>
                    <td colspan="6"><h1>No hay mantenimientos a mostrar</h1></td>
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>
    </div>
</section>
</body>
</html>