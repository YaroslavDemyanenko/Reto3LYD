package interfaces;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Component;
import javax.swing.border.BevelBorder;

/**
 * @wbp.parser.entryPoint
 */
public class PanelSaludo extends JPanel {

	public JLabel lblBienvenidoATermibus,lblTocaParaContinuar, lblUsuario,lblLogo, lblLogo2;
	public JButton btnSignUP;
	
	public PanelSaludo() {
		setBackground(new Color(193, 240, 240));
		
		setBounds(0, 0, 800, 600);
		setLayout(null);
		
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsuario.setBounds(506, 12, 173, 25);
		add(lblUsuario);
		
		
		
		btnSignUP = new JButton("Sign Up");
		btnSignUP.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		btnSignUP.setAlignmentY(Component.TOP_ALIGNMENT);
		btnSignUP.setBackground(new Color(192, 192, 192));
		btnSignUP.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSignUP.setBounds(676, 12, 102, 23);
		add(btnSignUP);
		btnSignUP.setName("botonLogin");
		
		
		lblTocaParaContinuar = new JLabel();
		lblTocaParaContinuar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTocaParaContinuar.setHorizontalAlignment(SwingConstants.CENTER);
		lblTocaParaContinuar.setText("Toque la pantalla para continuar");
		lblTocaParaContinuar.setBounds(255, 358, 293, 44);
		add(lblTocaParaContinuar);
		
		
		
		lblBienvenidoATermibus = new JLabel();
		lblBienvenidoATermibus.setForeground(new Color(153, 0, 102));
		lblBienvenidoATermibus.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblBienvenidoATermibus.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenidoATermibus.setText("Bienvenid@\r\n a Termibus");
		lblBienvenidoATermibus.setBounds(174, 157, 471, 159);
		add(lblBienvenidoATermibus);
		
		lblLogo = new JLabel("test");
		lblLogo.setBounds(550, 438, 296, 135);
		add(lblLogo);
		lblLogo.setIcon(new ImageIcon(PanelSaludo.class.getResource("/imagenes/logo-termibus.png")));
		
		lblLogo2 = new JLabel("");
		lblLogo2.setBounds(10, 438, 156, 124);
		lblLogo2.setIcon(new ImageIcon(PanelSaludo.class.getResource("/imagenes/LYD_opt (4).png")));
		add(lblLogo2);
		
		
		

	}
	public void limpiar() {
		lblUsuario.setText("");
	}
}
