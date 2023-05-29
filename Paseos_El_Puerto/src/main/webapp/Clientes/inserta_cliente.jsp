<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inserta Cliente</title>
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

        <br/><br/>
        <form action="/paseos_el_puerto/ServletCliente" method="post">
            <p>Nombre <input type="text" name="nombre"></p>
            <p>Apellido Paterno <input type="text" name="ap_pat"></p>
            <p>Apellido Materno <input type="text" name="ap_mat"></p>
            <p>Dirección <input type="text" name="direccion"></p>
            <p>Telefono <input type="text" name="telefono"></p>
            <p>Correo <input type="text" name="email"></p>
            <p>Fecha de nacimiento <input type="text" name="fecha_nac"></p>
            <div class="button-container">
                <input type="submit" class="button-minimal" value="Registrar" name="op">
            </div>
        </form>

        <form action="/paseos_el_puerto/Clientes/menu_cliente.jsp">
            <input type="submit" class="button-minimal" value="Regresar"/>
        </form>
    </div>
</section>
</body>
</html>