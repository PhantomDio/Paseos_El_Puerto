/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2023-06-10 06:15:46 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.Paseos;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Paseos;
import datos.PaseosDAO;
import model.Personal;
import java.util.ArrayList;

public final class Monto_005ftotal_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Monto_total</title>\r\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("  <link rel=\"stylesheet\" type=\"text/css\" href=\"/paseos_el_puerto/styles.css\">\r\n");
      out.write("  <link rel=\"stylesheet\" type=\"text/css\" href=\"/paseos_el_puerto/navbar.css\">\r\n");
      out.write("  <script src=\"/paseos_el_puerto/animaciones.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"body_color\">\r\n");
      out.write("<header class=\"navigation\">\r\n");
      out.write("  <ul class=\"cont_ul\">\r\n");
      out.write("    <li class=\"logo-nav-container\"><a href=\"/paseos_el_puerto/index.jsp\"><img src=\"/paseos_el_puerto/logo.png\" alt=\"Logo\">\r\n");
      out.write("    </a>\r\n");
      out.write("    </li>\r\n");
      out.write("    <li class=\"dropdown\">\r\n");
      out.write("      <a href=\"#\">Personal</a>\r\n");
      out.write("      <ul class=\"dropdown-menu\">\r\n");
      out.write("        <li><a href=\"/paseos_el_puerto/ServletEmbarcacion?op=lista\">Lista</a></li>\r\n");
      out.write("        <li><a href=\"/paseos_el_puerto/Personal/inserta_embarcacion.jsp\">Registrar</a></li>\r\n");
      out.write("        <li><a href=\"/paseos_el_puerto/Personal/actualiza_embarcacion.jsp\">Modificar</a></li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </li>\r\n");
      out.write("    <li class=\"dropdown\">\r\n");
      out.write("      <a href=\"#\">Contratos</a>\r\n");
      out.write("      <ul class=\"dropdown-menu\">\r\n");
      out.write("        <li><a href=\"/paseos_el_puerto/ServletContrato?op=lista\">Lista</a></li>\r\n");
      out.write("        <li><a href=\"/paseos_el_puerto/Contratos/actualiza_contrato.jsp\">Modificar</a></li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </li>\r\n");
      out.write("    <li class=\"dropdown\">\r\n");
      out.write("      <a href=\"#\">Paseos</a>\r\n");
      out.write("      <ul class=\"dropdown-menu\">\r\n");
      out.write("        <li><a href=\"/paseos_el_puerto/ServletPaseo?op=lista\">Lista</a></li>\r\n");
      out.write("        <li><a href=\"/paseos_el_puerto/ServletPaseo?op=listaEmb\">Nuevo</a></li>\r\n");
      out.write("        <li><a href=\"/paseos_el_puerto/Paseos/actualiza_paseo.jsp\">Modificar</a></li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </li>\r\n");
      out.write("    <li class=\"dropdown\">\r\n");
      out.write("      <a href=\"#\">Propietarios</a>\r\n");
      out.write("      <ul class=\"dropdown-menu\">\r\n");
      out.write("        <li><a href=\"/paseos_el_puerto/ServletPropietario?op=lista\">Lista</a></li>\r\n");
      out.write("        <li><a href=\"/paseos_el_puerto/Propietarios/inserta_propietario.jsp\">Registrar</a></li>\r\n");
      out.write("        <li><a href=\"/paseos_el_puerto/Propietarios/actualiza_propietario.jsp\">Modificar</a></li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </li>\r\n");
      out.write("    <li class=\"dropdown\">\r\n");
      out.write("      <a href=\"#\">Clientes</a>\r\n");
      out.write("      <ul class=\"dropdown-menu\">\r\n");
      out.write("        <li><a href=\"/paseos_el_puerto/ServletCliente?op=lista\" methods=\"GET\">Lista</a></li>\r\n");
      out.write("        <li><a href=\"/paseos_el_puerto/Clientes/inserta_cliente.jsp\">Registrar</a></li>\r\n");
      out.write("        <li><a href=\"/paseos_el_puerto/Clientes/actualiza_cliente.jsp\">Modificar</a></li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </li>\r\n");
      out.write("    <li class=\"dropdown\">\r\n");
      out.write("      <a href=\"#\">Empleados</a>\r\n");
      out.write("      <ul class=\"dropdown-menu\">\r\n");
      out.write("        <li><a href=\"#\">Lista</a></li>\r\n");
      out.write("        <li><a href=\"#\">Modificar</a></li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </li>\r\n");
      out.write("    <li class=\"dropdown\">\r\n");
      out.write("      <a href=\"#\">Reparación</a>\r\n");
      out.write("      <ul class=\"dropdown-menu\">\r\n");
      out.write("        <li><a href=\"#\">Lista</a></li>\r\n");
      out.write("        <li><a href=\"#\">Registrar</a></li>\r\n");
      out.write("        <li><a href=\"#\">Modificar</a></li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </li>\r\n");
      out.write("    <li class=\"dropdown\">\r\n");
      out.write("      <a href=\"#\">Mantenimiento</a>\r\n");
      out.write("      <ul class=\"dropdown-menu\">\r\n");
      out.write("        <li><a href=\"#\">Lista</a></li>\r\n");
      out.write("        <li><a href=\"#\">Registrar</a></li>\r\n");
      out.write("        <li><a href=\"#\">Modificar</a></li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </li>\r\n");
      out.write("  </ul>\r\n");
      out.write("</header>\r\n");
      out.write("<section class=\"container\">\r\n");
      out.write("  <div class=\"parallax-content\">\r\n");
      out.write("    <style>\r\n");
      out.write("      h1 {\r\n");
      out.write("      font-size: 36px;\r\n");
      out.write("      }\r\n");
      out.write("\r\n");
      out.write("      .monto-total {\r\n");
      out.write("      font-size: 90px;\r\n");
      out.write("      }\r\n");
      out.write("      .button-container{\r\n");
      out.write("        margin-top: 45px;\r\n");
      out.write("      }\r\n");
      out.write("      a{\r\n");
      out.write("        font-size: 27px;\r\n");
      out.write("      }\r\n");
      out.write("      p input[type=\"text\"] {\r\n");
      out.write("        padding: 5px;\r\n");
      out.write("        border: 1px solid #ccc;\r\n");
      out.write("        border-radius: 5px;\r\n");
      out.write("        font-size: 14px;\r\n");
      out.write("        margin-left: 9px;\r\n");
      out.write("        width: 63px; /* Ajusta el ancho según sea necesario */\r\n");
      out.write("      }\r\n");
      out.write("    </style>\r\n");
      out.write("    <script>\r\n");
      out.write("      function mostrarCampo() {\r\n");
      out.write("        var campo = document.getElementById(\"campo\");\r\n");
      out.write("        campo.style.display = \"block\";\r\n");
      out.write("      }\r\n");
      out.write("    </script>\r\n");
      out.write("    <br>\r\n");
      out.write("    <br>\r\n");
      out.write("    <h1 class=\"monto-total\">Monto Total</h1>\r\n");
      out.write("    ");
 PaseosDAO paseosDAO = new PaseosDAO();
      Paseos paseo = paseosDAO.getUltimoPaseo();
    
      out.write("\r\n");
      out.write("    ");
 if (paseo != null) { 
      out.write("\r\n");
      out.write("    <p class=\"monto-total\">$<span id=\"monto_total\">");
      out.print( paseo.getMontoTotal(paseo.getFechaInicioPaseo(), paseo.getFechaFinPaseo(), paseo.getCostoHora(), 0));
      out.write("</span>\r\n");
      out.write("      <span id=\"horas\" hidden>");
      out.print(paseo.getDiffHoras(paseo.getFechaInicioPaseo(), paseo.getFechaFinPaseo()));
      out.write("</span></p>\r\n");
      out.write("    ");
 } else { 
      out.write("\r\n");
      out.write("    <h2>Error al calcular el monto total</h2>\r\n");
      out.write("    ");
 } 
      out.write("\r\n");
      out.write("    <br>\r\n");
      out.write("    <br>\r\n");
      out.write("    <a href=\"#\" onclick=\"mostrarCampo()\">Solicitar personal</a>\r\n");
      out.write("    <br>\r\n");
      out.write("    <br>\r\n");
      out.write("    <br>\r\n");
      out.write("    <div id=\"campo\" style=\"display: none;\">\r\n");
      out.write("      <br>\r\n");
      out.write("      <form id=\"id_form\" action=\"/paseos_el_puerto/ServletPasPers\" method=\"post\">\r\n");
      out.write("        <p>ID_Personal: <input id=\"id_personal\" type=\"text\" name=\"id_personal\"></p>\r\n");
      out.write("        <div class=\"button-container\">\r\n");
      out.write("          <button id=\"addPer\" class=\"button-minimal\" name=\"op\">Agregar Personal</button>\r\n");
      out.write("          <input id=\"montoTotal\" type=\"text\" hidden>\r\n");
      out.write("          <button id=\"boton\" class=\"button-minimal\">Enviar datos</button>\r\n");
      out.write("        </div>\r\n");
      out.write("      </form>\r\n");
      out.write("      <div class=\"table-container\">\r\n");
      out.write("        <h1>Personal disponible</h1>\r\n");
      out.write("        <table>\r\n");
      out.write("          <thead>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <th>ID</th>\r\n");
      out.write("            <th>Nombre</th>\r\n");
      out.write("            <th>Apellido Paterno</th>\r\n");
      out.write("            <th>Apellido Materno</th>\r\n");
      out.write("            <th>Dirección</th>\r\n");
      out.write("            <th>Teléfono</th>\r\n");
      out.write("            <th>E-mail</th>\r\n");
      out.write("            <th>Edad</th>\r\n");
      out.write("            <th>Sexo</th>\r\n");
      out.write("            <th>Costo\r\n");
      out.write("            hora</th>\r\n");
      out.write("          </tr>\r\n");
      out.write("          </thead>\r\n");
      out.write("          <tbody>\r\n");
      out.write("          ");

            ArrayList<Personal> lista = (ArrayList<Personal>) request.getAttribute("listapers");

            if (lista != null && !lista.isEmpty()) {
              for (Personal personal : lista) {
                  if(personal.getEstado(personal.getIdPersonal()).equals("Disponible")){
          
      out.write("\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td>");
      out.print( personal.getIdPersonal() );
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print( personal.getNombre() );
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print( personal.getApellidoP() );
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print( personal.getApellidoM() );
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print( personal.getDireccion() );
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print( personal.getTelefono() );
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print( personal.getEmail() );
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print( personal.getEdad(personal.getFecha_nac()) );
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print( personal.getSexo() );
      out.write("</td>\r\n");
      out.write("            <td id=\"");
      out.print(personal.getIdPersonal());
      out.write('"');
      out.write('>');
      out.print( personal.getCostoHora() );
      out.write("</td>\r\n");
      out.write("            ");

                  }
                }
            }
            else { 
      out.write("\r\n");
      out.write("            <td colspan=\"9\"><h1>No hay personal disponible</h1></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          ");
 }
            ;
      out.write("\r\n");
      out.write("          </tbody>\r\n");
      out.write("        </table>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("  </div>\r\n");
      out.write("</section>\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("        const horas = document.querySelector(\"#horas\").textContent;\r\n");
      out.write("        const monto_paseo = document.querySelector(\"#monto_total\").textContent;\r\n");
      out.write("        let acumulador = 0;\r\n");
      out.write("        function getCosto_Empleado(empleado){\r\n");
      out.write("          const costo_empleado = document.getElementById(empleado).textContent;\r\n");
      out.write("          acumulador += Number(costo_empleado);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        document.addEventListener(\"DOMContentLoaded\",()=>{\r\n");
      out.write("          document.querySelector(\"#id_personal\").addEventListener(\"change\",(e)=>{\r\n");
      out.write("            getCosto_Empleado(e.target.value);\r\n");
      out.write("          })\r\n");
      out.write("\r\n");
      out.write("          document.querySelector(\"#id_form\").addEventListener(\"submit\",(e)=>{\r\n");
      out.write("            e.preventDefault()\r\n");
      out.write("            let monto_total = Number(monto_paseo) + (acumulador * Number(horas));\r\n");
      out.write("            document.querySelector(\"#monto_total\").textContent = monto_total;\r\n");
      out.write("            document.querySelector(\"#montoTotal\").value =monto_total;\r\n");
      out.write("            console.log(document.querySelector(\"#montoTotal\").value);\r\n");
      out.write("          })\r\n");
      out.write("        })\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
