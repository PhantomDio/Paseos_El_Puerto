package controlador;

import datos.ReparacionDAO;
import model.Reparacion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletReparacion", urlPatterns = {"/ServletReparacion"})
public class ServletReparacion extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException {
        String op = (rq.getParameter("op") != null) ? rq.getParameter("op") : "lista";

        if (op.equals("lista")) {
            ReparacionDAO reparacionDAO = new ReparacionDAO();
            ArrayList<Reparacion> lista = reparacionDAO.selectAll();
            rq.setAttribute("lista", lista);
            rq.getRequestDispatcher("/Reparacion/lista_reparacion.jsp").forward(rq, rp);
        }

        else if(op.equals("listActivos")) {
            ArrayList<Reparacion> listActivos = new ArrayList<Reparacion>();
            ReparacionDAO reparacionDAO = new ReparacionDAO();
            ArrayList<Reparacion> lista = reparacionDAO.selectAll();
            if (lista != null && !lista.isEmpty()) {
                for (Reparacion reparacion : lista) {
                    if (reparacion.getEstado(reparacion.getFechaFin()).equals("Activo"))
                        listActivos.add(reparacion);
                }
                rq.setAttribute("lista", listActivos);
                rq.getRequestDispatcher("/Reparacion/lista_reparacion.jsp").forward(rq, rp);
            }
        }

        else if (op.equals("Buscar")) {
            int id_reparacion = Integer.parseInt(rq.getParameter("id_reparacion"));
            ReparacionDAO reparacionDAO = new ReparacionDAO();
            Reparacion reparacion = reparacionDAO.select(id_reparacion);
            rq.setAttribute("reparacion", reparacion);
            rq.getRequestDispatcher("/Reparacion/lista_reparacion.jsp").forward(rq, rp);
        }
        
        else if (op.equals("Autollenado")) {
            int id = Integer.parseInt(rq.getParameter("id"));
            ReparacionDAO reparacionDAO = new ReparacionDAO();
            Reparacion reparacion = reparacionDAO.select(id);
            rq.setAttribute("reparacion", reparacion);
            rq.getRequestDispatcher("/Reparacion/actualiza_reparacion.jsp").forward(rq, rp);
        }
        
        else if (op.equals("Eliminar")) {
            int id_reparacion = Integer.parseInt(rq.getParameter(("id_reparacion")));
            ReparacionDAO reparacionDAO = new ReparacionDAO();
            reparacionDAO.delete(id_reparacion);
            rp.sendRedirect("/paseos_el_puerto/ServletReparacion");
        }
        
        else if (op.equals("Finalizar")) {
            int id_reparacion = Integer.parseInt(rq.getParameter(("id_reparacion")));
            ReparacionDAO reparacionDAO = new ReparacionDAO();
            reparacionDAO.finalizarReparacion(id_reparacion);
            rp.sendRedirect("/paseos_el_puerto/ServletReparacion");
        }
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        String op = rq.getParameter("op");

        if ("Registrar".equals(op)) {
            int id_embarcacion = Integer.parseInt(rq.getParameter("id_embarcacion"));
            String descripcion = rq.getParameter("descripcion");
            float costo = Float.parseFloat(rq.getParameter("costo"));
            String fecha_inicio = rq.getParameter("fecha_inicio");

            Reparacion reparacion = new Reparacion(id_embarcacion,descripcion, costo, fecha_inicio);
            ReparacionDAO reparacionDAO = new ReparacionDAO();
            reparacionDAO.insert(reparacion);
            rp.sendRedirect("/paseos_el_puerto/Reparacion/inserta_reparacion.jsp");
        }

        else if (op.equals("Modificar")) {
            int id_reparacion = Integer.parseInt(rq.getParameter("id_reparacion"));
            int id_embarcacion = Integer.parseInt(rq.getParameter("id_embarcacion"));
            int id_paseo = Integer.parseInt(rq.getParameter("id_paseo"));
            String descripcion = rq.getParameter("descripcion");
            float costo = Float.parseFloat(rq.getParameter("costo"));
            String fecha_inicio = rq.getParameter("fecha_inicio");
            String fecha_fin = rq.getParameter("fecha_fin");

            Reparacion reparacion = new Reparacion(id_reparacion,id_embarcacion, id_paseo, descripcion, costo, fecha_inicio, fecha_fin);
            ReparacionDAO reparacionDAO = new ReparacionDAO();
            reparacionDAO.update(reparacion);
            rp.sendRedirect("/paseos_el_puerto/Reparacion/actualiza_reparacion.jsp");
        }
    }
}