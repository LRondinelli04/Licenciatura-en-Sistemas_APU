package ar.edu.unlp.info.oo1._Parcial;

import java.util.ArrayList;
import java.util.List;

public class Sistema {

	/*
	 * registrar un usuario
	 * 
	 * publicar un producto nuevo 
	 * 
	 * publicar un producto usado
	 * 
	 * publicar un servicio
	 * 
	 * consultar el precio final de una publicacion
	 * 
	 * retornar las 10 publicaciones mas caras para una localidad
	 * 
	 * obtener las publicaciones ordenadas por suprecio final para una localidad
	 * 
	 * */
	
	private List<Usuario> usuarios;
	
	public Sistema() {
		this.usuarios = new ArrayList<Usuario>();
	}
	
	public List<Usuario> getUsuarios(){
		return this.usuarios;
	}
	
	// registrar un usuario y retornarlo
	public Usuario registrarUsuario(String email, String domicilio) {
		Usuario u = new Usuario(email, domicilio);
		this.usuarios.add(u);
		return u;
	}
	
	// PUBLICAR un producto NUEVO y retornarlo
	public Publicacion publicarProductoNuevo(Usuario usuario, String nombreP, String descripcion, double precioUnitario, int cantDisponible, FormaEntrega formaEntrega) {
		ProductoNuevo publicacion = new ProductoNuevo(usuario, nombreP, descripcion, precioUnitario, cantDisponible, formaEntrega);
		usuario.registrarPublicacion(publicacion);
		return publicacion;
	}
	
	// PUBLICAR un producto usado y retornarlo
	public Publicacion publicarProductoUsado(Usuario usuario, String nombreP, String descripcion, double precioUnitario) {
		ProductoUsado publicacion = new ProductoUsado(usuario, nombreP, descripcion, precioUnitario);
		usuario.registrarPublicacion(publicacion);
		return publicacion;
	}
	
	// PUBLICAR un servicio y retornarlo
	public Publicacion publicarServicio(Usuario usuario, String nombre, String descripcion, double precio) {
		Servicio publicacion = new Servicio(usuario, nombre, descripcion, precio);
		usuario.registrarPublicacion(publicacion);
		return publicacion;
	}
	
	public double precioFinalDePublicacion(Publicacion publicacion, String localidad) {
		double precioFinal = 0;
		List<Publicacion> listaPublicaciones = new ArrayList<Publicacion>();
		
		for (Usuario usuario : this.usuarios) {
			listaPublicaciones.addAll(usuario.getPublicaciones());// lista de publicaciones de todos los usuarios
		}	
		
		for (Publicacion publi : listaPublicaciones) {
			if (publi.equals(publicacion)) {
				return precioFinal = publicacion.calcularPrecioFinal(localidad);
			}
		}
			
		return precioFinal;
	}
	
	// retornar las 10 publicaciones as caras para una localidad
	public List<Publicacion> retornarPublicacionesMasCaras(String localidad) {
		
		List<Publicacion> listaPublicaciones = new ArrayList<Publicacion>(); // aca voy a guardar todas las listas de publicaciones de los usuarios
		for (Usuario usuario : this.usuarios) {
			listaPublicaciones.addAll(usuario.getPublicaciones());
		}
		
		listaPublicaciones.sort((p1, p2) -> Double.compare(p2.calcularPrecioFinal(localidad), p1.calcularPrecioFinal(localidad))); // ordeno la lista de mayor a menor
		
		return listaPublicaciones.stream().limit(10).toList(); // obtengo las 10 publicaciones mas caras por una localidad
	}
	
	public List<Publicacion> obtenerPublicacionesOrdenadasPorPrecio(String localidad) {
	    List<Publicacion> publicacionesOrdenadas = new ArrayList<Publicacion>();
	    
	    for (Usuario usuario : this.usuarios) {
	        publicacionesOrdenadas.addAll(usuario.getPublicaciones());
	    }
	    
	    publicacionesOrdenadas.sort((p1, p2) -> Double.compare(p2.calcularPrecioFinal(localidad), p1.calcularPrecioFinal(localidad)));
	    
	    return publicacionesOrdenadas; // Retorna todas las publicaciones ordenadas
	}
}
