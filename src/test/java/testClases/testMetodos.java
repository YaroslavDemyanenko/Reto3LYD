package testClases;

import static org.junit.Assert.*;

import org.junit.Test;

import clases.Modelo;
import controlador.Metodos;

public class testMetodos {

	@Test
	public void testRound() {
		int numDecimales = 2;
		double numero = 3.25564;
		
		Metodos testMetodos = new Metodos();
		
		assertEquals(testMetodos.round(numero, numDecimales),3.25,0.01);
	}

}
