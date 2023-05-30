<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Clientes" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <title>Lista Clientes</title>
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
        <a href="/paseos_el_puerto/ServletCliente"><input type="submit" class="button-minimal" value="Actualizar lista"/></a>
        <div class="table-container">
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Apellido Paterno</th>
                <th>Apellido Materno</th>
                <th>Dirección</th>
                <th>Telefono</th>
                <th>E-mail</th>
                <th>Fecha de nacimiento</th>
            </tr>
            </thead>
            <%List<Clientes> listaClientes = (List<Clientes>) request.getAttribute("listaClientes");
                if (listaClientes != null){
                    for (Clientes cliente : listaClientes){
            %>
            <tr>
                <td><%= cliente.getIdCliente() %></td>
                <td><%= cliente.getNombre() %></td>
                <td><%= cliente.getApellidoP() %></td>
                <td><%= cliente.getApellidoM() %></td>
                <td><%= cliente.getDireccion() %></td>
                <td><%= cliente.getTelefono() %></td>
                <td><%= cliente.getEmail() %></td>
                <td><%= cliente.getFecha_nac() %></td>
            </tr>
            <%
                    }
            }
            else
            session.removeAttribute("listaClientes");
        %>
        </table>
        </div>
    </div>
</section>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</body>
</html>