package Segundo_Año.Segundo_Semestre.OO1.Parciales.ParcialesCursada.ParcialDistribuidora.src.main.java.ar.edu.unlp.info.oo1.ParcialDistribuidora;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Distribuidora {
	
	private List<Cliente> clientes;
	private List<Producto> productos;
	
	public Distribuidora() {
		this.clientes = new ArrayList<Cliente>();
		this.productos = new ArrayList<Producto>();
	}
	
	public Cliente registrarCliente(String n, String e) {
		Cliente c = new Cliente(n, e);
		this.clientes.add(c);
		return c;
	}
	
	public Producto registrarProducto(Producto p) {
		this.productos.add(p);
		return p;
	}
	
	public Producto registrarProdNacional(String n, double cu, String d) {
		return this.registrarProducto(new Nacional(n, cu, d));
	}
	
	public Producto registrarProdImportado(String n, double cu, String d, String po) {
		return this.registrarProducto(new Importado(n, cu, d, po));
	}
	
	public int cantSolicitadaProducto(Producto p) {
		return this.clientes.stream()
				.mapToInt(cliente -> cliente.cantSolicitadaProducto(p))
				.sum();
	}
	
	public List<Cliente> clientesTop() {
		LocalDate ant = LocalDate.now().minusDays(30);
		return this.clientes.stream()
				.sorted((c1, c2) -> Double.compare(c2.costoTotalPedidos(ant, LocalDate.now()), c1.costoTotalPedidos(ant, LocalDate.now())))
				.limit(5)
				.collect(Collectors.toList());
				
	}

}
