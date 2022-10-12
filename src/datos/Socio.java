package datos;

public class Socio extends Persona {

  private int nivel;
  private int numeroMultas;

  public Socio(String nombre, String apellido, String dni) {
    super(nombre, apellido, dni);
    this.nivel = 0;
    this.numeroMultas = 0;
  }

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

  @Override
  public String toString() {
    return "datos.Socio{" +
        "nivel=" + nivel +
        ", numeroMultas=" + numeroMultas +
        '}';
  }
}
