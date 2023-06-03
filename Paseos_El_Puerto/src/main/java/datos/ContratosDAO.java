package datos;

import model.Contratos;

import java.sql.*;
import java.util.ArrayList;

public class ContratosDAO {

    public Contratos select(int id) {
        String selectSQL = "SELECT * FROM contratos WHERE id_contrato=?";
        try {
            PreparedStatement statement = Conexion.getConnection().prepareStatement(selectSQL);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            Contratos contrato = new Contratos();
            while (rs.next()) {

                contrato.setIdEmbarcacion(rs.getInt("id_contrato"));
                contrato.setIdEmbarcacion(rs.getInt("id_embarcacion"));
                contrato.setFechaInicio(rs.getDate("fecha_inicio"));
                contrato.setFechaFin(rs.getDate("fecha_fin"));
                contrato.setCostoHora(rs.getFloat("costo_hora"));
                contrato.setEstado(contrato.getEstado());
            }
            statement.close();
            rs.close();
            return contrato;

        } catch (SQLException ex) {
            System.out.println("Error al seleccionar contrato: " + ex.getMessage());
            return null;
        }
    }
    public ArrayList<Contratos> selectAll(){
        Connection conn;
        Statement state;
        ResultSet rs;
        Contratos contrato = new Contratos();
        String selectSQL = "SELECT * FROM contratos";

        ArrayList<Contratos> contratos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            rs = state.executeQuery(selectSQL);

            while (rs.next()) {
                int id_contrato = rs.getInt("id_contrato");
                int id_embarcacion = rs.getInt("id_embarcacion");
                String fecha_inicio = rs.getString("fecha_inicio");
                String fecha_fin = rs.getString("fecha_fin");
                float costo_hora = rs.getInt("costo_hora")    ;
                String estado = contrato.getEstado();
                contrato = new Contratos(id_contrato,id_embarcacion,fecha_inicio,fecha_fin, costo_hora, estado);
                contratos.add(contrato);

            }

            Conexion.close(rs);
            Conexion.close(state);
            Conexion.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return contratos;
    }
    private int INSERT_UPDATE(Contratos contrato, String query, Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, contrato.getIdEmbarcacion());
        ps.setDate(2, contrato.getFechaInicio());
        ps.setDate(3, contrato.getFechaFin());
        ps.setFloat(4, contrato.getCostoHora());
        if (contrato.getIdContrato() != 0)
            // Si el ID del contrato es diferente de cero, se trata de una actualización
            ps.setInt(5, contrato.getIdContrato());
        return ps.executeUpdate();
    }

    public void insert(Contratos contrato) {
        String insertSQL = "INSERT INTO contratos (id_embarcacion, fecha_inicio, fecha_fin, costo_hora) " +
                "VALUES (?, ?, ?, ?)";
        try (Connection con = Conexion.getConnection()) {
            int R = INSERT_UPDATE(contrato, insertSQL, con);
            if (R > 0) {
                System.out.println("Registro agregado exitosamente.");
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo agregar el contrato: " + ex.getMessage());
        }
    }
    public void update(Contratos contrato) {
        String updateSQL = "UPDATE contratos SET id_embarcacion = ?, fecha_inicio = ?, fecha_fin = ?, costo_hora = ?" +
                " WHERE id_contrato = ?";
        try (Connection con = Conexion.getConnection()) {
            int R = INSERT_UPDATE(contrato, updateSQL, con);
            if (R > 0) {
                System.out.println("Registro modificado exitosamente.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al modificar el contrato: " + ex.getMessage());
        }
    }


    public void delete(int id) {
        String deleteSQL = "DELETE FROM contratos WHERE id_contrato=?";
        try {
            PreparedStatement statement = Conexion.getConnection().prepareStatement(deleteSQL);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
            System.out.println("Registro eliminado exitosamente.");
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el contrato: " + ex.getMessage());
        }
    }
}