<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inserta Cliente</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="/paseos_el_puerto/styles.css">
    <script src="/paseos_el_puerto/animaciones.js"></script>
</head>
<body class="container_body">
<style>
    .navigation {
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        z-index: 999;
        height: 80px;
        background-color: transparent;
        transition: background-color 0.3s ease;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .navigation:hover,
    .navigation.scrolled {
        background-color: #5d4e3c;
    }

    .navigation ul {
        list-style: none;
        display: flex;
        align-items: center;
        margin: 0;
        padding: 0;
    }

    .navigation a {
        color: #333;
        transition: color 0.3s ease;
        text-decoration: none;
        font-size: 20px;
    }

    .navigation:hover a,
    .navigation.scrolled a {
        color: #f8f8f8;
    }

    .logo-nav-container {
        display: flex;
        align-items: center;
        justify-content: space-between;
        margin-right: 36px;
    }

    .logo-nav-container img {
        max-height: 45px;
    }

    .dropdown {
        position: relative;
        display: inline-block;
        margin-right: 15px; /* Espacio entre las opciones principales */
        text-transform: uppercase;
    }

    .dropdown-menu {
        display: block;
        position: absolute;
        top: 100%;
        left: 0;
        z-index: 1;
        padding: 10px;
        min-width: 150px;
        opacity: 0%;
    }

    .dropdown:hover .dropdown-menu {
        display: block;
        background-color: #5d4e3c;
        opacity: 100%;
    }

    .dropdown-menu li {margin-top: 20px;}

    .navigation-link:hover > a {
        background-color: #5d4e3c;
        color: #f8f8f8;
    }

    .navigation-link:hover .dropdown-menu {
        display: block;
    }
</style>
<header>
    <nav class="navigation">
        <ul>
            <li><a href="/paseos_el_puerto/index.jsp" class="logo-nav-container"><img src="/paseos_el_puerto/logo.png" alt="Logo"></a></li>
            <li class="dropdown">
                <a href="#" class="navigation-link">Embarcaciones</a>
                <ul class="dropdown-menu">
                    <li><a href="#">Lista</a></li>
                    <li><a href="#">Registrar</a></li>
                    <li><a href="#">Actualizar</a></li>
                    <li><a href="#">Eliminar</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="navigation-link">Propietarios</a>
                <ul class="dropdown-menu">
                    <li><a href="#">Lista</a></li>
                    <li><a href="#">Registrar</a></li>
                    <li><a href="#">Actualizar</a></li>
                    <li><a href="#">Eliminar</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="navigation-link">Alquileres</a>
                <ul class="dropdown-menu">
                    <li><a href="#">Lista</a></li>
                    <li><a href="#">Registrar</a></li>
                    <li><a href="#">Actualizar</a></li>
                    <li><a href="#">Eliminar</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="navigation-link">Clientes</a>
                <ul class="dropdown-menu">
                    <li><a href="/paseos_el_puerto/ServletCliente?op=lista" methods="POST">
                        Lista
                    </a></li>
                    <li><a href="/paseos_el_puerto/Clientes/inserta_cliente.jsp">Registrar</a></li>
                    <li><a href="#">Actualizar</a></li>
                    <li><a href="#">Eliminar</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="navigation-link">Personal</a>
                <ul class="dropdown-menu">
                    <li><a href="#">Lista</a></li>
                    <li><a href="#">Registrar</a></li>
                    <li><a href="#">Actualizar</a></li>
                    <li><a href="#">Eliminar</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="navigation-link">Mantenimiento</a>
                <ul class="dropdown-menu">
                    <li><a href="#">Lista</a></li>
                    <li><a href="#">Registrar</a></li>
                    <li><a href="#">Actualizar</a></li>
                    <li><a href="#">Eliminar</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="navigation-link">Reparación</a>
                <ul class="dropdown-menu">
                    <li><a href="#">Lista</a></li>
                    <li><a href="#">Registrar</a></li>
                    <li><a href="#">Actualizar</a></li>
                    <li><a href="#">Eliminar</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="navigation-link">Equipamiento</a>
                <ul class="dropdown-menu">
                    <li><a href="#">Lista</a></li>
                    <li><a href="#">Registrar</a></li>
                    <li><a href="#">Actualizar</a></li>
                    <li><a href="#">Eliminar</a></li>
                </ul>
            </li>
        </ul>
    </nav>
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

    </div>
</section>
</body>
</html>