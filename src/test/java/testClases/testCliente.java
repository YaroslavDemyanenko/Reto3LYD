package testClases;
import static org.junit.Assert.*;

import org.junit.Test;

import clases.Cliente;

public class testCliente {

	private String dni = "2448313F";
	private String nombre = "Nelda";
	private String apellido = "Jimenez";
	private String sexo = "Mujer";
	private String contrasenia = "cosas";
	private String fecha_nac = "";
	
	private Cliente testCliente = new Cliente();
	private Cliente testcons3Cliente = new Cliente(nombre, apellido, dni, sexo);
	private Cliente testcons1Cliente = new Cliente(dni, nombre, apellido, fecha_nac, sexo, contrasenia);
	
	
	@Test
	public void testDni() {
		testCliente.setDni(dni);
		assertEquals(testCliente.getDni(), dni);
	}
	
	
	@Test
	public void testNombre() {
		testCliente.setNombre(nombre);
		assertEquals(testCliente.getNombre(), nombre);
	}
	
	@Test
	public void testFecha_nac() {
		testCliente.setFecha_nac(fecha_nac);
		assertEquals(testCliente.getFecha_nac(), fecha_nac);
	}

	@Test
	public void testApellido() {
		testCliente.setApellido(apellido);
		assertEquals(testCliente.getApellido(), apellido);
	}
	
	@Test
	public void testSexo() {
		testCliente.setSexo(sexo);
		assertEquals(testCliente.getSexo(), sexo);
	}
	
	@Test
	public void testContrasenia() {
		testCliente.setContrasenia(contrasenia);
		assertEquals(testCliente.getContrasenia(), contrasenia);
	}
	
	@Test
	public void testcons3Cliente() {
		assertEquals(testcons3Cliente.getNombre(), nombre);
		assertEquals(testcons3Cliente.getApellido(), apellido);
		assertEquals(testcons3Cliente.getDni(), dni);
		assertEquals(testcons3Cliente.getSexo(), sexo);
	}
	
	@Test
	public void testcons1Cliente() {
		assertEquals(testcons1Cliente.getNombre(), nombre);
		assertEquals(testcons1Cliente.getApellido(), apellido);
		assertEquals(testcons1Cliente.getDni(), dni);
		assertEquals(testcons1Cliente.getSexo(), sexo);
		assertEquals(testcons1Cliente.getFecha_nac(), fecha_nac);
		assertEquals(testcons1Cliente.getContrasenia(), contrasenia);
		
	}
	
	@Test
	public void testCliente() {
		assertEquals(testCliente.getNombre(), null);
		assertEquals(testCliente.getApellido(), null);
		assertEquals(testCliente.getDni(), null);
		assertEquals(testCliente.getSexo(), null);
		assertEquals(testCliente.getFecha_nac(), null);
		assertEquals(testCliente.getContrasenia(), null);
		
	}
	
}
