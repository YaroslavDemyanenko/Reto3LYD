package testClases;

import static org.junit.Assert.*;

import org.junit.Test;

import clases.Parada;

public class testParada {

	private int codigo = 458;
	private String calle = "San Miguel";
	private String nombParada = "Norte";
	private double latitud = 43.2603479;
	private double longitud = -2.9334110;
	
	private Parada testParada = new Parada();
	
	@Test
	public void testCodigo() {
		testParada.setCodigo(codigo);
		assertEquals(testParada.getCodigo(),codigo);	
	}

	@Test
	public void testCalle() {
		testParada.setCalle(calle);
		assertEquals(testParada.getCalle(),calle);	
	}
	
	@Test
	public void testNombParada() {
		testParada.setNombParada(nombParada);
		assertEquals(testParada.getNombParada(),nombParada);	
	}
	
	@Test
	public void testLatitud() {
		testParada.setLatitud(latitud);
		assertEquals(testParada.getLatitud(),latitud, 0.5);	
	}
	
	@Test
	public void testLongitud() {
		testParada.setLongitud(longitud);
		assertEquals(testParada.getLongitud(),longitud, 0.5);	
	}
}
