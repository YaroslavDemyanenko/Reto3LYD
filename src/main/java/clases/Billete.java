package clases;

import java.util.Date;
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
	
	public Billete(float precioTrayecto, Date fecha, Linea linea, Parada paradaInic, Parada paradaFin) {
		this.precioTrayecto = precioTrayecto;
		this.fecha = fecha;
		this.linea = linea;
		this.paradaInic = paradaInic;
		this.paradaFin = paradaFin;
	}
	
	public Billete(Modelo mod) throws SQLException {
		ResultSet rs= mod.db.hacerPeticion("SELECT COUNT(*) FROM `billete`");
		this.codigoBillete=rs.getInt("COUNT(*)")+1;
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
		for(int i=0;i<mod.arrayParadas.size();i++) {
			if (mod.arrayParadas.get(i).nombreParada==vis.panelLineas2.modeloListaDestinos.getElementAt(vis.panelLineas2.listaDestinos.getSelectedIndex())) {
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
