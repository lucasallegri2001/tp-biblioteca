package negocios;

import datos.Libro;
import datos.Socio;
import interfaz.Interfaz;

import java.util.LinkedList;

public class SectorVentas {

  LinkedList<Socio> Socios = new LinkedList<Socio>();
  LinkedList<Libro> Libros = new LinkedList<Libro>();

  public static void main(String[] args) {
    Interfaz interfaz1 = new Interfaz();
    interfaz1.login();
  }

  public boolean addSocio(Socio socio) {
    // Se valida que el nombre tenga entre 3 y 60 caracteres como máximo.
    char[] caracteresNombre = socio.getNombre().toCharArray();
    if (caracteresNombre.length < 3 || caracteresNombre.length > 60) {
      return false;
    }

    // Se valida que el apellido tenga entre 3 y 60 caracteres como máximo.
    char[] caracteresApellido = socio.getApellido().toCharArray();
    if (caracteresApellido.length < 3 || caracteresApellido.length > 60) {
      return false;
    }

    // Se valida que el dni tenga entre 3 y 32 caracteres como máximo.
    char[] caracteresDni = socio.getDni().toCharArray();
    if(caracteresDni.length < 3 || caracteresDni.length > 32) {
      return false;
    }

    // Si ninguna de las condiciones excluyentes se cumplen, procedemos a registrar al socio en el sistema.
    Socios.add(socio);
    return true;
  }

  public boolean addLibro(Libro libro) {
    // TODO: Faltan realizar validaciones antes de agregar libros.
    Libros.add(libro);
    return true;
  }

  public boolean librosDisponibles() {
    int encontrados = 0;
    for(Libro libro : Libros) {
      if(libro.estaDisponible()) {
        System.out.println(libro);
        encontrados++;
      }
    }
    return encontrados != 0;
  }

  public boolean sociosRegistrados() {
    if(Socios.isEmpty()) return false;
    for(Socio socio : Socios) {
      System.out.println(socio);
    }
    return true;
  }

  public Socio buscarSocio(String dni) {
    for(Socio socio : Socios) {
      if(socio.getDni().equalsIgnoreCase(dni)) return socio;
    }
    return null;
  }

  public Libro buscarLibro(String nombre) {
    for(Libro libro : Libros) {
      if(libro.getNombre().contains(nombre)) return libro;
    }
    return null;
  }

  public LinkedList<Socio> buscarMultados() {
    LinkedList<Socio> multados = new LinkedList<Socio>();
    for(Socio socio : Socios) {
      if(socio.getNumeroMultas() < 1) continue;
      multados.add(socio);
    }
    return multados;
  }

  public void cambiarNivel(Socio socio, int nivel) {
    socio.setNivel(nivel);
  }

  public void agregarMulta(Socio socio) {
    socio.setNumeroMultas(socio.getNumeroMultas()+1);
  }

  public void borrarSocio(Socio socio) {
    Socios.remove(socio);
  }

  public void reponerStock(Libro libro, int cant) {
    libro.reponer(cant);
  }

  public void renombrarLibro(Libro libro, String nombre) {
    libro.setNombre(nombre);
  }

  /* Código de referencia - Software Estudiantil

  public Alumno buscar(String dni) {
    Alumno alumno = new Alumno();
    for (int i = 0; i < Estudiante.size(); i++) {
      System.out.println(Estudiante.get(i));
      alumno=Estudiante.get(i);
      //System.out.println(alumno.getDni());
      //System.out.println("Dni ");
      //System.out.println(dni);
      String aux = alumno.getDni();

      if(aux.equals(dni)) {
        //System.out.println("Lo encontr�");
        return alumno ;
      }
    }
    String aux = "0";
    alumno.setDni(aux);
    //System.out.println("no encontre");
    return alumno ;
  }

  public boolean Borrar(Alumno alumno) {

    if(Estudiante.remove(alumno)) {
      return true;
    }else {
      return false;
    }
  }
  public boolean Editar(Alumno alumno){
    int index = IndexAlumno(alumno);
    Estudiante.set(index, alumno);
    return true;
  }

  public int IndexAlumno(Alumno alumno){
    Alumno aux2 = new Alumno();
    for (int i = 0; i < Estudiante.size(); i++) {
      System.out.println(Estudiante.get(i));
      aux2=Estudiante.get(i);
      String aux = aux2.getDni();
      if(aux.equals(alumno.getDni())) {
        return i ;
      }
    }
    return 0;

  }

  public LinkedList<Alumno> getUsuarios() {
    return Estudiante;
  }

  public void setUsuarios(LinkedList<Alumno> usuarios) {
    Estudiante = usuarios;
  }

  @Override
  public String toString() {
    return "Listado [Estudiantes=" + Estudiante + "]";
  }

  */

}
