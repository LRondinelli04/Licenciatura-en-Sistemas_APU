{
   Definir un programa que genere un arcFisicohivo con registros de longitud fija conteniendo información de asistentes a un congreso a partir de la información obtenida por teclado. Se deberá almacenar la siguiente información: nro de asistente, apellido y nombre, email, teléfono y D.N.I. Implementar un procedimiento que, a partir del arcFisicohivo de datos generado, elimine de forma lógica todos los asistentes con nro de asistente inferior a 1000.
   Para ello se podrá utilizar algún carácter especial situándolo delante de algún campo String a su elección. Ejemplo: ‘@Saldaño’.
   
}


program Ej2;

const 
   valorAlto = 9999;

type
   asistente = record
      nro: integer;
      apellido: string;
      nombre: string;
      email: string;
      telefono: integer;
      dni: integer;
   end;
   arcFisico = file of asistente;

procedure mostrarArchivo(var archivo: arcFisico);
var
   a: asistente;
begin
   reset(archivo);
   while not eof(archivo) do
   begin
      read(archivo, a);
      writeln('Nro: ', a.nro, ' Apellido: ', a.apellido, ' Nombre: ', a.nombre, ' Email: ', a.email, ' Tel: ', a.telefono, ' DNI: ', a.dni);
   end;
   close(archivo);
end;

procedure leer(var archivo: arcFisico; var a: asistente);
begin
   if(not eof(archivo)) then begin
      read(archivo, a);
   end else 
   begin
      a.nro := valorAlto;
   end;
end;

procedure cargarArchivo(var archivo: arcFisico);
var
   a: asistente;
begin
   writeln('Ingrese el nro de asistente: ');
   readln(a.nro);
   while (a.nro <> 0) do begin
      writeln('Ingrese el apellido: ');
      readln(a.apellido);
      writeln('Ingrese el nombre: ');  
      readln(a.nombre);
      writeln('Ingrese el email: ');
      readln(a.email);
      writeln('Ingrese el telefono: ');
      readln(a.telefono);
      writeln('Ingrese el dni: ');
      readln(a.dni);
      
      write(archivo, a); // cargo en el arcFisicohivo
      
      writeln('Ingrese el nro de asistente: ');
      readln(a.nro);
   end;
end;

procedure eliminarLogico(var archivo: arcFisico);
var
   a: asistente;
begin
   leer(archivo, a);
   while (a.nro <> valorAlto) do begin
      if (a.nro < 1000) then begin
         a.apellido := '@Saldaño';
         seek(archivo, filepos(archivo) - 1);
         write(archivo, a); // cargo la marca en el archivo
      end;
      leer(archivo, a);
   end;
end;

var
   archivo: arcFisico;

BEGIN
	assign(archivo, 'asistentes');
   
   // cargar el arcFisicohivo
   rewrite(archivo);
   cargarArchivo(archivo);
   close(archivo);

   mostrarArchivo(archivo);

   // eliminar datos
   reset(archivo);
   eliminarLogico(archivo);
   close(archivo);

   writeln('Eliminacion logica realizada con exito');
   writeln();
   mostrarArchivo(archivo);

	
END.

