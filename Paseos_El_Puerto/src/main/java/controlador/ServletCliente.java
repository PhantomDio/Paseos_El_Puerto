package controlador;

import javax.annotation.Resource;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import javax.sql.DataSource;
import datos.conexion;
import model.Clientes;
import datos.ClientesDAO;
import java.sql.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.*;

@WebServlet(name = "ServletCliente", urlPatterns = {"/ServletCliente"})
public class ServletCliente extends HttpServlet {
    //PETICION GET
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException {
        String opc = (rq.getParameter("opc") != null) ? rq.getParameter("opc") : "list";

        if (opc.equals("list")) {
            ClientesDAO clidao = new ClientesDAO();
            List<clientes> lista = clidao.seleccionar();
            rq.setAttribute("lista",lista);
            rq.getRequestDispatcher("vistas/clientes/index.jsp").forward(rq, rp);
        }

        else if (opc.equals("mostrar")) {
            Conexion con = new Conexion();
            Connection c = con.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            int id_cliente = Integer.parseInt(rq.getParameter(("id_cliente")));
            try {
                String updateSql = "SELECT * FROM clientes WHERE id_cliente = ? ";
                ps = c.prepareStatement(updateSql);
                ps.setInt(1, id_cliente);
                rs = ps.executeQuery();
                Clientes cli = new Clientes();
                while (rs.next()) {

                    cli.setId_cliente(rs.getInt("id_cliente"));
                    cli.setNombre(rs.getString("nombre"));
                    cli.setApellido_Pat(rs.getString("apellido_Pat"));
                    cli.setApellido_Mat(rs.getString("apellido_Mat"));
                    cli.setEmail(rs.getString("email"));
                    cli.setTelefono(rs.getString("telefono"));
                    cli.setFecha_nac(rs.getDate("fecha_nac"));
                }
                rq.setAttribute("cliente", cli);

                rq.getRequestDispatcher("vistas/clientes/modificar.jsp").forward(rq, rp);
               
            } catch (SQLException ex) {
                System.out.println("Error en SQL " + ex.getMessage());
            }
        }
      
        else if (opc.equals("eliminar")) {

            int id_cliente = Integer.parseInt(rq.getParameter(("id_cliente")));
            Clientes cli = new Clientes(id_cliente);
            ClientesDAO clientdao = new ClientesDAO();
            clientdao.borrar(cli);
            rp.sendRedirect("ServletCliente");
        }
    }
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        String op;
        op=(String)rq.getSession().getAttribute("op");
       if (op.equals("nuevo")) {

            String nombre = rq.getParameter("nombre");
            String apellido_Pat = rq.getParameter("apellido_Pat");
            String apellido_Mat = rq.getParameter("apellido_Mat");
            String email = rq.getParameter("email");
            String telefono = rq.getParameter("telefono");
            Date fecha_nac = Date.valueOf(rq.getParameter("fecha_nac"));

            Clientes client = new Clientes(nombre, apellido_Pat, apellido_Mat, email, telefono,fecha_nac);
            ClientesDAO clidaoo = new ClientesDAO();
            clidaoo.agregar(client);
            rp.sendRedirect("/EjemploCliente/ServletCliente");
        }
       
    }
}

