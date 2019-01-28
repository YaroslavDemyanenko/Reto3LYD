package clases;

import java.util.ArrayList;

public class Parada {
	private int codigo;
	private String calle;
	private String nombreParada;
	private float latitud;
	private float longitud;

	public ArrayList<Parada> arrayParadasPorMunicipio(String nombreMunicipio) {
		
		
		return null;
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCalle() {
		return calle;
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

	public float getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

}
