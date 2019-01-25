package interfaces;

import java.awt.Color;
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
	

	public JTextField textFieldNombre, textFieldApellido, textFieldDNI, textFieldDNILogin, textFieldContraseniaLogin, textFieldContrasenia,txtFechanacimiento;
	public JComboBox textFieldSexo;
	public JLabel lblRegistroUsuario, lblNombre, lblApellido, lblDni, lblSexo, lblLogin, lblDniLogin, lblContraseaLogin, lblContrasea, lblFechaNacimiento;
	public JButton btnConfirmarRegistro, btnConfirmarLogin, btnCancelar;
	
	
	public PanelLogin() {
		setLayout(null);
		setVisible(false);
		setBounds(0,0,800,600);
		setBackground(new Color(193, 240, 240));
		
		lblRegistroUsuario = new JLabel("Registro:");
		lblRegistroUsuario.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblRegistroUsuario.setBounds(47, 35, 269, 48);
		add(lblRegistroUsuario);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(47, 106, 78, 39);
		add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldNombre.setBounds(135, 108, 192, 39);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido.setBounds(47, 170, 78, 41);
		add(lblApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(135, 170, 192, 39);
		add(textFieldApellido);
		
		lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDni.setBounds(51, 313, 65, 43);
		add(lblDni);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldDNI.setColumns(10);
		textFieldDNI.setBounds(141, 313, 190, 43);
		add(textFieldDNI);
		
		lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSexo.setBounds(51, 379, 65, 41);
		add(lblSexo);
		
		textFieldSexo = new JComboBox();
		textFieldSexo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldSexo.setModel(new DefaultComboBoxModel(new String[] {"Hombre", "Mujer"}));
		textFieldSexo.setBounds(139, 379, 192, 39);
		add(textFieldSexo);
		
		lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblLogin.setBounds(474, 35, 237, 48);
		add(lblLogin);
		
		lblDniLogin = new JLabel("DNI:");
		lblDniLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDniLogin.setBounds(468, 106, 65, 39);
		add(lblDniLogin);
		
		textFieldDNILogin = new JTextField();
		textFieldDNILogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldDNILogin.setBounds(559, 108, 180, 39);
		add(textFieldDNILogin);
		textFieldDNILogin.setColumns(10);
		
		lblContraseaLogin = new JLabel("Contrase\u00F1a:");
		lblContraseaLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContraseaLogin.setBounds(468, 170, 81, 39);
		add(lblContraseaLogin);
		
		textFieldContraseniaLogin = new JTextField();
		textFieldContraseniaLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldContraseniaLogin.setBounds(559, 170, 180, 39);
		add(textFieldContraseniaLogin);
		textFieldContraseniaLogin.setColumns(10);
		
		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasea.setBounds(47, 439, 92, 39);
		add(lblContrasea);
		
		textFieldContrasenia = new JTextField();
		textFieldContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldContrasenia.setBounds(139, 439, 192, 39);
		add(textFieldContrasenia);
		textFieldContrasenia.setColumns(10);
		
		btnConfirmarRegistro = new JButton("Confirmar Registro");
		btnConfirmarRegistro.setBackground(new Color(0, 0, 0));
		btnConfirmarRegistro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConfirmarRegistro.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
		btnConfirmarRegistro.setBounds(141, 514, 180, 35);
		add(btnConfirmarRegistro);
		
		btnConfirmarLogin = new JButton("Confirmar Login");
		btnConfirmarLogin.setBackground(new Color(0, 0, 0));
		btnConfirmarLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConfirmarLogin.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
		btnConfirmarLogin.setBounds(559, 268, 180, 35);
		add(btnConfirmarLogin);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(0, 0, 0));
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
		btnCancelar.setBounds(610, 514, 129, 35);
		add(btnCancelar);
		
		lblFechaNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaNacimiento.setBounds(47, 245, 136, 39);
		add(lblFechaNacimiento);
		
		txtFechanacimiento = new JTextField();
		txtFechanacimiento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtFechanacimiento.setBounds(193, 243, 190, 43);
		add(txtFechanacimiento);
		txtFechanacimiento.setColumns(10);
		

	
	}
}
