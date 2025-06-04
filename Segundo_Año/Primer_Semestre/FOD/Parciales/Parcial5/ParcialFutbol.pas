program ParcialFutbol;
const
   valorAlto = 9999;
type
   partido = record
      codigoEquipo: integer;
      nombreEquipo: string;
      anio: integer;
      codigoTorneo: integer;
      codigoEquipoRival: integer;
      golesFavor: integer;
      golesContra: integer;
      puntosObtenidos: integer;
   end;
   archivoPartidos = file of partido;

procedure leerPartido(var archivo: archivoPartidos; var p: partido);
begin
   if (not eof(archivo)) then
   begin
      read(archivo, p);
   end
   else p.anio := valorAlto;
end;

procedure generarInforme(var archivo: archivoPartidos);
var
   p: partido;
   anioActual, codigoTorneoActual, codigoEquipoActual: integer; nombreEquipoActual: string; // variables de corte de control
   cantGolesFavor, cantGolesContra, diferenciaGol, cantPartidosGanados, cantPartidosPerdidos, cantPartidosEmpatados, cantTotalPuntos: integer;// contadores
   maxPuntos: integer; maxEquipo: string; // para el equipo con más puntos
begin
   reset(archivo);
   leerPartido(archivo, p);
   while (p.anio <> valorAlto) do 
   begin
      anioActual := p.anio
      writeln('Año: ', anioActual);
      while (p.anio = anioActual) do
      begin
         maxPuntos := -1;
         maxEquipo := '';
         codigoTorneoActual := p.codigoTorneo;
         writeln('Torneo: ', codigoTorneoActual);
         while (p.anio = anioActual) and (p.codigoTorneo = codigoTorneoActual) do
         begin
            codigoEquipoActual := p.codigoEquipo;
            nombreEquipoActual := p.nombreEquipo;
            
            cantGolesFavor := 0;
            cantGolesContra := 0;
            diferenciaGol := 0;
            cantPartidosGanados := 0;
            cantPartidosPerdidos := 0;
            cantPartidosEmpatados := 0;
            cantTotalPuntos := 0;

            writeln('Equipo: ', nombreEquipoActual, ' (Codigo: ', codigoEquipoActual, ')');
            while (p.anio = anioActual) and (p.codigoTorneo = codigoTorneoActual) and (p.codigoEquipo = codigoEquipoActual) do
            begin
               cantGolesFavor := cantGolesFavor + p.golesFavor;
               cantGolesContra := cantGolesContra + p.golesContra;
               diferenciaGol := cantGolesFavor - cantGolesContra;
               if (p.puntosObtenidos = 3) then
               begin
                  cantPartidosGanados := cantPartidosGanados + 1;
               end
               else if (p.puntosObtenidos = 0) then
               begin 
                  cantPartidosPerdidos := cantPartidosPerdidos + 1;
               end else cantPartidosEmpatados := cantPartidosEmpatados + 1;

               cantTotalPuntos := cantTotalPuntos + p.puntosObtenidos;

               leerPartido(archivo, p);
            end; // cambio de equipo
            writeln('cantidad total de goles a favor de ', nombreEquipoActual, ': ', cantGolesFavor);
            writeln('cantidad total de goles en contra de ', nombreEquipoActual, ': ', cantGolesContra);
            writeln('diferencia de goles de ', nombreEquipoActual, ': ', diferenciaGol);
            writeln('cantidad de partidos ganados de ', nombreEquipoActual, ': ', cantPartidosGanados);
            writeln('cantidad de partidos perdidos de ', nombreEquipoActual, ': ', cantPartidosPerdidos);
            writeln('cantidad de partidos empatados de ', nombreEquipoActual, ': ', cantPartidosEmpatados);
            writeln('cantidad total de puntos obtenidos por ', nombreEquipoActual, ': ', cantTotalPuntos);
            writeln('----------------------------------------');
            // calculo del equipo con más puntos de ese torneo
            if (cantTotalPuntos > maxPuntos) then
            begin
               maxPuntos := cantTotalPuntos;
               maxEquipo := nombreEquipoActual;
            end;
         end; // cambio de torneo
         writeln('El equipo: ', maxEquipo, ' fue campeon del torneo ', codigoTorneoActual, ' del año ', anioActual); // informo el campeon del torneo
         writeln('----------------------------------------');
      end;
   end;
   close(archivo);
end;


var
   archivo: archivoPartidos;
BEGIN
	assign(archivo, 'partidos.dat');
	generarInforme(archivo);
END.

