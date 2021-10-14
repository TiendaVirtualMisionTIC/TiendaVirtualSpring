package com.uelbosque.virtualstore.TiendaVirtualSpring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaSpring {
	@RequestMapping("/saludo")
	public String Saludo() {
		return "Hola Spring, que bueno verte";
	}
	
	@RequestMapping("/despedir")
	public String despedir() {
		return "Adios Spring, que te vaya bonito...";
	}
}
