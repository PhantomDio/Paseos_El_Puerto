package datos;

import model.Paseos;

import java.sql.*;
import java.util.ArrayList;

public class PaseosDAO {

    public Paseos select(int id) {
        String selectSQL = "SELECT p.id_paseo, p.fecha_inicio AS fecha_inicio_paseo, p.fecha_fin AS fecha_fin_paseo," +
                " p.id_embarcacion, e.nombre AS nombre_embarcacion, e.id_propietario, CONCAT(pr.nombre, ' '," +
                " pr.ap_pat, ' ', pr.ap_mat) AS nombre_propietario, p.id_cliente, CONCAT(cl.nombre, ' ', cl.ap_pat," +
                " ' ', cl.ap_mat) AS nombre_cliente, c.costo_hora FROM Paseos p" +
                " INNER JOIN Embarcaciones e ON p.id_embarcacion = e.id_embarcacion INNER JOIN Contratos c ON" +
                " p.id_embarcacion = c.id_embarcacion INNER JOIN Propietarios pr ON e.id_propietario = pr.id_propietario" +
                " INNER JOIN Clientes cl ON p.id_cliente = cl.id_cliente WHERE p.id_paseo = ?";
        try {
            PreparedStatement statement = Conexion.getConnection().prepareStatement(selectSQL);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            Paseos paseo = new Paseos();
            while (rs.next()) {
                paseo.setIdPaseo(rs.getInt("id_paseo"));
                paseo.setFechaInicioPaseo(rs.getDate("fecha_inicio_paseo"));
                paseo.setFechaFinPaseo(rs.getDate("fecha_fin_paseo"));
                paseo.setIdEmbarcacion(rs.getInt("id_embarcacion"));
                paseo.setNombreEmbarcacion(rs.getString("nombre_embarcacion"));
                paseo.setIdCliente(rs.getInt("id_cliente"));
                paseo.setNombreCliente(rs.getString("nombre_cliente"));
                paseo.setIdPropietario(rs.getInt("id_propietario"));
                paseo.setNombreProp(rs.getString("nombre_propietario"));
                paseo.setCostoHora(rs.getFloat("costo_hora"));
            }
            statement.close();
            rs.close();
            return paseo;

        } catch (SQLException ex) {
            System.out.println("Error al seleccionar paseos: " + ex.getMessage());
            return null;
        }
    }
    public ArrayList<Paseos> selectAll() {
        Connection conn;
        Statement state;
        ResultSet rs;
        Paseos paseo;
        String selectSQL = "SELECT p.id_paseo, p.fecha_inicio AS fecha_inicio_paseo, p.fecha_fin AS fecha_fin_paseo," +
                " p.id_embarcacion, e.nombre AS nombre_embarcacion, e.id_propietario, CONCAT(pr.nombre, ' '," +
                " pr.ap_pat, ' ', pr.ap_mat) AS nombre_propietario, p.id_cliente, CONCAT(cl.nombre, ' ', cl.ap_pat," +
                " ' ', cl.ap_mat) AS nombre_cliente, c.fecha_fin AS fecha_fin_contrato, c.costo_hora, p.monto_total FROM Paseos p" +
                " INNER JOIN Embarcaciones e ON p.id_embarcacion = e.id_embarcacion INNER JOIN Contratos c ON" +
                " p.id_embarcacion = c.id_embarcacion INNER JOIN Propietarios pr ON e.id_propietario = pr.id_propietario" +
                " INNER JOIN Clientes cl ON p.id_cliente = cl.id_cliente ORDER BY p.id_paseo ASC";

        ArrayList<Paseos> paseos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            rs = state.executeQuery(selectSQL);

            while (rs.next()) {
                int id_paseo = rs.getInt("id_paseo");
                Date fecha_inicio_paseo = rs.getDate("fecha_inicio_paseo");
                Date fecha_fin_paseo = rs.getDate("fecha_fin_paseo");
                int id_embarcacion = rs.getInt("id_embarcacion");
                String nombre_embarcacion = rs.getString("nombre_embarcacion");
                int id_propietario = rs.getInt("id_propietario");
                String nombre_propietario = rs.getString("nombre_propietario");
                int id_cliente = rs.getInt("id_cliente");
                String nombre_cliente = rs.getString("nombre_cliente");
                float costo_hora = rs.getFloat("costo_hora");

                paseo = new Paseos(id_paseo, fecha_inicio_paseo, fecha_fin_paseo, id_embarcacion, nombre_embarcacion,
                        id_propietario, nombre_propietario, id_cliente, nombre_cliente, costo_hora);

                paseo.setMontoTotalBD(rs.getFloat("monto_total"));

                paseos.add(paseo);
            }

            Conexion.close(rs);
            Conexion.close(state);
            Conexion.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return paseos;
    }


    private int INSERT_UPDATE(Paseos paseos, String query, Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, paseos.getIdEmbarcacion());
        ps.setInt(2, paseos.getIdCliente());
        ps.setDate(3, paseos.getFechaInicioPaseo());
        ps.setDate(4, paseos.getFechaFinPaseo());
        if (paseos.getIdPaseo() != 0)
            // Si el ID del paseo es diferente de cero, se trata de una actualización
            ps.setInt(5, paseos.getIdPaseo());
        return ps.executeUpdate();
    }

    public void insert(Paseos paseos) {
        String insertSQL = "INSERT INTO paseos (id_embarcacion, id_cliente, fecha_inicio, fecha_fin) " +
                "VALUES (?, ?, ?, ?)";
        try (Connection con = Conexion.getConnection()) {
            int R = INSERT_UPDATE(paseos, insertSQL, con);
            if (R > 0) {
                System.out.println("Registro agregado exitosamente.");
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo agregar el paseos: " + ex.getMessage());
        }
    }
    public void update(Paseos paseos) {
        String updateSQL = "UPDATE paseos SET id_embarcacion = ?, id_cliente = ?, fecha_inicio = ?, fecha_fin = ?" +
                " WHERE id_paseo = ?";
        try (Connection con = Conexion.getConnection()) {
            int R = INSERT_UPDATE(paseos, updateSQL, con);
            if (R > 0) {
                System.out.println("Registro modificado exitosamente.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al modificar el paseo: " + ex.getMessage());
        }
    }


    public void delete(int id) {
        String deleteSQL = "DELETE FROM paseos WHERE id_paseo=?";
        try {
            PreparedStatement statement = Conexion.getConnection().prepareStatement(deleteSQL);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
            System.out.println("Registro eliminado exitosamente.");
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el paseo: " + ex.getMessage());
        }
    }
    public Paseos getUltimoPaseo() {
        String query = "SELECT p.fecha_inicio, p.fecha_fin, c.costo_hora FROM Paseos p"+
        " INNER JOIN Contratos c ON p.id_embarcacion = c.id_embarcacion ORDER BY p.id_paseo DESC LIMIT 1";

        try {
            PreparedStatement statement = Conexion.getConnection().prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                // Obtiene los valores de cada columna
                Date fechaInicio = rs.getDate("fecha_inicio");
                Date fechaFin = rs.getDate("fecha_fin");
                float costoHora = rs.getFloat("costo_hora");

                // Crea una instancia de Paseo y asigna los valores obtenidos
                Paseos ultimoPaseo = new Paseos();
                ultimoPaseo.setFechaInicioPaseo(fechaInicio);
                ultimoPaseo.setFechaFinPaseo(fechaFin);
                ultimoPaseo.setCostoHora(costoHora);

                return ultimoPaseo;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Si no se encuentra ningún paseo, devuelve null.
    }

    public void insertMontoT(float monto_total) {
        String updateSQL = "UPDATE paseos SET monto_total = ? WHERE id_paseo = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(updateSQL)) {
            Paseos_PersonalDAO ppDAO = new Paseos_PersonalDAO();
            ps.setFloat(1, monto_total);
            ps.setInt(2, ppDAO.getIdUltimoPaseo());

            int registros = ps.executeUpdate();

            if (registros > 0) {
                System.out.println("Se han modificado " + registros + " registros exitosamente.");
            } else {
                System.out.println("No se ha modificado ningún registro.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al modificar el contrato: " + ex.getMessage());
        }
    }
}