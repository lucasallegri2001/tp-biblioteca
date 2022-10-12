package datos;

public class Libro {

  private int id;
  private String nombre;

  private int stock = 10;

  public Libro(int id, String nombre) {
    this.id = id;
    this.nombre = nombre;
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
