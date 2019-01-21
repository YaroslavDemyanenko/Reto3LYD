package interfaces;

import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JList;

public class PanelLineas1 {
	private JTextField txtLinea;
	private JTextField txtParadaInicio;

	/**
	 * @wbp.parser.entryPoint 
	 */
	public PanelLineas1() {
		JPanel panelLineas1 = new JPanel();
		
		panelLineas1.setBounds(0, 0, 800, 600);
		
		panelLineas1.setLayout(null);
		
		
		
		JButton btnSingUp = new JButton("Sing Up");
		btnSingUp.setBounds(676, 31, 95, 23);
		panelLineas1.add(btnSingUp);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(604, 31, 62, 23);
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		panelLineas1.add(lblUsuario);
		
		txtLinea = new JTextField();
		txtLinea.setHorizontalAlignment(SwingConstants.CENTER);
		txtLinea.setText("Linea");
		txtLinea.setBounds(100, 167, 86, 20);
		panelLineas1.add(txtLinea);
		txtLinea.setColumns(10);
		
		JRadioButton rdbtnIda = new JRadioButton("Ida");
		rdbtnIda.setBounds(56, 493, 109, 23);
		panelLineas1.add(rdbtnIda);
		
		JRadioButton rdbtnIdayVuelta = new JRadioButton("Ida y vuelta");
		rdbtnIdayVuelta.setBounds(216, 493, 109, 23);
		panelLineas1.add(rdbtnIdayVuelta);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdbtnIda);
		grupo.add(rdbtnIdayVuelta);
		
		txtParadaInicio = new JTextField();
		txtParadaInicio.setText("Parada inicio");
		txtParadaInicio.setBounds(433, 167, 86, 20);
		panelLineas1.add(txtParadaInicio);
		txtParadaInicio.setColumns(10);
		
		JList listLineas = new JList();
		listLineas.setBounds(462, 215, 258, 274);
		panelLineas1.add(listLineas);
		
		JList listParadas = new JList();
		listParadas.setBounds(136, 215, 200, 233);
		panelLineas1.add(listParadas);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setToolTipText("");
		btnCancelar.setBounds(36, 551, 129, 35);
		panelLineas1.add(btnCancelar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(655, 551, 116, 35);
		panelLineas1.add(btnConfirmar);
		
		
	}
}
