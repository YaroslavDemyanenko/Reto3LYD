package conexion;

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
			this.conexion=(DriverManager.getConnection("jdbc:mysql://" + ip + ":" + puerto + "/" + baseDatos + "?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC", user, pass));
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
		}
		return null;
	}

	public void llenarModeloConLinea(Ventana vis, Modelo mod) throws SQLException {
		String peticion = "SELECT * FROM `linea`";
		ResultSet resul = mod.db.hacerPeticion(peticion);
		while (resul.next()) {
			vis.panelLineas1.modeloLineas.addElement(resul.getString("Cod_Linea") + " " + resul.getString("Nombre"));
		}
	}
	
	/**
	 * Inserta la informacion del usuario en la base de datos
	 * @param usuario el cliente que se registrara en la base de datos
	 * @param mod modelo con la conexion a la base de datos
	 */
	public void insertarUsuarioEnBaseDeDatos(Cliente usuario, Modelo mod) {
		try {
			String query = "insert into cliente (DNI,Nombre,Apellidos,Fecha_nac,Sexo,Contraseña) values(?,?,?,?,?,?);";
			PreparedStatement insertartUsuario = this.conexion.prepareStatement(query);
			insertartUsuario.setString(1, usuario.dni);
			insertartUsuario.setString(2, usuario.nombre);
			insertartUsuario.setString(3, usuario.apellido);
			insertartUsuario.setDate(4,new java.sql.Date( usuario.fechaNac.getTime()));
			insertartUsuario.setString(5, String.valueOf(usuario.sexo));
			insertartUsuario.setString(6, usuario.getContrasenia());
			insertartUsuario.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
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
	 * Calculamos el precio del trayecto dependiendo de las paradas que haya elegido
	 * el usuario
	 * 
	 * @param mod
	 * @param llegada
	 * @param salida
	 * @return
	 * @throws SQLException
	 */
	public double PrecioTrayecto(Modelo mod, Parada llegada, Parada salida) throws SQLException {

		double precioGasolina = 0.80;
		String DatosAutobus = "select N_plazas, Consumo_km from autobus";
		ResultSet rs = mod.db.hacerPeticion(DatosAutobus);
		float consumo = rs.getFloat("Consumo_km");
		int asiento = rs.getInt("N_plazas");
		double distancia = controlador.Metodos.distanciaLineas(salida, llegada);

		return (precioGasolina * consumo * distancia) / asiento;

	}


	/**
	 * Statement stmt = con.createStatement(); ResultSet rs =
	 * stmt.executeQuery("select * from `linea` where 1"); while (rs.next())
	 * System.out.println(rs.getString("Cod_Linea") + " " + rs.getString("Nombre"));
	 */
}
