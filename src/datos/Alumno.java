package datos;

public class Alumno extends Persona {
	
	private int NroAlumno;

	public int getNroAlumno() {
		return NroAlumno;
	}

	public void setNroAlumno(int nroAlumno) {
		NroAlumno = nroAlumno;
	}
	
	public Alumno(String nombre, String apellido, int dni) {
		super(nombre, apellido, dni);
	}

	public Alumno(){
		super();
	}

}
