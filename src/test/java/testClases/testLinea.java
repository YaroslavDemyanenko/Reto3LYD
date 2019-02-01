package testClases;

import static org.junit.Assert.*;

import org.junit.Test;

import clases.Linea;

public class testLinea {

	String codigo = "L3";
	
	private Linea testLinea = new Linea();
	private Linea test2Linea = new Linea(codigo);
	@Test
	public void testConstructor2() {

		assertEquals(testLinea.getCodigo(), null);
	}
	
	@Test
	public void testCodigo() {

		testLinea.setCodigo(codigo);
		assertEquals(testLinea.getCodigo(), codigo);
	}
	
	@Test
	public void testConstructor1() {

		assertEquals(test2Linea.getCodigo(), codigo);
	}

}
