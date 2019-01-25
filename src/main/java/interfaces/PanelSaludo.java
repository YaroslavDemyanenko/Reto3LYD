package interfaces;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
/**
 * @wbp.parser.entryPoint
 */
public class PanelSaludo extends JPanel {

	public JLabel lblBienvenidoATermibus,lblTocaParaContinuar, lblUsuario;
	public JButton btnSignUP;
	
	public PanelSaludo() {

		setBounds(0, 0, 800, 600);
		setVisible(true);
		setLayout(null);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(506, 12, 173, 25);
		add(lblUsuario);
		
		
		
		btnSignUP = new JButton("Sign UP");
		btnSignUP.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSignUP.setBounds(689, 12, 89, 23);
		add(btnSignUP);
		
		
		lblTocaParaContinuar = new JLabel();
		lblTocaParaContinuar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTocaParaContinuar.setHorizontalAlignment(SwingConstants.CENTER);
		lblTocaParaContinuar.setText("Toca para continuar");
		lblTocaParaContinuar.setBounds(254, 404, 293, 44);
		add(lblTocaParaContinuar);
		
		
		
		lblBienvenidoATermibus = new JLabel();
		lblBienvenidoATermibus.setForeground(new Color(153, 0, 102));
		lblBienvenidoATermibus.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblBienvenidoATermibus.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenidoATermibus.setText("Bienvenid@\r\n a Termibus");
		lblBienvenidoATermibus.setBounds(163, 180, 471, 159);
		add(lblBienvenidoATermibus);
		
		
		

	}
}
