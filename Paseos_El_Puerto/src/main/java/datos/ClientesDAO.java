package datos;

import model.Clientes;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientesDAO {

    public Clientes select(int id) {
        String selectSQL = "SELECT * FROM clientes WHERE id_cliente=?";
        try {
            PreparedStatement statement = Conexion.getConnection().prepareStatement(selectSQL);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            Clientes cli = new Clientes();
            while (rs.next()) {

                cli.setIdCliente(rs.getInt("id_cliente"));
                cli.setNombre(rs.getString("nombre"));
                cli.setApellidoP(rs.getString("ap_pat"));
                cli.setApellidoM(rs.getString("ap_mat"));
                cli.setDireccion(rs.getString("direccion"));
                cli.setTelefono(rs.getString("telefono"));
                cli.setEmail(rs.getString("email"));;
            }
            statement.close();
            rs.close();
            return cli;

        } catch (SQLException ex) {
            System.out.println("Error al seleccionar alumno: " + ex.getMessage());
            return null;
        }
    }
    public List<Clientes> selectAll(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
        Clientes client = null;
        String selectSQL = "SELECT * FROM clientes";

        List<Clientes> clientes = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectSQL);

            while (result.next()) {
                int id_cliente = result.getInt("id_cliente");
                String nombre = result.getString("nombre");
                String apellido_Pat = result.getString("ap_pat");
                String apellido_Mat = result.getString("ap_mat");
                String direccion = result.getString("direccion");
                String telefono = result.getString("telefono");
                String email = result.getString("email");
                String fecha_nac = result.getString("fecha_nac");

                client = new Clientes(id_cliente,nombre,apellido_Pat,apellido_Mat, direccion,telefono,email, fecha_nac);
                clientes.add(client);

            }

            Conexion.close(result);
            Conexion.close(state);
            Conexion.close(conn);

            for(Clientes cliente: clientes) {
                System.out.println("ID_cliente: " + cliente.getIdCliente());
                System.out.println("Nombre: " + cliente.getNombre());
                System.out.println("Apellido Paterno: " + cliente.getApellidoP());
                System.out.println("Apellido Materno: " + cliente.getApellidoM());
                System.out.println("Direccion: " + cliente.getDireccion());
                System.out.println("Telefono: " + cliente.getTelefono());
                System.out.println("Email: " + cliente.getEmail());
                System.out.println("Fecha de nacimiento: " + cliente.getFecha_nac());
                System.out.println(" \n ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return clientes;
    }
    private int INSERT_UPDATE(Clientes cliente, String query, Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, cliente.getNombre());
        ps.setString(2, cliente.getApellidoP());
        ps.setString(3, cliente.getApellidoM());
        ps.setString(4, cliente.getDireccion());
        ps.setString(5, cliente.getTelefono());
        ps.setString(6, cliente.getEmail());
        ps.setDate(7, cliente.getFecha_nac());
        if (cliente.getIdCliente() != 0)
            // Si el ID del cliente es diferente de cero, se trata de una actualización
            ps.setInt(8, cliente.getIdCliente());
        return ps.executeUpdate();
    }

    public void insert(Clientes cliente) {
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

    public void update(Clientes cliente) {
        String updateSQL = "UPDATE clientes SET nombre = ?, ap_pat = ?, ap_mat = ?, direccion = ?, telefono = ?, " +
                "email = ?, fecha_nac = ? WHERE id_cliente = ?";
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
        String deleteSQL = "DELETE FROM clientes WHERE id_cliente=?";
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
