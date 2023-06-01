package org.feliz.almacen.api.dao;

import java.sql.SQLException;
import java.util.List;

import org.feliz.almacen.api.modelo.ICompra;

public interface IComprasDAO extends IGenericDAO{

	//Cuanto producto se ha vendido (punto de vista jefe comercial)
	public int getProductoVendidoFecha(int idCompra);

}