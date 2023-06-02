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
        String op = (rq.getParameter("op") != null) ? rq.getParameter("op") : "lista";

        if (op.equals("lista")) {
            ClientesDAO clidao = new ClientesDAO();
            ArrayList<Clientes> listaClientes = clidao.selectAll();
            rq.setAttribute("listaClientes", listaClientes);
            rq.getRequestDispatcher("/Clientes/lista_cliente.jsp").forward(rq, rp);
        }
        else if (op.equals("Buscar")) {
            int id_cliente = Integer.parseInt(rq.getParameter("id_cliente"));
            ClientesDAO clidao = new ClientesDAO();
            Clientes cli = clidao.select(id_cliente);
            rq.setAttribute("cliente", cli);
            rq.getRequestDispatcher("/Clientes/lista_cliente.jsp").forward(rq, rp);
        }
        else if (op.equals("Eliminar")) {
            int id_cliente = Integer.parseInt(rq.getParameter(("id_cliente")));
            ClientesDAO clientdao = new ClientesDAO();
            clientdao.delete(id_cliente);
            rp.sendRedirect("/paseos_el_puerto/ServletCliente");
        }
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        String op = rq.getParameter("op");

        if ("Registrar".equals(op)) {
            String nombre = rq.getParameter("nombre");
            String apellido_Pat = rq.getParameter("ap_pat");
            String apellido_Mat = rq.getParameter("ap_mat");
            String direccion = rq.getParameter("direccion");
            String telefono = rq.getParameter("telefono");
            String email = rq.getParameter("email");
            String fecha_nac = rq.getParameter("fecha_nac");

            Clientes client = new Clientes(nombre, apellido_Pat, apellido_Mat, direccion, telefono, email, fecha_nac);
            ClientesDAO clidao = new ClientesDAO();
            clidao.insert(client);
            rp.sendRedirect("/paseos_el_puerto/Clientes/inserta_cliente.jsp");
        }

        else if (op.equals("Modificar")) {
            int id_cliente = Integer.parseInt(rq.getParameter("id_cliente"));
            String nombre = rq.getParameter("nombre");
            String apellido_Pat = rq.getParameter("ap_pat");
            String apellido_Mat = rq.getParameter("ap_mat");
            String direccion = rq.getParameter("direccion");
            String telefono = rq.getParameter("telefono");
            String email = rq.getParameter("email");
            String fecha_nac = rq.getParameter("fecha_nac");

            Clientes client = new Clientes(id_cliente,nombre, apellido_Pat, apellido_Mat, direccion, telefono, email, fecha_nac);
            ClientesDAO clidao = new ClientesDAO();
            clidao.update(client);
            rp.sendRedirect("/paseos_el_puerto/Clientes/actualiza_cliente.jsp");
        }
    }
}