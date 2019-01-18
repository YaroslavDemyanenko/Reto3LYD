package conexion;

import java.sql.*;

class ConexionAMySQL {
	public Connection conectarABase(String baseDatos,String user,String pass) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+baseDatos+"?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC", user, pass);
			return con;
		} catch (SQLException e) {
			
		}
		return null;
	}
	public ResultSet hacerPeticion(Connection con,String peticionString) {
		try {
			Statement peticion = con.createStatement();
			ResultSet resultadoPeticion = peticion.executeQuery(peticionString);
			return resultadoPeticion;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
	/**
	 * Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from `linea` where 1");
			while (rs.next())
				System.out.println(rs.getString("Cod_Linea") + "  " + rs.getString("Nombre"));
	 */
}
