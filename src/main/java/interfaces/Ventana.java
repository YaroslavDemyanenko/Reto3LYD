package interfaces;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class Ventana extends JFrame {

	JFrame ventana;


	public Ventana() {

		//Inicializacion de variables

		ventana = new JFrame("test");
		ventana.setResizable(false);
		ventana.setBounds(100, 100, 800, 600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.getContentPane().setLayout(new CardLayout(0, 0));

		

	}
}
