package negocios;

import datos.Empleado;
import datos.Libro;
import datos.Promocion;
import datos.Socio;
import interfaz.Interfaz;
import interfaz.InterfazLogin;
import interfaz.InterfazEmpleado;

import java.util.LinkedList;
import java.util.List;

public class SectorVentas {

  LinkedList<Socio> Socios = new LinkedList<Socio>();
  LinkedList<Libro> Libros = new LinkedList<Libro>();
  LinkedList<Empleado> Empleados = new LinkedList<Empleado>();
  ConexionDB baseDatos = ConexionDB.getInstancia();

  public static void main(String[] args) {
    Interfaz interfaz1 = new Interfaz();
    interfaz1.iniciar();
  }
  
  public void sobreCarga() {

    LinkedList<Libro> libros = Libro.listar();
    if(libros != null && !libros.isEmpty()) {
      for(Libro libro : libros) {
        addLibro(libro);
      }
    } else {
      new Libro("Los Juegos del Hambre", 10).guardar();
    }

    LinkedList<Empleado> empleados = Empleado.listar();
    if(empleados != null && !empleados.isEmpty()) {
      for(Empleado empleado : empleados) {
        addEmpleado(empleado);
      }
    } else {
      Empleado empleadoDefault = new Empleado("Gabriel", "Rodriguez", "233503939");
      empleadoDefault.setUsuario("usuario");
      empleadoDefault.setContraseña("contraseña");
      empleadoDefault.guardar();
    }

    LinkedList<Socio> socios = Socio.listar();
    if(socios != null && !socios.isEmpty()) {
      for(Socio socio : socios) {
        addSocio(socio);
      }
    } else {
      new Socio("Raul", "Martinez", "23592929").guardar();
    }

    //ventas.addSocio(new Socio("Raul", "Martinez", "23592929"));
    //ventas.addSocio(new Socio("Francisco", "Gomez", "33792999"));
    //ventas.addSocio(new Socio("Luis", "Gutierrez", "12345678"));
    //ventas.addSocio(new Socio("Juan", "Ramon", "12121212"));

    //ventas.addLibro(new Libro(1, "Los Juegos del Hambre", 10));
    //ventas.addLibro(new Libro(2, "El Señor de los Anillos", 10));
    //ventas.addLibro(new Libro(3, "Juego de Tronos", 10));
    //ventas.addLibro(new Libro(4, "1984", 10));
    //ventas.addLibro(new Libro(5, "Bajo la Misma Estrella", 10));

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

    // Si ninguna de las condiciones anteriores se cumplen procedemos a registrar al socio en el sistema.
    Socios.add(socio);
    return true;
  }

  public boolean guardarSocio(Socio socio) {
    // TODO: Faltan realizar validaciones antes de guardar socios.
    return socio.guardar();
  }

  public boolean addLibro(Libro libro) {
    // TODO: Faltan realizar validaciones antes de agregar libros.
    char[] dato = libro.getNombre().toCharArray();

    if(dato.length > 1 && dato.length < 100) {
      int stock = libro.getStock();

      if (stock >= 1) {
        return Libros.add(libro);
      }
    }
    return false;
  }

  public boolean guardarLibro(Libro libro) {
    // TODO: Faltan realizar validaciones antes de guardar libros.
    return libro.guardar();
  }

  public boolean addEmpleado(Empleado empleado) {
    // TODO: Faltan realizar validaciones antes de agregar empleados.
    Empleados.add(empleado);
    return true;
  }

  public boolean guardarEmpleado(Empleado empleado) {
    // TODO: Faltan realizar validaciones antes de guardar empleados.
    return empleado.guardar();
  }

  public boolean addPromocion(Promocion promocion) {
    char[] dato = promocion.getNombre_promocion().toCharArray();

    if(dato.length > 1 && dato.length < 2000) {
      double precio = promocion.getPrecio();
      if (precio>=1) {
        return promocion.agregar();
      }
    }
    return false;
  }
  
  public boolean login(String usuario, String contraseña) {
	Empleado empleado = buscarUsuario(usuario);

    if(empleado == null) return false;

    if(!validarLogin(empleado, contraseña)) return false;
    
    return true;
  }

  public Empleado buscarUsuario(String usuario) {
    for(Empleado empleado : Empleados) {
      if(empleado.getUsuario().equalsIgnoreCase(usuario)) return empleado;
    }
    return null;
  }

  public boolean validarLogin(Empleado empleado, String contraseña) {
    return empleado.getContraseña().equals(contraseña);
  }

  public LinkedList<Libro> librosDisponibles() {
    return Libros;
  }

  public LinkedList<Socio> sociosRegistrados() {
    return Socios;
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
    socio.actualizar();
  }

  public void agregarMulta(Socio socio) {
    socio.setNumeroMultas(socio.getNumeroMultas()+1);
    socio.actualizar();
  }

  public void borrarSocio(Socio socio) {
    Socios.remove(socio);
  }

  public void reponerStock(Libro libro, int cant) {
    libro.reponer(cant);
    libro.actualizar();
  }

  public void renombrarLibro(Libro libro, String nombre) {
    libro.setNombre(nombre);
    libro.actualizar();
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
