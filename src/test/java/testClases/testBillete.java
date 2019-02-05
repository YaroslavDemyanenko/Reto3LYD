package testClases;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import clases.Billete;
import clases.Linea;
import clases.Parada;

public class testBillete {

	int codigoBillete,codAutobusIda,codAutobusVuelta;
	float precioTrayecto;
	Date fechaIda, fechaVuelta;
	Linea linea;
	Parada paradaInic, paradaFin;
	
	Billete testBillete = new Billete();
	
	@Test
	public void testCodigoBillete() {
		testBillete.setCodigoBillete(codigoBillete);
		assertEquals(testBillete.getCodigoBillete(),codigoBillete);	
	}
	
	@Test
	public void testCodAutobusIda() {
		testBillete.setCodAutobusIda(codAutobusIda);
		assertEquals(testBillete.getCodAutobusIda(),codAutobusIda);	
	}

	/*
	@Test
	public void testCodAutobusVuelta() {
		testBillete.setCodAutobusVuelta(codAutobusVuelta);
		assertEquals(testBillete.getCodAutobusVuelta(),codAutobusVuelta);	
	}
	*/
	@Test
	public void testPrecioTrayecto() {
		testBillete.setPrecioTrayecto(precioTrayecto);
		assertEquals(testBillete.getPrecioTrayecto(),precioTrayecto, 0.005);	
	}
	
	@Test
	public void testFechaIda() {
		testBillete.setFechaIda(fechaIda);
		assertEquals(testBillete.getFechaIda(),fechaIda);
	}
	
	/*
	@Test
	public void testFechaVuelta() {
		testBillete.setFechaVuelta(fechaVuelta);
		assertEquals(testBillete.getFechaVuelta(),fechaVuelta);
	}
	*/
	
	@Test
	public void testLinea() {
		testBillete.setLinea(linea);
		assertEquals(testBillete.getLinea(),linea);
	}
	
	@Test
	public void testParadaInic() {
		testBillete.setParadaInic(paradaInic);
		assertEquals(testBillete.getParadaInic(),paradaInic);
	}
	
	@Test
	public void testParadaFin() {
		testBillete.setParadaFin(paradaFin);
		assertEquals(testBillete.getParadaFin(),paradaFin);
	}
}
