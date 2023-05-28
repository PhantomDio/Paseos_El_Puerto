/*package datos;

import model.Propietarios;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PropietariosDAO {

    public void select(int id) {
        String selectSQL = "SELECT * FROM propietarios WHERE id_propietario=?";
        try {
            PreparedStatement statement = Conexion.getConnection().prepareStatement(selectSQL);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_propietario"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Apellido paterno: " + rs.getString("ap_pat"));
                System.out.println("Apellido materno: " + rs.getString("ap_mat"));
                System.out.println("Edad: " + rs.getInt("edad"));
                System.out.println("Fecha de nacimiento: " + rs.getDate("f_nac"));
                System.out.println("Celular: " + rs.getString("cel"));
                System.out.println("Teléfono: " + rs.getString("tel"));
                System.out.println("Correo electrónico: " + rs.getString("email"));
                System.out.println("Dirección: " + rs.getString("direccion"));

            } else {
                System.out.println("No se encontró ningún alumno con el ID " + id);
            }
            statement.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error al seleccionar alumno: " + ex.getMessage());
        }
    }
    public List<Propietarios> selectAll(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
        Propietarios client = null;
        String selectSQL = "SELECT * FROM propietarios";

        List<Propietarios> propietarios = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectSQL);

            while (result.next()) {
                int id_propietario = result.getInt("id_propietario");
                String nombre = result.getString("nombre");
                String apellido_Pat = result.getString("ap_pat");
                String apellido_Mat = result.getString("ap_mat");
                String direccion = result.getString("direccion");
                String telefono = result.getString("telefono");
                String email = result.getString("email");
                String fecha_nac = result.getString("fecha_nac");

                client = new Propietarios(id_propietario,nombre,apellido_Pat,apellido_Mat, direccion,telefono,email, fecha_nac);
                propietarios.add(client);

            }

            Conexion.close(result);
            Conexion.close(state);
            Conexion.close(conn);

            for(Propietarios propietario: propietarios) {
                System.out.println("ID: " + propietario.getIdPropietario());
                System.out.println("Nombre: " + propietario.getNombre());
                System.out.println("Apellido Paterno: " + propietario.getApellidoP());
                System.out.println("Apellido Materno: " + propietario.getApellidoM());
                System.out.println("Direccion: " + propietario.getDireccion());
                System.out.println("Telefono: " + propietario.getTelefono());
                System.out.println("Email: " + propietario.getEmail());
                System.out.println("Fecha de nacimiento: " + propietario.getFecha_nac());
                System.out.println(" \n ");
            }

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
        if (propietario.getIdCliente() != 0)
            // Si el ID del propietario es diferente de cero, se trata de una actualización
            ps.setInt(8, propietario.getIdCliente());
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
            System.out.println("Error al eliminar el alumno: " + ex.getMessage());
        }
    }
}*/
