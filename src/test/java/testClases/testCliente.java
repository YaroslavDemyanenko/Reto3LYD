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
	
	private Cliente testCliente = new Cliente();
	
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
}
