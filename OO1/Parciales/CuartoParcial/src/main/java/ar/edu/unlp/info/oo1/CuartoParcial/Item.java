package ar.edu.unlp.info.oo1.CuartoParcial;

public class Item {

	private Producto producto;
	private int cantNecesaria;
	
	public Item(Producto producto, int cantNecesaria) {
		this.producto = producto;
		this.cantNecesaria = cantNecesaria;
	}
	
	public Producto getProducto() {
		return this.producto;
	}
	
	public int getCantNecesaria() {
		return this.cantNecesaria;
	}
	
	public double getCosto() {
		double total = 0.0;
		total = this.producto.costo * this.cantNecesaria + producto.calcularImpuesto(this.cantNecesaria);
		System.out.println(this.producto.costo);
		System.out.println(this.cantNecesaria);
		System.out.println(this.producto.calcularImpuesto(cantNecesaria));
		System.out.println(total);
		return total;
	}
}
