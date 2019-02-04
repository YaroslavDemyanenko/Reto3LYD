package clases;

import java.util.ArrayList;

public class Linea {
	public String codigo;
	public ArrayList <Autobus> listaAutobuses = new ArrayList<Autobus>();
	public ArrayList<Municipio> listaMunicipios = new ArrayList<Municipio>();
	
	public Linea(String codigo) {
		this.setCodigo(codigo);
	}
	
	public Linea() {
		
	}
	
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}
