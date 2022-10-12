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
    interfaz1.Login();
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

}
