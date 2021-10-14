<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tienda Virtual: Ingreso de Usuarios</title>
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
	
	function enviarDatos() {
		if(validarDatos()){
			
		    var user = document.getElementById("txtUser").value.trim();
            var pass = document.getElementById("txtPass").value.trim();
            
            //SEÑORAS Y SEÑORES PARA USTEDES EL FAMOSISIMO OBJETO XMLHttpREQUEST
            var mensajero = new XMLHttpRequest();
            
            var url = "/TiendaVirtualPrototipo_1/SrvRegistroUsuarios";
            var params = "user=" + user+ "&" + "pass=" + pass;
            mensajero.open('POST', url, true);
            
            //Send the proper header information along with the request
            mensajero.setRequestHeader('Content-type',
                    'application/x-www-form-urlencoded');
            mensajero.onreadystatechange = function() {//Call a function when the state changes.
                if (mensajero.readyState == 4 && mensajero.status == 200) {
                    alert(mensajero.responseText);
                }
            }
            mensajero.send(params);
		}
		else{
			alert("algo va mal");
		}
		
		return;
	}
	function validarDatos() {
		if (document.getElementById("txtUser").value.length == 0){
			alert("El campo user esta vacio!");
			return false;
	    }else if (document.getElementById("txtPass").value.length == 0){
			alert("El campo nombre esta vacio!");
			return false;
	    }	
	    else{
	    	return true;
	    }	
	    
	}
</script>
</head>
<body>

	<table border='1'>
		<tr>
			<td><strong>TIENDA VIRTUAL INGRESO DE USUARIOS</strong></td>
		</tr>
		<tr>
			<td>Usuario:</td>
			<td><input type="text" id="txtUser" name="user"></input></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" id="txtPass" name="pass"></input></td>
		</tr>
	</table>

	<br>
	<button onclick='enviarDatos()'>Login</button>
	<br>
	<br>
	<a href="Cliente.jsp">Ir a pagina de registro</a>
	<br>

</body>
</html>