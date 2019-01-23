package clases;

import conexion.ConexionAMySQL;

public class Modelo {

	public Autobus autobus;
	public Billete billete;
	public Cliente cliente;
	public Linea linea;
	public Municipio municipio;
	public Parada parada;
	public ConexionAMySQL db;
	
	public Modelo(ConexionAMySQL db) {
		autobus=new Autobus();
		billete=new Billete();
		cliente=new Cliente();
		linea=new Linea();
		municipio=new Municipio();
		parada=new Parada();
		this.db=db;
	}
}
