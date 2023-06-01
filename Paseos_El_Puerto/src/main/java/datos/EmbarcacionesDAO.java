package datos;

import model.Embarcaciones;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmbarcacionesDAO {

    public Embarcaciones select(int id) {
        String selectSQL = "SELECT * FROM embarcaciones WHERE id_embarcacion=?";
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
                embar.setIdPropietario(rs.getInt("id_propietario"));
            }
            statement.close();
            rs.close();
            return embar;

        } catch (SQLException ex) {
            System.out.println("Error al seleccionar embarcacion: " + ex.getMessage());
            return null;
        }
    }
    public List<Embarcaciones> selectAll(){
        Connection conn = null;
        Statement state = null;
        ResultSet rs = null;
        Embarcaciones embarcacion = null;
        String selectSQL = "SELECT * FROM embarcaciones";

        List<Embarcaciones> embarcaciones = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            rs = state.executeQuery(selectSQL);

            while (rs.next()) {
                int id_embarcacion = rs.getInt("id_embarcacion");
                String nombre = rs.getString("nombre");
                String modelo = rs.getString("modelo");
                float longitud = rs.getFloat("longitud");
                int anio = rs.getInt("anio")    ;
                int id_propietario = rs.getInt("id_propietario");
                embarcacion = new Embarcaciones(id_embarcacion,nombre,modelo,longitud, anio, id_propietario);
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
        ps.setInt(5, embarcacion.getIdPropietario());
        if (embarcacion.getIdEmbarcacion() != 0)
            // Si el ID del embarcacion es diferente de cero, se trata de una actualización
            ps.setInt(6, embarcacion.getIdEmbarcacion());
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
        String updateSQL = "UPDATE embarcaciones SET nombre = ?, modelo = ?, longitud = ?, anio = ?, id_propietario = ?, " +
                "WHERE id_embarcacion = ?";
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