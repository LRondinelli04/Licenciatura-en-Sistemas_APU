{
    Suponga que trabaja en una oficina donde está montada una  LAN (red local). La misma fue 
    construida  sobre  una  topología  de  red  que  conecta  5  máquinas  entre  sí  y  todas  las 
    máquinas  se  conectan  con  un  servidor  central.  Semanalmente  cada  máquina  genera un 
    archivo de logs informando las sesiones abiertas por cada usuario en cada terminal y por 
    cuánto  tiempo  estuvo  abierta.  Cada  archivo  detalle  contiene  los  siguientes  campos: 
    cod_usuario, fecha, tiempo_sesion. Debe realizar un procedimiento que reciba los archivos 
    detalle  y  genere  un  archivo  maestro  con  los  siguientes  datos:  cod_usuario,  fecha, 
    tiempo_total_de_sesiones_abiertas. 
    Notas: 
        ●  Cada archivo detalle está ordenado por cod_usuario y fecha. 
        ●  Un  usuario  puede  iniciar  más de una sesión el mismo día en la misma máquina, o 
        inclusive, en diferentes máquinas.  
        ●  El archivo maestro debe crearse en la siguiente ubicación física:  /var/log.
   
}

(* 
    Paso a paso:
    
    1. Definir tipos y constantes
        - Definí los registros para detalle y maestro.
        - Definí la cantidad de archivos detalle (cantDetalles), el valor alto y los arrays necesarios.
    
    2. Abrir y preparar archivos detalle
        - Abrí los 5 archivos detalle y leé el primer registro de cada uno, guardando cada registro en un array de registros.

    3. Procedimiento mínimo
        - Implementá un procedimiento que busque el registro con el menor código de usuario y, en caso de empate, la menor fecha entre los registros actuales de los 5 archivos detalle.
        - Cada vez que se selecciona un registro como mínimo, se lee el siguiente registro del archivo correspondiente y se actualiza el array de registros.

    4. Merge y acumulación
        - Mientras el mínimo no sea valor alto:
            - Guardá el código de usuario y la fecha actuales.
            - Inicializá el acumulador de tiempo total.
            - Mientras el mínimo tenga el mismo código de usuario y fecha, sumá el tiempo de sesión y buscá el siguiente mínimo.
            - Cuando cambie el usuario o la fecha, escribí en el maestro el registro con el usuario, la fecha y el tiempo total acumulado.
    
    5. Cerrar archivos
        - Cerrá todos los archivos detalle y el maestro.
 *)


program Ej5;

const
    cantDetalles = 5; // Cantidad de archivos detalle (1 por maquina)
    valorAlto = 999999; // Valor alto para indicar fin de archivo

type
    detalle = record
        cod_usuario: integer;
        fecha: string; 
        tiempo_sesion: integer;
    end;
    archivoDetalle = file of detalle;

    maestro = record
        cod_usuario: integer;
        fecha: string; 
        tiempo_total_de_sesiones_abiertas: integer;
    end;
    archivoMaestro = file of maestro;

    arrayDetalles = array[1..cantDetalles] of archivoDetalle; // Array que contiene los archivos detalle
    arrayRegistros = array[1..cantDetalles] of detalle; // Array que contiene los registros actuales de cada archivo detalle

// -----------------------------------------------------------------------------
// Lee el siguiente registro de un archivo detalle. Si termina, pone valorAlto.
// -----------------------------------------------------------------------------
procedure leer(var archivo: archivoDetalle; var reg: detalle);
begin
    if (not eof(archivo)) then
        read(archivo, reg)
    else
        reg.cod_usuario := valorAlto; // Marco que este archivo ya no tiene mas datos (esta ordenado por cod_usuario)
end;

// -----------------------------------------------------------------------------
// Inicializa los archivos detalle y lee el primer registro de cada uno.
// -----------------------------------------------------------------------------
procedure inicializarDetalles(var vecDetalles: arrayDetalles; var vecRegistros: arrayRegistros);
var
    i: integer;
    nombreArchivo: string;
begin
    for i := 1 to cantDetalles do
    begin
        str(i, nombreArchivo); // Convertir i a string
        Assign(vecDetalles[i], 'detalle' + nombreArchivo + '.dat'); // Asignar nombre de archivo
        Reset(vecDetalles[i]); // Abrir archivo en modo lectura
        leer(vecDetalles[i], vecRegistros[i]); // Leer primer registro
    end;
end;

// -----------------------------------------------------------------------------
// Cierra todos los archivos detalle.
// -----------------------------------------------------------------------------
procedure cerrarDetalles(var vecDetalles: arrayDetalles);
var
    i: integer;
begin
    for i:= 1 to cantDetalles do 
    begin
        close(vecDetalles[i]); // Cerrar archivo
    end;
end;

// -----------------------------------------------------------------------------
// Busca el registro mínimo entre los actuales de los detalles (por cod_usuario y fecha).
// Cuando lo encuentra, lee el siguiente registro de ese archivo.
// -----------------------------------------------------------------------------
procedure minimo(var vecDetalles: arrayDetalles; var vecRegistros: arrayRegistros; var min: detalle);
var 
    i, indiceMin: integer;
begin
    min.cod_usuario := valorAlto;
    min.fecha := '999999'
    indiceMin := -1;
    for i := 1 to cantDetalles do 
    begin
        // Comparar por cod_usuario, si el cod_usuario es igual que el minimo, comparar por fecha
        if (vecRegistro[i].cod_usuario < min.cod_usuario) or ((vecRegistro[i].cod_usuario = min.cod_usuario) and (vecRegistro[i].fecha < min.fecha)) then begin
            min := vecRegistros[i]; // Actualizar el mínimo
            indiceMin := i; // Guardar el índice del archivo que tiene el mínimo
        end;
    end;
    if (indiceMin <> -1) then begin // Si se encontró un mínimo
        leer(vecDetalles[indiceMin], vecRegistros[indiceMin]); // Leer el siguiente registro del archivo que tenía el mínimo
    end;
end;

// -----------------------------------------------------------------------------
// Crea el archivo maestro haciendo el merge múltiple y acumulando los tiempos.
// -----------------------------------------------------------------------------
procedure crearMaestro(var maestro: archivoMaestro; var vecDetalles: arrayDetalles; var vecRegistros: arrayRegistros);
var
    min: detalle;
    usuarioActual, tiempoTotal: integer; // codigo de usuario
    fechaActual: string; // fecha actual
    regMaestro: maestro; // registro maestro para ir cargando en archivo maestro
begin
    assign(maestro, '/var/log/maestro.dat'); // Asignar nombre de archivo maestro
    rewrite(maestro); // Crear el archivo maestro 

    minimo(becDetalles, vecRegistros, min); // Leer el primer mínimo
    while (min.cod_usuario <> valorAlto) do begin // mientras que los archivos devuelvan un minimo
        usuarioActual := min.cod_usuario;
        while (usuarioActual = min.cod_usuario) do begin
            // Acumular el tiempo de sesiones abiertas por el usuario
            tiempoTotal := 0;
            fechaActual := min.fecha;
            while (usuarioActual = min.cod_usuario) and (fechaActual = min.fecha) do begin
                tiempoTotal := tiempoTotal + min.tiempo_sesion; // Acumular el tiempo de sesiones abiertas
                minimo(vecDetalles, vecRegistros, min); // Leer el siguiente mínimo de los archivos
            end;
            // guardar la información en el maestro
            regMaestro.cod_usuario := usuarioActual;
            regMaestro.fecha := fechaActual;
            regMaestro.tiempo_total_de_sesiones_abiertas := tiempoTotal;
            write(maestro, regMaestro); // Escribir en el archivo maestro
        end;
    end;
    // Cerrar el archivo maestro
    close(maestro);
    // Cerrar todos los archivos detalle
    cerrarDetalles(vecDetalles);
end;

// -----------------------------------------------------------------------------
// Imprime el archivo maestro para control.
// -----------------------------------------------------------------------------
procedure imprimirMaestro(var maestro: archivoMaestro);
var
    regMaestro: maestro;
begin
    reset(maestro); // Abrir el archivo maestro en modo lectura
    while (not eof(maestro)) do begin
        read(maestro, regMaestro); // Leer el registro maestro
        writeln('Usuario: ', regMaestro.cod_usuario, ' Fecha: ', regMaestro.fecha, ' Tiempo total de sesiones abiertas: ', regMaestro.tiempo_total_de_sesiones_abiertas);
    end;
    close(maestro); // Cerrar el archivo maestro
end;

var
    maestro: archivoMaestro; // Archivo maestro
    vecDetalles: arrayDetalles; // Array de archivos detalle
    vecRegistros: arrayRegistros; // Array de registros actuales de cada archivo detalle

BEGIN
	inicializarDetalles(vecDetalles, vecRegistros); // Inicializar los archivos detalle y leer el primer registro
    crearMaestro(maestro, vecDetalles, vecRegistros); // Crear el archivo maestro
    imprimirMaestro(maestro); // Imprimir el archivo maestro para control
END.

