{
   Realizar un programa que presente un menú con opciones para:
	a. Crear un archivo de registros no ordenados de empleados y completarlo con datos ingresados desde teclado. De cada empleado se registra: número de
	empleado, apellido, nombre, edad y DNI. Algunos empleados se ingresan con DNI 00. La carga finaliza cuando se ingresa el String ‘fin’ como apellido.
	b. Abrir el archivo anteriormente generado y
		i. Listar en pantalla los datos de empleados que tengan un nombre o apellido
			determinado, el cual se proporciona desde el teclado.
		ii. Listar en pantalla los empleados de a uno por línea.
		iii. Listar en pantalla los empleados mayores de 70 años, próximos a jubilarse.

	NOTA: El nombre del archivo a crear o utilizar debe ser proporcionado por el usuario
}


program Ej3;

type
	registroEmp = record
		nro: integer;
		apellido: string;
		nombre: string;
		edad: integer;
		dni: integer;
	end;
	empleados = file of registroEmp;

procedure cargarArchivo(var arc_logico: empleados);
	var
		e: registroEmp;
	begin 
		reset(arc_logico);
		writeln('Ingrese el apellido del empleado: ');
		readln(e.apellido);
		while(e.apellido <> 'fin') do begin
			writeln('Ingrese el nombre del empleado: ');
			readln(e.nombre);
			writeln('Ingrese el numero del empleado: ');
			readln(e.nro);
			writeln('Ingrese la edad del empleado: ');
			readln(e.edad);
			writeln('Ingrese el DNI del empleado: ');
			readln(e.dni);
			
			write(arc_logico, e);
			writeln('Ingrese el apellido del empleado: ');
			readln(e.apellido);
		end;
		close(arc_logico);
	end;

procedure listarEmpleados(var arc_logico: empleados; emp: string);
	var
		e: registroEmp;
	begin 
		reset(arc_logico);
		while not eof(arc_logico) do begin
			read(arc_logico, e);
			if (e.nombre = emp) or (e.apellido = emp) then begin 
				writeln(e.nombre + ' ' +  e.apellido);
			end;
		end;
		close(arc_logico);
	end;
var
	arc_logico: empleados;
	arc_fisico: string;
	emp: string;
	
BEGIN
	writeln('Ingrese el nombre del archivo: ');
	readln(arc_fisico);
	assign(arc_logico, arc_fisico);
	rewrite(arc_logico);
	cargarArchivo(arc_logico); // A)
	
	writeln('Ingrese nombre o apellido del empleado a buscar');
	readln(emp);
	listarEmpleados(arc_logico, emp); // B) i)
	
END.

