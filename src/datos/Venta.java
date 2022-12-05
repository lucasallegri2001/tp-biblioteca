package datos;

import negocios.ConexionDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Venta {

  private int id = 0;
  private int idLibro = 0;
  private int cantidad = 0;
  private Date fecha;
  private double precio;

  public Venta(int id, int idLibro, int cantidad, Date fecha, double precio) {
    this.id = id;
    this.idLibro = idLibro;
    this.cantidad = cantidad;
    this.fecha = fecha;
    this.precio = precio;
  }

  public Venta(int idLibro, int cantidad, Date fecha, double precio) {
    this.id = id;
    this.idLibro = idLibro;
    this.cantidad = cantidad;
    this.fecha = fecha;
    this.precio = precio;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getIdLibro() {
    return idLibro;
  }

  public void setIdLibro(int idLibro) {
    this.idLibro = idLibro;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public static LinkedList<Venta> listar() {
    String sql = "SELECT * FROM `venta`";
    PreparedStatement stmt;
    LinkedList<Venta> ventas = new LinkedList<>();
    LinkedList<Object> datos = new LinkedList<>();

    try {
      stmt = ConexionDB.getInstancia().getConnection().prepareStatement(sql);
      ResultSet result = stmt.executeQuery();

      while(result.next()) {
        datos.add(result.getInt(1));
        datos.add(result.getInt(2));
        datos.add(result.getInt(3));
        datos.add(result.getDate(4));
        datos.add(result.getDouble(5));

        ventas.add(new Venta((int) datos.get(0), (int) datos.get(1), (int) datos.get(2), (java.sql.Date) datos.get(3), (double) datos.get(4)));
      }

      return ventas;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public boolean guardar() {
    String sql = "INSERT INTO `venta` (`id_libro`, `cantidad`, `fecha`, `precio`) VALUES (?,?,?,?)";
    PreparedStatement stmt;

    try {
      stmt = ConexionDB.getInstancia().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

      stmt.setInt(1, this.getIdLibro());
      stmt.setInt(2, this.getCantidad());
      stmt.setDate(3, new java.sql.Date(this.getFecha().getTime()));
      stmt.setDouble(4, this.getPrecio());
      int ejecutadas = stmt.executeUpdate();

      if (ejecutadas == 0) {
        System.out.println("Error al guardar venta");
      }

      try (ResultSet generadas = stmt.getGeneratedKeys()) {
        if (generadas.next()) {
          setId((int) generadas.getLong(1));
        }
        else {
          System.out.println("No se devolvio ninguna ID");
        }
      }

      stmt.close();

      return true;

    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

}
