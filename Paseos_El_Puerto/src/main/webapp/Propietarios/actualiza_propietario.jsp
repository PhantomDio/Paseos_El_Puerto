<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Actualiza Propietario</title>
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
                    <li><a href="#">Modificar</a></li>
                    <li><a href="#">Eliminar</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="navigation-link">Propietarios</a>
                <ul class="dropdown-menu">
                    <li><a href="#">Lista</a></li>
                    <li><a href="#">Registrar</a></li>
                    <li><a href="#">Modificar</a></li>
                    <li><a href="#">Eliminar</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="navigation-link">Alquileres</a>
                <ul class="dropdown-menu">
                    <li><a href="#">Lista</a></li>
                    <li><a href="#">Registrar</a></li>
                    <li><a href="#">Modificar</a></li>
                    <li><a href="#">Eliminar</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="navigation-link">Clientes</a>
                <ul class="dropdown-menu">
                    <li><a href="/paseos_el_puerto/ServletPropietario?op=lista" methods="GET">Lista</a></li>
                    <li><a href="/paseos_el_puerto/Clientes/inserta_cliente.jsp">Registrar</a></li>
                    <li><a href="/paseos_el_puerto/Clientes/actualiza_cliente.jsp">Modificar</a></li>
                    <li><a href="/paseos_el_puerto/Clientes/elimina_cliente.jsp">Eliminar</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="navigation-link">Personal</a>
                <ul class="dropdown-menu">
                    <li><a href="#">Lista</a></li>
                    <li><a href="#">Registrar</a></li>
                    <li><a href="#">Modificar</a></li>
                    <li><a href="#">Eliminar</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="navigation-link">Mantenimiento</a>
                <ul class="dropdown-menu">
                    <li><a href="#">Lista</a></li>
                    <li><a href="#">Registrar</a></li>
                    <li><a href="#">Modificar</a></li>
                    <li><a href="#">Eliminar</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="navigation-link">Reparación</a>
                <ul class="dropdown-menu">
                    <li><a href="#">Lista</a></li>
                    <li><a href="#">Registrar</a></li>
                    <li><a href="#">Modificar</a></li>
                    <li><a href="#">Eliminar</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="navigation-link">Equipamiento</a>
                <ul class="dropdown-menu">
                    <li><a href="#">Lista</a></li>
                    <li><a href="#">Registrar</a></li>
                    <li><a href="#">Modificar</a></li>
                    <li><a href="#">Eliminar</a></li>
                </ul>
            </li>
        </ul>
    </nav>
</header>

<section class="container">
    <div class="parallax-content">
        <style>
            body {
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }

            form {
                display: flex;
                flex-direction: column;
            }

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
                var formato = /^\d{4}-\d{2}-\d{2}$/;

                if (!formato.test(fechaValue)) {
                    alert("El formato de fecha debe ser (yyyy-mm-dd).");
                    fechaInput.value = '';
                    return false;
                }

                return true;
            }
        </script>

        <form action="/paseos_el_puerto/ServletPropietario" method="post" onsubmit="return validarFormulario()">
            <p>ID: <input type="text" name="id_propietario"></p>
            <p>Nombre: <input type="text" name="nombre"></p>
            <p>Apellido Paterno: <input type="text" name="ap_pat"></p>
            <p>Apellido Materno: <input type="text" name="ap_mat"></p>
            <p>Dirección: <input type="text" name="direccion"></p>
            <p>Teléfono: <input type="text" name="telefono"></p>
            <p>Correo: <input type="text" name="email"></p>
            <p>Fecha de nacimiento: <input type="text" name="fecha_nac" value="(yyyy-mm-dd)" onclick="clearValue(this)"></p>
            <br>
            <div class="button-container">
                <input type="submit" class="button-minimal" value="Modificar" name="op" onclick="validarFormulario() ? this.form.submit() : false">
            </div>
        </form>

    </div>
</section>
</body>
</html>