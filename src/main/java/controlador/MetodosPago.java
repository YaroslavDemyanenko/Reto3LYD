package controlador;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import clases.Modelo;
import clases.Parada;
import interfaces.PanelPago;


/**
 * Metodos relacionados con el pago del billete
 * @author Yaros
 *
 */
public class MetodosPago {

	private DecimalFormatSymbols simbolos = new DecimalFormatSymbols(Locale.getDefault());
	public DecimalFormat dosDec;

	/**
	 * Indica al decimal format como se quiere formatear los numeros
	 * @param dosDec 	DecimalFormat para modificar su pattern
	 */
	public void dosDecFormato() {
		simbolos.setDecimalSeparator('.');
		simbolos.setGroupingSeparator(','); 
		this.dosDec = new DecimalFormat("#.##",simbolos);
		this.dosDec.setMinimumFractionDigits(2);
		this.dosDec.setGroupingSize(300);
		this.dosDec.setMaximumFractionDigits(2);
	}
	
	/**
	 * Redondea un double a n numero de decimales
	 * @param value numero que se desea redondear
	 * @param numDec numero de decimales
	 * @return el numero redondeado
	 */
	public double redondear(double value, int numDec) {
	    if (numDec < 0) throw new IllegalArgumentException();
	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(numDec, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	/**
	 * Metodo para calcular la distancia en km entre dos puntos (formula utilizada:
	 * Haversine Formula)
	 * 
	 * @param salida  parada inicial
	 * @param llegada parada final
	 * @return distancia en km entre 2 coordenadas
	 */
	public double distanciaEnKmEntreDosParadas(Parada salida, Parada llegada) {
		double lati1 = Math.toRadians(salida.latitud);
		double lati2 = Math.toRadians(llegada.latitud);

		double dlat = Math.toRadians(llegada.latitud - salida.latitud);
		double dlong = Math.toRadians(llegada.longitud - salida.longitud);

		final double radioTierra = 6371;

		double a = Math.sin(dlat/2.0) * Math.sin(dlat/2.0)  + 
				Math.cos(lati1) * Math.cos(lati2) * 
				Math.sin(dlong/2.0) * Math.sin(dlong/2.0);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double distancia = radioTierra * c;
		return distancia;
	}
	
	/**
	 * Metodo para calcular el precio del trayecto entre 2 paradas
	 * 
	 * @param mod     modelo para utilizar funciones
	 * @param salida  parada salida
	 * @param llegada parada destino
	 * @param autobus autobus para saber el consumo
	 * @return
	 */
	public double precioTrayecto(Parada salida, Parada llegada, Double consumo) {
		final double precioGasolina = 0.80;
		double distancia = distanciaEnKmEntreDosParadas(salida, llegada);
		return ((precioGasolina * consumo * distancia) * 1.20);
	}

	/**
	 * Calcula el precio total del trayecto y lo pasa a string para meter en textfield
	 * @param mod
	 * @param numeroBilletes
	 * @return precio total del trayecto en string
	 */
	public String precioTotal(Modelo mod, int numeroBilletes) {
		double precioTotal = 0;

		String peticion = "SELECT Consumo_km FROM autobus WHERE Cod_bus=" + mod.billeteGeneralIda.codAutobus;
		ResultSet rs = mod.db.hacerPeticion(peticion);
		try {
			if (rs.next()) {
				precioTotal += precioTrayecto(mod.billeteGeneralIda.paradaInic, mod.billeteGeneralIda.paradaFin, rs.getDouble("Consumo_km"));
				mod.billeteGeneralIda.setPrecioTrayecto(precioTotal);
				mod.billeteGeneralVuelta.setPrecioTrayecto(precioTotal);
			}
			if (mod.isIdaYVuelta()) {
				peticion = "SELECT N_plazas,Consumo_km FROM autobus WHERE Cod_bus=" + mod.billeteGeneralVuelta.codAutobus;
				rs = mod.db.hacerPeticion(peticion);
				if (rs.next()) {
					precioTotal += precioTrayecto(mod.billeteGeneralIda.paradaInic, mod.billeteGeneralIda.paradaFin, rs.getDouble("Consumo_km"));
				}
			}
			precioTotal=precioTotal*numeroBilletes;
			dosDecFormato();
			return dosDec.format(redondear(precioTotal, 2));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Calculando el precio del billete", "Error", 0);
		}
		return null;

	}
	
	
	/**
	 * Calcula el cambio de la forma mas optima en lo referente al numero de monedas a devolver
	 * @param panel
	 */
	@SuppressWarnings("unchecked")
	public void Cambios(PanelPago panel) {
		int euros = (int)(Float.parseFloat(panel.textVueltas.getText()));
		int decimales = Math.round(((Float.parseFloat(panel.textVueltas.getText()))-euros) * 100);
		int[] billetesMonedas = { 500, 200, 100, 50, 20, 10, 5, 2, 1 };
		

		for (int i = 0, f = 0, fake = 1; i < billetesMonedas.length + fake; i++, f++) {
			// Mira si tiene que pasar a calcular los decimales
			if (f == 9) {
				i = 3;
				fake = 0;
			}
			// Calcula los euros
			if (euros >= billetesMonedas[i] && f < 9) {
				panel.modeloCambio.addElement(billetesMonedas[i] + " €: " + (euros / billetesMonedas[i]));
				euros = euros % billetesMonedas[i];
			}
			// Calcula los centimos si ha acabado con los euros
			else if (decimales >= billetesMonedas[i] && f >= 9) {
				panel.modeloCambio.addElement((dosDec.format(billetesMonedas[i] / 100f)) + " €: " + (decimales / billetesMonedas[i]));
				decimales = decimales % billetesMonedas[i];
			}
		}
	}

	
	/**
	 * Metodo para sumar dinero con un boton
	 * @param panel donde se encuentra los textfielda editar y los botones
	 * @param btn boton del cual se mira el texto y pasa a string para sumar esa cantidad
	 */
	public void sumarDinero(PanelPago panel,JButton btn) {
		float dineroPagadoGuardado= Float.parseFloat(panel.textDineroMetido.getText());
		float dineroAPagarGuardado= Float.parseFloat(panel.textAPagar.getText());
		float valorBoton = Float.valueOf(btn.getText());
		dineroPagadoGuardado = dineroPagadoGuardado + valorBoton;
		dineroAPagarGuardado = dineroAPagarGuardado - valorBoton;
		if (dineroAPagarGuardado <= 0 && btn.isEnabled() == true) {
			float dineroCambio=Math.abs(dineroAPagarGuardado);
			panel.textVueltas.setText(String.valueOf(dosDec.format(dineroCambio)));
			panel.btnConfirmar.setEnabled(true);
			panel.ActDesBotones(false);
			panel.textAPagar.setText("0.00");
			panel.textDineroMetido.setText(String.valueOf(dosDec.format(dineroPagadoGuardado)));
			Cambios(panel);
		} else if (btn.isEnabled() == true) {
			panel.textAPagar.setText(String.valueOf(dosDec.format(dineroAPagarGuardado)));
			panel.textDineroMetido.setText(String.valueOf(dosDec.format(dineroPagadoGuardado)));
		}
	}
	/**
	 * Metodo para restar dinero con un boton
	 * @param panel donde se encuentra los textfielda editar y los botones
	 * @param btn boton del cual se mira el texto y pasa a string para restar esa cantidad
	 */
	public void restarDinero(PanelPago panel,JButton btn) {
		float dineroPagadoGuardado= Float.parseFloat(panel.textDineroMetido.getText());
		float dineroAPagarGuardado= Float.parseFloat(panel.textAPagar.getText());
		float valorBoton = Float.valueOf(btn.getText());
		if ((dineroPagadoGuardado - valorBoton) >= 0) {
			dineroPagadoGuardado = dineroPagadoGuardado - valorBoton;
			dineroAPagarGuardado = dineroAPagarGuardado + valorBoton;
		}
		panel.textAPagar.setText(String.valueOf(dosDec.format(dineroAPagarGuardado)));
		panel.textDineroMetido.setText(String.valueOf(dosDec.format(dineroPagadoGuardado)));
		
	}

	
}
