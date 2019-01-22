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
	
	JLabel lblBienvenidoATermibus,lblTocaParaContinuar;

	
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
		
		
		lblTocaParaContinuar = new JLabel();
		lblTocaParaContinuar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTocaParaContinuar.setHorizontalAlignment(SwingConstants.CENTER);
		lblTocaParaContinuar.setText("Toca para continuar");
		lblTocaParaContinuar.setBounds(260, 428, 270, 20);
		InterfazSaludo.add(lblTocaParaContinuar);
		
		
		
		lblBienvenidoATermibus = new JLabel();
		lblBienvenidoATermibus.setForeground(new Color(153, 0, 102));
		lblBienvenidoATermibus.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblBienvenidoATermibus.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenidoATermibus.setText("Bienvenid@\r\na Termibus");
		lblBienvenidoATermibus.setBounds(163, 180, 471, 159);
		InterfazSaludo.add(lblBienvenidoATermibus);
		
		
		

	}
}
