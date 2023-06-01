package org.feliz.almacen.api.dao;

import java.util.Date;

import org.feliz.almacen.api.modelo.IVendedor;

public interface IVendedorDAO extends IGenericDAO<IVendedor,String>{

	//Cuantas compras ha realizado(punto de vista vendedor)
	public int getComprasFecha(Date fechaInicial, Date fechaFinal);
	
}
