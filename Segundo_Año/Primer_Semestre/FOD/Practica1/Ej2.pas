{
   Realizar un algoritmo, que utilizando el archivo de números enteros no ordenados
   creado en el ejercicio 1, informe por pantalla cantidad de números menores a 1500 y el
   promedio de los números ingresados. El nombre del archivo a procesar debe ser
   proporcionado por el usuario una única vez. Además, el algoritmo deberá listar el
   contenido del archivo en pantalla.

}


program Ej2;

type archivo = file of integer; // archivo de numeros
var arc_logico: archivo;
    nro: integer;
    nombre_archivo: string;

procedure informar(var arc_logico: archivo);
   var nro: integer;
      cant: integer;
      suma: integer;
   begin 
      cant:= 0;
      suma:= 0;
      reset(arc_logico); // se abre el archivo para lectura
      while not eof(arc_logico) do begin
         read(arc_logico, nro);
         if(nro < 1500) then 
            cant := cant + 1; // se cuenta la cantidad de numeros menores a 1500
            suma := suma + nro; // se suma el valor de los numeros
      end;
      writeln('Cantidad de numeros menores a 1500: ', cant);
      writeln('Promedio de los numeros ingresados: ', suma/cant);
      close(arc_logico); // se cierra el archivo
   end;

BEGIN
	write('Ingrese el nombre del archivo: ');
   readln(nombre_archivo);
   assign(arc_logico, nombre_archivo);
   rewrite(arc_logico); // se crea el archivo
   writeln('Ingrese un numero entero: ');
   read(nro);
   while nro <> 30000 do begin
      write(arc_logico, nro); // se escribe en el archivo cada numero
      writeln('Ingrese un numero entero: ');
      read(nro);
   end;

   writeln('Contenido del archivo: ');
   informar(arc_logico); // se llama al procedimiento para informar

   close (arc_logico);
END.

