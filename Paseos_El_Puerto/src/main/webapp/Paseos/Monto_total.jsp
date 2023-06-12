<%@ page import="model.Paseos" %>
<%@ page import="datos.PaseosDAO" %>
<%@ page import="model.Personal" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Monto_total</title>
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
                <li><a href="/paseos_el_puerto/Embarcaciones/inserta_embarcacion.jsp">Registrar</a></li>
                <li><a href="/paseos_el_puerto/Embarcaciones/actualiza_embarcacion.jsp">Modificar</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a href="#">Contratos</a>
            <ul class="dropdown-menu">
                <li><a href="/paseos_el_puerto/ServletContrato?op=lista">Lista</a></li>
                <li><a href="/paseos_el_puerto/Contratos/actualiza_contrato.jsp">Modificar</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a href="#">Paseos</a>
            <ul class="dropdown-menu">
                <li><a href="/paseos_el_puerto/ServletPaseo?op=lista">Lista</a></li>
                <li><a href="/paseos_el_puerto/ServletPaseo?op=listaEmb">Nuevo</a></li>
                <li><a href="/paseos_el_puerto/Paseos/actualiza_paseo.jsp">Modificar</a></li>
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
                <li><a href="/paseos_el_puerto/ServletPersonal?op=lista" methods="GET">Lista</a></li>
                <li><a href="/paseos_el_puerto/Personal/inserta_personal.jsp">Registrar</a></li>
                <li><a href="/paseos_el_puerto/Personal/actualiza_personal.jsp">Modificar</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a href="#">Reparación</a>
            <ul class="dropdown-menu">
                <li><a href="/paseos_el_puerto/ServletReparacion?op=lista">Lista</a></li>
                <li><a href="/paseos_el_puerto/Reparacion/inserta_reparacion.jsp">Registrar</a></li>
                <li><a href="/paseos_el_puerto/Reparacion/actualiza_reparacion.jsp">Modificar</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a href="#">Mantenimiento</a>
            <ul class="dropdown-menu">
                <li><a href="/paseos_el_puerto/ServletMantenimiento?op=lista">Lista</a></li>
                <li><a href="/paseos_el_puerto/Mantenimiento/inserta_mantenimiento.jsp">Registrar</a></li>
                <li><a href="/paseos_el_puerto/Mantenimiento/actualiza_mantenimiento.jsp">Modificar</a></li>
            </ul>
        </li>
    </ul>
</header>
<section class="container">
    <div class="parallax-content">
        <style>
            h1 {
                font-size: 36px;
            }

            .monto-total {
                font-size: 90px;
            }

            .button-container {
                margin-top: 45px;
            }

            a {
                font-size: 27px;
            }

            P input[type="text"] {
                padding: 5px;
                border: 1px solid #ccc;
                border-radius: 5px;
                font-size: 14px;
                margin-left: 5px;
                margin-bottom: 13px;
                width: 63px; /* Ajusta el ancho según sea necesario */
            }
        </style>

        <script>
            function mostrarContenido() {
                var campo = document.getElementById("campo");
                campo.style.display = "block";
            }
        </script>

        <br>
        <br>
        <h1 class="monto-total">Monto Total</h1>
        <% PaseosDAO paseosDAO = new PaseosDAO();
            Paseos paseo = paseosDAO.getUltimoPaseo();
        %>
        <% if (paseo != null) { %>
        <form id="" action="/paseos_el_puerto/ServletPasPers" method="post">

            <p class="monto-total" id="monto_total_p">
                $<%= paseo.getMontoTotal(paseo.getFechaInicioPaseo(), paseo.getFechaFinPaseo(), paseo.getCostoHora())%>
            </p>
            <input id="monto_total" name="monto_total"
                   value="<%= paseo.getMontoTotal(paseo.getFechaInicioPaseo(), paseo.getFechaFinPaseo(), paseo.getCostoHora())%>"
                   hidden>
            <span id="horas"
                  hidden><%=paseo.getDiffHoras(paseo.getFechaInicioPaseo(), paseo.getFechaFinPaseo())%></span>

            <div id="personalAgregado">

            </div>

            <div class="button-container">
                <input type="submit" class="button-minimal" value="Terminar Registro" name="op">
            </div>
        </form>

        <% } else { %>
        <h2>Error al calcular el monto total</h2>
        <% } %>
        <br>
        <br>
        <a href="#" onclick="mostrarContenido()">Solicitar personal</a>
        <br>
        <br>
        <br>
        <div id="campo" style="display: none;">
            <br>
            <p>ID: <input type="text" id="id_personal"/></p>
            <button id="addPer" class="button-minimal"> Agregar Personal</button>
            <div class="table-container">
                <h1>Personal disponible</h1>
                <table>
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Apellido Paterno</th>
                        <th>Apellido Materno</th>
                        <th>Dirección</th>
                        <th>Teléfono</th>
                        <th>E-mail</th>
                        <th>Edad</th>
                        <th>Sexo</th>
                        <th>Costo
                            hora
                        </th>
                    </tr>
                    </thead>
                    <tbody id="tablaEmpleados">

                    </tbody>
                </table>
            </div>
        </div>

    </div>
</section>
<script>
    let empleados = [];
    let empleadoOcupados = [];
    let acumulado = 0;
    const costoBase = document.querySelector("#monto_total").value;
    const horas = document.querySelector("#horas").textContent;

    <%
    ArrayList<Personal> lista = (ArrayList<Personal>) request.getAttribute("listapers");
        if (lista != null && !lista.isEmpty()) {
          for (Personal personal : lista) {
              if(personal.getEstado(personal.getIdPersonal()).equals("Disponible")){
              %>
    agregaEmpleado(
        {
            id_empleado: <%= personal.getIdPersonal() %>,
            nombre: "<%= personal.getNombre() %>",
            apellidoP: "<%= personal.getApellidoP() %>",
            apellidoM: "<%= personal.getApellidoM() %>",
            sexo: "<%= personal.getSexo()%>",
            direccion: "<%= personal.getDireccion() %>",
            telefono: "<%= personal.getTelefono() %>",
            email: "<%= personal.getEmail() %>",
            edad: "<%= personal.getEdad(personal.getFecha_nac()) %>",
            costoHora: <%= personal.getCostoHora() %>,
        }
    )
    <%
    }
  }
}
%>
    function agregaEmpleado(empleado) {
        empleados.push(empleado);
    }

    function limpiarTabla() {
        const tablaEmpleados = document.querySelector("#tablaEmpleados");
        while (tablaEmpleados.firstChild) {
            tablaEmpleados.removeChild(tablaEmpleados.firstChild);
        }
    }

    function generarTablaEmpleado() {
        limpiarTabla();
        let htmlText = ""

        empleados.forEach(({
                               id_empleado,
                               nombre,
                               apellidoP,
                               apellidoM,
                               sexo,
                               direccion,
                               telefono,
                               email,
                               edad,
                               costoHora
                           }) => {
            htmlText += `
            <tr>
            <td>${id_empleado}</td>
            <td>${nombre}</td>
            <td>${apellidoP}</td>
            <td>${apellidoM}</td>
            <td>${direccion}</td>
            <td>${telefono}</td>
            <td>${email}</td>
            <td>${edad}</td>
            <td>${sexo}</td>
            <td>${costoHora}</td>
            </tr>
            `;
        })

        document.querySelector("#tablaEmpleados").innerHTML = htmlText;
    }

    function setInputs(){
        let htmlText = "";
        empleadoOcupados.forEach(({id_empleado}) => {
            htmlText += `
                <input name="id_personal" value="${id_empleado}" hidden/>
            `;
        })
        document.querySelector("#personalAgregado").innerHTML = htmlText;
    }

    // Funcion que obtiene el precio por hora del id_empleado
    function getCostoEmpleado(idEmpleado) {
      // Tenemos que hacer el calculo de las horas * el costo del empleado mas el acumulado

      // Aqui vamos a traer el empleado que tenga el id que pusimos en el input
      const empleado = empleados.find((e) => e.id_empleado == idEmpleado);

        if(!empleado){
            alert("El empleado no está disponible");
            return false;
        }
        // agregamos el input con el id de los empleados
        empleadoOcupados.push(empleado);
        setInputs();


      //Eliminamos el elemento de la lista de empleados
      empleados = empleados.filter((e) => e.id_empleado != idEmpleado);

      // Calculamos el costo del empleado por las horas que se utilizo
      return empleado.costoHora * Number(horas);
    }


    document.addEventListener("DOMContentLoaded", () => {
        // Imprime la tabla de empleado
        generarTablaEmpleado();

        // Cuando se presione el boton hara las siguientes acciones
        document.querySelector("#addPer").addEventListener("click", () => {

          // Calcular el monto total
          const idEmpleado = document.querySelector("#id_personal").value;
          acumulado += getCostoEmpleado(idEmpleado);

          if(!acumulado){
              return;
          }

        // modificar el valor del costo base

          // Volvemos a generar la tabla de los empleados
          generarTablaEmpleado();

          // Ponemos el Monto total en pantalla
          document.querySelector("#monto_total_p").textContent = "$" + (Number(costoBase) + acumulado);
          document.querySelector("#monto_total").value = (Number(costoBase) + acumulado);
        })
    });

</script>
</body>
</html>