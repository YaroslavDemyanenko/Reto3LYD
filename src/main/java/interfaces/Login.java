package interfaces;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sun.glass.ui.Cursor;

public class Login {

	
	JPanel panelLogin = new JPanel();
	JTextField textFieldNombre, textFieldApellido, textFieldDNI, textFieldDNILogin, textFieldContraseniaLogin, textFieldContrasenia;
	private JComboBox textFieldSexo;
	JLabel lblRegistroUsuario, lblNombre, lblApellido, lblDni, lblSexo, lblLogin, ;

	/**
	 * @wbp.parser.entryPoint
	 */
	public void Login() {
		panelLogin.setLayout(null);
		panelLogin.setBounds(0,0,800,600);
		
		lblRegistroUsuario = new JLabel("Registro:");
		lblRegistroUsuario.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblRegistroUsuario.setBounds(47, 35, 269, 48);
		panelLogin.add(lblRegistroUsuario);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(47, 106, 78, 39);
		panelLogin.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(135, 108, 192, 39);
		panelLogin.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido.setBounds(47, 170, 78, 41);
		panelLogin.add(lblApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(135, 170, 192, 39);
		panelLogin.add(textFieldApellido);
		
		lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDni.setBounds(47, 238, 65, 43);
		panelLogin.add(lblDni);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setColumns(10);
		textFieldDNI.setBounds(137, 238, 190, 43);
		panelLogin.add(textFieldDNI);
		
		lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSexo.setBounds(47, 304, 65, 41);
		panelLogin.add(lblSexo);
		
		textFieldSexo = new JComboBox();
		textFieldSexo.setModel(new DefaultComboBoxModel(new String[] {"Hombre", "Mujer"}));
		textFieldSexo.setBounds(135, 304, 192, 39);
		panelLogin.add(textFieldSexo);
		
		lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblLogin.setBounds(474, 35, 237, 48);
		panelLogin.add(lblLogin);
		
		JLabel lblDniLogin = new JLabel("DNI:");
		lblDniLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDniLogin.setBounds(468, 106, 65, 39);
		panelLogin.add(lblDniLogin);
		
		textFieldDNILogin = new JTextField();
		textFieldDNILogin.setBounds(559, 108, 180, 39);
		panelLogin.add(textFieldDNILogin);
		textFieldDNILogin.setColumns(10);
		
		JLabel lblContraseaLogin = new JLabel("Contrase\u00F1a:");
		lblContraseaLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContraseaLogin.setBounds(468, 170, 81, 39);
		panelLogin.add(lblContraseaLogin);
		
		textFieldContraseniaLogin = new JTextField();
		textFieldContraseniaLogin.setBounds(559, 170, 180, 39);
		panelLogin.add(textFieldContraseniaLogin);
		textFieldContraseniaLogin.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasea.setBounds(43, 364, 92, 39);
		panelLogin.add(lblContrasea);
		
		textFieldContrasenia = new JTextField();
		textFieldContrasenia.setBounds(135, 364, 192, 39);
		panelLogin.add(textFieldContrasenia);
		textFieldContrasenia.setColumns(10);
		
		JButton btnConfirmarRegistro = new JButton("Confirmar Registro");
		btnConfirmarRegistro.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
		btnConfirmarRegistro.setBounds(94, 497, 141, 48);
		panelLogin.add(btnConfirmarRegistro);
		
		JButton btnConfirmarLogin = new JButton("Confirmar Login");
		btnConfirmarLogin.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
		btnConfirmarLogin.setBounds(564, 497, 141, 48);
		panelLogin.add(btnConfirmarLogin);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
		btnCancelar.setBounds(329, 497, 141, 48);
		panelLogin.add(btnCancelar);
		

	
	}
}
