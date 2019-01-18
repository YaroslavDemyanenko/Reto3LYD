package clases;

import java.sql.Date;

public class Billete {
	int codigoBillete,codAutobusIda,codAutobusVuelta;
	float precioTrayecto;
	Date fechaIda, fechaVuelta;
	Linea linea;
	Parada paradaInic, paradaFin;
	
	
	public int getCodigoBillete() {
		return codigoBillete;
	}
	public void setCodigoBillete(int codigoBillete) {
		this.codigoBillete = codigoBillete;
	}
	public int getCodAutobusIda() {
		return codAutobusIda;
	}
	public void setCodAutobusIda(int codAutobusIda) {
		this.codAutobusIda = codAutobusIda;
	}
	public int getCodAutobusVuelta() {
		return codAutobusVuelta;
	}
	public void setCodAutobusVuelta(int codAutobusVuelta) {
		this.codAutobusVuelta = codAutobusVuelta;
	}
	public float getPrecioTrayecto() {
		return precioTrayecto;
	}
	public void setPrecioTrayecto(float precioTrayecto) {
		this.precioTrayecto = precioTrayecto;
	}
	public Date getFechaIda() {
		return fechaIda;
	}
	public void setFechaIda(Date fechaIda) {
		this.fechaIda = fechaIda;
	}
	public Date getFechaVuelta() {
		return fechaVuelta;
	}
	public void setFechaVuelta(Date fechaVuelta) {
		this.fechaVuelta = fechaVuelta;
	}
	public Linea getLinea() {
		return linea;
	}
	public void setLinea(Linea linea) {
		this.linea = linea;
	}
	public Parada getParadaInic() {
		return paradaInic;
	}
	public void setParadaInic(Parada paradaInic) {
		this.paradaInic = paradaInic;
	}
	public Parada getParadaFin() {
		return paradaFin;
	}
	public void setParadaFin(Parada paradaFin) {
		this.paradaFin = paradaFin;
	}

}
