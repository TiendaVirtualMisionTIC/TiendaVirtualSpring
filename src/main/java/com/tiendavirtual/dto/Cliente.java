package com.tiendavirtual.dto;

public class Cliente {
	private String cedula;
	private String nombre_completo;
	private String direccion;
	private String telefono;
	private String correo_electronico;
	
	public Cliente(String cedula, String nombre_completo, String direccion, String telefono,
			String correo_electronico) {
		super();
		this.cedula = cedula;
		this.nombre_completo = nombre_completo;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo_electronico = correo_electronico;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre_completo() {
		return nombre_completo;
	}

	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}
	
	//?cedula=987&nombre_completo=Adam&direccion=cartagena&telefono=111&correo_electronico=gato@gmail.com
	
	
}
