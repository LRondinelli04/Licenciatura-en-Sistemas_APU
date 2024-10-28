{
Realizar un programa que lea números hasta leer el valor 0 e imprima, para cada número leído, sus dígitos en el orden en que aparecen en el número. Debe implementarse un módulo recursivo que reciba el número e imprima lo pedido. Ejemplo si se lee el valor 256, se debe imprimir 2 5 6
}





program punto2;

procedure ImprimirRecursivo(var num:integer);
	var 
		digito: integer;
	begin 
		if (num <> 0) then begin
		digito:= num MOD 10; // guardo el ultimo digito
		num:= num DIV 10; // guardo el numero restante
		ImprimirRecursivo (num); // llamo antes al proceso recursivo para que despues para imprimir sea en orden
		writeln (digito);
		end;
	end;

var
	num: integer;
begin
	write('ingrese un numero: ');
	Read(num);
	while (num <> 0) do begin 
		ImprimirRecursivo(num);
		write('ingrese un numero: ');
		Read(num);
	end;

end.




