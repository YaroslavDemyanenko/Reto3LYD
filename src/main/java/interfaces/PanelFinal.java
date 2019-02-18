package interfaces;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PanelFinal extends JPanel {

	public JLabel lblImpresion, lblEspereUnMomento;

	
	public PanelFinal() {
		setLayout(null);
		setBounds(0,0,800,600);
		setBackground(new Color(193, 240, 240));
		
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
		lblEspereUnMomento.setBounds(115, 250, 578, 311);
		add(lblEspereUnMomento);
	}
}
