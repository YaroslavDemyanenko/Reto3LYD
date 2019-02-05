package testClases;

import static org.junit.Assert.assertEquals;

import java.awt.Color;

import javax.swing.JTextField;

import org.junit.Test;

import controlador.MetodosLoginYRegistro;

public class testValidaciones {
	private MetodosLoginYRegistro metodosLoginTest = new MetodosLoginYRegistro();
	private JTextField campoTextoTest=new JTextField();

	@Test
	public void testValidarNombre() {
		campoTextoTest.setText("1");
		assertEquals(metodosLoginTest.validarSoloLetras(campoTextoTest),false);
		assertEquals(campoTextoTest.getBackground(),new Color(240, 128, 128));
		campoTextoTest.setText("Juan");
		assertEquals(metodosLoginTest.validarSoloLetras(campoTextoTest),true);
		assertEquals(campoTextoTest.getBackground(),new JTextField().getBackground());	
	}
		
	
//	@Test
//	public void testCambiarSexoAChar() {
//		assertEquals(cambiarSexoAChar("Hombre"),'V');
//	}
//	
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
	}


}
