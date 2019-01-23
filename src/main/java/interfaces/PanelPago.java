package interfaces;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.sun.prism.paint.Color;
import javax.swing.ImageIcon;
import java.awt.Cursor;

public class PanelPago extends JPanel{

	JButton btn500, btn200, btn100, btn50, btn20, btn10, btn5, btn2, btn1, btn050, btn020, btn010, btn005, btn002, btn001, btnLogOut, btnSiguiente, btnCancelar;
	JButton[] arrayBtn= new JButton[15];
	JLabel label, label_1, label_2, lblAPagar, lblUsuario, lblTitulo, lblPagado, lblDineroMetido;
	JTextField textField, textDineroMetido, textVueltas;
	JList list;


	/**
	 * @wbp.parser.entryPoint
	 */
	public PanelPago() {
		setLayout(null);
		setVisible(false);

		setBounds(0,0,800,600);
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSiguiente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSiguiente.setBounds(457, 511, 229, 59);
		add(btnSiguiente);

		lblDineroMetido = new JLabel("Dinero metido:");
		lblDineroMetido.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDineroMetido.setBounds(309, 75, 169, 35);
		add(lblDineroMetido);
		
		textDineroMetido = new JTextField();
		textDineroMetido.setBounds(309, 110, 130, 41);
		add(textDineroMetido);
		textDineroMetido.setColumns(10);

		lblPagado = new JLabel("Vueltas:");
		lblPagado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPagado.setBounds(581, 75, 112, 35);
		add(lblPagado);
		
		textVueltas = new JTextField();
		textVueltas.setBounds(581, 110, 104, 41);
		add(textVueltas);

		textVueltas.setBounds(581, 108, 104, 41);
		add(textVueltas);
		textVueltas.setColumns(10);

		btn5 = new JButton("5");
		btn5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn5.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/5euros.jpg")));
		btn5.setFont(btn5.getFont().deriveFont(0f));
		btn5.setBounds(40, 289, 59, 35);
		add(btn5);
		btn5.setBounds(39, 279, 59, 51);
		add(btn5);


		btn2 = new JButton("2");
		btn2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn2.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/2euros.png")));
		btn2.setFont(btn2.getFont().deriveFont(0f));
		btn2.setBounds(127, 279, 59, 54);
		add(btn2);

		btn10 = new JButton("10");
		btn10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn10.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/10euros.jpg")));
		btn10.setFont(btn10.getFont().deriveFont(0f));
		btn10.setBounds(210, 233, 60, 35);
		add(btn10);

		btn200 = new JButton("200");
		btn200.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn200.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/200euros.jpg")));
		btn200.setFont(btn200.getFont().deriveFont(0f));
		btn200.setBounds(128, 187, 59, 35);
		add(btn200);

		btn20 = new JButton("20");
		btn20.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn20.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/20euros.jpg")));
		btn20.setFont(btn20.getFont().deriveFont(0f));
		btn20.setBounds(127, 233, 59, 35);
		add(btn20);

		btn500 = new JButton("500");
		btn500.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn500.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/500euros.jpg")));
		btn500.setFont(btn500.getFont().deriveFont(0f));
		btn500.setBounds(40, 187, 59, 35);
		add(btn500);

		lblTitulo = new JLabel("Pago");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(255, 12, 223, 35);
		add(lblTitulo);

		btn100 = new JButton("100");
		btn100.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn100.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/100euros.jpg")));
		btn100.setFont(btn100.getFont().deriveFont(0f));
		btn100.setBounds(211, 187, 59, 35);
		add(btn100);

		btn50 = new JButton("50");
		btn50.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn50.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/50euros.jpg")));
		btn50.setFont(btn50.getFont().deriveFont(0f));
		btn50.setBounds(39, 233, 59, 35);
		add(btn50);

		btn1 = new JButton("1");
		btn1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn1.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/1euro.png")));
		btn1.setFont(btn1.getFont().deriveFont(0f));
		btn1.setBounds(210, 277, 65, 54);
		add(btn1);

		btn050 = new JButton("0.50");
		btn050.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn050.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/50centimos.png")));
		btn050.setFont(btn050.getFont().deriveFont(0f));
		btn050.setBounds(39, 341, 59, 54);
		add(btn050);

		btn020 = new JButton("0.20");
		btn020.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn020.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/20centimos.png")));
		btn020.setFont(btn020.getFont().deriveFont(0f));
		btn020.setBounds(127, 341, 59, 54);
		add(btn020);

		btn010 = new JButton("0.10");
		btn010.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn010.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/10centimos.png")));
		btn010.setFont(btn010.getFont().deriveFont(0f));
		btn010.setBounds(210, 341, 65, 54);
		add(btn010);

		btn005 = new JButton("0.05");
		btn005.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn005.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/5centimos.png")));
		btn005.setFont(btn005.getFont().deriveFont(0f));
		btn005.setBounds(39, 406, 60, 54);
		add(btn005);

		btn002 = new JButton("0.02");
		btn002.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn002.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/2centimos.png")));
		btn002.setFont(btn002.getFont().deriveFont(0f));
		btn002.setBounds(127, 406, 59, 54);
		add(btn002);

		btn001 = new JButton("0.01");
		btn001.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn001.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/1centimo.png")));
		btn001.setFont(btn001.getFont().deriveFont(0f));
		btn001.setBounds(210, 406, 65, 54);
		add(btn001);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancelar.setBounds(114, 511, 229, 59);
		add(btnCancelar);

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
		
		label = new JLabel("\u20AC");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(695, 121, 43, 35);
		add(label);
		
		label_1 = new JLabel("\u20AC");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(449, 121, 29, 35);
		add(label_1);
		
		label_2 = new JLabel("\u20AC");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBounds(166, 121, 29, 35);
		add(label_2);
		
		lblAPagar = new JLabel("A pagar:");
		lblAPagar.setFont(new Font("Tahoma", Font.PLAIN, 20));

		lblAPagar.setBounds(52, 80, 98, 25);
		add(lblAPagar);
		
		textField = new JTextField();
		textField.setBounds(52, 110, 104, 42);
		add(textField);

		lblAPagar.setBounds(52, 75, 98, 25);
		add(lblAPagar);
		
		textField = new JTextField();
		textField.setBounds(52, 107, 104, 42);
		add(textField);
		textField.setColumns(10);
		
		list = new JList();
		list.setBounds(484, 192, 254, 268);
		add(list);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(593, 12, 86, 25);
		add(lblUsuario);
		
		btnLogOut = new JButton("Log out");
		btnLogOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogOut.setBounds(689, 12, 89, 23);
		add(btnLogOut);
		
				
	}
}
