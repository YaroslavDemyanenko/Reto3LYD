package interfaces;
import java.awt.Color;
import java.awt.Font;

import javax.imageio.IIOImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.sun.javafx.iio.ImageFrame;

/**
 * @wbp.parser.entryPoint
 */
public class PanelSaludo extends JPanel {

	public JLabel lblBienvenidoATermibus,lblTocaParaContinuar, lblUsuario;
	public JButton btnSignUP;
	
	public PanelSaludo() {
		setBackground(new Color(193, 240, 240));
		
		setBounds(0, 0, 800, 600);
		setLayout(null);
		
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(506, 12, 173, 25);
		add(lblUsuario);
		
		
		
		btnSignUP = new JButton("Sign UP");
		btnSignUP.setBackground(new Color(0, 0, 0));
		btnSignUP.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSignUP.setBounds(689, 12, 89, 23);
		add(btnSignUP);
		
		
		lblTocaParaContinuar = new JLabel();
		lblTocaParaContinuar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTocaParaContinuar.setHorizontalAlignment(SwingConstants.CENTER);
		lblTocaParaContinuar.setText("Toca para continuar");
		lblTocaParaContinuar.setBounds(255, 358, 293, 44);
		add(lblTocaParaContinuar);
		
		
		
		lblBienvenidoATermibus = new JLabel();
		lblBienvenidoATermibus.setForeground(new Color(153, 0, 102));
		lblBienvenidoATermibus.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblBienvenidoATermibus.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenidoATermibus.setText("Bienvenid@\r\n a Termibus");
		lblBienvenidoATermibus.setBounds(174, 157, 471, 159);
		add(lblBienvenidoATermibus);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(506, 438, 296, 135);
		add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(PanelSaludo.class.getResource("/imagenes/logo-termibus.png")));
		
		
		

	}
}
