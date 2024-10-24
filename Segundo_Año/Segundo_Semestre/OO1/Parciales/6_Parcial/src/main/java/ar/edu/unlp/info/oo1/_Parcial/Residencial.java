package ar.edu.unlp.info.oo1._Parcial;

import java.util.List;

public class Residencial extends Cliente {


	private String apellido;
	
	public Residencial(String nombre, String apellido ,String domicilio) {
		super(nombre, domicilio);
		this.apellido = apellido;
	}

	@Override
	public double calcularMontoAFacturar(int mes, int anio, Tarifa tarifa) {
		Medicion medicionActual = this.obtenerConsumo(mes, anio);
        if (medicionActual == null) return 0; 

        double consumoActual = medicionActual.getConsumo();
        double monto = consumoActual * tarifa.getPrecioUnidadCliente();

        Medicion medicionAnioAnterior = this.obtenerConsumo(mes, anio-1);
        if (medicionAnioAnterior == null || consumoActual < medicionAnioAnterior.getConsumo()) {
            monto *= 0.90;
        }

        return monto;
	}




	
	
}
