package datos;

import model.Paseos_Personal;
import model.Personal;

import java.sql.*;
import java.util.ArrayList;

public class Paseos_PersonalDAO {

    public void insert(int id_personal) {
        String insertSQL = "INSERT INTO paseos_personal (id_paseo, id_personal) " +
                "VALUES (?, ?)";
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement ps = con.prepareStatement(insertSQL);
            ps.setInt(1, getIdUltimoPaseo());
            ps.setInt(2, id_personal);
            
            int registros = ps.executeUpdate();

            if(registros>0)
                System.out.println("Registro agregado exitosamente");

            Conexion.close(ps);
            Conexion.close(con);
        } catch (SQLException ex) {
            System.out.println("No se pudo agregar el PP: " + ex.getMessage());
        }
    }

    public void update(Paseos_Personal PP) {
        String updateSQL = "UPDATE paseos_personal SET id_paseo = ?, id_personal = ?" +
                " WHERE id_contrato = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(updateSQL)) {

            ps.setInt(1, PP.getIdPaseo());
            ps.setInt(2, PP.getIdPersonal());

            int registros = ps.executeUpdate();

            if (registros > 0) {
                System.out.println("Se han modificado " + registros + " registros exitosamente.");
            } else {
                System.out.println("No se ha modificado ningún registro.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al modificar el Paseo_Personal: " + ex.getMessage());
        }
    }


    public void delete(int id_paseo, int id_personal) {
        String deleteSQL = "DELETE FROM paseos_personal WHERE id_personal = ? AND id_paseo = ?;";
        try {
            PreparedStatement statement = Conexion.getConnection().prepareStatement(deleteSQL);
            statement.setInt(1, id_personal);
            statement.setInt(2, id_paseo);
            statement.executeUpdate();
            statement.close();
            System.out.println("Registro eliminado exitosamente.");
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el personal: " + ex.getMessage());
        }
    }

    public int getIdUltimoPaseo() {
        int idPaseo = 0;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Obtener la conexión a la base de datos
            conn = Conexion.getConnection();

            // Crear la consulta SQL para obtener el último ID de embarcación registrado
            String sql = "SELECT id_paseo FROM paseos ORDER BY id_paseo DESC LIMIT 1";

            // Crear el objeto Statement y ejecutar la consulta
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            // Obtener el último ID de Paseo
            if (rs.next()) {
                idPaseo = rs.getInt("id_paseo");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar los recursos de base de datos
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return idPaseo;
    }
}
