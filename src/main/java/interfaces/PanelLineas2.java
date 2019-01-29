package interfaces;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;

import clases.Parada;

import javax.swing.JSpinner;
import javax.swing.JList;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
/**
 * @wbp.parser.entryPoint
 */
public class PanelLineas2 extends JPanel{

	public JLabel lblUsuario, lblSalida,lblLinea,lblNumeroDeBilletes,lblNombreLinea,lblFechaIda,lblFechaVuelta,lblLleg,lblSal;
	public JDateChooser calendarioIda,calendarioVuelta;
	public JLabel lblLlegada;
	public JList<Parada> listaDestinos;
	public DefaultListModel<Parada> modeloListaDestinos;
	public JButton btnLogIn, btnCancelar, btnConfirmar;
	public JSpinner spnNumeroDeBilletes;
	public JSpinnerDateEditor spinnerDateEditorVuelta, spinnerDateEditorIda;
	
	public PanelLineas2() {
	
		setBounds(0, 0, 800, 600);
		setLayout(null);
		setBackground(new Color(193, 240, 240));

		lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsuario.setBounds(506, 12, 173, 25);
		add(lblUsuario);

		btnLogIn = new JButton("Log in");
		btnLogIn.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		btnLogIn.setAlignmentY(Component.TOP_ALIGNMENT);
		btnLogIn.setBackground(new Color(192, 192, 192));
		btnLogIn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogIn.setBounds(689, 12, 89, 23);
		add(btnLogIn);

		lblLinea = new JLabel("Linea:");
		lblLinea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLinea.setBounds(79, 133, 89, 25);
		add(lblLinea);

		lblNombreLinea = new JLabel("x");
		lblNombreLinea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombreLinea.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreLinea.setBounds(178, 133, 179, 25);
		add(lblNombreLinea);

		lblFechaIda = new JLabel("Fecha Ida:");
		lblFechaIda.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFechaIda.setBounds(79, 212, 116, 27);
		add(lblFechaIda);

		lblFechaVuelta = new JLabel("Fecha Vuelta:");
		lblFechaVuelta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFechaVuelta.setBounds(79, 301, 102, 27);
		add(lblFechaVuelta);

		lblNumeroDeBilletes = new JLabel("Numero de billetes:");
		lblNumeroDeBilletes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNumeroDeBilletes.setBounds(79, 383, 151, 27);
		add(lblNumeroDeBilletes);

		spinnerDateEditorIda = new JSpinnerDateEditor();
		spinnerDateEditorIda.setFont(new Font("Tahoma", Font.BOLD, 12));
		spinnerDateEditorIda.setEnabled(false);
		calendarioIda = new JDateChooser(null, null, null, spinnerDateEditorIda);
		calendarioIda.setDateFormatString("dd-MM-yyyy");
	
		calendarioIda.setBounds(180, 212, 137, 27);
		
		add(calendarioIda);
		
		spinnerDateEditorVuelta = new JSpinnerDateEditor();
		spinnerDateEditorVuelta.setEnabled(false);
		spinnerDateEditorVuelta.setDateFormatString("dd/mm/yyyy");
		calendarioVuelta = new JDateChooser(null, null, null, spinnerDateEditorVuelta);
		calendarioVuelta.setDateFormatString("dd-MM-yyyy");
		calendarioVuelta.setBounds(180, 301, 137, 27);
		add(calendarioVuelta);
		
		spnNumeroDeBilletes = new JSpinner();
		spnNumeroDeBilletes.setBounds(247, 381, 70, 30);
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
		lblSalida.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSalida.setBounds(489, 130, 86, 31);
		add(lblSalida);
		
		
		lblSal = new JLabel("yyyyyyyyyyy");
		lblSal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSal.setBounds(574, 133, 204, 25);
		add(lblSal);
		
		modeloListaDestinos= new DefaultListModel<Parada>();
		
		lblLlegada = new JLabel("Llegada:");
		lblLlegada.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLlegada.setBounds(489, 186, 89, 25);
		add(lblLlegada);
		
		listaDestinos = new JList<Parada>(modeloListaDestinos);
		listaDestinos.setBounds(489, 237, 231, 199);
		add(listaDestinos);
	}
}
