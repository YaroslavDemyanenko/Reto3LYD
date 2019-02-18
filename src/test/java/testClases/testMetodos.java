package testClases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import controlador.MetodosPago;

public class testMetodos {

	@Test
	public void testRedondear() {
		int numDecimales = 2;
		double numero = 3.25564;
		
		MetodosPago testMetodos = new MetodosPago();
		
		assertEquals(testMetodos.redondear(numero, numDecimales),3.25,0.01);
	}

}
