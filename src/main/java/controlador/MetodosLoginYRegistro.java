package controlador;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

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
					return (new Cliente(rs.getString("DNI"), rs.getString("Nombre"), rs.getString("Apellidos"), rs.getDate("Fecha_nac"), rs.getString("Sexo").toCharArray()[0], rs.getString("Contraseña")));
				} else {
					System.out.println("Contraseña erronea");
				}
			} else
				System.out.println("El usuario no existe");
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
	public boolean comprobarDNIenBD(String dni, Modelo mod) {
		String sql = "select DNI from cliente where DNI = \"" + dni + "\"";
		ResultSet rs = mod.db.hacerPeticion(sql);
		try {
			if (rs.next()) {
				return true;
			} else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Cliente registroUsuario(Ventana vis, Modelo mod) {
		String dni = vis.panelLogin.textFieldDNI.getText();
		String nombre = vis.panelLogin.textFieldNombre.getText();
		String apellido = vis.panelLogin.textFieldApellido.getText();
		Date fechaNac = vis.panelLogin.calendarioFechaNac.getDate();
		char sexo = cambiarSexoAChar(vis);
		final char[] contra = vis.panelLogin.passFieldContrasenia.getPassword();
		if (nombre.length() > 0 && apellido.length() > 0 && validarDNI(dni) == true && fechaNac.before(Calendar.getInstance().getTime()) && validarContrasenia(contra)) {
			if (comprobarDNIenBD(vis.panelLogin.textFieldDNI.getText(), mod) == false) {
				return (new Cliente(dni, nombre, apellido, fechaNac, sexo, encriptarContra(contra)));
			} else {
				JOptionPane.showMessageDialog(null, "El usuario introducido ya esta registrado, porfavor inicie sesion", "Usuario ya registrado", JOptionPane.INFORMATION_MESSAGE);
			}

		} else if (validarContrasenia(contra) == true)
			JOptionPane.showMessageDialog(null, "Porfavor, rellena todos los campos", "Campos sin completar", JOptionPane.WARNING_MESSAGE);
		;
		return null;
	}

	private boolean validarContrasenia(char[] contra) {
		// Regex para validar contraseña, por orden: Una letra minuscula, una letra
		// mayuscula, un numero y minimo 8 caracteres de longitud
		if (contra.toString().matches("^.*(?=.{8,})(?=..*[0-9])(?=\\S+$)(?=.*[a-z])(?=.*[A-Z]).*$")) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Introduce una letra minuscula, una mayuscula, un numero y al menos 8 caracteres", "Contraseña poco segura", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	public boolean validarDNI(String DNI) {
		return DNI.matches("^[0-9]{7,8}['T|R|W|A|G|M|Y|F|P|D|X|B|N|J|Z|S|Q|V|H|L|C|K|E|T]$");
	}

	public char cambiarSexoAChar(Ventana vis) {
		String sexo = vis.panelLogin.cmbBoxSexo.getSelectedItem().toString();
		if (sexo == "Hombre") {
			return 'V';
		} else
			return 'M';

	}

}
