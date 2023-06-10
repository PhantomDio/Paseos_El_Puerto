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
      <a href="#">Personal</a>
      <ul class="dropdown-menu">
        <li><a href="/paseos_el_puerto/ServletEmbarcacion?op=lista">Lista</a></li>
        <li><a href="/paseos_el_puerto/Personal/inserta_embarcacion.jsp">Registrar</a></li>
        <li><a href="/paseos_el_puerto/Personal/actualiza_embarcacion.jsp">Modificar</a></li>
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
      <a href="#">Empleados</a>
      <ul class="dropdown-menu">
        <li><a href="#">Lista</a></li>
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
      <a href="#">Mantenimiento</a>
      <ul class="dropdown-menu">
        <li><a href="#">Lista</a></li>
        <li><a href="#">Registrar</a></li>
        <li><a href="#">Modificar</a></li>
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
      .button-container{
        margin-top: 45px;
      }
      a{
        font-size: 27px;
      }
      p input[type="text"] {
        padding: 5px;
        border: 1px solid #ccc;
        border-radius: 5px;
        font-size: 14px;
        margin-left: 9px;
        width: 63px; /* Ajusta el ancho según sea necesario */
      }
    </style>
    <script>
      function mostrarCampo() {
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
    <p class="monto-total">$<span id="monto_total"><%= paseo.getMontoTotal(paseo.getFechaInicioPaseo(), paseo.getFechaFinPaseo(), paseo.getCostoHora(), 0)%></span>
      <span id="horas" hidden><%=paseo.getDiffHoras(paseo.getFechaInicioPaseo(), paseo.getFechaFinPaseo())%></span></p>
    <% } else { %>
    <h2>Error al calcular el monto total</h2>
    <% } %>
    <br>
    <br>
    <a href="#" onclick="mostrarCampo()">Solicitar personal</a>
    <br>
    <br>
    <br>
    <div id="campo" style="display: none;">
      <br>
      <form id="id_form" action="/paseos_el_puerto/ServletPasPers" method="post">
        <p>ID_Personal: <input id="id_personal" type="text" name="id_personal"></p>
        <div class="button-container">
          <button id="addPer" class="button-minimal" name="op">Agregar Personal</button>
          <input id="montoTotal" type="text" hidden>
          <button id="boton" class="button-minimal">Enviar datos</button>
        </div>
      </form>
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
            hora</th>
          </tr>
          </thead>
          <tbody>
          <%
            ArrayList<Personal> lista = (ArrayList<Personal>) request.getAttribute("listapers");

            if (lista != null && !lista.isEmpty()) {
              for (Personal personal : lista) {
                  if(personal.getEstado(personal.getIdPersonal()).equals("Disponible")){
          %>
          <tr>
            <td><%= personal.getIdPersonal() %></td>
            <td><%= personal.getNombre() %></td>
            <td><%= personal.getApellidoP() %></td>
            <td><%= personal.getApellidoM() %></td>
            <td><%= personal.getDireccion() %></td>
            <td><%= personal.getTelefono() %></td>
            <td><%= personal.getEmail() %></td>
            <td><%= personal.getEdad(personal.getFecha_nac()) %></td>
            <td><%= personal.getSexo() %></td>
            <td id="<%=personal.getIdPersonal()%>"><%= personal.getCostoHora() %></td>
            <%
                  }
                }
            }
            else { %>
            <td colspan="9"><h1>No hay personal disponible</h1></td>
          </tr>
          <% }
            ;%>
          </tbody>
        </table>
      </div>
    </div>

  </div>
</section>
<script>

        const horas = document.querySelector("#horas").textContent;
        const monto_paseo = document.querySelector("#monto_total").textContent;
        let acumulador = 0;
        function getCosto_Empleado(empleado){
          const costo_empleado = document.getElementById(empleado).textContent;
          acumulador += Number(costo_empleado);
        }

        document.addEventListener("DOMContentLoaded",()=>{
          document.querySelector("#id_personal").addEventListener("change",(e)=>{
            getCosto_Empleado(e.target.value);
          })

          document.querySelector("#id_form").addEventListener("submit",(e)=>{
            e.preventDefault()
            let monto_total = Number(monto_paseo) + (acumulador * Number(horas));
            document.querySelector("#monto_total").textContent = monto_total;
            document.querySelector("#montoTotal").value =monto_total;
            console.log(document.querySelector("#montoTotal").value);
          })
        })
</script>
</body>
</html>