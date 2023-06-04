package datos;

import model.Embarcaciones;

import java.sql.*;
import java.util.ArrayList;

public class EmbarcacionesDAO {

    public Embarcaciones select(int id) {
        String selectSQL = "SELECT e.id_embarcacion, e.nombre, e.modelo, e.longitud, e.anio, " +
                "CONCAT(p.nombre, ' ', p.ap_pat, ' ', p.ap_mat) AS nombre_propietario, c.fecha_fin AS fecha_fin_contrato, " +
                "c.costo_hora, ps.fecha_fin AS fecha_fin_paseo FROM embarcaciones e INNER JOIN propietarios p " +
                "ON e.id_propietario = p.id_propietario LEFT JOIN contratos c ON e.id_embarcacion = c.id_embarcacion " +
                "LEFT JOIN paseos ps ON e.id_embarcacion = ps.id_embarcacion WHERE e.id_embarcacion = ?";
        try {
            PreparedStatement statement = Conexion.getConnection().prepareStatement(selectSQL);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            Embarcaciones embar = new Embarcaciones();
            while (rs.next()) {
                embar.setIdEmbarcacion(rs.getInt("id_embarcacion"));
                embar.setNombre(rs.getString("nombre"));
                embar.setModelo(rs.getString("modelo"));
                embar.setLongitud(rs.getFloat("longitud"));
                embar.setAnio(rs.getInt("anio"));

                embar.setnombreProp(rs.getString("nombre_propietario"));
                embar.setFechaFinContrato(rs.getDate("fecha_fin_contrato"));
                embar.setCostoHora(rs.getFloat("costo_hora"));
                embar.setFechaFinPaseo(rs.getDate("fecha_fin_paseo"));
            }
            statement.close();
            rs.close();
            return embar;

        } catch (SQLException ex) {
            System.out.println("Error al seleccionar embarcacion: " + ex.getMessage());
            return null;
        }
    }
    public ArrayList<Embarcaciones> selectAll() {
        Connection conn;
        Statement state;
        ResultSet rs;
        Embarcaciones embarcacion;
        String selectSQL = "SELECT e.id_embarcacion, e.nombre, e.modelo, e.longitud, e.anio, " +
                "CONCAT(p.nombre, ' ', p.ap_pat, ' ', p.ap_mat) AS nombre_propietario, c.fecha_fin AS fecha_fin_contrato, " +
                "c.costo_hora, ps.fecha_fin AS fecha_fin_paseo FROM embarcaciones e INNER JOIN propietarios p " +
                "ON e.id_propietario = p.id_propietario LEFT JOIN contratos c ON e.id_embarcacion = c.id_embarcacion " +
                "LEFT JOIN paseos ps ON e.id_embarcacion = ps.id_embarcacion";

        ArrayList<Embarcaciones> embarcaciones = new ArrayList<>();
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

                embarcacion = new Embarcaciones(id_embarcacion, nombre, modelo, longitud, anio);
                embarcacion.setnombreProp(rs.getString("nombre_propietario"));
                embarcacion.setFechaFinContrato(rs.getDate("fecha_fin_contrato"));
                embarcacion.setCostoHora(rs.getFloat("costo_hora"));
                embarcacion.setFechaFinPaseo(rs.getDate("fecha_fin_paseo"));

                embarcaciones.add(embarcacion);
            }

            Conexion.close(rs);
            Conexion.close(state);
            Conexion.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return embarcaciones;
    }

    private int INSERT_UPDATE(Embarcaciones embarcacion, String query, Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, embarcacion.getNombre());
        ps.setString(2, embarcacion.getModelo());
        ps.setFloat(3, embarcacion.getLongitud());
        ps.setInt(4, embarcacion.getAnio());
        if (embarcacion.getIdEmbarcacion() != 0)
            // Si el ID del embarcacion es diferente de cero, se trata de una actualización
            ps.setInt(5, embarcacion.getIdEmbarcacion());
        else
            ps.setInt(5, embarcacion.getIdPropietario());
        return ps.executeUpdate();
    }

    public void insert(Embarcaciones embarcacion) {
        String insertSQL = "INSERT INTO embarcaciones (nombre, modelo, longitud, anio, id_propietario) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (Connection con = Conexion.getConnection()) {
            int R = INSERT_UPDATE(embarcacion, insertSQL, con);
            if (R > 0) {
                System.out.println("Registro agregado exitosamente.");
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo agregar el embarcacion: " + ex.getMessage());
        }
    }
    public void update(Embarcaciones embarcacion) {
        String updateSQL = "UPDATE embarcaciones SET nombre = ?, modelo = ?, longitud = ?, anio = ?" +
                " WHERE id_embarcacion = ?";
        try (Connection con = Conexion.getConnection()) {
            int R = INSERT_UPDATE(embarcacion, updateSQL, con);
            if (R > 0) {
                System.out.println("Registro modificado exitosamente.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al modificar el embarcacion: " + ex.getMessage());
        }
    }


    public void delete(int id) {
        String deleteSQL = "DELETE FROM embarcaciones WHERE id_embarcacion=?";
        try {
            PreparedStatement statement = Conexion.getConnection().prepareStatement(deleteSQL);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
            System.out.println("Registro eliminado exitosamente.");
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el embarcacion: " + ex.getMessage());
        }
    }
}