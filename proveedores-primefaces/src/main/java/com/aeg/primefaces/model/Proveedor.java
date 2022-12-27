package com.aeg.primefaces.model;

public class Proveedor {
	  int		id;
	  String	nombre;
	  int		numide;
	  String	direccion;
	  String	email;
	  int		vehiculos;

	  public Proveedor(int id,String nombre, int numide, String direccion, String email, int vehiculos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.numide = numide;
		this.direccion = direccion;
		this.email = email;
		this.vehiculos = vehiculos;
	}
	  
	public Proveedor() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumide() {
		return numide;
	}
	public void setNumide(int numide) {
		this.numide = numide;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getVehiculos() {
		return vehiculos;
	}
	public void setVehiculos(int vehiculos) {
		this.vehiculos = vehiculos;
	}

	
}
