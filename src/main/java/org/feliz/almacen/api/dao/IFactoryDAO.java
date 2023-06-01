package org.feliz.almacen.api.dao;

import java.sql.SQLException;

public interface IFactoryDAO {
	
	public IClienteDAO getClienteDAO() throws SQLException;
	public IVendedorDAO getVendedorDAO()throws SQLException;
	public IComprasDAO getComprasDAO()throws SQLException;
	public IProductoDAO getProductoDAO()throws SQLException;
	
}