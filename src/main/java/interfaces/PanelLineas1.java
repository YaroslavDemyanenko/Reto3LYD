package interfaces;

import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JList;
import java.awt.Font;
/**
 * @wbp.parser.entryPoint 
 */
public class PanelLineas1 extends JPanel {
	

	public JButton btnSingUp;
	public JLabel lblUsuario, lblLinea, lblParadaInicio;
	public JRadioButton rdbtnIda, rdbtnIdayVuelta;
	public ButtonGroup grupo;
	public JList listLineas,listParadas;
	public DefaultListModel<String> modeloLineas,modeloParadas;
	public JButton btnCancelar, btnConfirmar;
	
	
	public PanelLineas1() {
		
		setBounds(0, 0, 800, 600);
		setLayout(null);
	
		btnSingUp = new JButton("Sing Up");
		btnSingUp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSingUp.setBounds(689, 12, 89, 23);
		add(btnSingUp);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsuario.setBounds(593, 12, 86, 25);
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblUsuario);
		
		lblLinea = new JLabel();
		lblLinea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLinea.setHorizontalAlignment(SwingConstants.LEFT);
		lblLinea.setText("Linea");
		lblLinea.setBounds(83, 97, 86, 20);
		add(lblLinea);
		
		
		rdbtnIda = new JRadioButton("Ida");
		rdbtnIda.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnIda.setBounds(83, 468, 109, 23);
		add(rdbtnIda);
		
		rdbtnIdayVuelta = new JRadioButton("Ida y vuelta");
		rdbtnIdayVuelta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnIdayVuelta.setBounds(267, 468, 109, 23);
		add(rdbtnIdayVuelta);
		
		grupo = new ButtonGroup();
		grupo.add(rdbtnIda);
		grupo.add(rdbtnIdayVuelta);
		
		lblParadaInicio = new JLabel();
		lblParadaInicio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblParadaInicio.setHorizontalAlignment(SwingConstants.LEFT);
		lblParadaInicio.setText("Parada inicio");
		lblParadaInicio.setBounds(433, 97, 129, 20);
		add(lblParadaInicio);
		
		
		modeloLineas = new DefaultListModel();
		listLineas = new JList(modeloLineas);
		listLineas.setBounds(83, 153, 200, 233);
		add(listLineas);
		
		modeloParadas = new DefaultListModel();
		listParadas = new JList(modeloParadas);
		listParadas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		listParadas.setBounds(433, 153, 258, 274);
		add(listParadas);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar.setToolTipText("");
		btnCancelar.setBounds(56, 527, 129, 35);
		add(btnCancelar);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConfirmar.setBounds(655, 527, 129, 35);
		add(btnConfirmar);
		
		
	}
}
