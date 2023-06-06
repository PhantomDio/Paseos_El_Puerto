package datos;

import model.Propietarios;
import java.sql.*;
import java.util.ArrayList;

public class PropietariosDAO {

    public Propietarios select(int id) {
        String selectSQL = "SELECT * FROM propietarios WHERE id_propietario=?";
        try {
            PreparedStatement statement = Conexion.getConnection().prepareStatement(selectSQL);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            Propietarios prop = new Propietarios();
            while (rs.next()) {

                prop.setIdPropietario(rs.getInt("id_propietario"));
                prop.setNombre(rs.getString("nombre"));
                prop.setApellidoP(rs.getString("ap_pat"));
                prop.setApellidoM(rs.getString("ap_mat"));
                prop.setDireccion(rs.getString("direccion"));
                prop.setTelefono(rs.getString("telefono"));
                prop.setEmail(rs.getString("email"));;
                prop.setFecha_nac(rs.getDate("fecha_nac"));
            }
            statement.close();
            rs.close();
            return prop;

        } catch (SQLException ex) {
            System.out.println("Error al seleccionar propietario: " + ex.getMessage());
            return null;
        }
    }
    public ArrayList<Propietarios> selectAll(){
        Connection conn;
        Statement state;
        ResultSet rs;
        Propietarios propietario;
        String selectSQL = "SELECT * FROM propietarios ORDER BY id_propietario ASC";

        ArrayList<Propietarios> propietarios = new ArrayList<>();
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

                propietario = new Propietarios(id_propietario,nombre,apellido_Pat,apellido_Mat, direccion,telefono,email, fecha_nac);
                propietarios.add(propietario);

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