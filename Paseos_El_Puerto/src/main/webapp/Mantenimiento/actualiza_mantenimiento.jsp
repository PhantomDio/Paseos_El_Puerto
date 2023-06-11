<%@ page import="model.Mantenimiento" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Actualiza Embarcación</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="/paseos_el_puerto/styles.css">
    <link rel="stylesheet" type="text/css" href="/paseos_el_puerto/navbar.css">
    <script src="/paseos_el_puerto/animaciones.js"></script>
    <script src="/paseos_el_puerto/Formato_fecha.js"></script>
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
        var url = '/paseos_el_puerto/ServletMantenimiento?op=Autollenado&id=' + id;

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
        <h1>Modificar Mantenimiento</h1>
        <br>
        <% Mantenimiento mantenimiento = (Mantenimiento) request.getAttribute("mantenimiento"); %>

        <form action="/paseos_el_puerto/ServletMantenimiento" method="post" onsubmit="return validarFormulario2()">
            <p>ID_Mantenimiento : <input type="text" name="id_mantenimiento" id="id" onblur="autollenar()"></p>
            <% if (mantenimiento != null) { %>
            <p>ID_Embarcación: <input type="text" value="<%=mantenimiento.getIdEmbarcacion()%>" name="id_embarcacion"></p>
            <p>Descripción: <input type="text" name="descripcion" value="<%=mantenimiento.getDescripcion()%>" placeholder="(yyyy-mm-dd)"></p>
            <p>Costo: <input type="text" name="costo" value="<%=mantenimiento.getCosto()%>"></p>
            <p>Fecha de inicio: <input type="text" name="fecha_inicio" value="<%=mantenimiento.getFechaInicio()%>"></p>
            <p>Fecha de fin: <input type="text" name="fecha_fin" value="<%=mantenimiento.getFechaFin()%>"></p>
            <% } else { %>
            <p>ID_Embarcación: <input type="text" name="id_embarcacion"></p>
            <p>Descripción: <input type="text" name="descripcion" placeholder="(yyyy-mm-dd)"></p>
            <p>Costo: <input type="text" name="costo"></p>
            <p>Fecha de inicio: <input type="text" name="fecha_inicio" placeholder="(yyyy-mm-dd)"></p>
            <p>Fecha de fin: <input type="text" name="fecha_fin" placeholder="(yyyy-mm-dd)"></p>
            <% } %>
            <br>
            <br>
            <div class="button-container">
                <input type="submit" class="button-minimal" value="Modificar" name="op" onclick="validarFormulario() ? this.form.submit() : false">
            </div>
        </form>

    </div>
</section>
</body>
</html>