package org.feliz.almacen.api.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.naming.*;

import org.apache.commons.dbcp2.BasicDataSource;
import org.feliz.almacen.api.configuracion.ConfigAplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public class MariaDBFactoryDAO extends ProducerFactoryDAO{
	
	private static Logger logger = LoggerFactory.getLogger(MariaDBFactoryDAO.class);
	
    private static final String URL = "jdbc:mariadb://localhost:3306/almacen";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String DRIVER_CLASS = "org.mariadb.jdbc.Driver";
    
    private static DataSource dataSource = null;
    
    public DataSource getDataSource() throws SQLException {
    	if (dataSource == null) {
    		dataSource = doDataSource();
    	}
    	return dataSource;
    }
    
    private DataSource doDataSource() throws SQLException {
    	DataSource ds = null;
    	
    	/*if (ConfigAplication.getInstance().isModCLI()) {
    		ds = doDataSourceFromConfig();
    	} else*/ 
    	
    	if (ConfigAplication.getInstance().isDataBaseWebServerPool()){
    		try {Context ctx = new InitialContext();
    			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/almacen");
    			
    			logger.debug("Se ha obtenido el DataSource desde Context java:comp/env/jdbc/almacen");
    			
    		} catch (NamingException e) {
    			logger.error("No se ha podido obtener info para conectar a la BD", e);
    			throw new SQLException("No se ha podido obtener info para conectar a la BD", e);
    		}
    	}else {	
    		ds = doDataSourceFromConfig();
    		logger.debug("Se ha construido el DataSource instanciando un Pool");
    	}
    	
    	String confidentialMarkertext = "CONFIDENTIAL";
    	Marker confidentialMarker = MarkerFactory.getMarker(confidentialMarkertext);
    	logger.debug("This logger supports confidential messages...");
    	logger.debug(confidentialMarker,"This is a confidential message...");
    	logger.debug("Just logged a confidential message");
    	
    	return ds;
    }
    
    private DataSource doDataSourceFromConfig() {
    	BasicDataSource ds = new BasicDataSource();
    	
    	ds.setDriverClassName(DRIVER_CLASS);
    	
    	String userbd=ConfigAplication.getInstance().getDataBaseUser();
    	
    	ds.setUsername(userbd);

    	ds.setPassword(PASSWORD);
    	ds.setUrl(URL);
    	ds.setInitialSize(1);
    	ds.setMaxIdle(2);
    	ds.setTestWhileIdle(true);
    	ds.setTimeBetweenEvictionRunsMillis(1000);
    	ds.setTestOnReturn(true);
    	
    	return ds;
    }

	@Override
	public IClienteDAO getClienteDAO() throws SQLException {
		IClienteDAO resultado = new ClienteDAO();
		resultado.setDataSource(getDataSource());
		return resultado;
	}

	@Override
	public IVendedorDAO getVendedorDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IComprasDAO getComprasDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IProductoDAO getProductoDAO() {
		// TODO Auto-generated method stub
		return null;
	}
    
    /*protected static Connection getConnection() {
        Connection con = null;
        try {
            con = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
            return con;
        } catch (SQLException e) {
            System.exit(-1);
            return null;
        }
    }*/
}