package com.tiendavirtual.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.tiendavirtual.dto.*;;

public class ProveedorDAO {

	public void insertProveedor(Proveedor prov) {
		Conexion conex = new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("INSERT INTO proveedores(NIT, nombre, direccion, telefono, email, sitioweb) VALUES ('" + prov.getNIT() + "', '" + prov.getNombre()
					+ "', '" + prov.getDireccion() + "', '" + prov.getTelefono() + "', '" + prov.getEmail() + "', '"
					+ prov.getSitioweb() + "')");
			estatuto.close();
			

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<Proveedor> consultarProveedores(String nit) {
		ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();
		Conexion conex = new Conexion();

		String sql = "SELECT * FROM proveedores ";
		if (!nit.trim().equals("null")) {
			sql = sql + "WHERE NIT = '" + nit + "'";
		}

		try {
			Statement consulta = conex.getConnection().createStatement();
			ResultSet res = consulta.executeQuery(sql);

			while (res.next()) {
				Proveedor prov = new Proveedor(res.getString("NIT"), res.getString("nombre"),
						res.getString("direccion"), res.getString("telefono"), res.getString("email"),
						res.getString("sitioweb"));
				proveedores.add(prov);
			}
			res.close();
			consulta.close();
			

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n" + e);
		}
		return proveedores;
	}

}
