package com.codenotfound.primefaces;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import com.codenotfound.primefaces.model.Proveedor;
import com.codenotfound.primefaces.servicios.ProveedorService;

@ManagedBean
@RequestScoped
public class HelloWorld {

	private Proveedor proveedor = new Proveedor();
	private Proveedor nuevoProv = new Proveedor();
	private Proveedor selectedProv = new Proveedor();
	private Proveedor editProv = new Proveedor();
	private Proveedor borraProv = new Proveedor();
	private List<Proveedor> selectedProvs;
	private List<Proveedor> proveedores;
	private ProveedorService service = new ProveedorService();

	public HelloWorld() {
		super();
		proveedores = service.getProveedores();
	}

	public Proveedor getNuevoProv() {
		return nuevoProv;
	}

	public void setNuevoProv(Proveedor nuevoProv) {
		this.nuevoProv = nuevoProv;
	}

	public Proveedor getSelectedProv() {
		return selectedProv;
	}

	public void setSelectedProv(Proveedor selectedProv) {
		this.selectedProv = selectedProv;
	}

	public List<Proveedor> getSelectedProvs() {
		return selectedProvs;
	}

	public void setSelectedProvs(List<Proveedor> selectedProvs) {
		this.selectedProvs = selectedProvs;
	}

	public ProveedorService getService() {
		return service;
	}

	public void setService(ProveedorService service) {
		this.service = service;
	}

	public List<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Proveedor getEditProv() {
		return editProv;
	}

	public void setEditProv(Proveedor editProv) {
		this.editProv = editProv;
	}

	
	
	public Proveedor getBorraProv() {
		return borraProv;
	}

	public void setBorraProv(Proveedor borraProv) {
		this.borraProv = borraProv;
	}

	public void nuevoProveedor() {
		System.out.println("nuevoUsuarios ");
		try {
			service.createProveedor(nuevoProv);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void editaProveedor() {
		System.out.println("editaProveedor " + selectedProv.getNombre());
		try {
			service.editaProveedor(editProv);
			//PrimeFaces.current().dialog().closeDynamic(null);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void borraProveedor() {
		System.out.println("borraProveedor " + selectedProv.getNombre());
		try {
			service.borraProveedor(editProv);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void someListener(SelectEvent event) {
		Proveedor qq = (Proveedor) event.getObject();
		System.out.println("event : " + qq.getId());
		editProv.setId(qq.getId());
		editProv.setNombre(qq.getNombre());
		editProv.setNumide(qq.getNumide());
		editProv.setDireccion(qq.getDireccion());
		editProv.setEmail(qq.getEmail());
		editProv.setVehiculos(qq.getVehiculos());

		borraProv.setId(qq.getId());
		borraProv.setNombre(qq.getNombre());
		borraProv.setNumide(qq.getNumide());
		borraProv.setDireccion(qq.getDireccion());
		borraProv.setEmail(qq.getEmail());
		borraProv.setVehiculos(qq.getVehiculos());
		PrimeFaces.current().ajax().update("forma1");
	}

}
