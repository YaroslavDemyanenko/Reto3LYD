package clases;

import java.util.Date;

import javax.swing.JSpinner;

import java.sql.SQLException;

import interfaces.Ventana;

public class Billete {
	
	int codigoBillete,codAutobus;
	float precioTrayecto;
	Date fecha;
	Linea linea;
	Parada paradaInic, paradaFin;
	
	/**
	 * Constructor vacio
	 */
	public Billete() {}
	
	/**
	 * Constructor con todos los parametros menos el codigo;
	 * @param precioTrayecto
	 * @param fecha
	 * @param linea
	 * @param paradaInic
	 * @param paradaFin
	 */
	public Billete(float precioTrayecto, Date fecha, Linea linea, Parada paradaInic, Parada paradaFin) {
		this.precioTrayecto = precioTrayecto;
		this.fecha = fecha;
		this.linea = linea;
		this.paradaInic = paradaInic;
		this.paradaFin = paradaFin;
	}

	/**
	 * Metodo para calcular la distancia en km entre dos puntos (formula utilizada: Haversine Formula)
	 * @param salida parada inicial
	 * @param llegada parada final
	 * @return distancia en km entre 2 coordenadas
	 */
	public double distanciaEnKmEntreDosParadas(Parada salida, Parada llegada) {
		double lati1=Math.toRadians(salida.latitud);
		double lati2=Math.toRadians(llegada.latitud);
		
		double lati2menoslati1=Math.toRadians(llegada.latitud-salida.latitud);
		double long2menoslong1=Math.toRadians(llegada.longitud-salida.longitud);
		
		final double radioTierra=6371000;

		double a=Math.sin(lati2menoslati1/2) * Math.sin(lati2menoslati1)/2 +
				Math.cos(lati1) * Math.cos(lati2) * Math.sin(long2menoslong1/2) * Math.sin(long2menoslong1/2);
		double c=2*Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		double distancia=radioTierra*c;
		System.out.println(distancia);
		return distancia;
	
	}
	
	/**
	 * Metodo para calcular el precio del trayecto entre 2 paradas
	 * @param mod modelo para utilizar funciones
	 * @param salida parada salida
	 * @param llegada parada destino
	 * @param autobus autobus para saber el consumo
	 * @return
	 */
	public double precioTrayecto(Modelo mod, Parada salida, Parada llegada, Double consumo,int numPlazas){
		final double precioGasolina = 0.80;
		double distancia = distanciaEnKmEntreDosParadas(salida, llegada);
		return ((precioGasolina * consumo * distancia)*1.20) / numPlazas;
	}
	
	public void informacionGeneralBilletes (Modelo mod,Ventana vis){
		
		Linea linea;
		Parada paradaInic,paradaDest;
		Date fechaIda,fechaVuelta;
		
		
		for(int i=0;i<mod.lineas.size();) {
			if (mod.lineas.get(i).codigo.equals(vis.panelLineas2.lblNombreLinea.getText().substring(0, 2))) {
				linea=mod.lineas.get(i);
				break;
			}
		}
		String destino=vis.panelLineas2.modeloListaDestinos.getElementAt(vis.panelLineas2.listaDestinos.getSelectedIndex());
		for(int i=0;i<mod.arrayParadas.size();i++) {
			if (mod.arrayParadas.get(i).nombreParada==destino) {
				paradaDest=mod.arrayParadas.get(i);
				break;
			}
			else if (mod.arrayParadas.get(i).nombreParada==vis.panelLineas2.lblSal.getText()) {
				paradaInic=mod.arrayParadas.get(i);
			}
		}
		fechaIda=vis.panelLineas2.calendarioIda.getDate();
		mod.billeteGeneralIda=new Billete();
		if(mod.isIdaYVuelta()) {
			fechaVuelta=vis.panelLineas2.calendarioVuelta.getDate();
			mod.billeteGeneralVuelta=mod.billeteGeneralIda;
			mod.billeteGeneralVuelta.fecha=fechaVuelta;
		}
	}
	
	public void limitarCompraBilletes(JSpinner spnBilletes) {
		
	}
	
	public int getCodigoBillete() {
		return this.codigoBillete;
	}
	public void setCodigoBillete(int codigoBillete) {
		this.codigoBillete = codigoBillete;
	}
	public int getCodAutobusIda() {
		return this.codAutobus;
	}
	public void setCodAutobusIda(int codAutobusIda) {
		this.codAutobus = codAutobusIda;
	}
	
	public float getPrecioTrayecto() {
		return this.precioTrayecto;
	}
	public void setPrecioTrayecto(float precioTrayecto) {
		this.precioTrayecto = precioTrayecto;
	}
	public Date getFechaIda() {
		return fecha;
	}
	public void setFechaIda(Date fechaIda) {
		this.fecha = fechaIda;
	}
	public Linea getLinea() {
		return this.linea;
	}
	public void setLinea(Linea linea) {
		this.linea = linea;
	}
	public Parada getParadaInic() {
		return this.paradaInic;
	}
	public void setParadaInic(Parada paradaInic) {
		this.paradaInic = paradaInic;
	}
	public Parada getParadaFin() {
		return this.paradaFin;
	}
	public void setParadaFin(Parada paradaFin) {
		this.paradaFin = paradaFin;
	}

}
