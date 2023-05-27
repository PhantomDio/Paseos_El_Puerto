import datos.ClientesDAO;
import model.Clientes;


public class Main {
    public static void main(String[] args) {

        ClientesDAO clidao = new ClientesDAO();
        clidao.selectAll();
    }
}
