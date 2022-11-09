package datos;

import negocios.ConexionDB;

import java.sql.PreparedStatement;

public class Promocion {

  private int id;
  private String nombre_promocion;
  private double precio;

  public Promocion(int id, String nombre_promocion, double precio) {
    this.id = id;
    this.nombre_promocion = nombre_promocion;
    this.precio = precio;
  }

  public Promocion() {}

  public boolean agregar() {
    String sql = "INSERT INTO `promocion` (`nombre_promocion`, `precio`) VALUES (?,?)";
    PreparedStatement stmt;

    try {
      stmt = ConexionDB.getInstancia().getConnection().prepareStatement(sql);

      stmt.setString(1, this.getNombre_promocion());
      stmt.setDouble(2, this.getPrecio());
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

  public String getNombre_promocion() {
    return nombre_promocion;
  }

  public void setNombre_promocion(String nombre_promocion) {
    this.nombre_promocion = nombre_promocion;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  @Override
  public String toString() {
    return "Promocion [id=" + id + ", nombre_promocion=" + nombre_promocion + ", precio=" + precio + "]";
  }

}
