package ar.edu.unlp.info.oo1.SegundoParcial;

import java.time.LocalDate;
import java.util.List;

public class FacturaOrdenes {
	
	public FacturaOrdenes() {
	}

	public void facturarOrdenes(List<OrdenCompraRepuestos> ordenCompraRepuestos, List<OrdenReparacion> ordenReparacion) {
		
		double total = 0.0;
		
		System.out.println("");
		System.out.println("FACTURA DE ORDEN DE COMPRA DE REPUESTOS");
		
		for (OrdenCompraRepuestos ordenRepuestos : ordenCompraRepuestos) {
			System.out.println("-------------------------------");
			System.out.println("Factura correspondiente a la ORDEN DE COMPRA DE REPUESTOS - fecha: " + LocalDate.now() + ", patente numero: " + ordenRepuestos.getPatente() + " es de un total de: $" + ordenRepuestos.getCostoTotal());
			System.out.println("-------------------------------");
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("FACTURA DE ORDEN DE REPARACION");
		
		for (OrdenReparacion reparacion : ordenReparacion) {
			System.out.println("-------------------------------");
			System.out.println("Factura correspondiente a la ORDEN DE REPARACION - fecha: " + LocalDate.now() + ", patente numero: " + reparacion.getPatente() + ", descripcion: " + reparacion.getDescripcion() + ". Es de un total de: $" + reparacion.getCostoTotal());
			System.out.println("-------------------------------");
		}
	}
	
}
