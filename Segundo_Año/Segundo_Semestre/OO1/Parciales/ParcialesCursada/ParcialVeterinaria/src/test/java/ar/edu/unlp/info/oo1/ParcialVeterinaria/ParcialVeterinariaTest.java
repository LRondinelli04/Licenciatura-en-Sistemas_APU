/*
 *	3)
 *
 * 	FUNCIONALIDAD --> RECAUDACION GENERADA POR UNA MASCOTA EN UNA FECHA DADA
 * 
 * 	Mascota::montoRecaudacion(LocalDate fecha)
 * 		- La Mascota no tiene servicios contratados
 * 		- Al menos tiene un serivicio contratado fuera de fecha
 * 		- Al menos un servicio contratado en fecha
 *      - Fecha muy lejana en el pasado (ej: LocalDate.of(1900, 1, 1))
 *      - Fecha muy lejana en el futuro (ej: LocalDate.of(3000, 1, 1))
 * 
 * Servicio::montoRecaudacion()
 * 
 *      - ConsultaMedica::montoRecaudacion()
 *          - El medico es recien egresado (antiguedad = 0)
 *          - El medico tiene antiguedad (antiguedad = 30)
 *          - El servicio se realizo con materiales adicionales
 *          - El servicio se realizo sin materiales adicionales
 *          - El servicio se realizo un dia domingo  
 *          - El servicio se realizo cualquier otro dia de la semana
 *          - Los honorarios del medico son 0
 *          - Los honorarios del medico son mayores a 0
 * 
 *      - Vacunacion::montoRecaudacion()
 *          - El costo de la vacuna es 0
 *          - El costo de la vacuna es mayor a 0
 *          - El costo de la vacuna es alto (ej: 10000)
 *          - El servicio se realizo con materiales adicionales
 *          - El servicio se realizo sin materiales adicionales
 *          - El servicio se realizo un dia domingo  
 *          - El servicio se realizo cualquier otro dia de la semana
 * 
 * 		   - Guarderia::montoRecaudacion()
 * 			      - La mascota tiene contratado 4 Servicios (no se hace descuento)
 * 			      - La mascota tiene contratado 5 Servicios (se hace descuento)
 *          - La mascota tiene contratado la Guarderia por 0 dias
 *          - La mascota tiene contratado la Guarderia por al menos 1 dia
 *          - La mascota tiene contratado la Guarderia por muchos dias (ej: 10 dias)
 * 
 * Medico::getHonorarios()
 *  - Los honorarios del medico son 0
 *  - Los honorarios del medico son mayores a 0
 *  - Los honorarios del medico son altos (ej: 10000)
 * 
 * Medico::getAntiguedad()
 *  - El medico es recien egresado (antiguedad = 0)
 *  - El medico tiene antiguedad (antiguedad = 30)
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
