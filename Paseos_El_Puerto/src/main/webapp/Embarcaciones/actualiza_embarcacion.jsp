<%@ page import="model.Embarcaciones" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Actualiza Embarcación</title>
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
                <li><a href="/paseos_el_puerto/Embarcaciones/inserta_reparacion.jsp">Registrar</a></li>
                <li><a href="/paseos_el_puerto/Embarcaciones/actualiza_reparacion.jsp">Modificar</a></li>
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
<script>
    function autollenar() {
        var id = document.getElementById('id').value;
        var url = '/paseos_el_puerto/ServletEmbarcacion?op=Autollenado&id=' + id;

        // Almacenar el valor de id_paseo en el almacenamiento local del navegador
        localStorage.setItem('id', id);

        // Realizar redirección a la página de actualización con los parámetros en la URL
        window.location.href = url;
    }

    // Obtener el valor de id_paseo del almacenamiento local y asignarlo al campo después de cargar la página
    window.addEventListener('DOMContentLoaded', function() {
        var id = localStorage.getItem('id');
        if (id) {
            document.getElementById('id').value = id;
        }
    });
</script>
<br>
<br>
<section class="container">
    <div class="parallax-content">
        <br>
        <h1>Modificar Embarcaciones</h1>
        <br>
        <% Embarcaciones embarcacion = (Embarcaciones) request.getAttribute("embarcacion"); %>

        <form action="/paseos_el_puerto/ServletEmbarcacion" method="post">
            <p>ID_Embarcación: <input type="text" name="id_embarcacion" id="id" onblur="autollenar()"></p>
            <% if (embarcacion != null) { %>
            <p>Nombre: <input type="text" name="nombre" value="<%=embarcacion.getNombre()%>"></p>
            <p>Modelo: <input type="text" name="modelo" value="<%=embarcacion.getModelo()%>"></p>
            <p>Longitud<input type="text" name="longitud" value="<%=embarcacion.getLongitud()%>"></p>
            <p>Año: <input type="text" name="anio" value="<%=embarcacion.getAnio()%>"></p>
            <% } else { %>
            <p>Nombre: <input type="text" name="nombre"></p>
            <p>Modelo: <input type="text" name="modelo"></p>
            <p>Longitud<input type="text" name="longitud"></p>
            <p>Año: <input type="text" name="anio"></p>
            <% } %>
            <br>
            <div class="button-container">
                <input type="submit" class="button-minimal" value="Modificar" name="op">
            </div>
        </form>

    </div>
</section>
</body>
</html>