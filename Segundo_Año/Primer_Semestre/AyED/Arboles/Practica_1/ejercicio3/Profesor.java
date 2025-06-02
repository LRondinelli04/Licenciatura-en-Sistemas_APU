package tp1.ejercicio3;

public class Profesor {

	String nombre, apellido, email, facultad, catedra;
	
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFacultad() {
		return facultad;
	}


	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}


	public String getCatedra() {
		return catedra;
	}


	public void setCatedra(String catedra) {
		this.catedra = catedra;
	}


	public String tusDatos() {
		return "Profesor [nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", facultad=" + facultad
				+ ", catedra=" + catedra + "]";
	}
	
	
	
}
