package interfaces;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Interfazsaludo extends JPanel {
	JPanel InterfazSaludo;
	JTextField txtTocaParaContinuar;
	JTextField txtBienvenidoATermibus;

	
	JLabel lblUsuario;
	JButton btnSignUP;
	/**
	 * @wbp.parser.entryPoint
	 */
	public void crearInterfazsaludo() {
		
		InterfazSaludo = new JPanel();
		InterfazSaludo.setBounds(0, 0, 800, 600);
		
		InterfazSaludo.setLayout(null);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(593, 12, 86, 25);
		InterfazSaludo.add(lblUsuario);
		
		
		
		btnSignUP = new JButton("Sign UP");
		btnSignUP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSignUP.setBounds(689, 12, 89, 23);
		InterfazSaludo.add(btnSignUP);
		
		
		txtTocaParaContinuar = new JTextField();
		txtTocaParaContinuar.setHorizontalAlignment(SwingConstants.CENTER);
		txtTocaParaContinuar.setText("Toca para continuar");
		txtTocaParaContinuar.setBounds(260, 428, 270, 20);
		InterfazSaludo.add(txtTocaParaContinuar);
		txtTocaParaContinuar.setColumns(10);
		
		
		txtBienvenidoATermibus = new JTextField();
		txtBienvenidoATermibus.setForeground(new Color(153, 0, 102));
		txtBienvenidoATermibus.setFont(new Font("Tahoma", Font.PLAIN, 40));
		txtBienvenidoATermibus.setHorizontalAlignment(SwingConstants.CENTER);
		txtBienvenidoATermibus.setText("Bienvenid@\r\na Termibus");
		txtBienvenidoATermibus.setBounds(163, 180, 471, 159);
		InterfazSaludo.add(txtBienvenidoATermibus);
		txtBienvenidoATermibus.setColumns(10);
		
		

	}
}
