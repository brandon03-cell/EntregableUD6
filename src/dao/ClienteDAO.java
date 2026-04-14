package dao;

import modelo.Cliente;

import java.sql.*;
import java.util.ArrayList;

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

    public void actualizarCliente(Cliente a, int id) {
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "update Clientes set nombre = ?, email = ?, telefono = ?, " +
                    "edad = ?, dinero_gastado = ?, productos_comprados = ? where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getEmail());
            ps.setString(3, a.getTelefono());
            ps.setInt(4, a.getEdad());
            ps.setDouble(5, a.getDinero_gastado());
            ps.setInt(6, a.getProductos_comprados());
            ps.setInt(7, id);
            ps.executeUpdate();
            System.out.println("No dudaba de mis habilidades como programador 🗿");
        } catch (SQLException e) {
            System.out.println("Si que dudaba de mis habilidades como programador, el error es: " + e.getMessage());
        }
    }

    public void eliminarCliente(int id) {
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "delete from Clientes where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("goodbye broder 🗿🥀");
        } catch (Exception e) {
            System.out.println("bruh: " + e.getMessage());
        }
    }

    public ArrayList<Cliente> obtenerCliente(int id) {
        ArrayList<Cliente> lista = new ArrayList<>();
        String sql = "select * from Clientes where id = ?";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                lista.add(new Cliente(
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("telefono"),
                        rs.getInt("edad"),
                        rs.getDouble("dinero_gastado"),
                        rs.getInt("productos_comprados")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public ArrayList<Cliente> obtenerTodos() {
        ArrayList<Cliente> lista = new ArrayList<>();
        String sql = "select * from Clientes";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Cliente(
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("telefono"),
                        rs.getInt("edad"),
                        rs.getDouble("dinero_gastado"),
                        rs.getInt("productos_comprados")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public ArrayList<Cliente> obtenerMayores30() {
        ArrayList<Cliente> lista = new ArrayList<>();
        String sql = "select * from Clientes where edad > 30";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Cliente(
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("telefono"),
                        rs.getInt("edad"),
                        rs.getDouble("dinero_gastado"),
                        rs.getInt("productos_comprados")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public ArrayList<Cliente> obtenerGastoMas500() {
        ArrayList<Cliente> lista = new ArrayList<>();
        String sql = "select * from Clientes where dinero_gastado > 500";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Cliente(
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("telefono"),
                        rs.getInt("edad"),
                        rs.getDouble("dinero_gastado"),
                        rs.getInt("productos_comprados")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public ArrayList<Cliente> obtenerOrdenadosPorGasto() {
        ArrayList<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM Clientes ORDER BY dinero_gastado DESC";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Cliente(rs.getString("nombre"), rs.getString("email"), rs.getString("telefono"), rs.getInt("edad"), rs.getDouble("dinero_gastado"), rs.getInt("productos_comprados")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public ArrayList<Cliente> obtenerTop3Compradores() {
        ArrayList<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM Clientes ORDER BY productos_comprados DESC LIMIT 3";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Cliente(rs.getString("nombre"), rs.getString("email"), rs.getString("telefono"), rs.getInt("edad"), rs.getDouble("dinero_gastado"), rs.getInt("productos_comprados")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public double obtenerSumaTotalGasto() {
        double total = 0;
        String sql = "SELECT SUM(dinero_gastado) FROM Clientes";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                total = rs.getDouble(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return total;
    }
}
