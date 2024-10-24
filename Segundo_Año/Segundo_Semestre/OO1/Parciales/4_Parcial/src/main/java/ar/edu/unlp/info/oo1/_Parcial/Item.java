package ar.edu.unlp.info.oo1._Parcial;

public class Item {

	private Producto producto;
	private int cant;
	
	public Item(Producto producto, int cant) {
		this.producto = producto;
		this.cant = cant;
	}
	
	public Producto getProducto() {
		return this.producto;
	}
	
	public int getCant() {
		return this.cant;
	}
	
	public double calcularCosto() {
		double costo = 0.0;
		costo = this.cant * this.producto.costoUnitario + this.producto.calcularImpuesto(this.cant);
		return costo;
	}
	
}
