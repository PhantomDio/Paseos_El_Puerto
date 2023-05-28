/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2023-05-28 07:31:51 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Clientes;
import java.util.List;

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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Administración de Clientes</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<h1>Administración de Clientes</h1>\n");
      out.write("\n");
      out.write('\n');
 if (request.getAttribute("mensaje") != null) { 
      out.write("\n");
      out.write("<p>");
      out.print( request.getAttribute("mensaje") );
      out.write("</p>\n");
 } 
      out.write("\n");
      out.write("\n");
      out.write("<h2>Registrar nuevo cliente</h2>\n");
      out.write("\n");
      out.write("<form action=\"ServletCliente\" method=\"POST\">\n");
      out.write("    <label for=\"nombre\">Nombre:</label>\n");
      out.write("    <input type=\"text\" id=\"nombre\" name=\"nombre\" required><br><br>\n");
      out.write("\n");
      out.write("    <label for=\"correo\">Correo electrónico:</label>\n");
      out.write("    <input type=\"email\" id=\"correo\" name=\"correo\" required><br><br>\n");
      out.write("\n");
      out.write("    <label for=\"telefono\">Teléfono:</label>\n");
      out.write("    <input type=\"text\" id=\"telefono\" name=\"telefono\" required><br><br>\n");
      out.write("\n");
      out.write("    <input type=\"submit\" value=\"Registrar\">\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("<h2>Listado de clientes</h2>\n");
      out.write("<a href=\"ServletCliente\">Listar</a>\n");
      out.write("<table>\n");
      out.write("    ");
      out.write("\n");
      out.write("    ");
 List<Clientes> listaClientes = (List<Clientes>) request.getAttribute("listaClientes"); 
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("    ");
 if (listaClientes == null) { 
      out.write("\n");
      out.write("    <h2>No hay clientes a mostrar</h2>\n");
      out.write("    ");
 } else { 
      out.write("\n");
      out.write("    <tr>\n");
      out.write("        <th>ID</th>\n");
      out.write("        <th>Nombre</th>\n");
      out.write("        <th>Apellido Paterno</th>\n");
      out.write("        <th>Apellido Materno</th>\n");
      out.write("        <th>Dirección</th>\n");
      out.write("        <th>Teléfono</th>\n");
      out.write("        <th>E-mail</th>\n");
      out.write("        <th>Fecha de nacimiento</th>\n");
      out.write("    </tr>\n");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("    ");
 for (Clientes cliente : listaClientes) { 
      out.write("\n");
      out.write("    <tr>\n");
      out.write("        <td>");
      out.print( cliente.getIdCliente() );
      out.write("</td>\n");
      out.write("        <td>");
      out.print( cliente.getNombre() );
      out.write("</td>\n");
      out.write("        <td>");
      out.print( cliente.getApellidoP() );
      out.write("</td>\n");
      out.write("        <td>");
      out.print( cliente.getApellidoM() );
      out.write("</td>\n");
      out.write("        <td>");
      out.print( cliente.getDireccion() );
      out.write("</td>\n");
      out.write("        <td>");
      out.print( cliente.getTelefono() );
      out.write("</td>\n");
      out.write("        <td>");
      out.print( cliente.getEmail() );
      out.write("</td>\n");
      out.write("        <td>");
      out.print( cliente.getFecha_nac() );
      out.write("</td>\n");
      out.write("    </tr>\n");
      out.write("    ");
 } 
      out.write("\n");
      out.write("    ");
 } 
      out.write("\n");
      out.write("</table>\n");
      out.write("\n");
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
