program ParcialDengue;
const
   archivoMensual = 30;
   valorAlto = 9999; 
type
   dengueMaestro = record
      codigoMunicipio: integer;
      nombreMunicipio: string;
      cantCasos: integer;
   end;
   archivoMaestro = file of dengueMaestro;

   dengueDetalle = record
      codigoMunicipio: integer;
      cantCasos: integer;
   end;
   archivoDetalle = file of dengueDetalle;

   dengueDetalleArray = array[1..archivoMensual] of dengueDetalle; // array de 30 archivos que se recibe por mes
   dengueDetalleArrayReg = array[1..archivoMensual] of dengueDetalle; // array de los registros de los archivos

procedure leer(var archivo: archivoDetalle; var reg: dengueDetalle);
begin
   if (not eof(archivo)) then
      read(archivo, reg)
   else
      reg.codigoMunicipio := valoralto; // valor alto para indicar el final del archivo
end;

procedure minimo(var regDetalle: dengueDetalleArrayReg; var minDetalle: dengueDetalle, var indiceMinimo: integer);
var
   i: integer; 
begin
   minDetalle.codigoMunicipio := valroAlto;
   for i := 1 to archivoMensual do begin
      if (regDetalle[i].codigoMunicipio < minDetalle.codigoMunicipio) then begin
         minDetalle := regDetalle[i];
         indiceMinimo := i;
      end;
   end;
end;

procedure actualizarMaestro(var maestro: archivoMaestro; var arrayDetalles: dengueDetalleArray, var regDetalle: dengueDetalleArrayReg);
var
   minDetalle: dengueDetalle;
   indiceMinimo: integer;
   regMaestro: dengueMaestro;
begin
   reset(maestro); // abrir el archivo maestro en modo escritura

   minimo(regDetalle, minDetalle, indiceMinimo);
   while (minDetalle.codigoMunicipio <> valorAlto) do begin
      read(maestro, regMaestro);
      while(regMaestro.codigoMunicipio < minDetalle.codigoMunicipio) do begin
         read(maestro, regMaestro); // leer el siguiente registro del maestro hasta encontrar el municipio correspondiente
      end;

      while (regMaestro.codigoMunicipio = minDetalle.codigoMunicipio) do begin
         regMaestro.cantCasos := regMaestro.cantCasos + minDetalle.cantCasos;
         leer(arrayDetalles[indiceMinimo], regDetalle[indiceMinimo]);
         minimo(regDetalle, minDetalle, indiceMinimo);

         if (minDetalle.codigoMunicipio <> regMaestro.codigoMunicipio) then 
            break; // salir del bucle si se cambia de municipio
      end;
      seek(maestro, filepos(maestro) -1);
      write(maestro, regMaestro);
   end;
   
   close(maestro); // cerrar el archivo maestro
end;


var
   maestro: archivoMaestro; 
   arrayDetalles: dengueDetalleArray; regDetalle: dengueDetalleArrayReg; // array de registros de los archivos detalle
   i: integer;
BEGIN
   assign(maestro, 'maestro');
	for i := 1 to archivoMensual do begin
      assign(arrayDetalles[i], 'detalle' + IntToStr(i));
      reset(arrayDetalles[i]); // abrir cada archivo detalle en modo lectura
      leer(arrayDetalles[i], regDetalle[i]);
   end;


   actualizarMaestro(maestro, arrayDetalles, regDetalle);

   for i := 1 to archivoMensual do begin
      close(arrayDetalles[i]); // cerrar cada archivo detalle
   end;
	
END.

