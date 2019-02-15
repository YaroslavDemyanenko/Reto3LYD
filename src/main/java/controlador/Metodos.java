package controlador;


import java.util.Calendar;
import java.util.Date;

import clases.Cliente;
import clases.Modelo;
import clases.Parada;
import interfaces.PanelConfirmacion;
import interfaces.PanelLineas1;
import interfaces.PanelLineas2;
import interfaces.Ventana;

public class Metodos {

	/**
	 * Limita las fechas de los billetes
	 * 
	 * @param vis
	 * @param numDias
	 */
	public void limitarFechasIda(Ventana vis, int numDias) {
		Date fechaLimite = new Date();
		vis.panelLineas2.calendarioIda.setDate(fechaLimite);
		Calendar c = Calendar.getInstance();
		c.setTime(fechaLimite);
		c.add(Calendar.DATE, numDias);
		fechaLimite = c.getTime();
		vis.panelLineas2.calendarioIda.setSelectableDateRange(new Date(), fechaLimite);
	}

	/**
	 * Limita las fechas de la vuelta
	 * 
	 * @param vis
	 * @param numDias
	 */
	public void limitarFechasVuelta(Ventana vis, int numDias) {
		Date fechaLimite = vis.panelLineas2.calendarioIda.getDate();
		Calendar c = Calendar.getInstance();
		c.setTime(fechaLimite);
		fechaLimite = c.getTime();
		vis.panelLineas2.calendarioVuelta.setDate(fechaLimite);
		c.add(Calendar.DATE, numDias);
		fechaLimite = c.getTime();
		vis.panelLineas2.calendarioVuelta.setSelectableDateRange(vis.panelLineas2.calendarioVuelta.getDate(), fechaLimite);
		vis.panelLineas2.calendarioVuelta.setDate(vis.panelLineas2.calendarioVuelta.getMinSelectableDate());

	}	
	
	

	
	  

	public void mostrarResumenTrayecto(Ventana vis, Modelo mod) {
		vis.panelResumen.lblNombreLinea.setText(vis.panelLineas2.lblNombreLinea.getText());
		vis.panelResumen.lblNombrePardaInicio.setText(vis.panelLineas2.lblSal.getText());
		vis.panelResumen.lblNombreParadaFin.setText(vis.panelLineas2.modeloListaDestinos.getElementAt(vis.panelLineas2.listaDestinos.getSelectedIndex()));
		if (mod.isIdaYVuelta()) {
			vis.panelResumen.lblIdaYVuelta.setText("Ida y vuelta");
			vis.panelResumen.calendarioVuelta.setDate(vis.panelLineas2.calendarioVuelta.getDate());
		} else {
			vis.panelResumen.lblIdaYVuelta.setText("Ida");
			vis.panelResumen.calendarioVuelta.setVisible(false);
			vis.panelResumen.lblFechaVuelta.setVisible(false);
		}
		vis.panelResumen.calendarioIda.setDate(vis.panelLineas2.calendarioIda.getDate());
		mod.numeroBilletes = (Integer) vis.panelLineas2.spnNumeroDeBilletes.getValue();
		vis.panelResumen.lblNumeroDeBilletes.setText(String.valueOf(mod.numeroBilletes));
		vis.panelResumen.calendarioIda.setDate(vis.panelLineas2.calendarioIda.getDate());
		vis.panelResumen.calendarioVuelta.setDate(vis.panelLineas2.calendarioVuelta.getDate());
	}


	
	/**
	 * Inserta los clientes en el array
	 * @param vis
	 * @param cliente
	 * @param mod
	 */
	public void eleccionCliente(Ventana vis, Modelo mod, Cliente[] cliente) {	
		vis.panelConfirmacion.modeloPasajero.removeAllElements();
		if(cliente!=null) {
			for(int i=0; i>cliente.length;i++) {
				mod.arrayClientes.add(cliente[i]);
			}
		}		
		
	}
	
	/**
	 * Enseñar datos de cada cliente
	 * @param vis
	 * @param mod
	 * @param cliente
	 */
	public void confirmacionDatos(PanelConfirmacion panel1, PanelLineas2 panel2, PanelLineas1 panel3, Modelo mod) {		
		int posicion = panel1.getPasajeros();
		panel1.actualizarPosicion(posicion);
		panel1.actualizarNombre(mod, posicion);
		panel1.actualizarApellido(mod, posicion);
		panel1.actualizarDni(mod, posicion);	
		panel1.actualizarLinea(panel2);
		panel1.actualizarParadaInicio(panel3);
		panel1.actualizarParadaFin(panel2);
		panel1.actualizarFechaIda(panel2);
		panel1.actualizarFechaVuelta(panel2);
		panel1.actualizarTipoTrayecto(mod);
	}
	
	
	
	
}
