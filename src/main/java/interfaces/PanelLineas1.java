package interfaces;

import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JList;
import java.awt.Font;

public class PanelLineas1 {
	JTextField txtLinea;
	JTextField txtParadaInicio;
	JPanel panelLineas1;
	JButton btnSingUp;
	JLabel lblUsuario;
	JRadioButton rdbtnIda;
	JRadioButton rdbtnIdayVuelta;
	
	ButtonGroup grupo;
	JList listLineas;
	JList listParadas;
	JButton btnCancelar;
	JButton btnConfirmar;
	
	/**
	 * @wbp.parser.entryPoint 
	 */
	public void PanelLineas1() {
		panelLineas1 = new JPanel();
		
		panelLineas1.setBounds(0, 0, 800, 600);
		
		panelLineas1.setLayout(null);
		
		
		
		btnSingUp = new JButton("Sing Up");
		btnSingUp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSingUp.setBounds(689, 12, 89, 23);
		panelLineas1.add(btnSingUp);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsuario.setBounds(593, 12, 86, 25);
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		panelLineas1.add(lblUsuario);
		
		txtLinea = new JTextField();
		txtLinea.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtLinea.setHorizontalAlignment(SwingConstants.CENTER);
		txtLinea.setText("Linea");
		txtLinea.setBounds(100, 167, 86, 20);
		panelLineas1.add(txtLinea);
		txtLinea.setColumns(10);
		
		rdbtnIda = new JRadioButton("Ida");
		rdbtnIda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnIda.setBounds(56, 493, 109, 23);
		panelLineas1.add(rdbtnIda);
		
		rdbtnIdayVuelta = new JRadioButton("Ida y vuelta");
		rdbtnIdayVuelta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnIdayVuelta.setBounds(216, 493, 109, 23);
		panelLineas1.add(rdbtnIdayVuelta);
		
		grupo = new ButtonGroup();
		grupo.add(rdbtnIda);
		grupo.add(rdbtnIdayVuelta);
		
		txtParadaInicio = new JTextField();
		txtParadaInicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtParadaInicio.setHorizontalAlignment(SwingConstants.CENTER);
		txtParadaInicio.setText("Parada inicio");
		txtParadaInicio.setBounds(433, 167, 86, 20);
		panelLineas1.add(txtParadaInicio);
		txtParadaInicio.setColumns(10);
		
		listLineas = new JList();
		listLineas.setBounds(462, 215, 258, 274);
		panelLineas1.add(listLineas);
		
		listParadas = new JList();
		listParadas.setBounds(136, 215, 200, 233);
		panelLineas1.add(listParadas);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setToolTipText("");
		btnCancelar.setBounds(36, 551, 129, 35);
		panelLineas1.add(btnCancelar);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnConfirmar.setBounds(655, 551, 116, 35);
		panelLineas1.add(btnConfirmar);
		
		
	}
}
