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

public class PagoPrueba {


	JPanel panelPago = new JPanel();

	JTextField txfDineroMetido;
	JTextField txfVueltas;

	JLabel lblDineroMetido;
	JLabel lblPagado;
	JLabel lblTitulo;

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
	private JLabel lblAPagar;
	private JTextField textField;
	private JLabel lblUsuario;
	private JButton btnLogOut;


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

		lblDineroMetido = new JLabel("Dinero metido:");
		lblDineroMetido.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDineroMetido.setBounds(280, 75, 169, 35);
		panelPago.add(lblDineroMetido);

		lblPagado = new JLabel("Vueltas");
		lblPagado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPagado.setBounds(544, 75, 112, 35);
		panelPago.add(lblPagado);

		btn5 = new JButton("5");
		btn5.setFont(btn5.getFont().deriveFont(0f));
		btn5.setBounds(39, 279, 59, 51);
		panelPago.add(btn5);

		btn2 = new JButton("2");
		btn2.setFont(btn2.getFont().deriveFont(0f));
		btn2.setBounds(127, 279, 59, 54);
		panelPago.add(btn2);

		btn10 = new JButton("10");
		btn10.setFont(btn10.getFont().deriveFont(0f));
		btn10.setBounds(210, 233, 60, 35);
		panelPago.add(btn10);

		btn200 = new JButton("200");
		btn200.setFont(btn200.getFont().deriveFont(0f));
		btn200.setBounds(128, 187, 59, 35);
		panelPago.add(btn200);

		btn20 = new JButton("20");
		btn20.setFont(btn20.getFont().deriveFont(0f));
		btn20.setBounds(127, 233, 59, 35);
		panelPago.add(btn20);

		btn500 = new JButton("500");
		btn500.setFont(btn500.getFont().deriveFont(0f));
		btn500.setBounds(40, 187, 59, 35);
		panelPago.add(btn500);

		lblTitulo = new JLabel("Pago");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 37, 788, 35);
		panelPago.add(lblTitulo);

		btn100 = new JButton("100");
		btn100.setFont(btn100.getFont().deriveFont(0f));
		btn100.setBounds(211, 187, 59, 35);
		panelPago.add(btn100);

		btn50 = new JButton("50");
		btn50.setFont(btn50.getFont().deriveFont(0f));
		btn50.setBounds(39, 233, 59, 35);
		panelPago.add(btn50);

		btn1 = new JButton("1");
		btn1.setFont(btn1.getFont().deriveFont(0f));
		btn1.setBounds(210, 277, 65, 54);
		panelPago.add(btn1);

		btn050 = new JButton("0.50");
		btn050.setFont(btn050.getFont().deriveFont(0f));
		btn050.setBounds(39, 341, 59, 54);
		panelPago.add(btn050);

		btn020 = new JButton("0.20");
		btn020.setFont(btn020.getFont().deriveFont(0f));
		btn020.setBounds(127, 341, 59, 54);
		panelPago.add(btn020);

		btn010 = new JButton("0.10");
		btn010.setFont(btn010.getFont().deriveFont(0f));
		btn010.setBounds(210, 341, 65, 54);
		panelPago.add(btn010);

		btn005 = new JButton("0.05");
		btn005.setFont(btn005.getFont().deriveFont(0f));
		btn005.setBounds(39, 406, 60, 54);
		panelPago.add(btn005);

		btn002 = new JButton("0.02");
		btn002.setFont(btn002.getFont().deriveFont(0f));
		btn002.setBounds(127, 406, 59, 54);
		panelPago.add(btn002);

		btn001 = new JButton("0.01");
		btn001.setFont(btn001.getFont().deriveFont(0f));
		btn001.setBounds(210, 406, 65, 54);
		panelPago.add(btn001);

		txfVueltas = new JTextField();
		txfVueltas.setEditable(false);
		txfVueltas.setHorizontalAlignment(SwingConstants.CENTER);
		txfVueltas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txfVueltas.setDropMode(DropMode.INSERT);
		txfVueltas.setColumns(10);
		txfVueltas.setBounds(545, 105, 112, 54);
		panelPago.add(txfVueltas);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancelar.setBounds(68, 486, 130, 65);
		panelPago.add(btnCancelar);

		txfDineroMetido = new JTextField();
		txfDineroMetido.setEditable(false);
		txfDineroMetido.setHorizontalAlignment(SwingConstants.CENTER);
		txfDineroMetido.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txfDineroMetido.setBounds(280, 105, 130, 54);
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
		
		label = new JLabel("\u20AC");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(667, 114, 43, 35);
		panelPago.add(label);
		
		label_1 = new JLabel("\u20AC");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(420, 121, 29, 35);
		panelPago.add(label_1);
		
		lblAPagar = new JLabel("A pagar:");
		lblAPagar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAPagar.setBounds(52, 75, 98, 25);
		panelPago.add(lblAPagar);
		
		textField = new JTextField();
		textField.setBounds(52, 107, 104, 42);
		panelPago.add(textField);
		textField.setColumns(10);
		
		JList list = new JList();
		list.setBounds(438, 192, 318, 268);
		panelPago.add(list);
		
		lblUsuario = new JLabel("USUARIO");
		lblUsuario.setBounds(582, 11, 112, 35);
		panelPago.add(lblUsuario);
		
		btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(694, 11, 104, 35);
		panelPago.add(btnLogOut);
		
				
	}

}
