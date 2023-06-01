package org.feliz.almacen;

import java.util.List;

import org.feliz.almacen.api.MotorApiServicioNegocio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ProbaExecucion {
	
	private static Logger logger = LoggerFactory.getLogger(ProbaExecucion.class);
	
	public static void main(String[] args) {
		
		try {
			new ProbaExecucion().doRun(args);
		} catch (Exception e) {
		logger.error("ERROR:", e);
		}
	}

private void doRun(String[] args) throws Exception {
	
	Logger logger = LoggerFactory.getLogger(ProbaExecucion.class);
	
	logger.debug("Inicio, args: " + args);
	MotorApiServicioNegocio mApi = new MotorApiServicioNegocio();
	
	List<String> datos = mApi.getDatos();
	datos.forEach(System.out::println);
	
	logger.debug("Sacamos Lista Clientes");
	
	datos =mApi.getListaClientes();
	datos.forEach(System.out::println);
	
	logger.debug("Fin");
	}
}