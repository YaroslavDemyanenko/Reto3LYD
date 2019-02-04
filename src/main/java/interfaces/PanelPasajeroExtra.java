package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
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
		setBounds(0,0,800,600);
		setBackground(new Color(193, 240, 240));
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		btnCancelar.setAlignmentY(Component.TOP_ALIGNMENT);
		btnCancelar.setBackground(new Color(192, 192, 192));
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setBounds(56, 527, 129, 35);
		add(btnCancelar);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		btnConfirmar.setAlignmentY(Component.TOP_ALIGNMENT);
		btnConfirmar.setBackground(new Color(192, 192, 192));
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConfirmar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfirmar.setBounds(655, 527, 129, 35);
		add(btnConfirmar);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldNombre.setBounds(348, 153, 259, 39);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(348, 217, 259, 39);
		add(textFieldApellido);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldDNI.setColumns(10);
		textFieldDNI.setBounds(348, 289, 259, 39);
		add(textFieldDNI);
		
		lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblSexo.setBounds(216, 344, 83, 48);
		add(lblSexo);
		
		textFieldSexo = new JComboBox();
		textFieldSexo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldSexo.setModel(new DefaultComboBoxModel(new String[] {"Hombre", "Mujer"}));
		textFieldSexo.setBounds(348, 351, 259, 39);
		add(textFieldSexo);
		
		lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblDni.setBounds(216, 285, 130, 43);
		add(lblDni);
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblApellido.setBounds(216, 210, 130, 48);
		add(lblApellido);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblNombre.setBounds(216, 151, 109, 39);
		add(lblNombre);
		
		lblRegistroUsuario = new JLabel("Registro pasajero extra");
		lblRegistroUsuario.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblRegistroUsuario.setBounds(235, 39, 330, 48);
		add(lblRegistroUsuario);
	
	}
	
	public void limpiar() {
		textFieldApellido.setText("");
		textFieldDNI.setText("");
		textFieldNombre.setText("");
	}
}
