package clases;

import java.util.Date;

/**
 * Objeto Cliente hecho para guardar la informacion de los clientes
 * @author Yaros
 *
 */
public class Cliente {
	public String dni;
	public String nombre;
	public String apellido;
	public Date fechaNac;
	public char sexo;
	private String contrasenia;
	
	/**
	 * Constructor Con toda la informacion de cliente
	 * @param dni
	 * @param nombre
	 * @param apellido
	 * @param fechaNac
	 * @param sexo
	 * @param contrasenia
	 */
	public Cliente(String dni, String nombre, String apellido, Date fechaNac, char sexo, String contrasenia) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
		this.sexo = sexo;
		this.contrasenia=contrasenia;

	}
	/**
	 * Contructor vacio
	 */
	public Cliente() {	
	}
	/**
	 * Contructor para los clientes extra solo con informacion basica
	 * @param nombre
	 * @param apellido
	 * @param dni
	 * @param sexo
	 */
	public Cliente(String nombre, String apellido, String dni, char sexo) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.sexo = sexo;
	}
	
	
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre=nombre;		
	}
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido=apellido;		
	}

	public String getContrasenia() {
		return contrasenia;
	}
	
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo=sexo;		
	}

	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	

}
