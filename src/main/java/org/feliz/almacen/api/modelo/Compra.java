package org.feliz.almacen.api.modelo;

import java.util.Date;

public class Compra implements ICompra {

	private Date fechaCompra;
	private Float precio;
	private String idCompra;
	private String idVendedor;
	private String idCliente;
	
	public Compra() {
		
	}
	public Compra(Date fechaCompra, Float precio, String idCompra, String idVendedor, String idCliente) {
		super();
		this.fechaCompra = fechaCompra;
		this.precio = precio;
		this.idCompra = idCompra;
		this.idVendedor = idVendedor;
		this.idCliente = idCliente;
	}
	
	public void setId(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setFechaCompra(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setPrecio(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setIdVendedor(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setIdCliente(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFechaCompra() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPrecio() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getIdVendedor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getIdCliente() {
		// TODO Auto-generated method stub
		return null;
	}

}
