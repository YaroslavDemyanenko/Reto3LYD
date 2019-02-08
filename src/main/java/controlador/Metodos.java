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
		vis.panelLineas2.calendarioVuelta.setDate(fechaLimite);
		Calendar c = Calendar.getInstance();
		c.setTime(fechaLimite);
		c.add(Calendar.DATE, numDias);
		fechaLimite = c.getTime();
		vis.panelLineas2.calendarioVuelta.setSelectableDateRange(vis.panelLineas2.calendarioIda.getDate(), fechaLimite);

	}		
	

	/**
	 * public void PasajeroExtra(Ventana vis, int CantidadPasajeros) {
	 * 
	 * Cliente pasajeroExtra[] = new Cliente[CantidadPasajeros];
	 * 
	 * // Genera clientes extra en base a la cantidad de pasajeros extra while
	 * (CantidadPasajeros > 0) { pasajeroExtra[CantidadPasajeros] = new
	 * Cliente(vis.panelPasajeroExtra.textFieldNombre.getText(),
	 * //vis.panelPasajeroExtra.textFieldApellido.getText(),
	 * vis.panelPasajeroExtra.textFieldDNI.getText(),
	 * //vis.panelPasajeroExtra.textFieldSexo.getToolTipText()); //CantidadPasajeros
	 * = CantidadPasajeros - 1; } }
	 **/

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
	 * Determinamos el cliente
	 * @param vis
	 * @param cliente
	 * @param mod
	 */
	public void eleccionCliente(Ventana vis, Cliente cliente, Modelo mod) {	
		for (int i = 0;i<mod.arrayClientes.size();i++)
		{
			mod.arrayClientes.add(cliente);
			vis.panelConfirmacion.modeloPasajero.addElement(mod.arrayClientes.get(i).nombre);
			vis.panelConfirmacion.modeloPasajero.addElement(mod.arrayClientes.get(i).apellido);
			vis.panelConfirmacion.modeloPasajero.addElement(mod.arrayClientes.get(i).dni);
		}
	}
	
	/**
	 * Enseñar datos de cada cliente
	 * @param vis
	 * @param mod
	 * @param cliente
	 */
	public void confirmacionDatos(Ventana vis, Modelo mod, Cliente cliente) {
		vis.panelConfirmacion.modeloPasajero.removeAllElements();
		for (int i = 0;i<mod.arrayClientes.size();i++)
		{
			vis.panelConfirmacion.lblFieldCodigo.setText(String.valueOf(i));
			vis.panelConfirmacion.lblFieldNombre.setText(mod.arrayClientes.get(i).nombre);
			vis.panelConfirmacion.lblFieldApellidos.setText(mod.arrayClientes.get(i).apellido);
			vis.panelConfirmacion.lblFieldDNI.setText(mod.arrayClientes.get(i).dni);			
		}
		
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
