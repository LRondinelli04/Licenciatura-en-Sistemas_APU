package ar.edu.unlp.info.oo1.GenealogiaSalvaje;

import java.sql.Date;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Mamifero {
	
	private String identificador, especie;
	private Date fechaNacimiento;
	private Mamifero padre, madre, abuelo, abuela;
	
	
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Mamifero getPadre() {
		return padre;
	}
	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}
	public Mamifero getMadre() {
		return madre;
	}
	public void setMadre(Mamifero madre) {
		this.madre = madre;
	}
	public Mamifero getAbuelo() {
		return abuelo;
	}
	public Mamifero getAbuela() {
		return abuela;
	}
	
	public boolean tieneComoAncestroA(Mamifero mamifero) {
		if ((mamifero.getPadre() != null) || (mamifero.getMadre() != null)) {
			return true;
		} else {
			return false;
		}
	}
	
	

}
