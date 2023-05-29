package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import model.Clientes;
import datos.ClientesDAO;
import java.util.*;

@WebServlet(name = "ServletCliente", urlPatterns = {"/ServletCliente"})
public class ServletCliente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException {
        String op = (rq.getParameter("op") != null) ? rq.getParameter("op") : "list";

        if (op.equals("list")) {
            ClientesDAO clidao = new ClientesDAO();
            List<Clientes> listaClientes = clidao.selectAll();
            rq.setAttribute("listaClientes", listaClientes);
            rq.getRequestDispatcher("/Clientes/lista_cliente.jsp").forward(rq, rp);
        }

        else if (op.equals("Buscar")) {
            int id_cliente = Integer.parseInt(rq.getParameter("id_cliente"));
            ClientesDAO clidao = new ClientesDAO();
                Clientes cli = new Clientes();
                cli = clidao.select(id_cliente);
                rq.setAttribute("cliente", cli);
                rq.getRequestDispatcher("/Clientes/lista_cliente.jsp").forward(rq, rp);
                
        }

        else if (op.equals("Eliminar")) {

            int id_cliente = Integer.parseInt(rq.getParameter(("id_cliente")));
            ClientesDAO clientdao = new ClientesDAO();
            clientdao.delete(id_cliente);
            rp.sendRedirect("ServletCliente");
        }
    }
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        String op=(String)rq.getSession().getAttribute("op");

       if (op.equals("nuevo")) {

            String nombre = rq.getParameter("nombre");
            String apellido_Pat = rq.getParameter("ap_pat");
            String apellido_Mat = rq.getParameter("ap_mat");
            String direccion = rq.getParameter("direccion");
            String telefono = rq.getParameter("telefono");
            String email = rq.getParameter("email");
            String fecha_nac = rq.getParameter("fecha_nac");

            Clientes client = new Clientes(nombre, apellido_Pat, apellido_Mat, direccion, email, telefono,fecha_nac);
            ClientesDAO clidaoo = new ClientesDAO();
            clidaoo.insert(client);
            rp.sendRedirect("/Clientes/ServletCliente");
        }
       else if (op.equals("lista")){
           ClientesDAO clidao = new ClientesDAO();
           List<Clientes> listaClientes = clidao.selectAll();
           rq.getSession().setAttribute("listaClientes", listaClientes);
           rp.sendRedirect("/Clientes/lista_cliente.jsp");
       }
    }
}