<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Contratos" %>

<html>
<head>
    <title>Lista Contratos</title>
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
        <form method="get" action="/paseos_el_puerto/ServletContrato">
            <p>ID:<input type="text" name = "id_contrato"></p>
            <input type="submit" class="button-minimal button-container" value="Buscar" name="op">
            <input type="submit" class="button-minimal" value="Eliminar" name="op">
        </form>
        <br>
        <a href="/paseos_el_puerto/ServletContrato">Mostrar lista completa</a>
        <div class="table-container">
            <table>
                <thead>
                <tr>
                    <th>ID Contrato</th>
                    <th>ID Embarcación</th>
                    <th>Fecha_inicio</th>
                    <th>Fecha_fin</th>
                    <th>Costo_hora</th>
                    <th>Estado</th>
                </tr>
                </thead>
                <tbody>
                <%
                    Contratos contrato = (Contratos) request.getAttribute("contrato");
                    ArrayList<Contratos> lista = (ArrayList<Contratos>) request.getAttribute("lista");

                    if (contrato != null) {
                %>
                <tr>
                    <td><%= contrato.getIdContrato() %></td>
                    <td><%= contrato.getIdEmbarcacion() %></td>
                    <td><%= contrato.getFechaInicio() %></td>
                    <td><%= contrato.getFechaFin() %></td>
                    <td><%= contrato.getCostoHora() %></td>
                    <td><%= contrato.getEstado(contrato.getFechaFin()) %></td>
                </tr>
                <% } else if (lista != null && !lista.isEmpty()) {
                    for (Contratos contrat : lista) {
                %>
                <tr>
                    <td><%= contrat.getIdContrato() %></td>
                    <td><%= contrat.getIdEmbarcacion() %></td>
                    <td><%= contrat.getFechaInicio() %></td>
                    <td><%= contrat.getFechaFin() %></td>
                    <td><%= contrat.getCostoHora() %></td>
                    <td><%= contrat.getEstado(contrat.getFechaFin()) %></td>
                </tr>
                <% }
                } else { %>
                <tr>
                    <td colspan="6"><h1>No hay contratos a mostrar</h1></td>
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>
    </div>
</section>
</body>
</html>