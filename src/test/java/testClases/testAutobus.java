package testClases;

import static org.junit.Assert.*;

import org.junit.Test;

import clases.Autobus;

public class testAutobus {

	private int codigo = 45856564;
	private int numPlazas = 35;
	private double consumoKm = 8.5;
	private String color = "Verde";
	
	private Autobus testAutobus = new Autobus();
	
	
	@Test
	public void testCosumoKm() {
		testAutobus.setConsumoKm(consumoKm);
		assertEquals(testAutobus.getConsumoKm(), consumoKm, 0.05);
	}

	@Test
	public void testCodigo() {
		testAutobus.setCodigo(codigo);
		assertEquals(testAutobus.getCodigo(), codigo);
	}
	
	@Test
	public void testnumPlazas() {
		testAutobus.setNumPlazas(numPlazas);
		assertEquals(testAutobus.getNumPlazas(), numPlazas);
	}
	
	@Test
	public void testColor() {
		testAutobus.setColor(color);
		assertEquals(testAutobus.getColor(), color);
	}
}
