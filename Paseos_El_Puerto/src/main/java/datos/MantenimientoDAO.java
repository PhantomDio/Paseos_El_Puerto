package datos;

import model.Mantenimiento;

import java.sql.*;
import java.util.ArrayList;

public class MantenimientoDAO {

    public Mantenimiento select(int id) {
        String selectSQL = "SELECT * FROM mantenimiento WHERE id_mantenimiento = ?";
        try {
            PreparedStatement statement = Conexion.getConnection().prepareStatement(selectSQL);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            Mantenimiento mantenimiento = new Mantenimiento();
            while (rs.next()) {
                mantenimiento.setIdMantenimiento(rs.getInt("id_mantenimiento"));
                mantenimiento.setIdEmbarcacion(rs.getInt("id_embarcacion"));
                mantenimiento.setDescripcion(rs.getString("descripcion"));
                mantenimiento.setCosto(rs.getFloat("costo"));
                mantenimiento.setFechaInicio(rs.getDate("fecha_inicio"));
                mantenimiento.setFechaFin(rs.getDate("fecha_fin"));
            }
            statement.close();
            rs.close();
            return mantenimiento;

        } catch (SQLException ex) {
            System.out.println("Error al seleccionar mantenimiento: " + ex.getMessage());
            return null;
        }
    }
    public ArrayList<Mantenimiento> selectAll() {
        Connection conn;
        Statement state;
        ResultSet rs;
        Mantenimiento mantenimiento;
        String selectSQL = "SELECT * FROM mantenimiento" +
                " ORDER BY id_mantenimiento ASC ";

        ArrayList<Mantenimiento> mantenimientos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            rs = state.executeQuery(selectSQL);


            while (rs.next()) {
                mantenimiento = new Mantenimiento();

                mantenimiento.setIdMantenimiento(rs.getInt("id_mantenimiento"));
                mantenimiento.setIdEmbarcacion(rs.getInt("id_embarcacion"));
                mantenimiento.setDescripcion(rs.getString("descripcion"));
                mantenimiento.setCosto(rs.getFloat("costo"));
                mantenimiento.setFechaInicio(rs.getDate("fecha_inicio"));
                mantenimiento.setFechaFin(rs.getDate("fecha_fin"));

                mantenimientos.add(mantenimiento);
            }

            Conexion.close(rs);
            Conexion.close(state);
            Conexion.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return mantenimientos;
    }

   private int INSERT_UPDATE(Mantenimiento mantenimiento, String query, Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, mantenimiento.getIdEmbarcacion());
        ps.setString(2, mantenimiento.getDescripcion());
        ps.setFloat(3, mantenimiento.getCosto());
        ps.setDate(4, mantenimiento.getFechaInicio());
        if (mantenimiento.getIdMantenimiento() != 0) {
            // Si el ID del mantenimiento es diferente de cero, se trata de una actualización
            ps.setDate(5, mantenimiento.getFechaFin());
            ps.setInt(6, mantenimiento.getIdMantenimiento());
        }
        return ps.executeUpdate();
    }

    public void insert(Mantenimiento mantenimiento) {
        String insertSQL = "INSERT INTO mantenimiento (id_embarcacion, descripcion, costo, fecha_inicio) " +
                "VALUES (?, ?, ?, ?)";
        try (Connection con = Conexion.getConnection()) {
            int R = INSERT_UPDATE(mantenimiento, insertSQL, con);
            if (R > 0) {
                System.out.println("Registro agregado exitosamente.");
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo agregar el mantenimiento: " + ex.getMessage());
        }
    }

    public void update(Mantenimiento mantenimiento) {
        String updateSQL = "UPDATE mantenimiento SET id_embarcacion = ?, descripcion = ?, costo = ?, fecha_inicio = ?," +
                " fecha_fin = ? WHERE id_mantenimiento = ?";
        try (Connection con = Conexion.getConnection()) {
            int R = INSERT_UPDATE(mantenimiento, updateSQL, con);
            if (R > 0) {
                System.out.println("Registro modificado exitosamente.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al modificar el mantenimiento: " + ex.getMessage());
        }
    }

    public void delete(int id) {
        String deleteSQL = "DELETE FROM mantenimiento WHERE id_mantenimiento=?";
        try {
            PreparedStatement statement = Conexion.getConnection().prepareStatement(deleteSQL);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
            System.out.println("Registro eliminado exitosamente.");
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el mantenimiento: " + ex.getMessage());
        }
    }
    public void finalizarMantenimiento(int idMantenimiento) {
        try (Connection con = Conexion.getConnection()) {
            String query = "UPDATE mantenimiento SET fecha_fin = CURRENT_DATE WHERE id_mantenimiento = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idMantenimiento);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al finalizar el mantenimiento: " + ex.getMessage());
        }
    }
}