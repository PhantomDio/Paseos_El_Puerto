package datos;

import model.Contratos;

import java.sql.*;
import java.util.ArrayList;

public class ContratosDAO {

    public Contratos select(int id) {
        String selectSQL = "SELECT * FROM contratos WHERE id_contrato=?";
        try {
            PreparedStatement statement = Conexion.getConnection().prepareStatement(selectSQL);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            Contratos contrato = new Contratos();
            while (rs.next()) {

                contrato.setIdContrato(rs.getInt("id_contrato"));
                contrato.setIdEmbarcacion(rs.getInt("id_embarcacion"));
                contrato.setFechaInicio(rs.getDate("fecha_inicio"));
                contrato.setFechaFin(rs.getDate("fecha_fin"));
                contrato.setCostoHora(rs.getFloat("costo_hora"));
            }
            statement.close();
            rs.close();
            return contrato;

        } catch (SQLException ex) {
            System.out.println("Error al seleccionar contrato: " + ex.getMessage());
            return null;
        }
    }
    public ArrayList<Contratos> selectAll(){
        Connection conn;
        Statement state;
        ResultSet rs;
        Contratos contrato;
        String selectSQL = "SELECT * FROM contratos ORDER BY id_contrato ASC";

        ArrayList<Contratos> contratos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            rs = state.executeQuery(selectSQL);

            while (rs.next()) {
                int id_contrato = rs.getInt("id_contrato");
                int id_embarcacion = rs.getInt("id_embarcacion");
                String fecha_inicio = rs.getString("fecha_inicio");
                String fecha_fin = rs.getString("fecha_fin");
                float costo_hora = rs.getInt("costo_hora");
                contrato = new Contratos(id_contrato,id_embarcacion,fecha_inicio,fecha_fin, costo_hora);
                contratos.add(contrato);

            }

            Conexion.close(rs);
            Conexion.close(state);
            Conexion.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return contratos;
    }

    public void insert(Contratos contrato) {
        String insertSQL = "INSERT INTO contratos (id_embarcacion, fecha_inicio, fecha_fin, costo_hora) " +
                "VALUES (?, ?, ?, ?)";
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement ps = con.prepareStatement(insertSQL);
            ps.setInt(1, contrato.getIdEmbarcacion());
            ps.setDate(2, contrato.getFechaInicio());
            ps.setDate(3, contrato.getFechaFin());
            ps.setFloat(4, contrato.getCostoHora());

            int registros = ps.executeUpdate();

            if(registros>0)
                System.out.println("Registro agregado exitosamente");

            Conexion.close(ps);
            Conexion.close(con);
        } catch (SQLException ex) {
            System.out.println("No se pudo agregar el contrato: " + ex.getMessage());
        }
    }

    public void update(Contratos contrato) {
        String updateSQL = "UPDATE contratos SET fecha_inicio = ?, fecha_fin = ?, costo_hora = ?" +
                " WHERE id_contrato = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(updateSQL)) {

            ps.setDate(1, contrato.getFechaInicio());
            ps.setDate(2, contrato.getFechaFin());
            ps.setFloat(3, contrato.getCostoHora());
            ps.setInt(4, contrato.getIdContrato());

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

    public void delete(int id) {
        String deleteSQL = "DELETE FROM contratos WHERE id_contrato=?";
        try {
            PreparedStatement statement = Conexion.getConnection().prepareStatement(deleteSQL);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
            System.out.println("Registro eliminado exitosamente.");
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el contrato: " + ex.getMessage());
        }
    }

    public int getIdUltimaEmbarcacion() {
        int idEmbarcacion = 0;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Obtener la conexión a la base de datos
            conn = Conexion.getConnection();

            // Crear la consulta SQL para obtener el último ID de embarcación registrado
            String sql = "SELECT id_embarcacion FROM embarcaciones ORDER BY id_embarcacion DESC LIMIT 1";

            // Crear el objeto Statement y ejecutar la consulta
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            // Obtener el último ID de embarcación
            if (rs.next()) {
                idEmbarcacion = rs.getInt("id_embarcacion");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar los recursos de base de datos
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return idEmbarcacion;
    }
}