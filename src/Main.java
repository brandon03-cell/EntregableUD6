import dao.ClienteDAO;
import modelo.Cliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

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
        System.out.println(cdao.obtenerCliente(2));
    }

    public static void obtenerTodos() {
        ClienteDAO cdao = new ClienteDAO();
        System.out.println(cdao.obtenerTodos());
    }

    public static void obtenerMayores30() {
        ClienteDAO cdao = new ClienteDAO();
        System.out.println(cdao.obtenerMayores30());
    }

    public static void obtenerGastoMas500() {
        ClienteDAO cdao = new ClienteDAO();
        System.out.println(cdao.obtenerGastoMas500());
    }

    public static void obtenerOrdenadosPorGasto() {
        ClienteDAO cdao = new ClienteDAO();
        System.out.println(cdao.obtenerOrdenadosPorGasto());
    }

    public static void obtenerTop3Compradores() {
        ClienteDAO cdao = new ClienteDAO();
        System.out.println(cdao.obtenerTop3Compradores());
    }

    public static void obtenerSumaTotalGasto() {
        ClienteDAO cdao = new ClienteDAO();
        System.out.println(cdao.obtenerSumaTotalGasto());
    }

    public static void obtenerMediaProductos() {
        ClienteDAO cdao = new ClienteDAO();
        System.out.println(cdao.obtenerMediaProductos());
    }

    public static void obtenerMediaGastoFiltrado() {
        ClienteDAO cdao = new ClienteDAO();
        System.out.println(cdao.obtenerMediaGastoFiltrado());
    }

    public static void contadorGastoMas100() {
        ClienteDAO cdao = new ClienteDAO();
        System.out.println(cdao.contadorGastoMas100());
    }

    public static void contadorEdad30a50() {
        ClienteDAO cdao = new ClienteDAO();
        System.out.println(cdao.contadorEdad30a50());
    }

    public static void obtenerGasto200Ordenado() {
        ClienteDAO cdao = new ClienteDAO();
        System.out.println(cdao.obtenerGasto200Ordenado());
    }

    public static void obtenerMasJovenGasto400() {
        ClienteDAO cdao = new ClienteDAO();
        System.out.println(cdao.obtenerMasJovenGasto400());
    }
}