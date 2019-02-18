package controlador;

import clases.Modelo;
import conexion.ConexionAMySQL;
import interfaces.Ventana;

/**
 * Main del programa que inicializa todos los elementos del mismo
 * @author Yaros
 *
 */
public class Launcher {

	public static void main(String[] args) {
		ConexionAMySQL conexion= new ConexionAMySQL();
		Modelo modelo = new Modelo(conexion);
		Ventana vista = new Ventana();
		
		
		@SuppressWarnings("unused")
		Controlador controlador = new Controlador(modelo, vista);
		vista.setVisible(true);

	}

}
