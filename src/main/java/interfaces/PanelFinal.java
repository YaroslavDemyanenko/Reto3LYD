package interfaces;

import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
/**
 * @wbp.parser.entryPoint
 */
public class PanelFinal extends JPanel {

	public JLabel lblImpresion, lblEspereUnMomento;

	
	public PanelFinal() {
		setLayout(null);
		setVisible(false);
		setBounds(0,0,800,600);
		
		lblImpresion = new JLabel("Imprimiendo billete/s...");
		lblImpresion.setHorizontalAlignment(SwingConstants.CENTER);
		lblImpresion.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblImpresion.setBounds(184, 183, 443, 83);
		add(lblImpresion);
		
		lblEspereUnMomento = new JLabel();
		lblEspereUnMomento.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEspereUnMomento.setHorizontalAlignment(SwingConstants.CENTER);
		lblEspereUnMomento.setIcon(new ImageIcon(PanelFinal.class.getResource("/imagenes/cargando.gif")));
		lblEspereUnMomento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEspereUnMomento.setBounds(219, 250, 369, 260);
		add(lblEspereUnMomento);
	}
}
