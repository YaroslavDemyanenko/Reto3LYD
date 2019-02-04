package controlador;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import clases.Cliente;
import clases.Modelo;
import interfaces.Ventana;

public class MetodosLoginYRegistro {

	/**
	 * Metodo de incripatcion de la contraseña
	 * 
	 * @return
	 */
	public String encriptarContra(char[] contrasenia) {

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			String contraEnc = new String(contrasenia);
			byte[] hashInBytes = md.digest(contraEnc.getBytes(StandardCharsets.UTF_8));
			StringBuilder sb = new StringBuilder();
			for (byte b : hashInBytes) {
				sb.append(String.format("%02x", b));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Metodo para loguearse
	 * 
	 * @param mod
	 * @param vis
	 * @param dni
	 * @param contrasenia
	 * @param CantidadPasajeros
	 * @return
	 * @throws SQLException
	 */
	public Cliente iniciarSesion(Modelo mod, Ventana vis) {
		String dniUsuario = vis.panelLogin.textFieldDNILogin.getText();
		String contraUsuario = encriptarContra(vis.panelLogin.passFieldContraseniaLogin.getPassword());
		String sql = "select * from cliente where DNI=\"" + dniUsuario + "\"";
		ResultSet rs = mod.db.hacerPeticion(sql);
		try {
			if (rs.next()) {
				String contraBase = rs.getString("Contraseña");
				if (contraBase.equals(contraUsuario)) {
					return (new Cliente(rs.getString("DNI"), rs.getString("Nombre"), rs.getString("Apellidos"), rs.getDate("Fecha_nac"), rs.getString("Sexo").toCharArray()[0], rs.getString("Contraseña").toCharArray()));
				} else {
					System.out.println("Contraseña erronea");
				}
			} else System.out.println("El usuario no existe");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Comprueba la existencia de ese DNI
	 * 
	 * @param cliente
	 * @return
	 * @throws SQLException
	 */
	public boolean comprobarDNIenBD(Cliente cliente,Modelo mod) throws SQLException {
		String sql = "select DNI from cliente where DNI = " + cliente.dni + "";
		ResultSet rs = mod.db.hacerPeticion(sql);
		if (rs.next()) {
			return true;
		} else
			return false;
	}
	
	public boolean ValidarDNI(String DNI){
		return DNI.matches("^[0-9]{7,8}['T|R|W|A|G|M|Y|F|P|D|X|B|N|J|Z|S|Q|V|H|L|C|K|E|T]$");
	}
	
	public void cambiarSexoAChar(Ventana vis, Cliente Cliente){
		Object sexo = vis.panelLogin.cmbBoxSexo.getSelectedItem();
		if(sexo=="Hombre"){
			Cliente.setSexo('V');
		}
		else 
			Cliente.setSexo('M');

	}
	
}
