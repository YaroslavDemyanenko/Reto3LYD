package controlador;

import java.awt.event.ActionEvent;
import java.sql.Connection;

import clases.Modelo;
import interfaces.Ventana;



public class Controlador {
	
	public Modelo mod;
	public Ventana vis;
	
	public Controlador(Modelo modelo,Ventana vista) {
		this.mod=modelo;
		this.vis=vista;
		vista.setContentPane(vista.panelSaludo);
		inicializar_eventos();
	}
	
	public void inicializar_eventos() {
		//Listeners
	}
	
	
	
	
	
	/**
	private VentanaPrincipal vista;
	private Cliente modelo;

	public Controlador(VentanaPrincipal vista, Cliente modelo) {
		this.vista = vista;
		this.modelo = modelo;
		this.vista.panel1.boton.addActionListener(this);
		this.vista.panel2.boton.addActionListener(this);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == vista.panel1.boton) {
			modelo.setNombre(vista.panel1.textNombre.getText());
			modelo.setApellido(vista.panel1.textApellido.getText());
			vista.setContentPane(vista.panel2);
			vista.panel2.textDatos.setText(modelo.getNombre() + "\n" + modelo.getApellido());
		}

		if (e.getSource() == vista.panel2.boton) {
			vista.panel1.setVisible(true);
			vista.panel2.setVisible(false);
		}

	}
	**/
}
