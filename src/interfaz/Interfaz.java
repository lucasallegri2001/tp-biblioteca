package interfaz;

import java.util.Scanner;

import datos.Alumno;d
import datos.Libro;
import datos.Socio;
import negocios.SectorVentas;

public class Interfaz {
	
		static Scanner entrada = new Scanner(System.in);
		static SectorVentas ventas = new SectorVentas();
		
		public void Login() {
			sobreCarga();
			System.out.println("Bienvenido al sistema de ventas de Biblioteca Jenny");
			imprimirMenu();
		}
		
		private void sobreCarga() {
			ventas.addSocio(new Socio("Raul", "Martinez", "23592929"));
			ventas.addLibro(new Libro(1, "Los Juegos del Hambre"));
			ventas.addLibro(new Libro(2, "El Señor de los Anillos"));
			ventas.addLibro(new Libro(3, "Juego de Tronos"));
			ventas.addLibro(new Libro(4, "1984"));
			ventas.addLibro(new Libro(5, "Bajo la Misma Estrella"));
		}
		
		private void imprimirMenu() {
			System.out.println("Por favor escoja una de las siguientes opciones");
			System.out.println("Para acceder a la opción escriba el numero que corresponda:");
			System.out.println("1 - Registrar venta");
			System.out.println("2 - Registrar socio");
			System.out.println("3 - Búsqueda");
			System.out.println("4 - Salir");
			
			int opcion = entrada.nextInt();
			switch (opcion) {
			case 1: registrarVenta(); break;
			case 2: registrarSocio(); break;
			case 3: buscar(); break;
			case 4: salir(); break;
			default:
				System.out.println("Se eligio una opción incorrecta. Vuelva a intentar");
				imprimirMenu();
			    break;
			}
		}
		
		
		private void menuAlter(Alumno alumno) {
			System.out.println("1.Borrar alumno ");
			System.out.println("2.Editar alumno");
			System.out.println("3.Menu principal");
			
			int opcion = entrada.nextInt();
			switch (opcion) {
			case 1: Borrar(alumno);
				break;
			case 2: Editar(alumno);
				break;
			case 3: imprimirMenu();
				break;
				default: System.out.println("Se eligio una opci�n incorrecta volver a intentar");
					break;
				}
		}
		private void Borrar(Alumno alumno) {
			System.out.println("Esta seguro de querer borrar a "+ alumno+ "?");
			System.out.println("si esta seguro presione 1");
			int aux = entrada.nextInt();
			if(aux ==1) {
				if(legajo.Borrar(alumno)) {
					System.out.println("se borro exitosamente");
				}
			}else {
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
			if(legajo.Editar(alumno)) {
				System.out.println("el alumno se pudo editar correctamente");
			}else {
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
			 if(legajo.add(alumno)== true) {
				 System.out.println("Se agrego correctamente el alumno");
			 }else {
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
			if(alumno.getDni() == "0" ) {
				System.out.println("el alumno no se encontro");
			}else {
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
		
		private void salir() {
			System.out.println("El programa finalizó.");
			System.exit(1);
		}
		

}
