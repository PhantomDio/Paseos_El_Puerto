/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2023-05-30 00:56:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.Clientes;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import model.Clientes;
import java.util.List;

public final class lista_005fcliente_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>Lista Clientes</title>\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"/paseos_el_puerto/styles.css\">\r\n");
      out.write("    <script src=\"/paseos_el_puerto/animaciones.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"container_body\">\r\n");
      out.write("<style>\r\n");
      out.write("    .navigation {\r\n");
      out.write("        position: fixed;\r\n");
      out.write("        top: 0;\r\n");
      out.write("        left: 0;\r\n");
      out.write("        width: 100%;\r\n");
      out.write("        z-index: 999;\r\n");
      out.write("        height: 80px;\r\n");
      out.write("        background-color: transparent;\r\n");
      out.write("        transition: background-color 0.3s ease;\r\n");
      out.write("        display: flex;\r\n");
      out.write("        justify-content: center;\r\n");
      out.write("        align-items: center;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .navigation:hover,\r\n");
      out.write("    .navigation.scrolled {\r\n");
      out.write("        background-color: #5d4e3c;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .navigation ul {\r\n");
      out.write("        list-style: none;\r\n");
      out.write("        display: flex;\r\n");
      out.write("        align-items: center;\r\n");
      out.write("        margin: 0;\r\n");
      out.write("        padding: 0;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .navigation a {\r\n");
      out.write("        color: #333;\r\n");
      out.write("        transition: color 0.3s ease;\r\n");
      out.write("        text-decoration: none;\r\n");
      out.write("        font-size: 20px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .navigation:hover a,\r\n");
      out.write("    .navigation.scrolled a {\r\n");
      out.write("        color: #f8f8f8;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .logo-nav-container {\r\n");
      out.write("        display: flex;\r\n");
      out.write("        align-items: center;\r\n");
      out.write("        justify-content: space-between;\r\n");
      out.write("        margin-right: 36px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .logo-nav-container img {\r\n");
      out.write("        max-height: 45px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .dropdown {\r\n");
      out.write("        position: relative;\r\n");
      out.write("        display: inline-block;\r\n");
      out.write("        margin-right: 15px; /* Espacio entre las opciones principales */\r\n");
      out.write("        text-transform: uppercase;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .dropdown-menu {\r\n");
      out.write("        display: block;\r\n");
      out.write("        position: absolute;\r\n");
      out.write("        top: 100%;\r\n");
      out.write("        left: 0;\r\n");
      out.write("        z-index: 1;\r\n");
      out.write("        padding: 10px;\r\n");
      out.write("        min-width: 150px;\r\n");
      out.write("        opacity: 0%;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .dropdown:hover .dropdown-menu {\r\n");
      out.write("        display: block;\r\n");
      out.write("        background-color: #5d4e3c;\r\n");
      out.write("        opacity: 100%;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .dropdown-menu li {margin-top: 20px;}\r\n");
      out.write("\r\n");
      out.write("    .navigation-link:hover > a {\r\n");
      out.write("        background-color: #5d4e3c;\r\n");
      out.write("        color: #f8f8f8;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .navigation-link:hover .dropdown-menu {\r\n");
      out.write("        display: block;\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write("<header>\r\n");
      out.write("    <nav class=\"navigation\">\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li><a href=\"/paseos_el_puerto/index.jsp\" class=\"logo-nav-container\"><img src=\"/paseos_el_puerto/logo.png\" alt=\"Logo\"></a></li>\r\n");
      out.write("            <li class=\"dropdown\">\r\n");
      out.write("                <a href=\"#\" class=\"navigation-link\">Embarcaciones</a>\r\n");
      out.write("                <ul class=\"dropdown-menu\">\r\n");
      out.write("                    <li><a href=\"#\">Lista</a></li>\r\n");
      out.write("                    <li><a href=\"#\">Registrar</a></li>\r\n");
      out.write("                    <li><a href=\"#\">Actualizar</a></li>\r\n");
      out.write("                    <li><a href=\"#\">Eliminar</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"dropdown\">\r\n");
      out.write("                <a href=\"#\" class=\"navigation-link\">Propietarios</a>\r\n");
      out.write("                <ul class=\"dropdown-menu\">\r\n");
      out.write("                    <li><a href=\"#\">Lista</a></li>\r\n");
      out.write("                    <li><a href=\"#\">Registrar</a></li>\r\n");
      out.write("                    <li><a href=\"#\">Actualizar</a></li>\r\n");
      out.write("                    <li><a href=\"#\">Eliminar</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"dropdown\">\r\n");
      out.write("                <a href=\"#\" class=\"navigation-link\">Alquileres</a>\r\n");
      out.write("                <ul class=\"dropdown-menu\">\r\n");
      out.write("                    <li><a href=\"#\">Lista</a></li>\r\n");
      out.write("                    <li><a href=\"#\">Registrar</a></li>\r\n");
      out.write("                    <li><a href=\"#\">Actualizar</a></li>\r\n");
      out.write("                    <li><a href=\"#\">Eliminar</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"dropdown\">\r\n");
      out.write("                <a href=\"#\" class=\"navigation-link\">Clientes</a>\r\n");
      out.write("                <ul class=\"dropdown-menu\">\r\n");
      out.write("                    <li><a href=\"/paseos_el_puerto/ServletCliente?op=lista\" methods=\"POST\">\r\n");
      out.write("                        Lista\r\n");
      out.write("                    </a></li>\r\n");
      out.write("                    <li><a href=\"/paseos_el_puerto/Clientes/inserta_cliente.jsp\">Registrar</a></li>\r\n");
      out.write("                    <li><a href=\"#\">Actualizar</a></li>\r\n");
      out.write("                    <li><a href=\"#\">Eliminar</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"dropdown\">\r\n");
      out.write("                <a href=\"#\" class=\"navigation-link\">Personal</a>\r\n");
      out.write("                <ul class=\"dropdown-menu\">\r\n");
      out.write("                    <li><a href=\"#\">Lista</a></li>\r\n");
      out.write("                    <li><a href=\"#\">Registrar</a></li>\r\n");
      out.write("                    <li><a href=\"#\">Actualizar</a></li>\r\n");
      out.write("                    <li><a href=\"#\">Eliminar</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"dropdown\">\r\n");
      out.write("                <a href=\"#\" class=\"navigation-link\">Mantenimiento</a>\r\n");
      out.write("                <ul class=\"dropdown-menu\">\r\n");
      out.write("                    <li><a href=\"#\">Lista</a></li>\r\n");
      out.write("                    <li><a href=\"#\">Registrar</a></li>\r\n");
      out.write("                    <li><a href=\"#\">Actualizar</a></li>\r\n");
      out.write("                    <li><a href=\"#\">Eliminar</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"dropdown\">\r\n");
      out.write("                <a href=\"#\" class=\"navigation-link\">Reparación</a>\r\n");
      out.write("                <ul class=\"dropdown-menu\">\r\n");
      out.write("                    <li><a href=\"#\">Lista</a></li>\r\n");
      out.write("                    <li><a href=\"#\">Registrar</a></li>\r\n");
      out.write("                    <li><a href=\"#\">Actualizar</a></li>\r\n");
      out.write("                    <li><a href=\"#\">Eliminar</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"dropdown\">\r\n");
      out.write("                <a href=\"#\" class=\"navigation-link\">Equipamiento</a>\r\n");
      out.write("                <ul class=\"dropdown-menu\">\r\n");
      out.write("                    <li><a href=\"#\">Lista</a></li>\r\n");
      out.write("                    <li><a href=\"#\">Registrar</a></li>\r\n");
      out.write("                    <li><a href=\"#\">Actualizar</a></li>\r\n");
      out.write("                    <li><a href=\"#\">Eliminar</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </nav>\r\n");
      out.write("</header>\r\n");
      out.write("\r\n");
      out.write("<section class=\"container\">\r\n");
      out.write("    <div class=\"parallax-content\">\r\n");
      out.write("        <a href=\"/paseos_el_puerto/ServletCliente\"><input type=\"submit\" class=\"button-minimal\" value=\"Actualizar lista\"/></a>\r\n");
      out.write("        <div class=\"table-container\">\r\n");
      out.write("        <table>\r\n");
      out.write("            <thead>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th>ID</th>\r\n");
      out.write("                <th>Nombre</th>\r\n");
      out.write("                <th>Apellido Paterno</th>\r\n");
      out.write("                <th>Apellido Materno</th>\r\n");
      out.write("                <th>Dirección</th>\r\n");
      out.write("                <th>Telefono</th>\r\n");
      out.write("                <th>E-mail</th>\r\n");
      out.write("                <th>Fecha de nacimiento</th>\r\n");
      out.write("            </tr>\r\n");
      out.write("            </thead>\r\n");
      out.write("            ");
List<Clientes> listaClientes = (List<Clientes>) request.getAttribute("listaClientes");
                if (listaClientes != null){
                    for (Clientes cliente : listaClientes){
            
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>");
      out.print( cliente.getIdCliente() );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( cliente.getNombre() );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( cliente.getApellidoP() );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( cliente.getApellidoM() );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( cliente.getDireccion() );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( cliente.getTelefono() );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( cliente.getEmail() );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( cliente.getFecha_nac() );
      out.write("</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            ");

                    }
            }
            else
            session.removeAttribute("listaClientes");
        
      out.write("\r\n");
      out.write("        </table>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</section>\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.5.1.min.js\"></script>\r\n");
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
