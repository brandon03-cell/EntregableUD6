package dao;

import modelo.Cliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {
    String url = "jdbc:sqlite:entregable.sqlite";

    public void insertarCliente(Cliente a) {
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "insert into Clientes (nombre, email, telefono, edad, " +
                    "dinero_gastado, productos_comprados) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getEmail());
            ps.setString(3, a.getTelefono());
            ps.setInt(4, a.getEdad());
            ps.setDouble(5, a.getDinero_gastado());
            ps.setInt(6, a.getProductos_comprados());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("bro, el error es: " + e.getMessage());
        }
    }
}
