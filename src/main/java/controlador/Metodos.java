package controlador;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;

import clases.Billete;
import clases.Cliente;
import clases.Modelo;
import interfaces.PanelConfirmacion;
import interfaces.PanelLineas1;
import interfaces.PanelLineas2;
import interfaces.Ventana;

/**
 * Metodos de uso no especifico
 * 
 * @author Yaros
 *
 */
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

	/**
	 * Metodo para mostrar el resumen del trayecto en la interfaz
	 * 
	 * @param vis
	 * @param mod
	 */
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
	 * Inserta los clientes en el combobox
	 * 
	 * @param vis
	 * @param cliente
	 * @param mod
	 */
	public void meterClientesEnComboBox(Ventana vis, Modelo mod, ArrayList<Cliente> cliente) {
		vis.panelConfirmacion.modeloPasajero.removeAllElements();
		for (int i = 0; i < cliente.size(); i++) {
			vis.panelConfirmacion.modeloPasajero.addElement(cliente.get(i).nombre);
		}
	}

	/**
	 * Enseñar datos de cada cliente
	 * 
	 * @param vis
	 * @param mod
	 * @param cliente
	 */
	public void confirmacionDatos(PanelConfirmacion panelConf, PanelLineas2 panelLin2, Modelo mod) {
		int posicion = panelConf.getPasajeros();
		panelConf.actualizarPosicion(posicion);
		panelConf.actualizarNombre(mod, posicion);
		panelConf.actualizarApellido(mod, posicion);
		panelConf.actualizarDni(mod, posicion);
		panelConf.actualizarLinea(panelLin2);

	}

	/**
	 * Enseña los datos generales de trayecto, como la fecha y paradas
	 * 
	 * @param panelConf
	 * @param panelLin2
	 * @param panelLin1
	 * @param mod
	 */
	public void confirmacionTrayecto(PanelConfirmacion panelConf, PanelLineas2 panelLin2, PanelLineas1 panelLin1, Modelo mod) {
		panelConf.actualizarParadaInicio(panelLin1);
		panelConf.actualizarParadaFin(panelLin2);
		panelConf.actualizarFechaIda(panelLin2);
		if (mod.isIdaYVuelta()) {
			panelConf.actualizarFechaVuelta(panelLin2);
		}else {
			panelConf.lblFechaVuelta.setVisible(false);
			panelConf.fechaVuelta.setVisible(false);
		}
		panelConf.actualizarTipoTrayecto(mod);
	}

	/**
	 * Crea e imprime los billetes
	 * 
	 * @param mod
	 * @param bill
	 * @param usuario
	 * @param codBill
	 * @param Vuelta
	 */
	public void imprimirBillete(Modelo mod, Billete bill, Cliente usuario, int codBill, boolean Vuelta) {
		PrintWriter writer;
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
		try {
			writer = new PrintWriter("Billete Nº " + codBill + ".txt", "UTF-8");
			writer.println("INFORMACIÓN DEL RECORRIDO");
			writer.println("Codigo de billete: " + codBill + " Linea: " + bill.linea.codigo + " Codigo de autobus: " + bill.codAutobus);
			if (Vuelta) {
				writer.println("Origen: " + bill.paradaFin.nombreParada + " Destino: " + bill.paradaInic.nombreParada);
			} else
				writer.println("Origen: " + bill.paradaInic.nombreParada + " Destino: " + bill.paradaFin.nombreParada);
			writer.println("Fecha: " + formatoFecha.format(bill.fecha) + " Precio: " + mod.metodosPago.dosDec.format(bill.precioTrayecto));
			writer.println("INFORMACION DEL CLIENTE");
			writer.println("Nombre: " + usuario.nombre + " " + usuario.apellido);
			writer.println("DNI: " + usuario.dni + " Sexo: " + usuario.sexo);
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
