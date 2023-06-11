package datos;

import model.Mantenimiento;

import java.sql.*;
import java.util.ArrayList;

/*public class MantenimientoDAO {

    public Mantenimiento select(int id) {
        String selectSQL = "SELECT * FROM mantenimiento WHERE id_mantenimiento = ?";
        try {
            PreparedStatement statement = Conexion.getConnection().prepareStatement(selectSQL);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            Mantenimiento mantenimiento = new Mantenimiento();
            while (rs.next()) {
                mantenimiento.setIdEmbarcacion(rs.getInt("id_embarcacion"));
                mantenimiento.setIdMantenimiento(rs.getInt("id_mantenimiento"));
                mantenimiento.setModelo(rs.getString("descripcion"));
                mantenimiento.setLongitud(rs.getFloat("costo"));
                mantenimiento.setFechaFinContrato(rs.getDate("fecha_fin_contrato"));

                mantenimiento.setnombreProp(rs.getString("nombre_propietario"));
                mantenimiento.setCostoHora(rs.getFloat("costo_hora"));
                mantenimiento.setFechaFinPaseo(rs.getDate("fecha_fin_paseo"));
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
                int id_embarcacion = rs.getInt("id_embarcacion");
                String nombre = rs.getString("nombre");
                String modelo = rs.getString("modelo");
                float longitud = rs.getFloat("longitud");
                int anio = rs.getInt("anio");

                mantenimiento = new Mantenimiento(id_embarcacion, nombre, modelo, longitud, anio);
                mantenimiento.setnombreProp(rs.getString("nombre_propietario"));
                mantenimiento.setFechaFinContrato(rs.getDate("fecha_fin_contrato"));
                mantenimiento.setCostoHora(rs.getFloat("costo_hora"));

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
        ps.setString(1, mantenimiento.getNombre());
        ps.setString(2, mantenimiento.getModelo());
        ps.setFloat(3, mantenimiento.getLongitud());
        ps.setInt(4, mantenimiento.getAnio());
        if (mantenimiento.getIdEmbarcacion() != 0)
            // Si el ID del mantenimiento es diferente de cero, se trata de una actualización
            ps.setInt(5, mantenimiento.getIdEmbarcacion());
        else
            ps.setInt(5, mantenimiento.getIdPropietario());
        return ps.executeUpdate();
    }

    public void insert(Mantenimiento mantenimiento) {
        String insertSQL = "INSERT INTO mantenimientos (nombre, modelo, longitud, anio, id_propietario) " +
                "VALUES (?, ?, ?, ?, ?)";
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
        String updateSQL = "UPDATE mantenimientos SET nombre = ?, modelo = ?, longitud = ?, anio = ?" +
                " WHERE id_embarcacion = ?";
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
        String deleteSQL = "DELETE FROM mantenimientos WHERE id_embarcacion=?";
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
    public Date obtenerFechaFinPaseo(int idEmbarcacion) {
        Date fechaFinPaseo = null;
        try (Connection con = Conexion.getConnection()) {
            String query = "SELECT fecha_fin FROM Paseos WHERE id_embarcacion = ? ORDER BY fecha_fin DESC LIMIT 1";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idEmbarcacion);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                fechaFinPaseo = rs.getDate("fecha_fin");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return fechaFinPaseo;
    }
}*/