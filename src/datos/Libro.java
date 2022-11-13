package datos;

import negocios.ConexionDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class Libro {

  private int id;
  private String nombre;
  private int stock;

  public Libro(String nombre, int stock) {
    this.nombre = nombre;
    this.stock = stock;
  }

  public Libro(int id, String nombre, int stock) {
    this.id = id;
    this.nombre = nombre;
    this.stock = stock;
  }

  public static LinkedList<Libro> listar() {
    String sql = "SELECT * FROM `libro`";
    PreparedStatement stmt;
    LinkedList<Libro> libros = new LinkedList<>();
    String[] datos = new String[3];

    try {
      stmt = ConexionDB.getInstancia().getConnection().prepareStatement(sql);
      ResultSet result = stmt.executeQuery();

      while(result.next()) {
        datos[0] = result.getString(1);
        datos[1] = result.getString(2);
        datos[2] = result.getString(3);

        libros.add(new Libro(Integer.parseInt(datos[0]), datos[1], Integer.parseInt(datos[2])));
      }

      return libros;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public boolean actualizar() {
    String sql = "UPDATE `libro` SET `nombre`='?',`stock`='?' WHERE id=?";
    PreparedStatement stmt;

    try {
      stmt = ConexionDB.getInstancia().getConnection().prepareStatement(sql);

      stmt.setString(1, this.getNombre());
      stmt.setInt(2, this.getStock());
      stmt.setInt(3, this.getId());
      stmt.executeUpdate();
      stmt.close();

      return true;

    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }

  }

  public boolean guardar() {
    String sql = "INSERT INTO `libro` (`nombre`, `stock`) VALUES (?,?)";
    PreparedStatement stmt;

    try {
      stmt = ConexionDB.getInstancia().getConnection().prepareStatement(sql);

      stmt.setString(1, this.getNombre());
      stmt.setInt(2, this.getStock());
      stmt.executeUpdate();
      stmt.close();

      return true;

    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  public void ventaRealizada() {
    this.stock -= 1;
  }

  public void reponer(int cant) {
    this.stock += cant;
  }

  public boolean estaDisponible() {
    return this.stock >= 1;
  }

  @Override
  public String toString() {
    return "Libro{" +
            "id=" + id +
            ", nombre='" + nombre + '\'' +
            ", stock=" + stock +
            '}';
  }
}
