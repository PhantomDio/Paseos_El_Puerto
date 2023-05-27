package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import javax.sql.DataSource;
import datos.Conexion;
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
            List<Clientes> lista = clidao.selectAll();
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

                    cli.setIdCliente(rs.getInt("id_cliente"));
                    cli.setNombre(rs.getString("nombre"));
                    cli.setApellidoP(rs.getString("ap_pat"));
                    cli.setApellidoM(rs.getString("ap_mat"));
                    cli.setDireccion(rs.getString("direccion"));
                    cli.setTelefono(rs.getString("telefono"));
                    cli.setEmail(rs.getString("email"));;
                }
                rq.setAttribute("cliente", cli);

                rq.getRequestDispatcher("vistas/clientes/modificar.jsp").forward(rq, rp);
               
            } catch (SQLException ex) {
                System.out.println("Error en SQL " + ex.getMessage());
            }
        }
      
        else if (opc.equals("eliminar")) {

            int id_cliente = Integer.parseInt(rq.getParameter(("id_cliente")));
            ClientesDAO clientdao = new ClientesDAO();
            clientdao.delete(id_cliente);
            rp.sendRedirect("ServletCliente");
        }
    }
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        String op;
        op=(String)rq.getSession().getAttribute("op");
       if (op.equals("nuevo")) {

            String nombre = rq.getParameter("nombre");
            String apellido_Pat = rq.getParameter("ap_pat");
            String apellido_Mat = rq.getParameter("ap_mat");
            String direccion = rq.getParameter("direccion");
            String telefono = rq.getParameter("telefono");
           String email = rq.getParameter("email");
            Date fecha_nac = Date.valueOf(rq.getParameter("fecha_nac"));

            Clientes client = new Clientes(nombre, apellido_Pat, apellido_Mat, direccion, email, telefono,fecha_nac);
            ClientesDAO clidaoo = new ClientesDAO();
            clidaoo.insert(client);
            rp.sendRedirect("/EjemploCliente/ServletCliente");
        }
       
    }
}

