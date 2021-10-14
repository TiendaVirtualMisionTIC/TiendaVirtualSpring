package com.tiendavirtual.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.tiendavirtual.dto.Producto;
import com.tiendavirtual.dto.Producto;

public class ProductosDAO {
	
	public void insertProducto(Producto prod) {
		Conexion conex = new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("INSERT INTO productos(codigo_producto, nombre_producto, nit_proveedor, precio_compra, iva_compra, precio_venta) VALUES ('" + prod.getCodigo_producto() + "', '" + prod.getNombre_producto()
					+ "', '" + prod.getNit_proveedor() + "', '" + prod.getPrecio_compra() + "', '" + prod.getIva_compra() + "', '"
					+ prod.getPrecio_venta() + "')");
			estatuto.close();
			

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<Producto> consultarProductos(String nombre_producto) {
		ArrayList<Producto> productos = new ArrayList<Producto>();
		Conexion conex = new Conexion();

		String sql = "SELECT * FROM productos ";
		if (!nombre_producto.trim().equals("null")) {
			sql = sql + "WHERE nombre_producto = '" + nombre_producto + "'";
		}

		try {
			Statement consulta = conex.getConnection().createStatement();
			ResultSet res = consulta.executeQuery(sql);

			while (res.next()) {
				Producto prod = new Producto(res.getString("codigo_producto"), res.getString("nombre_producto"),
						res.getString("nit_proveedor"), res.getString("precio_compra"), res.getString("iva_compra"),
						res.getString("precio_venta"));
				productos.add(prod);
			}
			res.close();
			consulta.close();
			

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n" + e);
		}
		return productos;
	}

}
