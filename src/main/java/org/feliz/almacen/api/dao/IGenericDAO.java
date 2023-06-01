package org.feliz.almacen.api.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

public interface IGenericDAO<T,ID>{
	
	public List<T> findByID(String string) throws SQLException;
	public List<T> findByExample(T entity)throws SQLException ;
	public List<T> findAll() throws SQLException;
	public void update(T entity) throws SQLException ;
	public void delete(T entity) throws SQLException ;
	public void save(T entity) throws SQLException ;
	
	void setDataSource(DataSource ds);
	void setConnection(Connection connect);
	Connection getConnection() throws SQLException;

}