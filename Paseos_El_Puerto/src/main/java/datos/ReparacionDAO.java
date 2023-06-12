package datos;

import model.Reparacion;

import java.sql.*;
import java.util.ArrayList;

public class ReparacionDAO {

    public Reparacion select(int id) {
        String selectSQL = "SELECT * FROM reparacion WHERE id_reparacion = ?";
        try {
            PreparedStatement statement = Conexion.getConnection().prepareStatement(selectSQL);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            Reparacion reparacion = new Reparacion();
            while (rs.next()) {
                reparacion.setIdReparacion(rs.getInt("id_reparacion"));
                reparacion.setIdEmbarcacion(rs.getInt("id_embarcacion"));
                reparacion.setDescripcion(rs.getString("descripcion"));
                reparacion.setCosto(rs.getFloat("costo"));
                reparacion.setFechaInicio(rs.getDate("fecha_inicio"));
                reparacion.setFechaFin(rs.getDate("fecha_fin"));
            }
            statement.close();
            rs.close();
            return reparacion;

        } catch (SQLException ex) {
            System.out.println("Error al seleccionar reparacion: " + ex.getMessage());
            return null;
        }
    }
    public ArrayList<Reparacion> selectAll() {
        Connection conn;
        Statement state;
        ResultSet rs;
        Reparacion reparacion;
        String selectSQL = "SELECT * FROM reparacion" +
                " ORDER BY id_reparacion ASC ";

        ArrayList<Reparacion> reparaciones = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            rs = state.executeQuery(selectSQL);


            while (rs.next()) {
                reparacion = new Reparacion();

                reparacion.setIdReparacion(rs.getInt("id_reparacion"));
                reparacion.setIdEmbarcacion(rs.getInt("id_embarcacion"));
                reparacion.setDescripcion(rs.getString("descripcion"));
                reparacion.setCosto(rs.getFloat("costo"));
                reparacion.setFechaInicio(rs.getDate("fecha_inicio"));
                reparacion.setFechaFin(rs.getDate("fecha_fin"));

                reparaciones.add(reparacion);
            }

            Conexion.close(rs);
            Conexion.close(state);
            Conexion.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return reparaciones;
    }

    private int INSERT_UPDATE(Reparacion reparacion, String query, Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, reparacion.getIdEmbarcacion());

        if (reparacion.getIdPaseo() != 0) {
            ps.setInt(2, reparacion.getIdPaseo());
        } else {
            ps.setNull(2, Types.INTEGER);
        }

        ps.setString(3, reparacion.getDescripcion());
        ps.setFloat(4, reparacion.getCosto());
        ps.setDate(5, reparacion.getFechaInicio());

        if (reparacion.getIdReparacion() != 0) {
            // Si el ID del reparacion es diferente de cero, se trata de una actualización
            ps.setDate(6, reparacion.getFechaFin());
            ps.setInt(7, reparacion.getIdReparacion());
        }

        return ps.executeUpdate();
    }

    public void insert(Reparacion reparacion) {
        String insertSQL = "INSERT INTO reparacion (id_embarcacion, id_paseo, descripcion, costo, fecha_inicio) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (Connection con = Conexion.getConnection()) {
            int R = INSERT_UPDATE(reparacion, insertSQL, con);
            if (R > 0) {
                System.out.println("Registro agregado exitosamente.");
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo agregar el reparacion: " + ex.getMessage());
        }
    }

    public void update(Reparacion reparacion) {
        String updateSQL = "UPDATE reparacion SET id_embarcacion = ?, id_paseo = ?, descripcion = ?, costo = ?, fecha_inicio = ?," +
                " fecha_fin = ? WHERE id_reparacion = ?";
        try (Connection con = Conexion.getConnection()) {
            int R = INSERT_UPDATE(reparacion, updateSQL, con);
            if (R > 0) {
                System.out.println("Registro modificado exitosamente.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al modificar el reparacion: " + ex.getMessage());
        }
    }

    public void delete(int id) {
        String deleteSQL = "DELETE FROM reparacion WHERE id_reparacion=?";
        try {
            PreparedStatement statement = Conexion.getConnection().prepareStatement(deleteSQL);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
            System.out.println("Registro eliminado exitosamente.");
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el reparacion: " + ex.getMessage());
        }
    }
    public void finalizarReparacion(int idReparacion) {
        try (Connection con = Conexion.getConnection()) {
            String query = "UPDATE reparacion SET fecha_fin = CURRENT_DATE WHERE id_reparacion = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idReparacion);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al finalizar el reparacion: " + ex.getMessage());
        }
    }
}