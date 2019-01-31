package testClases;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import clases.Cliente;

public class textCliente {

	public String dni = "485967R";
	public String nombre = "Nelda";
	public String apellido = "Lopez";
	public Date fechaNac;
	public char sexo = 'M';
	private char[] contrasenia;
	
	private Cliente testCliente = new Cliente();
	private Cliente testcons2Cliente = new Cliente();
	
	@Test
	public void testContrasenia() {
		testCliente.setContrasenia(contrasenia);
		assertEquals(testCliente.getContrasenia(),contrasenia);
	}
	
	@Test
	public void testConstructor2() {
		
		assertEquals(testcons2Cliente.dni, dni);
		assertEquals(testcons2Cliente.nombre, nombre);
		assertEquals(testcons2Cliente.apellido, apellido);
		assertEquals(testcons2Cliente.fechaNac, fechaNac);
		assertEquals(testcons2Cliente.sexo, sexo);
		assertEquals(testcons2Cliente.getContrasenia(), contrasenia);
	}

}
