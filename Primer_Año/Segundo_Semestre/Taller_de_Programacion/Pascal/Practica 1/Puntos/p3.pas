{Netflix ha publicado la lista de películas que estarán disponibles durante el mes de diciembre de 2022. De cada película se conoce: código de película, código de género (1: acción, 2: aventura, 3: drama, 4: suspenso, 5: comedia, 6: bélica, 7: documental y 8: terror) y puntaje promedio otorgado por las críticas. 
Implementar un programa modularizado que:
a. Lea los datos de películas y los almacene por orden de llegada y agrupados por código de género, en una estructura de datos adecuada. La lectura finaliza cuando se lee el código de la película -1. 
b. Una vez almacenada la información, genere un vector que guarde, para cada género, el código de película con mayor puntaje obtenido entre todas las críticas.
c. Ordene los elementos del vector generado en b) por puntaje utilizando alguno de los dos métodos vistos en la teoría. 
d. Luego de ordenar el vector, muestre el código de película con mayor puntaje y el código de película con menor puntaje.
}

program p3;

const
	dimF = 8;

type
	gen = 1..8;

	pelicula = record
		codigoP: integer;
		codigoG: gen;
		puntaje: real;
	end;

	lista = ^nodo;
	nodo = record
		dato: pelicula;
		sig: lista;
	end;

	vector =  array [gen] of lista;

	vector2 = array [gen] of integer;

procedure iniciarVector (var v: vector);
var
	i: integer;
begin
	for i:= 1 to dimF do begin
		v[i]:= nil;
	end;
end;

procedure agregarPelicula (var l: lista ; p: pelicula);
var
	aux: lista;
begin
	new (aux);
	aux^.dato:= p;
	aux^.sig:= l;
	l:= aux;
end;

procedure leerPelicula (var p: pelicula);
begin
    Randomize;
	writeln (' INGRESE CODIGO PELICLA');
	readln (p.codigoP);
	if (p.codigoP <> -1) then begin
		writeln (' INGRESE genero PELICLA');
		p.codigoG:= random (8) + 1;
		writeln (' INGRESE puntaje PELICLA');
		p.puntaje:= random (10);
	end;
end;

procedure iniciarVector2 (var v2: vector2);
var
	i: integer;
begin
	for i:= 1 to dimF do begin
		v2[i]:= 0;
	end;
end;

procedure calcularMax (l: lista ; var codMax: integer);
var
	puntMax: real;
begin
	puntMax:= -999;
	while (l <> nil) do begin
		if (l^.dato.puntaje > puntMax) then begin
			puntMax:= l^.dato.puntaje;
			codMax:= l^.dato.codigoP;
		end;
		l:= l^.sig;
		end;
end;

procedure generarVector2 (v1: vector ; var v2: vector2; dimL: integer);
var
	i, codMax: integer;
begin
	for i:= 1 to dimL do begin
		calcularMax (v1[i], codMax);
		v2[i]:= codMax;
	end;
end;

procedure generarVector (var v: vector; var dimL: integer);
var
	p: pelicula;
begin
    dimL:= 0;
	leerPelicula (p);
	while (p.codigoP <> -1) do begin
        dimL:= dimL + 1;
		agregarPelicula (v[p.codigoP], p);
		leerPelicula (p);
	end;
end;

procedure ordenarVector (var v2: vector2 ; dimL: integer);
var
	i, j, actual: integer;
begin
	for i:= 2 to dimL do begin
		actual:= v2[i];
		j:= i-1;
		while (j > 0) and (v2[j] > actual) do begin
			v2[j + 1]:= v2[j];
			j:= j - 1;
		end;
		v2[j + 1]:= actual;
	end;
end;




procedure recorrerVector (l: lista);
begin
      while (l <> nil) do begin
        writeln ('--------');
        writeln (' CODIGO: ', l^.dato.codigoP);
        writeln ('--------');
        writeln ('--------');
        writeln (' GENERO: ', l^.dato.codigoG);
        writeln ('--------');
        writeln ('--------');
        writeln (' PUNTAJE: ', l^.dato.puntaje);
        writeln ('--------');
        l:= l^.sig;
    end;
end;

procedure recorrerVector2 (v: vector2; dimL: integer);
var
    i: integer;
begin
  for i:= 1 to dimL do begin
    writeln ('------');
    writeln (v[i]);
    writeln ('------');
  end;
end;

procedure calcularMaxyMin (l: lista ; var max: integer; var min: integer ; var maxPunt: real ; var minPunt: real);
begin
    maxPunt:= -999.9;
    minPunt:= 999.9;
    while (l <> nil) do begin
      if (l^.dato.puntaje > maxPunt) then begin
        maxPunt:= l^.dato.puntaje;
        max:= l^.dato.codigoP;
      end;
      if (l^.dato.puntaje < minPunt) then begin
        minPunt:= l^.dato.puntaje;
        min:= l^.dato.codigoP;
      end;
    end;
end;

var
	v1: vector;
	v2: vector2;
    i, max, min, dimL: integer;
    maxPunt, minPunt: real;
BEGIN
	iniciarVector (v1);
	generarVector (v1, dimL); // (A)
    for i:= 1 to dimF do begin
        recorrerVector (v1[i]); // COMPROBACION
	end;
    iniciarVector2 (v2);
	generarVector2 (v1, v2, dimL); // (B)
	ordenarVector (v2, dimL); // (C)}
    writeln (' ---ORDEN DEL SEGUNDO VECTOR--- ');
    recorrerVector2 (v2, dimL); // COMPROBACION
    {for i:= 1 to dimF do begin
        calcularMaxyMin (v1[i], max, min, maxPunt, minPunt); //CORREGIR 
	end;
    writeln ('----------------------------------');
    writeln ('LA PELICULA CON MEJOR PUNTUACION ES: ', max, ' Y LA PELICULA CON MENOR PUNTUACION ES: ', min);
    }
END.
