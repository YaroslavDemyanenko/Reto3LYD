package interfaces;

import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

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
		lblImpresion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblImpresion.setBounds(249, 183, 443, 83);
		panelProcesar.add(lblImpresion);
		
		lblEspereUnMomento = new JLabel("Espere un momento");
		lblEspereUnMomento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEspereUnMomento.setBounds(249, 277, 443, 48);
		panelProcesar.add(lblEspereUnMomento);

	}
}
