package testClases;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.junit.Test;

import clases.Autobus;
import clases.Billete;
import clases.Cliente;
import clases.Linea;
import clases.Modelo;
import clases.Municipio;
import clases.Parada;
import conexion.ConexionAMySQL;
import controlador.Metodos;
import controlador.MetodosLoginYRegistro;

public class testModelo {

	public Billete billeteIda,billeteVuelta;
	private boolean idaYVuelta=false;
	public int numeroBilletes;
	public Cliente clienteRegistrado;
	public JPanel ultimoPanel;
	public Parada paradaSalida, paradaDestino;
	
	private Modelo testModelo = new Modelo();
	
	@Test
	public void testidaYVuelta() {
		testModelo.setIdaYVuelta(idaYVuelta);
		assertEquals(testModelo.isIdaYVuelta(), idaYVuelta);
	}
	
	@Test
	public void testConstructor1() {
		testModelo.reset();
		assertEquals(testModelo.billeteIda, billeteIda);
		assertEquals(testModelo.billeteVuelta, billeteVuelta);
		assertEquals(testModelo.numeroBilletes, numeroBilletes);
		assertEquals(testModelo.clienteRegistrado, clienteRegistrado);
		assertEquals(testModelo.ultimoPanel, ultimoPanel);
		assertEquals(testModelo.paradaSalida, paradaSalida);
		assertEquals(testModelo.paradaDestino, paradaDestino);
		assertEquals(testModelo.isIdaYVuelta(), idaYVuelta);
	}

}
