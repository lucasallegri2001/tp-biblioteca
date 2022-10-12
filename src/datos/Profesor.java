package datos;

public class Profesor extends Persona {
	
	private int nrolegajo;

	public int getNrolegajo() {
		return nrolegajo;
	}

	public void setNrolegajo(int nrolegajo) {
		this.nrolegajo = nrolegajo;
	}
	
	public Profesor(String nombre, String apellido, int dni) {
		super(nombre, apellido, dni);
	}

	public Profesor() {
		super();
	}

}
