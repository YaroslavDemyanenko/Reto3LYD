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

public class PanelFinal {

	JPanel panelProcesar = new JPanel();	
	JLabel lblImpresion, lblEspereUnMomento;

	/**
	 * @wbp.parser.entryPoint
	 */
	public void Impresion() {
		panelProcesar.setLayout(null);
		panelProcesar.setBounds(0,0,800,600);
		
		lblImpresion = new JLabel("Imprimiendo billete/s...");
		lblImpresion.setHorizontalAlignment(SwingConstants.CENTER);
		lblImpresion.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblImpresion.setBounds(184, 183, 443, 83);
		panelProcesar.add(lblImpresion);
		
		lblEspereUnMomento = new JLabel("Espere un momento");
		lblEspereUnMomento.setHorizontalAlignment(SwingConstants.CENTER);
		lblEspereUnMomento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEspereUnMomento.setBounds(184, 328, 443, 48);
		panelProcesar.add(lblEspereUnMomento);

	}
}
