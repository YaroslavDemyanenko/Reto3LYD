package interfaces;

import javax.swing.JPanel;

import java.awt.Font;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.toedter.calendar.IDateEditor;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;
import java.awt.BorderLayout;
import javax.swing.JTextField;
/**
 * @wbp.parser.entryPoint
 */

public class PanelResumen extends JPanel {

	public JLabel lblUsuario,lblResumen, lblLinea, lblPardaInicio, lblPardaFin, lblTipoDeTrayecto, lblNombreLinea, lblNombrePardaInicio, lblNombreParadaFin, lblIdaIda, lblNumeroDeBilletes, lblX, lblFechaIda, lblFechaVuelta, lblPrecio ;
	public JButton btnSingUp, btnCancelar, btnConfirmar ;
	public JDateChooser calendarioIda, calendarioVuelta;
	public JTextField textPrecio;
	
	public PanelResumen() {
		
		setBounds(0, 0, 800, 600);
		setVisible(false);
		setLayout(null);
		
		btnSingUp = new JButton("Sign Up");
		btnSingUp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSingUp.setBounds(689, 12, 89, 23);
		add(btnSingUp);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsuario.setBounds(506, 12, 173, 25);
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblUsuario);
		
		lblResumen = new JLabel("Resumen De Trayecto");
		lblResumen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblResumen.setHorizontalAlignment(SwingConstants.LEFT);
		lblResumen.setBounds(76, 88, 247, 32);
		add(lblResumen);
		
		lblPardaInicio = new JLabel("Parda Inicio:");
		lblPardaInicio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPardaInicio.setHorizontalAlignment(SwingConstants.LEFT);
		lblPardaInicio.setBounds(76, 257, 99, 23);
		add(lblPardaInicio);
		
		lblPardaFin = new JLabel("Parda Fin:");
		lblPardaFin.setHorizontalAlignment(SwingConstants.LEFT);
		lblPardaFin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPardaFin.setBounds(76, 295, 80, 32);
		add(lblPardaFin);
		
		lblTipoDeTrayecto = new JLabel("Tipo de Trayecto:");
		lblTipoDeTrayecto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipoDeTrayecto.setBounds(76, 354, 131, 32);
		add(lblTipoDeTrayecto);
		
		lblNombreLinea = new JLabel("Nombre linea");
		lblNombreLinea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombreLinea.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreLinea.setBounds(185, 202, 216, 31);
		add(lblNombreLinea);
		
		lblNombrePardaInicio = new JLabel("Nombre parda inicio");
		lblNombrePardaInicio.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombrePardaInicio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombrePardaInicio.setBounds(185, 252, 216, 32);
		add(lblNombrePardaInicio);
		
		lblNombreParadaFin = new JLabel("Nombre parada fin");
		lblNombreParadaFin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombreParadaFin.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreParadaFin.setBounds(185, 295, 216, 32);
		add(lblNombreParadaFin);
		
		lblIdaIda = new JLabel("Ida / Ida y vuelta");
		lblIdaIda.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdaIda.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIdaIda.setBounds(217, 354, 128, 32);
		add(lblIdaIda);
		
		lblNumeroDeBilletes = new JLabel("Numero de billetes:");
		lblNumeroDeBilletes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNumeroDeBilletes.setBounds(76, 410, 131, 41);
		add(lblNumeroDeBilletes);
		
		lblX = new JLabel("x");
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(217, 414, 89, 32);
		add(lblX);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar.setBounds(80, 519, 140, 41);
		add(btnCancelar);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConfirmar.setBounds(638, 519, 140, 41);
		add(btnConfirmar);
		
		lblFechaIda = new JLabel("Fecha Ida");
		lblFechaIda.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaIda.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFechaIda.setBounds(570, 170, 104, 24);
		add(lblFechaIda);
		
		
		calendarioIda = new JDateChooser((JCalendar) null, (Date) null, (String) null, (IDateEditor) null);
		calendarioIda.setBounds(554, 202, 137, 27);
		add(calendarioIda);
		

		lblLinea = new JLabel("Linea:");
		lblLinea.setBounds(76, 197, 110, 32);
		add(lblLinea);
		lblLinea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLinea.setHorizontalAlignment(SwingConstants.LEFT);
		
		lblFechaVuelta = new JLabel("Fecha Vuelta");
		lblFechaVuelta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFechaVuelta.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaVuelta.setBounds(570, 295, 104, 24);
		add(lblFechaVuelta);
		
		calendarioVuelta = new JDateChooser((JCalendar) null, (Date) null, (String) null, (IDateEditor) null);
		calendarioVuelta.setBounds(554, 341, 137, 27);
		add(calendarioVuelta);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrecio.setBounds(584, 410, 77, 28);
		add(lblPrecio);
		
		textPrecio = new JTextField();
		textPrecio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textPrecio.setBounds(563, 448, 119, 41);
		add(textPrecio);
		textPrecio.setColumns(10);

	}
}
