package interfaces;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Calendar;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import com.toedter.calendar.IDateEditor;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;
/**
 * @wbp.parser.entryPoint
 */

public class PanelResumen extends JPanel {

	public JLabel lblUsuario,lblResumen, lblLinea, lblPardaInicio, lblPardaFin, lblTipoDeTrayecto, lblNombreLinea, lblNombrePardaInicio, lblNombreParadaFin, lblIdaYVuelta, lblNumBill, lblNumeroDeBilletes, lblFechaIda, lblFechaVuelta, lblPrecio ;
	public JButton btnSignUp, btnCancelar, btnConfirmar ;
	public JDateChooser calendarioIda, calendarioVuelta;
	public JTextField textPrecio;
	public JSpinnerDateEditor spinnerDateEditorIda,spinnerDateEditorVuelta;
	
	public PanelResumen() {
		
		setBounds(0, 0, 800, 600);
		setLayout(null);
		setBackground(new Color(193, 240, 240));
		
		btnSignUp = new JButton("Sign Up");
		btnSignUp.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		btnSignUp.setAlignmentY(Component.TOP_ALIGNMENT);
		btnSignUp.setBackground(new Color(192, 192, 192));
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSignUp.setBounds(689, 12, 89, 23);
		add(btnSignUp);
		btnSignUp.setName("botonLogin");
		
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
		lblPardaInicio.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblPardaInicio.setHorizontalAlignment(SwingConstants.LEFT);
		lblPardaInicio.setBounds(76, 257, 110, 23);
		add(lblPardaInicio);
		
		lblPardaFin = new JLabel("Parda Fin:");
		lblPardaFin.setHorizontalAlignment(SwingConstants.LEFT);
		lblPardaFin.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblPardaFin.setBounds(76, 314, 110, 32);
		add(lblPardaFin);
		
		lblTipoDeTrayecto = new JLabel("Tipo de Trayecto:");
		lblTipoDeTrayecto.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblTipoDeTrayecto.setBounds(76, 375, 154, 32);
		add(lblTipoDeTrayecto);
		
		lblNombreLinea = new JLabel("Nombre linea");
		lblNombreLinea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombreLinea.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreLinea.setBounds(237, 202, 216, 31);
		add(lblNombreLinea);
		
		lblNombrePardaInicio = new JLabel("Nombre parda inicio");
		lblNombrePardaInicio.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombrePardaInicio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombrePardaInicio.setBounds(237, 252, 216, 32);
		add(lblNombrePardaInicio);
		
		lblNombreParadaFin = new JLabel("Nombre parada fin");
		lblNombreParadaFin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombreParadaFin.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreParadaFin.setBounds(237, 314, 216, 32);
		add(lblNombreParadaFin);
		
		lblIdaYVuelta = new JLabel("Ida / Ida y vuelta");
		lblIdaYVuelta.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdaYVuelta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIdaYVuelta.setBounds(259, 375, 128, 32);
		add(lblIdaYVuelta);
		
		lblNumBill = new JLabel("Numero de billetes:");
		lblNumBill.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblNumBill.setBounds(76, 435, 173, 41);
		add(lblNumBill);
		
		lblNumeroDeBilletes = new JLabel("x");
		lblNumeroDeBilletes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNumeroDeBilletes.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroDeBilletes.setBounds(250, 439, 89, 32);
		add(lblNumeroDeBilletes);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		btnCancelar.setAlignmentY(Component.TOP_ALIGNMENT);
		btnCancelar.setBackground(new Color(192, 192, 192));
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar.setBounds(80, 519, 140, 41);
		add(btnCancelar);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		btnConfirmar.setAlignmentY(Component.TOP_ALIGNMENT);
		btnConfirmar.setBackground(new Color(192, 192, 192));
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConfirmar.setBounds(638, 519, 140, 41);
		add(btnConfirmar);
		
		lblFechaIda = new JLabel("Fecha Ida");
		lblFechaIda.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaIda.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblFechaIda.setBounds(570, 170, 104, 24);
		add(lblFechaIda);
		
		
		
		

		lblLinea = new JLabel("Linea:");
		lblLinea.setBounds(76, 197, 110, 32);
		add(lblLinea);
		lblLinea.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblLinea.setHorizontalAlignment(SwingConstants.LEFT);
		
		lblFechaVuelta = new JLabel("Fecha Vuelta");
		lblFechaVuelta.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblFechaVuelta.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaVuelta.setBounds(564, 295, 115, 24);
		add(lblFechaVuelta);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblPrecio.setBounds(584, 410, 77, 28);
		add(lblPrecio);
		
		textPrecio = new JTextField();
		textPrecio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textPrecio.setBounds(563, 448, 119, 41);
		add(textPrecio);
		textPrecio.setColumns(10);
		
		
		
		
		spinnerDateEditorIda = new JSpinnerDateEditor();
		spinnerDateEditorIda.setEnabled(false);
		((JSpinner.DefaultEditor) spinnerDateEditorIda.getEditor()).getTextField().setEditable(false);
		((JSpinner.DefaultEditor) spinnerDateEditorIda.getEditor()).getTextField().setEnabled(true);
		spinnerDateEditorIda.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		calendarioIda = new JDateChooser(null, null, null, spinnerDateEditorIda);
		calendarioIda.getCalendarButton().setEnabled(false);
		calendarioIda.getCalendarButton().setDisabledIcon(new ImageIcon(PanelResumen.class.getResource("/imagenes/JCalendarColor16.gif")));
		calendarioIda.setBounds(554, 202, 137, 27);
		calendarioIda.setDateFormatString("dd-MM-yyyy");
		add(calendarioIda);
		
		
		spinnerDateEditorVuelta = new JSpinnerDateEditor();
		spinnerDateEditorVuelta.setEnabled(false);
		((JSpinner.DefaultEditor) spinnerDateEditorVuelta.getEditor()).getTextField().setEditable(false);
		((JSpinner.DefaultEditor) spinnerDateEditorVuelta.getEditor()).getTextField().setEnabled(true);
		spinnerDateEditorVuelta.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		calendarioVuelta = new JDateChooser(null, null, null, spinnerDateEditorVuelta);
		calendarioVuelta.getCalendarButton().setEnabled(false);
		calendarioVuelta.getCalendarButton().setDisabledIcon(new ImageIcon(PanelResumen.class.getResource("/imagenes/JCalendarColor16.gif")));
		calendarioVuelta.setBounds(554, 341, 137, 27);
		calendarioVuelta.setDateFormatString("dd-MM-yyyy");
		add(calendarioVuelta);

	}
	public void limpiar() {
		lblNombreLinea.setText("");
		lblNombrePardaInicio.setText("");
		lblNombreParadaFin.setText("");
		lblIdaYVuelta.setText("");
		textPrecio.setText("0");
		calendarioIda.setDate(Calendar.getInstance().getTime());
		calendarioVuelta.setDate(Calendar.getInstance().getTime());
		calendarioVuelta.setVisible(true);
		lblFechaVuelta.setVisible(true);
	}
}
