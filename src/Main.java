import dao.ClienteDAO;
import modelo.Cliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        insertarCliente();

        //String url = "jdbc:sqlite:entregable.sqlite";
        //try (Connection conn = DriverManager.getConnection(url)) {
        //    System.out.println("gg");
        //} catch (SQLException e) {
        //    System.out.println("nuh uh");
        //}
    }

    public static void insertarCliente() {
        Cliente c = new Cliente("julian", "danielpavon@hotmail.com", "676767676", 4,
                9999.99, 1);
        ClienteDAO cdao = new ClienteDAO();
        cdao.insertarCliente(c);
    }
}