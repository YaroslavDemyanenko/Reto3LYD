package interfaces;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;


@SuppressWarnings("serial")
public class PanelLineas2 extends JPanel{

	public JLabel lblUsuario, lblSalida,lblLinea,lblNumeroDeBilletes,lblNombreLinea,lblFechaIda,lblFechaVuelta,lblLleg,lblSal;
	public JDateChooser calendarioIda,calendarioVuelta;
	public JLabel lblLlegada;
	@SuppressWarnings("rawtypes")
	public JList listaDestinos;
	public DefaultListModel<String> modeloListaDestinos;
	public JButton btnLogIn, btnCancelar, btnConfirmar;
	public JSpinner spnNumeroDeBilletes;
	public JSpinnerDateEditor spinnerDateEditorVuelta, spinnerDateEditorIda;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PanelLineas2() {
	
		setBounds(0, 0, 800, 600);
		setLayout(null);
		setBackground(new Color(193, 240, 240));

		lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsuario.setBounds(506, 12, 173, 25);
		add(lblUsuario);

		btnLogIn = new JButton("Sign Up");
		btnLogIn.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		btnLogIn.setAlignmentY(Component.TOP_ALIGNMENT);
		btnLogIn.setBackground(new Color(192, 192, 192));
		btnLogIn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogIn.setBounds(676, 12, 102, 23);
		add(btnLogIn);
		btnLogIn.setName("botonLogin");

		lblLinea = new JLabel("Linea:");
		lblLinea.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblLinea.setBounds(79, 133, 89, 25);
		add(lblLinea);

		lblNombreLinea = new JLabel("");
		lblNombreLinea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombreLinea.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreLinea.setBounds(178, 133, 179, 25);
		add(lblNombreLinea);

		lblFechaIda = new JLabel("Fecha Ida:");
		lblFechaIda.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblFechaIda.setBounds(79, 212, 116, 27);
		add(lblFechaIda);

		lblFechaVuelta = new JLabel("Fecha Vuelta:");
		lblFechaVuelta.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblFechaVuelta.setBounds(79, 301, 116, 27);
		add(lblFechaVuelta);

		lblNumeroDeBilletes = new JLabel("Numero de billetes:");
		lblNumeroDeBilletes.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblNumeroDeBilletes.setBounds(79, 383, 166, 27);
		add(lblNumeroDeBilletes);

		
		
		spinnerDateEditorIda = new JSpinnerDateEditor();
		((JSpinner.DefaultEditor) spinnerDateEditorIda.getEditor()).getTextField().setEditable(false);
		spinnerDateEditorIda.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		calendarioIda = new JDateChooser(null, null, null, spinnerDateEditorIda);
		calendarioIda.setDateFormatString("dd-MM-yyyy");
		calendarioIda.setBounds(205, 212, 137, 27);
		add(calendarioIda);
		
		
		
		spinnerDateEditorVuelta = new JSpinnerDateEditor();
		((JSpinner.DefaultEditor) spinnerDateEditorVuelta.getEditor()).getTextField().setEditable(false);
		spinnerDateEditorVuelta.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		calendarioVuelta = new JDateChooser(null, null, null, spinnerDateEditorVuelta);
		calendarioVuelta.setDateFormatString("dd-MM-yyyy");
		calendarioVuelta.setBounds(205, 301, 137, 27);
		add(calendarioVuelta);
		
		
		
		spnNumeroDeBilletes = new JSpinner();
		spnNumeroDeBilletes.setModel(new SpinnerNumberModel(new Integer(1), new Integer(0), null, new Integer(1)));
		spnNumeroDeBilletes.setBounds(255, 381, 70, 30);
		
		
		spnNumeroDeBilletes.setEditor(new JSpinner.DefaultEditor(spnNumeroDeBilletes));
		add(spnNumeroDeBilletes);
		
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
		
		lblSalida = new JLabel("Salida:");
		lblSalida.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblSalida.setBounds(447, 130, 86, 31);
		add(lblSalida);
		
		
		lblSal = new JLabel("yyyyyyyyyyy");
		lblSal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSal.setBounds(520, 133, 258, 25);
		add(lblSal);
		
		modeloListaDestinos= new DefaultListModel<String>();
		
		lblLlegada = new JLabel("Llegada:");
		lblLlegada.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblLlegada.setBounds(447, 201, 89, 25);
		add(lblLlegada);
		
		listaDestinos = new JList(modeloListaDestinos);
		listaDestinos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		listaDestinos.setBounds(447, 237, 270, 218);
		add(listaDestinos);
	}
	public void limpiar() {
		lblNombreLinea.setText("");
		modeloListaDestinos.clear();
		calendarioVuelta.setVisible(true);
		lblFechaVuelta.setVisible(true);
		calendarioIda.setDate(Calendar.getInstance().getTime());
		calendarioVuelta.setDate(Calendar.getInstance().getTime());
		spnNumeroDeBilletes.setValue(1);
		lblSal.setText("");
		lblUsuario.setText("");
	}
}
