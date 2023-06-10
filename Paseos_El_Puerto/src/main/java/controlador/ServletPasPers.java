package controlador;

import datos.PaseosDAO;
import datos.Paseos_PersonalDAO;
import datos.PersonalDAO;
import model.Paseos;
import model.Paseos_Personal;
import model.Personal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletPasPers", urlPatterns = {"/ServletPasPers"})
public class ServletPasPers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException {
        String op = (rq.getParameter("op") != null) ? rq.getParameter("op") : "listaPers";

        if (op.equals("listaPers")) {
            PersonalDAO personalDAO = new PersonalDAO();
            ArrayList<Personal> lista = personalDAO.selectAll();
            rq.setAttribute("listapers", lista);
            rq.getRequestDispatcher("/Paseos/Monto_total.jsp").forward(rq, rp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        String op = rq.getParameter("op");

        if ("Agregar".equals(op)) {
            int id_personal = Integer.parseInt(rq.getParameter("id_personal"));
            Paseos_Personal pp = new Paseos_Personal(id_personal);
            Paseos_PersonalDAO ppDAO = new Paseos_PersonalDAO();
            ppDAO.insert(pp);
            rp.sendRedirect("/paseos_el_puerto/ServletPasPers");        }

        else if (op.equals("Terminar Registro")) {
            float monto_total = Float.parseFloat(rq.getParameter("monto_total"));
            PaseosDAO paseoDAO = new PaseosDAO();
            paseoDAO.insertMontoT(monto_total);
            rp.sendRedirect("/paseos_el_puerto/index.jsp");
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