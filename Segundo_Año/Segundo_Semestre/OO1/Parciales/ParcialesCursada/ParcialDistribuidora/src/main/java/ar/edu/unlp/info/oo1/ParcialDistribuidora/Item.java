package ar.edu.unlp.info.oo1.ParcialDistribuidora;

public class Item {

	private Producto producto;
	private int cantidad;
	
	public Item(Producto p, int c) {
		this.producto = p;
		this.cantidad = c;
	}
	
	public Producto getProducto() {
		return this.producto;
	}
	
	public int getCantidad() {
		return this.cantidad;
	}
	
	public double costoTotalItem() {
		double monto = this.producto.costoUnitario * this.cantidad + this.producto.calcImpuesto(this.cantidad);
		return monto;
	}
	
}
