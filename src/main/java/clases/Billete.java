package clases;

import java.sql.Date;

public class Billete {
	int codigoBillete,codAutobusIda,codAutobusVuelta;
	float precioTrayecto;
	Date fechaIda, fechaVuelta;
	Linea linea;
	Parada paradaInic, paradaFin;
	
	
	public int getCodigoBillete() {
		return this.codigoBillete;
	}
	public void setCodigoBillete(int codigoBillete) {
		this.codigoBillete = codigoBillete;
	}
	public int getCodAutobusIda() {
		return this.codAutobusIda;
	}
	public void setCodAutobusIda(int codAutobusIda) {
		this.codAutobusIda = codAutobusIda;
	}
	public int getCodAutobusVuelta() {
		return this.codAutobusVuelta;
	}
	public void setCodAutobusVuelta(int codAutobusVuelta) {
		this.codAutobusVuelta = codAutobusVuelta;
	}
	public float getPrecioTrayecto() {
		return this.precioTrayecto;
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
		return this.fechaVuelta;
	}
	public void setFechaVuelta(Date fechaVuelta) {
		this.fechaVuelta = fechaVuelta;
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
