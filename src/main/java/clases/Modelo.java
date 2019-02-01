package clases;

import java.sql.SQLException;
import java.util.ArrayList;

import conexion.ConexionAMySQL;
import controlador.Metodos;

public class Modelo {

	public Autobus autobus;
	public Billete billete;
	public Cliente cliente;
	public Linea linea;
	public Municipio municipio;
	public Parada parada;
	public ConexionAMySQL db;
	public Metodos metodo;
	
	public ArrayList<Linea> lineas = new ArrayList<Linea>();
	public ArrayList<Parada> arrayParadas=new ArrayList<Parada>();
	public Billete billeteIda,billeteVuelta;
	
	private boolean idaYVuelta=false;
	public int numeroBilletes;
	public Cliente clienteRegistrado;
	
	public Modelo(ConexionAMySQL db) {
		autobus=new Autobus();
		billete=new Billete();
		cliente=new Cliente();
		linea=new Linea();
		municipio=new Municipio();
		parada=new Parada();
		metodo=new Metodos();
		this.db=db;
		try {
			db.inicializarLineas(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean isIdaYVuelta() {
		return this.idaYVuelta;
	}

	public void setIdaYVuelta(boolean idaYVuelta) {
		this.idaYVuelta = idaYVuelta;
	}
}
