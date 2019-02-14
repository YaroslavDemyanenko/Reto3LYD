package controlador;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;

import interfaces.PanelPago;



public class MetodosPago {

	private NumberFormat nf = NumberFormat.getNumberInstance(Locale.UK);
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

	
	
	public void sumarDinero(PanelPago panel,JButton btn) {
		float dineroPagadoGuardado= Float.parseFloat(panel.textDineroMetido.getText());
		float dineroAPagarGuardado= Float.parseFloat(panel.textAPagar.getText());
		float valorBoton = Float.valueOf(btn.getText());
		dineroPagadoGuardado = dineroPagadoGuardado + valorBoton;
		dineroAPagarGuardado = dineroAPagarGuardado - valorBoton;
		dosDecFormato(dosDec);
		if (dineroAPagarGuardado <= 0 && btn.isEnabled() == true) {
			float dineroCambio=Math.abs(dineroAPagarGuardado);
			panel.textVueltas.setText(String.valueOf(dosDec.format(dineroCambio)));
			panel.btnConfirmar.setEnabled(true);
			panel.ActDesBotones(false);
			panel.textAPagar.setText("0.00");
			panel.textDineroMetido.setText(String.valueOf(dosDec.format(dineroPagadoGuardado)));
		} else if (btn.isEnabled() == true) {
			panel.textAPagar.setText(String.valueOf(dineroAPagarGuardado));
			panel.textDineroMetido.setText(String.valueOf(dineroPagadoGuardado));
		}
	}
	
	public void restarDinero(PanelPago panel,JButton btn) {
		float dineroPagadoGuardado= Float.parseFloat(panel.textDineroMetido.getText());
		float dineroAPagarGuardado= Float.parseFloat(panel.textAPagar.getText());
		float valorBoton = Float.valueOf(btn.getText());
		if ((dineroPagadoGuardado - valorBoton) >= 0) {
			dineroPagadoGuardado = dineroPagadoGuardado - valorBoton;
			dineroAPagarGuardado = dineroAPagarGuardado + valorBoton;
		}
		dosDecFormato(dosDec);
		panel.textAPagar.setText(String.valueOf(dosDec.format(dineroAPagarGuardado)));
		panel.textDineroMetido.setText(String.valueOf(dosDec.format(dineroPagadoGuardado)));
		
	}

	
}
