<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Paseos "El Puerto"</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="styles.css">
    <link rel="stylesheet" type="text/css" href="navbar.css">
    <script src="animaciones.js"></script>
</head>
<body>
<header>
    <nav class="navigation">
        <ul>
            <li><a href="/paseos_el_puerto/index.jsp" class="logo-nav-container"><img src="/paseos_el_puerto/logo.png" alt="Logo"></a></li>
            <li class="dropdown">
                <a href="#" class="navigation-link">Embarcaciones</a>
                <ul class="dropdown-menu">
                    <li><a href="#">Lista</a></li>
                    <li><a href="#">Registrar</a></li>
                    <li><a href="#">Modificar</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="navigation-link">Propietarios</a>
                <ul class="dropdown-menu">
                    <li><a href="/paseos_el_puerto/ServletPropietario?op=lista">Lista</a></li>
                    <li><a href="/paseos_el_puerto/Propietarios/inserta_propietario.jsp">Registrar</a></li>
                    <li><a href="/paseos_el_puerto/Propietarios/actualiza_propietario.jsp">Modificar</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="navigation-link">Alquileres</a>
                <ul class="dropdown-menu">
                    <li><a href="#">Lista</a></li>
                    <li><a href="#">Registrar</a></li>
                    <li><a href="#">Modificar</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="navigation-link">Clientes</a>
                <ul class="dropdown-menu">
                    <li><a href="/paseos_el_puerto/ServletCliente?op=lista" methods="GET">Lista</a></li>
                    <li><a href="/paseos_el_puerto/Clientes/inserta_cliente.jsp">Registrar</a></li>
                    <li><a href="/paseos_el_puerto/Clientes/actualiza_cliente.jsp">Modificar</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="navigation-link">Personal</a>
                <ul class="dropdown-menu">
                    <li><a href="#">Lista</a></li>
                    <li><a href="#">Registrar</a></li>
                    <li><a href="#">Modificar</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="navigation-link">Mantenimiento</a>
                <ul class="dropdown-menu">
                    <li><a href="#">Lista</a></li>
                    <li><a href="#">Registrar</a></li>
                    <li><a href="#">Modificar</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="navigation-link">Reparación</a>
                <ul class="dropdown-menu">
                    <li><a href="#">Lista</a></li>
                    <li><a href="#">Registrar</a></li>
                    <li><a href="#">Modificar</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="navigation-link">Equipamiento</a>
                <ul class="dropdown-menu">
                    <li><a href="#">Lista</a></li>
                    <li><a href="#">Registrar</a></li>
                    <li><a href="#">Modificar</a></li>
                </ul>
            </li>
        </ul>
    </nav>
</header>

<section class="parallax-section">
    <div class="parallax-content">
    </div>
</section>
<section class="container">
<div class="parallax-content">
<h1 class="fade-in">Descripción del proyecto</h1>
<p class="fade-in">
    Paseos "El Puerto" es una agencia que alquila embarcaciones a sus clientes mediante una tarjeta
    de membresía. Nuestro objetivo es brindar a nuestros clientes una experiencia inolvidable en el mar,
    ofreciendo una amplia selección de embarcaciones de alta calidad y servicios personalizados.
</p>

<h1 class="fade-in">Servicios ofrecidos:</h1>
<ul class="fade-in">
    <li>Alquiler de embarcaciones de diferentes tamaños y capacidades.</li>
    <li>Tours guiados por lugares turísticos y pintorescos.</li>
    <li>Equipo de buceo y snorkel disponible para los amantes del agua.</li>
    <li>Servicios de catering y eventos especiales a bordo.</li>
    <li>Transporte y traslado desde y hacia el puerto.</li>
</ul>

<h1 class="fade-in">Beneficios de la membresía:</h1>
<ul class="fade-in">
    <li>Descuentos exclusivos en alquileres y servicios adicionales.</li>
    <li>Acceso prioritario a las embarcaciones más populares.</li>
    <li>Asistencia personalizada para planificar su viaje.</li>
    <li>Invitaciones a eventos y actividades especiales.</li>
    <li>Programa de puntos para acumular beneficios adicionales.</li>
</ul>
</div>
</section>
<footer class="footer">
    <div class="container">
        <p>© 2023 Paseos "El Puerto". Todos los derechos reservados.</p>
    </div>
</footer>
</body>
</html>
