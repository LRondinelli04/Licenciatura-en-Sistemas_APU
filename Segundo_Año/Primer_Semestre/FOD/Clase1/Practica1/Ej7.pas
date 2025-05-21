{
    Realizar un programa que permita: 
        a)  Crear un archivo binario a partir de la información almacenada en un archivo de 
        texto.  El  nombre  del  archivo  de  texto  es:  “novelas.txt”.  La  información  en el 
        archivo de texto consiste en: código   de novela, nombre, género y precio de 
        diferentes novelas argentinas. Los datos de cada novela se almacenan en dos 
        líneas en el archivo de texto. La primera línea contendrá la siguiente información: 
        código novela, precio y género, y la segunda línea almacenará el nombre de la 
        novela. 
        b)  Abrir  el  archivo  binario  y  permitir  la  actualización del mismo. Se debe poder 
        agregar  una  novela  y modificar una existente. Las búsquedas se realizan por 
        código de novela.
   
   
}


program Ej7;

type
    novela = record
        codigo: integer;
        nombre: string;
        genero: string;
        precio: real;
    end;
    archivo = file of novela;

procedure crearArchivo(var arcLogico: archivo; var text: Text);
var
    n: novela;
begin
    while (not eof(text)) do begin
        readln(text, n.codigo, n.precio, n.genero);
        readln(text, n.nombre);
        write(arcLogico, n);
    end;
end;

procedure cambiarOAgregar(var arcLogico: archivo);
var 
    codigo: integer;
begin
    writeln('Ingrese 1 si quiere agregar una novela o 2 si quiere modificar una existente: ');
    readln(codigo);
    if (codigo = 1) then begin
        agregarNovela(arcLogico);
    end 
    else begin
        writeln('Ingrese el codigo de la novela que quiere modificar: ');
        readln(codigo);
        modificarNovela(arcLogico, codigo);
    end;   
end;

procedure agregarNovela(var arcLogico: archivo);
var
    n: novela;
begin
    writeln('Ingrese los datos correspondientes a la novela: ');
    writeln();
    writeln('Codigo: ');
    readln(n.codigo);
    writeln('Nombre: ');
    readln(n.nombre);
    writeln('Genero: ');
    readln(n.genero);
    writeln('Precio: ');
    readln(n.precio);

    seek(arcLogico, fileSize(arcLogico)); // me posiciono al final del archivo
    write(arcLogico, n); // escribo el nuevo registro
    writeln('Registro agregado con exito');

end;

procedure modificarNovela(var arcLogico: archivo; codigo: integer);
var
    n: novela;
    encontrado: boolean;
begin
    encontrado := false;
    while(not eof(arcLogico) and (encontrado = false)) do begin
        read(arcLogico, n);
        if (n.codigo = codigo) then begin
            encontrado := true;
            writeln('Datos de la novela: ');
            writeln('Codigo: ', n.codigo, ' Nombre: ', n.nombre , ' Precio: ', n.precio, ' Genero: ', n.genero);
            
            
            writeln('Ingrese el nuevo nombre de la novela: ');
            readln(n.nombre);
            writeln('Ingrese el nuevo precio de la novela: ');
            readln(n.precio);
            writeln('Ingrese el nuevo género de la novela: ');
            readln(n.genero);

            seek(arcLogico, filepos(arcLogico) - 1); // me posiciono en el registro que quiero modificar
            write(arcLogico, n); // escribo el nuevo registro
            writeln('Registro modificado con exito');
        end;
    end;
end;

var
    text: Text; // archivo de texto ya existente
    arcLogico: archivo; // archivo binario a crear

BEGIN
	assign(text, 'novelas.txt');
    assign(arcLogico, 'archivoLogico');

    reset(text); // lectura
    rewrite(arcLogico); // creo el archivo binario

    crearArchivo(arcLogico, text);
    writeln('Archivo binario creado con exito');
    close(text); close(arcLogico);

    reset(arcLogico);
    cambiarOAgregar(arcLogico);
    close(arcLogico);
    writeln('Archivo binario actualizado/creado con exito');
	
END.

