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

/**
 * @wbp.parser.entryPoint
 */
public class PanelLogin extends JPanel {
	
	public static JTextField textFieldNombre, textFieldApellido, textFieldDNI, textFieldDNILogin, textFieldContraseniaLogin, textFieldContrasenia;
	public static JComboBox comboBoxSexo;
	public JLabel lblRegistroUsuario, lblNombre, lblApellido, lblDni, lblSexo, lblLogin, lblDniLogin, lblContraseaLogin, lblContrasea;
	public JButton btnConfirmarRegistro, btnConfirmarLogin, btnCancelar;

	
	public PanelLogin() {
		setLayout(null);
		setVisible(false);
		setBounds(0,0,800,600);
		
		lblRegistroUsuario = new JLabel("Registro:");
		lblRegistroUsuario.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblRegistroUsuario.setBounds(47, 35, 269, 48);
		add(lblRegistroUsuario);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombre.setBounds(47, 106, 78, 39);
		add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(135, 108, 192, 39);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblApellido.setBounds(47, 170, 78, 41);
		add(lblApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(135, 170, 192, 39);
		add(textFieldApellido);
		
		lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDni.setBounds(47, 238, 65, 43);
		add(lblDni);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setColumns(10);
		textFieldDNI.setBounds(137, 238, 190, 43);
		add(textFieldDNI);
		
		lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSexo.setBounds(47, 304, 65, 41);
		add(lblSexo);
		
		comboBoxSexo = new JComboBox();
		comboBoxSexo.setModel(new DefaultComboBoxModel(new String[] {"Hombre", "Mujer"}));
		comboBoxSexo.setBounds(135, 304, 192, 39);
		add(comboBoxSexo);
		
		lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblLogin.setBounds(474, 35, 237, 48);
		add(lblLogin);
		
		lblDniLogin = new JLabel("DNI:");
		lblDniLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDniLogin.setBounds(468, 106, 65, 39);
		add(lblDniLogin);
		
		textFieldDNILogin = new JTextField();
		textFieldDNILogin.setBounds(559, 108, 180, 39);
		add(textFieldDNILogin);
		textFieldDNILogin.setColumns(10);
		
		lblContraseaLogin = new JLabel("Contrase\u00F1a:");
		lblContraseaLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContraseaLogin.setBounds(468, 170, 81, 39);
		add(lblContraseaLogin);
		
		textFieldContraseniaLogin = new JTextField();
		textFieldContraseniaLogin.setBounds(559, 170, 180, 39);
		add(textFieldContraseniaLogin);
		textFieldContraseniaLogin.setColumns(10);
		
		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContrasea.setBounds(43, 364, 92, 39);
		add(lblContrasea);
		
		textFieldContrasenia = new JTextField();
		textFieldContrasenia.setBounds(135, 364, 192, 39);
		add(textFieldContrasenia);
		textFieldContrasenia.setColumns(10);
		
		btnConfirmarRegistro = new JButton("Confirmar Registro");
		btnConfirmarRegistro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnConfirmarRegistro.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
		btnConfirmarRegistro.setBounds(169, 452, 158, 35);
		add(btnConfirmarRegistro);
		
		btnConfirmarLogin = new JButton("Confirmar Login");
		btnConfirmarLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnConfirmarLogin.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
		btnConfirmarLogin.setBounds(610, 268, 129, 35);
		add(btnConfirmarLogin);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
		btnCancelar.setBounds(56, 527, 129, 35);
		add(btnCancelar);
		

	
	}
}
