package testClases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JPanel;

import org.junit.Test;
import org.mockito.Mockito;

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

	private Billete billeteIda,billeteVuelta;
	private boolean idaYVuelta = false;
	private int numeroBilletes = 0;
	private Cliente clienteRegistrado;
	private JPanel ultimoPanel;
	private Parada paradaSalida, paradaDestino;
	private ConexionAMySQL db;
	
	private Modelo testModeloConstrutor = new Modelo();
	private ConexionAMySQL dbMock = mock(ConexionAMySQL.class);
	private Modelo testModeloConstructor2 = new Modelo(dbMock);
	
	@Test
	public void testidaYVuelta() {
		testModeloConstrutor.setIdaYVuelta(idaYVuelta);
		assertEquals(testModeloConstrutor.isIdaYVuelta(), idaYVuelta);
	}
	
	@Test
	public void testConstructor1() {
		assertEquals(testModeloConstrutor.billete, null);
		assertEquals(testModeloConstrutor.cliente, null);
		assertEquals(testModeloConstrutor.linea, null);
		assertEquals(testModeloConstrutor.municipio, null);
		assertEquals(testModeloConstrutor.parada, null);
		assertEquals(testModeloConstrutor.metodo, null);
		assertEquals(testModeloConstrutor.db, null);		
		assertEquals(testModeloConstrutor.metodosLogin, null);
		assertEquals(testModeloConstrutor.billeteGeneralIda.getClass(), Billete.class);
		assertNotEquals(testModeloConstrutor.billeteGeneralIda, null);
		assertEquals(testModeloConstrutor.billeteGeneralVuelta.getClass(), Billete.class);
		assertNotEquals(testModeloConstrutor.billeteGeneralVuelta, null);
		assertEquals(testModeloConstrutor.fechaIda, null);
		assertEquals(testModeloConstrutor.fechaVuelta, null);
		assertEquals(testModeloConstrutor.colorCalendario, null);
		assertEquals(testModeloConstrutor.billeteIda, null);
		assertEquals(testModeloConstrutor.billeteVuelta, null);
		assertEquals(testModeloConstrutor.numeroBilletes, 0);
		assertEquals(testModeloConstrutor.clienteRegistrado, null);
		assertEquals(testModeloConstrutor.ultimoPanel, null);
		assertEquals(testModeloConstrutor.paradaSalida, null);
		assertEquals(testModeloConstrutor.paradaDestino, null);
		assertEquals(testModeloConstrutor.isIdaYVuelta(), false);
		assertEquals(testModeloConstrutor.autobus, null);
		assertEquals(testModeloConstrutor.lineas.size(), 0);
		assertTrue(testModeloConstrutor.lineas.isEmpty());
		assertEquals(testModeloConstrutor.arrayParadas.size(), 0); /*Comprueb que el array esta en la posicion 0*/
		assertTrue(testModeloConstrutor.arrayParadas.isEmpty()); /*Comprueba que el array esta vacio*/
	}
	
	@Test
	public void testConstructor2() throws SQLException  {
		assertEquals(testModeloConstructor2.billete.getClass(), Billete.class);
		assertNotEquals(testModeloConstructor2.billete, null);
		assertEquals(testModeloConstructor2.cliente.getClass(), Cliente.class);
		assertNotEquals(testModeloConstructor2.cliente, null);
		assertEquals(testModeloConstructor2.linea.getClass(), Linea.class);
		assertNotEquals(testModeloConstructor2.linea, null);
		assertEquals(testModeloConstructor2.municipio.getClass(), Municipio.class);
		assertNotEquals(testModeloConstructor2.municipio, null);
		assertEquals(testModeloConstructor2.parada.getClass(), Parada.class);
		assertNotEquals(testModeloConstructor2.parada, null);
		assertEquals(testModeloConstructor2.metodo.getClass(), Metodos.class);
		assertNotEquals(testModeloConstructor2.metodo, null);
		assertEquals(testModeloConstructor2.metodosLogin.getClass(), MetodosLoginYRegistro.class);
		assertNotEquals(testModeloConstructor2.metodosLogin, null);
		verify(dbMock, times(1)).inicializarLineas(Mockito.any(Modelo.class)); /*Comprueba que con el mock que se haya llamado 1 vez a la clase inicializarLineas en la baase de datos*/
		assertNotEquals(testModeloConstructor2.db, null);	
		assertEquals(testModeloConstructor2.billeteGeneralIda.getClass(), Billete.class);
		assertNotEquals(testModeloConstructor2.billeteGeneralIda, null);
		assertEquals(testModeloConstructor2.billeteGeneralVuelta.getClass(), Billete.class);
		assertNotEquals(testModeloConstructor2.billeteGeneralVuelta, null);
		assertEquals(testModeloConstructor2.fechaIda, null);
		assertEquals(testModeloConstructor2.fechaVuelta, null);
		assertEquals(testModeloConstructor2.colorCalendario, null);
		assertEquals(testModeloConstructor2.billeteIda, null);
		assertEquals(testModeloConstructor2.billeteVuelta, null);
		assertEquals(testModeloConstructor2.numeroBilletes, 0);
		assertEquals(testModeloConstructor2.clienteRegistrado, null);
		assertEquals(testModeloConstructor2.ultimoPanel, null);
		assertEquals(testModeloConstructor2.paradaSalida, null);
		assertEquals(testModeloConstructor2.paradaDestino, null);
		assertEquals(testModeloConstructor2.isIdaYVuelta(), false);
		assertEquals(testModeloConstructor2.autobus.getClass(), Autobus.class);
		assertNotEquals(testModeloConstructor2.autobus, null);
		assertEquals(testModeloConstructor2.lineas.size(), 0);
		assertTrue(testModeloConstructor2.lineas.isEmpty());
		assertEquals(testModeloConstructor2.arrayParadas.size(), 0);
		assertTrue(testModeloConstructor2.arrayParadas.isEmpty());
	}
	
	@Test
	public void testReset() {
		Modelo testModeloConstrutor = new Modelo();
		testModeloConstrutor.reset();
		assertEquals(testModeloConstrutor.billeteIda.getClass(), Billete.class);
		assertNotEquals(testModeloConstrutor.billeteIda, null);
		assertEquals(testModeloConstrutor.billeteVuelta.getClass(), Billete.class);
		assertNotEquals(testModeloConstrutor.billeteVuelta, null);
		assertEquals(testModeloConstrutor.numeroBilletes, 0);
		assertEquals(testModeloConstrutor.clienteRegistrado, null);
	    assertEquals(testModeloConstrutor.ultimoPanel.getClass(), JPanel.class);
	    assertNotEquals(testModeloConstrutor.ultimoPanel, null);
		assertEquals(testModeloConstrutor.paradaSalida.getClass(), Parada.class);
		assertNotEquals(testModeloConstrutor.paradaSalida, null);
		assertEquals(testModeloConstrutor.paradaDestino.getClass(), Parada.class);
		assertNotEquals(testModeloConstrutor.paradaDestino, null);
		assertEquals(testModeloConstrutor.isIdaYVuelta(), false);
	}

}
