<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menú Cliente</title>
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
                <li><a href="menu_cliente.jsp" class="navigation-link">Clientes</a></li>
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
        <h1>Clientes</h1>
        <div class="button-container">
        <a href="/paseos_el_puerto/ServletCliente?opc=lista" methods="POST">
            <input type="submit" class="button-minimal" value="Lista de Clientes">
        </a></div>
        <div class="button-container">
            <a href="/paseos_el_puerto/ServletCliente?opc=lista" methods="POST">
                <input type="submit" class="button-minimal" value="Registrar Cliente">
            </a></div>
        <div class="button-container">
            <a href="/paseos_el_puerto/ServletCliente?opc=lista" methods="POST">
                <input type="submit" class="button-minimal" value="Actualizar Cliente">
            </a></div>
        <div class="button-container">
            <a href="/paseos_el_puerto/ServletCliente?opc=lista" methods="POST">
                <input type="submit" class="button-minimal" value="Eliminar Cliente">
            </a></div>
    </div>
</section>

</body>
</html>