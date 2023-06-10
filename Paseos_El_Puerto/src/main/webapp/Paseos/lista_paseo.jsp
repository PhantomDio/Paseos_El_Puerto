<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Paseos" %>
<html>
<head>
    <title>Lista Paseos</title>
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
            <a href="#">Paseos</a>
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
        <form method="get" action="/paseos_el_puerto/ServletPaseo">
            <p>ID:<input type="text" name = "id_paseo"></p>
            <input type="submit" class="button-minimal button-container" value="Buscar" name="op">
            <input type="submit" class="button-minimal" value="Eliminar" name="op">
        </form>
        <br>
        <a href="/paseos_el_puerto/ServletPaseo">Mostrar lista completa</a>
        <div class="table-container">
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Fecha_inicio</th>
                    <th>Fecha___fin</th>
                    <th>ID
                        Embarcacion</th>
                    <th>Nombre_Embarcacion</th>
                    <th>ID
                        Propietario</th>
                    <th>Nombre_Propietario</th>
                    <th>ID
                        Cliente</th>
                    <th>Nombre_Cliente</th>
                    <th>Monto_total</th>
                    <th>Estado</th>
                </tr>
                </thead>
                <tbody>
                <%
                    Paseos paseo = (Paseos) request.getAttribute("paseo");
                    ArrayList<Paseos> lista = (ArrayList<Paseos>) request.getAttribute("lista");

                    if (paseo != null) {
                %>
                <tr>
                    <td><%= paseo.getIdPaseo() %></td>
                    <td><%= paseo.getFechaInicioPaseo() %></td>
                    <td><%= paseo.getFechaFinPaseo() %></td>
                    <td><%= paseo.getIdEmbarcacion() %></td>
                    <td><%= paseo.getNombreEmbarcacion() %></td>
                    <td><%= paseo.getIdPropietario() %></td>
                    <td><%= paseo.getNombreProp() %></td>
                    <td><%= paseo.getIdCliente() %></td>
                    <td><%= paseo.getNombreCliente() %></td>
                    <td>$<%= paseo.getMontoTotalBD() %></td>
                    <td><%= paseo.getEstadoPaseo(paseo.getFechaFinPaseo()) %></td>
                </tr>
                <% 
                    } else if (lista != null && !lista.isEmpty()) {
                    for (Paseos paseos : lista) {
                %>
                <tr>
                    <td><%= paseos.getIdPaseo() %></td>
                    <td><%= paseos.getFechaInicioPaseo() %></td>
                    <td><%= paseos.getFechaFinPaseo() %></td>
                    <td><%= paseos.getIdEmbarcacion() %></td>
                    <td><%= paseos.getNombreEmbarcacion() %></td>
                    <td><%= paseos.getIdPropietario() %></td>
                    <td><%= paseos.getNombreProp() %></td>
                    <td><%= paseos.getIdCliente() %></td>
                    <td><%= paseos.getNombreCliente() %></td>
                    <td>$<%= paseos.getMontoTotalBD() %></td>
                    <td><%= paseos.getEstadoPaseo(paseos.getFechaFinPaseo()) %></td>
                </tr>
                <%
                    }
                } else { %>
                    <td colspan="9"><h1>No hay paseos a mostrar</h1></td>
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>
    </div>
</section>
</body>
</html>