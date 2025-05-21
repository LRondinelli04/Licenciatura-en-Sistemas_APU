{
   Se desea modelar la información necesaria para un sistema de recuentos de casos de covid 
   para el ministerio de salud de la provincia de buenos aires. 
   Diariamente  se  reciben  archivos  provenientes  de  los  distintos  municipios,  la  información 
   contenida  en  los  mismos  es  la  siguiente:  código  de  localidad,  código  cepa,  cantidad  de 
   casos activos, cantidad de casos nuevos, cantidad de casos recuperados, cantidad de casos 
   fallecidos. 
   El ministerio cuenta con un archivo maestro con la siguiente información: código localidad, 
   nombre localidad, código cepa, nombre cepa, cantidad de casos activos, cantidad de casos 
   nuevos, cantidad de recuperados y cantidad de fallecidos. 
   Se  debe  realizar  el  procedimiento  que  permita  actualizar  el  maestro  con  los  detalles 
   recibidos,  se  reciben  10  detalles. Todos los archivos están ordenados por código de 
   localidad y código de cepa.  
   Para la actualización se debe proceder de la siguiente manera:  
      1.  Al número de fallecidos se le suman el valor de fallecidos recibido del detalle. 
      2.  Idem anterior para los recuperados. 
      3.  Los casos activos se actualizan con el valor recibido en el detalle. 
      4.  Idem anterior para los casos nuevos hallados. 
   Realice  las  declaraciones  necesarias,  el  programa  principal  y  los  procedimientos  que 
   requiera para la actualización solicitada e informe cantidad de localidades con más de 50 
   casos activos (las localidades pueden o no haber sido actualizadas).
      
}


program Ej6;
const
   valorAlto = 9999;
type
   maestro = record
      codLocalidad: integer;
      nombreLocalidad: string;
      codCepa: integer;
      nombreCepa: string;
      cantCasosactivos: integer;
      cantCasosNuevos: integer;
      cantRecuperados: integer;
      cantFallecidos: integer;
   end;
   archivoMaestro = file of maestro; // ya se cuenta con la informacion

   detalle = record
      codLocalidad: integer;
      codCepa: integer;
      cantCasosActivos: integer;
      cantCasosNuevos: integer;
      cantRecuperados: integer;
      cantFallecidos: integer;
   end;
   archivoDetalle = file of detalle; // se recibe la informacion

   // Se recibe 10 detalles ordenados por codLocalidad y codCepa
   arrayDetalles = array[1..10] of archivoDetalle; // Array que contiene los archivos detalle

procedure leerDetalle(var detalle: archivoDetalle; var dato: detalle);
begin
   if (not eof(detalle)) then begin
      read(detalle, dato);
   end else
   begin
      dato.codLocalidad := valorAlto; // se asigna un valor alto para indicar fin de archivo
      dato.codCepa := valorAlto;
   end;
end;

procedure actualizarMaestro(var maestro: archivoMaestro; var detalles: arrayDetalles);
var
   i, totalFallecidos, totalRecuperados, totalActivos, totalNuevos: integer;
   infoDetalle, aux: detalle;
   infoMaestro: maestro;
begin
   for i:= 1 to 10 do begin // recorrer los detalles
      leer(detalles[i], infoDetalle);
      while(infoDetalle.codLocalidad <> valorAlto) do begin
         aux := infoDetalle;
         totalFallecidos := 0; totalRecuperados := 0; totalActivos := 0; totalNuevos := 0; // totales por localidad
         while(infoDetalle.codLocalidad = aux.codLocalidad) and (infoDetalle.codCepa = aux.codCepa) do begin
            totalFellecidos := totalFallecidos + infoDetalle.cantFallecidos;
            totalRecuperados := totalRecuperados + infoDetalle.cantRecuperados;
            totalActivos := totalActivos + infoDetalle.cantCasosActivos;
            totalNuevos := totalNuevos + infoDetalle.cantCasosNuevos;

            leer(detalles[i], infoDetalle);
         end;
         // cuando cambia de localidad, actualizo el maestro en base a los totales y su codigo de localidad
         // recorrer el maestro hasta encontrar el codigo de la localidad de aux
         read(maestro, infoMaestro);
         while (infoMaestro.codLocalidad <> aux.codLocalidad) and (not eof(maestro)) do begin
            read(maestro, infoMaestro);
         end;
         if (infoMaestro.codLocalidad = aux.codLocalidad) then begin
            // actualizar el maestro
            infoMaestro.cantFallecidos := infoMaestro.cantFallecidos + totalFallecidos;
            infoMaestro.cantRecuperados := infoMaestro.cantRecuperados + totalRecuperados;
            infoMaestro.cantCasosActivos := infoMaestro.cantCasosActivos + totalActivos;
            infoMaestro.cantCasosNuevos := infoMaestro.cantCasosNuevos + totalNuevos;
            seek(maestro, filepos(maestro) - 1); // retrocedo una posicion para actualizar
            write(maestro, infoMaestro);
         end;
      end;
   end;
end;

procedure informarCasos(var maestro: archivoMaestro);
var
   cant: integer;
   infoMaestro: maestro;
begin
   while (not eof(maestro)) do begin
      read(maestro, infoMaestro);
      if (infoMaestro.cantCasosActivos > 50) then begin
         writeln('Localidad: ', infoMaestro.nombreLocalidad, ' - Casos Activos: ', infoMaestro.cantCasosActivos);
         cant := cant + 1;
      end;
   end;

   writeln('Cantidad de localidades con más de 50 casos activos: ', cant);
end;


(* NO HICE UN MERGE DE LOS DETALLES (MAS CONVENIENTE) 

   LA SOLUCION HACE CORRECTAMENTE LO QUE SE SOLICITA PERO DEBERIA HACER UN MERGE DE LOS DETALLES Y LUEGO HACER LA ACTUALIZACION DEL MAESTRO
*)

var
   maestro: archivoMaestro; arregloDetalles: arrayDetalles;;
BEGIN
	assign(maestro, 'maestro');
   assign(detalle, 'detalle');

   reset(maestro); reset(detalle);
   actualizarMaestro(maestro, arregloDetalles);
   close(maestro); close(detalle);

   reset(maestro);
   informarCasos(maestro);
   close(maestro);
	
END.

