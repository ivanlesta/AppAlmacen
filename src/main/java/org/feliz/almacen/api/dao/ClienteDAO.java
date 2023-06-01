package org.feliz.almacen.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.feliz.almacen.api.modelo.Cliente;
import org.feliz.almacen.api.modelo.ICliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClienteDAO extends AbstractGenericDAO implements IClienteDAO {

	private static Logger logger = LoggerFactory.getLogger(MariaDBFactoryDAO.class);
	
	private static final String QUERY_FINDBY = "SELECT * FROM cliente WHERE idCliente = ?";
	private static final String QUERY_FINDBYEXAMPLE = "SELECT * FROM cliente ?";
	private static final String QUERY_FINDALL = "SELECT * FROM cliente";
	private static final String QUERY_UPDATE = "UPDATE cliente SET nombre = ?, apellido1 = ? WHERE idCliente = ?";
	private static final String QUERY_DELETE = "DELETE FROM cliente WHERE idCliente = ?, nombre = ?, apellido1 = ? "
			+ " apellido2 = ?, DNI = ?, Telefono = ?";
	private static final String QUERY_SAVE = "INSERT INTO cliente (nombre,apellido1) VALUES (?,?)";
	
	public List<ICliente> findByID(String id) throws SQLException {
	
		Connection con = getConnection();
		
		PreparedStatement ps = con.prepareStatement(QUERY_FINDBY);
		ps.setString(1,id);
	
		List<ICliente> resultado = new ArrayList<ICliente>();
		
		ResultSet rs = ps.executeQuery();
		
		String val = null;
		Cliente res = null;

		while (rs.next()) {
			val = rs.getString(1);
			res = new Cliente();
			res.setIdCliente(val);
			res.setNombre(rs.getString(2));
			res.setApellido1(rs.getString(3));
			res.setApellido2(rs.getString(4)); //TODO
			res.setNIF(rs.getString(5));
			res.setTelefono(rs.getString(6));
			resultado.add(res);
		}				
		return resultado;
	}		

	public List<ICliente> findByExample(ICliente entidad) throws SQLException {

				Connection con = getConnection();

				ICliente enti= entidad;

				String query = QUERY_FINDBYEXAMPLE;

				boolean engadirAnd = false;

				int posicion = 0;

				int posicionId = 0;

				int posicionNombre =0;

				int posicionApellido1 = 0;

				int posicionApellido2 =0;

				int posicionNif = 0;

				int posicionTelefono =0;

				if (null!= enti.getId()) {

					query= query + " idCliente= ? " + enti.getNIF();

					engadirAnd = true;

					posicion++;

					posicionId=posicion;

				}

				if (null!= enti.getNombre()) {

					query= query + ( engadirAnd ? " AND " : "")+ " nombre= ? ";

					engadirAnd = true;

					posicion++;

					posicionNombre=posicion;

				}

				if (null!= enti.getApellido1()) {

					query= query + ( engadirAnd ? " AND " : "")+ " apellido1= ? ";

					engadirAnd = true;

					posicion++;

					posicionApellido1=posicion;

				}

				if (null!= enti.getApellido2()) {

					query= query + ( engadirAnd ? " AND " : "")+ " apellido2= ? ";

					engadirAnd = true;

					posicion++;

					posicionApellido2=posicion;

				}

				if (null!= enti.getNIF()) {

					query= query + ( engadirAnd ? " AND " : "")+ " dni= ? ";

					engadirAnd = true;

					posicion++;

					posicionNif=posicion;

				}

				if (null!= enti.getTelefono()) {

					query= query + ( engadirAnd ? " AND " : "") + " telefono= ? ";

					engadirAnd = true;

					posicion++;

					posicionTelefono=posicion;

				}
				//TODO completar
		
				PreparedStatement ps = con.prepareStatement(query);
		
				//ps.setString(1,enti.getId());
		
				if (null!= enti.getId()) {
					ps.setString(posicionId,enti.getId());
				}
		
				if (null!= enti.getNombre()) {
					ps.setString(posicionNombre,enti.getNombre());
				}
		
				if (null!= enti.getApellido1()) {
					ps.setString(posicionApellido1,enti.getApellido1());
				}
		
				if (null!= enti.getApellido2()) {
					ps.setString(posicionApellido2,enti.getApellido2());
				}
		
				if (null!= enti.getNIF()) {
					ps.setString(posicionNif,enti.getNIF());
				}
				
				if (null!= enti.getTelefono()) {
					ps.setString(posicionTelefono,enti.getTelefono());
				}
				
				List<ICliente> resultado = new ArrayList<ICliente>();
				//ResultSet rs = ps.executeQuery();
				String val = null;

				Cliente res = null;

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

					res= new Cliente();

					res.setIdCliente(rs.getString("idCliente"));

					res.setNombre(rs.getString("nombre"));

					res.setApellido1(rs.getString("apellido1"));

					res.setApellido2(rs.getString("apellido2"));

					res.setNIF(rs.getString("dni"));

					res.setTelefono(rs.getString("telefono"));
				resultado.add(res);

				}
				return resultado;
			}
	
	@Override
	public List<ICliente> findAll() throws SQLException {
		
		Connection con = getConnection();
		
		PreparedStatement ps = con.prepareStatement(QUERY_FINDALL);
		List<ICliente> resultado = new ArrayList<ICliente>();
		
		ResultSet rs = ps.executeQuery();
		
		String val = null;
		Cliente res = null;

		while (rs.next()) {
			val = rs.getString(1);
			res = new Cliente();
			res.setIdCliente(val);
			res.setNombre(rs.getString(2));
			res.setApellido1(rs.getString(3));
			res.setApellido2(rs.getString(4));
			res.setNIF(rs.getString(5));
			res.setTelefono(rs.getString(6));
			resultado.add(res);
		}			
		return resultado;
	}
	
	public void update(ICliente entidad) throws SQLException {
		
		Connection con = getConnection();
		
		PreparedStatement ps = con.prepareStatement(QUERY_UPDATE);
		
		ps.setString(1, entidad.getId());
		ps.setString(2, entidad.getNombre());
		ps.setString(3, entidad.getApellido1());
		ps.setString(4, entidad.getApellido2());
		ps.setString(5, entidad.getNIF());
		ps.setString(6, entidad.getTelefono());
		ps.setString(7, entidad.getId());
		List<ICliente> resultado2 = new ArrayList<ICliente>();
		
		ResultSet rs = ps.executeQuery();
	}
	
	public void delete(ICliente entidad) throws SQLException {
		
		Connection con = getConnection();
		
		PreparedStatement ps = con.prepareStatement(QUERY_DELETE);
		
		ps.setString(1, entidad.getId());
		ps.setString(2, entidad.getNombre());
		ps.setString(3, entidad.getApellido1());
		ps.setString(4, entidad.getApellido2());
		ps.setString(5, entidad.getNIF());
		ps.setString(6, entidad.getTelefono());
		ps.setString(7, entidad.getId());
		List<ICliente> resultado3 = new ArrayList<ICliente>();
		
		ResultSet rs = ps.executeQuery();
	}
	
	public void save(ICliente entity) throws SQLException {
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String idCliente=entity.getId();
		try {
		con = getConnection();
		
		if(entity.getId()==null) {
			ps = con.prepareStatement(QUERY_SAVE,Statement.RETURN_GENERATED_KEYS);
			ps = setString(1, entity.getNombre());
			ps.setString(2, entity.getApellido1());
			
			int acts = ps.executeUpdate();
			
			if(1!=acts) {
				logger.error("Error insertando entidad, múltiples actualizaciones, por favor pongase en contacto con el administrador: " + ps.getResultSet().getStatement());
				
				throw new SQLException("Error insertando entidad, múltiples actualizaciones, por favor póngase en contacto con el administrador.´");
			}
			
			rs=ps.getGeneratedKeys();
			
			if(!rs.next()) {
				logger.error("Error insertando entidad, sin generatedKeys, por favor póngase en contacto con el administrador: " + ps.getResultSet().getStatement());
				
				throw new SQLException("Error insertando entidad, sin generatedKeys, por favor póngase en contacto con el administrador.");
			}
			
				idCliente = rs.getString(1);
				
			if (null==idCliente || "".equals(idCliente)) {
				logger.error("Error insertando entidad, se requiere ID, por favor póngase en contacto con la administración: " + ps.getResultSet().getStatement());
				
				throw new SQLException("Error inmsertando entidad, se requiere ID, por favor póngase en contacto con la administración.");
			}
			
		} else {
			ps=con.prepareStatement(QUERY_UPDATE);
			ps.setString(3, entity.getId());
			ps.setString(1, entity.getNombre());
			ps.setString(2, entity.getApellido1());
			
			int acts = ps.executeUpdate();
			
			if(1!=acts) {
				logger.error("Error insertando entidad, múltiples actualizaciones, por favor pongase en contacto con el administrador: " + ps.getResultSet().getStatement());
				
				throw new SQLException("Error insertando entidad, múltiples actualizaciones, por favor póngase en contacto con el administrador.´");
			}
			
		}
		
		List<ICliente> lc=findByID(idCliente);
		
		if (null==lc || 1!=lc.size()) {
			logger.error("Error recuperando entidad insertada, por favor póngase en contacto con el administrador: " + ps.getResultSet().getStatement());
			
			throw new SQLException("Error entidad insertada, por favor póngase en contacto con el administrador.");
		}
		
		entity=lc.get(0);
		
		if(null==entity) {
			logger.error("Error recuperando entidad insertada, contacte administrador: " + ps.getResultSet().getStatement());;
			
			throw new SQLException("Error entidad insertada, cobtacten administrador.");
		}
		
		//TODO
		
		} catch (SQLException e ) {
			close(con, ps, rs);
			throw e;
		}
}
		
	private void close(Connection con, PreparedStatement ps, ResultSet rs) {
		// TODO Auto-generated method stub
		
	}

	private PreparedStatement setString(int i, String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	public double getFacturacionAnual(int year) {
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

	@Override
	public void save(Object entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}