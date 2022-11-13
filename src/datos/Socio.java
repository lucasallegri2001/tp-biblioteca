package datos;

import negocios.ConexionDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class Socio extends Persona {

  private int id = 0;
  private int nivel = 1;
  private int numeroMultas = 0;

  public Socio(String nombre, String apellido, String dni) {
    super(nombre, apellido, dni);
  }

  public Socio(int id, String nombre, String apellido, String dni, int nivel, int numeroMultas) {
    super(nombre, apellido, dni);
    this.id = id;
    this.nivel = nivel;
    this.numeroMultas = numeroMultas;
  }

  public Socio() {}

  public int getNivel() {
    return nivel;
  }

  public void setNivel(int nivel) {
    this.nivel = nivel;
  }

  public int getNumeroMultas() {
    return numeroMultas;
  }

  public void setNumeroMultas(int numeroMultas) {
    this.numeroMultas = numeroMultas;
  }

  public static LinkedList<Socio> listar() {
    String sql = "SELECT * FROM `socio`";
    PreparedStatement stmt;
    LinkedList<Socio> socios = new LinkedList<>();
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

        socios.add(new Socio(Integer.parseInt(datos[0]), datos[1], datos[2], datos[3], Integer.parseInt(datos[4]), Integer.parseInt(datos[5])));
      }

      return socios;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public boolean actualizar() {
    String sql = "UPDATE `socio` SET `nombre`='?',`apellido`='?',`dni`='?',`nivel`='?',`numeroMultas`='?' WHERE id=?";
    PreparedStatement stmt;

    try {
      stmt = ConexionDB.getInstancia().getConnection().prepareStatement(sql);

      stmt.setString(1, this.getNombre());
      stmt.setString(2, this.getApellido());
      stmt.setString(3, this.getDni());
      stmt.setInt(4, this.getNivel());
      stmt.setInt(5, this.getNumeroMultas());
      stmt.setInt(6, this.id);
      stmt.executeUpdate();
      stmt.close();

      return true;

    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }

  }

  public boolean guardar() {
    String sql ="INSERT INTO `socio` (`nombre`, `apellido`, `dni`, `nivel`, `numeroMultas`) VALUES (?,?,?,?,?)";
    PreparedStatement stmt;

    try {
      stmt = ConexionDB.getInstancia().getConnection().prepareStatement(sql);

      stmt.setString(1, this.getNombre());
      stmt.setString(2, this.getApellido());
      stmt.setString(3, this.getDni());
      stmt.setInt(4, this.getNivel());
      stmt.setInt(5, this.getNumeroMultas());
      stmt.executeUpdate();
      stmt.close();

      return true;

    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public String toString() {
    return "Socio{" +
        "nombre=" + super.getNombre() +
        ", apellido=" + super.getApellido() +
        ", dni=" + super.getDni() +
        ", nivel=" + nivel +
        ", numeroMultas=" + numeroMultas +
        "} ";
  }
}
