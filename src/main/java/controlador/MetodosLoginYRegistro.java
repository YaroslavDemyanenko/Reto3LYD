package controlador;

import java.awt.Color;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import clases.Cliente;
import clases.Modelo;
import interfaces.PanelPasajeroExtra;
import interfaces.Ventana;

/**
 * Metodos para registrar/logear al usuario
 * @author Yaros
 *
 */
public class MetodosLoginYRegistro {

	/**
	 * Metodo para la incripatcion de la contraseña
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
	 * Metodo para loguearse al usuario en la aplicacion
	 * 
	 * @param mod
	 * @param vis
	 * @param dni
	 * @param contrasenia
	 * @param CantidadPasajeros
	 * @return un objeto cliente con los datos del usuario
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
					actualizarLabelUsuario(vis,rs.getString("Nombre"));
					return (new Cliente(rs.getString("DNI"), rs.getString("Nombre"), rs.getString("Apellidos"), rs.getDate("Fecha_nac"), rs.getString("Sexo").toCharArray()[0], rs.getString("Contraseña")));
				} else {
					JOptionPane.showMessageDialog(null, "Contraseña incorrecta", null, JOptionPane.INFORMATION_MESSAGE);
				}
			} else
				JOptionPane.showMessageDialog(null, "Este usuario no esta registrado, por favor introduzca sus datos a la izquierda", null, JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Actualiza los paneles de la interfaz con el nombre del usuario, tambien limpia las interfaces si se le pasa un string vacio
	 * @param vis
	 * @param nombre
	 */
	public void actualizarLabelUsuario(Ventana vis,String nombre) {
		vis.panelSaludo.lblUsuario.setText(nombre);
		vis.panelLineas1.lblUsuario.setText(nombre);
		vis.panelLineas2.lblUsuario.setText(nombre);
		vis.panelPago.lblUsuario.setText(nombre);
		vis.panelResumen.lblUsuario.setText(nombre);
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

	/**
	 * Registra al usuario en la base de datos en el caso que no estuviera
	 * 
	 * @param vis
	 * @param mod
	 * @return
	 */
	public Cliente registroUsuario(Ventana vis, Modelo mod) {
		JTextField dni = vis.panelLogin.textFieldDNI;
		JTextField nombre = vis.panelLogin.textFieldNombre;
		JTextField apellido = vis.panelLogin.textFieldApellido;
		Date fechaNac = vis.panelLogin.calendarioFechaNac.getDate();
		char sexo = cambiarSexoAChar(vis.panelLogin.cmbBoxSexo);
		final char[] contra = vis.panelLogin.passFieldContrasenia.getPassword();
		if (validarSoloLetras(nombre) && validarSoloLetras(apellido) && (nombre.getText().length() > 0) && (apellido.getText().length() > 0) && validarDNI(dni) && validarFecha(fechaNac) && validarContrasenia(contra)) {
			if (comprobarDNIenBD(vis.panelLogin.textFieldDNI.getText(), mod) == false) {
				return (new Cliente(dni.getText(), nombre.getText(), apellido.getText(), fechaNac, sexo, encriptarContra(contra)));
			} else {
				JOptionPane.showMessageDialog(null, "El usuario introducido ya esta registrado, porfavor inicie sesion", "Usuario ya registrado", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		return null;
	}

	/**
	 * Comprueba que la fecha sea anterior a hoy
	 * @param fecha
	 * @return
	 */
	public boolean validarFecha(Date fecha) {
		if(!fecha.before(Calendar.getInstance().getTime())) {
			JOptionPane.showMessageDialog(null, "La fecha introducida es invalida","Fecha invalida", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}else return true; 
	}

	/**
	 * Comprueba que has introducido la contraseña segun los criterios requeridos (letra mayus,letra minus, numero y almenos 8 caracteres)
	 * 
	 * @param contra
	 * @return
	 */
	public boolean validarContrasenia(char[] contra) {
		// Regex para validar contraseña, por orden: Una letra minuscula, una letra
		// mayuscula, un numero y minimo 8 caracteres de longitud

		Pattern p = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$");
		String contraString = new String(contra);
		Matcher m = p.matcher(contraString);
		if (m.matches()) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Introduce una letra minuscula, una mayuscula, un numero y al menos 8 caracteres", "Contraseña poco segura", JOptionPane.ERROR_MESSAGE);
			return false;
		}

	}

	/**
	 * Comprueba que el DNI cumple con los parametros de un DNI (8 numeros y una letra)
	 * 
	 * @param DNI
	 * @return
	 */
	public boolean validarDNI(JTextField DNI) {
		if (!(DNI.getText().matches("^[0-9]{7,8}['T|R|W|A|G|M|Y|F|P|D|X|B|N|J|Z|S|Q|V|H|L|C|K|E|T]$"))) {
			JOptionPane.showMessageDialog(null, "El DNI introducido es invalido", "Error", JOptionPane.ERROR_MESSAGE);
			DNI.setBackground(new Color(240, 128, 128));
			return false;
		} else {
			DNI.setBackground(new JTextField().getBackground());
			return true;
		}
	}

	/**
	 * Comprueba que has metido letras en el campo de texto
	 * 
	 * @param vis
	 * @return
	 */
	public boolean validarSoloLetras(JTextField campoTexto) {
		if (!(campoTexto.getText().matches("^[a-zA-Z]+$"))) {
			JOptionPane.showMessageDialog(null, "Este campo solo admite letras", "Error", JOptionPane.ERROR_MESSAGE);
			campoTexto.setBackground(new Color(240, 128, 128));
			return false;
		} else {
			campoTexto.setBackground(new JTextField().getBackground());
			return true;
		}
	}

	/**
	 * Pasa los parametros del comboBox de la interfaz a caracteres para poder
	 * enviarselo posteriormente a la BD
	 * 
	 * @param campoTexto
	 * @return
	 */
	public char cambiarSexoAChar(@SuppressWarnings("rawtypes") JComboBox campoTexto) {
		String sexo = campoTexto.getSelectedItem().toString();
		if (sexo == "Hombre") {
			return 'V';
		} else
			return 'M';
	}

	/**
	 * Devuelte un objeto Cliente con los datos de un pasajero extra
	 * @param panel
	 * @return
	 */
	public Cliente pasajeroExtra(PanelPasajeroExtra panel) {
		JTextField nombre, apellido, dni;
		nombre = panel.textFieldNombre;
		apellido = panel.textFieldApellido;
		dni = panel.textFieldDNI;

		if (validarSoloLetras(nombre) && validarSoloLetras(apellido) && validarDNI(dni)) {
			return new Cliente(panel.textFieldNombre.getText(), panel.textFieldApellido.getText(), panel.textFieldDNI.getText(), cambiarSexoAChar(panel.textFieldSexo));

		} else
			return null;

	}

}
