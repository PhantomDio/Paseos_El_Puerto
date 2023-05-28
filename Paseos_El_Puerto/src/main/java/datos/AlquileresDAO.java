package datos;

import model.Clientes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlquileresDAO {

    public void select(int id) {
        String selectSQL = "SELECT * FROM clientes WHERE id_cliente=?";
        try {
            PreparedStatement statement = Conexion.getConnection().prepareStatement(selectSQL);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_cliente"));
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
    private int INSERT_UPDATE(Clientes cliente, String query, int indexID, int indexNOMBRE, int indexAPELLP,
                              int indexAPELLM, int indexEDAD, int indexFECHAN, int indexCEL, int indexTEL, int indexEMAIL,
                              int indexDIRECC)
            throws SQLException {
        Connection con = Conexion.getConnection();
        if (con != null) { // asegurarse de que la conexión no sea nula
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(indexID, cliente.getIdCliente());
            ps.setString(indexNOMBRE, cliente.getNombre());
            ps.setString(indexAPELLP, cliente.getApellidoP());
            ps.setString(indexAPELLM, cliente.getApellidoM());
            ps.setString(indexEDAD, cliente.getDireccion());
            ps.setString(indexCEL, cliente.getTelefono());
            ps.setString(indexEMAIL, cliente.getEmail());
            ps.setString(indexDIRECC, cliente.getDireccion());
            ps.setString(indexTEL, cliente.getTelefono());
            ps.executeUpdate();
            Conexion.close(con);
            return 1;
        } else {
            System.out.println("La conexión a la BD no se ha establecido correctamente");
            return 0;
        }
    }

    public void insert(Clientes cliente) {
        String insertSQL = "INSERT INTO clientes (id_cliente, nombre, ap_pat, ap_mat, direccion, f_nac, cel, tel, email, direccion)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            int R = INSERT_UPDATE(cliente, insertSQL, 1, 2, 3, 4, 5, 6,
                    7, 8, 9, 10);
            if (R==1)
                System.out.println("Registro agregado exitosamente.");
        }
        catch(SQLException ex){
            System.out.println("No se pudo agregar el cliente: " + ex.getMessage());
        }
    }

    public void update(Clientes cliente) {
        String updateSQL = "UPDATE clientes SET nombre = ?, ap_pat = ?, ap_mat = ?, direccion = ?, telefono = ?, " +
                "email = ? WHERE id_cliente = ? ";
        try {
            int R = INSERT_UPDATE(cliente, updateSQL, 10, 1, 2, 3, 4, 5,
                    6, 7, 8, 9);
            if (R==1)
                System.out.println("Registro modificado exitosamente.");
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
