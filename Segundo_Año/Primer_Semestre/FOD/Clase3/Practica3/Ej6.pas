{
   Una cadena de tiendas de indumentaria posee un archivo maestro no ordenado con 
   la información correspondiente a las prendas que se encuentran a la venta. De cada 
   prenda  se  registra:  cod_prenda,  descripción,  colores,  tipo_prenda,  stock  y 
   precio_unitario.  Ante  un  eventual  cambio  de  temporada,  se  deben  actualizar  las 
   prendas  a la venta. Para ello reciben un archivo conteniendo: cod_prenda de las 
   prendas que quedarán obsoletas. Deberá implementar un procedimiento que reciba 
   ambos archivos y  realice la baja lógica de las prendas, para ello deberá modificar el 
   stock de la prenda correspondiente a valor negativo. 

   Adicionalmente,  deberá  implementar  otro  procedimiento  que  se  encargue  de 
   efectivizar  las  bajas  lógicas  que  se  realizaron  sobre  el  archivo  maestro  con  la 
   información  de  las  prendas  a  la  venta.  Para  ello  se deberá utilizar una estructura 
   auxiliar (esto es, un archivo nuevo),  en el cual se copien únicamente aquellas prendas 
   que no están marcadas como borradas. Al finalizar este proceso de compactación 
   del archivo, se deberá renombrar el archivo nuevo con el nombre del archivo maestro 
   original. 
}


program Ej6;

type
   prenda = record
      cod_prenda: integer;
      descripcion: string;
      colores: string;
      tipo_prenda: string;
      stock: integer; // cambiar a negativo si el codigo es obsoleto
      precio_unitario: real;
   end;
   archivoMaestro = file of prenda; // archivo con info

   prenda_obsoleta = record
      cod_prenda: integer;
   end;
   archivoDetalle = file of prenda_obsoleta; // archivo con prendas obsoletas

procedure actualizarStock(var maestro: archivoMaestro; var detalle: archivoDetalle);
var
   obsoleta: prenda_obsoleta;
   prenda: prenda;
begin
   while (not eof(detalle)) do begin
      read(detalle, obsoleta);
      reset(maestro); // reiniciamos el maestro para leer desde el principio
      while (not eof(maestro)) do begin
         read(maestro, prenda);
         if (prenda.cod_prenda = obsoleta.cod_prenda) then begin
            prenda.stock := prenda.stocl * -1;
            seek(maestro, filepos(maestro) -1);
            write(maestro, prenda);
            break; // salimos del while interno para leer la siguiente obsoleta
         end;
      end;
   end;
end;

var
   maestro: archivoMaestro;
   detalle: archivoDetalle;
BEGIN
	assign(maestro, 'prendas'); assign(detalle, 'obsoletas');
   reset(maestro); reset(detalle); // ambos archivos con informacion
   actualizarStock(maestro, detalle);
   close(maestro); close(detalle);
	
END.

