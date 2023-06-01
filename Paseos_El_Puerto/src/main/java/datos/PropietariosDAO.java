package datos;

import model.Propietarios;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PropietariosDAO {

    public Propietarios select(int id) {
        String selectSQL = "SELECT * FROM clientes WHERE id_propietaro=?";
        try {
            PreparedStatement statement = Conexion.getConnection().prepareStatement(selectSQL);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            Propietarios cli = new Propietarios();
            while (rs.next()) {

                cli.setIdPropietario(rs.getInt("id_propietaro"));
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
            System.out.println("Error al seleccionar alumno: " + ex.getMessage());
            return null;
        }
    }
    public List<Propietarios> selectAll(){
        Connection conn = null;
        Statement state = null;
        ResultSet rs = null;
        Propietarios client = null;
        String selectSQL = "SELECT * FROM clientes";

        List<Propietarios> clientes = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            rs = state.executeQuery(selectSQL);

            while (rs.next()) {
                int id_propietaro = rs.getInt("id_propietaro");
                String nombre = rs.getString("nombre");
                String apellido_Pat = rs.getString("ap_pat");
                String apellido_Mat = rs.getString("ap_mat");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                String fecha_nac = rs.getString("fecha_nac");

                client = new Propietarios(id_propietaro,nombre,apellido_Pat,apellido_Mat, direccion,telefono,email, fecha_nac);
                clientes.add(client);

            }

            Conexion.close(rs);
            Conexion.close(state);
            Conexion.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return clientes;
    }
    private int INSERT_UPDATE(Propietarios cliente, String query, Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, cliente.getNombre());
        ps.setString(2, cliente.getApellidoP());
        ps.setString(3, cliente.getApellidoM());
        ps.setString(4, cliente.getDireccion());
        ps.setString(5, cliente.getTelefono());
        ps.setString(6, cliente.getEmail());
        ps.setDate(7, cliente.getFecha_nac());
        if (cliente.getIdPropietario() != 0)
            // Si el ID del cliente es diferente de cero, se trata de una actualización
            ps.setInt(8, cliente.getIdPropietario());
        return ps.executeUpdate();
    }

    public void insert(Propietarios cliente) {
        String insertSQL = "INSERT INTO clientes (nombre, ap_pat, ap_mat, direccion, telefono, email, fecha_nac) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = Conexion.getConnection()) {
            int R = INSERT_UPDATE(cliente, insertSQL, con);
            if (R > 0) {
                System.out.println("Registro agregado exitosamente.");
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo agregar el cliente: " + ex.getMessage());
        }
    }

    public void update(Propietarios cliente) {
        String updateSQL = "UPDATE clientes SET nombre = ?, ap_pat = ?, ap_mat = ?, direccion = ?, telefono = ?, " +
                "email = ?, fecha_nac = ? WHERE id_propietaro = ?";
        try (Connection con = Conexion.getConnection()) {
            int R = INSERT_UPDATE(cliente, updateSQL, con);
            if (R > 0) {
                System.out.println("Registro modificado exitosamente.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al modificar el cliente: " + ex.getMessage());
        }
    }


    public void delete(int id) {
        String deleteSQL = "DELETE FROM clientes WHERE id_propietaro=?";
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
}