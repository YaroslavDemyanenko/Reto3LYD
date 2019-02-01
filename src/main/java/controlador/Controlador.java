package controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import clases.Modelo;
import interfaces.Ventana;

public class Controlador {

	public Modelo mod;
	public Ventana vis;

	public Controlador(Modelo modelo, Ventana vista) {
		this.mod = modelo;
		this.vis = vista;
		vista.setContentPane(vista.panelSaludo);
		inicializarEventos();
	}

	public void inicializarEventos() {
		this.vis.panelSaludo.addMouseListener(new mseListener());
		this.vis.panelLineas1.listLineas.addListSelectionListener(new lstListener());
		this.vis.panelLineas1.btnConfirmar.addActionListener(new btnListener());
		this.vis.panelLineas2.calendarioIda.addPropertyChangeListener("date",new calendarListener());
		this.vis.panelLineas2.btnConfirmar.addActionListener(new btnListener());
	}


	private class btnListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == vis.panelLineas1.btnConfirmar) {
				if (!vis.panelLineas1.listParadas.isSelectionEmpty()) {
					if (vis.panelLineas1.rdbtnIdayVuelta.isSelected()) {
						mod.setIdaYVuelta(true);
					}
					else {
						vis.panelLineas2.calendarioVuelta.setVisible(false);
						vis.panelLineas2.lblFechaVuelta.setVisible(false);
					}
					vis.panelLineas2.lblNombreLinea.setText(vis.panelLineas1.listLineas.getSelectedValue().toString());
					vis.panelLineas2.lblSal.setText(vis.panelLineas1.listParadas.getSelectedValue().toString());
					vis.setContentPane(vis.panelLineas2);
					mod.metodo.limitarFechasIda(vis, 4);
					mod.metodo.limitarFechasVuelta(vis, 4);
					mod.parada.paradasLlegadaAModelo(mod, vis);
				}
			}
			else if (e.getSource() == vis.panelLineas2.btnConfirmar) {
				vis.setContentPane(vis.panelResumen);
				mod.metodo.mostrarResumenTrayecto(vis, mod);
				
			}
		}
	}

	private class mseListener implements MouseListener {

		/*Metodo para que cuando haga click en cualquier zona del panel saludo pase al siguiente panel*/
		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == vis.panelSaludo) {
				vis.setContentPane(vis.panelLineas1);
				try {
					mod.db.llenarModeloConLinea(vis, mod);
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

	private class lstListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (e.getSource() == vis.panelLineas1.listLineas) {
				try {
					vis.panelLineas1.modeloParadas.clear();
					mod.parada.paradasIdaAModelo(vis, mod);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

		}

	}

	private class calendarListener implements PropertyChangeListener{

		@Override
		public void propertyChange(PropertyChangeEvent e) {
			if (e.getSource() == vis.panelLineas2.calendarioIda) {
				mod.metodo.limitarFechasVuelta(vis, 4);
			}
			
		}
		
	}
	
	private class loginListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if (((JButton) e.getSource()).getName()=="botonLogin") {
				
			}
		}
	}
	/**
	 * private VentanaPrincipal vista; private Cliente modelo;
	 * 
	 * public Controlador(VentanaPrincipal vista, Cliente modelo) { this.vista =
	 * vista; this.modelo = modelo; this.vista.panel1.boton.addActionListener(this);
	 * this.vista.panel2.boton.addActionListener(this); }
	 * 
	 * 
	 * @Override public void actionPerformed(ActionEvent e) {
	 * 
	 *           if (e.getSource() == vista.panel1.boton) {
	 *           modelo.setNombre(vista.panel1.textNombre.getText());
	 *           modelo.setApellido(vista.panel1.textApellido.getText());
	 *           vista.setContentPane(vista.panel2);
	 *           vista.panel2.textDatos.setText(modelo.getNombre() + "\n" +
	 *           modelo.getApellido()); }
	 * 
	 *           if (e.getSource() == vista.panel2.boton) {
	 *           vista.panel1.setVisible(true); vista.panel2.setVisible(false); }
	 * 
	 *           }
	 **/
}
