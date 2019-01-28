package clases;

public class Parada {
	private int codigo;
	private String calle;
	private String nombParada;
	private float latitud;
	private float longitud;
	
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
	public float getLatitud() {
		return this.latitud;
	}
	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}
	public float getLongitud() {
		return this.longitud;
	}
	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}
	
}
