package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * @wbp.parser.entryPoint
 */
public class PanelPasajeroExtra extends JPanel{
	
	public JTextField textFieldNombre, textFieldApellido, textFieldDNI;
	public JComboBox textFieldSexo;
	public JButton btnCancelar, btnConfirmar;
	public JLabel lblSexo, lblDni, lblApellido, lblNombre, lblRegistroUsuario;

	
	public PanelPasajeroExtra() {
		setLayout(null);
		setVisible(false);
		setBounds(0,0,800,600);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setBounds(128, 458, 214, 61);
		add(btnCancelar);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfirmar.setBounds(470, 458, 200, 61);
		add(btnConfirmar);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(347, 124, 259, 39);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(347, 188, 259, 39);
		add(textFieldApellido);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setColumns(10);
		textFieldDNI.setBounds(347, 260, 259, 39);
		add(textFieldDNI);
		
		lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSexo.setBounds(215, 315, 83, 48);
		add(lblSexo);
		
		textFieldSexo = new JComboBox();
		textFieldSexo.setModel(new DefaultComboBoxModel(new String[] {"Hombre", "Mujer"}));
		textFieldSexo.setBounds(347, 322, 259, 39);
		add(textFieldSexo);
		
		lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDni.setBounds(215, 256, 130, 43);
		add(lblDni);
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido.setBounds(215, 181, 130, 48);
		add(lblApellido);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(215, 122, 109, 39);
		add(lblNombre);
		
		lblRegistroUsuario = new JLabel("Registro usuario 2");
		lblRegistroUsuario.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblRegistroUsuario.setBounds(282, 30, 269, 48);
		add(lblRegistroUsuario);
	
	}
}
