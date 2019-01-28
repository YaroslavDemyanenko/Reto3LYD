package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
		inicializarEventos();
	}
	
	public void inicializarEventos() {
		
		this.vis.panelSaludo.addMouseListener(new MseListener());
		this.vis.panelLineas1.listLineas.addListSelectionListener(new lstListener());
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
		
		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == vis.panelSaludo){
        		vis.setContentPane(vis.panelLineas1);
        		try {
					mod.db.meterLineaEnListaYArray(vis.panelLineas1.modeloLineas, "SELECT * FROM `linea`", mod,mod.lineas);
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
	
	private class lstListener implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (e.getSource() == vis.panelLineas1.listLineas) {
				String nombreLinea= vis.panelLineas1.listLineas.getSelectedValue().toString();
				nombreLinea=nombreLinea.substring(0,2);
    			String query="select nombre,sqrt(power((longitud-(SELECT Longitud FROM `parada` where Nombre=\"Termibus-Bilbao\")),2)+power((latitud-(SELECT Latitud FROM `parada` where Nombre=\"Termibus-Bilbao\")),2)) distancia from parada WHERE Cod_Parada IN(SELECT Cod_Parada FROM linea_parada where linea_parada.Cod_Linea=\""+nombreLinea+"\") order by distancia;";
				try {
					vis.panelLineas1.modeloParadas.clear();
					mod.db.meterParadasAModelo(vis.panelLineas1.modeloParadas,nombreLinea, query, mod);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
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
