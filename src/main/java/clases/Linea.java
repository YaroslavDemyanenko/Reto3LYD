package clases;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

public class Linea {
	String codigo;
	ArrayList <Autobus> listaAutobuses = new ArrayList<Autobus>();
	ArrayList<Municipio> listaMunicipios = new ArrayList<Municipio>();
	
	public Linea(String codigo) {
		this.codigo=codigo;
	}
	public Linea() {}
	
}
