package clases;

public class Cliente {
	private String dni;
	private String nombre;
	private String apellido;
	private String fecha_nac;
	private String sexo;
	private String contrasenia;
	

	                                          /*CONSTRUCTOR 1*/
	public Cliente(String dni, String nombre, String apellido, String fecha_nac, String sexo, String contrasenia) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.contrasenia = contrasenia;
		this.dni = dni;
		this.sexo = sexo;
		this.fecha_nac = fecha_nac;
	}
	                                          /*CONSTRUCTOR 2*/
	public Cliente() {
		
	}
	
	/*pasajeros Extra*/                       /*CONSTRUCTOR 3*/
	public Cliente(String nombre2, String apellido2, String dni2, String sexo2) {
		
		this.nombre = nombre2;
		this.apellido = apellido2;
		this.dni = dni2;
		this.sexo = sexo2;
	}
	

	public String getDni() {
		return this.dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return this.apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getFecha_nac() {
		return fecha_nac;
	}
	public void setFecha_nac(String fecha_nac) {
		this.fecha_nac = fecha_nac;
	}
	public String getSexo() {
		return this.sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getContrasenia() {
		return this.contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

}
