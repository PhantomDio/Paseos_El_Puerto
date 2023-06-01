package datos;

import model.Propietarios;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PropietariosDAO {

    public Propietarios select(int id) {
        String selectSQL = "SELECT * FROM propietarios WHERE id_propietario=?";
        try {
            PreparedStatement statement = Conexion.getConnection().prepareStatement(selectSQL);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            Propietarios cli = new Propietarios();
            while (rs.next()) {

                cli.setIdPropietario(rs.getInt("id_propietario"));
                cli.setNombre(rs.getString("nombre"));
                cli.setApellidoP(rs.getString("ap_pat"));
                cli.setApellidoM(rs.getString("ap_mat"));
                cli.setDireccion(rs.getString("direccion"));
                cli.setTelefono(rs.getString("telefono"));
                cli.setEmail(rs.getString("email"));;
                cli.setFecha_nac(rs.getDate("fecha_nac"));
            }
            statement.close();
            rs.close();
            return cli;

        } catch (SQLException ex) {
            System.out.println("Error al seleccionar propietario: " + ex.getMessage());
            return null;
        }
    }
    public List<Propietarios> selectAll(){
        Connection conn = null;
        Statement state = null;
        ResultSet rs = null;
        Propietarios client = null;
        String selectSQL = "SELECT * FROM propietarios";

        List<Propietarios> propietarios = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            rs = state.executeQuery(selectSQL);

            while (rs.next()) {
                int id_propietario = rs.getInt("id_propietario");
                String nombre = rs.getString("nombre");
                String apellido_Pat = rs.getString("ap_pat");
                String apellido_Mat = rs.getString("ap_mat");
                String direccion = rs.getString("direccion")    ;
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                String fecha_nac = rs.getString("fecha_nac");

                client = new Propietarios(id_propietario,nombre,apellido_Pat,apellido_Mat, direccion,telefono,email, fecha_nac);
                propietarios.add(client);

            }

            Conexion.close(rs);
            Conexion.close(state);
            Conexion.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return propietarios;
    }
    private int INSERT_UPDATE(Propietarios propietario, String query, Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, propietario.getNombre());
        ps.setString(2, propietario.getApellidoP());
        ps.setString(3, propietario.getApellidoM());
        ps.setString(4, propietario.getDireccion());
        ps.setString(5, propietario.getTelefono());
        ps.setString(6, propietario.getEmail());
        ps.setDate(7, propietario.getFecha_nac());
        if (propietario.getIdPropietario() != 0)
            // Si el ID del propietario es diferente de cero, se trata de una actualización
            ps.setInt(8, propietario.getIdPropietario());
        return ps.executeUpdate();
    }

    public void insert(Propietarios propietario) {
        String insertSQL = "INSERT INTO propietarios (nombre, ap_pat, ap_mat, direccion, telefono, email, fecha_nac) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = Conexion.getConnection()) {
            int R = INSERT_UPDATE(propietario, insertSQL, con);
            if (R > 0) {
                System.out.println("Registro agregado exitosamente.");
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo agregar el propietario: " + ex.getMessage());
        }
    }

    public void update(Propietarios propietario) {
        String updateSQL = "UPDATE propietarios SET nombre = ?, ap_pat = ?, ap_mat = ?, direccion = ?, telefono = ?, " +
                "email = ?, fecha_nac = ? WHERE id_propietario = ?";
        try (Connection con = Conexion.getConnection()) {
            int R = INSERT_UPDATE(propietario, updateSQL, con);
            if (R > 0) {
                System.out.println("Registro modificado exitosamente.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al modificar el propietario: " + ex.getMessage());
        }
    }


    public void delete(int id) {
        String deleteSQL = "DELETE FROM propietarios WHERE id_propietario=?";
        try {
            PreparedStatement statement = Conexion.getConnection().prepareStatement(deleteSQL);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
            System.out.println("Registro eliminado exitosamente.");
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el propietario: " + ex.getMessage());
        }
    }
}