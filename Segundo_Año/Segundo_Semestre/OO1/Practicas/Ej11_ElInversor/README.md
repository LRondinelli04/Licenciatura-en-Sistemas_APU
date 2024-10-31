# Ejercicio 11: El Inversor
Estamos desarrollando una aplicación móvil para que un inversor pueda conocer el estado de sus inversiones. El sistema permite manejar dos tipos de inversiones: Inversión en acciones e inversión en plazo fijo. Nuestro sistema representa al inversor y a cada uno de los tipos de inversiones con una clase.

- La clase InversionEnAcciones tiene las siguientes variables de instancia:
	String nombre;
	int cantidad;
	double valorUnitario;

- La clase PlazoFijo tiene las siguientes variables de instancia:
	LocalDate fechaDeConstitucion;
	double montoDepositado;
	double porcentajeDeInteresDiario;

- La clase Inversor tiene las siguientes variables de instancia:
	String nombre;
	List<?> inversiones;

La variable inversiones de la clase Inversor es una colección con instancias de cualquiera de las dos clases de inversiones que pueden estar mezcladas.
Cuando se quiere saber cuánto dinero representan las inversiones del inversor, se envía al mismo el mensaje valorActual().

**Tareas:**
- **Modele e implemente**
    - Realice el diagrama UML de clases de la solución al problema.
    - Implemente en Java lo que considere necesario para que las instancias de Inversor entiendan el mensaje valorActual() teniendo en cuenta los siguientes criterios:
    - El valor actual de las inversiones de un inversor es la suma de los valores actuales de cada una de las inversiones en su cartera (su colección de inversiones).  
    - El valor actual de un PlazoFijo equivale al montoDepositado incrementado como corresponda por el porcentaje de interés diario, desde la fecha de constitución a la fecha actual (la del momento en el que se hace el cálculo).  
    - El valor actual de una InversionEnAcciones se calcula multiplicando el número de acciones por el valor unitario de las mismas.
Recordatorio: No olvide la inicialización.
- **Pruebas automatizadas**
    - Implemente los tests (JUnit) que considere necesarios.
