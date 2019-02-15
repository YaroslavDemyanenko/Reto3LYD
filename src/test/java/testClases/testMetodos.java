package testClases;

import static org.junit.Assert.*;

import org.junit.Test;

import controlador.Metodos;
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
