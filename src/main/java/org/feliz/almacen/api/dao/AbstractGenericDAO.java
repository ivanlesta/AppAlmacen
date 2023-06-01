package org.feliz.almacen.api.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public abstract class AbstractGenericDAO implements IGenericDAO{
	
	private DataSource _ds = null;
	private Connection _con = null;
	
	@Override
	public void setDataSource(DataSource ds) {
		_ds = ds;
	}
	
	@Override
	public void setConnection(Connection connect) {
		_con = connect;
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		if (null == _con) {
			_con = _ds.getConnection();
		}
		return _con;
	}
}