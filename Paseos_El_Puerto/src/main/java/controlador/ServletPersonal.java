package controlador;

import datos.PersonalDAO;
import model.Personal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletPersonal", urlPatterns = {"/ServletPersonal"})
public class ServletPersonal extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException {
        String op = (rq.getParameter("op") != null) ? rq.getParameter("op") : "lista";

        if (op.equals("lista")) {
            PersonalDAO persDAO = new PersonalDAO();
            ArrayList<Personal> lista = persDAO.selectAll();
            rq.setAttribute("lista", lista);
            rq.getRequestDispatcher("/Personal/lista_propietario.jsp").forward(rq, rp);
        }
        else if (op.equals("Buscar")) {
            int id_personal = Integer.parseInt(rq.getParameter("id_personal"));
            PersonalDAO persDAO = new PersonalDAO();
            Personal personal = persDAO.select(id_personal);
            rq.setAttribute("personal", personal);
            rq.getRequestDispatcher("/Personal/lista_propietario.jsp").forward(rq, rp);
        }
        else if (op.equals("Eliminar")) {
            int id_personal = Integer.parseInt(rq.getParameter(("id_personal")));
            PersonalDAO persDAO = new PersonalDAO();
            persDAO.delete(id_personal);
            rp.sendRedirect("/paseos_el_puerto/ServletPersonal");
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
            float costo_hora = Float.parseFloat(rq.getParameter("costo_hora"));
            String fecha_nac = rq.getParameter("fecha_nac");


            Personal personal = new Personal(nombre, apellido_Pat, apellido_Mat, direccion,
                    telefono, email, costo_hora, fecha_nac);
            PersonalDAO persDAO = new PersonalDAO();
            persDAO.insert(personal);
            rp.sendRedirect("/paseos_el_puerto/Personal/inserta_propietario.jsp");
        }

        else if (op.equals("Modificar")) {
            int id_personal = Integer.parseInt(rq.getParameter("id_personal"));
            String nombre = rq.getParameter("nombre");
            String apellido_Pat = rq.getParameter("ap_pat");
            String apellido_Mat = rq.getParameter("ap_mat");
            String direccion = rq.getParameter("direccion");
            String telefono = rq.getParameter("telefono");
            String email = rq.getParameter("email");
            float costo_hora = Float.parseFloat(rq.getParameter("costo_hora"));
            String fecha_nac = rq.getParameter("fecha_nac");

            Personal personal = new Personal(id_personal,nombre, apellido_Pat, apellido_Mat, direccion,
                    telefono, email, costo_hora, fecha_nac);
            PersonalDAO persDAO = new PersonalDAO();
            persDAO.update(personal);
            rp.sendRedirect("/paseos_el_puerto/Personal/actualiza_personal.jsp");
        }
    }
}