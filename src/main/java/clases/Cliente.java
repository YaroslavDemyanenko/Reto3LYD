package clases;

public class Cliente {
	private String dni;
	private String nombre;
	private String apellido;
	private String fecha_nac;
	private String sexo;
	private String contrasenia;
	

	
	public Cliente(String string, String string2, String string3, String string4, String string5) {
		// TODO Auto-generated constructor stub
	}
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	
	/*pasajeros Extra*/
	public Cliente(String nombre2, String apellido2, String dni2, String sexo2) {
		// TODO Auto-generated constructor stub
	}
	

	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
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
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

}
