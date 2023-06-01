package org.feliz.almacen.api.configuracion;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigAplication extends Configuracion {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private static final Logger logger = LoggerFactory.getLogger(ConfigAplication.class);

	
	static ConfigAplication instance;
	
	public static final ConfigAplication getInstance() {
		 
        logger.debug("Inicio");
 
        if (instance == null) {
            instance = new ConfigAplication();
 
            String mruta = System.getProperty(APP_CONFIG_FILE_KEY, PATH_CONFIGURATION);
            
                        
            logger.info("mruta: " + mruta);
 
            instance.loadProperties(mruta);
 
        }
 
        logger.debug("Final");
 
        return instance;
    }
	
	public boolean isDataBaseWebServerPool() {
		return getPropertyBoolean(DB_CONNECTION_WEB_SERVER_DS, "false");
	}

	public String getDataBaseUser() {
		return getProperty(DB_USER);			
	}
	
}