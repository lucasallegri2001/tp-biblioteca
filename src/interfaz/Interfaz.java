package interfaz;

import datos.Empleado;
import datos.Libro;
import datos.Socio;
import negocios.SectorVentas;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Interfaz {

  static Scanner entrada = new Scanner(System.in);
  public static SectorVentas ventas = new SectorVentas();
  
  public void iniciar() {
	ventas.sobreCarga();
	InterfazLogin.main(null);
  }

  public void login() {
    System.out.println("Bienvenido al sistema de ventas de Biblioteca Jenny");
    System.out.println("Ingrese su nombre de usuario:");
    String usuario = entrada.next();
    Empleado empleado = ventas.buscarUsuario(usuario);

    if(empleado == null) {
      System.out.println("No se encontró ese usuario.");
      login();
    }

    System.out.println("Ingrese la contraseña de su usuario:");
    String contraseña = entrada.next();
    if(!ventas.validarLogin(empleado, contraseña)) {
      System.out.println("Contraseña inválida.");
      login();
    }

    System.out.println("Bienvenido " + empleado.getNombre());
    imprimirMenu();
  }

  private void imprimirMenu() {
    System.out.println("Por favor escoja una de las siguientes opciones");
    System.out.println("Para acceder a la opción escriba el numero que corresponda:");
    System.out.println("1 - Registrar venta");
    System.out.println("2 - Registrar socio");
    System.out.println("3 - Registrar libro");
    System.out.println("4 - Búsqueda");
    System.out.println("5 - Salir");

    int opcion = entrada.nextInt();
    switch (opcion) {
      case 1:
        registrarVenta();
        break;
      case 2:
        registrarSocio();
        break;
      case 3:
        registrarLibro();
        break;
      case 4:
        menuBusqueda();
        break;
      case 5:
        salir();
        break;
      default:
        System.out.println("Se eligio una opción incorrecta. Vuelva a intentar");
        imprimirMenu();
        break;
    }
  }

  private void registrarVenta() {
    System.out.println("Sin implementar.");
    imprimirMenu();
  }

  private void registrarSocio() {
    System.out.println("Ingrese el nombre del socio:");
    String nombre = entrada.next();
    System.out.println("Ingrese el apellido del socio:");
    String apellido = entrada.next();
    System.out.println("Ingrese el dni del socio:");
    String dni = entrada.next();

    if(ventas.addSocio(new Socio(nombre, apellido, dni))) {
      System.out.println("Se registró al socio correctamente");
      pulsarParaContinuar();
      imprimirMenu();
    } else {
      System.out.println("Datos inválidos.");
      imprimirMenu();
    }
  }

  private void registrarLibro() {
    System.out.println("Ingrese el nombre del libro:");
    String nombre = entrada.next();

    if(ventas.addLibro(new Libro(200, nombre, 10))) {
      System.out.println("Se registró al libro correctamente");
      pulsarParaContinuar();
      imprimirMenu();
    } else {
      System.out.println("Datos inválidos.");
      imprimirMenu();
    }
  }

  private void salir() {
    System.out.println("El programa finalizó.");
    System.exit(1);
  }

  private void menuBusqueda() {
    System.out.println("BUSQUEDA - Por favor escoja una de las siguientes opciones:");
    System.out.println("1 - Buscar socio");
    System.out.println("2 - Buscar libro");
    System.out.println("3 - Buscar multados");
    System.out.println("4 - Ver libros disponibles");
    System.out.println("5 - Ver cant. de socios registrados");
    System.out.println("6 - Regresar al menú principal");

    int opcion = entrada.nextInt();
    switch (opcion) {
      case 1:
        buscarSocio();
        break;
      case 2:
        buscarLibro();
        break;
      case 3:
        buscarMultados();
        break;
      case 4:
        librosDisponibles();
        break;
      case 5:
        sociosRegistrados();
        break;
      case 6:
        imprimirMenu();
        break;
      default:
        System.out.println("Se eligio una opción incorrecta. Vuelva a intentar");
        menuBusqueda();
        break;
    }
  }

  private void buscarSocio() {
    System.out.println("Ingrese el DNI del socio a buscar:");
    String dni = entrada.next();
    Socio socio = ventas.buscarSocio(dni);
    if(socio == null) {
      System.out.println("No se encontró ningún socio con ese DNI.");
      pulsarParaContinuar();
      menuBusqueda();
    }
    System.out.println("Se encontró al siguiente socio:");
    System.out.println(socio);
    menuSocio(socio);
  }

  private void buscarLibro() {
    System.out.println("Ingrese parte del nombre o el nombre completo del libro a buscar:");
    String nombre = entrada.next();
    Libro libro = ventas.buscarLibro(nombre);
    if(libro == null) {
      System.out.println("No se encontró ningún libro con ese nombre.");
      pulsarParaContinuar();
      menuBusqueda();
    }
    System.out.println("Se encontró al siguiente libro:");
    System.out.println(libro);
    menuLibro(libro);
  }

  private void buscarMultados() {
    LinkedList<Socio> multados = ventas.buscarMultados();
    if(!multados.isEmpty()) {
      System.out.println("Hay " + multados.size() + " socios multados: ");
      for(Socio multado : multados) System.out.println(multado);
      pulsarParaContinuar();
      menuBusqueda();
    } else {
      System.out.println("No hay socios multados.");
      pulsarParaContinuar();
      menuBusqueda();
    }
  }

  private void librosDisponibles() {
    if(!ventas.librosDisponibles().isEmpty()) {
      pulsarParaContinuar();
      menuBusqueda();
    } else {
      System.out.println("No hay libros disponibles.");
      pulsarParaContinuar();
      menuBusqueda();
    }
  }

  private void sociosRegistrados() {
    if(!ventas.sociosRegistrados().isEmpty()) {
      pulsarParaContinuar();
      menuBusqueda();
    } else {
      System.out.println("No hay socios registrados.");
      pulsarParaContinuar();
      menuBusqueda();
    }
  }

  private void menuSocio(Socio socio) {
    System.out.println("SOCIO " + socio.getNombre() + " " + socio.getApellido() + " - ¿Qué desea hacer con el socio?");
    System.out.println("1 - Cambiar nivel");
    System.out.println("2 - Agregar multa");
    System.out.println("3 - Borrar");
    System.out.println("4 - Regresar al menú de búsqueda");

    int opcion = entrada.nextInt();
    switch (opcion) {
      case 1:
        cambiarNivel(socio);
        break;
      case 2:
        agregarMulta(socio);
        break;
      case 3:
        borrarSocio(socio);
        break;
      case 4:
        menuBusqueda();
        break;
      default:
        System.out.println("Se eligio una opción incorrecta. Vuelva a intentar");
        menuSocio(socio);
        break;
    }
  }

  private void cambiarNivel(Socio socio) {
    System.out.println("¿A qué nivel desea cambiar a este socio? El número debe estar comprendido entre 1 y 5 inclusive");
    String nivel = entrada.next();
    try {
      int aux = Integer.parseInt(nivel);
      if(aux > 0 && aux < 6) {
        ventas.cambiarNivel(socio, aux);
      } else {
        System.out.println("El número ingresado es menor que 1 o mayor a 5");
      }
    } catch (NumberFormatException e) {
      System.out.println("No se ingresó un número.");
      menuSocio(socio);
    }
    System.out.println("Se cambió el nivel del socio a: " + nivel);
    pulsarParaContinuar();
    menuSocio(socio);
  }

  private void agregarMulta(Socio socio) {
    ventas.agregarMulta(socio);
    System.out.println("Se multó al socio.");
    pulsarParaContinuar();
    menuSocio(socio);
  }

  private void borrarSocio(Socio socio) {
    System.out.println("Está seguro que desea borrar a este socio? Escriba 'si' para proceder, de lo contrario se volverá al menú");
    String rta = entrada.next();
    if(!rta.equalsIgnoreCase("si")) {
      menuSocio(socio);
    }
    ventas.borrarSocio(socio);
    System.out.println("Socio borrado.");
    pulsarParaContinuar();
    menuBusqueda();
  }

  private void menuLibro(Libro libro) {
    System.out.println("LIBRO " + libro.getNombre() + " - ¿Qué desea hacer con este libro?");
    System.out.println("1 - Renombrar libro");
    System.out.println("2 - Reponer stock");
    System.out.println("3 - Ver unidades vendidas (día)");
    System.out.println("4 - Regresar al menú de búsqueda");

    int opcion = entrada.nextInt();
    switch (opcion) {
      case 1:
        renombrarLibro(libro);
        break;
      case 2:
        reponerStock(libro);
        break;
      case 3:
        unidadesVendidas(libro);
        break;
      case 4:
        menuBusqueda();
        break;
      default:
        System.out.println("Se eligio una opción incorrecta. Vuelva a intentar");
        menuLibro(libro);
        break;
    }
  }

  private void renombrarLibro(Libro libro) {
    System.out.println("¿Qué nombre desea ponerle al libro?");
    String nuevoNombre = entrada.next();
    ventas.renombrarLibro(libro, nuevoNombre);
    System.out.println("Se renombró el libro a: " + nuevoNombre);
    pulsarParaContinuar();
    menuLibro(libro);
  }

  private void reponerStock(Libro libro) {
    System.out.println("¿Cuánto stock desea reponer a este libro? (Solo ingresar números)");
    String cant = entrada.next();
    try {
      int aux = Integer.parseInt(cant);
      ventas.reponerStock(libro, aux);
    } catch (NumberFormatException e) {
      System.out.println("No se ingresó un número.");
      menuLibro(libro);
    }
    System.out.println("El nuevo stock de este libro es: " + libro.getStock());
    pulsarParaContinuar();
    menuLibro(libro);
  }

  private void unidadesVendidas(Libro libro) {
    System.out.println("Sin implementar");
    pulsarParaContinuar();
    menuLibro(libro);
  }

  private void pulsarParaContinuar() {
    System.out.println("Pulse cualquier tecla para volver al menú.");
    try {
      System.in.read();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /* Código de referencia - Software Estudiantil

  private void menuAlter(Alumno alumno) {
    System.out.println("1.Borrar alumno ");
    System.out.println("2.Editar alumno");
    System.out.println("3.Menu principal");

    int opcion = entrada.nextInt();
    switch (opcion) {
      case 1:
        Borrar(alumno);
        break;
      case 2:
        Editar(alumno);
        break;
      case 3:
        imprimirMenu();
        break;
      default:
        System.out.println("Se eligio una opción incorrecta volver a intentar");
        break;
    }
  }

  private void Borrar(Alumno alumno) {
    System.out.println("Esta seguro de querer borrar a " + alumno + "?");
    System.out.println("si esta seguro presione 1");
    int aux = entrada.nextInt();
    if (aux == 1) {
      if (legajo.Borrar(alumno)) {
        System.out.println("se borro exitosamente");
      }
    } else {
      imprimirMenu();
    }
  }

  private void Editar(Alumno alumno) {
    System.out.println("Ingrese el nombre de alumno");
    System.out.println("Debe ser un nombre de minimo 3 letras y maximo 60");
    alumno.setNombre(entrada.next());
    System.out.println("Ingrese apellido");
    System.out.println("Debe ser un apellido de minimo 3 letras y maximo 60");
    alumno.setApellido(entrada.next());
    if (legajo.Editar(alumno)) {
      System.out.println("el alumno se pudo editar correctamente");
    } else {
      System.out.println("no se pudo editar el alumno");
    }

    imprimirMenu();
  }

  private void Ingresar() {
    System.out.println("Ingrese el nombre de alumno");
    System.out.println("Debe ser un nombre de minimo 3 letras y maximo 60");
    Alumno alumno = new Alumno();
    alumno.setNombre(entrada.next());
    System.out.println("Ingrese apellido");
    System.out.println("Debe ser un apellido de minimo 3 letras y maximo 60");
    alumno.setApellido(entrada.next());
    System.out.println("Ingrese el DNI: ");
    alumno.setDni(entrada.next());
    if (legajo.add(alumno))) {
      System.out.println("Se agrego correctamente el alumno");
    } else {
      System.out.println("no se pudo agregar correctamente");
      System.out.println("si deseas agregar nuevamente un contacto ");
      System.out.println("seleccionar opcion 1");
    }
    imprimirMenu();

  }

  private void buscar() {
    System.out.println("Ingrese dni de alumno a buscar");
    String dni = entrada.next();
    Alumno alumno = new Alumno();
    alumno = legajo.buscar(dni);
    if (alumno.getDni() == "0") {
      System.out.println("el alumno no se encontro");
    } else {
      System.out.println("El alumno es");
      System.out.println(alumno);
      menuAlter(alumno);
    }
    imprimirMenu();
  }

  private void verPerfiles() {
    System.out.println(legajo);
    imprimirMenu();
  }

  */

}
