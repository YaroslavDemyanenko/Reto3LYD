package testClases;

import static org.junit.Assert.*;

import org.junit.Test;

import clases.Municipio;

public class testMunicipio {

	String nombre = "Igorre" ;
	int codigoPostal = 48340;
	
	 Municipio testMunicipio = new Municipio();
	 Municipio testcons2Municipio = new Municipio(nombre, codigoPostal);
	
	@Test
	public void testContructor1() {
		
		assertEquals(testMunicipio.nombre, "Igorre");
		assertEquals(testMunicipio.codigoPostal, 48340);
	}

	public void testContructor2() {
		
		assertEquals(testcons2Municipio.nombre, nombre);
		assertEquals(testcons2Municipio.codigoPostal, codigoPostal);
	}
}
