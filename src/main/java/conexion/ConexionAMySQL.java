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

import com.sun.org.apache.regexp.internal.RESyntaxException;

import clases.Billete;
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

			BufferedReader reader = new BufferedReader(new FileReader(("C:/Users/Yaros/Desktop/ddbb.txt").replace((char)92, (char)47)));

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
	public void insertarUsuarioEnBaseDeDatos(Cliente usuario) {
		try {
			String query = "insert into cliente (DNI,Nombre,Apellidos,Fecha_nac,Sexo,Contraseña) values(?,?,?,?,?,?);";
			PreparedStatement insertarUsuario = this.conexion.prepareStatement(query);
			insertarUsuario.setString(1, usuario.dni);
			insertarUsuario.setString(2, usuario.nombre);
			insertarUsuario.setString(3, usuario.apellido);
			insertarUsuario.setDate(4, new java.sql.Date(usuario.fechaNac.getTime()));
			insertarUsuario.setString(5, String.valueOf(usuario.sexo));
			insertarUsuario.setString(6, usuario.getContrasenia());
			insertarUsuario.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
		}
	}
	
	public void insertarBilleteIdaDB(Cliente usuario,Billete billete) {
		try {
			String query = "INSERT INTO `billete` (`Cod_Billete`, `NTrayecto`, `Cod_Linea`, `Cod_Bus`, `Cod_Parada_Inicio`, `Cod_Parada_Fin`, `Fecha`, `Hora`, `DNI`, `Precio`) VALUES (?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement insertarBillete = this.conexion.prepareStatement(query);
			insertarBillete.setInt(1, 0);
			//el 1 para la ida
			insertarBillete.setInt(2, 1);
			insertarBillete.setString(3, billete.linea.codigo);
			insertarBillete.setInt(4, billete.codAutobus);
			insertarBillete.setInt(5, billete.paradaInic.codigo);
			insertarBillete.setInt(6, billete.paradaFin.codigo);
			insertarBillete.setDate(7,  new java.sql.Date(billete.fecha.getTime()));
			insertarBillete.setString(8,"12:00:00");
			if (usuario.getContrasenia()==null) {
				insertarBillete.setString(9,"11111111A");
			}else insertarBillete.setString(9, usuario.dni);
			insertarBillete.setFloat(10, (float) billete.precioTrayecto);
			insertarBillete.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
		}
	}
	
	public void insertarBilleteVueltaDB(Cliente usuario,Billete billete) {
		try {
			String query = "INSERT INTO `billete` (`Cod_Billete`, `NTrayecto`, `Cod_Linea`, `Cod_Bus`, `Cod_Parada_Inicio`, `Cod_Parada_Fin`, `Fecha`, `Hora`, `DNI`, `Precio`) VALUES (?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement insertarBillete = this.conexion.prepareStatement(query);
			insertarBillete.setInt(1, 0);
			//el 2 para la vuelta
			insertarBillete.setInt(2, 2);
			insertarBillete.setString(3, billete.linea.codigo);
			insertarBillete.setInt(4, billete.codAutobus);
			insertarBillete.setInt(5, billete.paradaFin.codigo);
			insertarBillete.setInt(6, billete.paradaInic.codigo);
			insertarBillete.setDate(7, new java.sql.Date(billete.fecha.getTime()));
			insertarBillete.setString(8,"12:00:00");
			if (usuario.getContrasenia()==null) {
				insertarBillete.setString(9,"11111111A");
			}else insertarBillete.setString(9, usuario.dni);
			insertarBillete.setFloat(10, (float) billete.precioTrayecto);
			insertarBillete.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
		}
	}

	public int codigoDeBillete() {
		String peticion="SELECT MAX(Cod_Billete) FROM billete";
		ResultSet result=hacerPeticion(peticion);
		try {
			if (result.next()) {
				return result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
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
