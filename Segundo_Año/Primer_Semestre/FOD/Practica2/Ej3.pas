{
   A partir de información sobre la alfabetización en la Argentina, se necesita actualizar un
archivo que contiene los siguientes datos: nombre de provincia, cantidad de personas
alfabetizadas y total de encuestados. Se reciben dos archivos detalle provenientes de dos
agencias de censo diferentes, dichos archivos contienen: nombre de la provincia, código de
localidad, cantidad de alfabetizados y cantidad de encuestados. Se pide realizar los módulos
necesarios para actualizar el archivo maestro a partir de los dos archivos detalle.
NOTA: Los archivos están ordenados por nombre de provincia y en los archivos detalle
pueden venir 0, 1 ó más registros por cada provincia.

   
}

(* REALIZAR UN MERGE Y LUEGO ACTUALIZAR EL ARCHIVO MAESTRO *)


program Ej3;

const
   valorAlto = 'ZZZ';

type
   provincia = record
     nombre: string;
     alfabetizados: integer;
     encuestados: integer;
   end;
   archivoMaestro = file of provincia;

   detalle = record
     nombre: string;
     codLocalidad: integer;
     alfabetizados: integer;
     encuestados: integer;
   end;
   archivoDetalle = file of detalle;

procedure leer(var archivo: archivoDetalle; var dato: detalle);
begin
   if (not eof(archivo)) then
      read(archivo, dato)
   else 
      dato.nombre := valorAlto;
end;

procedure minimo(var det1, det2: archivoDetalle; var r1, r2, min: detalle);
begin
   if(r1.nombre <= r2.nombre) then begin
      min := r1;
      leer(det1, r1);
   end
   else begin
      min := r2;
      leer(det2, r2);
   end;
end;

procedure mergearDetalles(var archivo1, archivo2, maestro: archivoDetalle);
var
   regDetalle1, regDetalle2, min: detalle;
begin
   leer(archivoDetalle1, regDetalle1); leer(archivoDetalle2, regDetalle2);

   minimo(archivoDetalle1, archivoDetalle2, regDetalle1, regDetalle2, min);
   // Mergeo los archivos detalle en el maestroDetalles
   while(min.nombre <> valorAlto) do begin
      write(maestroDetalle, min);
      minimo(archivoDetalle1, archivoDetalle2, regDetalle1, regDetalle2, min);
   end;
end;

procedure actualizarMaestro(var archivoMaestro: archivoMaestro; var maestroDetalle: archivoDetalle);
var   
   regMaestro: provincia;
   regDetalle: detalle;
   totalAlfabetizados, totalEncuestados: integer;
begin
   while(not eof(maestroDetalle)) do begin
      read(archivoMaestro, regMaestro); read(maestroDetalle, regDetalle);

      while (regMaestro.nombre <> regDetalle.nombre) do 
         read(archivoMaestro, regMaestro);

      // Iniciar contadores
      totalAlfabetizados := 0;
      totalEncuestados := 0;
      while (not eof(maestroDetalle)) and (regMaestro.nombre = regDetalle.nombre) do begin
         totalAlfabetizados := totalAlfabetizados + regDetalle.alfabetizados;
         totalEncuestados := totalEncuestados + regDetalle.encuestados;
         leer(maestroDetalle, regDetalle);
      end;

      // Actualizar el registro en el archivo maestro
      regMaestro.alfabetizados := regMaestro.alfabetizados + totalAlfabetizados;
      regMaestro.encuestados := regMaestro.encuestados + totalEncuestados;

      seek(archivoMaestro, filepos(archivoMaestro) - 1); // Volver al registro actual
      write(archivoMaestro, regMaestro); // Actualizar el registro en el archivo maestro

   end;
end;

var
   regMaestro: provincia;
   archivoMaestro: archivoMaestro;
   maestroDetalle, archivoDetalle1, archivoDetalle2: archivoDetalle;

BEGIN
	assign(archivoMaestro, 'maestro'); assign(archivoDetalle1, 'detalle1'); assign(archivoDetalle2, 'detalle2'); assign(maestroDetalle, 'maestroDetalle');
   
   // Crear el archivo maestro y los archivos detalle
   rewrite(maestroDetalle); 
   reset(archivoDetalle1); reset(archivoDetalle2);
   // Crear el archivo maestroDetalles
   mergearDetalles(archivoDetalle1, archivoDetalle2, maestroDetalle);

   close(maestroDetalle); close(archivoDetalle1); close(archivoDetalle2);

   // Actualizo el archivo maestro a partir del maestroDetalles
   reset(maestroDetalle); reset(archivoMaestro);
   actualizarMaestro(archivoMaestro, maestroDetalle);

   close(maestroDetalle); close(archivoMaestro);
	
END.

