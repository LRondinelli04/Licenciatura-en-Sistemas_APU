{Implementar un programa que contenga:
a. Un módulo que lea información de alumnos de Taller de Programación y almacene en una estructura de datos sólo a aquellos alumnos que posean año de ingreso posterior al 2010. De cada alumno se lee legajo, DNI y año de ingreso. La estructura generada debe ser eficiente para la búsqueda por número de legajo. 
b. Un módulo que reciba la estructura generada en a. e informe el DNI y año de ingreso de aquellos alumnos cuyo legajo sea inferior a un valor ingresado como parámetro. 
c. Un módulo que reciba la estructura generada en a. e informe el DNI y año de ingreso de aquellos alumnos cuyo legajo esté comprendido entre dos valores que se reciben como parámetro. 
d. Un módulo que reciba la estructura generada en a. y retorne el DNI más grande.
e. Un módulo que reciba la estructura generada en a. y retorne la cantidad de alumnos con legajo impar.
}

program p3;

type
    alumno = record
        legajo: integer;
        dni: integer;
        ingreso: integer;
    end;

    arbol = ^nodo;
    nodo = record
        dato: alumno;
        HI: arbol;
        HD: arbol;
    end;


procedure generarArbol (var a: arbol);

    procedure leerAlumno (var al: alumno);
    begin
        writeln (' INGRESE EL NUMERO DEL LEGAJO ');
        readln (al.legajo);
        {al.legajo:= Random (300);}
        writeln (' INGRESE EL NUMERO DE DNI ');
        readln (al.dni);
        {al.dni:= Random (300);}
        writeln (' INGRESE EL AÑO DE INGRESO ');
        readln (al.ingreso)
        {al.ingreso:= Random (2100);}
    end;

    procedure insertarEnArbol (var a: arbol ; al: alumno);
    begin
        if (a = nil) then begin
            new (a);
            a^.dato:= al;
            a^.HI:= nil;
            a^.HD:= nil;
        end
        else begin
            if (a^.dato.legajo < al.legajo) then begin
                insertarEnArbol (a^.HI, al);
            end
            else begin
                insertarEnArbol (a^.HD, al);
            end
        end
    end;

var 
    al: alumno;
begin
    a:= nil;
    leerAlumno (al);
    while (al.ingreso < 2010) do begin
        insertarEnArbol (a, al);
        writeln;
        leerAlumno (al);
    end;
end;

procedure informarArbol (a: arbol);
begin
    if (a <> nil) then begin
        writeln;
        writeln (' LEGAJO: ', a^.dato.legajo);
        writeln;
        writeln (' DNI: ', a^.dato.dni);
        writeln;
        writeln (' INGRESO: ', a^.dato.ingreso);
        writeln;
        writeln ('------------------');
        informarArbol (a^.HI);
        informarArbol (a^.HD);
    end;
end;

procedure legajoMenor (a: arbol);
    
    procedure buscar (a: arbol ; num: integer);
    begin
        if (a <> nil) then begin
            if (a^.dato.legajo > num) then begin
                buscar (a^.HD, num);
            end
            else begin
                writeln;
                writeln (' LEGAJO PARA COMPROBAR: ', a^.dato.legajo);
                writeln;
                writeln (' DNI: ', a^.dato.dni);
                writeln;
                writeln (' INGRESO: ', a^.dato.ingreso);
                writeln;
                writeln ('------------------');
                buscar (a^.HI, num);
                buscar (a^.HD, num);
            end
        end;
    end;


var
    num: integer;
begin
    writeln;
    write ('---INGRESE EL LEGAJO PARA INFORMAR LOS MENORES---> ');
    read (num);
    if (a <> nil) then 
        buscar (a, num)
    else 
        writeln (' EL ARBOL ESTA VACIO ');
    writeln;
    writeln ('---------------------------------------------------');
end;

procedure alumnosEntreValores (a: arbol);

    procedure buscarAlumno (a: arbol ; inf, sup: integer);
    begin
        if (a <> nil) then begin
            if (a^.dato.legajo >= inf) and (a^.dato.legajo <= sup) then begin
                writeln;
                writeln (' DNI: ', a^.dato.dni);
                writeln;
                writeln (' INGRESO: ', a^.dato.ingreso);
                writeln;
                writeln ('------------------');
                buscarAlumno (a^.HI, inf, sup);
                buscarAlumno (a^.HD, inf, sup);
            end
            else 
                begin
                    if (a^.dato.legajo > inf) then begin
                        buscarAlumno (a^.HI, inf, sup);
                    end
                    else 
                        begin
                            if (a^.dato.legajo < sup) then begin
                                buscarAlumno (a^.HD, inf, sup);
                            end;
                        end
                end;
        end;
    end;

var 
    inf, sup: integer;
begin
    writeln;
    writeln;
    write (' ---INGRESE EL VALOR INFERIOR PARA BUSCAR---> ');
    read (inf);
    writeln;
    write (' ---INGRESE EL VALOR SUPERIOR PARA BUSCAR---> ');
    read (sup);
    writeln;
    buscarAlumno (a, inf, sup);
end;

procedure dniMax (a: arbol);

    procedure recorrerArbol (a: arbol ; var max: integer);
    begin
        if (a <> nil) then begin
            if (a^.dato.dni >= max) then begin
                max:= a^.dato.dni;
            end;
            recorrerArbol (a^.HI, max);
            recorrerArbol (a^.HD, max);
        end;
    end;

var 
    max: integer;
begin
    max:= 0;
    writeln;
    writeln (' ---CALCULO DEL DNI MAX---> ');
    recorrerArbol (a, max);
    writeln;
    writeln (' EL MAXIMO DNI ES: ', max);
    writeln;
    writeln ('----------------------------');
end;

procedure legajoImpar (a: arbol ; var cant: integer);
begin
    if (a <> nil) then begin
        if (a^.dato.legajo MOD 2 = 1) then begin
            cant:= cant + 1;
        end;
        legajoImpar (a^.HI, cant);
        legajoImpar (a^.HD, cant);
    end;
end;

var
    a: arbol;
    cant: integer;
begin
    Randomize;
    generarArbol (a); // (A)
    informarArbol (a); // COMPROBACION
    legajoMenor (a); //(B)
    alumnosEntreValores (a); // (C)
    dniMax (a); // (D)
    cant:= 0;
    legajoImpar (a, cant); // (E)
    writeln;
    writeln ('---CANTIDAD DE ALUMNOS CON LEGAJO IMPAR--->');
    writeln;
    writeln (cant);
    writeln;
end.