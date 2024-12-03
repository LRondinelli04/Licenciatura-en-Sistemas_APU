/*
 * 3)
 * 
 * FUNCIONALIDAD --> Calcular monto a recuperar por una entrada
 * 
 *  Entrada::montoARecuperar()
 *      - Si la diferencia de dias entre la fecha de compra con la fecha del evento es mayor o igual a 30
 *          - Si tiene seguro de compra
 *          - Si no tiene seguro de compra
 *      - Si la diferencia de dias entre la fecha de compra con la fecha del evento es menor a 30
 *          - Si tiene seguro de compra
 *          - Si no tiene seguro de compra
 *  
 *  Evento::EventoPresencial::precioAsistencia()
 *      - El evento presencial no tiene sedes
 *      - El evento presencial tiene al menos 1 sede
 *       ::consultarFechaEvento()
 *          - Si la fecha de compra fue realizada el mismo dia que la consulta
 *          - Si la fecha de compra fue realizada en una fecha distinta a la consulta
 *  Evento::EventoVirtual::precioAsistencia()
 *       ::consultaFechaEvento()
 *          - Si la fecha de compra fue realizada el mismo dia que la consulta
 *          - Si la fecha de compra fue realizada en una fecha distinta a la consulta
 * 
 * 
 */

// 4)
// Crear un usuario y un evento
Usuario u = new Usuario("Lucas");
Presencial ep = new Presencial("Presencial", LocalDate.now(), "tema principal", 100, 50);
// creo y cargo las sedes al evento
Sede s1 = new Sede("sede1", 100, 10);
Sede s2 = new Sede("sede2", 10, 10);
ep.addSede(s1);
ep.addSede(s2);
// Usuario compra entrada (sin seguro)
u.comprarEntrada(ep, false);



 
