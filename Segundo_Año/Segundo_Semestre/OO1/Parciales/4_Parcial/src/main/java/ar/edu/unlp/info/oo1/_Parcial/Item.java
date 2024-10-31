package ar.edu.unlp.info.oo1._Parcial;

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
}
