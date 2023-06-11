/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2023-06-11 10:18:17 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.Paseos;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Paseos;

public final class actualiza_005fpaseo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Actualiza Embarcación</title>\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"/paseos_el_puerto/styles.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"/paseos_el_puerto/navbar.css\">\r\n");
      out.write("    <script src=\"/paseos_el_puerto/animaciones.js\"></script>\r\n");
      out.write("    <script src=\"/paseos_el_puerto/Formato_fecha.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"body_color\">\r\n");
      out.write("<header class=\"navigation\">\r\n");
      out.write("    <ul class=\"cont_ul\">\r\n");
      out.write("        <li class=\"logo-nav-container\"><a href=\"/paseos_el_puerto/index.jsp\"><img src=\"/paseos_el_puerto/logo.png\" alt=\"Logo\">\r\n");
      out.write("        </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"dropdown\">\r\n");
      out.write("            <a href=\"#\">Embarcaciones</a>\r\n");
      out.write("            <ul class=\"dropdown-menu\">\r\n");
      out.write("                <li><a href=\"/paseos_el_puerto/ServletEmbarcacion?op=lista\">Lista</a></li>\r\n");
      out.write("                <li><a href=\"/paseos_el_puerto/Propietarios/inserta_embarcacion.jsp\">Registrar</a></li>\r\n");
      out.write("                <li><a href=\"/paseos_el_puerto/Propietarios/actualiza_embarcacion.jsp\">Modificar</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"dropdown\">\r\n");
      out.write("            <a href=\"#\">Propietarios</a>\r\n");
      out.write("            <ul class=\"dropdown-menu\">\r\n");
      out.write("                <li><a href=\"/paseos_el_puerto/ServletPropietario?op=lista\">Lista</a></li>\r\n");
      out.write("                <li><a href=\"/paseos_el_puerto/Propietarios/inserta_propietario.jsp\">Registrar</a></li>\r\n");
      out.write("                <li><a href=\"/paseos_el_puerto/Propietarios/actualiza_propietario.jsp\">Modificar</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"dropdown\">\r\n");
      out.write("            <a href=\"#\">Alquileres</a>\r\n");
      out.write("            <ul class=\"dropdown-menu\">\r\n");
      out.write("                <li><a href=\"#\">Lista</a></li>\r\n");
      out.write("                <li><a href=\"#\">Registrar</a></li>\r\n");
      out.write("                <li><a href=\"#\">Modificar</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"dropdown\">\r\n");
      out.write("            <a href=\"#\">Clientes</a>\r\n");
      out.write("            <ul class=\"dropdown-menu\">\r\n");
      out.write("                <li><a href=\"/paseos_el_puerto/ServletCliente?op=lista\" methods=\"GET\">Lista</a></li>\r\n");
      out.write("                <li><a href=\"/paseos_el_puerto/Clientes/inserta_cliente.jsp\">Registrar</a></li>\r\n");
      out.write("                <li><a href=\"/paseos_el_puerto/Clientes/actualiza_cliente.jsp\">Modificar</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"dropdown\">\r\n");
      out.write("            <a href=\"#\">Personal</a>\r\n");
      out.write("            <ul class=\"dropdown-menu\">\r\n");
      out.write("                <li><a href=\"#\">Lista</a></li>\r\n");
      out.write("                <li><a href=\"#\">Registrar</a></li>\r\n");
      out.write("                <li><a href=\"#\">Modificar</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"dropdown\">\r\n");
      out.write("            <a href=\"#\">Mantenimiento</a>\r\n");
      out.write("            <ul class=\"dropdown-menu\">\r\n");
      out.write("                <li><a href=\"#\">Lista</a></li>\r\n");
      out.write("                <li><a href=\"#\">Registrar</a></li>\r\n");
      out.write("                <li><a href=\"#\">Modificar</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"dropdown\">\r\n");
      out.write("            <a href=\"#\">Reparación</a>\r\n");
      out.write("            <ul class=\"dropdown-menu\">\r\n");
      out.write("                <li><a href=\"#\">Lista</a></li>\r\n");
      out.write("                <li><a href=\"#\">Registrar</a></li>\r\n");
      out.write("                <li><a href=\"#\">Modificar</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"dropdown\">\r\n");
      out.write("            <a href=\"#\">Equipamiento</a>\r\n");
      out.write("            <ul class=\"dropdown-menu\">\r\n");
      out.write("                <li><a href=\"#\">Lista</a></li>\r\n");
      out.write("                <li><a href=\"#\">Registrar</a></li>\r\n");
      out.write("                <li><a href=\"#\">Modificar</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("    </ul>\r\n");
      out.write("</header>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("\r\n");
      out.write("    p {\r\n");
      out.write("        display: flex;\r\n");
      out.write("        justify-content: flex-end;\r\n");
      out.write("        align-items: center;\r\n");
      out.write("        margin: 10px 0;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    p input[type=\"text\"] {\r\n");
      out.write("        padding: 5px;\r\n");
      out.write("        border: 1px solid #ccc;\r\n");
      out.write("        border-radius: 5px;\r\n");
      out.write("        font-size: 14px;\r\n");
      out.write("        margin-left: 9px;\r\n");
      out.write("        width: 200px; /* Ajusta el ancho según sea necesario */\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write("<script>\r\n");
      out.write("    function autollenar() {\r\n");
      out.write("        var id_paseo = document.getElementById('id_paseo').value;\r\n");
      out.write("        var url = '/paseos_el_puerto/ServletPaseo?op=Autollenado&id_paseo=' + id_paseo;\r\n");
      out.write("\r\n");
      out.write("        // Almacenar el valor de id_paseo en el almacenamiento local del navegador\r\n");
      out.write("        localStorage.setItem('id_paseo_value', id_paseo);\r\n");
      out.write("\r\n");
      out.write("        // Realizar redirección a la página de actualización con los parámetros en la URL\r\n");
      out.write("        window.location.href = url;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    // Obtener el valor de id_paseo del almacenamiento local y asignarlo al campo después de cargar la página\r\n");
      out.write("    window.addEventListener('DOMContentLoaded', function() {\r\n");
      out.write("        var id_paseo = localStorage.getItem('id_paseo_value');\r\n");
      out.write("        if (id_paseo) {\r\n");
      out.write("            document.getElementById('id_paseo').value = id_paseo;\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<br>\r\n");
      out.write("<br>\r\n");
      out.write("<section class=\"container\">\r\n");
      out.write("    <div class=\"parallax-content\">\r\n");
      out.write("        ");
 Paseos paseo = (Paseos) request.getAttribute("paseo"); 
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <form action=\"/paseos_el_puerto/ServletPaseo\" method=\"post\" onsubmit=\"return validarFormulario2()\">\r\n");
      out.write("            <p>ID_Paseo: <input type=\"text\" name=\"id_paseo\" id=\"id_paseo\" onblur=\"autollenar()\"></p>\r\n");
      out.write("\r\n");
      out.write("            ");
 if (paseo != null) { 
      out.write("\r\n");
      out.write("            <p>ID_Embarcación: <input type=\"text\" name=\"id_embarcacion\" value=\"");
      out.print( paseo.getIdEmbarcacion() );
      out.write("\"></p>\r\n");
      out.write("            <p>ID_Cliente: <input type=\"text\" name=\"id_cliente\" value=\"");
      out.print( paseo.getIdCliente() );
      out.write("\"></p>\r\n");
      out.write("            <p>Fecha_inicio: <input type=\"text\" name=\"fecha_inicio\" value=\"");
      out.print( paseo.getFechaInicioPaseo() );
      out.write("\"></p>\r\n");
      out.write("            <p>Fecha_fin: <input type=\"text\" name=\"fecha_fin\" value=\"");
      out.print( paseo.getFechaFinPaseo() );
      out.write("\"></p>\r\n");
      out.write("            ");
 } else { 
      out.write("\r\n");
      out.write("            <p>ID_Embarcación: <input type=\"text\" name=\"id_embarcacion\" value=\"\"></p>\r\n");
      out.write("            <p>ID_Cliente: <input type=\"text\" name=\"id_cliente\" value=\"\"></p>\r\n");
      out.write("            <p>Fecha_inicio: <input type=\"text\" name=\"fecha_inicio\" placeholder=\"(yyyy-mm-dd)\"></p>\r\n");
      out.write("            <p>Fecha_fin: <input type=\"text\" name=\"fecha_fin\" placeholder=\"(yyyy-mm-dd)\"></p>\r\n");
      out.write("            ");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <br>\r\n");
      out.write("            <div class=\"button-container\">\r\n");
      out.write("                <input type=\"submit\" class=\"button-minimal\" value=\"Modificar\" name=\"op\">\r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("</section>\r\n");
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
