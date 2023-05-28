<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menú Cliente</title>
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
                <li><a href="Clientes/menu_cliente.jsp" class="navigation-link">Clientes</a></li>
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
        <br/><h1>Cliente</h1>
        <br>
        <form class="center" action="/paseos_el_puerto/Cliente/cliente.jsp">
            <input type="submit" class=" opc opc-green" value="Lista de Clientes">
        </form><br>

        <form class="center" action="/paseos_el_puerto/Cliente/inserta_cliente.jsp">
            <input type="submit" class=" opc opc-green" value="Inserta Cliente">
        </form><br>
        <form class="center" action="/paseos_el_puerto/Cliente/actualiza_cliente.jsp">
            <input type="submit" class=" opc opc-green" value="Actualiza Cliente">
        </form><br>
        <form class="center" action="/paseos_el_puerto/Cliente/elimina_cliente.jsp">
            <input type="submit" class=" opc opc-green" value="Elimina Cliente">
        </form>
    </div><br>
</section>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="/XMenWebProject/javaS1.js"></script>
</body>
</html>