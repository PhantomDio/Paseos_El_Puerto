package datos;

import java.sql.*;

public class Conexion {
    private static String user = "postgres";
    private static String pswd = "123";
    private static String bd = "Paseos_El_Puerto";
    private static String server = "jdbc:postgresql://localhost:5432/" + bd;
    private static String driver = "org.postgresql.Driver";

    public static Connection getConnection() {
        Connection con = null; // inicializar la variable como nula
        try {
            Class.forName(driver);
            System.out.println("conexion establecida");
            con = DriverManager.getConnection(server, user, pswd);
        } catch (SQLException ex) {
            System.out.println("Error al intentar conectarse a la BD" + server);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return con; // devolver la conexión, ya sea nula o establecida correctamente
    }

    public static void close(ResultSet result){
        try {
            result.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void close(Statement state){
        try {
            state.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void close(Connection con){
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
