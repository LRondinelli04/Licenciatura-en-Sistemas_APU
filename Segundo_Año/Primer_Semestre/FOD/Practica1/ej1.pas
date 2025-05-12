{
   Realizar un algoritmo que cree un archivo de números enteros no ordenados y permita
   incorporar datos al archivo. Los números son ingresados desde teclado. La carga finaliza
   cuando se ingresa el número 30000, que no debe incorporarse al archivo. El nombre del
   archivo debe ser proporcionado por el usuario desde teclado.

}


program Ej1;

type archivo = file of integer; // archivo de numeros
var arc_logico: archivo;
    nro: integer;
    nombre_archivo: string;

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
   close (arc_logico);
END.

