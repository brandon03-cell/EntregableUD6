import dao.ClienteDAO;
import modelo.Cliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        //insertarCliente();
        //actualizarCliente();
        //eliminarCliente();
        obtenerCliente();

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

    public static void actualizarCliente() {
        Cliente c = new Cliente("Daniel Pavón", "julian@gmail.com", "123456789",
                67, 1.01, 10);
        ClienteDAO cdao = new ClienteDAO();
        cdao.actualizarCliente(c, 10);
    }

    public static void eliminarCliente() {
        ClienteDAO cdao = new ClienteDAO();
        cdao.eliminarCliente(1);
    }

    public static void obtenerCliente() {
        ClienteDAO cdao = new ClienteDAO();
        Cliente c = cdao.obtenerCliente(2);
        System.out.println(c);
    }
}