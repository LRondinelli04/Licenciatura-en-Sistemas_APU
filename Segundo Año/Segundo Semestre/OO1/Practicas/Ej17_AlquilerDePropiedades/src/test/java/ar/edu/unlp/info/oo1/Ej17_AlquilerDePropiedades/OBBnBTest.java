package ar.edu.unlp.info.oo1.Ej17_AlquilerDePropiedades;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Aca escribiremos los test de unidad para cada clase 
 * 
 */
public class OBBnBTest {
	
	OBBnB sistema;
	Usuario u1, u2;
	Propiedad p1, p2, p3;
	Reserva r;
	
	@BeforeEach
	public void setUp() {
		sistema = new OBBnB();
		
		p1 = new Propiedad("citybell", "duplex", 100, LocalDate.of(2024, 1, 1), LocalDate.MAX);
		p2 = new Propiedad("villaelisa", "casa", 1000, LocalDate.of(2024, 12, 1), LocalDate.of(2024, 12, 15));
		p3 = new Propiedad("melchor romero", "quinta", 10000, LocalDate.of(2024, 12, 1), LocalDate.of(2024, 12, 15));
		
		sistema.addPropiedadDisponible(p1);
		sistema.addPropiedadDisponible(p2);
		sistema.addPropiedadDisponible(p3);
		
		u1 = new Usuario("Lucas", "citybell", 94118949, sistema.getPropiedadesDisponibles());
		u2 = new Usuario("Pedro", "villaelisa", 45789321, sistema.getPropiedadesDisponibles());
		
		sistema.addUsuario(u1);
		sistema.addUsuario(u2);
	
	}
	
	@Test
	public void testAddUsuario() {
		assertEquals(u1, sistema.getUsuarios().get(0));
		assertEquals(u2, sistema.getUsuarios().get(1));
	}
	
	@Test void testAddPropiedadDisponible() {
		assertEquals(p1, sistema.getPropiedadesDisponibles().get(0));
		assertEquals(p2, sistema.getPropiedadesDisponibles().get(1));
		assertEquals(p3, sistema.getPropiedadesDisponibles().get(2));
	
	}
	
	@Test 
	public void testDisponiblidadDePropiedad() {
		assertTrue(sistema.disponibilidadDePropiedad(p3, LocalDate.of(2024, 11, 1), LocalDate.of(2024, 12, 16)));
		assertFalse(sistema.disponibilidadDePropiedad(p2, LocalDate.of(2024, 11, 1), LocalDate.of(2024, 12, 11)));
	}
	
	@Test
	public void testCrearUnaReserva() {
		u1.crearUnaReserva(p1, LocalDate.of(2024, 1, 5), LocalDate.of(2024, 1, 15));
		assertTrue(u1.getReservas().size() == 1); // se registro correctamente la reserva
		
	}
	
	@Test
	public void testCalcularPrecioReserva() {
		this.testCrearUnaReserva();
		r = u1.getReservas().get(0);
		
		assertEquals(1000, u1.calcularPrecioReserva(r)); // 100 * 10 dias = 1000
	}
	
	@Test
	public void testCancelarReserva() {
		this.testCrearUnaReserva();
		r = u1.getReservas().get(0);
		assertTrue(u1.getReservas().size() == 1);
		
		u1.cancelarReserva(p1);
		assertTrue(u1.getReservas().size() == 0);
		
	}
	
	@Test
	public void testCalcularIngresosPropietario() {
		this.testCrearUnaReserva();
		assertEquals(1, sistema.getUsuarios().get(0).getReservas().size());
		assertEquals(750, sistema.calcularIngresosPropietario(u1)); // 75% del calcular reservar = 1000 * 0.75% = 750
	}

}
