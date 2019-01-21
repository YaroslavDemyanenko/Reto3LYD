package interfaces;

import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelPago {

	JPanel panelPago = new JPanel();

	JTextField txfDineroMetido;
	JTextField txfTotalAPagar;

	JLabel lblDineroMetido;
	JLabel lblTotalAPagar;
	JLabel lblHazClickEn;

	JButton btnSiguiente;
	JButton btnCancelar;

	JButton btn500;
	JButton btn200;
	JButton btn100;
	JButton btn50;
	JButton btn20;
	JButton btn10;
	JButton btn5;
	JButton btn2;
	JButton btn1;
	JButton btn050;
	JButton btn020;
	JButton btn010;
	JButton btn005;
	JButton btn002;
	JButton btn001;
	JButton[] arrayBtn= new JButton[15];
	private JLabel label;
	private JLabel label_1;


	/**
	 * @wbp.parser.entryPoint
	 */
	public void HacerPanelPago() {
		panelPago.setLayout(null);
		panelPago.setVisible(false);

		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSiguiente.setBounds(600, 486, 130, 65);
		panelPago.add(btnSiguiente);

		lblDineroMetido = new JLabel("Dinero metido:      ");
		lblDineroMetido.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDineroMetido.setBounds(490, 194, 219, 35);
		panelPago.add(lblDineroMetido);

		lblTotalAPagar = new JLabel("Total a pagar:   ");
		lblTotalAPagar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTotalAPagar.setBounds(490, 272, 186, 35);
		panelPago.add(lblTotalAPagar);

		btn5 = new JButton("5");
		btn5.setFont(btn5.getFont().deriveFont(0f));
		btn5.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/5euros.jpg")));
		btn5.setBounds(37, 222, 123, 54);
		panelPago.add(btn5);

		btn2 = new JButton("2");
		btn2.setFont(btn2.getFont().deriveFont(0f));
		btn2.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/2euros.png")));
		btn2.setBounds(197, 222, 123, 54);
		panelPago.add(btn2);

		btn10 = new JButton("10");
		btn10.setFont(btn10.getFont().deriveFont(0f));
		btn10.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/10euros.jpg")));
		btn10.setBounds(357, 158, 123, 54);
		panelPago.add(btn10);

		btn200 = new JButton("200");
		btn200.setFont(btn200.getFont().deriveFont(0f));
		btn200.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/200euros.jpg")));
		btn200.setBounds(197, 94, 123, 54);
		panelPago.add(btn200);

		btn20 = new JButton("20");
		btn20.setFont(btn20.getFont().deriveFont(0f));
		btn20.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/20euros.jpg")));
		btn20.setBounds(197, 158, 123, 54);
		panelPago.add(btn20);

		btn500 = new JButton("500");
		btn500.setFont(btn500.getFont().deriveFont(0f));
		btn500.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/500euros.jpg")));
		btn500.setBounds(37, 94, 123, 54);
		panelPago.add(btn500);

		lblHazClickEn = new JLabel("Haz clic en un botón para introducir dinero o haz clic derecho para quitar esa cantidad");
		lblHazClickEn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHazClickEn.setHorizontalAlignment(SwingConstants.CENTER);
		lblHazClickEn.setBounds(0, 29, 788, 35);
		panelPago.add(lblHazClickEn);

		btn100 = new JButton("100");
		btn100.setFont(btn100.getFont().deriveFont(0f));
		btn100.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/100euros.jpg")));
		btn100.setBounds(357, 94, 123, 54);
		panelPago.add(btn100);

		btn50 = new JButton("50");
		btn50.setFont(btn50.getFont().deriveFont(0f));
		btn50.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/50euros.jpg")));
		btn50.setBounds(37, 158, 123, 54);
		panelPago.add(btn50);

		btn1 = new JButton("1");
		btn1.setFont(btn1.getFont().deriveFont(0f));
		btn1.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/1euro.png")));
		btn1.setBounds(357, 222, 123, 54);
		panelPago.add(btn1);

		btn050 = new JButton("0.50");
		btn050.setFont(btn050.getFont().deriveFont(0f));
		btn050.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/50centimos.png")));
		btn050.setBounds(37, 284, 123, 54);
		panelPago.add(btn050);

		btn020 = new JButton("0.20");
		btn020.setFont(btn020.getFont().deriveFont(0f));
		btn020.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/20centimos.png")));
		btn020.setBounds(197, 284, 123, 54);
		panelPago.add(btn020);

		btn010 = new JButton("0.10");
		btn010.setFont(btn010.getFont().deriveFont(0f));
		btn010.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/10centimos.png")));
		btn010.setBounds(357, 284, 123, 54);
		panelPago.add(btn010);

		btn005 = new JButton("0.05");
		btn005.setFont(btn005.getFont().deriveFont(0f));
		btn005.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/5centimos.png")));
		btn005.setBounds(37, 349, 123, 54);
		panelPago.add(btn005);

		btn002 = new JButton("0.02");
		btn002.setFont(btn002.getFont().deriveFont(0f));
		btn002.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/2centimos.png")));
		btn002.setBounds(197, 349, 123, 54);
		panelPago.add(btn002);

		btn001 = new JButton("0.01");
		btn001.setFont(btn001.getFont().deriveFont(0f));
		btn001.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/1centimo.png")));
		btn001.setBounds(357, 349, 123, 54);
		panelPago.add(btn001);

		txfTotalAPagar = new JTextField();
		txfTotalAPagar.setEditable(false);
		txfTotalAPagar.setBackground(Color.WHITE);
		txfTotalAPagar.setHorizontalAlignment(SwingConstants.CENTER);
		txfTotalAPagar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txfTotalAPagar.setDropMode(DropMode.INSERT);
		txfTotalAPagar.setColumns(10);
		txfTotalAPagar.setBounds(632, 263, 112, 54);
		panelPago.add(txfTotalAPagar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancelar.setBounds(68, 486, 130, 65);
		panelPago.add(btnCancelar);

		txfDineroMetido = new JTextField();
		txfDineroMetido.setBackground(Color.WHITE);
		txfDineroMetido.setEditable(false);
		txfDineroMetido.setHorizontalAlignment(SwingConstants.CENTER);
		txfDineroMetido.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txfDineroMetido.setBounds(632, 185, 112, 54);
		panelPago.add(txfDineroMetido);
		txfDineroMetido.setColumns(10);

		arrayBtn[0]=btn500;
		arrayBtn[1]=btn200;
		arrayBtn[2]=btn100;
		arrayBtn[3]=btn50;
		arrayBtn[4]=btn20;
		arrayBtn[5]=btn10;
		arrayBtn[6]=btn5;
		arrayBtn[7]=btn2;
		arrayBtn[8]=btn1;
		arrayBtn[9]=btn050;
		arrayBtn[10]=btn020;
		arrayBtn[11]=btn010;
		arrayBtn[12]=btn005;
		arrayBtn[13]=btn002;
		arrayBtn[14]=btn001;
		
		JLabel lblAdvertenciaCuandoLa = new JLabel("Advertencia: cuando la cantidad introducida supere a la que has \r\nde pagar ");
		lblAdvertenciaCuandoLa.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdvertenciaCuandoLa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdvertenciaCuandoLa.setBounds(26, 409, 512, 38);
		panelPago.add(lblAdvertenciaCuandoLa);
		
		JLabel lblYaNoPodrs = new JLabel("no podr\u00E1s sacar m\u00E1s dinero, se te dar\u00E1 en los \r\ncambios si pulsas \"Siguiente\"");
		lblYaNoPodrs.setHorizontalAlignment(SwingConstants.CENTER);
		lblYaNoPodrs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblYaNoPodrs.setBounds(26, 436, 525, 38);
		panelPago.add(lblYaNoPodrs);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 0, 810, 29);
		panelPago.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(0, 553, 810, 29);
		panelPago.add(panel_1);
		
		label = new JLabel("€");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(754, 272, 43, 35);
		panelPago.add(label);
		
		label_1 = new JLabel("€");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(754, 194, 29, 35);
		panelPago.add(label_1);
		
				
	}

	public JComponent PasarPanelPago() {
		return panelPago;
	}
}