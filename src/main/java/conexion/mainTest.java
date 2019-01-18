package conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class mainTest {

	public static void main(String[] args) throws SQLException {
		ConexionAMySQL conector = new ConexionAMySQL();
		Connection con=conector.conectarABase("termibus", "hr", "PepeJeans");
		ResultSet resultado = conector.hacerPeticion(con, "SELECT * FROM `linea` where 1");
			while (resultado.next())
				System.out.println(resultado.getString("Cod_Linea") + "  " + resultado.getString("Nombre"));
	}

}
