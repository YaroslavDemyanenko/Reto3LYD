package clases;

import java.util.Date;

import interfaces.Ventana;

public class Billete {

	public int codigoBillete, codAutobus;
	public float precioTrayecto;
	public Date fecha;
	public Linea linea;
	public Parada paradaInic, paradaFin;

	/**
	 * Constructor vacio
	 */
	public Billete() {
	}

	/**
	 * Constructor con todos los parametros menos el codigo;
	 * 
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

	public Billete(Linea linea, Parada paradaInic, Parada paradaFin) {
		this.linea = linea;
		this.paradaInic = paradaInic;
		this.paradaFin = paradaFin;
	}

	

	

	public void informacionGeneralBilletes(Modelo mod, Ventana vis) {

		Linea linea = new Linea();
		Parada paradaInic = new Parada(), paradaDest = new Parada();
		

		for (int i = 0; i < mod.lineas.size(); i++) {
			if (mod.lineas.get(i).codigo.equals(vis.panelLineas2.lblNombreLinea.getText().substring(0, 2))) {
				linea = mod.lineas.get(i);
				break;
			}
		}
		String salida= vis.panelLineas2.lblSal.getText();
		String destino = vis.panelLineas2.listaDestinos.getSelectedValue().toString();
		for (int i = 0; i < mod.arrayParadas.size(); i++) {
			if (mod.arrayParadas.get(i).nombreParada.equals(destino)) {
				paradaDest = mod.arrayParadas.get(i);
				break;
			} else if (mod.arrayParadas.get(i).nombreParada.equals(salida)) {
				paradaInic = mod.arrayParadas.get(i);
			}
		}
		mod.billeteGeneralIda=new Billete(linea,paradaInic,paradaDest);
		
	}
	
	public void fechasGeneralBilletes(Modelo mod, Ventana vis) {
		Date fechaIda, fechaVuelta;
		fechaIda = vis.panelLineas2.calendarioIda.getDate();
		mod.billeteGeneralIda.fecha=fechaIda;
		if (mod.isIdaYVuelta()) {
			fechaVuelta = vis.panelLineas2.calendarioVuelta.getDate();
			mod.billeteGeneralVuelta = mod.billeteGeneralIda;
			mod.billeteGeneralVuelta.fecha = fechaVuelta;
		}
	}
	
	public Date getFecha() {
		return this. fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
