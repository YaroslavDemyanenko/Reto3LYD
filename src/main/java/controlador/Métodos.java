package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import bean.Usuario;
import clases.Cliente;
import formularios.frmBienvenida;
import funcionesYObjetos.Producto;
import manejoPanelesYBotones.Datos;
import mantenimientos.GestionUsuario;
import utils.MySQLConexion;

public class Métodos {

	public class GestionUsuario {
		

		public Cliente obtenerUsuario(Cliente usu){
			
			Cliente usuario = null;
			
			Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			
			try {
			
				con = MySQLConexion.getConexion();
			
				String sql = "select*from tb_usuario where usuario = ? and clave =  ? ";
				
				pst = con.prepareStatement(sql);
				
				pst.setString(1, usu.getNombre());
				pst.setString(2, usu.getApellido());
				pst.setString(3, usu.getDni());
				pst.setString(4, usu.getSexo());
				pst.setString(5, usu.getContrasenia());
				
				rs = pst.executeQuery();
				
				while (rs.next()) {
					usuario = new Cliente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
					
				}
				
				
				
			} catch (Exception e) {
			System.out.println("Error en obtener usuario");
			}
			
			
			return usuario;
			
		}
	
	public void ingresar() {

		String nombre = textFieldNombre.getText();
		String apellido = textFieldApellido.getText();
		String dni = textFieldDNI.getText();
		String sexo = textFieldSexo.getText();
		String contrasenia = textFieldContrasenia.getText();

		GestionUsuario gestionUsuario = new GestionUsuario();

		Cliente cliente = new Cliente();
		cliente.setNombre(nombre);
		cliente.setApellido(apellido);
		cliente.setDni(dni);
		cliente.setSexo(sexo);
		cliente.setContrasenia(contrasenia);

		Cliente usu = gestionUsuario.obtenerUsuario(usuario2);

		if (usu != null) {
			JOptionPane.showMessageDialog(contentPane, "Bienvenido");

			this.dispose();
			
			frmBienvenida bienvenida = new frmBienvenida();
			bienvenida.setVisible(true);

		} else {
			JOptionPane.showMessageDialog(contentPane, "Datos invalidos", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	/**
	---------------------------------------------------------------------------------------------------------------------------------------------------------------------
	*/
	
	/**
	 * Funciones y metodos relacionados con el pago de los productos.
	 * 
	 *
	 */
	public class FuncionesPago {

		NumberFormat nf = NumberFormat.getNumberInstance(Locale.UK);
		private DecimalFormat dosDec = (DecimalFormat) nf;

		/**
		 * Comprueba todas las cantidades del parametro inventario y si es mayor que 0.
		 * Calcula el precio a pagar.
		 * 
		 * @param inventario Array de objetos de tipo Producto.
		 * @return devuelve el precio total sin IVA (Dinero que debe pagar el cliente).
		 */
		public float PrecioAPagar(Producto[] inventario) {
			float resultado = 0;
			for (int i = 0; i < inventario.length; i++) {
				if (inventario[i].cantidad > 0) {
					resultado = resultado + inventario[i].cantidad * inventario[i].precio;
				}
			}
			return resultado;
		}

		/**
		 * Dandole un numero y un modelo de lista nos hace una lista del cambio de la forma mas optima (menor numero de monedas).
		 * @param model		El modelo en el cual se guarda la lista de cambios.
		 * @param dinero	El numero con el cual tiene que calcular el cambio.
		 */
		public void Cambios(DefaultListModel model, float dinero) {
			int euros = (int) dinero;
			int decimales = Math.round((dinero - euros) * 100);
			int[] billetesMonedas = { 500, 200, 100, 50, 20, 10, 5, 2, 1 };
			Datos.dosDecFormato(dosDec);
			
			for (int i = 0, f = 0,fake=1; i < billetesMonedas.length+fake;i++,f++) {
				//Mira si tiene que pasar a calcular los decimales
				if (f==9) {
					i=3;
					fake=0;
				}
				//Calcula los euros
				if (euros >= billetesMonedas[i] && f < 9) {
					model.addElement(billetesMonedas[i] + " €: " + (euros / billetesMonedas[i]));
					euros = euros % billetesMonedas[i];
				}
				//Calcula los centimos si ha acabado con los euros
				else if (decimales >= billetesMonedas[i] && f >= 9) {
					model.addElement((dosDec.format(billetesMonedas[i]/100f)) + " €: " + (decimales / billetesMonedas[i]));
					decimales = decimales % billetesMonedas[i];
				}
			}
		}

	}	
	
	/**
	---------------------------------------------------------------------------------------------------------------------------------------------------------------------
	*/
	
	
	
}
