package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

import clases.Linea;
import clases.Modelo;
import interfaces.Ventana;



public class Controlador{
	
	public Modelo mod;
	public Ventana vis;
	
	public Controlador(Modelo modelo,Ventana vista) {
		this.mod=modelo;
		this.vis=vista;
		vista.setContentPane(vista.panelSaludo);
		inicializar_eventos();
	}
	
	public void inicializar_eventos() {
		this.vis.panelSaludo.addMouseListener(new MseListener());
	}

	
	private class BtnListener implements ActionListener
    {
		public void actionPerformed(ActionEvent e)
        {
        	if (e.getSource() == vis.panelSaludo){

        	}
        }
    }
	
	private class MseListener implements MouseListener
    {
		ArrayList<Linea> lineas = new ArrayList<Linea>();
		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == vis.panelSaludo){
        		vis.setContentPane(vis.panelLineas1);
        		try {
					mod.db.meterAModelo(vis.panelLineas1.modeloLineas, "SELECT * FROM `linea`", mod);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
        	}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
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
