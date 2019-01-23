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

public class PanelLineas2 extends JPanel{

	JLabel lblUsuario, lblSalida,lblLinea,lblNumeroDeBilletes,lblNombreLinea,lblFechaIda,lblFechaVuelta,lblLleg,lblSal;
	JDateChooser calendarioIda,calendarioVuelta;
	JLabel lblLlegada;
	JList<Parada> listaDestinos;
	DefaultListModel<Parada> modeloListaDestinos;
	JButton btnLogIn, btnCancelar, btnConfirmar;
	JSpinner spnNumeroDeBilletes;
	/**
	 * @wbp.parser.entryPoint
	 */
	public PanelLineas2() {
	
		setBounds(0, 0, 800, 600);
		setVisible(false);
		setLayout(null);

		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(593, 12, 86, 25);
		add(lblUsuario);

		btnLogIn = new JButton("Log in");
		btnLogIn.setBounds(689, 12, 89, 23);
		add(btnLogIn);

		lblLinea = new JLabel("Linea:");
		lblLinea.setBounds(79, 144, 46, 14);
		add(lblLinea);

		lblNombreLinea = new JLabel("x");
		lblNombreLinea.setBounds(191, 144, 46, 14);
		add(lblNombreLinea);

		lblFechaIda = new JLabel("Fecha Ida");
		lblFechaIda.setBounds(79, 212, 119, 14);
		add(lblFechaIda);

		lblFechaVuelta = new JLabel("Fecha Vuelta");
		lblFechaVuelta.setBounds(79, 301, 89, 14);
		add(lblFechaVuelta);

		lblNumeroDeBilletes = new JLabel("Numero de billetes");
		lblNumeroDeBilletes.setBounds(79, 383, 100, 14);
		add(lblNumeroDeBilletes);

		calendarioIda = new JDateChooser(null, null, null, new JSpinnerDateEditor());
		calendarioIda.setBounds(163, 212, 137, 27);
		add(calendarioIda);
		
		calendarioVuelta = new JDateChooser(null, null, null, new JSpinnerDateEditor());
		calendarioVuelta.setBounds(163, 301, 137, 27);
		add(calendarioVuelta);
		
		spnNumeroDeBilletes = new JSpinner();
		spnNumeroDeBilletes.setBounds(183, 370, 70, 40);
		add(spnNumeroDeBilletes);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(109, 519, 89, 23);
		add(btnCancelar);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(572, 519, 89, 23);
		add(btnConfirmar);
		
		lblSalida = new JLabel("Salida:");
		lblSalida.setBounds(489, 144, 137, 14);
		add(lblSalida);
		
		
		lblSal = new JLabel("yyyyyyyyyyy");
		lblSal.setBounds(604, 144, 107, 14);
		add(lblSal);
		
		modeloListaDestinos= new DefaultListModel<Parada>();
		
		lblLlegada = new JLabel("Llegada:");
		lblLlegada.setBounds(489, 197, 46, 14);
		add(lblLlegada);
		
		listaDestinos = new JList<Parada>(modeloListaDestinos);
		listaDestinos.setBounds(489, 237, 231, 199);
		add(listaDestinos);
	}
}
