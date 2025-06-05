program ParcialAdministrador;
const 
   valorAlto = 99999;
type
   logs = record
      numeroUsuario: integer;
      nombreUsuario: string;
      nombre: string;
      apellido: string;
      cantEmail: integer;
   end;
   archivoLogs = file of logs;

   correo = record
      numeroUsuario: integer;
      cuentaDestino: string;
      cuerpoMensaje: string;
   end;
   archivoCorreo = file of correo;

procedure leerMail(var archivoMail: archivoCorreo, mail: correo);
begin
   if (not eof(archivoMail)) then
      read(archivoMail, mail)
   else mail.numeroUsuario := valorAlto;
end;

procedure procesarArchivo(var archivoLog: archivoLogs; var archivoMail: arhcivoCorreo);
var
   mail: correo; log: logs;
   cantMails: integer;
begin
   reset(archivoLog); reset(archivoMail);
   leerMail(archivoMail, mail);
   while (mail.numeroUsuario <> valorAlto) do begin
      read(archivoLog, log);
      while (log.numeroUsuario <> mail.numeroUsuario) and (not eof(archivoLog)) do begin
         read(archivoLog, log);
      end;

      cantMails := 0;
      while (log.numeroUsuario = mail.numeroUsuario) do begin
         cantMails := cantMails + 1;
         leerMail(archivoMail, mail);
         if (log.numeroUsuario <> mail.numeroUsuario) then break;
      end;

      // actualizo el archivo de logs
      seek(archivoLog, filepos(archivoLog) -1);
      log.cantEmail := log.cantEmail + cantMails;
      write(archivoLog, log);
   end;

   close(archivoLog); close(archivoMail);
end;

procedure generarListado(var archivoLog: archivoLogs);
var
   texto: Text;
   log: logs;
begin
   assign(texto, 'listado.txt');
   rewrite(texto);
   while (not eof(archivoLog)) do begin
      read(archivoLog, log);

      // escribo el archivo de texto
      writeln(texto, log.numeroUsuario, ' - ', log.nombreUsuario, ' : ', log.cantEmail);
   end;
   close(texto);
end;

var
   archivoLog: archivoLogs;
   archivoMail: archivoCorreo;
   opcion: integer;
BEGIN
	assign(archivoLog, '/var/log/logsmail.dat');
   assign(archivoMail, '6junio2017.dat');
   writeln('1. Actualizar log');
   writeln('2. Generar listado');
   writeln('0. Salir');
   readln(opcion);
   case opcion of
      1: procesarArchivo(archivoLog, archivoMail);
      2: generarListado(archivoLog);
   end;
END.

