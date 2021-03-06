package interfaces;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;
import javax.swing.SwingConstants;


@SuppressWarnings("serial")
public class PanelLogin extends JPanel {
	

	public JTextField textFieldNombre, textFieldApellido, textFieldDNI, textFieldDNILogin;
	@SuppressWarnings("rawtypes")
	public JComboBox cmbBoxSexo;
	public JPasswordField passFieldContrasenia,passFieldContraseniaLogin;
	public JLabel lblRegistroUsuario, lblNombre, lblApellido, lblDni, lblSexo, lblLogin, lblDniLogin, lblContraseaLogin, lblContrasea, lblFechaNacimiento;
	public JButton btnConfirmarRegistro, btnConfirmarLogin, btnCancelar;
	public JSpinnerDateEditor spinnerFechaNac;
	public JDateChooser calendarioFechaNac;
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PanelLogin() {
		setLayout(null);
		setBounds(0,0,800,600);
		setBackground(new Color(193, 240, 240));
		
		lblRegistroUsuario = new JLabel("REGISTRO");
		lblRegistroUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroUsuario.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblRegistroUsuario.setBounds(47, 35, 269, 48);
		add(lblRegistroUsuario);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		lblNombre.setBounds(47, 106, 78, 39);
		add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldNombre.setBounds(135, 108, 192, 39);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		lblApellido.setBounds(47, 170, 78, 41);
		add(lblApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(135, 170, 192, 39);
		add(textFieldApellido);
		
		lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		lblDni.setBounds(51, 313, 65, 43);
		add(lblDni);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldDNI.setColumns(10);
		textFieldDNI.setBounds(141, 313, 190, 43);
		add(textFieldDNI);
		
		lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		lblSexo.setBounds(51, 379, 65, 41);
		add(lblSexo);
		
		cmbBoxSexo = new JComboBox();
		cmbBoxSexo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cmbBoxSexo.setModel(new DefaultComboBoxModel(new String[] {"Hombre", "Mujer"}));
		cmbBoxSexo.setBounds(139, 379, 192, 39);
		add(cmbBoxSexo);
		
		lblLogin = new JLabel("Sign In");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblLogin.setBounds(474, 35, 237, 48);
		add(lblLogin);
		
		lblDniLogin = new JLabel("DNI:");
		lblDniLogin.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		lblDniLogin.setBounds(468, 106, 65, 39);
		add(lblDniLogin);
		
		textFieldDNILogin = new JTextField();
		textFieldDNILogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldDNILogin.setBounds(559, 108, 180, 39);
		add(textFieldDNILogin);
		textFieldDNILogin.setColumns(10);
		
		lblContraseaLogin = new JLabel("Contrase\u00F1a:");
		lblContraseaLogin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContraseaLogin.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		lblContraseaLogin.setBounds(443, 170, 106, 39);
		add(lblContraseaLogin);
		
		passFieldContraseniaLogin = new JPasswordField();
		passFieldContraseniaLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passFieldContraseniaLogin.setBounds(559, 170, 180, 39);
		add(passFieldContraseniaLogin);
		
		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		lblContrasea.setBounds(47, 439, 92, 39);
		add(lblContrasea);
		
		passFieldContrasenia = new JPasswordField();
		passFieldContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passFieldContrasenia.setBounds(139, 439, 192, 39);
		add(passFieldContrasenia);
		
		btnConfirmarRegistro = new JButton("Confirmar");
		btnConfirmarRegistro.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		btnConfirmarRegistro.setAlignmentY(Component.TOP_ALIGNMENT);
		btnConfirmarRegistro.setBackground(new Color(192, 192, 192));
		btnConfirmarRegistro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConfirmarRegistro.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
		btnConfirmarRegistro.setBounds(141, 514, 180, 35);
		add(btnConfirmarRegistro);
		
		btnConfirmarLogin = new JButton("Confirmar");
		btnConfirmarLogin.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		btnConfirmarLogin.setAlignmentY(Component.TOP_ALIGNMENT);
		btnConfirmarLogin.setBackground(new Color(192, 192, 192));
		btnConfirmarLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConfirmarLogin.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
		btnConfirmarLogin.setBounds(559, 268, 180, 35);
		add(btnConfirmarLogin);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		btnCancelar.setAlignmentY(Component.TOP_ALIGNMENT);
		btnCancelar.setBackground(new Color(192, 192, 192));
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
		btnCancelar.setBounds(610, 514, 129, 35);
		add(btnCancelar);
		
		lblFechaNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaNacimiento.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		lblFechaNacimiento.setBounds(47, 245, 160, 39);
		add(lblFechaNacimiento);
		
		spinnerFechaNac = new JSpinnerDateEditor();
		((JSpinner.DefaultEditor) spinnerFechaNac.getEditor()).getTextField().setEditable(false);
		spinnerFechaNac.setFont(new Font("Tahoma", Font.BOLD, 12));
		spinnerFechaNac.setDateFormatString("dd/mm/yyyy");
		calendarioFechaNac = new JDateChooser(null, null, null, spinnerFechaNac);
		calendarioFechaNac.setDateFormatString("dd-MM-yyyy");
		calendarioFechaNac.setBounds(215, 250, 137, 27);
		calendarioFechaNac.setDate(Calendar.getInstance().getTime());
		add(calendarioFechaNac);
		
		

	
	}
	public void limpiar(){
		textFieldNombre.setText("");
		textFieldApellido.setText("");
		textFieldDNI.setText("");
		calendarioFechaNac.setDate(Calendar.getInstance().getTime());
		passFieldContrasenia.setText("");
		passFieldContraseniaLogin.setText("");
		textFieldDNILogin.setText("");
		textFieldNombre.setBackground(new JTextField().getBackground());
		textFieldApellido.setBackground(new JTextField().getBackground());
		textFieldDNI.setBackground(new JTextField().getBackground());
		passFieldContrasenia.setText("");
		passFieldContraseniaLogin.setText("");
		textFieldDNILogin.setText("");
		
	}
}
