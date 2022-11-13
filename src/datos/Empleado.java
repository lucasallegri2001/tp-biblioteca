package datos;

import negocios.ConexionDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

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
  public Empleado(int id, String nombre, String apellido, String dni, String usuario, String contraseña) {
    super(nombre, apellido, dni);
    this.id = id;
    this.usuario = usuario;
    this.contraseña = contraseña;
  }

  public Empleado() {}

  public static LinkedList<Empleado> listar() {
    String sql = "SELECT * FROM `empleado`";
    PreparedStatement stmt;
    LinkedList<Empleado> empleados = new LinkedList<>();
    String[] datos = new String[6];

    try {
      stmt = ConexionDB.getInstancia().getConnection().prepareStatement(sql);
      ResultSet result =  stmt.executeQuery();

      while(result.next()) {
        datos[0] = result.getString(1);
        datos[1] = result.getString(2);
        datos[2] = result.getString(3);
        datos[3] = result.getString(4);
        datos[4] = result.getString(5);
        datos[5] = result.getString(6);

        empleados.add(new Empleado(Integer.parseInt(datos[0]), datos[1], datos[2], datos[3], datos[4], datos[5]));
      }

      return empleados;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public boolean actualizar() {
    String sql = "UPDATE `empleado` SET `nombre`='?',`apellido`='?',`dni`='?',`usuario`='?',`contraseña`='?' WHERE id=?";
    PreparedStatement stmt;

    try {
      stmt = ConexionDB.getInstancia().getConnection().prepareStatement(sql);

      stmt.setString(1, this.getNombre());
      stmt.setString(2, this.getApellido());
      stmt.setString(3, this.getDni());
      stmt.setString(4, this.getUsuario());
      stmt.setString(5, this.getContraseña());
      stmt.setInt(6, this.getId());
      stmt.executeUpdate();
      stmt.close();

      return true;

    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }

  }

  public boolean guardar() {
    String sql ="INSERT INTO `empleado` (`nombre`, `apellido`, `dni`, `usuario`, `contraseña`) VALUES (?,?,?,?,?)";
    PreparedStatement stmt;

    try {
      stmt = ConexionDB.getInstancia().getConnection().prepareStatement(sql);

      stmt.setString(1, this.getNombre());
      stmt.setString(2, this.getApellido());
      stmt.setString(3, this.getDni());
      stmt.setString(4, this.getUsuario());
      stmt.setString(5, this.getContraseña());
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
