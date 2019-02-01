package clases;

import java.sql.Date;

public class Cliente {
	public String dni;
	public String nombre;
	public String apellido;
	public Date fechaNac;
	public char sexo;
	private char[] contrasenia;
	
	/*CONSTRUCTOR 1*/
	public Cliente(String dni, String nombre, String apellido, Date fechaNac, char sexo, char[] contrasenia) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.setContrasenia(contrasenia);
		this.dni = dni;
		this.sexo = sexo;
		this.fechaNac = fechaNac;
	}
	
	/*CONSTRUCTOR 2*/
	public Cliente() {	
	}
	
	/*CONSTRUCTOR 3*/
	public Cliente(String nombre, String apellido, String dni, char sexo) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.sexo = sexo;
	}
	
	public char[] getContrasenia() {
		return contrasenia;
	}
	
	public void setContrasenia(char[] contrasenia) {
		this.contrasenia = contrasenia;
	}
	
}
