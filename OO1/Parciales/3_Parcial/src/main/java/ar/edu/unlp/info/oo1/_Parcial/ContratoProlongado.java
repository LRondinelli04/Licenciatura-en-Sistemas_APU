package ar.edu.unlp.info.oo1._Parcial;

import java.time.LocalDate;

public class ContratoProlongado extends Contrato{

	private LocalDate fechaInicial;
	private int cantDias;
	
	public ContratoProlongado(Cliente cliente, Servicio servicio, LocalDate fechaInicial, int cantDias) {
		super(cliente, servicio);
		this.fechaInicial = fechaInicial;
		this.cantDias = cantDias;
	}

	@Override
	public double calcularMonto() {
		double monto = this.servicio.montoAbonar() * this.cantDias;
		if (this.contratoCincoDias()) {
			double descuento = monto * 0.1;
			monto -= descuento;
		}
		return monto;
	}

	public boolean contratoCincoDias() {
		if (this.cantDias > 5) {
			return true;
		} else {
			return false;
		}
	}

	
}
