<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Reparacion" %>

<html>
<head>
    <title>Lista Reparacion</title>
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
            <a href="#">Embarcaciones</a>
            <ul class="dropdown-menu">
                <li><a href="/paseos_el_puerto/ServletEmbarcacion?op=lista">Lista</a></li>
                <li><a href="/paseos_el_puerto/Embarcaciones/inserta_embarcacion.jsp">Registrar</a></li>
                <li><a href="/paseos_el_puerto/Embarcaciones/actualiza_embarcacion.jsp">Modificar</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a href="#">Contratos</a>
            <ul class="dropdown-menu">
                <li><a href="/paseos_el_puerto/ServletContrato?op=lista">Lista</a></li>
                <li><a href="/paseos_el_puerto/Contratos/actualiza_contrato.jsp">Modificar</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a href="#">Paseos</a>
            <ul class="dropdown-menu">
                <li><a href="/paseos_el_puerto/ServletPaseo?op=lista">Lista</a></li>
                <li><a href="/paseos_el_puerto/ServletPaseo?op=listaEmb">Nuevo</a></li>
                <li><a href="/paseos_el_puerto/Paseos/actualiza_paseo.jsp">Modificar</a></li>
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
                <li><a href="/paseos_el_puerto/ServletPersonal?op=lista" methods="GET">Lista</a></li>
                <li><a href="/paseos_el_puerto/Personal/inserta_personal.jsp">Registrar</a></li>
                <li><a href="/paseos_el_puerto/Personal/actualiza_personal.jsp">Modificar</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a href="#">Reparación</a>
            <ul class="dropdown-menu">
                <li><a href="/paseos_el_puerto/ServletReparacion?op=lista">Lista</a></li>
                <li><a href="/paseos_el_puerto/Reparacion/inserta_reparacion.jsp">Registrar</a></li>
                <li><a href="/paseos_el_puerto/Reparacion/actualiza_reparacion.jsp">Modificar</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a href="#">Mantenimiento</a>
            <ul class="dropdown-menu">
                <li><a href="/paseos_el_puerto/ServletMantenimiento?op=lista">Lista</a></li>
                <li><a href="/paseos_el_puerto/Mantenimiento/inserta_mantenimiento.jsp">Registrar</a></li>
                <li><a href="/paseos_el_puerto/Mantenimiento/actualiza_mantenimiento.jsp">Modificar</a></li>
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
        <form method="get" action="/paseos_el_puerto/ServletReparacion">
            <p>ID:<input type="text" name = "id_reparacion"></p>
            <input type="submit" class="button-minimal button-container" value="Buscar" name="op">
            <input type="submit" class="button-minimal" value="Eliminar" name="op">
            <input type="submit" class="button-minimal" style="margin-top: 9px" value="Finalizar" name="op">
        </form>
        <br>
        <a method="get" href="/paseos_el_puerto/ServletReparacion?op=listActivos">Mostrar reparaciones activas</a>
        <div class="table-container">
            <table>
                <thead>
                <tr>
                    <th>ID Reparacion</th>
                    <th>ID Embarcación</th>
                    <th>ID Paseo</th>
                    <th>Descripcion</th>
                    <th>Costo</th>
                    <th>Fecha_inicio</th>
                    <th>Fecha_fin</th>
                </tr>
                </thead>
                <tbody>
                <%
                    Reparacion reparacion = (Reparacion) request.getAttribute("reparacion");
                    ArrayList<Reparacion> lista = (ArrayList<Reparacion>) request.getAttribute("lista");

                    if (reparacion != null) {
                %>
                <tr>
                    <td><%= reparacion.getIdReparacion() %></td>
                    <td><%= reparacion.getIdEmbarcacion() %></td>
                    <td><%= reparacion.getIdPaseo() %></td>
                    <td><%= reparacion.getDescripcion() %></td>
                    <td><%= reparacion.getCosto() %></td>
                    <td><%= reparacion.getFechaInicio() %></td>
                    <td><%= reparacion.getFechaFin() %></td>
                </tr>
                <% } else if (lista != null && !lista.isEmpty()) {
                    for (Reparacion repair : lista) {
                %>
                <tr>
                    <td><%= repair.getIdReparacion() %></td>
                    <td><%= repair.getIdEmbarcacion() %></td>
                    <td><%= repair.getIdPaseo() %></td>
                    <td><%= repair.getDescripcion() %></td>
                    <td><%= repair.getCosto() %></td>
                    <td><%= repair.getFechaInicio() %></td>
                    <td><%= repair.getFechaFin() %></td>
                </tr>
                <% }
                } else { %>
                <tr>
                    <td colspan="6"><h1>No hay reparaciones a mostrar</h1></td>
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>
    </div>
</section>
</body>
</html>