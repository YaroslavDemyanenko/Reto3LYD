package controlador;


import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;

import clases.Cliente;
import clases.Modelo;
import clases.Parada;
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
		vis.panelLineas2.calendarioIda.setDate(new Date());
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
		c.add(Calendar.DATE, 1);
		fechaLimite = c.getTime();
		vis.panelLineas2.calendarioVuelta.setDate(fechaLimite);
		c.add(Calendar.DATE, numDias);
		fechaLimite = c.getTime();
		vis.panelLineas2.calendarioVuelta.setSelectableDateRange(vis.panelLineas2.calendarioVuelta.getDate(), fechaLimite);

	}		
	

	
	  public void pasajeroExtra(Ventana vis, int CantidadPasajeros) {
	  
		  Cliente pasajeroExtra[] = new Cliente[CantidadPasajeros];
		  
		  for (int i = 0; i < pasajeroExtra.length; i++) {
			  pasajeroExtra[i].setNombre(vis.panelPasajeroExtra.textFieldNombre.getText());
			  pasajeroExtra[i].setApellido(vis.panelPasajeroExtra.textFieldApellido.getText());
			  pasajeroExtra[i].setDni(vis.panelPasajeroExtra.textFieldDNI.getText());
			  if( vis.panelPasajeroExtra.textFieldSexo.getSelectedItem().toString()=="Hombre") {
				  pasajeroExtra[i].setSexo('V');
			  } else {
				  pasajeroExtra[i].setSexo('M');
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
	public void eleccionCliente(Ventana vis, Cliente cliente, Modelo mod, Cliente[] pasajeroExtra) {	
		vis.panelConfirmacion.modeloPasajero.removeAllElements();
		mod.arrayClientes.add(cliente);		
		if(pasajeroExtra!=null) {
			for(int i=0; i>pasajeroExtra.length;i++) {
				mod.arrayClientes.add(pasajeroExtra[i]);
			}
		}		
		
	}
	
	/**
	 * Enseñar datos de cada cliente
	 * @param vis
	 * @param mod
	 * @param cliente
	 */
	public void confirmacionDatos(Ventana vis, Modelo mod, Cliente cliente) {		
		int posicion = vis.panelConfirmacion.comboBoxPasajeros.getSelectedIndex();
		vis.panelConfirmacion.lblFieldCodigo.setText(String.valueOf(posicion));
		vis.panelConfirmacion.lblFieldNombre.setText(mod.arrayClientes.get(posicion).nombre);
		vis.panelConfirmacion.lblFieldApellidos.setText(mod.arrayClientes.get(posicion).apellido);
		vis.panelConfirmacion.lblFieldDNI.setText(mod.arrayClientes.get(posicion).dni);
		
		vis.panelConfirmacion.lblFieldLinea.setText(vis.panelLineas2.lblNombreLinea.getText());
		vis.panelConfirmacion.lblFieldParadaInicio.setText(String.valueOf(vis.panelLineas1.listParadas.getSelectedValues()));
		vis.panelConfirmacion.lblFieldParadaFin.setText(String.valueOf(vis.panelLineas2.listaDestinos.getSelectedValues()));		
		vis.panelConfirmacion.fechaIda.setDate(vis.panelLineas2.calendarioIda.getDate());
		vis.panelConfirmacion.fechaVuelta.setDate(vis.panelLineas2.calendarioVuelta.getDate());
		if(mod.isIdaYVuelta()==true) {
			vis.panelConfirmacion.lblFieldTipoTrayecto.setText("Ida y vuelta");
		}
		else
			vis.panelConfirmacion.lblFieldTipoTrayecto.setText("Ida");
		
	}
	
}
