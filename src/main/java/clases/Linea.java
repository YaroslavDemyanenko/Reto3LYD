package clases;

import java.util.ArrayList;

/**
 * Clase del objeto linea el cual contiene toda la informacion de cada linea
 * @author Yaros
 *
 */
public class Linea {
	public String codigo;
	public ArrayList <Autobus> listaAutobuses = new ArrayList<Autobus>();
	public ArrayList<Municipio> listaMunicipios = new ArrayList<Municipio>();
	
	/**
	 * Constructor con el codigo de linea
	 * @param codigo
	 */
	public Linea(String codigo) {
		this.setCodigo(codigo);
	}
	/**
	 * Constructor vacio
	 */
	public Linea() {
		
	}
	
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}
