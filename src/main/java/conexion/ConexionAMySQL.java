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
	public void llenarModeloConLinea (Ventana vis,Modelo mod) throws SQLException {
		String peticion = "SELECT * FROM `linea`";
		ResultSet resul = mod.db.hacerPeticion(peticion);
		while (resul.next()) {
			vis.panelLineas1.modeloLineas.addElement(resul.getString("Cod_Linea")+" "+resul.getString("Nombre"));
		}
	}
	public void inicializarLineas (Modelo mod) throws SQLException {
		String peticion = "SELECT * FROM `linea`";
		ResultSet resul = mod.db.hacerPeticion(peticion);
		while (resul.next()) {
			mod.lineas.add(new Linea(resul.getString("Cod_Linea")));
		}
		mod.municipio.crearYMeterMunicipios(mod);
		mod.autobus.crearYMeterAutobuses(mod);
	}
	
	public void meterParadasAModelo (Ventana vis,Modelo mod) throws SQLException {
		String query= vis.panelLineas1.listLineas.getSelectedValue().toString().substring(0,2);
		query="select nombre,Cod_Parada,Calle,sqrt(power((longitud-(SELECT Longitud FROM `parada` where Nombre=\"Termibus-Bilbao\")),2)+power((latitud-(SELECT Latitud FROM `parada` where Nombre=\"Termibus-Bilbao\")),2)) distancia from parada WHERE Cod_Parada IN(SELECT Cod_Parada FROM linea_parada where linea_parada.Cod_Linea=\""+query+"\") order by distancia;";
		ResultSet result = mod.db.hacerPeticion(query);
		while (result.next()) {
			vis.panelLineas1.modeloParadas.addElement(result.getString("Nombre"));
			mod.arrayParadas.add(new Parada(result.getInt("Cod_Parada"),result.getString("Calle"),result.getString("Nombre")));
		}
	}
	/**
	 * Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from `linea` where 1");
			while (rs.next())
				System.out.println(rs.getString("Cod_Linea") + "  " + rs.getString("Nombre"));
	 */
}
