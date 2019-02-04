package controlador;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import clases.Cliente;
import clases.Modelo;
import clases.Parada;
import interfaces.Ventana;

public class Metodos {

	/**
	 * Crea un objeto cliente
	 * 
	 * @param nombre
	 * @param apellido
	 * @param dni
	 * @param sexo
	 * @param contrasenia
	 * @return
	 */
	public Cliente ingresar(String nombre, String apellido, String dni, char sexo, char[] contrasenia) {

		Cliente cliente = new Cliente();
		cliente.setNombre(nombre);
		cliente.setApellido(apellido);
		cliente.setDni(dni);
		cliente.setSexo(sexo);
		cliente.setContrasenia(contrasenia);
		return cliente;

	}

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

	public static double distanciaLineas(Parada llegada, Parada salida) {
		double latitudX = (salida.getLatitud() - llegada.getLatitud()) * (salida.getLatitud() - llegada.getLatitud());
		double altitudX = (salida.getLongitud() - llegada.getLongitud()) * (salida.getLongitud() - llegada.getLongitud());
		double distancia = Math.sqrt(latitudX + altitudX);

		return distancia;
	}

	/**
	 * public char DevolverSexo(Ventana vis) { char charSexo = 'V'; if
	 * (vis.panelPasajeroExtra.textFieldSexo.getToolTipText()="Hombre") {
	 * charSexo='V';
	 * 
	 * } else { charSexo='M'; }
	 * 
	 * return charSexo;
	 * 
	 * }
	 **/

}
