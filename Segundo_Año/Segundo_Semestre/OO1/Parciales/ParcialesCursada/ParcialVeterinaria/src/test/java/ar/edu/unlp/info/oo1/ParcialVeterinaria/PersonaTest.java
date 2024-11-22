/*
 *	3)
 *
 * 	FUNCIONALIDAD --> RECAUDACION GENERADA POR UNA MASCOTA EN UNA FECHA DADA
 * 
 * 	Mascota::montoRecaudacion(LocalDate fecha)
 * 		- La Mascota no tiene servicios contratados
 * 		- Al menos tiene un serivicio contratado fuera de fecha
 * 		- Al menos un servicio contratado en fecha
 * 
 * Servicio::montoRecaudacion()
 * 		- ConsultaMedica y Vacunacion::montoRecaudacion()
 * 			- Al contratar el servicio se utiliza materiales adicionales
 * 			- Al contratar el servicio no se usan materiales adicionales
 * 			- El servicio se realiza un dia domingo
 * 			- El servicio se realiza caulquier otro dia de la semana
 * 
 * 		- Guarderia::montoRecaudacion()
 * 			- La mascota tiene contratado 5 Servicios (se hace descuento)
 * 			- La mascota tiene contratado 4 Servicios (no se hace descuento)
 * 
 * 
 */

// 4)

 // Inicializar el sistema
SistemaVeterinaria sv = new SistemaVeterinaria();
// Creo la mascota, el medico 
Medico medico = sv.registrarMedico("Medico", LocalDate.now(), 100);
Mascota mascota = sv.registrarMascota("mascota", LocalDate.now(), "perro");

// Le cargo a la mascota un servicio de vacunacion y guarderia
Servicio v = mascota.registrarVacunacion(medico, "nombre vacuna", 100, false);
Servicio g = mascota.registrarGuarderia(10);
