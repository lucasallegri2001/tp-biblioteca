package datos;

public class Empleado extends Persona {

  private int id;

  public Empleado(String nombre, String apellido, String dni) {
    super(nombre, apellido, dni);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Empleado{" +
        "id=" + id +
        '}';
  }
}
