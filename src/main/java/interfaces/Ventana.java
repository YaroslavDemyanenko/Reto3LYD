package interfaces;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class Ventana extends JFrame {
	public PanelSaludo panelSaludo;
	public PanelConfirmacion panelConfirmacion;
	public PanelFinal panelFinal;
	public PanelLineas1 panelLineas1;
	public PanelLineas2 panelLineas2;
	
	public PanelPasajeroExtra panelPasajeroExtra;
	public PanelLogin panelLogin;
	public PanelPago panelPago;

	public Ventana() {

		panelSaludo=new PanelSaludo();
		panelConfirmacion=new PanelConfirmacion();
		panelFinal=new PanelFinal();
		panelLineas1=new PanelLineas1();
		panelLineas2=new PanelLineas2();
		
		panelPasajeroExtra=new PanelPasajeroExtra();
		panelLogin=new PanelLogin();
		panelPago=new PanelPago();
		getContentPane().add(panelSaludo);
		getContentPane().add(panelLineas1);
		getContentPane().add(panelLineas2);
		//AQUI VA LA ULTIMA INTERFAZ
		getContentPane().add(panelLogin);
		getContentPane().add(panelPasajeroExtra);
		getContentPane().add(panelPago);
		getContentPane().add(panelConfirmacion);
		getContentPane().add(panelFinal);
		
		//Inicializacion de variables
		
		setResizable(false);
		setBounds(0, 0, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new CardLayout(0, 0));
		setTitle("Termibus"); 
		setLocationRelativeTo(null);
		

	}
}
