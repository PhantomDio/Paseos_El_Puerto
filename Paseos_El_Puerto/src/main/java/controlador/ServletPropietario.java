package controlador;

import datos.PropietariosDAO;
import model.Propietarios;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletPropietario", urlPatterns = {"/ServletPropietario"})
public class ServletPropietario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException {
        String op = (rq.getParameter("op") != null) ? rq.getParameter("op") : "lista";

        if (op.equals("lista")) {
            PropietariosDAO propdao = new PropietariosDAO();
            List<Propietarios> lista = propdao.selectAll();
            rq.setAttribute("lista", lista);
            rq.getRequestDispatcher("/Propietarios/lista_propietario.jsp").forward(rq, rp);
        }
        else if (op.equals("Buscar")) {
            int id_propietario = Integer.parseInt(rq.getParameter("id_propietario"));
            PropietariosDAO propdao = new PropietariosDAO();
            Propietarios propietario = propdao.select(id_propietario);
            rq.setAttribute("propietario", propietario);
            rq.getRequestDispatcher("/Propietarios/lista_propietario.jsp").forward(rq, rp);
        }
        else if (op.equals("Eliminar")) {
            int id_propietario = Integer.parseInt(rq.getParameter(("id_propietario")));
            PropietariosDAO propdao = new PropietariosDAO();
            propdao.delete(id_propietario);
            rp.sendRedirect("/paseos_el_puerto/ServletPropietario");
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

            Propietarios client = new Propietarios(nombre, apellido_Pat, apellido_Mat, direccion, telefono, email, fecha_nac);
            PropietariosDAO propdao = new PropietariosDAO();
            propdao.insert(client);
            rp.sendRedirect("/paseos_el_puerto/Propietarios/inserta_propietario.jsp");
        }

        else if (op.equals("Modificar")) {
            int id_propietario = Integer.parseInt(rq.getParameter("id_propietario"));
            String nombre = rq.getParameter("nombre");
            String apellido_Pat = rq.getParameter("ap_pat");
            String apellido_Mat = rq.getParameter("ap_mat");
            String direccion = rq.getParameter("direccion");
            String telefono = rq.getParameter("telefono");
            String email = rq.getParameter("email");
            String fecha_nac = rq.getParameter("fecha_nac");

            Propietarios client = new Propietarios(id_propietario,nombre, apellido_Pat, apellido_Mat, direccion, telefono, email, fecha_nac);
            PropietariosDAO propdao = new PropietariosDAO();
            propdao.update(client);
            rp.sendRedirect("/paseos_el_puerto/Propietarios/actualiza_propietario.jsp");
        }
    }
}