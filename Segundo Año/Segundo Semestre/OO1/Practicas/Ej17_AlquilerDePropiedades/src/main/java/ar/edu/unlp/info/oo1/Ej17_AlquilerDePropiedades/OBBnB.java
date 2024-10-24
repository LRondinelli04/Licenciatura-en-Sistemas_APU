package ar.edu.unlp.info.oo1.Ej17_AlquilerDePropiedades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class OBBnB {

	private List<Usuario> usuarios;
	private List<Propiedad> propiedadesDisponibles;
	
	public OBBnB() {
		this.usuarios = new ArrayList<Usuario>();
		this.propiedadesDisponibles = new ArrayList<Propiedad>();
	}
	
	public void addUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}
	
	public void addPropiedadDisponible(Propiedad propiedad) {
		this.propiedadesDisponibles.add(propiedad);
	}
	
	public boolean disponibilidadDePropiedad(Propiedad propiedad, LocalDate fechaInicio, LocalDate fechaFin) {
		boolean disponible = false;
		for (Propiedad p : this.propiedadesDisponibles) {
			if (p.equals(propiedad)) { // encontrar la propiedad dentro de la lista de propiedades disponibles
				if (propiedad.getOcupada() == false) { // preguntar si esa propiedad no esta ocupada
					if (propiedad.getFechaInicio().isAfter(fechaInicio) && propiedad.getFechaFin().isBefore(fechaFin)) { // preguntar si la propiedad se ecnuentra disponible entre esas fechas
						disponible = true;						
					}
				}
			}
		}
		return disponible;
	}
	
	public double calcularIngresosPropietario(Usuario usuario) {
		double total = 0;
		for (Usuario u : this.usuarios) {
			if (u.equals(usuario)) {
				total = u.calcularIngresosPropietario();
				return total;
			}
		}
		return total;
	}
	
	public List<Propiedad> getPropiedadesDisponibles(){
		return this.propiedadesDisponibles;
	}
	
	public List<Usuario> getUsuarios(){
		return this.usuarios;
	}

}
