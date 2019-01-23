package interfaces;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.Font;
import java.awt.Cursor;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;
import java.util.Date;
import com.toedter.calendar.IDateEditor;

public class PanelConfirmacion extends JPanel {

	JTextField textFieldCodigo, textFieldNombre, textFieldApellidos, textFieldDNI, textFieldParadaFin, textFieldParadaInicio, textFieldLinea, textFieldTipoTrayecto, textFieldPrecioBillete;
	JButton btnLogIn, btnCancelar, btnImprimir;
	JLabel lblUsuario, lblCdigo, lblNombre, lblApellidos, lblDni, lblLnea, lblSalida, lblLlegada, lblTipoDeTrayecto, lblFechaIda, lblFechaVuelta, lblPrecioBillete, lblPasajerosas;
	JDateChooser fechaIda,fechaVuelta;
	JComboBox comboBoxPasajeros;

	/**
	 * @wbp.parser.entryPoint
	 */
	public PanelConfirmacion() {
		setLayout(null);
		setBounds(0,0,800,600);
		setVisible(false);
		
		btnLogIn = new JButton("Log out");
		btnLogIn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogIn.setBounds(689, 12, 89, 23);
		add(btnLogIn);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(593, 12, 86, 25);
		add(lblUsuario);
		
		lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCdigo.setBounds(53, 158, 132, 35);
		add(lblCdigo);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setBounds(49, 193, 201, 35);
		add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(53, 249, 112, 23);
		add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(48, 278, 201, 35);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellidos.setBounds(53, 327, 104, 29);
		add(lblApellidos);
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.setBounds(49, 360, 201, 35);
		add(textFieldApellidos);
		textFieldApellidos.setColumns(10);
		
		lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDni.setBounds(53, 411, 112, 23);
		add(lblDni);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setBounds(49, 445, 201, 35);
		add(textFieldDNI);
		textFieldDNI.setColumns(10);
		
		lblLnea = new JLabel("L\u00EDnea");
		lblLnea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLnea.setBounds(297, 161, 138, 29);
		add(lblLnea);
		
		textFieldLinea = new JTextField();
		textFieldLinea.setBounds(299, 193, 201, 35);
		add(textFieldLinea);
		textFieldLinea.setColumns(10);
		
		lblSalida = new JLabel("Salida:");
		lblSalida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSalida.setBounds(297, 249, 118, 23);
		add(lblSalida);
		
		textFieldParadaInicio = new JTextField();
		textFieldParadaInicio.setBounds(297, 278, 201, 35);
		add(textFieldParadaInicio);
		textFieldParadaInicio.setColumns(10);
		
		lblLlegada = new JLabel("Llegada:");
		lblLlegada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLlegada.setBounds(297, 330, 167, 23);
		add(lblLlegada);
		
		textFieldParadaFin = new JTextField();
		textFieldParadaFin.setBounds(299, 360, 201, 35);
		add(textFieldParadaFin);
		textFieldParadaFin.setColumns(10);
		
		lblTipoDeTrayecto = new JLabel("Tipo de Trayecto:");
		lblTipoDeTrayecto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipoDeTrayecto.setBounds(297, 411, 118, 23);
		add(lblTipoDeTrayecto);
		
		textFieldTipoTrayecto = new JTextField();
		textFieldTipoTrayecto.setBounds(299, 445, 201, 35);
		add(textFieldTipoTrayecto);
		textFieldTipoTrayecto.setColumns(10);
		
		lblFechaIda = new JLabel("Fecha Ida:");
		lblFechaIda.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaIda.setBounds(549, 164, 104, 23);
		add(lblFechaIda);
		
		lblFechaVuelta = new JLabel("Fecha Vuelta:");
		lblFechaVuelta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaVuelta.setBounds(549, 249, 84, 23);
		add(lblFechaVuelta);
		
		lblPrecioBillete = new JLabel("Precio Billete:");
		lblPrecioBillete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecioBillete.setBounds(603, 372, 112, 23);
		add(lblPrecioBillete);
		
		textFieldPrecioBillete = new JTextField();
		textFieldPrecioBillete.setColumns(10);
		textFieldPrecioBillete.setBounds(592, 411, 130, 35);
		add(textFieldPrecioBillete);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setBounds(118, 511, 229, 59);
		add(btnCancelar);
		
		btnImprimir = new JButton("Imprimir Billete");
		btnImprimir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnImprimir.setBounds(465, 511, 217, 64);
		add(btnImprimir);
		
		lblPasajerosas = new JLabel("Pasajeros/as:");
		lblPasajerosas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPasajerosas.setBounds(53, 64, 91, 25);
		add(lblPasajerosas);
		
		comboBoxPasajeros = new JComboBox();
		comboBoxPasajeros.setBounds(53, 100, 132, 47);
		add(comboBoxPasajeros);
		
		fechaIda = new JDateChooser((JCalendar) null, (Date) null, (String) null, (IDateEditor) null);
		fechaIda.setBounds(549, 198, 137, 27);
		add(fechaIda);
		
		fechaVuelta = new JDateChooser((JCalendar) null, (Date) null, (String) null, (IDateEditor) null);
		fechaVuelta.setBounds(549, 278, 137, 27);
		add(fechaVuelta);
		

	}
}
