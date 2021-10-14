<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tienda Virtual:Ingreso de Clientes</title>
<style>
body {
	background-color: lightblue;
	font-family: helvetica;
}

strong {
	background-color: grey;
}
</style>
<script>
	
function validateFields() {
	if (document.getElementById("txtCedula").value.trim().length == 0) {
		alert("Cedula no puede ser vacio.");
		return false;
	} else if (document.getElementById("txtNombreCompleto").value.trim().length == 0) {
		alert("El nombre no puede ser vacio.");
		return false;
	} else if (document.getElementById("txtDireccion").value.trim().length == 0) {
		alert("La dirección no puede ser vacia.");
		return false;
	} else if (document.getElementById("txtTelefono").value.trim().length == 0) {
		alert("El telefono no puede ser vacio.");
		return false;
	} else if (document.getElementById("txtCorreoElectronico").value.trim().length == 0) {
		alert("El correo electronico no puede ser vacio.");
		return false;
	} else {
		return true;
	}
}

function sendData() {
	if (!validateFields()) {
		return;
	} else {
		var cedula = document.getElementById("txtCedula").value.trim();
		var nombre_completo = document.getElementById("txtNombreCompleto").value.trim();
		var direccion = document.getElementById("txtDireccion").value
				.trim();
		var telefono = document.getElementById("txtTelefono").value.trim();
		var correo_electronico = document.getElementById("txtCorreoElectronico").value.trim();
		

		var http = new XMLHttpRequest();
		var url = 'http://localhost:8080/ingresarcliente';
		var params = "cedula=" + cedula + "&" + "nombre_completo=" + nombre_completo + "&"
				+ "direccion=" + direccion + "&" + "telefono=" + telefono
				+ "&" + "correo_electronico=" + correo_electronico;
		http.open('POST', url, true);

		//Send the proper header information along with the request
		http.setRequestHeader('Content-type',
				'application/x-www-form-urlencoded');

		http.onreadystatechange = function() {//Call a function when the state changes.
			if (http.readyState == 4 && http.status == 200) {
				alert(http.responseText);
			}
		}
		http.send(params);
	}
}
	
	
</script>
</head>
<body>
	<h1>Registro de Clientes</h1>
	<table>
		<tr>
			<td><label for="txtCedula">Cedula:</label></td>
			<td><input type="text" id="txtCedula" name="cedula"></td>
		</tr>
		<tr>
			<td><label for="txtNombreCompleto">Nombre Completo</label></td>
			<td><input type="text" id="txtNombreCompleto"
				name="nombre_completo"></td>
		</tr>
		<tr>
			<td><label for="txtDireccion">Dirección:</label></td>
			<td><input type="text" id="txtDireccion" name="direccion"></td>
		</tr>
		<tr>
			<td><label for="txtTelefono">Telefono</label></td>
			<td><input type="text" id="txtTelefono" name="telefono"></td>
		</tr>
		<tr>
			<td><label for="txtCorreoElectronico">Correo
					Electrónico:</label></td>
			<td><input type="email" id="txtCorreoElectronico"
				name="correo_electronico"></td>
		</tr>

		<tr>
			<td><button onclick="sendData()">Enviar Datos</button></td>
			<td><button onclick="clearForm()">Cancelar</button></td>
		</tr>
	</table>


</body>
</html>