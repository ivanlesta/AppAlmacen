package org.feliz.almacen.api.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ProducerFactoryDAO implements IFactoryDAO{

	private static final Logger logger = LoggerFactory.getLogger(ProducerFactoryDAO.class);
	private static final int MariaDB = 1;
	
	public static IFactoryDAO getFactoryDAO(int whichFactory) {
		
		logger.debug("Inicio");
		
		IFactoryDAO  resultado = null;
		
		switch (whichFactory) {
		case MariaDB:
			resultado = new MariaDBFactoryDAO();
			break;
		default:
			resultado = new MariaDBFactoryDAO();
		}
		logger.debug("Fin, o resultado é da clase = " + resultado.getClass());
		return resultado;
	}
	
	public static IFactoryDAO getFactoryDAO() {
		//TODO CALCULAR-LEER CONFIGURACION PARA INSTANCIAR LA FACTORIA QUE CORRESPONDA
		return getFactoryDAO(MariaDB);
	}	
}