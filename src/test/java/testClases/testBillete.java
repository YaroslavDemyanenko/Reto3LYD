package testClases;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import clases.Billete;
import clases.Linea;
import clases.Parada;
import controlador.MetodosPago;

public class testBillete {

	private int codigoBillete =0;
	private int codAutobusVuelta =0;
	private float precioTrayecto = 0;
	private Date fecha;
	private Linea linea;
	private Parada paradaInic=new Parada();
	private Parada paradaFin=new Parada();
	 
	private Billete testBillete = new Billete();
	private MetodosPago metPago=new MetodosPago();
	
	@Test
	public void testDistanciaEnKmEntreDosParadas() {
		Billete test2Billete = new Billete(precioTrayecto, fecha, linea, paradaInic, paradaFin);
		test2Billete.paradaInic.latitud= 43.257;
		test2Billete.paradaInic.longitud= -2.92344;
		test2Billete.paradaFin.latitud= 42.8462700;
		test2Billete.paradaFin.longitud= -2.6722500;
		metPago.distanciaEnKmEntreDosParadas(this.paradaInic, this.paradaFin);
		assertEquals(metPago.distanciaEnKmEntreDosParadas(this.paradaInic, this.paradaFin), 50.01,0.1);
	}
	
	@Test
	public void testclasePrecioTrayecto() {
		Billete test2Billete = new Billete(precioTrayecto, fecha, linea, paradaInic, paradaFin);
		test2Billete.paradaInic.latitud= 43.257;
		test2Billete.paradaInic.longitud= -2.92344;
		test2Billete.paradaFin.latitud= 42.8462700;
		test2Billete.paradaFin.longitud= -2.6722500;
		double consumo = 50.23;
		
		assertEquals(metPago.precioTrayecto(test2Billete.paradaInic, test2Billete.paradaFin, consumo),2412.20,0.01);
	}
	
	@Test
	public void testConsBillete() {
		Billete test3Billete = new Billete(linea,paradaInic,paradaFin);
		assertEquals(test3Billete.getLinea(), null);
		assertEquals(test3Billete.getParadaInic(), paradaInic);
		assertEquals(test3Billete.getParadaFin(), paradaFin);
		assertEquals(test3Billete.getFecha(), null);
	}
	
	@Test
	public void testCodigoBillete() {
		testBillete.setCodigoBillete(codigoBillete);
		assertEquals(testBillete.getCodigoBillete(),codigoBillete);	
	}
	
	@Test
	public void testCodAutobusIda() {
		testBillete.setFecha(fecha);
		assertEquals(testBillete.getFecha(),fecha);
	}
	
	@Test
	public void testFecha() {
		fecha=new Date();
		testBillete.setFecha(fecha); 
		assertEquals(testBillete.getFecha(),fecha);	
	}

	
	@Test
	public void testCodAutobusVuelta() {
		testBillete.setCodAutobus(codAutobusVuelta);
		assertEquals(testBillete.getCodAutobus(),codAutobusVuelta);	
	}
	
	@Test
	public void testPrecioTrayecto() {
		testBillete.setPrecioTrayecto(precioTrayecto);
		assertEquals(testBillete.getPrecioTrayecto(),precioTrayecto, 0.005);	
	}

	
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
