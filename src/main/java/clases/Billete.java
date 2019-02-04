package clases;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import interfaces.Ventana;

public class Billete {
	int codigoBillete,codAutobus;
	float precioTrayecto;
	Date fecha;
	Linea linea;
	Parada paradaInic, paradaFin;
	
	public Billete() {
		
	}
	public Billete(Modelo mod) throws SQLException {
		ResultSet rs= mod.db.hacerPeticion("SELECT COUNT(*) FROM `billete`");
		this.codigoBillete=rs.getInt("COUNT(*)")+1;
	}
	
	public void crearBilletes (Modelo mod,Ventana vis) throws SQLException{
		mod.billeteIda=new Billete(mod);
		mod.billeteVuelta=new Billete(mod);
		for(int i=0;i<mod.arrayParadas.size();i++) {
			if (mod.arrayParadas.get(i).nombreParada==vis.panelLineas2.lblSal.getText()) {
				mod.billeteIda.paradaInic=mod.arrayParadas.get(i);
			}
			if (mod.arrayParadas.get(i).nombreParada==vis.panelLineas2.modeloListaDestinos.getElementAt(vis.panelLineas2.listaDestinos.getSelectedIndex())) {
				mod.billeteIda.paradaFin=mod.arrayParadas.get(i);
			}
		}
		mod.billeteIda.fecha=(Date) vis.panelLineas2.calendarioIda.getDate();
		//if(vis.panelLineas2.calendarioVuelta.isVisible()) {
			//billete.fecha=(Date) vis.panelLineas2.calendarioVuelta.getDate();
		//}
		
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
