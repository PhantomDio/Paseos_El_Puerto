<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inserta Cliente</title>
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
            function clearValue(input) {
                if (input.dataset.clicked !== "true") {
                    input.value = '';
                    input.dataset.clicked = "true";
                }
            }

            function validarFormulario() {
                var fechaInput = document.querySelector('input[name="fecha_nac"]');
                var fechaValue = fechaInput.value;
                var regex = /^\d{4}-\d{2}-\d{2}$/;

                if (!regex.test(fechaValue)) {
                    alert("El formato de fecha debe ser (yyyy-mm-dd).");
                    fechaInput.value = '';
                    return false;
                }

                return true;
            }
        </script>

<br>
<br>
<section class="container">
    <div class="parallax-content">
        <br>
        <h1>Nuevo Cliente</h1>
        <br>
        <form action="/paseos_el_puerto/ServletCliente" method="post" onsubmit="return validarFormulario()">
            <p>Nombre: <input type="text" name="nombre"></p>
            <p>Apellido Paterno: <input type="text" name="ap_pat"></p>
            <p>Apellido Materno: <input type="text" name="ap_mat"></p>
            <p>Dirección: <input type="text" name="direccion"></p>
            <p>Teléfono: <input type="text" name="telefono"></p>
            <p>Correo: <input type="text" name="email"></p>
            <p>Fecha de nacimiento: <input type="text" name="fecha_nac" value="(yyyy-mm-dd)" onclick="clearValue(this)"></p>
            <br>
            <br>
            <div class="button-container">
                <input type="button" class="button-minimal" value="Registrar" name="op" onclick="validarFormulario() ? this.form.submit() : false">
            </div>
        </form>
    </div>
</section>
</body>
</html>