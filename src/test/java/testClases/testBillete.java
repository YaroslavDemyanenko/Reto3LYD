package testClases;

import static org.junit.Assert.*;

import java.sql.Date;
import java.text.DateFormat;

import org.junit.Test;

import clases.Billete;
import clases.Linea;
import clases.Parada;

public class testBillete {

	int codigoBillete;
	int codAutobusIda;
	int codAutobusVuelta;
	float precioTrayecto;
	Date fechaIda;
	Date fechaVuelta;
	Date fecha;
	Linea linea;
	Parada paradaInic;
	Parada paradaFin;
	
	Billete testBillete = new Billete();
	Billete test2Billete = new Billete(precioTrayecto, fecha, linea, paradaInic, paradaFin);
	
	
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
