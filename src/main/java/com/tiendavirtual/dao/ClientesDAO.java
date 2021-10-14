package com.tiendavirtual.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.tiendavirtual.dto.Cliente;
import com.tiendavirtual.dto.Proveedor;
import com.tiendavirtual.dto.Usuario;

public class ClientesDAO {
	public void insertCostumer(Cliente cli) {
		Conexion conex = new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("INSERT INTO cliente(cedula, nombre_completo, direccion, telefono, correo_electronico) VALUES ('" + cli.getCedula() + "', '" + cli.getNombre_completo()
					+ "', '" + cli.getDireccion() + "', '" + cli.getTelefono() + "', '" + cli.getCorreo_electronico() +	"')");
			estatuto.close();
			

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<Cliente> consultarClientes(String cedula) {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Conexion conex = new Conexion();

		String sql = "SELECT * FROM cliente ";
		if (!cedula.trim().equals("null")) {
			sql = sql + "WHERE cedula = '" + cedula + "'";
		}

		try {
			Statement consulta = conex.getConnection().createStatement();
			ResultSet res = consulta.executeQuery(sql);

			while (res.next()) {
				Cliente cli = new Cliente(res.getString("cedula"), res.getString("nombre_completo"),
						res.getString("direccion"), res.getString("telefono"), res.getString("correo_electronico"));
					
				clientes.add(cli);
			}
			res.close();
			consulta.close();
			

		} catch (Exception e) {
			System.out.println("no se pudo consultar la Persona\n" + e);
		}
		return clientes;
	}

	
	public Cliente searchUser(String nombre) {
		return null;
	}
	
	public void updateUser(Cliente cli) {
		
	}
	
	public void deleteUser(Cliente cli) {
		
	}
}

