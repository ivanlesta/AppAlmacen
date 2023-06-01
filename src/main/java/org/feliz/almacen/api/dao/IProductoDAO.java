package org.feliz.almacen.api.dao;

import java.util.Date;

import org.feliz.almacen.api.modelo.IProducto;

public interface IProductoDAO extends IGenericDAO<IProducto,String>{

	//Dime la cantidad de producto vendido en un mes concreto(punto de vista jefe de almacen)
	public int getCantidadProductoFecha (Date fecha);
}
