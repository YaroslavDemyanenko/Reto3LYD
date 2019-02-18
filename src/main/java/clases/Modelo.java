package clases;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JPanel;

import conexion.ConexionAMySQL;
import controlador.Metodos;
import controlador.MetodosLoginYRegistro;
import controlador.MetodosPago;

/**
 * Clase modelo,Aqui se guardan todas las variables
 * @author Yaros
 *
 */
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
	public MetodosPago metodosPago;
	
	public ArrayList<Linea> lineas = new ArrayList<Linea>();
	public ArrayList<Parada> arrayParadas=new ArrayList<Parada>();
	public ArrayList<Cliente> arrayClientes = new  ArrayList<Cliente>();
	public Billete billeteGeneralIda = new Billete(),billeteGeneralVuelta=new Billete(),billeteIda,billeteVuelta;
	
	public final Cliente clienteExtra=new Cliente("11111111A","Cliente","Extra",new GregorianCalendar(2000, 1, 1).getTime(),'X',"");
	
	public Date fechaIda,fechaVuelta;
	private boolean idaYVuelta=false;
	public int numeroBilletes;
	public Cliente clienteRegistrado;
	public JPanel ultimoPanel;
	public Parada paradaSalida, paradaDestino;
	public Color colorCalendario;
	
	/**
	 * Constructor vacio de modelo
	 */
	public Modelo() {}
	
	/**
	 * Constructor de modelo el cual requiere una conexion a la base de datos
	 * @param db
	 */
	public Modelo(ConexionAMySQL db) {
		this.autobus=new Autobus();
		this.billete=new Billete();
		this.cliente=new Cliente();
		this.linea=new Linea();
		this.municipio=new Municipio();
		this.parada=new Parada();
		this.metodo=new Metodos();
		this.metodosLogin=new MetodosLoginYRegistro();
		this.metodosPago=new MetodosPago();
		this.db=db;
		db.inicializarLineas(this);
	}

	/**
	 * Indica si el trayecto elegido es de ida o ida yvuelta
	 * @return true si es ida y vuelta, false si es solo ida
	 */
	public boolean isIdaYVuelta() {
		return this.idaYVuelta;
	}
	/**
	 * Establece el tipo de trayecto mediante un booleano
	 * @param idaYVuelta true para indicar que es de ida y vuelta, false para indicar que es solo ida
	 */
	public void setIdaYVuelta(boolean idaYVuelta) {
		this.idaYVuelta = idaYVuelta;
	}
	
	/**
	 * Comprueba que el usuario esta logeado
	 * @return true si el usuario esta logeado, false si no lo esta
	 */
	public boolean estaLogeado() {
		if (clienteRegistrado==null) {
			return false;
		} else return true;
		
	}

	
	/**
	 * Restablece el modelo para la n vuelta del programa
	 */
	public void reset() {
		this.billeteIda=new Billete();
		this.billeteGeneralIda=new Billete();
		this.billeteGeneralVuelta=new Billete();
		this.billeteVuelta=new Billete();
		this.numeroBilletes=0;
		this.clienteRegistrado=null;
		this.ultimoPanel=new JPanel();
		this.paradaSalida=new Parada();
		this.paradaDestino=new Parada();
		this.idaYVuelta=false;
		
	}
}
