package controlador;

import clases.Modelo;
import conexion.ConexionAMySQL;
import interfaces.Ventana;

public class Launcher {

	public static void main(String[] args) {
		ConexionAMySQL conexion= new ConexionAMySQL("localhost","3306","reto3", "aplication", "PepeJeans");
		Modelo modelo = new Modelo(conexion);
		Ventana vista = new Ventana();
		
		
		@SuppressWarnings("unused")
		Controlador controlador = new Controlador(modelo, vista);
		vista.setVisible(true);

	}

}
