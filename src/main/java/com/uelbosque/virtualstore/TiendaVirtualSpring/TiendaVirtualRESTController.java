package com.uelbosque.virtualstore.TiendaVirtualSpring;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiendavirtual.dao.ClientesDAO;
import com.tiendavirtual.dao.ProductosDAO;
import com.tiendavirtual.dao.ProveedorDAO;
import com.tiendavirtual.dto.Cliente;
import com.tiendavirtual.dto.Producto;
import com.tiendavirtual.dto.Proveedor;

@RestController
public class TiendaVirtualRESTController {
	@RequestMapping("/listarclientes")
	public ArrayList<Cliente> consultarClientes(String cedula) {
		ClientesDAO dao=new ClientesDAO();
		return dao.consultarClientes(cedula);
	}

	@RequestMapping("/ingresarcliente")
	public String insertarCliente(Cliente c) {
		ClientesDAO dao=new ClientesDAO();
		dao.insertCostumer(c);
		return "cliente insertado ";
		//?cedula=1456&nombreCompleto=raul&direccion=tolu&telefono=5678&correoElectronico=raul@gmail.com
	}
	
	//?NIT=112233&nombre=Gato&direccion=Barranquilla&telefono=314456987&email=gato@hotmail.com&sitioweb=www.elgato.com
		@RequestMapping("/registrarProveedor")
		public String registrarProveedor(Proveedor p) {		
			ProveedorDAO dao = new ProveedorDAO();
			dao.insertProveedor(p);
			return "Proveedor Registrado";		
		}
		
		@RequestMapping("/consultarProveedores")
		public ArrayList<Proveedor> consultarProveedores(String nit) {		
			ProveedorDAO dao = new ProveedorDAO();
			return dao.consultarProveedores(nit);		
		}
		
		@RequestMapping("/registrarProducto")
		public String registrarProducto(Producto p) {
			ProductosDAO dao=new ProductosDAO();
			dao.insertProducto(p);
			return "Producto Registrado";
		}
		@RequestMapping("/consultarProductos")
		public ArrayList<Producto> consultarProductos(String nombre_producto) {		
			ProductosDAO dao = new ProductosDAO();
			return dao.consultarProductos(nombre_producto);		
		}
		
		
}