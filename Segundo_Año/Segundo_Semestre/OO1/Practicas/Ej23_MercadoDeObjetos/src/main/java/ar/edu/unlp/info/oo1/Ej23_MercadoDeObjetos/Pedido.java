package ar.edu.unlp.info.oo1.Ej23_MercadoDeObjetos;

public class Pedido {

	private Producto producto;
	private FormaPago formaPago;
	private FormaEnvio formaEnvio;
	private int cantSolicitada;
	
	public Pedido(Producto producto, FormaPago formaPago, FormaEnvio formaEnvio, int cantSolicitada) {
		this.producto = producto;
		this.formaPago = formaPago;
		this.formaEnvio = formaEnvio;
		this.cantSolicitada = cantSolicitada;
	}
	
	public Producto getProducto() {
		return this.producto;
	}
	
	public double calcularCostoTotal() {
		double total, precioFormaPago, precioFormaEnvio = 0;
		
		precioFormaPago = this.formaPago.calcularCosto(this.producto.getPrecio());
		precioFormaEnvio = this.formaEnvio.calcularEnvio();
		
		total = precioFormaPago + precioFormaEnvio;
		
		
		return total;
	}
	
	
	
}
