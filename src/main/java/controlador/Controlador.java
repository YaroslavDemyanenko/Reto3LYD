package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import clases.Cliente;
import clases.Modelo;
import interfaces.Ventana;
/**
 * Clase de eventos y variables, el cerebro del programa
 * @author Yaros
 *
 */
public class Controlador {

	public Modelo mod;
	public Ventana vis;

	/**
	 * Constructor que junta la interfaz con el programa e inicializa los eventos
	 * @param modelo
	 * @param vista
	 */
	public Controlador(Modelo modelo, Ventana vista) {
		this.mod = modelo;
		this.vis = vista;
		vista.setContentPane(vista.panelSaludo);
		inicializarEventos();
	}

	/**
	 * Inicializa los eventos metiendo listeners a todos los objetos necesarios
	 */
	public void inicializarEventos() {
		this.vis.panelSaludo.addMouseListener(new mseListener());
		this.vis.panelLineas2.spnNumeroDeBilletes.addMouseListener(new mseListener());

		this.vis.panelLineas1.listLineas.addListSelectionListener(new lstListener());
		this.vis.panelLineas2.listaDestinos.addListSelectionListener(new lstListener());

		this.vis.panelLineas2.calendarioIda.addPropertyChangeListener("date", new changeListener());
		this.vis.panelLineas2.calendarioVuelta.addPropertyChangeListener("date", new changeListener());
		this.vis.panelConfirmacion.comboBoxPasajeros.addPropertyChangeListener(new changeListener());
		this.vis.panelConfirmacion.btnImprimir.addActionListener(new btnListener());

		this.vis.panelLineas1.btnConfirmar.addActionListener(new btnListener());
		this.vis.panelLineas2.btnConfirmar.addActionListener(new btnListener());
		this.vis.panelSaludo.btnSignUP.addActionListener(new btnListener());
		this.vis.panelLineas1.btnSignUP.addActionListener(new btnListener());
		this.vis.panelLineas2.btnLogIn.addActionListener(new btnListener());
		this.vis.panelResumen.btnSignUp.addActionListener(new btnListener());
		this.vis.panelResumen.btnConfirmar.addActionListener(new btnListener());
		this.vis.panelLogin.btnConfirmarLogin.addActionListener(new btnListener());
		this.vis.panelLogin.btnConfirmarRegistro.addActionListener(new btnListener());

		
		this.vis.panelPago.btnConfirmar.addActionListener(new btnListener());
		this.vis.panelPasajeroExtra.btnConfirmar.addActionListener(new btnListener());
		
		
		this.vis.panelConfirmacion.comboBoxPasajeros.addItemListener(new comboListener());


		// botones de pago
		for (int i = 0; i < vis.panelPago.arrayBtn.length; i++) {
			this.vis.panelPago.arrayBtn[i].addMouseListener(new mseListener());
		}

		this.vis.panelLineas1.btnCancelar.addActionListener(new cancelListener());
		this.vis.panelLineas2.btnCancelar.addActionListener(new cancelListener());
		this.vis.panelResumen.btnCancelar.addActionListener(new cancelListener());
		this.vis.panelPasajeroExtra.btnCancelar.addActionListener(new cancelListener());
		this.vis.panelLogin.btnCancelar.addActionListener(new cancelListener());
		this.vis.panelConfirmacion.btnCancelar.addActionListener(new cancelListener());
		this.vis.panelPago.btnCancelar.addActionListener(new cancelListener());
	}

	/**
	 * Clase listner para los botones
	 * @author Yaros
	 *
	 */
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
					vis.panelLineas2.listaDestinos.setSelectedIndex(0);
					mod.billete.informacionGeneralBilletes(mod, vis);
					mod.billete.fechasGeneralBilletes(mod, vis);
					vis.panelLineas2.spnNumeroDeBilletes.setValue(1);
					vis.panelLineas2.spnNumeroDeBilletes.setModel(new SpinnerNumberModel(1, 0, mod.autobus.numeroPlazasRestantes(mod, vis), 1));
				}
			} else if (e.getSource() == vis.panelLineas2.btnConfirmar) {
				if (!vis.panelLineas2.listaDestinos.isSelectionEmpty() && (int) vis.panelLineas2.spnNumeroDeBilletes.getValue()>0) {
					vis.panelResumen.textPrecio.setText(mod.metodosPago.precioTotal(mod, (int) (vis.panelLineas2.spnNumeroDeBilletes.getModel().getValue())));
					vis.setContentPane(vis.panelResumen);
					mod.metodo.mostrarResumenTrayecto(vis, mod);
				}

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
					mod.db.insertarUsuarioEnBaseDeDatos(mod.clienteRegistrado);
					vis.setContentPane(mod.ultimoPanel);
				}
			} else if (e.getSource() == vis.panelResumen.btnConfirmar) {
				vis.panelPago.textAPagar.setText(vis.panelResumen.textPrecio.getText());
				vis.panelConfirmacion.textFieldPrecioBillete.setText(vis.panelResumen.textPrecio.getText());
				if (mod.estaLogeado()) {
					vis.setContentPane(vis.panelPago);
				} else {
					mod.ultimoPanel = vis.panelPago;
					vis.setContentPane(vis.panelLogin);
				}
			} else if (e.getSource() == vis.panelPago.btnConfirmar) {
				mod.arrayClientes.clear();
				mod.arrayClientes.add(mod.clienteRegistrado);
				if (mod.numeroBilletes > 1) {
					vis.setContentPane(vis.panelPasajeroExtra);
				} else {
					vis.setContentPane(vis.panelConfirmacion);
					mod.metodo.meterClientesEnComboBox(vis, mod, mod.arrayClientes);
					mod.metodo.confirmacionTrayecto(vis.panelConfirmacion, vis.panelLineas2, vis.panelLineas1, mod);
					mod.metodo.confirmacionDatos(vis.panelConfirmacion, vis.panelLineas2, mod);
				}
				
			} else if (e.getSource() == vis.panelPasajeroExtra.btnConfirmar) {
				Cliente cliente = mod.metodosLogin.pasajeroExtra(vis.panelPasajeroExtra);
				if (cliente != null) {
					mod.arrayClientes.add(cliente);
					vis.panelPasajeroExtra.limpiar();
					if(mod.numeroBilletes==mod.arrayClientes.size()) {
						vis.setContentPane(vis.panelConfirmacion);
						mod.metodo.meterClientesEnComboBox(vis, mod, mod.arrayClientes);
						mod.metodo.confirmacionTrayecto(vis.panelConfirmacion, vis.panelLineas2, vis.panelLineas1, mod);
						mod.metodo.confirmacionDatos(vis.panelConfirmacion, vis.panelLineas2, mod);
						
					}
				} 	
			}else if (e.getSource() == vis.panelConfirmacion.btnImprimir){
				vis.setContentPane(vis.panelFinal);
				for (int i=0, contBilletes=mod.db.codigoDeBillete();i<mod.arrayClientes.size();i++,contBilletes++){
					mod.metodo.imprimirBillete(mod,mod.billeteGeneralIda, mod.arrayClientes.get(i),contBilletes,false);
					mod.db.insertarBilleteIdaDB(mod.arrayClientes.get(i), mod.billeteGeneralIda);
					if(mod.isIdaYVuelta()) {
						contBilletes++;
						mod.metodo.imprimirBillete(mod,mod.billeteGeneralVuelta, mod.arrayClientes.get(i),contBilletes,true);
						mod.db.insertarBilleteVueltaDB(mod.arrayClientes.get(i), mod.billeteGeneralVuelta);
					}
				}
				Timer timer = new Timer(5000, new ActionListener() {

				    @Override
				    public void actionPerformed(ActionEvent arg0) {            
				    	mod.reset();
						vis.panelConfirmacion.limpiar();
						vis.panelPago.limpiar();
						vis.panelPasajeroExtra.limpiar();
						vis.panelLogin.limpiar();
						vis.panelResumen.limpiar();
						vis.panelLineas2.limpiar();
						vis.panelLineas1.limpiar();
						vis.panelSaludo.limpiar();
						vis.setContentPane(vis.panelSaludo);
				    }
				});
				timer.setRepeats(false);
				timer.start();	
			}

		}
	}

	/**
	 * Clase listener para los botones que cancelan/reinician el programa
	 * @author Yaros
	 *
	 */
	private class cancelListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			vis.panelConfirmacion.limpiar();
			vis.panelPago.limpiar();
			vis.panelPasajeroExtra.limpiar();
			vis.panelLogin.limpiar();
			vis.panelResumen.limpiar();
			vis.panelLineas2.limpiar();
			vis.panelLineas1.limpiar();
			vis.panelSaludo.limpiar();
			vis.setContentPane(vis.panelSaludo);
			mod.reset();
		}
	}

	/**
	 * Clase listener para el raton
	 * @author Yaros
	 *
	 */
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
			if (e.getSource() instanceof JButton) {
				if (SwingUtilities.isLeftMouseButton(e)) {
					mod.metodosPago.sumarDinero(vis.panelPago, (JButton) e.getSource());

				} else if (SwingUtilities.isRightMouseButton(e) && ((JButton) e.getSource()).isEnabled() == true) {
					mod.metodosPago.restarDinero(vis.panelPago, (JButton) e.getSource());
				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

	}

	/**
	 * Clase listener que escucha los cambios en las listas
	 * @author Yaros
	 *
	 */
	private class lstListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (e.getSource() == vis.panelLineas1.listLineas && e.getValueIsAdjusting() == true && vis.panelLineas1.listLineas.getSelectedIndex() > -1) {
				vis.panelLineas1.modeloParadas.clear();
				mod.parada.paradasIdaAModelo(vis, mod);
			}
			if (e.getSource() == vis.panelLineas2.listaDestinos && e.getValueIsAdjusting() == true && vis.panelLineas2.listaDestinos.getSelectedIndex() > -1) {
				mod.billete.informacionGeneralBilletes(mod, vis);
				mod.billete.fechasGeneralBilletes(mod, vis);
				vis.panelLineas2.spnNumeroDeBilletes.setValue(1);
				vis.panelLineas2.spnNumeroDeBilletes.setModel(new SpinnerNumberModel(1, 0, mod.autobus.numeroPlazasRestantes(mod, vis), 1));
			}

		}

	}
	


	/**
	 * Clase listener que escuchas los cambios de propiedades en calendarios
	 * @author Yaros
	 *
	 */
	private class changeListener implements PropertyChangeListener {

		@Override
		public void propertyChange(PropertyChangeEvent e) {
			if (e.getSource() == vis.panelLineas2.calendarioIda) {
				mod.metodo.limitarFechasVuelta(vis, 4);
				mod.billete.fechasGeneralBilletes(mod, vis);
			} else if ((e.getSource() == vis.panelLineas2.calendarioVuelta) && !vis.panelLineas2.listaDestinos.isSelectionEmpty()) {
				vis.panelLineas2.spnNumeroDeBilletes.setValue(1);
				mod.billete.fechasGeneralBilletes(mod, vis);
				vis.panelLineas2.spnNumeroDeBilletes.setModel(new SpinnerNumberModel(1, 0, mod.autobus.numeroPlazasRestantes(mod, vis), 1));
			} 
		}

	}

	/**
	 * Clase listener que escuchas los cambios en los comboBox
	 * @author Yaros
	 *
	 */
	private class comboListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				mod.metodo.confirmacionTrayecto(vis.panelConfirmacion, vis.panelLineas2, vis.panelLineas1, mod);
				mod.metodo.confirmacionDatos(vis.panelConfirmacion, vis.panelLineas2, mod);
		       }
			
		}
		
	}
}
