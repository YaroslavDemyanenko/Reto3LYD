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
		double lati1=salida.latitud;
		double long1=salida.longitud;
		double lati2=llegada.latitud;
		double long2=llegada.longitud;
		final double radioTierra=6371;

		double rLati=lati2-lati1;
		double rLong=long2-long1;
		double a=Math.pow(Math.sin((rLati/2)),2) + Math.cos(lati1) * Math.cos(lati2) * Math.pow(Math.sin((rLong/2)),2);
		double c=2*Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		double distancia=radioTierra*c;
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
		double distancia = mod.billete.distanciaEnKmEntreDosParadas(salida, llegada);
		return ((precioGasolina * consumo * distancia)*1.20) / numPlazas;
	}
	
	public void informacionGeneralBilletes (Modelo mod,Ventana vis) throws SQLException{
		
		Linea linea;
		Parada paradaInic,paradaDest;
		Date fechaIda,fechaVuelta;
		Double precio;
		
		
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
		//
		//precio=precioTrayecto(mod, paradaInic, paradaDest, consumo, numPlazas);
		//
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
