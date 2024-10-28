{Escribir un programa que:
a. Implemente un módulo recursivo que genere una lista de números enteros “random” mayores a 0 y menores a 100. Finalizar con el número 0.
b. Implemente un módulo recursivo que devuelva el mínimo valor de la lista.
c. Implemente un módulo recursivo que devuelva el máximo valor de la lista.
d. Implemente un módulo recursivo que devuelva verdadero si un valor determinado se encuentra en la lista o falso en caso contrario.}
program p3;

type

lista = ^nodo;
nodo = record
	dato: integer;
	sig: lista;
end;

procedure generarLista (var l: lista);
	procedure agregarEnLista (var l: lista ; num: integer);
	var
		aux: lista;
	begin
		new (aux);
		aux^.dato:= num;
		aux^.sig:= l;
		l:= aux;
	end;
	
var
		num: integer;
begin
	num:= Random (100);
	if (num <> 0) then begin
		agregarEnLista (l, num);
		generarLista (l);
	end;
end;

procedure recorrerLista (l: lista);
begin
	while (l <> nil) do begin
		writeln (l^.dato);
		l:= l^.sig;
	end;
end;

function minLista(l: lista ; var min: integer): integer;
begin
	if (l <> nil) then begin
        if (l^.dato < min) then begin
            min:= l^.dato;
	    end;
        minLista:= minLista (l^.sig, min);
    end;
    minLista:= min;
end;

function maxLista(l: lista ; var max: integer): integer;
begin
	if (l <> nil) then begin
        if (l^.dato > max) then begin
            max:= l^.dato;
	    end;
        maxLista:= maxLista (l^.sig, max);
    end;
    maxLista:= max;
end;

function buscarValor (l: lista ; num: integer): boolean;
begin
    begin
    If (l = nil) then
      buscarValor:= false
    else
    begin
      If (l^.dato = num) then
        buscarValor:= true
      else
        buscarValor:= buscarValor (l^.sig, num);
    end;
  end;

end;

var
	l: lista;
	minimo, min, max, maximo, num: integer;
    ok: boolean;
BEGIN
	Randomize;
	generarLista (l); // (A)
	recorrerLista (l); // COMPROBACION
    min:= 999;
	minimo:= minLista (l, min); // (B)
    writeln;
	writeln(' EL VALOR MINIMO DE LA LISTA ES: ', minimo);
    writeln;
    max:= -999;
    maximo:= maxLista (l, max); // (C)
	writeln (' ----------------------------------');
    writeln;
	writeln(' EL VALOR MAXIMO DE LA LISTA ES: ', maximo);
    writeln;	
    writeln (' INGRESE EL VALOR A BUSCAR: ');
    readln (num);
    ok:= buscarValor (l, num);
    if (ok = true) then begin
        writeln;
        writeln (' ---VERDADERO--- ');
        writeln;
    end
    else
        begin
            writeln;
            writeln (' ---FALSO--- ');
            writeln;
        end
END.


