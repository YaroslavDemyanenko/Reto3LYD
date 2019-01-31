package conexion;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

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
			Statement peticion = conexion.createStatement();
			ResultSet resultadoPeticion = peticion.executeQuery(peticionString);
			return resultadoPeticion;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
		}
		return null;
	}

	/**
	 * 
	 * @param model
	 * @param peticion
	 * @param mod
	 * @param lineas
	 * @throws SQLException
	 */
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

	/**
	 * Statement stmt = con.createStatement(); ResultSet rs =
	 * stmt.executeQuery("select * from `linea` where 1"); while (rs.next())
	 * System.out.println(rs.getString("Cod_Linea") + " " + rs.getString("Nombre"));
	 */
}
