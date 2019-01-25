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
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setBounds(56, 527, 129, 35);
		add(btnCancelar);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConfirmar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfirmar.setBounds(655, 527, 129, 35);
		add(btnConfirmar);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(348, 153, 259, 39);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(348, 217, 259, 39);
		add(textFieldApellido);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setColumns(10);
		textFieldDNI.setBounds(348, 289, 259, 39);
		add(textFieldDNI);
		
		lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSexo.setBounds(216, 344, 83, 48);
		add(lblSexo);
		
		textFieldSexo = new JComboBox();
		textFieldSexo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldSexo.setModel(new DefaultComboBoxModel(new String[] {"Hombre", "Mujer"}));
		textFieldSexo.setBounds(348, 351, 259, 39);
		add(textFieldSexo);
		
		lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDni.setBounds(216, 285, 130, 43);
		add(lblDni);
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblApellido.setBounds(216, 210, 130, 48);
		add(lblApellido);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(216, 151, 109, 39);
		add(lblNombre);
		
		lblRegistroUsuario = new JLabel("Registro usuario 2");
		lblRegistroUsuario.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblRegistroUsuario.setBounds(265, 39, 269, 48);
		add(lblRegistroUsuario);
	
	}
}
