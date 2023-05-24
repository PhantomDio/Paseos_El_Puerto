package datos;

import model.Clientes;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//import java.util.StringTokenizer;

public class ClientesDAO {
    public static final String selectSQL = "SELECT * FROM clientes";
    public static final String deleteSQL = "DELETE FROM clientes WHERE id_cliente = ? ";


    public List<Clientes> seleccionar(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
        Clientes client = null;

        List<Clientes> clientes = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectSQL);

            while (result.next()) {
                int id_cliente = result.getInt("id_cliente");
                String nombre = result.getString("nombre");
                String apellido_Pat = result.getString("apellido_Pat");
                String apellido_Mat = result.getString("apellido_Mat");
                String direccion = result.getString("direccion");
                String telefono = result.getString("telefono");
                String email = result.getString("email");

                client = new Clientes(id_cliente,nombre,apellido_Pat,apellido_Mat, direccion,telefono,email);
                clientes.add(client);

            }

            Conexion.close(result);
            Conexion.close(state);
            Conexion.close(conn);

            for(Clientes cliente: clientes) {
                System.out.println("ID_cliente: " + cliente.getIdCliente());
                System.out.println("Nombre: " + cliente.getNombre());
                System.out.println("Apellido_Pat: " + cliente.getApellido_Pat());
                System.out.println("Apellido_Mat: " + cliente.getApellido_Mat());
                System.out.println("Direccion: " + cliente.getDireccion());
                System.out.println("Telefono: " + cliente.getTelefono());
                System.out.println("Email: " + cliente.getEmail());
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
            ps.setString(indexAPELLP, cliente.getApellido_Pat());
            ps.setString(indexAPELLM, cliente.getApellido_Mat());
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

    public int borrar(Clientes cliente){

        Connection conn = null;
        PreparedStatement state = null;
        int registros=0;

        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(deleteSQL);

            state.setInt(1,cliente.getIdCliente());
            registros = state.executeUpdate();

            if(registros>0)
                System.out.println("Registro eliminado");


            Conexion.close(state);
            Conexion.close(conn);
            Clientes clienteDelete = new Clientes();

        }catch (Exception e) {
            e.printStackTrace();
        }

        return registros;
    }
}
