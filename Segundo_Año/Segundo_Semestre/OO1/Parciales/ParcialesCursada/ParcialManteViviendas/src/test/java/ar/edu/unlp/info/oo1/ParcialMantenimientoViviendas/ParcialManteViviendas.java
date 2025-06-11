package Segundo_Año.Segundo_Semestre.OO1.Parciales.ParcialesCursada.ParcialManteViviendas.src.test.java.ar.edu.unlp.info.oo1.ParcialMantenimientoViviendas;

import Segundo_Año.Segundo_Semestre.OO1.Parciales.ParcialesCursada.ParcialManteViviendas.src.main.java.ar.edu.unlp.info.oo1.ParcialMantenimientoViviendas.Cliente;
import Segundo_Año.Segundo_Semestre.OO1.Parciales.ParcialesCursada.ParcialManteViviendas.src.main.java.ar.edu.unlp.info.oo1.ParcialMantenimientoViviendas.Plataforma;
import Segundo_Año.Segundo_Semestre.OO1.Parciales.ParcialesCursada.ParcialManteViviendas.src.main.java.ar.edu.unlp.info.oo1.ParcialMantenimientoViviendas.Servicio;
import java.time.LocalDate;

/*
 * 
 * 
 *	TEST NECESARIOS PARA LA SIGUIENTE FUNCIONALIDAD:
 *		- Monto a pagar por un cliente considerando solo contrataciones unicas para Serv de limpieza
 *
 * 
 * 	CLiente::montoPagar()
 * 		- Metodo principal que suma los valores de los costos de los contratos de todos los servicios contratados
 * 
 *  ContratoUnico::montoAPagar()
 *  	- El contrato se realizo durante el fin de semana
 *  	- El contrato se realizo cualquier dia menos el fin de semana
 *  
 *  Limpieza::montoServicio()
 *  	- El precio por hora multiplicado por la cantidad de horas es mayor a la tarifa minima (tarifa = 99 | precioHora * cantHoras = 100)
 *  	- El precio por hora multiplicado por la cantidad de horas es menor a la tarifa minima (tarifa = 100 | precioHora * cantHoras = 99)
 *  	- El precio por hora multiplicado por la cantidad de horas es muy mayor a la tarifa minima (tarifa = 1 | precioHora * cantHoras = 10000)
 *  	- El precio por hora multiplicado por la cantidad de horas es muy menor a la tarifa minima (tarifa = 10000 | precioHora * cantHoras = 1)
 *  	
 */

/*
 * CODIGO JAVA NECESARIO PARA INICIALIZAR EL SISTEMA, REGISTRAR UN SERVICIO DE LIMPIEZA, UN CLIENTE Y CONTRATAR POR UNICA VEZ EL SERVICIO AL CLIENTE
*/

public class ParcialManteViviendas {
    public static void main(String[] args) {
        Plataforma p = new Plataforma();
        Cliente c = p.registrarCliente("Lucas", "La Plata");
        Servicio limpieza = p.registrarServLimpieza(100, 10, 100);

        // contratar el servicio para el cliente
        c.contratarUnica(limpieza, LocalDate.now());
    }
}
