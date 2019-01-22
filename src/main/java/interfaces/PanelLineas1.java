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
	
	
	JPanel panelLineas1;
	JButton btnSingUp;
	JLabel lblUsuario, lblLinea, lblParadaInicio;
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
		
		lblLinea = new JLabel();
		lblLinea.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLinea.setHorizontalAlignment(SwingConstants.CENTER);
		lblLinea.setText("Linea");
		lblLinea.setBounds(100, 167, 86, 20);
		panelLineas1.add(lblLinea);
		
		
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
		
		lblParadaInicio = new JLabel();
		lblParadaInicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblParadaInicio.setHorizontalAlignment(SwingConstants.CENTER);
		lblParadaInicio.setText("Parada inicio");
		lblParadaInicio.setBounds(433, 167, 86, 20);
		panelLineas1.add(lblParadaInicio);
		
		
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
