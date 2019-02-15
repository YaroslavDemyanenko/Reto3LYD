package conexion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import clases.Cliente;
import clases.Linea;
import clases.Modelo;
import interfaces.Ventana;

public class ConexionAMySQL {
	private Connection conexion;

	public String[] leerArchivoDDBB() {
		try {
			
//			String pathArchivo = JOptionPane.showInputDialog("Introduce la direccion del archivo");
//			if (pathArchivo==null) {
//				System.exit(0);
//			}
//			pathArchivo.replace((char)92, (char)47);
//			meter patharchivo al new filereader
			BufferedReader reader = new BufferedReader(new FileReader(("C:/Users/IN1DM3B_18/Desktop/ddbb.txt").replace((char)92, (char)47)));
			String[] datosDB = new String[5];	
			for(int i=0;datosDB.length>i;i++) {
				String line = reader.readLine();
				datosDB[i]=line;
			}
			reader.close();
			return datosDB;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Conecta la aplicacion a la base de datos
	 * 
	 * @param ip        IP de la base de datos
	 * @param puerto    Puerto que usa para conectarse
	 * @param baseDatos Base de datos de la cual se pedira informacion
	 * @param user      Usuario que pueda acceder a la base de datos
	 * @param pass      Contraseña del usuario
	 */
	public ConexionAMySQL() {
		try {
			String[] datosDB = leerArchivoDDBB();
			this.conexion = (DriverManager.getConnection("jdbc:mysql://" + datosDB[0] + ":" + datosDB[1] + "/" + datosDB[2] + "?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC", datosDB[3], datosDB[4]));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Conexion a la base de datos no conseguida, revisa el archivo de texto ddbb.txt y asegurate de que este en el escritorio o crea uno nuevo e introduce los datos", "", 0);
			System.exit(0);
		}
	}

	/**
	 * Metodo para hacer peticiones a la base de datos
	 * 
	 * @param peticionString String que se usara en la query de sql
	 * @return devuelve un set de resultados
	 */
	public ResultSet hacerPeticion(String peticionString) {
		try {
			Statement peticion = this.conexion.createStatement();
			ResultSet resultadoPeticion = peticion.executeQuery(peticionString);
			return resultadoPeticion;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
		}
		return null;
	}

	public void llenarModeloConLinea(Ventana vis, Modelo mod) {
		String peticion = "SELECT * FROM `linea`";
		ResultSet resul = mod.db.hacerPeticion(peticion);
		try {
			while (resul.next()) {
				vis.panelLineas1.modeloLineas.addElement(resul.getString("Cod_Linea") + " " + resul.getString("Nombre"));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al rellenar el modelo con las lineas", "Error", JOptionPane.WARNING_MESSAGE);
		}
	}

	/**
	 * Inserta la informacion del usuario en la base de datos
	 * 
	 * @param usuario el cliente que se registrara en la base de datos
	 * @param mod     modelo con la conexion a la base de datos
	 */
	public void insertarUsuarioEnBaseDeDatos(Cliente usuario, Modelo mod) {
		try {
			String query = "insert into cliente (DNI,Nombre,Apellidos,Fecha_nac,Sexo,Contraseña) values(?,?,?,?,?,?);";
			PreparedStatement insertartUsuario = this.conexion.prepareStatement(query);
			insertartUsuario.setString(1, usuario.dni);
			insertartUsuario.setString(2, usuario.nombre);
			insertartUsuario.setString(3, usuario.apellido);
			insertartUsuario.setDate(4, new java.sql.Date(usuario.fechaNac.getTime()));
			insertartUsuario.setString(5, String.valueOf(usuario.sexo));
			insertartUsuario.setString(6, usuario.getContrasenia());
			insertartUsuario.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
		}
	}

	public void inicializarLineas(Modelo mod) {
		String peticion = "SELECT Cod_Linea FROM `linea`";
		ResultSet resul = mod.db.hacerPeticion(peticion);
		try {
			while (resul.next()) {
				mod.lineas.add(new Linea(resul.getString("Cod_Linea")));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al crear el array de lineas", "Error", 0);
		}
		mod.municipio.crearYMeterMunicipios(mod);
		mod.autobus.crearYMeterAutobuses(mod);
	}

}
