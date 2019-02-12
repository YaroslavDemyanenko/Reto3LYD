package controlador;


import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;

import clases.Cliente;
import clases.Modelo;
import clases.Parada;
import interfaces.PanelPasajeroExtra;
import interfaces.Ventana;
import interfaces.PanelConfirmacion;
import interfaces.PanelLineas2;
import interfaces.PanelLineas1;

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
		c.add(Calendar.DATE, 1);
		fechaLimite = c.getTime();
		vis.panelLineas2.calendarioVuelta.setDate(fechaLimite);
		c.add(Calendar.DATE, numDias);
		fechaLimite = c.getTime();
		vis.panelLineas2.calendarioVuelta.setSelectableDateRange(vis.panelLineas2.calendarioVuelta.getDate(), fechaLimite);

	}		
	

	
	  public void pasajeroExtra(PanelPasajeroExtra panel, Cliente [] cliente) {		  
		  for (int i = 0; i < cliente.length; i++) {
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
	 * Enseñar datos de cada cliente
	 * @param vis
	 * @param mod
	 * @param cliente
	 */
	public void confirmacionDatos(PanelConfirmacion panel1,PanelLineas2 panel2, PanelLineas1 panel3, Modelo mod) {		
		int posicion = panel1.comboBoxPasajeros.getSelectedIndex();
		panel1.lblFieldCodigo.setText(String.valueOf(posicion));
		panel1.lblFieldNombre.setText(mod.arrayClientes.get(posicion).nombre);
		panel1.lblFieldApellidos.setText(mod.arrayClientes.get(posicion).apellido);
		panel1.lblFieldDNI.setText(mod.arrayClientes.get(posicion).dni);
		
		panel1.lblFieldLinea.setText(panel2.lblNombreLinea.getText());
		panel1.lblFieldParadaInicio.setText(String.valueOf(panel3.listParadas.getSelectedValues()));
		panel1.lblFieldParadaFin.setText(String.valueOf(panel2.listaDestinos.getSelectedValues()));		
		panel1.fechaIda.setDate(panel2.calendarioIda.getDate());
		panel1.fechaVuelta.setDate(panel2.calendarioVuelta.getDate());
		if(mod.isIdaYVuelta()==true) {
			panel1.lblFieldTipoTrayecto.setText("Ida y vuelta");
		}
		else
			panel1.lblFieldTipoTrayecto.setText("Ida");
		
	}
	
}
