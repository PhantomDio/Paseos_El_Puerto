package controlador;

import datos.EmbarcacionesDAO;
import datos.PaseosDAO;
import model.Embarcaciones;
import model.Paseos;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletPaseo", urlPatterns = {"/ServletPaseo"})
public class ServletPaseo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException {
        String op = (rq.getParameter("op") != null) ? rq.getParameter("op") : "lista";

        if (op.equals("lista")) {
            PaseosDAO paseoDAO = new PaseosDAO();
            ArrayList<Paseos> lista = paseoDAO.selectAll();
            rq.setAttribute("lista", lista);
            rq.getRequestDispatcher("/Paseos/lista_paseo.jsp").forward(rq, rp);
        }

        else if (op.equals("listaEmb")) {
            EmbarcacionesDAO embardao = new EmbarcacionesDAO();
            ArrayList<Embarcaciones> lista = embardao.selectAll();
            rq.setAttribute("listaemb", lista);
            rq.getRequestDispatcher("/Paseos/inserta_paseo.jsp").forward(rq, rp);
        }

        else if (op.equals("Buscar")) {
            int id_paseo = Integer.parseInt(rq.getParameter("id_paseo"));
            PaseosDAO paseoDAO = new PaseosDAO();
            Paseos paseo = paseoDAO.select(id_paseo);
            rq.setAttribute("paseo", paseo);
            rq.getRequestDispatcher("/Paseos/lista_paseo.jsp").forward(rq, rp);
        }

        else if (op.equals("Autollenado")) {
            int id_paseo = Integer.parseInt(rq.getParameter("id_paseo"));
            PaseosDAO paseoDAO = new PaseosDAO();
            Paseos paseo = paseoDAO.select(id_paseo);
            rq.setAttribute("paseo", paseo);
            rq.getRequestDispatcher("/Paseos/actualiza_paseo.jsp").forward(rq, rp);
        }

        else if (op.equals("Eliminar")) {
            int id_paseo = Integer.parseInt(rq.getParameter(("id_paseo")));
            PaseosDAO paseoDAO = new PaseosDAO();
            paseoDAO.delete(id_paseo);
            rp.sendRedirect("/paseos_el_puerto/ServletPaseo");
        }
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        String op = rq.getParameter("op");

        if ("Registrar".equals(op)) {
            int id_embarcacion = Integer.parseInt(rq.getParameter("id_embarcacion"));
            int id_cliente = Integer.parseInt(rq.getParameter("id_cliente"));
            String fecha_inicio = rq.getParameter("fecha_inicio");
            String fecha_fin = rq.getParameter("fecha_fin");
            Paseos paseo = new Paseos(id_embarcacion, id_cliente, fecha_inicio, fecha_fin);
            PaseosDAO paseoDAO = new PaseosDAO();
            paseoDAO.insert(paseo);
            rp.sendRedirect("/paseos_el_puerto/ServletPasPers");
        }

        else if (op.equals("Modificar")) {
            int id_paseo = Integer.parseInt(rq.getParameter("id_paseo"));
            int id_embarcacion = Integer.parseInt(rq.getParameter("id_embarcacion"));
            int id_cliente = Integer.parseInt(rq.getParameter("id_cliente"));
            String fecha_inicio = rq.getParameter("fecha_inicio");
            String fecha_fin = rq.getParameter("fecha_fin");

            Paseos paseo = new Paseos(id_paseo, id_embarcacion, id_cliente, fecha_inicio, fecha_fin);
            PaseosDAO paseoDAO = new PaseosDAO();
            paseoDAO.update(paseo);
            rp.sendRedirect("/paseos_el_puerto/Paseos/actualiza_paseo.jsp");
        }
    }
}