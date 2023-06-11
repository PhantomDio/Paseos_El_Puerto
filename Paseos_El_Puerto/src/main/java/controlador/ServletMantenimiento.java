package controlador;

import datos.MantenimientoDAO;
import model.Mantenimiento;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletMantenimiento", urlPatterns = {"/ServletMantenimiento"})
public class ServletMantenimiento extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException {
        String op = (rq.getParameter("op") != null) ? rq.getParameter("op") : "lista";

        if (op.equals("lista")) {
            MantenimientoDAO mantenimientoDAO = new MantenimientoDAO();
            ArrayList<Mantenimiento> lista = mantenimientoDAO.selectAll();
            rq.setAttribute("lista", lista);
            rq.getRequestDispatcher("/Mantenimiento/lista_mantenimiento.jsp").forward(rq, rp);
        }

        else if(op.equals("listActivos")) {
            ArrayList<Mantenimiento> listActivos = new ArrayList<Mantenimiento>();
            MantenimientoDAO mantenimientoDAO = new MantenimientoDAO();
            ArrayList<Mantenimiento> lista = mantenimientoDAO.selectAll();
            if (lista != null && !lista.isEmpty()) {
                for (Mantenimiento mantenimiento : lista) {
                    if (mantenimiento.getEstado(mantenimiento.getFechaFin()).equals("Activo"))
                        listActivos.add(mantenimiento);
                }
                rq.setAttribute("lista", listActivos);
                rq.getRequestDispatcher("/Mantenimiento/lista_mantenimiento.jsp").forward(rq, rp);
            }
        }

        else if (op.equals("Buscar")) {
            int id_mantenimiento = Integer.parseInt(rq.getParameter("id_mantenimiento"));
            MantenimientoDAO mantenimientoDAO = new MantenimientoDAO();
            Mantenimiento mantenimiento = mantenimientoDAO.select(id_mantenimiento);
            rq.setAttribute("mantenimiento", mantenimiento);
            rq.getRequestDispatcher("/Mantenimiento/lista_mantenimiento.jsp").forward(rq, rp);
        }
        
        else if (op.equals("Autollenado")) {
            int id = Integer.parseInt(rq.getParameter("id"));
            MantenimientoDAO mantenimientoDAO = new MantenimientoDAO();
            Mantenimiento mantenimiento = mantenimientoDAO.select(id);
            rq.setAttribute("mantenimiento", mantenimiento);
            rq.getRequestDispatcher("/Mantenimiento/actualiza_mantenimiento.jsp").forward(rq, rp);
        }
        
        else if (op.equals("Eliminar")) {
            int id_mantenimiento = Integer.parseInt(rq.getParameter(("id_mantenimiento")));
            MantenimientoDAO mantenimientoDAO = new MantenimientoDAO();
            mantenimientoDAO.delete(id_mantenimiento);
            rp.sendRedirect("/paseos_el_puerto/ServletMantenimiento");
        }
        
        else if (op.equals("Finalizar")) {
            int id_mantenimiento = Integer.parseInt(rq.getParameter(("id_mantenimiento")));
            MantenimientoDAO mantenimientoDAO = new MantenimientoDAO();
            mantenimientoDAO.finalizarMantenimiento(id_mantenimiento);
            rp.sendRedirect("/paseos_el_puerto/ServletMantenimiento");
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

            Mantenimiento mantenimiento = new Mantenimiento(id_embarcacion,descripcion, costo, fecha_inicio);
            MantenimientoDAO mantenimientoDAO = new MantenimientoDAO();
            mantenimientoDAO.insert(mantenimiento);
            rp.sendRedirect("/paseos_el_puerto/Mantenimiento/inserta_mantenimiento.jsp");
        }

        else if (op.equals("Modificar")) {
            int id_mantenimiento = Integer.parseInt(rq.getParameter("id_mantenimiento"));
            int id_embarcacion = Integer.parseInt(rq.getParameter("id_embarcacion"));
            String descripcion = rq.getParameter("descripcion");
            float costo = Float.parseFloat(rq.getParameter("costo"));
            String fecha_inicio = rq.getParameter("fecha_inicio");
            String fecha_fin = rq.getParameter("fecha_fin");

            Mantenimiento mantenimiento = new Mantenimiento(id_mantenimiento,id_embarcacion,descripcion, costo, fecha_inicio, fecha_fin);
            MantenimientoDAO mantenimientoDAO = new MantenimientoDAO();
            mantenimientoDAO.update(mantenimiento);
            rp.sendRedirect("/paseos_el_puerto/Mantenimiento/actualiza_mantenimiento.jsp");
        }
    }
}