package conexion;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import clases.Linea;
import clases.Modelo;

public class ConexionAMySQL {
	private Connection conexion;
	

	/**
	 * Conecta la aplicacion con las base de datos
	 * @param baseDatos
	 * @param user
	 * @param pass
	 */
	public ConexionAMySQL(String ip,String puerto,String baseDatos,String user,String pass) {
		try {
			this.conexion= DriverManager.getConnection("jdbc:mysql://"+ip+":"+puerto+"/"+baseDatos+"?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC", user, pass);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
		}
	}
	

	/**
	 * Metodo para hacer peticiones a la base de datos
	 * @param peticionString String que se usara en la query en sql
	 * @return	devuelve un set de resultados
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
	public void meterLineaEnListaYArray (DefaultListModel<String> model,String peticion,Modelo mod,ArrayList<Linea> lineas) throws SQLException {
		ResultSet resul = mod.db.hacerPeticion(peticion);
		while (resul.next()) {
			String codLinea=resul.getString("Cod_Linea");
			model.addElement(codLinea+" "+resul.getString("Nombre"));
			lineas.add(new Linea(codLinea));
		}
		mod.municipio.crearYMeterMunicipios(lineas, mod);
		mod.autobus.crearYMeterAutobuses(lineas, mod);
	}
	
	public void meterParadasAModelo (DefaultListModel<String> model,String lista,String peticion,Modelo mod) throws SQLException {
		ResultSet resul = mod.db.hacerPeticion(peticion);
		while (resul.next()) {
			model.addElement(resul.getString("Nombre"));
		}
	}
	/**
	 * Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from `linea` where 1");
			while (rs.next())
				System.out.println(rs.getString("Cod_Linea") + "  " + rs.getString("Nombre"));
	 */
}
