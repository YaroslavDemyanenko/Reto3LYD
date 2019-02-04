package clases;

import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JPanel;

import conexion.ConexionAMySQL;
import controlador.Metodos;
import controlador.MetodosLoginYRegistro;

public class Modelo {

	public Autobus autobus;
	public Billete billete;
	public Cliente cliente;
	public Linea linea;
	public Municipio municipio;
	public Parada parada;
	public ConexionAMySQL db;
	public Metodos metodo;
	public MetodosLoginYRegistro metodosLogin;
	
	public ArrayList<Linea> lineas = new ArrayList<Linea>();
	public ArrayList<Parada> arrayParadas=new ArrayList<Parada>();
	public Billete billeteGeneralIda,billeteGeneralVuelta,billeteIda,billeteVuelta;
	
	public Date fechaIda,fechaVuelta;
	private boolean idaYVuelta=false;
	public int numeroBilletes;
	public Cliente clienteRegistrado;
	public JPanel ultimoPanel;
	public Parada paradaSalida, paradaDestino;
	public Color colorCalendario;
	
	public Modelo(ConexionAMySQL db) {
		autobus=new Autobus();
		billete=new Billete();
		cliente=new Cliente();
		linea=new Linea();
		municipio=new Municipio();
		parada=new Parada();
		metodo=new Metodos();
		metodosLogin=new MetodosLoginYRegistro();
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
	
	public void reset() {
		billeteIda=null;
		billeteVuelta=null;
		numeroBilletes=0;
		clienteRegistrado=null;
		ultimoPanel=null;
		paradaSalida=null;
		paradaDestino=null;
		idaYVuelta=false;
	}
}
