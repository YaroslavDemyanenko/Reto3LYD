package testClases;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import clases.Cliente;

public class testCliente {

	public String dni = "485967R";
	public String nombre = "Nelda";
	public String apellido = "Lopez";
	public Date fechaNac;
	public char sexo = 'M';
	private String contrasenia;
	
	private Cliente testCliente = new Cliente();
	private Cliente testcons1Cliente = new Cliente(dni, nombre, apellido, fechaNac, sexo, contrasenia);
	private Cliente testcons3Cliente = new Cliente(nombre, apellido, dni, sexo);
	
	@Test
	public void testContrasenia() {
		testCliente.setContrasenia(contrasenia);
		assertEquals(testCliente.getContrasenia(),contrasenia);
	}
	
	@Test
	public void testConstructor1() {
		
		assertEquals(testcons1Cliente.dni, dni);
		assertEquals(testcons1Cliente.nombre, nombre);
		assertEquals(testcons1Cliente.apellido, apellido);
		assertEquals(testcons1Cliente.fechaNac, fechaNac);
		assertEquals(testcons1Cliente.sexo, sexo);
		assertEquals(testcons1Cliente.getContrasenia(), contrasenia);
	}
	
	@Test
	public void testConstructor2() {
		
		assertEquals(testCliente.dni, null);
		assertEquals(testCliente.nombre, null);
		assertEquals(testCliente.apellido, null);
		assertEquals(testCliente.fechaNac, null);
		assertEquals(testCliente.sexo, '\u0000');
		assertEquals(testCliente.getContrasenia(), null);
	}
	
	@Test
	public void testConstructor3() {
		
		assertEquals(testcons3Cliente.dni, dni);
		assertEquals(testcons3Cliente.nombre, nombre);
		assertEquals(testcons3Cliente.apellido, apellido);
		assertEquals(testcons3Cliente.sexo, sexo);
	}

}
