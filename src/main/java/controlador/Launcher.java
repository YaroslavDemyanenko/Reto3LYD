package controlador;

import java.sql.Connection;

import clases.Modelo;
import interfaces.Ventana;
import conexion.*;

public class Launcher {

	public static void main(String[] args) {
		ConexionAMySQL conexion= new ConexionAMySQL("termibus", "hr", "PepeJeans");
		Modelo modelo = new Modelo(conexion);
		Ventana vista = new Ventana();
		
		
		Controlador controlador = new Controlador(modelo, vista);
		vista.setVisible(true);

	}

}
