package interfaces;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

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
		btnSignUp.setBounds(676, 12, 102, 23);
		add(btnSignUp);
		btnSignUp.setName("botonLogin");
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsuario.setBounds(506, 12, 173, 25);
		lblUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblUsuario);
		
		lblResumen = new JLabel("Resumen De Trayecto");
		lblResumen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblResumen.setHorizontalAlignment(SwingConstants.LEFT);
		lblResumen.setBounds(73, 69, 247, 32);
		add(lblResumen);
		
		lblPardaInicio = new JLabel("Parda Inicio:");
		lblPardaInicio.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblPardaInicio.setHorizontalAlignment(SwingConstants.LEFT);
		lblPardaInicio.setBounds(73, 238, 110, 23);
		add(lblPardaInicio);
		
		lblPardaFin = new JLabel("Parda Fin:");
		lblPardaFin.setHorizontalAlignment(SwingConstants.LEFT);
		lblPardaFin.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblPardaFin.setBounds(73, 295, 110, 32);
		add(lblPardaFin);
		
		lblTipoDeTrayecto = new JLabel("Tipo de Trayecto:");
		lblTipoDeTrayecto.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblTipoDeTrayecto.setBounds(73, 356, 154, 32);
		add(lblTipoDeTrayecto);
		
		lblNombreLinea = new JLabel("Nombre linea");
		lblNombreLinea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombreLinea.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreLinea.setBounds(215, 183, 317, 31);
		add(lblNombreLinea);
		
		lblNombrePardaInicio = new JLabel("Nombre parda inicio");
		lblNombrePardaInicio.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombrePardaInicio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombrePardaInicio.setBounds(215, 233, 349, 32);
		add(lblNombrePardaInicio);
		
		lblNombreParadaFin = new JLabel("Nombre parada fin");
		lblNombreParadaFin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombreParadaFin.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreParadaFin.setBounds(215, 295, 349, 32);
		add(lblNombreParadaFin);
		
		lblIdaYVuelta = new JLabel("Ida / Ida y vuelta");
		lblIdaYVuelta.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdaYVuelta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIdaYVuelta.setBounds(237, 356, 128, 32);
		add(lblIdaYVuelta);
		
		lblNumBill = new JLabel("Numero de billetes:");
		lblNumBill.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblNumBill.setBounds(73, 416, 173, 41);
		add(lblNumBill);
		
		lblNumeroDeBilletes = new JLabel("x");
		lblNumeroDeBilletes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNumeroDeBilletes.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroDeBilletes.setBounds(234, 420, 59, 32);
		add(lblNumeroDeBilletes);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		btnCancelar.setAlignmentY(Component.TOP_ALIGNMENT);
		btnCancelar.setBackground(new Color(192, 192, 192));
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar.setBounds(56, 527, 129, 35);
		add(btnCancelar);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		btnConfirmar.setAlignmentY(Component.TOP_ALIGNMENT);
		btnConfirmar.setBackground(new Color(192, 192, 192));
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConfirmar.setBounds(655, 527, 129, 35);
		add(btnConfirmar);
		
		lblFechaIda = new JLabel("Fecha Ida");
		lblFechaIda.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaIda.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblFechaIda.setBounds(604, 164, 104, 24);
		add(lblFechaIda);
		
		
		
		

		lblLinea = new JLabel("Linea:");
		lblLinea.setBounds(73, 178, 110, 32);
		add(lblLinea);
		lblLinea.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblLinea.setHorizontalAlignment(SwingConstants.LEFT);
		
		lblFechaVuelta = new JLabel("Fecha Vuelta");
		lblFechaVuelta.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblFechaVuelta.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaVuelta.setBounds(599, 304, 115, 24);
		add(lblFechaVuelta);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblPrecio.setBounds(584, 410, 77, 28);
		add(lblPrecio);
		
		textPrecio = new JTextField();
		textPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		textPrecio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textPrecio.setBounds(588, 448, 77, 41);
		textPrecio.setColumns(10);
		textPrecio.setEditable(false);
		add(textPrecio);
		
		
		
		
		
		spinnerDateEditorIda = new JSpinnerDateEditor();
		spinnerDateEditorIda.setLocation(608, 0);
		spinnerDateEditorIda.setEnabled(false);
		((JSpinner.DefaultEditor) spinnerDateEditorIda.getEditor()).getTextField().setEditable(false);
		((JSpinner.DefaultEditor) spinnerDateEditorIda.getEditor()).getTextField().setEnabled(true);
		spinnerDateEditorIda.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		calendarioIda = new JDateChooser(null, null, null, spinnerDateEditorIda);
		calendarioIda.getCalendarButton().setLocation(656, 0);
		calendarioIda.getCalendarButton().setEnabled(false);
		calendarioIda.getCalendarButton().setDisabledIcon(new ImageIcon(PanelResumen.class.getResource("/imagenes/JCalendarColor16.gif")));
		calendarioIda.setBounds(588, 200, 137, 27);
		calendarioIda.setDateFormatString("dd-MM-yyyy");
		add(calendarioIda);
		
		
		spinnerDateEditorVuelta = new JSpinnerDateEditor();
		spinnerDateEditorVuelta.setLocation(608, 0);
		spinnerDateEditorVuelta.setEnabled(false);
		((JSpinner.DefaultEditor) spinnerDateEditorVuelta.getEditor()).getTextField().setEditable(false);
		((JSpinner.DefaultEditor) spinnerDateEditorVuelta.getEditor()).getTextField().setEnabled(true);
		spinnerDateEditorVuelta.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		calendarioVuelta = new JDateChooser(null, null, null, spinnerDateEditorVuelta);
		calendarioVuelta.getCalendarButton().setEnabled(false);
		calendarioVuelta.getCalendarButton().setDisabledIcon(new ImageIcon(PanelResumen.class.getResource("/imagenes/JCalendarColor16.gif")));
		calendarioVuelta.setBounds(588, 339, 137, 27);
		calendarioVuelta.setDateFormatString("dd-MM-yyyy");
		add(calendarioVuelta);
		
		JLabel label = new JLabel("€");
		label.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		label.setBounds(672, 449, 29, 35);
		add(label);

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
