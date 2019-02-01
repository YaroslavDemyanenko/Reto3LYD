package clases;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;

public class Cliente {
	public String dni;
	public String nombre;
	public String apellido;
	public Date fechaNac;
	public char sexo;
	private char[] contrasenia;
	
	public Cliente(String dni, String nombre, String apellido, Date fechaNac, char sexo, char[] contrasenia) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.setContrasenia(contrasenia);
		this.dni = dni;
		this.sexo = sexo;
		this.fechaNac = fechaNac;
	}
	
	public Cliente() {	
	}
	
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
	
	public String encriptarContra() throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		String contraEnc = new String(this.contrasenia);
		byte[] hashInBytes = md.digest(contraEnc.getBytes(StandardCharsets.UTF_8));
		StringBuilder sb = new StringBuilder();
		for (byte b : hashInBytes) {
			sb.append(String.format("%02x", b));
		}
		return sb.toString();
	}
	
}
