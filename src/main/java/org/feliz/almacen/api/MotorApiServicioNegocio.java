package org.feliz.almacen.api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.feliz.almacen.api.dao.IComprasDAO;
import org.feliz.almacen.api.dao.IClienteDAO;
import org.feliz.almacen.api.dao.IFactoryDAO;
import org.feliz.almacen.api.dao.ProducerFactoryDAO;
import org.feliz.almacen.api.modelo.ICliente;
import org.feliz.almacen.api.modelo.ICompra;

public class MotorApiServicioNegocio implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String[] DATOS_INICIALES = { "uno", "dos", "tres" };

	private List<String> datos;

	public MotorApiServicioNegocio() {
		super();
		this.datos = Arrays.asList(DATOS_INICIALES);
	}

	public List<String> getDatos() {
		return datos;
	}

	public void setDatos(List<String> datos) {
		this.datos = datos;
	}

	public List<String> getListaClientes() throws Exception {
		IFactoryDAO mFactoryDAO = ProducerFactoryDAO.getFactoryDAO();
		IClienteDAO dao = mFactoryDAO.getClienteDAO();

		List<ICliente> lc = dao.findAll();

		List<String> resultado = new ArrayList<String>();

		for (Iterator<ICliente> iterator = lc.iterator(); iterator.hasNext();) {
			ICliente iCliente = (ICliente) iterator.next();

			resultado.add(iCliente.toString());
		}

		return resultado;
	}
	public List<String> getListaCompras() throws Exception {
		IFactoryDAO mFactoryDAO = ProducerFactoryDAO.getFactoryDAO();
		IClienteDAO dao = mFactoryDAO.getClienteDAO();

		List<ICompra> lc = dao.findAll();

		List<String> resultado = new ArrayList<String>();

		for (Iterator<ICompra> iterator = lc.iterator(); iterator.hasNext();) {
			ICompra iCompra = (ICompra) iterator.next();

			resultado.add(iCompra.toString());
		}

		return resultado;
	}
}