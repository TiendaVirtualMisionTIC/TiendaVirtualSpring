package com.tiendavirtual.dao;

import java.sql.SQLException;
import java.sql.Statement;

import com.tiendavirtual.dto.Usuario;

public class UsuariosDAO {
	
	public void insertUser(Usuario user){
		Conexion con = new Conexion();
		Statement stmt;
		try {
			stmt = con.getConnection().createStatement();
			stmt.executeUpdate("INSERT INTO usuarios(nombre, password) VALUES (" + "'" + user.getNombre() + "'" + "," + "'"
					+ user.getPassword() + "'" + ")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Usuario searchUser(String nombre){
		
		return null;
	}
	
	public void updateUser(Usuario user){
		
	}
	
	public void deleteUser(Usuario user){
		
	}
}
