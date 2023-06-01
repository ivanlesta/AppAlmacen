package org.feliz.almacen.api.dao;

import java.sql.SQLException;
import java.util.List;

import org.feliz.almacen.api.modelo.ICliente;

public interface IClienteDAO extends IGenericDAO{
	
	//Dime el historial de mis compras en un año concreto (punto de vista cliente)
	public double getFacturacionAnual(int year);
	
}
