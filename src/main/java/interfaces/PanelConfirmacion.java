package interfaces;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import com.toedter.calendar.JDateChooser;

import clases.Modelo;

import com.toedter.calendar.JCalendar;
import java.util.Date;
import com.toedter.calendar.IDateEditor;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
/**
 * @wbp.parser.entryPoint
 */
public class PanelConfirmacion extends JPanel {

	public JLabel lblFieldCodigo, lblFieldNombre, lblFieldApellidos, lblFieldDNI, lblFieldParadaFin, lblFieldParadaInicio, lblFieldLinea, lblFieldTipoTrayecto, lblFieldPrecioBillete;
	public JButton btnLogIn, btnCancelar, btnImprimir;
	public JLabel lblUsuario, lblCdigo, lblNombre, lblApellidos, lblDni, lblLnea, lblSalida, lblLlegada, lblTipoDeTrayecto, lblFechaIda, lblFechaVuelta, lblPrecioBillete, lblPasajerosas;
	public JDateChooser fechaIda,fechaVuelta;
	public JComboBox comboBoxPasajeros;
	public JTextField textFieldPrecioBillete;
	public DefaultComboBoxModel<String> modeloPasajero;
	
	public PanelConfirmacion() {
		setLayout(null);
		setBounds(0,0,800,600);
		setBackground(new Color(193, 240, 240));
		
		btnLogIn = new JButton("Log out");
		btnLogIn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogIn.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		btnLogIn.setAlignmentY(Component.TOP_ALIGNMENT);
		btnLogIn.setBackground(new Color(192, 192, 192));
		btnLogIn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogIn.setBounds(689, 12, 89, 23);
		add(btnLogIn);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsuario.setBounds(506, 12, 173, 25);
		add(lblUsuario);
		
		lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblCdigo.setBounds(53, 158, 132, 35);
		add(lblCdigo);
		
		lblFieldCodigo = new JLabel();
		lblFieldCodigo.setBounds(49, 193, 201, 35);
		add(lblFieldCodigo);
		
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblNombre.setBounds(53, 249, 112, 23);
		add(lblNombre);
		
		lblFieldNombre = new JLabel();
		lblFieldNombre.setBounds(48, 278, 201, 35);
		add(lblFieldNombre);
		
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblApellidos.setBounds(53, 327, 104, 29);
		add(lblApellidos);
		
		lblFieldApellidos = new JLabel();
		lblFieldApellidos.setBounds(49, 360, 201, 35);
		add(lblFieldApellidos);
		
		
		lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblDni.setBounds(53, 411, 112, 23);
		add(lblDni);
		
		lblFieldDNI = new JLabel();
		lblFieldDNI.setBounds(49, 445, 201, 35);
		add(lblFieldDNI);
		
		
		lblLnea = new JLabel("L\u00EDnea");
		lblLnea.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblLnea.setBounds(297, 161, 138, 29);
		add(lblLnea);
		
		lblFieldLinea = new JLabel();
		lblFieldLinea.setBounds(299, 193, 201, 35);
		add(lblFieldLinea);
		
		
		lblSalida = new JLabel("Salida:");
		lblSalida.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblSalida.setBounds(297, 249, 118, 23);
		add(lblSalida);
		
		lblFieldParadaInicio = new JLabel();
		lblFieldParadaInicio.setBounds(297, 278, 201, 35);
		add(lblFieldParadaInicio);
		
		
		lblLlegada = new JLabel("Llegada:");
		lblLlegada.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblLlegada.setBounds(297, 330, 167, 23);
		add(lblLlegada);
		
		lblFieldParadaFin = new JLabel();
		lblFieldParadaFin.setBounds(299, 360, 201, 35);
		add(lblFieldParadaFin);
		
		
		lblTipoDeTrayecto = new JLabel("Tipo de Trayecto:");
		lblTipoDeTrayecto.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblTipoDeTrayecto.setBounds(297, 411, 167, 23);
		add(lblTipoDeTrayecto);
		
		lblFieldTipoTrayecto = new JLabel();
		lblFieldTipoTrayecto.setBounds(299, 445, 201, 35);
		add(lblFieldTipoTrayecto);
		
		
		lblFechaIda = new JLabel("Fecha Ida:");
		lblFechaIda.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblFechaIda.setBounds(549, 164, 104, 23);
		add(lblFechaIda);
		
		lblFechaVuelta = new JLabel("Fecha Vuelta:");
		lblFechaVuelta.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblFechaVuelta.setBounds(549, 249, 130, 23);
		add(lblFechaVuelta);
		
		lblPrecioBillete = new JLabel("Precio Billete:");
		lblPrecioBillete.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblPrecioBillete.setBounds(592, 372, 130, 23);
		add(lblPrecioBillete);
		
		textFieldPrecioBillete = new JTextField();
		textFieldPrecioBillete.setColumns(10);
		textFieldPrecioBillete.setBounds(592, 411, 130, 35);
		add(textFieldPrecioBillete);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		btnCancelar.setAlignmentY(Component.TOP_ALIGNMENT);
		btnCancelar.setBackground(new Color(192, 192, 192));
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setBounds(56, 527, 129, 35);
		add(btnCancelar);
		
		btnImprimir = new JButton("Imprimir Billete");
		btnImprimir.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		btnImprimir.setAlignmentY(Component.TOP_ALIGNMENT);
		btnImprimir.setBackground(new Color(192, 192, 192));
		btnImprimir.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnImprimir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnImprimir.setBounds(603, 527, 181, 35);
		add(btnImprimir);
		
		lblPasajerosas = new JLabel("Pasajeros/as:");
		lblPasajerosas.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblPasajerosas.setBounds(53, 64, 138, 25);
		add(lblPasajerosas);
		
		modeloPasajero= new DefaultComboBoxModel<String>();
		
		comboBoxPasajeros = new JComboBox(modeloPasajero);
		comboBoxPasajeros.setBounds(53, 100, 132, 35);
		add(comboBoxPasajeros);
		
		fechaIda = new JDateChooser((JCalendar) null, (Date) null, (String) null, (IDateEditor) null);
		fechaIda.setBounds(549, 198, 137, 27);
		add(fechaIda);
		
		fechaVuelta = new JDateChooser((JCalendar) null, (Date) null, (String) null, (IDateEditor) null);
		fechaVuelta.setBounds(549, 278, 137, 27);
		add(fechaVuelta);
		

	}
	
	public void limpiar() {
		lblFieldCodigo.setText("");
		lblFieldApellidos.setText("");
		lblFieldNombre.setText("");
		lblFieldCodigo.setText("");
		lblFieldLinea.setText("");
		lblFieldParadaFin.setText("");
		lblFieldParadaInicio.setText("");
		lblFieldTipoTrayecto.setText("");
	}
	
	
	
	public void actualizarPosicion(int posicion) {
		lblFieldCodigo.setText(String.valueOf(posicion));
	}
	
	public void actualizarNombre(Modelo mod, int posicion) {
		lblFieldNombre.setText(mod.arrayClientes.get(posicion).nombre);
	}
	
	public void actualizarApellido(Modelo mod, int posicion) {
		lblFieldApellidos.setText(mod.arrayClientes.get(posicion).apellido);
	}
	
	public void actualizarDni(Modelo mod, int posicion) {
		lblFieldDNI.setText(mod.arrayClientes.get(posicion).dni);
	}
	
	public void actualizarLinea(PanelLineas2 panel2) {
		lblFieldLinea.setText(panel2.lblNombreLinea.getText());
	}
	
	public void actualizarParadaInicio(PanelLineas1 panel3) {
		lblFieldParadaInicio.setText(String.valueOf(panel3.listParadas.getSelectedValuesList()));
	}
	
	public void actualizarParadaFin(PanelLineas2 panel2) {
		lblFieldParadaFin.setText(String.valueOf(panel2.listaDestinos.getSelectedValuesList()));
	}
	
	public void actualizarFechaIda(PanelLineas2 panel2) {
		fechaIda.setDate(panel2.calendarioIda.getDate());
	}
	
	public void actualizarFechaVuelta(PanelLineas2 panel2) {
		fechaVuelta.setDate(panel2.calendarioVuelta.getDate());
	}
	
	public void actualizarTipoTrayecto(Modelo mod) {
		if(mod.isIdaYVuelta()==true) {
			lblFieldTipoTrayecto.setText("Ida y vuelta");
		}
		else
			lblFieldTipoTrayecto.setText("Ida");
	}
	
	public int getPasajeros() {
		return this.comboBoxPasajeros.getSelectedIndex();
	}
	

}
