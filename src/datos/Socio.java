package datos;

public class Socio extends Persona {

  private int nivel = 1;
  private int numeroMultas = 0;

  public Socio() { super(); }

  public Socio(String nombre, String apellido, String dni) {
    super(nombre, apellido, dni);
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
    return "Socio{" +
        "nombre=" + super.getNombre() +
        ", apellido=" + super.getApellido() +
        ", dni=" + super.getDni() +
        ", nivel=" + nivel +
        ", numeroMultas=" + numeroMultas +
        "} ";
  }
}
