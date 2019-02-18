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
		
		assertEquals(testMunicipio.getNombre(), null);
		assertEquals(testMunicipio.getCodigoPostal(), 0);
	}

	@Test
	public void testContructor2() {
		
		assertEquals(testcons2Municipio.getNombre(), nombre);
		assertEquals(testcons2Municipio.getCodigoPostal(), codigoPostal);
	}
	
	@Test
	public void testNombre() {
		testMunicipio.setNombre(nombre);
		assertEquals(testMunicipio.getNombre(),nombre);	
	}
	
	@Test
	public void testCodigoPostal() {
		testMunicipio.setCodigoPostal(codigoPostal);
		assertEquals(testMunicipio.getCodigoPostal(),codigoPostal);	
	}
}
