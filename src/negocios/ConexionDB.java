package negocios;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDB {

  private static ConexionDB instancia = null;
  Connection con;

  private ConexionDB() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca","root","");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public Connection getConnection() {
    return con;
  }

  public static ConexionDB getInstancia() {
    if (instancia == null) instancia = new ConexionDB();
    return instancia;
  }

}
