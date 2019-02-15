package testClases;
import static org.mockito.Mockito.*;
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
	public void testConfirmacionDatos() {
		Metodos metodosTest2 = new Metodos();
		PanelConfirmacion panel1Mock = mock(PanelConfirmacion.class);
		PanelLineas2 panel2Mock = mock(PanelLineas2.class);
		PanelLineas1 panel3Mock = mock(PanelLineas1.class);
		Modelo modeloMock = mock(Modelo.class);
		when(panel1Mock.getPasajeros()).thenReturn(18);
		metodosTest.confirmacionDatos(panel1Mock, panel2Mock, panel3Mock, modeloMock);
		verify(panel1Mock, times(1)).getPasajeros();
		verify(panel1Mock, times(1)).actualizarPosicion(18);
		verify(panel1Mock, times(1)).actualizarNombre(modeloMock, 18);
		verify(panel1Mock, times(1)).actualizarApellido(modeloMock, 18);
		verify(panel1Mock, times(1)).actualizarLinea(panel2Mock);
	}
	
	@Test
	public void testConfirmacionTrayectos() {
		Metodos metodosTest2 = new Metodos();
		PanelConfirmacion panel1Mock = mock(PanelConfirmacion.class);
		PanelLineas2 panel2Mock = mock(PanelLineas2.class);
		PanelLineas1 panel3Mock = mock(PanelLineas1.class);
		Modelo modeloMock = mock(Modelo.class);
		when(panel1Mock.getPasajeros()).thenReturn(18);
		metodosTest.confirmacionTrayecto(panel1Mock, panel2Mock, panel3Mock, modeloMock);
		verify(panel1Mock, times(1)).actualizarParadaInicio(panel3Mock);
		verify(panel1Mock, times(1)).actualizarParadaFin(panel2Mock);
		verify(panel1Mock, times(1)).actualizarFechaIda(panel2Mock);
		verify(panel1Mock, times(1)).actualizarFechaVuelta(panel2Mock);
		verify(panel1Mock, times(1)).actualizarTipoTrayecto(modeloMock);
		
		
	}
	
	
	
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
		JTextField valid = new JTextField("22758295W");
		assertEquals(metodosLoginTest.validarDNI(valid),true);
		valid.setText("500PP"); 
		assertEquals(metodosLoginTest.validarDNI(valid),false);
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
	

	
}
