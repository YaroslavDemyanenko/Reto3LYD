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

public class Regis2 {
	
	JPanel panelRegistro2 = new JPanel();
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldDNI;
	private JComboBox textFieldSexo;

	/**
	 * @wbp.parser.entryPoint
	 */
	public void HacerRegistro2() {
		panelRegistro2.setLayout(null);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
		});
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setBounds(47, 478, 214, 61);
		panelRegistro2.add(btnCancelar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addMouseListener(new MouseAdapter() {
		});
		btnConfirmar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfirmar.setBounds(372, 478, 200, 61);
		panelRegistro2.add(btnConfirmar);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(253, 106, 259, 39);
		panelRegistro2.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(253, 168, 259, 39);
		panelRegistro2.add(textFieldApellido);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setColumns(10);
		textFieldDNI.setBounds(253, 242, 259, 39);
		panelRegistro2.add(textFieldDNI);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSexo.setBounds(47, 297, 170, 48);
		panelRegistro2.add(lblSexo);
		
		textFieldSexo = new JComboBox();
		textFieldSexo.setModel(new DefaultComboBoxModel(new String[] {"Hombre", "Mujer"}));
		textFieldSexo.setBounds(253, 306, 259, 39);
		panelRegistro2.add(textFieldSexo);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDni.setBounds(47, 238, 130, 43);
		panelRegistro2.add(lblDni);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido.setBounds(47, 163, 130, 48);
		panelRegistro2.add(lblApellido);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(47, 106, 109, 39);
		panelRegistro2.add(lblNombre);
		
		JLabel lblRegistroUsuario = new JLabel("Registro usuario 2");
		lblRegistroUsuario.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblRegistroUsuario.setBounds(189, 30, 269, 48);
		panelRegistro2.add(lblRegistroUsuario);
	
	}
}
