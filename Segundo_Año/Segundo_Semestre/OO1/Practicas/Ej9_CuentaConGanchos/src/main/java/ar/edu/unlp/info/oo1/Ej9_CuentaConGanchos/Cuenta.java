package ar.edu.unlp.info.oo1.Ej9_CuentaConGanchos;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public abstract class Cuenta {
	
	private double saldo;
	
	public Cuenta() {
		this.saldo = 0;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	public void depositar(double monto) {
		this.saldo += monto;
	}
	public void extraerSinControlar(double monto) {
		this.saldo -= monto;
	}
	public boolean extraer(double monto, Cuenta cuentaDestino) {
		if (this.puedeExtraerMonto(monto)) {
			this.extraerSinControlar(monto);
			cuentaDestino.depositar(monto);
			return true;
		} else {
			return false;
		}
	}
	
	public abstract boolean puedeExtraerMonto(double monto);
	
}
