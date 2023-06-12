package controlador;

import datos.ContratosDAO;
import datos.ContratosDAO;
import model.Contratos;
import model.Contratos;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletContrato", urlPatterns = {"/ServletContrato"})
public class ServletContrato extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException {
        String op = (rq.getParameter("op") != null) ? rq.getParameter("op") : "lista";

        if (op.equals("lista")) {
            ContratosDAO contratodao = new ContratosDAO();
            ArrayList<Contratos> lista = contratodao.selectAll();
            rq.setAttribute("lista", lista);
            rq.getRequestDispatcher("/Contratos/lista_contrato.jsp").forward(rq, rp);
        }
        else if (op.equals("Buscar")) {
            int id_contrato = Integer.parseInt(rq.getParameter("id_contrato"));
            ContratosDAO contratodao = new ContratosDAO();
            Contratos contrato = contratodao.select(id_contrato);
            rq.setAttribute("contrato", contrato);
            rq.getRequestDispatcher("/Contratos/lista_contrato.jsp").forward(rq, rp);
        }
        else if (op.equals("Eliminar")) {
            int id_contrato = Integer.parseInt(rq.getParameter(("id_contrato")));
            ContratosDAO contratodao = new ContratosDAO();
            contratodao.delete(id_contrato);
            rp.sendRedirect("/paseos_el_puerto/ServletContrato");
        }
        else if (op.equals("Autollenado")) {
            int id = Integer.parseInt(rq.getParameter("id"));
            ContratosDAO contratosDAO = new ContratosDAO();
            Contratos contrato = contratosDAO.select(id);
            rq.setAttribute("contrato", contrato);
            rq.getRequestDispatcher("/Contratos/actualiza_contrato.jsp").forward(rq, rp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        String op = rq.getParameter("op");

        if ("Registrar".equals(op)) {
            int id_embarcacion = Integer.parseInt(rq.getParameter("id_embarcacion"));
            String fecha_inicio = rq.getParameter("fecha_inicio");
            String fecha_fin = rq.getParameter("fecha_fin");
            float costo_hora = Float.parseFloat(rq.getParameter("costo_hora"));
            Contratos contrato = new Contratos(id_embarcacion, fecha_inicio, fecha_fin, costo_hora);
            ContratosDAO contratodao = new ContratosDAO();
            contratodao.insert(contrato);
            rp.sendRedirect("/paseos_el_puerto/Contratos/inserta_embarcacion.jsp");
        }

        else if (op.equals("Modificar")) {
            int id_contrato = Integer.parseInt(rq.getParameter("id_contrato"));
            String fecha_inicio = rq.getParameter("fecha_inicio");
            String fecha_fin = rq.getParameter("fecha_fin");
            float costo_hora = Float.parseFloat(rq.getParameter("costo_hora"));
            Contratos contrato = new Contratos(fecha_inicio, id_contrato, fecha_fin,costo_hora);
            ContratosDAO contratodao = new ContratosDAO();
            contratodao.update(contrato);
            rp.sendRedirect("/paseos_el_puerto/Contratos/actualiza_contrato.jsp");
        }
    }
}