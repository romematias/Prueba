package ar.edu.banco.dominio;

public class Cliente {
	private String nombre;
	private String apellido;
	private Integer dni;
	
	public Cliente (String nombre, String apellido, Integer dni) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.dni=dni;
	}
}
