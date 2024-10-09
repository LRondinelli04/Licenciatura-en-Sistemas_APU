package ar.edu.unlp.info.oo1._Parcial;

public class Parquizacion extends Servicio{

	private int cantMaquinas;
	private double costoMantenimiento;
	
	public Parquizacion(double precioXHora, int cantHoras, int cantMaquinas, double costoMantenimiento) {
		super(precioXHora, cantHoras);
		this.cantMaquinas = cantMaquinas;
		this.costoMantenimiento = costoMantenimiento;
	}

	@Override
	public double montoAbonar() {
		double monto = this.precioXHora * this.cantHoras;
		double adicional = this.cantMaquinas * this.costoMantenimiento;
		monto += adicional;
		return monto;
	}

}
