package com.codenotfound.primefaces.servicios;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.codenotfound.primefaces.dao.ProveedorDAO;
import com.codenotfound.primefaces.dao.impl.ProveedorDAOImpl;
import com.codenotfound.primefaces.model.Proveedor;

public class ProveedorService {

	private List<Proveedor> proveedores;

	public ProveedorService() {
		super();
		// this.proveedores = proveedores;
		proveedores = new ArrayList<>();
	}

	public List<Proveedor> getProveedores() {
		ProveedorDAO dao = new ProveedorDAOImpl();
		List<Proveedor> lst = null;
		try {
			lst = dao.listAllProveedors();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
		// return new ArrayList<>(proveedores);
	}

	
	public boolean createProveedor(Proveedor prov) throws SQLException {
		return new ProveedorDAOImpl().insertProveedor(prov);
	}

	public boolean editaProveedor(Proveedor prov) throws SQLException {
		return new ProveedorDAOImpl().updateProveedor(prov);
	}

	public boolean borraProveedor(Proveedor prov) throws SQLException {
		return new ProveedorDAOImpl().deleteProveedor(prov);
	}


	
	
}
