package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JPanel;
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
		this.vis.panelLineas2.calendarioIda.addPropertyChangeListener("date", new calendarListener());
		this.vis.panelLineas2.btnConfirmar.addActionListener(new btnListener());

		this.vis.panelSaludo.btnSignUP.addActionListener(new btnListener());
		this.vis.panelLineas1.btnSignUP.addActionListener(new btnListener());
		this.vis.panelLineas2.btnLogIn.addActionListener(new btnListener());
		this.vis.panelResumen.btnSignUp.addActionListener(new btnListener());

		this.vis.panelLogin.btnConfirmarLogin.addActionListener(new btnListener());
		this.vis.panelLogin.btnConfirmarRegistro.addActionListener(new btnListener());

		this.vis.panelLineas1.btnCancelar.addActionListener(new cancelListener());
		this.vis.panelLineas2.btnCancelar.addActionListener(new cancelListener());
		this.vis.panelResumen.btnCancelar.addActionListener(new cancelListener());
		this.vis.panelPasajeroExtra.btnCancelar.addActionListener(new cancelListener());
		this.vis.panelLogin.btnCancelar.addActionListener(new cancelListener());
		this.vis.panelConfirmacion.btnCancelar.addActionListener(new cancelListener());
		this.vis.panelPago.btnCancelar.addActionListener(new cancelListener());
	}

	private class btnListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == vis.panelLineas1.btnConfirmar) {
				if (!vis.panelLineas1.listParadas.isSelectionEmpty()) {
					if (vis.panelLineas1.rdbtnIdayVuelta.isSelected()) {
						mod.setIdaYVuelta(true);
					} else {
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
			} else if (e.getSource() == vis.panelLineas2.btnConfirmar) {
				// mod.db.calcularPrecioTrayecto(mod);
				vis.setContentPane(vis.panelResumen);
				mod.metodo.mostrarResumenTrayecto(vis, mod);

			} else if (((JButton) e.getSource()).getName() == "botonLogin") {
				mod.ultimoPanel = (JPanel) ((JButton) e.getSource()).getParent();
				vis.setContentPane(vis.panelLogin);
			} else if (e.getSource() == vis.panelLogin.btnConfirmarLogin) {
				mod.clienteRegistrado = mod.metodosLogin.iniciarSesion(mod, vis);
				if (mod.clienteRegistrado != null) {
					vis.setContentPane(mod.ultimoPanel);
				}
			} else if (e.getSource() == vis.panelLogin.btnConfirmarRegistro) {
				mod.clienteRegistrado = mod.metodosLogin.registroUsuario(vis, mod);
				if (mod.clienteRegistrado != null) {
					mod.db.insertarUsuarioEnBaseDeDatos(mod.clienteRegistrado, mod);
					vis.setContentPane(mod.ultimoPanel);
				}
			}
		}
	}

	private class cancelListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			vis.setContentPane(vis.panelSaludo);
			mod.reset();
			switch ((((JButton) e.getSource()).getParent().getName())) {
			case "panelConfirmacion":
				vis.panelConfirmacion.limpiar();
			case "panelPago":
				vis.panelPago.limpiar();
			case "panelPasajeroExtra":
				vis.panelPasajeroExtra.limpiar();
			case "panelLogin":
				vis.panelLogin.limpiar();
			case "panelResumen":
				vis.panelResumen.limpiar();
			case "panelLineas2":
				vis.panelLineas2.limpiar();
			case "PanelLineas1":
				vis.panelLineas1.limpiar();
				break;
			}
		}
	}

	private class mseListener implements MouseListener {

		/**
		 * Metodo para que cuando haga click en cualquier zona del panel saludo pase al
		 * siguiente panel
		 */
		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == vis.panelSaludo) {
				vis.setContentPane(vis.panelLineas1);
				mod.db.llenarModeloConLinea(vis, mod);
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
			if (e.getSource() == vis.panelLineas1.listLineas && e.getValueIsAdjusting() == true) {
				try {
					vis.panelLineas1.modeloParadas.clear();
					mod.parada.paradasIdaAModelo(vis, mod);
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (NullPointerException e2) {
					e2.printStackTrace();
				}
			}

		}

	}

	private class calendarListener implements PropertyChangeListener {

		@Override
		public void propertyChange(PropertyChangeEvent e) {
			if (e.getSource() == vis.panelLineas2.calendarioIda) {
				mod.metodo.limitarFechasVuelta(vis, 4);
			}

		}

	}

}
