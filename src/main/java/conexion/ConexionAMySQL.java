package conexion;

import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import clases.Cliente;
import clases.Linea;
import clases.Modelo;
import clases.Parada;
import interfaces.Ventana;

public class ConexionAMySQL {
	private Connection conexion;

	/**
	 * Conecta la aplicacion con las base de datos
	 * 
	 * @param baseDatos
	 * @param user
	 * @param pass
	 */
	public ConexionAMySQL(String ip, String puerto, String baseDatos, String user, String pass) {
		try {
			this.conexion = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + puerto + "/" + baseDatos + "?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC", user, pass);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
		}
	}

	/**
	 * Metodo para hacer peticiones a la base de datos
	 * 
	 * @param peticionString String que se usara en la query en sql
	 * @return devuelve un set de resultados
	 */
	public ResultSet hacerPeticion(String peticionString) {
		try {
			Statement peticion = this.conexion.createStatement();
			ResultSet resultadoPeticion = peticion.executeQuery(peticionString);
			return resultadoPeticion;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
		}return null;
	}
	
	public void insertarUsuarioEnBaseDeDatos(Cliente usuario) {
		try {
			String query = "insert into cliente (DNI,Nombre,Apellidos,Fecha_nac,Sexo,Constraseña) values(?,?,?,?,?,?);";
			PreparedStatement insertartUsuario=this.conexion.prepareStatement(query);
	            insertartUsuario.setString(1, usuario.dni);
	            insertartUsuario.setString(2, usuario.nombre);
	            insertartUsuario.setString(3, usuario.apellido);
	            insertartUsuario.setDate(4, usuario.fechaNac);
	            insertartUsuario.setString(5, String.valueOf(usuario.sexo));
	            try {
					insertartUsuario.setString(6, usuario.encriptarContra());
				} catch (NoSuchAlgorithmException e) {
					System.out.println(e);
				}
	            insertartUsuario.executeQuery();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
		}
	}
	
	public boolean comprobarDNIenBD(Cliente cliente) throws SQLException {
		String sql = "select DNI from cliente where DNI = " + cliente.dni+"";
		ResultSet rs = hacerPeticion(sql);
		if (rs.next()) {
			return true;
		}else return false;
	}

	public void Login(Modelo mod, Ventana vis, String dni, String contrasenia, int CantidadPasajeros )throws SQLException {

		Boolean login = false;		
		String sql = "select DNI,Contrase�a from cliente";
		ResultSet rs = mod.db.hacerPeticion(sql);
			
			//ResultSet rs;

			// llamamos a la base de datos el DNI y la contrase�a del cliente 
			//LoginDB = "select DNI,Contrase�a from cliente";

			//rs = mod.db.hacerPeticion(LoginDB);

			//Comparamos los datos de la base de datos con los que ha introducido en el login el cliente
		if (rs.getString("DNI") == dni){
			//Este es el caso optimo donde tanto el DNI y la contrase�a existen y corresponden al mismo usuario
			if(rs.getString("Contrase�a")== contrasenia) {
				login = true;
				vis.panelLogin.setVisible(false);
					if(CantidadPasajeros==0) {
						vis.panelPago.setVisible(true);
					}						else {
						vis.panelPasajeroExtra.setVisible(true);
					}
					//En este caso el DNI es correcto pero la contrase�a que corresponde a ese usuario es err�nea
			}
			else {
				JOptionPane.showMessageDialog(vis.panelLogin, "Contrase�a Incorrecta", "Advertencia", 0);
				login = false;
			}
				
		}
		// En este caso el DNI que ha metido no est� registrado en la BD
		else {
			JOptionPane.showMessageDialog(vis.panelLogin, "Usuario inexistente", "Advertencia", 0);
			login = false;
		}
	}
		

	public void llenarModeloConLinea(Ventana vis, Modelo mod) throws SQLException {
		String peticion = "SELECT * FROM `linea`";
		ResultSet resul = mod.db.hacerPeticion(peticion);
		while (resul.next()) {
			vis.panelLineas1.modeloLineas.addElement(resul.getString("Cod_Linea") + " " + resul.getString("Nombre"));
		}
	}

	public void inicializarLineas(Modelo mod) throws SQLException {
		String peticion = "SELECT Cod_Linea FROM `linea`";
		ResultSet resul = mod.db.hacerPeticion(peticion);
		while (resul.next()) {
			mod.lineas.add(new Linea(resul.getString("Cod_Linea")));
		}
		mod.municipio.crearYMeterMunicipios(mod);
		mod.autobus.crearYMeterAutobuses(mod);
	}
	
	public double PrecioTrayecto(Modelo mod) throws SQLException{
		double precioGasolina = 0.80;
		String DatosAutobus = "";
		float consumo=0;
		double distancia= 0;
		int asiento=0;
		
		ResultSet rs;
		
		//Pedimos los datos de cantidad de asientos y el consumo a la BD
		DatosAutobus = "select N_plazas, Consumo_km from autobus";
		
		rs = mod.db.hacerPeticion(DatosAutobus);
		
		consumo = rs.getFloat("Consumo_km");
		asiento = rs.getInt("N_plazas");
						
		
		double total=(precioGasolina*consumo*distancia)/asiento;
		return total;

	}

	/**
	 * Statement stmt = con.createStatement(); ResultSet rs =
	 * stmt.executeQuery("select * from `linea` where 1"); while (rs.next())
	 * System.out.println(rs.getString("Cod_Linea") + " " + rs.getString("Nombre"));
	 */
}
