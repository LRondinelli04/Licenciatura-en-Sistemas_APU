{
   La empresa de software 'X' posee un servidor web donde se encuentra alojado el sitio de la organizacion. En dicho servidor, se almacenan en nu archivo todos los accesos que se realizan al sitio.
   La informacion que se almacena en el archivo es la siguiente: año, mes, dia, idUsuario y tiempo de acceso al sitio de la organizacion. El archivo se encuentra ordenado por los siguientes criterios: año, mes, dia e idUsuario.
   Se debe realizar un procedimiento que genere un informe en pantalla, para ello se indicara el año calendario sobre el cual debe realizar el informe. El mismo debe respetar el formato mostrado a continuacion:

   Año: ___
      Mes:___ 1
         Dia:___ 1
            IdUsuario: ___ 1 Tiempo Total de acceso en el dia 1 mes 1
            ---------
            idUsuario N Tiempo Total de acceso en el dia 1 mes 1
         -----------
         dia N
            idUsuario 1 Tiempo Total de acceso en el dia N mes 1
            ----------
            idUsuario N Tiempo total de acceso en el dia N mes 1
      --------
      Mes 12
         dia 1
            idUsuario 1 Tiempo Total de acceso en el dia 1 mes 12
            ----------
            idUsuario N Tiempo total de acceso en el dia 1 mes 12
         ----------
         dia N
            idUsuario 1 Tiempo Total de acceso en el dia N mes 12
            ----------
            idUsuario N Tiempo total de acceso en el dia N mes 12
         Tiempo total acceso dia N mes 12
      Total tiempo de acceso mes 12
   Total tiempo de acceso año ___

   Se debe tener en cuenta las siguientes aclaraciones:
   - El año sobre el cual realizara el informa de accesos debe leerse desde teclado.
   - El año puede no existir en el archivo, en tal caso, debe informarse en pantalla "año no encontrado".
   - Debe definir las estructuras de datos necesarias.
   - El recorrido del archivo debe realizarse una unica vez procesando solo la informacion necesaria.
}


program Parcial1;

const
   valorAlto = 9999; // Valor alto para indicar fin de recorrido
type
   archivo = record
      anio: integer;
      mes: integer;
      dia: integer;
      idUsuario: integer;
      tiempoAcceso: real;
   end;
   archivoAccesos = file of archivo;


procedure leerArchivo(var archivoAcceso: archivoAccesos; var arc: archivo);
begin
   if (not eof(archivoAcceso)) then begin
      read(archivoAcceso, arc);
   end
   else begin
      arc.anio := valorAlto; // Indicamos que no hay más registros
   end;
end;

procedure imprimirInforme(var archivoAcceso: archivoAccesos);
var
   anio: integer;
   arc: archivo;
begin
   writeln('Ingrese el año para el informe:');
   readln(anio);

   reset(archivoAcceso);

   leerArchivo(archivoAcceso, arc);
   while (arc.anio < anio) do begin
      leerArchivo(archivoAcceso, arc);
   end;
   if (arc.anio = anio) then begin
      procesarInforme(archivoAcceso, arc);
   end
   else begin
      writeln('Año no encontrado.');
   end;
   close(archivoAcceso);
end;

procedure procesarInforme(var archivoAcceso: archivoAccesos; var arc: archivo);
var
   anioActual, mesActual, diaActual, idUsuarioActual: integer;
   tiempoAccesoAnio, tiempoAccesoMes, tiempoAccesoDia: real;
begin
   anioActual := arc.anio;
   tiempoAccesoAnio := 0;
   writeln('Año: ', anioActual);

   while (arc.anio = anioActual) do 
   begin
      mesActual := arc.mes;
      tiempoAccesoMes := 0;
      writeln('Mes: ', mesActual);

      while (arc.anio = anioActual) and (arc.mes = mesActual) do 
      begin
         diaActual := arc.dia;
         tiempoAccesoDia := 0;
         writeln('Dia: ', diaActual);

         while (arc.anio = anioActual) and (arc.mes = mesActual) and (arc.dia = diaActual) do 
         begin
            idUsuarioActual := arc.idUsuario;
            timepoAccesoUsuario := 0;

            while (arc.anio = anioActual) and (arc.mes = mesActual) and (arc.dia = diaActual) and (idUsuarioActual = arc.idUsuario) do 
            begin
               tiempoAccesoUsuario := tiempoAccesoUsuario + arc.tiempoAcceso;
               leerArchivo(archivoAcceso, arc);
            end;            
            writeln('IdUsuario: ', idUsuarioActual, ' Tiempo Total de acceso en el dia ', diaActual, ' mes ', mesActual, ': ', tiempoAccesoUsuario:2:2);
            tiempoAccesoDia := tiempoAccesoDia + tiempoAccesoUsuario;
         end;
         writeln('Tiempo Total acceso dia ', diaActual, ' mes ', mesActual, ': ', tiempoAccesoDia:2:2);
         tiempoAccesoMes := tiempoAccesoMes + tiempoAccesoDia;
      end;
      writeln('Total tiempo de acceso mes: ', mesActual, ': ', tiempoAccesoMes:2:2);
      tiempoAccesoAnio := tiempoAccesoAnio + tiempoAccesoMes;
   end;
   writeln ('Tiempo total de acceso del año: ',tiempoAccesoAnio:2:2); 
end;

var
   archivoAcceso: archivoAccesos;
BEGIN
   assign(archivoAcceso, 'accesos.dat');
   imprimirInforme(archivoAcceso);
	
END.

