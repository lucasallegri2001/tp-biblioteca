package datos;

import negocios.ConexionDB;

import java.sql.PreparedStatement;

public class Libro {

  private int id;
  private String nombre;
  private int stock;

  public Libro(int id, String nombre, int stock) {
    this.id = id;
    this.nombre = nombre;
    this.stock = stock;
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
