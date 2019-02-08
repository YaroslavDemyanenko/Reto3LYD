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
		 char[] bueno = new char[8];
		 bueno[0]='J';
		 bueno[1]='a';
		 bueno[2]='M';
		 bueno[3]='o';
		 bueno[4]='n';
		 bueno[5]='7';
		 bueno[6]='7';
		 bueno[7]='8';
		assertEquals(metodosLoginTest.validarContrasenia(bueno),true);
		
<<<<<<< HEAD
		numeros[0]='a';
		numeros[1]='l';
		numeros[2]='m';
		numeros[3]='e';
		numeros[4]='n';
		numeros[5]='d';
		numeros[6]='r';
		numeros[7]='a';
		assertEquals(metodosLoginTest.validarContrasenia(numeros),true);
=======
		char[] malo = new char[8];
		malo[0]='a';
		malo[1]='l';
		malo[2]='m';
		malo[3]='e';
		malo[4]='n';
		malo[5]='d';
		malo[6]='r';
		malo[7]='a';
		assertEquals(metodosLoginTest.validarContrasenia(malo),false);
>>>>>>> 2aba49068312911a20ac08fb6a1400c027b5d2d7
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
