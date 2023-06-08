package datos;

import model.Personal;

import java.sql.*;
import java.util.ArrayList;

public class PersonalDAO {

    public Personal select(int id) {
        String selectSQL = "SELECT * FROM personal WHERE id_personal=?";
        try {
            PreparedStatement statement = Conexion.getConnection().prepareStatement(selectSQL);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            Personal prop = new Personal();
            while (rs.next()) {

                prop.setIdPersonal(rs.getInt("id_personal"));
                prop.setNombre(rs.getString("nombre"));
                prop.setApellidoP(rs.getString("ap_pat"));
                prop.setApellidoM(rs.getString("ap_mat"));
                prop.setDireccion(rs.getString("direccion"));
                prop.setTelefono(rs.getString("telefono"));
                prop.setEmail(rs.getString("email"));;
                prop.setFecha_nac(rs.getDate("fecha_nac"));
                prop.setCostoHora(rs.getFloat("costo_hora"));
            }
            statement.close();
            rs.close();
            return prop;

        } catch (SQLException ex) {
            System.out.println("Error al seleccionar personal: " + ex.getMessage());
            return null;
        }
    }
    public ArrayList<Personal> selectAll(){
        Connection conn;
        Statement state;
        ResultSet rs;
        Personal personal;
        String selectSQL = "SELECT * FROM personal ORDER BY id_personal ASC";

        ArrayList<Personal> empleados = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            rs = state.executeQuery(selectSQL);

            while (rs.next()) {
                int id_personal = rs.getInt("id_personal");
                String nombre = rs.getString("nombre");
                String apellido_Pat = rs.getString("ap_pat");
                String apellido_Mat = rs.getString("ap_mat");
                String direccion = rs.getString("direccion")    ;
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                String fecha_nac = rs.getString("fecha_nac");
                float costo_hora = rs.getFloat("costo_hora");

                personal = new Personal(id_personal,nombre,apellido_Pat,apellido_Mat, direccion,telefono,email, costo_hora, fecha_nac);
                empleados.add(personal);

            }

            Conexion.close(rs);
            Conexion.close(state);
            Conexion.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return empleados;
    }
    private int INSERT_UPDATE(Personal personal, String query, Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, personal.getNombre());
        ps.setString(2, personal.getApellidoP());
        ps.setString(3, personal.getApellidoM());
        ps.setString(4, personal.getDireccion());
        ps.setString(5, personal.getTelefono());
        ps.setString(6, personal.getEmail());
        ps.setDate(7, personal.getFecha_nac());
        if (personal.getIdPersonal() != 0)
            // Si el ID del personal es diferente de cero, se trata de una actualización
            ps.setInt(8, personal.getIdPersonal());
        return ps.executeUpdate();
    }

    public void insert(Personal personal) {
        String insertSQL = "INSERT INTO personal (nombre, ap_pat, ap_mat, direccion, telefono, email, fecha_nac) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = Conexion.getConnection()) {
            int R = INSERT_UPDATE(personal, insertSQL, con);
            if (R > 0) {
                System.out.println("Registro agregado exitosamente.");
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo agregar el personal: " + ex.getMessage());
        }
    }

    public void update(Personal personal) {
        String updateSQL = "UPDATE personal SET nombre = ?, ap_pat = ?, ap_mat = ?, direccion = ?, telefono = ?, " +
                "email = ?, fecha_nac = ? WHERE id_personal = ?";
        try (Connection con = Conexion.getConnection()) {
            int R = INSERT_UPDATE(personal, updateSQL, con);
            if (R > 0) {
                System.out.println("Registro modificado exitosamente.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al modificar el personal: " + ex.getMessage());
        }
    }


    public void delete(int id) {
        String deleteSQL = "DELETE FROM personal WHERE id_personal=?";
        try {
            PreparedStatement statement = Conexion.getConnection().prepareStatement(deleteSQL);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
            System.out.println("Registro eliminado exitosamente.");
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el personal: " + ex.getMessage());
        }
    }
}
