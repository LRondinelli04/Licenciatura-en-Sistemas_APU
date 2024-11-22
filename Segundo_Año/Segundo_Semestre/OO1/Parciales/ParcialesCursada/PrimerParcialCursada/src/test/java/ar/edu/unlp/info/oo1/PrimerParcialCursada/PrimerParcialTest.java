/*
 * 3)
 * 
 * FUNCIONALIDAD --> Calcular monto a recuperar por una entrada
 * 
 * Usuario::montoRecuperar():
 * 	- El usuario no tiene entradas
 * 	- El usuario tiene al menos 1 entrada
 * 
 * Entrada::calcularRembolso():
 * 	- La consulta de dias entre la fecha de compra con la actual es de 29 dias
 * 	- La consulta de dias entre la fecha de compra con la actual es de 30 dias
 * 	- La consulta de dias entre la fecha de compra con la actual es de 30 dias y comprando el seguro
 * 
 * Evento::precioAsistencia():
 * 	- la fecha de consulta no se hace el mismo dia que el evento
 * 	- La fecha de la consulta se hace el mismo dia que el evento
 * 	*Presencial::precioAsistencia():
 * 		- No hay sedes para el evento presencial
 * 		- Hay al menos 1 sede para el evento presencial

 * 
 * 
 * 
 * 
 */

// 4)
// Crear Sistema de eventos
SistemaEvento se = new SistemaEvento();
// Crear un usuario y un evento
Usuario u = new Usuario("Lucas");
Presencial ep = new Presencial("Presencial", LocalDate.now(), "tema principal", 100, 50);
// creo y cargo las sedes al evento
Sede s1 = new Sede("sede1", 100, 10);
Sede s2 = new Sede("sede2", 10, 10);
ep.addSede(s1);
ep.addSede(s2);
// cargo el evento y el usuario al sistema
se.addUsuario(u);
se.addEvento(ep);
// Usuario compra entrada (sin seguro)
u.comprarEntrada(ep, false);



 
