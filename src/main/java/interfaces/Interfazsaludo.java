package interfaces;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Interfazsaludo extends JPanel {
	private JTextField txtTocaParaContinuar;
	private JTextField txtBienvenidoATermibus;

	/**
	 * Create the panel.
	 */
	public Interfazsaludo() {
		setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(494, 12, 86, 25);
		add(lblUsuario);
		
		
		
		JButton btnSignUP = new JButton("Sign UP");
		btnSignUP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSignUP.setBounds(588, 12, 89, 23);
		add(btnSignUP);
		
		
		txtTocaParaContinuar = new JTextField();
		txtTocaParaContinuar.setHorizontalAlignment(SwingConstants.CENTER);
		txtTocaParaContinuar.setText("Toca para continuar");
		txtTocaParaContinuar.setBounds(215, 432, 270, 20);
		add(txtTocaParaContinuar);
		txtTocaParaContinuar.setColumns(10);
		
		
		txtBienvenidoATermibus = new JTextField();
		txtBienvenidoATermibus.setForeground(new Color(153, 0, 102));
		txtBienvenidoATermibus.setFont(new Font("Tahoma", Font.PLAIN, 40));
		txtBienvenidoATermibus.setHorizontalAlignment(SwingConstants.CENTER);
		txtBienvenidoATermibus.setText("Bienvenid@\r\na Termibus");
		txtBienvenidoATermibus.setBounds(123, 160, 471, 159);
		add(txtBienvenidoATermibus);
		txtBienvenidoATermibus.setColumns(10);
		
		

	}
}
