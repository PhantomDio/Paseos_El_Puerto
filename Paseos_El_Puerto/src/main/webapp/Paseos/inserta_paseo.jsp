<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Embarcaciones" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>Nuevo Paseo</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="/paseos_el_puerto/styles.css">
    <link rel="stylesheet" type="text/css" href="/paseos_el_puerto/navbar.css">
    <script src="/paseos_el_puerto/animaciones.js"></script>
    <script src="/paseos_el_puerto/Utilidades.js"></script>
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
        width: 200px; /* Ajusta el ancho según sea necesario */
    }
</style>
<br>
<br>
<section class="container">
    <div class="parallax-content">
        <br>
        <h1>Nuevo Paseo</h1>
        <br>
        <form action="/paseos_el_puerto/ServletPaseo" method="post" onsubmit="return validarFormulario2()">
            <p>ID_Embarcación: <input type="text" name="id_embarcacion"></p>
            <p>ID_Cliente: <input type="text" name="id_cliente"></p>
            <p>Fecha_inicio: <input type="text" placeholder="(yyyy-mm-dd)" name="fecha_inicio"></p>
            <p>Fecha_fin: <input type="text" placeholder="(yyyy-mm-dd)" name="fecha_fin"></p>
            <br>
            <br>
            <div class="button-container">
                <input type="submit" class="button-minimal" value="Registrar" name="op">
            </div>
        </form>
        </div>
        <br>
        <div class="table-container">
            <h1>Embarcaciones disponibles</h1>
            <a href="/paseos_el_puerto/ServletPaseo?op=listaEmb">Actualizar lista</a>
            <br>
            <br>
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
                </tr>
                </thead>
                <tbody>
                <%
                    ArrayList<Embarcaciones> lista = (ArrayList<Embarcaciones>) request.getAttribute("listaemb");
                    ArrayList<Embarcaciones> listaSinDuplicados = new ArrayList<Embarcaciones>();

                    if (lista != null && !lista.isEmpty()) {
                        for (Embarcaciones e : lista) {
                            if (!listaSinDuplicados.contains(e)) {
                                listaSinDuplicados.add(e);
                            }
                        }

                    for (Embarcaciones embarc : listaSinDuplicados) {
                        if (embarc.getFechaFinContrato() != null ) {
                          if(embarc.getEstado(embarc.getIdEmbarcacion(), embarc.getFechaFinContrato()).equals("Disponible")){
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
                    }
                    }
                    }
                    }
                            else { %>
                <td colspan="9"><h1>No hay embarcaciones disponibles</h1></td>
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>
</section>
</body>
</html>