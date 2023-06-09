package controlador;

import datos.Paseos_PersonalDAO;
import model.Paseos_Personal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletPasPers", urlPatterns = {"/ServletPasPers"})
public class ServletPasPers extends HttpServlet {

    /*
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException {
        String op = (rq.getParameter("op") != null) ? rq.getParameter("op") : "listaPers";

         if (op.equals("lista")) {
            Paseos_PersonalDAO ppDAO = new Paseos_PersonalDAO();
            ArrayList<Paseos_Personal> lista = ppDAO.selectAll();
            rq.setAttribute("lista", lista);
            rq.getRequestDispatcher("/Paseos_Personal/lista_propietario.jsp").forward(rq, rp);
        }

        else if (op.equals("Buscar")) {
            int id_personal = Integer.parseInt(rq.getParameter("id_personal"));
            Paseos_PersonalDAO ppDAO = new Paseos_PersonalDAO();
            Paseos_Personal pp = ppDAO.select(id_personal);
            rq.setAttribute("pp", pp);
            rq.getRequestDispatcher("/Paseos_Personal/lista_propietario.jsp").forward(rq, rp);
        }
        else if (op.equals("Eliminar")) {
            int id_personal = Integer.parseInt(rq.getParameter(("id_personal")));
            Paseos_PersonalDAO ppDAO = new Paseos_PersonalDAO();
            ppDAO.delete(id_personal);
            rp.sendRedirect("/paseos_el_puerto/ServletPasPers");
        }
    } */

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        String op = rq.getParameter("op");

        if ("Agregar Personal".equals(op)) {
            int id_personal = Integer.parseInt(rq.getParameter("id_personal"));
            Paseos_Personal pp = new Paseos_Personal(id_personal);
            Paseos_PersonalDAO ppDAO = new Paseos_PersonalDAO();
            ppDAO.insert(pp);
            rp.sendRedirect("/paseos_el_puerto/ServletPersonal");
        }

        else if (op.equals("Modificar")) {

            int id_paseo = Integer.parseInt(rq.getParameter("id_paseo"));
            int id_personal = Integer.parseInt(rq.getParameter("id_personal"));
            Paseos_Personal pp = new Paseos_Personal(id_personal, id_paseo);
            Paseos_PersonalDAO ppDAO = new Paseos_PersonalDAO();
            ppDAO.update(pp);
            rp.sendRedirect("/paseos_el_puerto/Paseos_Personal/actualiza_personal.jsp");
        }
    }
}