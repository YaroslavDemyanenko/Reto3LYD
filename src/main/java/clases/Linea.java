package clases;

import java.util.ArrayList;

public class Linea {
	String codigo;
	ArrayList <Autobus> listaAutobuses = new ArrayList<Autobus>();
	ArrayList<Municipio> listaMunicipios = new ArrayList<Municipio>();
	
	public Linea(String codigo) {
		this.codigo=codigo;
	}
	public Linea() {}
	
}
