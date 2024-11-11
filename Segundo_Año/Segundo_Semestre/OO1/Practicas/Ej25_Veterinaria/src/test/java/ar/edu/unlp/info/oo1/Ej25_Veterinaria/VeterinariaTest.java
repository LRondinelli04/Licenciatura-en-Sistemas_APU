package ar.edu.unlp.info.oo1.Ej25_Veterinaria;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Aca escribiremos los test de unidad para cada clase 
 * 
 */
public class VeterinariaTest {
	
	Plataforma p;
	Medico m1;
	Mascota perro, gato;
	
	@BeforeEach
	public void setUp() {
		p = new Plataforma();
		m1 = new Medico("juan", LocalDate.of(2014, 1, 1), 100.0);
		perro = new Mascota("perro",LocalDate.of(2010, 1, 1),"bordercolli");
		gato = new Mascota("gato", LocalDate.of(2015, 1, 1), "callejero");
		
		p.addMedico(m1);
		p.addMascota(gato);
		p.addMascota(perro);
	}
	
    @Test
    public void testAddMedico() {
        assertEquals(m1, p.getMedicos().get(0));
    }
    @Test
    public void testAddMascota() {
    	assertEquals(perro, p.getMascotas().get(1));
    	assertEquals(gato, p.getMascotas().get(0));
    }
    
    @Test
    public void testDarAltaConsultaMedica() {
    	p.darAltaConsutlaMedica(m1, gato);
    	p.darAltaConsutlaMedica(m1, gato);
    	assertEquals(2, gato.getServicios().size());
    }
    @Test
    public void testDarAltaVacunacion() {
    	p.darAltaVacunacion(m1, perro, "vacuna", 10, LocalDate.now());
    	assertEquals(1, perro.getServicios().size());
    }
    @Test
    public void testDarAltaGuarderia() {
    	p.darAltaGuarderia(gato, 10);
    	p.darAltaGuarderia(perro, 12);
    	assertEquals(1, gato.getServicios().size());
    	assertEquals(1, perro.getServicios().size());
    }
    
    @Test
    public void testRecaudacionGeneradaPorMascota() {
    	p.darAltaConsutlaMedica(m1, gato);
    	p.darAltaGuarderia(perro, 12);
    	System.out.println(m1.getHonorarios());
    	assertEquals(500, perro.recaudacionGeneradaPorMascota(LocalDate.now()));
    	assertEquals(1100, gato.recaudacionGeneradaPorMascota(LocalDate.now()));
    }
    
}
