package testClases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import org.junit.Test;

import controlador.MetodosLoginYRegistro;

public class testValidaciones {
	private MetodosLoginYRegistro metodosLoginTest = new MetodosLoginYRegistro();
	private JTextField campoTextoTest=new JTextField();
	private JComboBox campoTextoTest1=new JComboBox(new String[] {"Hombre", "Mujer"});

	@Test
	public void testValidarLetras() {
		campoTextoTest.setText("1");
		assertEquals(metodosLoginTest.validarSoloLetras(campoTextoTest),false);
		assertEquals(campoTextoTest.getBackground(),new Color(240, 128, 128));
		
		campoTextoTest.setText("Juan");
		assertEquals(metodosLoginTest.validarSoloLetras(campoTextoTest),true);
		assertEquals(campoTextoTest.getBackground(),new JTextField().getBackground());	
	}
		
	
	
	@Test
	public void testvalidarDNI() {
		assertEquals(metodosLoginTest.validarDNI("7777777B"),true);
		assertEquals(metodosLoginTest.validarDNI("500PP"),false);
	}
	
	
	@Test
	public void testvalidarContrasenia() {
		 char[] numeros = new char[8];
		 numeros[0]='J';
		 numeros[1]='a';
		 numeros[2]='M';
		 numeros[3]='o';
		 numeros[4]='n';
		 numeros[5]=7;
		 numeros[6]=7;
		 numeros[7]=8;
		assertEquals(metodosLoginTest.validarContrasenia(numeros),true);
		
		numeros[0]='a';
		numeros[1]='l';
		numeros[2]='m';
		numeros[3]='e';
		numeros[4]='n';
		numeros[5]='d';
		numeros[6]='r';
		numeros[7]='a';
		assertEquals(metodosLoginTest.validarContrasenia(numeros),true);
	}

	@Test
	public void testCambioSexoAChar() {
		campoTextoTest1.setSelectedItem("Hombre");
		assertEquals(metodosLoginTest.cambiarSexoAChar(campoTextoTest1),'V');
		assertNotEquals(metodosLoginTest.cambiarSexoAChar(campoTextoTest1),'M');
		
		campoTextoTest1.setSelectedItem("Mujer");
		assertEquals(metodosLoginTest.cambiarSexoAChar(campoTextoTest1),'M');
		assertNotEquals(metodosLoginTest.cambiarSexoAChar(campoTextoTest1),'V');
	}
	
}
