package clases;

public class Parada {
	private int codigo;
	private String calle;
	private String nombParada;
	private double latitud;
	private double longitud;
	
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
	public String getNombParada() {
		return this.nombParada;
	}
	public void setNombParada(String nombCalle) {
		this.nombParada = nombCalle;
	}
	public double getLatitud() {
		return this.latitud;
	}
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	public double getLongitud() {
		return this.longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	
}
