program p1;
const
    dimF = 300;
type
    oficina = record
        codigo: integer;
        dni: integer;
        valor: real;
    end;

    vector = array [1..dimF] of oficina;

procedure generarVector (var v: vector ; var dimL: integer);

    procedure leerOficina (var o: oficina);
    begin
        writeln;
        write (' CODIGO DE OFICINA: ');
        read (o.codigo);
        if (o.codigo <> -1) then begin
            writeln;
            write (' DNI DE OFICINA: ');
            read (o.dni);
            writeln;
            write (' VALOR DE OFICINA: ');
            read (o.valor);
        end;
    end;

var
    o: oficina;
begin
    leerOficina (o);
    while (o.codigo <> -1) and (dimL <= dimF) do begin
        dimL:= dimL + 1;
        v[dimL]:= o;
        leerOficina (o);
    end;
end;

procedure ordenarVector (var v: vector ; dimL: integer);
var 
    i,j: integer;
    actual: oficina;
begin
    for i:= 2 to dimL do begin
        actual:= v[i];
        j:= i - 1;
        while (j > 0) and (v[j].codigo > actual.codigo) do begin
            v[j + 1]:= v[j];
            j:= j - 1;
        end;
        v[j + 1]:= actual;
    end;
end;

{procedure recorrerVector (v: vector ; dimL: integer);
var
    i: integer;
begin
    for i:= 1 to dimL do begin
        writeln (' CODIGO: ', v[i].codigo);
        writeln ('----------------------');
        writeln;

    end;
end;}

procedure busquedaDicotomica (v: vector ; dimL, cod: integer);

    procedure Buscar (v: vector ; dimL: integer ; cod: integer; var pos: integer);
    var 
        pri, ult, medio: integer;
    begin
        pri:= 1;
        ult:= dimL;
        medio:= (pri + ult) DIV 2;
        while (pri <= ult) and (cod <> v[medio].codigo) do begin
            if (cod < v[medio].codigo) then begin
                ult:= medio - 1;
            end
            else begin
                pri:= medio + 1;
                medio:= (pri + ult) DIV 2;
            end
        end;
        if (pri <= ult) then begin
            pos:= medio;
        end;
    end;

var
    pos: integer;
begin
    pos:= 0;
    Buscar (v, dimL, cod, pos);
    if (pos = 0) then begin
        writeln;
        writeln ('---EL CODIGO BUSCADO NO EXISTE---');
    end
    else begin
        writeln ('DNI: ', v[pos].dni);
        writeln;
        writeln;
        writeln ('VALOR: ', v[pos].valor);
        writeln ('----------');
    end
end;

procedure montoTotal (v: vector ; dimL: integer);

    procedure sumarValor (v: vector ; dimL: integer; var i: integer; var total: real);
    begin
        if (i < dimL) then begin
            i:= i + 1;
            total:= total + v[i].valor;
            sumarValor (v, dimL, i, total);
        end;
    end;

var 
    i: integer;
    total: real;
begin   
    i:= 0;
    total:= 0.0;
    sumarValor (v, dimL, i, total);
    writeln (' EL VALOR TOTAL DE TODAS LAS EXPENSAS ES: ', total);
end;

var
    v: vector;
    dimL, cod: integer;
begin
    dimL:= 0;
    generarVector (v, dimL);
    ordenarVector (v, dimL);
    {recorrerVector (v, dimL);} //COMPROBACION
    writeln;
    write (' INGRESE CODIGO A BUSCAR: ');
    read (cod);
    busquedaDicotomica (v, dimL, cod);
    montoTotal (v, dimL);

end.