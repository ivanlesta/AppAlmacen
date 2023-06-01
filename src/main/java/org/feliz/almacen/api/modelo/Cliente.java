//constructor, atributos, método buscarPedidos
package org.feliz.almacen.api.modelo;

public class Cliente implements ICliente {
	
	private String telefono;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String NIF;
	private String idCliente;
	
	public Cliente() {
		
	}
	public Cliente(String telefono, String nombre, String apellido1, String apellido2, String nIF, String idCliente) {
		super();
		this.telefono = telefono;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		NIF = nIF;
		this.idCliente = idCliente;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido1() {
		return apellido1;
	}
	
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	
	public String getApellido2() {
		return apellido2;
	}
	
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	
	public String getNIF() {
		return NIF;
	}
	
	public void setNIF(String nIF) {
		NIF = nIF;
	}
	
	public String getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString() {
		String resultado = "";
		resultado = resultado + "ID = " + getIdCliente();
		resultado = resultado + "; DNI = " + getNIF();
		resultado = resultado + "; NOMBRE = " + getNombre();
		resultado = resultado + "; APELLIDOS = " + getApellido1();
		resultado = resultado + " " + getApellido2();
		resultado = resultado + "; TELÉFONO = " + getTelefono();
		return resultado;
	}
		
}