package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ProductoDAO {

    public void ingresarProducto() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese nombre del producto: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese precio del producto: ");
        double precio = sc.nextDouble();
        System.out.print("Ingrese cantidad del producto: ");
        int cantidad = sc.nextInt();

        String sql = "INSERT INTO productos (nombre, precio, cantidad) VALUES (?, ?, ?)";
        
        try (Connection conn = Conexion.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, nombre);
            stmt.setDouble(2, precio);
            stmt.setInt(3, cantidad);
            stmt.executeUpdate();
            
            System.out.println("Producto ingresado correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mostrarProductos() {
        String sql = "SELECT * FROM productos";
        
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
             
            System.out.println("ID\tNombre\tPrecio\tCantidad");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" + rs.getString("nombre") + "\t" +
                                   rs.getDouble("precio") + "\t" + rs.getInt("cantidad"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void buscarProducto() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del producto a buscar: ");
        String nombre = sc.nextLine();

        String sql = "SELECT * FROM productos WHERE nombre LIKE ?";
        
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, "%" + nombre + "%");
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                System.out.println("Producto encontrado:");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Precio: " + rs.getDouble("precio"));
                System.out.println("Cantidad: " + rs.getInt("cantidad"));
            } else {
                System.out.println("Producto no encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modificarProducto() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el ID del producto a modificar: ");
        int id = sc.nextInt();
        sc.nextLine();  // Consumir la nueva línea
        System.out.print("Ingrese nuevo nombre del producto: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese nuevo precio del producto: ");
        double precio = sc.nextDouble();
        System.out.print("Ingrese nueva cantidad del producto: ");
        int cantidad = sc.nextInt();

        String sql = "UPDATE productos SET nombre = ?, precio = ?, cantidad = ? WHERE id = ?";
        
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, nombre);
            stmt.setDouble(2, precio);
            stmt.setInt(3, cantidad);
            stmt.setInt(4, id);
            stmt.executeUpdate();
            
            System.out.println("Producto modificado correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarProducto() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el ID del producto a eliminar: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM productos WHERE id = ?";
        
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, id);
            stmt.executeUpdate();
            
            System.out.println("Producto eliminado correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
