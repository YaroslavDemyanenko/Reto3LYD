package controlador;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;



public class MetodosPago {

	NumberFormat nf = NumberFormat.getNumberInstance(Locale.UK);
	private DecimalFormat dosDec = (DecimalFormat) nf;

	/**
	 * Indica al decimal format como se quiere formatear los numeros
	 * @param dosDec 	DecimalFormat para modificar su pattern
	 */
	public void dosDecFormato(DecimalFormat dosDec) {
		dosDec.setMinimumFractionDigits(2);
		dosDec.setGroupingSize(300);
	}
	
	@SuppressWarnings("unchecked")
	public void Cambios(DefaultListModel model, float dinero) {
		int euros = (int) dinero;
		int decimales = Math.round((dinero - euros) * 100);
		int[] billetesMonedas = { 500, 200, 100, 50, 20, 10, 5, 2, 1 };
		

		for (int i = 0, f = 0, fake = 1; i < billetesMonedas.length + fake; i++, f++) {
			// Mira si tiene que pasar a calcular los decimales
			if (f == 9) {
				i = 3;
				fake = 0;
			}
			// Calcula los euros
			if (euros >= billetesMonedas[i] && f < 9) {
				model.addElement(billetesMonedas[i] + " €: " + (euros / billetesMonedas[i]));
				euros = euros % billetesMonedas[i];
			}
			// Calcula los centimos si ha acabado con los euros
			else if (decimales >= billetesMonedas[i] && f >= 9) {
				model.addElement((dosDec.format(billetesMonedas[i] / 100f)) + " €: " + (decimales / billetesMonedas[i]));
				decimales = decimales % billetesMonedas[i];
			}
		}
	}

	
	
	public void sumarDinero(JButton btn, JTextField dnrPagado, JTextField dnrAPagar, JButton btnSig) {
		float dineroPagadoGuardado= Float.parseFloat(dnrPagado.getText());
		float dineroAPagarGuardado= Float.parseFloat(dnrAPagar.getText());
		float valorBoton = Float.valueOf(btn.getText());
		dineroPagadoGuardado = dineroPagadoGuardado + valorBoton;
		dineroAPagarGuardado = dineroAPagarGuardado - valorBoton;
		dosDecFormato(dosDec);
		if (dineroAPagarGuardado <= 0 && btn.isEnabled() == true) {
			dineroAPagarGuardado = Math.abs(dineroAPagarGuardado);
			btnSig.setEnabled(true);
			dnrAPagar.setText(String.valueOf(dosDec.format(dineroAPagarGuardado)));
			dnrPagado.setText(String.valueOf(dosDec.format(dineroPagadoGuardado)));
		} else if (btn.isEnabled() == true) {
			dnrAPagar.setText(String.valueOf(dineroAPagarGuardado));
			dnrPagado.setText(String.valueOf(dineroPagadoGuardado));
		}
	}
	
	public void restarDinero(JButton btn, JTextField dnrPagado, JTextField dnrAPagar, JButton btnSig) {
		float dineroPagadoGuardado= Float.parseFloat(dnrPagado.getText());
		float dineroAPagarGuardado= Float.parseFloat(dnrAPagar.getText());
		float valorBoton = Float.valueOf(btn.getText());
		if ((dineroPagadoGuardado - valorBoton) >= 0) {
			dineroPagadoGuardado = dineroPagadoGuardado - valorBoton;
			dineroAPagarGuardado = dineroAPagarGuardado + valorBoton;
		}
		dosDecFormato(dosDec);
		dnrAPagar.setText(String.valueOf(dosDec.format(dineroAPagarGuardado)));
		dnrPagado.setText(String.valueOf(dosDec.format(dineroPagadoGuardado)));
		if (dineroAPagarGuardado > 0) {
			btnSig.setEnabled(false);
		}
	}

	/**
	 * Activa o desactiva el array de botones que se le pasa por parametro
	 * 
	 * @param array  El array de botones que se activa/desactiva
	 * @param estado El estado que se quiere tener para el array de botones (true =
	 *               activado y false = desactivado)
	 */
	public void ActDesBotones(JButton[] array, boolean estado) {
		for (int i = 0; i < array.length; i++) {
			array[i].setEnabled(estado);
		}
	}
}
