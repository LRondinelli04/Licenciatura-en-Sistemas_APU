{
   Una empresa posee un archivo con información de los ingresos percibidos por diferentes
	empleados en concepto de comisión, de cada uno de ellos se conoce: código de empleado,
	nombre y monto de la comisión. La información del archivo se encuentra ordenada por
	código de empleado y cada empleado puede aparecer más de una vez en el archivo de
	comisiones.
	Realice un procedimiento que reciba el archivo anteriormente descrito y lo compacte. En
	consecuencia, deberá generar un nuevo archivo en el cual, cada empleado aparezca una
	única vez con el valor total de sus comisiones.
	NOTA: No se conoce a priori la cantidad de empleados. Además, el archivo debe ser
	recorrido una única vez.
   
}


(* 
	Paso a paso:
		1. Definir el archivo y el registro que contiene la información de los empleados.
		2. Abrir el archivo original de comisiones en modo lectura.
		3. Crear el archivo compacto en modo escritura.
		4. Leer el primer registro del archivo original.
		5. Mientras no sea fin de archivo (original):
			5.1. Guardar el codigo y nombre del empleado actual.
			5.2. Inicializar el acumulador de comisiones en 0.
			5.3. Mientras el codigo de empleado sea igual al actual (porque esta ordenado):
				5.3.1 Sumar la comision al acumulador.
				5.3.2 Leer el siguiente registro.
		    5.4. Escribir en el archivo compacto un registro con el codigo, nombre y total acumulado
		6. Cerrar ambos archivos.
		7. Fin.
 *)

program Ej1;

type
	ingresos = record
		codEmpleado: integer;
		nombre: string;
		montoComision: real;
	end;
	archivo = filo of ingresos;
	

procedure compactarArchivo(var archOriginal, archCompacto: archivo);
var
	actual, regOriginal: ingresos;
begin
	reset(archOriginal); // Abrir el archivo original en modo lectura
	rewrite(archCompacto); // Crear el archivo compacto en modo escritura

	if (not eof(archOriginal)) then
		read(archOriginal, regOriginal); // Leer el primer registro del archivo original;

	while (not eof(archOriginal)) do begin
		// Guardar el codigo y nombre del empleado actual
		actual.codEmpleado := regOriginal.codEmpleado;
		actual.nombre := regOriginal.nombre;
		actual.montoComision := 0; // Inicializar el acumulador de comisiones en 0

		// Acumular todas las comisiones del mismo empleado
		while (not eof(archOriginal)) and (regOriginal.codEmpleado = actual.codEmpleado) do begin
			actual.montoComision := actual.montoComision + regOriginal.montoComision; // Sumo las comisiones al archivo compacto
			read(archOriginal, regOriginal); // Leer el siguiente registro
		end;

		// Para el ultimo registro leido
		if (regOriginal.codEmpleado = actual.codEmpleado) then begin
			actual.montoComision := actual.montoComision + regOriginal.montoComision;
		end;

	
		write(archCompacto, actual); // Escribir en el archivo compacto un registro con el codigo, nombre y total acumulado
	end;
	close(archOriginal); // Cerrar el archivo original
	close(archCompacto); // Cerrar el archivo compacto
end;

BEGIN
(* Solo pide realizar el procedimiento *)	
END.

