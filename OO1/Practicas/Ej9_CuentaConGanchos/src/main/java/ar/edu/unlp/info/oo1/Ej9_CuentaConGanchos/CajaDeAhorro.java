package ar.edu.unlp.info.oo1.Ej9_CuentaConGanchos;

public class CajaDeAhorro extends Cuenta{
	
	public CajaDeAhorro() {
	}
	
	public void depositar(double monto) {
		double costoAdicional = monto * 2 / 100;
		super.depositar(monto - costoAdicional);
	}
	
	public boolean extraer(double monto) {
		double costoAdicional = monto * 2 / 100;
		if (this.puedeExtraerMonto(monto + costoAdicional)) {			
			super.extraerSinControlar(monto + costoAdicional);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean trasnferirACuenta(double monto, Cuenta cuentaDestino) {
		double costoAdicional = monto * 2 / 100;
		if (this.puedeExtraerMonto(monto + costoAdicional)) {
			super.extraer(monto, cuentaDestino);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean puedeExtraerMonto(double monto) {
		// double costoAdicional = monto * 2 / 100;
		// ya estoy contando en el monto el costoAdicional
		if (monto > super.getSaldo()) {
			return true;
		} else {
			return false;
		}
	}
	
	

	
	
}
