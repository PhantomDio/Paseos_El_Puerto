import datos.ClientesDAO;
import model.Clientes;

import java.sql.Date;


public class Main {
    public static void main(String[] args) {

        ClientesDAO clidao = new ClientesDAO();
        Clientes cli = new Clientes(7,"Day Jamil", "Salazar", "Medina", "Lucio Blanco 1", "2238734322", "daydjsm@gmail.com", "2004-08-25");
        clidao.update(cli);
    }
}
