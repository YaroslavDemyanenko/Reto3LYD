package testClases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import org.junit.Test;

import controlador.Metodos;
import controlador.MetodosLoginYRegistro;
import interfaces.PanelConfirmacion;
import interfaces.PanelLineas1;
import interfaces.PanelLineas2;
import interfaces.PanelPasajeroExtra;
import clases.Cliente;
import clases.Modelo;



public class testValidaciones {
	private MetodosLoginYRegistro metodosLoginTest = new MetodosLoginYRegistro();
	private Metodos metodosTest = new Metodos();
	private JTextField campoTextoTest=new JTextField();
	private JComboBox campoTextoTest1=new JComboBox(new String[] {"Hombre", "Mujer"});
	private DefaultComboBoxModel<String> modeloPasajero;
	private Cliente cliente = new Cliente();
	private PanelPasajeroExtra panel = new PanelPasajeroExtra();
	private PanelConfirmacion panel1 = new PanelConfirmacion();
	private PanelLineas2 panel2 = new PanelLineas2();
	private PanelLineas1 panel3 = new PanelLineas1();
	private Modelo mod = new Modelo();
	
	
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
	

	@Test
	public void testPasajeroExtra() {
		Cliente[] cliente = new Cliente[1];
		panel.textFieldNombre.setText("TestNombre");
		panel.textFieldApellido.setText("TestApellido");
		panel.textFieldDNI.setText("TestDNI");
		panel.textFieldSexo.setSelectedItem("Hombre");
		metodosTest.pasajeroExtra(panel, cliente);
		assertEquals(cliente[1].nombre,"TestNombre");
		assertEquals(cliente[1].apellido,"TestApellido");
		assertEquals(cliente[1].dni,"TestDNI");
		assertEquals(cliente[1].sexo,'V');
	}
	
	@Test
	public void testConfirmacionDatos() {
		panel1.lblFieldCodigo.setText("00008");
		assertEquals(panel1.lblFieldCodigo,"00008");
	}
	
}
