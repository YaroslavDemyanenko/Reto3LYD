package clases;

import java.util.ArrayList;

public class Municipio {
	String nombre;
	int codigoPostal;
	ArrayList<Parada> paradas= new ArrayList<Parada>();
	
	public Municipio() {
		
	}
	
	public Municipio(String nombre,int codigoPostal) {
		this.nombre=nombre;
		this.codigoPostal=codigoPostal;
	}
	
	public void crearMunicipios(ArrayList<Linea> lineas) {
		for (int i=0;i<lineas.size();i++) {
		lineas.get(i).listaMunicipios.add(new Municipio(nombre, i));
				}
	}
	
}
