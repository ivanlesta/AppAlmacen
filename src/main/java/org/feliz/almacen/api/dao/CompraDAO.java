package org.feliz.almacen.api.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.feliz.almacen.api.modelo.Compra;
import org.feliz.almacen.api.modelo.ICompra;

public class CompraDAO extends AbstractGenericDAO implements IComprasDAO {

	private static final String QUERY_FINDBY = "SELECT * FROM compra WHERE idCompra = ?";
	private static final String QUERY_FINDBYEXAMPLE = "SELECT * FROM compra ?";
	private static final String QUERY_FINDALL = "SELECT * FROM compra";
	private static final String QUERY_UPDATE = "UPDATE compra SET idCompra = ?, fechaCompra = ?, precio = ?, "
			+ "idVendedor = ?, idCliente = ? WHERE idCompra = ?";
	private static final String QUERY_DELETE = "DELETE FROM compra WHERE idCompra = ?, fechaCompra = ?, precio = ?,"
			+ " idVendedor = ?, idCliente = ?";
	private static final String QUERY_SAVE = "Insert * from compra";
	
	public List<ICompra> findByID(String id) throws SQLException {
	
		Connection con = getConnection();
		
		PreparedStatement ps = con.prepareStatement(QUERY_FINDBY);
		ps.setString(1,id);
	
		List<ICompra> resultado = new ArrayList<ICompra>();
		
		ResultSet rs = ps.executeQuery();
		
		String val = null;
		Compra res = null;

		while (rs.next()) {
			val = rs.getString(1);
			res = new Compra();
			res.setId(val);
			res.setFechaCompra(rs.getString(2));
			res.setPrecio(rs.getString(3));
			res.setIdVendedor(rs.getString(4));
			res.setIdCliente(rs.getString(5));
			resultado.add(res);
		}				
		return resultado;
	}		

	public List<ICompra> findByExample(ICompra entidad) throws SQLException {

				Connection con = getConnection();

				ICompra enti= entidad;

				String query = QUERY_FINDBYEXAMPLE;

				boolean engadirAnd = false;

				int posicion = 0;

				int posicionIdCompra = 0;

				int posicionFechaCompra =0;

				int posicionPrecio = 0;

				int posicionIdVendedor =0;

				int posicionIdCliente = 0;


				int posicionId = 0;
				if (null!= enti.getId()) {

					query = query + " idCompra= ? " + enti.getId();

					engadirAnd = true;

					posicion++;

					posicionId=posicion;

				}

				if (null!= enti.getFechaCompra()) {

					query= query + ( engadirAnd ? " AND " : "")+ " fechaCompra= ? ";

					engadirAnd = true;

					posicion++;

					posicionFechaCompra=posicion;

				}

				if (null!= enti.getPrecio()) {

					query= query + ( engadirAnd ? " AND " : "")+ " precio= ? ";

					engadirAnd = true;

					posicion++;

					posicionPrecio=posicion;

				}

				if (null!= enti.getIdVendedor()) {

					query= query + ( engadirAnd ? " AND " : "")+ " idVendedor= ? ";

					engadirAnd = true;

					posicion++;

					posicionIdVendedor=posicion;

				}

				if (null!= enti.getIdCliente()) {

					query= query + ( engadirAnd ? " AND " : "")+ " idCliente = ? ";

					engadirAnd = true;

					posicion++;

					posicionIdCliente=posicion;

				}

				//TODO completar
		
				PreparedStatement ps = con.prepareStatement(query);
		
				//ps.setString(1,enti.getId());
		
				if (null!= enti.getId()) {
					ps.setString(posicionId,(String) enti.getId());
				}
		
				if (null!= enti.getFechaCompra()) {
					ps.setString(posicionFechaCompra,(String) enti.getFechaCompra());
				}
		
				if (null!= enti.getPrecio()) {
					ps.setString(posicionPrecio,enti.getPrecio());
				}
		
				if (null!= enti.getIdVendedor()) {
					ps.setString(posicionIdVendedor,enti.getIdVendedor());
				}
		
				if (null!= enti.getIdCliente()) {
					ps.setString(posicionIdCliente,enti.getIdCliente());
				}
				
				List<ICompra> resultado = new ArrayList<ICompra>();
				//ResultSet rs = ps.executeQuery();
				String val = null;

				Compra res = null;

		/*

		        ps.setString(1, enti.getId());

		        ps.setString(2, enti.getNombre());

		        ps.setString(3, enti.getApellido1());

		        ps.setString(4, enti.getApellido2());

		        ps.setString(5, enti.getNif());

		        ps.setString(6, enti.getTelefono());

		        ps.setString(7, enti.getId());

		 	*/

				//List<ICliente> resultado1 = new ArrayList<ICliente>();

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {

					res= new Compra();

					res.setId(rs.getString("idCompra"));

					res.setFechaCompra(rs.getString("fechaCompra"));

					res.setPrecio(rs.getString("precio"));

					res.setIdVendedor(rs.getString("idVendedor"));

					res.setIdCliente(rs.getString("idCliente"));

				resultado.add((ICompra) res);

				}
				return resultado;
			}
	
	@Override
	public List<ICompra> findAll() throws SQLException {
		
		Connection con = getConnection();
		
		PreparedStatement ps = con.prepareStatement(QUERY_FINDALL);
		List<ICompra> resultado = new ArrayList<ICompra>();
		
		ResultSet rs = ps.executeQuery();
		
		String val = null;
		Compra res = null;

		while (rs.next()) {
			val = rs.getString(1);
			res = new Compra();
			res.setId(val);
			res.setFechaCompra(rs.getString(2));
			res.setPrecio(rs.getString(3));
			res.setIdVendedor(rs.getString(4));
			res.setIdCliente(rs.getString(5));
			resultado.add((ICompra) res);
		}			
		return resultado;
	}
	
	public void update(ICompra entidad) throws SQLException {
		
		Connection con = getConnection();
		
		PreparedStatement ps = con.prepareStatement(QUERY_UPDATE);
		
		ps.setString(1, (String) entidad.getId());
		ps.setString(2, (String) entidad.getFechaCompra());
		ps.setString(3, (String) entidad.getPrecio());
		ps.setString(4, (String) entidad.getIdVendedor());
		ps.setString(5, (String) entidad.getIdCliente());
		List<ICompra> resultado2 = new ArrayList<ICompra>();
		
		ResultSet rs = ps.executeQuery();
	}
	
	public void delete(ICompra entidad) throws SQLException {
		
		Connection con = getConnection();
		
		PreparedStatement ps = con.prepareStatement(QUERY_DELETE);
		
		ps.setString(1, (String) entidad.getId());
		ps.setString(2, (String) entidad.getFechaCompra());
		ps.setString(3, (String) entidad.getPrecio());
		ps.setString(4, (String) entidad.getIdVendedor());
		ps.setString(5, (String) entidad.getIdCliente());
		List<ICompra> resultado3 = new ArrayList<ICompra>();
		
		ResultSet rs = ps.executeQuery();
	}
	
	public void save(Object entidad) throws SQLException {
		Connection con = getConnection();
		
		PreparedStatement ps = con.prepareStatement(QUERY_SAVE);
		
		ps.setString(1, (String) ((ICompra) entidad).getId());
		ps.setString(2, (String) ((ICompra) entidad).getFechaCompra());
		ps.setString(3, (String) ((ICompra) entidad).getPrecio());
		ps.setString(4, (String) ((ICompra) entidad).getIdVendedor());
		ps.setString(5, (String) ((ICompra) entidad).getIdCliente());
		List<ICompra> resultado3 = new ArrayList<ICompra>();
		
		ResultSet rs = ps.executeQuery();	
	}
	
	
	public double getFacturacionAnual(int year) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getProductoVendidoFecha(int idCompra) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List findByExample(Object entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Object entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}