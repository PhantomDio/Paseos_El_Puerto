package controlador;

import datos.EmbarcacionesDAO;
import model.Embarcaciones;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletEmbarcacion", urlPatterns = {"/ServletEmbarcacion"})
public class ServletMantenimiento extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException {
        String op = (rq.getParameter("op") != null) ? rq.getParameter("op") : "lista";

        if (op.equals("lista")) {
            EmbarcacionesDAO embardao = new EmbarcacionesDAO();
            ArrayList<Embarcaciones> lista = embardao.selectAll();
            rq.setAttribute("lista", lista);
            rq.getRequestDispatcher("/Embarcaciones/lista_embarcacion.jsp").forward(rq, rp);
        }
        else if (op.equals("Buscar")) {
            int id_embarcacion = Integer.parseInt(rq.getParameter("id_embarcacion"));
            EmbarcacionesDAO embardao = new EmbarcacionesDAO();
            Embarcaciones embarcacion = embardao.select(id_embarcacion);
            rq.setAttribute("embarcacion", embarcacion);
            rq.getRequestDispatcher("/Embarcaciones/lista_embarcacion.jsp").forward(rq, rp);
        }
        else if (op.equals("Eliminar")) {
            int id_embarcacion = Integer.parseInt(rq.getParameter(("id_embarcacion")));
            EmbarcacionesDAO embardao = new EmbarcacionesDAO();
            embardao.delete(id_embarcacion);
            rp.sendRedirect("/paseos_el_puerto/ServletEmbarcacion");
        }
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        String op = rq.getParameter("op");

        if ("Registrar".equals(op)) {
            String nombre = rq.getParameter("nombre");
            String modelo = rq.getParameter("modelo");
            float longitud = Float.parseFloat(rq.getParameter("longitud"));
            int anio = Integer.parseInt(rq.getParameter("anio"));
            int id_propietario = Integer.parseInt(rq.getParameter("id_propietario"));

            Embarcaciones embarcacion = new Embarcaciones(nombre, modelo, longitud, anio, id_propietario);
            EmbarcacionesDAO embardao = new EmbarcacionesDAO();
            embardao.insert(embarcacion);
            rp.sendRedirect("/paseos_el_puerto/Contratos/inserta_contrato.jsp");
        }

        else if (op.equals("Modificar")) {
            int id_embarcacion = Integer.parseInt(rq.getParameter("id_embarcacion"));
            String nombre = rq.getParameter("nombre");
            String modelo = rq.getParameter("modelo");
            float longitud = Float.parseFloat(rq.getParameter("longitud"));
            int anio = Integer.parseInt(rq.getParameter("anio"));

            Embarcaciones embarcacion = new Embarcaciones(id_embarcacion, nombre, modelo, longitud, anio);
            EmbarcacionesDAO embardao = new EmbarcacionesDAO();
            embardao.update(embarcacion);
            rp.sendRedirect("/paseos_el_puerto/Embarcaciones/actualiza_embarcacion.jsp");
        }
    }
}