package ar.edu.unlp.info.oo1.Ej9_CuentaConGanchos;

public class CuentaCorriente extends Cuenta{

	private double descubierto;
	
	public CuentaCorriente() {
		this.descubierto = 0;
	}
	
	public double getDescubierto() {
		return this.descubierto;
	}
	public void setDescubierto(double descubierto) {
		this.descubierto = descubierto;
	}
	
	@Override
	public boolean puedeExtraerMonto(double monto) {
		// si el monto a extraer es menor al saldo y a su descubierto
		// descubierto = max negativo por extraer
		if (monto <= (super.getSaldo() + this.descubierto)) {
			return true;
		} else {
			return false;
		}
	}
	
}
