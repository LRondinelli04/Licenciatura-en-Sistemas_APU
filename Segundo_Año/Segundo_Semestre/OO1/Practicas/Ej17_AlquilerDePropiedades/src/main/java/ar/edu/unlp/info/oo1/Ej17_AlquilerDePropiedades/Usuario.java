package ar.edu.unlp.info.oo1.Ej17_AlquilerDePropiedades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private String nombre, direccion;
	private int dni;
	private List<Propiedad> propiedadesDeseadas;
	private List<Propiedad> propiedadesDisponibles;
	private List<Reserva> reservas;
	
	public Usuario(String nombre, String direccion, int dni, List<Propiedad> propiedadesDisponibles) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.dni = dni;
		this.propiedadesDisponibles = propiedadesDisponibles;
		this.propiedadesDeseadas = new ArrayList<Propiedad>();
		this.reservas = new ArrayList<Reserva>();
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public List<Reserva> getReservas(){
		return this.reservas;
	}
	
	public void crearUnaReserva(Propiedad propiedad, LocalDate fechaInicioReserva, LocalDate fechaFinReserva) {
		for (Propiedad p : this.propiedadesDisponibles) {
			if (p.equals(propiedad)) {
				if (propiedad.getOcupada() == false) {
					if (propiedad.getFechaFin().isAfter(fechaInicioReserva)) {
						// esta disponible
						p.ocuparPropiedad();
						p.setFechaInicio(fechaInicioReserva);
						p.setFechaFin(fechaFinReserva);
						Reserva r = new Reserva(p, fechaInicioReserva, fechaFinReserva);
						this.reservas.add(r);
					}
				}
			}
		}
	}
	
	public double calcularPrecioReserva(Reserva reserva) {
		for (Reserva r : this.reservas) {
			if (r.equals(reserva)) {
				return reserva.calcularPrecioReserva();
			}
		}
		return 0;
	}
	
	public void cancelarReserva(Propiedad propiedad) {
		for (int i = 0; i < this.reservas.size(); i++) {
			Reserva r = this.reservas.get(i);
			if (r.getPropiedad().equals(propiedad)) {
				if (propiedad.getFechaInicio().isBefore(LocalDate.now())) { // si la fecha de inicio de la reserva es posterior a la actual
					this.reservas.remove(i);
					System.out.println("Reserva cancelada: " + r.getPropiedad().getNombre());
					
					// Dar de alta nuevamente en la lista de Propiedades disponibles
					for (Propiedad p : this.propiedadesDisponibles) {
						if (p.equals(propiedad)) {
							p.desocuparPropiedad();
							p.setFechaInicio(LocalDate.now());
							p.setFechaFin(LocalDate.MAX);
						}
					}
					return; // salir del metodo cuando ya se haya cancelado la reserva
				}
			}
		}
		System.out.println("No se encontro ninguna reserva disponible para cancelar");
	}
	
	public double calcularIngresosPropietario(/*LocalDate fechaInicio, LocalDate fechaFin*/) {
		double total = 0;
		double precioReserva = 0;
		for (Reserva r : this.reservas) {
			//if (r.getFechaInicioReserva().isBefore(fechaInicio) && r.getFechaFinReserva().isAfter(fechaFin)) {
				precioReserva += r.calcularPrecioReserva();
			//}
		}
		
		total = precioReserva * 0.75;
		
		return total;
	}
	
}
