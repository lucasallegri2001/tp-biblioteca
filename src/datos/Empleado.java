package datos;

public class Empleado extends Persona {

  private int id;
  private String usuario;
  private String contraseña;

  public Empleado(String nombre, String apellido, String dni) {
    super(nombre, apellido, dni);
  }

  public Empleado(String nombre, String apellido, String dni, String usuario, String contraseña) {
    super(nombre, apellido, dni);
    this.usuario = usuario;
    this.contraseña = contraseña;
  }

  public Empleado() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public String getContraseña() {
    return contraseña;
  }

  public void setContraseña(String contraseña) {
    this.contraseña = contraseña;
  }

  @Override
  public String toString() {
    return "Empleado{" +
        "id=" + id +
        '}';
  }
}
