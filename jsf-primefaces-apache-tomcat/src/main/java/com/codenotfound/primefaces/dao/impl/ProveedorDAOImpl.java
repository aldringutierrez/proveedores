package com.codenotfound.primefaces.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codenotfound.primefaces.dao.ProveedorDAO;
import com.codenotfound.primefaces.model.Proveedor;
import com.codenotfound.primefaces.util.DBUtil;

/**
*
* */
public class ProveedorDAOImpl implements ProveedorDAO {

	@Override
	public boolean insertProveedor(Proveedor prov) throws SQLException {
		String sql = "INSERT INTO proveedores (nombre, numide, direccion,email,vehiculos) VALUES (?, ?, ?, ?, ?)";
		boolean rowInserted = false;

		try (Connection connection = DBUtil.getDataSource().getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);) {

			ps.setString(1, prov.getNombre());
			ps.setInt(2, prov.getNumide());
			ps.setString(3, prov.getDireccion());
			ps.setString(4, prov.getEmail());
			ps.setInt(5, prov.getVehiculos());

			rowInserted = ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowInserted;
	}

	@Override
	public List<Proveedor> listAllProveedors() throws SQLException {
		List<Proveedor> listProveedor = new ArrayList<>();

		String sql = "SELECT * FROM proveedores";

		try (Connection connection = DBUtil.getDataSource().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql)) {

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String nombre = resultSet.getString("nombre");
				int numide = resultSet.getInt("numide");
				String direccion = resultSet.getString("direccion");
				String email = resultSet.getString("email");
				int vehiculos = resultSet.getInt("vehiculos");

				Proveedor prov = new Proveedor(id, nombre, numide, direccion, email, vehiculos);
				listProveedor.add(prov);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listProveedor;
	}

	@Override
	public boolean updateProveedor(Proveedor prov) throws SQLException {
		//String sql = "UPDATE2 proveedores SET nombre = ?, numide = ?, direccion= ?, email= ?, vehiculos = ? WHERE id = ?";
		String sql = "UPDATE proveedores SET nombre = '"+prov.getNombre()+"', numide = "+prov.getNumide()+", direccion= '"+prov.getDireccion()+
				"', email= '"+prov.getEmail()+"', vehiculos = "+prov.getVehiculos()+" WHERE id = "+prov.getId();
		//String sql = "UPDATE proveedores SET nombre = 'qq', numide = 88, direccion= '1', email= '1', vehiculos = 2 WHERE id = 12";
		System.out.println("sql : "+sql);
		System.out.println("id : "+prov.getId());
		System.out.println("nombre : "+prov.getNombre());
		System.out.println("numide : "+prov.getNumide());
		System.out.println("direccion : "+prov.getDireccion());
		System.out.println("email : "+prov.getEmail());
		System.out.println("vehiculos : "+prov.getVehiculos());
		boolean rowUpdated = false;
		try (Connection connection = DBUtil.getDataSource().getConnection();
			PreparedStatement ps = connection.prepareStatement(sql)) {
			/*
			ps.setString(1, prov.getNombre());
			ps.setInt(2, prov.getNumide());
			ps.setString(3, prov.getDireccion());
			ps.setString(4, prov.getEmail());
			ps.setInt(5, prov.getVehiculos());
			ps.setInt(6, prov.getId());
*/			
			//System.out.println("sql : "+ps.get);

			rowUpdated = ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}

	@Override
	public boolean deleteProveedor(Proveedor prov) throws SQLException {
		String sql = "DELETE FROM proveedores where id = ?";
		boolean rowDeleted = false;
		try (Connection connection = DBUtil.getDataSource().getConnection();
			PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setInt(1, prov.getId());
			rowDeleted = ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowDeleted;
	}

	@Override
	public Proveedor getProveedor(int id) throws SQLException {
		Proveedor prov = null;
		String sql = "SELECT * FROM proveedores WHERE prov_id = ?";
		try (Connection connection = DBUtil.getDataSource().getConnection();
			PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet resultSet = ps.executeQuery();
			if (resultSet.next()) {
				String title = resultSet.getString("title");
				String author = resultSet.getString("author");
				float price = resultSet.getFloat("price");

				prov = new Proveedor(999,"prov 1", 1, "calle 1", "email 1", 5);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prov;
	}
}
