package testClases;

import static org.junit.Assert.*;

import java.sql.Date;
import java.text.DateFormat;

import org.junit.Test;

import clases.Billete;
import clases.Linea;
import clases.Parada;

public class testBillete {

	private int codigoBillete =0;
	private int codAutobusIda =0;
	private int codAutobusVuelta =0;
	private float precioTrayecto = 0;
	private Date fechaIda;
	private Date fechaVuelta;
	private Date fecha;
	private Linea linea;
	private Parada paradaInic=new Parada();
	private Parada paradaFin=new Parada();
	 
	private Billete testBillete = new Billete();

	
	
	@Test
	public void testDistanciaEnKmEntreDosParadas() {
		Billete test2Billete = new Billete(precioTrayecto, fecha, linea, paradaInic, paradaFin);
		test2Billete.paradaInic.latitud= 43.257;
		test2Billete.paradaInic.longitud= -2.92344;
		test2Billete.paradaFin.latitud= 42.8462700;
		test2Billete.paradaFin.longitud= -2.6722500;
		//test2Billete.distanciaEnKmEntreDosParadas(this.paradaInic, this.paradaFin);
		assertEquals(test2Billete.distanciaEnKmEntreDosParadas(this.paradaInic, this.paradaFin), 50.01,0.1);
	}
	
	@Test
	public void testclasePrecioTrayecto() {
		Billete test2Billete = new Billete(precioTrayecto, fecha, linea, paradaInic, paradaFin);
		test2Billete.paradaInic.latitud= 43.257;
		test2Billete.paradaInic.longitud= -2.92344;
		test2Billete.paradaFin.latitud= 42.8462700;
		test2Billete.paradaFin.longitud= -2.6722500;
		double consumo = 50.23;
		int numeroPlazas =5;
		assertEquals(test2Billete.precioTrayecto(test2Billete.paradaInic, test2Billete.paradaFin, consumo, numeroPlazas),482.44,0.1);
	}
	
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
