package testClases;

import static org.junit.Assert.*;

import org.junit.Test;

import clases.Parada;

public class testParada {

	private int codigo = 458;
	private String calle = "San Miguel";
	private String nombParada = "Norte";
	private float latitud = 43.2603479f;
	private float longitud = -2.9334110f;
	
	private Parada testParada = new Parada();
	private Parada testcons2parada = new Parada(codigo, calle, nombParada, latitud, longitud);
	private Parada testcons3parada = new Parada(codigo, calle, nombParada);
	
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
		testParada.setnombreParada(nombParada);
		assertEquals(testParada.getnombreParada(),nombParada);	
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
	
	@Test
	public void testConstructor2() {
		assertEquals(testcons2parada.getCodigo(), 458);
		assertEquals(testcons2parada.getCalle(), "San Miguel");
		assertEquals(testcons2parada.getnombreParada(), "Norte");
		assertEquals(testcons2parada.getLatitud(), latitud, 0.000001);	
		assertEquals(testcons2parada.getLongitud(), longitud, 0.000001);
	}
	
	@Test
	public void testConstructor3() {
		assertEquals(testcons3parada.getCodigo(), 458);
		assertEquals(testcons3parada.getCalle(), "San Miguel");
		assertEquals(testcons3parada.getnombreParada(), "Norte");
	}
	
	@Test
	public void testConstructor1() {
		assertEquals(testParada.getCodigo(), 0);
		assertEquals(testParada.getCalle(), null);
		assertEquals(testParada.getnombreParada(), null);
		assertEquals(testParada.getLatitud(), 0d, 0.000001);	
		assertEquals(testParada.getLongitud(), 0d, 0.000001);
	}
}
