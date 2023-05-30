/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2023-05-30 00:51:00 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Paseos \"El Puerto\"</title>\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\n");
      out.write("    <script src=\"animaciones.js\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<style>\n");
      out.write("    .navigation {\n");
      out.write("        position: fixed;\n");
      out.write("        top: 0;\n");
      out.write("        left: 0;\n");
      out.write("        width: 100%;\n");
      out.write("        z-index: 999;\n");
      out.write("        height: 80px;\n");
      out.write("        background-color: transparent;\n");
      out.write("        transition: background-color 0.3s ease;\n");
      out.write("        display: flex;\n");
      out.write("        justify-content: center;\n");
      out.write("        align-items: center;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .navigation:hover,\n");
      out.write("    .navigation.scrolled {\n");
      out.write("        background-color: #5d4e3c;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .navigation ul {\n");
      out.write("        list-style: none;\n");
      out.write("        display: flex;\n");
      out.write("        align-items: center;\n");
      out.write("        margin: 0;\n");
      out.write("        padding: 0;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .navigation a {\n");
      out.write("        color: #333;\n");
      out.write("        transition: color 0.3s ease;\n");
      out.write("        text-decoration: none;\n");
      out.write("        font-size: 20px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .navigation:hover a,\n");
      out.write("    .navigation.scrolled a {\n");
      out.write("        color: #f8f8f8;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .logo-nav-container {\n");
      out.write("        display: flex;\n");
      out.write("        align-items: center;\n");
      out.write("        justify-content: space-between;\n");
      out.write("        margin-right: 36px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .logo-nav-container img {\n");
      out.write("        max-height: 45px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .dropdown {\n");
      out.write("        position: relative;\n");
      out.write("        display: inline-block;\n");
      out.write("        margin-right: 15px; /* Espacio entre las opciones principales */\n");
      out.write("        text-transform: uppercase;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .dropdown-menu {\n");
      out.write("        display: block;\n");
      out.write("        position: absolute;\n");
      out.write("        top: 100%;\n");
      out.write("        left: 0;\n");
      out.write("        z-index: 1;\n");
      out.write("        padding: 10px;\n");
      out.write("        min-width: 150px;\n");
      out.write("        opacity: 0%;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .dropdown:hover .dropdown-menu {\n");
      out.write("        display: block;\n");
      out.write("        background-color: #5d4e3c;\n");
      out.write("        opacity: 100%;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .dropdown-menu li {margin-top: 20px;}\n");
      out.write("\n");
      out.write("    .navigation-link:hover > a {\n");
      out.write("        background-color: #5d4e3c;\n");
      out.write("        color: #f8f8f8;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .navigation-link:hover .dropdown-menu {\n");
      out.write("        display: block;\n");
      out.write("    }\n");
      out.write("</style>\n");
      out.write("<header>\n");
      out.write("    <nav class=\"navigation\">\n");
      out.write("        <ul>\n");
      out.write("            <li><a href=\"/paseos_el_puerto/index.jsp\" class=\"logo-nav-container\"><img src=\"/paseos_el_puerto/logo.png\" alt=\"Logo\"></a></li>\n");
      out.write("            <li class=\"dropdown\">\n");
      out.write("                <a href=\"#\" class=\"navigation-link\">Embarcaciones</a>\n");
      out.write("                <ul class=\"dropdown-menu\">\n");
      out.write("                    <li><a href=\"#\">Lista</a></li>\n");
      out.write("                    <li><a href=\"#\">Registrar</a></li>\n");
      out.write("                    <li><a href=\"#\">Actualizar</a></li>\n");
      out.write("                    <li><a href=\"#\">Eliminar</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"dropdown\">\n");
      out.write("                <a href=\"#\" class=\"navigation-link\">Propietarios</a>\n");
      out.write("                <ul class=\"dropdown-menu\">\n");
      out.write("                    <li><a href=\"#\">Lista</a></li>\n");
      out.write("                    <li><a href=\"#\">Registrar</a></li>\n");
      out.write("                    <li><a href=\"#\">Actualizar</a></li>\n");
      out.write("                    <li><a href=\"#\">Eliminar</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"dropdown\">\n");
      out.write("                <a href=\"#\" class=\"navigation-link\">Alquileres</a>\n");
      out.write("                <ul class=\"dropdown-menu\">\n");
      out.write("                    <li><a href=\"#\">Lista</a></li>\n");
      out.write("                    <li><a href=\"#\">Registrar</a></li>\n");
      out.write("                    <li><a href=\"#\">Actualizar</a></li>\n");
      out.write("                    <li><a href=\"#\">Eliminar</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"dropdown\">\n");
      out.write("                <a href=\"#\" class=\"navigation-link\">Clientes</a>\n");
      out.write("                <ul class=\"dropdown-menu\">\n");
      out.write("                    <li><a href=\"/paseos_el_puerto/ServletCliente?op=lista\" methods=\"POST\">\n");
      out.write("                        Lista\n");
      out.write("                    </a></li>\n");
      out.write("                    <li><a href=\"/paseos_el_puerto/Clientes/inserta_cliente.jsp\">Registrar</a></li>\n");
      out.write("                    <li><a href=\"#\">Actualizar</a></li>\n");
      out.write("                    <li><a href=\"#\">Eliminar</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"dropdown\">\n");
      out.write("                <a href=\"#\" class=\"navigation-link\">Personal</a>\n");
      out.write("                <ul class=\"dropdown-menu\">\n");
      out.write("                    <li><a href=\"#\">Lista</a></li>\n");
      out.write("                    <li><a href=\"#\">Registrar</a></li>\n");
      out.write("                    <li><a href=\"#\">Actualizar</a></li>\n");
      out.write("                    <li><a href=\"#\">Eliminar</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"dropdown\">\n");
      out.write("                <a href=\"#\" class=\"navigation-link\">Mantenimiento</a>\n");
      out.write("                <ul class=\"dropdown-menu\">\n");
      out.write("                    <li><a href=\"#\">Lista</a></li>\n");
      out.write("                    <li><a href=\"#\">Registrar</a></li>\n");
      out.write("                    <li><a href=\"#\">Actualizar</a></li>\n");
      out.write("                    <li><a href=\"#\">Eliminar</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"dropdown\">\n");
      out.write("                <a href=\"#\" class=\"navigation-link\">Reparación</a>\n");
      out.write("                <ul class=\"dropdown-menu\">\n");
      out.write("                    <li><a href=\"#\">Lista</a></li>\n");
      out.write("                    <li><a href=\"#\">Registrar</a></li>\n");
      out.write("                    <li><a href=\"#\">Actualizar</a></li>\n");
      out.write("                    <li><a href=\"#\">Eliminar</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"dropdown\">\n");
      out.write("                <a href=\"#\" class=\"navigation-link\">Equipamiento</a>\n");
      out.write("                <ul class=\"dropdown-menu\">\n");
      out.write("                    <li><a href=\"#\">Lista</a></li>\n");
      out.write("                    <li><a href=\"#\">Registrar</a></li>\n");
      out.write("                    <li><a href=\"#\">Actualizar</a></li>\n");
      out.write("                    <li><a href=\"#\">Eliminar</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </li>\n");
      out.write("        </ul>\n");
      out.write("    </nav>\n");
      out.write("</header>\n");
      out.write("\n");
      out.write("<section class=\"parallax-section\">\n");
      out.write("    <div class=\"parallax-content\">\n");
      out.write("    </div>\n");
      out.write("</section>\n");
      out.write("<section class=\"container\">\n");
      out.write("<div class=\"parallax-content\">\n");
      out.write("<h1 class=\"fade-in\">Descripción del proyecto</h1>\n");
      out.write("<p class=\"fade-in\">\n");
      out.write("    Paseos \"El Puerto\" es una agencia que alquila embarcaciones a sus clientes mediante una tarjeta\n");
      out.write("    de membresía. Nuestro objetivo es brindar a nuestros clientes una experiencia inolvidable en el mar,\n");
      out.write("    ofreciendo una amplia selección de embarcaciones de alta calidad y servicios personalizados.\n");
      out.write("</p>\n");
      out.write("\n");
      out.write("<h1 class=\"fade-in\">Servicios ofrecidos:</h1>\n");
      out.write("<ul class=\"fade-in\">\n");
      out.write("    <li>Alquiler de embarcaciones de diferentes tamaños y capacidades.</li>\n");
      out.write("    <li>Tours guiados por lugares turísticos y pintorescos.</li>\n");
      out.write("    <li>Equipo de buceo y snorkel disponible para los amantes del agua.</li>\n");
      out.write("    <li>Servicios de catering y eventos especiales a bordo.</li>\n");
      out.write("    <li>Transporte y traslado desde y hacia el puerto.</li>\n");
      out.write("</ul>\n");
      out.write("\n");
      out.write("<h1 class=\"fade-in\">Beneficios de la membresía:</h1>\n");
      out.write("<ul class=\"fade-in\">\n");
      out.write("    <li>Descuentos exclusivos en alquileres y servicios adicionales.</li>\n");
      out.write("    <li>Acceso prioritario a las embarcaciones más populares.</li>\n");
      out.write("    <li>Asistencia personalizada para planificar su viaje.</li>\n");
      out.write("    <li>Invitaciones a eventos y actividades especiales.</li>\n");
      out.write("    <li>Programa de puntos para acumular beneficios adicionales.</li>\n");
      out.write("</ul>\n");
      out.write("</div>\n");
      out.write("</section>\n");
      out.write("<footer class=\"footer\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <p>© 2023 Paseos \"El Puerto\". Todos los derechos reservados.</p>\n");
      out.write("    </div>\n");
      out.write("</footer>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
