package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Parada {
	private int codigo;
	private String calle;
	private String nombreParada;
	private double latitud;
	private double longitud;

	public ArrayList<Parada> arrayParadasPorMunicipio(String nombreMunicipio,Modelo mod) throws SQLException {
		ArrayList<Parada> arrayParadas=new ArrayList<Parada>();
		String consulta = "SELECT * FROM `parada` WHERE Cod_Parada IN (SELECT Cod_Parada FROM `poblacion_parada` where Cod_Postal in(SELECT Cod_Postal from poblacion WHERE Nombre=\""+nombreMunicipio+"\"))";
		ResultSet result = mod.db.hacerPeticion(consulta);
		while (result.next()) {
			arrayParadas.add(new Parada(result.getInt("Cod_Parada"),result.getString("Calle"),result.getString("Nombre"),result.getFloat("Latitud"),result.getFloat("Longitud")));
		}
		return arrayParadas;
		
	}

	public Parada() {
		
	}
	public Parada(int codigo,String calle, String nombreParada,float latit,float longi) {
		this.codigo=codigo;
		this.calle=calle;
		this.nombreParada=nombreParada;
		this.latitud=latit;
		this.longitud=longi;
	}
	
	public Parada(int codigo,String calle, String nombreParada) {
		this.codigo=codigo;
		this.calle=calle;
		this.nombreParada=nombreParada;
	}
	

	
	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getnombreParada() {
		return nombreParada;
	}

	public void setnombreParada(String nombreParada) {
		this.nombreParada = nombreParada;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

}
