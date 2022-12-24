package com.codenotfound.primefaces.dao;

import java.sql.SQLException;
import java.util.List;

import com.codenotfound.primefaces.model.Proveedor;


public interface ProveedorDAO {

	boolean insertProveedor(Proveedor proveedor) throws SQLException;
	List<Proveedor> listAllProveedors() throws SQLException;
	boolean deleteProveedor(Proveedor book) throws SQLException;
	boolean updateProveedor(Proveedor book) throws SQLException;
	Proveedor getProveedor(int id) throws SQLException;
}