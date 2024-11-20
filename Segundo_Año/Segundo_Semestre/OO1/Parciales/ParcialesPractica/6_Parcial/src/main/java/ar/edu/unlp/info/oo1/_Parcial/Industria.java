package ar.edu.unlp.info.oo1._Parcial;

import java.util.List;

public class Industria extends Cliente {

	public Industria(String nombre, String domicilio) {
		super(nombre, domicilio);
	}

	@Override
	public double calcularMontoAFacturar(int mes, int anio, Tarifa tarifa) {
		Medicion medicionActual = this.obtenerConsumo(mes, anio);
        if (medicionActual == null) return 0;

        double consumoActual = medicionActual.getConsumo();
        double monto = consumoActual * tarifa.getPrecioUnidadIndustria();

        System.out.println(monto);
        
        Medicion medicionAnterior;
        if (mes == 1) {
            medicionAnterior = this.obtenerConsumo(12, anio-1);
        } else {
        	medicionAnterior = this.obtenerConsumo(mes-1, anio);
        }

        if (medicionAnterior != null && consumoActual < medicionAnterior.getConsumo()) {
            monto *= 0.98;
        }

        return monto;
	}


	
}
