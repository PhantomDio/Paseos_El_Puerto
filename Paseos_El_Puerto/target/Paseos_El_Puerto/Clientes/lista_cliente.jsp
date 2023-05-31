<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Clientes" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <title>Lista Clientes</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="/paseos_el_puerto/styles.css">
    <link rel="stylesheet" type="text/css" href="/paseos_el_puerto/navbar.css">
    <script src="/paseos_el_puerto/animaciones.js"></script>
</head>
<body class="container_body">
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
                    <li><a href="/paseos_el_puerto/ServletCliente?op=lista" methods="POST">Lista</a></li>
                    <li><a href="/paseos_el_puerto/Clientes/inserta_cliente.jsp">Registrar</a></li>
                    <li><a href="/paseos_el_puerto/Clientes/actualiza_cliente.jsp">Actualizar</a></li>
                    <li><a href="/paseos_el_puerto/Clientes/elimina_cliente.jsp">Eliminar</a></li>
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
        <br>
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