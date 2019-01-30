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
		testBillete.setCodAutobusVuelta(codAutobusIda);
		assertEquals(testBillete.getCodAutobusVuelta(),codAutobusIda);	
	}

	@Test
	public void testCodAutobusVuelta() {
		testBillete.setCodAutobusVuelta(codAutobusVuelta);
		assertEquals(testBillete.getCodAutobusVuelta(),codAutobusVuelta);	
	}
	
	@Test
	public void testPrecioTrayecto() {
		testBillete.setPrecioTrayecto(precioTrayecto);
		assertEquals(testBillete.getPrecioTrayecto(),precioTrayecto, 0.005);	
	}
	
	@Test
	public void testFechaIda() {
			
	}
	
	@Test
	public void testFechaVuelta() {
			
	}
}
