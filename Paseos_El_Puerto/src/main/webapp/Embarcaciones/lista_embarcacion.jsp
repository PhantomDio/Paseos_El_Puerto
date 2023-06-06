<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Embarcaciones" %>
<%@ page import="java.util.Collections" %>
<html>
<head>
    <title>Lista Embarcaciones</title>
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
        <form method="get" action="/paseos_el_puerto/ServletEmbarcacion">
            <p>ID:<input type="text" name = "id_embarcacion"></p>
            <input type="submit" class="button-minimal button-container" value="Buscar" name="op">
            <input type="submit" class="button-minimal" value="Eliminar" name="op">
        </form>
        <br>
        <a href="/paseos_el_puerto/ServletEmbarcacion">Mostrar lista completa</a>
        <div class="table-container">
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Modelo</th>
                    <th>Longitud</th>
                    <th>Año</th>
                    <th>Nombre_Propietario</th>
                    <th>Costo_Hora</th>
                    <th>Contrato</th>
                    <th>Estado</th>
                </tr>
                </thead>
                <tbody>
                <%
                    Embarcaciones embarcacion = (Embarcaciones) request.getAttribute("embarcacion");
                    ArrayList<Embarcaciones> lista = (ArrayList<Embarcaciones>) request.getAttribute("lista");
                    ArrayList<Embarcaciones> listaSinDuplicados = new ArrayList<Embarcaciones>();

                    for (Embarcaciones e : lista) {
                        if (!listaSinDuplicados.contains(e)) {
                            listaSinDuplicados.add(e);
                        }
                    }

                    if (embarcacion != null) {
                %>
                <tr>
                    <td><%= embarcacion.getIdEmbarcacion() %></td>
                    <td><%= embarcacion.getNombre() %></td>
                    <td><%= embarcacion.getModelo() %></td>
                    <td><%= embarcacion.getLongitud() %></td>
                    <td><%= embarcacion.getAnio() %></td>
                    <td><%= embarcacion.getNombreProp() %></td>
                    <td><%= embarcacion.getCostoHora() %></td>
                        <%
                    if (embarcacion.getFechaFinContrato() != null){
                        %>
                    <td><%= embarcacion.getEstadoContrato(embarcacion.getFechaFinContrato()) %></td>
                    <td><%= embarcacion.getEstado(embarcacion.getIdEmbarcacion(), embarcacion.getFechaFinContrato()) %></td>
                    <%
                    } else {
                    %>
                    <td>Sin contrato</td>
                    <td>No disponible</td>
                    <%
                        }
                    %>
                </tr>
                <% } else if (listaSinDuplicados != null && !listaSinDuplicados.isEmpty()) {
                    for (Embarcaciones embarc : listaSinDuplicados) {
                %>
                <tr>
                    <td><%= embarc.getIdEmbarcacion() %></td>
                    <td><%= embarc.getNombre() %></td>
                    <td><%= embarc.getModelo() %></td>
                    <td><%= embarc.getLongitud() %></td>
                    <td><%= embarc.getAnio() %></td>
                    <td><%= embarc.getNombreProp() %></td>
                    <td><%= embarc.getCostoHora() %></td>
                    <%
                        if (embarc.getFechaFinContrato() != null){
                    %>
                    <td><%= embarc.getEstadoContrato(embarc.getFechaFinContrato()) %></td>
                    <td><%= embarc.getEstado(embarc.getIdEmbarcacion(), embarc.getFechaFinContrato()) %></td>
                    <%
                    } else {
                    %>
                    <td>Sin contrato</td>
                    <td>No disponible</td>
                    <%
                        }
                    %>
                </tr>
                <%
                }
                    } else { %>
                    <td colspan="9"><h1>No hay embarcaciones a mostrar</h1></td>
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>
    </div>
</section>
</body>
</html>