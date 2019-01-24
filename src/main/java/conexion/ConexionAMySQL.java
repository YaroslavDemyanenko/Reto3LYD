package conexion;

import java.sql.*;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import clases.Modelo;

public class ConexionAMySQL {
	private Connection conexion;
	
	public ConexionAMySQL(String baseDatos,String user,String pass) {
		try {
			this.conexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/"+baseDatos+"?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC", user, pass);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
		}
	}
	

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
	

	public void meterAModelo (DefaultListModel<String> model,String peticion,Modelo mod) throws SQLException {
		ResultSet resul = mod.db.hacerPeticion(peticion);
		while (resul.next()) {
			model.addElement(resul.getString("Cod_Linea")+" "+resul.getString("Nombre"));
		}
	}
	/**
	 * Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from `linea` where 1");
			while (rs.next())
				System.out.println(rs.getString("Cod_Linea") + "  " + rs.getString("Nombre"));
	 */
}
