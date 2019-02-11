package controlador;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;

import clases.Cliente;
import clases.Modelo;
import clases.Parada;
import interfaces.PanelPasajeroExtra;
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

	}	
	
	public double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();
	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}

	
	  public void pasajeroExtra(PanelPasajeroExtra panel, int CantidadPasajeros, Cliente [] cliente) {
		  CantidadPasajeros= CantidadPasajeros-1;
		  for (int i = 0; i < CantidadPasajeros; i++) {
			  cliente[i].setNombre(panel.textFieldNombre.getText());
			  cliente[i].setApellido(panel.textFieldApellido.getText());
			  cliente[i].setDni(panel.textFieldDNI.getText());
			  if(panel.textFieldSexo.getSelectedItem().toString()=="Hombre") {
				  cliente[i].setSexo('V');
			  } else {
				  cliente[i].setSexo('M');
			  }
		  }	  
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

	@Deprecated
	public static double distanciaLineas(Parada salida, Parada llegada) {
		double latitudX = (salida.getLatitud() - llegada.getLatitud()) * (salida.getLatitud() - llegada.getLatitud());
		double altitudX = (salida.getLongitud() - llegada.getLongitud()) * (salida.getLongitud() - llegada.getLongitud());
		double distancia = Math.sqrt(latitudX + altitudX);

		return distancia;
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
	 * Ensear datos de cada cliente
	 * @param vis
	 * @param mod
	 * @param cliente
	 */
	public void confirmacionDatos(Ventana vis, Modelo mod) {		
		int posicion = vis.panelConfirmacion.comboBoxPasajeros.getSelectedIndex();
		vis.panelConfirmacion.lblFieldCodigo.setText(String.valueOf(posicion));
		vis.panelConfirmacion.lblFieldNombre.setText(mod.arrayClientes.get(posicion).nombre);
		vis.panelConfirmacion.lblFieldApellidos.setText(mod.arrayClientes.get(posicion).apellido);
		vis.panelConfirmacion.lblFieldDNI.setText(mod.arrayClientes.get(posicion).dni);
		
		vis.panelConfirmacion.lblFieldLinea.setText(vis.panelLineas2.lblNombreLinea.getText());
		vis.panelConfirmacion.lblFieldParadaInicio.setText(String.valueOf(vis.panelLineas1.listParadas.getSelectedValuesList()));
		vis.panelConfirmacion.lblFieldParadaFin.setText(String.valueOf(vis.panelLineas2.listaDestinos.getSelectedValuesList()));		
		vis.panelConfirmacion.fechaIda.setDate(vis.panelLineas2.calendarioIda.getDate());
		vis.panelConfirmacion.fechaVuelta.setDate(vis.panelLineas2.calendarioVuelta.getDate());
		if(mod.isIdaYVuelta()==true) {
			vis.panelConfirmacion.lblFieldTipoTrayecto.setText("Ida y vuelta");
		}
		else
			vis.panelConfirmacion.lblFieldTipoTrayecto.setText("Ida");
		
	}
	
}
