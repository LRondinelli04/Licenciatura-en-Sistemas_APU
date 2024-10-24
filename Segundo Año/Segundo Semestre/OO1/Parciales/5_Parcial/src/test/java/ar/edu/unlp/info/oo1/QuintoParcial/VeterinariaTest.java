package ar.edu.unlp.info.oo1.QuintoParcial;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Aca escribiremos los test de unidad para cada clase 
 * 
 */
public class VeterinariaTest {
	
	Veterinaria vete;
	Mascota m1, m2, m3;
	Medico medico;
	Guarderia g;
	ConsultaMedica cm;
	Vacunacion v;
	
	@BeforeEach
	void setUp() throws Exception {
		vete = new Veterinaria();
		
		m1 = new Mascota("Soli", "perro", LocalDate.of(2020, 10, 10));
		m2 = new Mascota("blaki", "perro", LocalDate.of(2020, 10, 20));
		m3 = new Mascota("chino", "perro", LocalDate.of(2022, 10, 1));
		
		medico = new Medico("Lucas", LocalDate.of(2015, 6, 1), 100);
		
		g = new Guarderia(m1, 10);
		cm = new ConsultaMedica(m2, medico, 1);
		v = new Vacunacion(m3, medico,"pzier", 100, 1);
	}
	
    @Test
    public void testRegistrarMascota() {
        vete.registrarMascota(m1);
        vete.registrarMascota(m2);
        vete.registrarMascota(m3);
        
        assertEquals(3, vete.getCantMascotas(), "Deberia traer 3 mascotas registradas");
    }
    
    @Test
    public void testRegistrarMedico() {
    	vete.registrarMedico(medico);
    	
    	assertEquals(1, vete.getCantMedicos(), "Deberia traer 1 medico registrado");
    }
    
    @Test
    public void testRegistrarServicio() {
    	m1.registrarServicio(g);
    	m2.registrarServicio(cm);
    	m3.registrarServicio(v);
    	
    	 // Verificar el costo de cada servicio
        assertEquals(5000, g.costoServicio(), "El costo de la guardería debería ser 5000");
        assertEquals(1300, cm.costoServicio(), "El costo de la consulta médica debería ser 1300");
        assertEquals(700, v.costoServicio(), "El costo de la vacunación debería ser 700");
    }
}
