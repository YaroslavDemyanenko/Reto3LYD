package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class Autobus {
	private int codigo;
	
	private int numPlazas;
	private double consumoKm;
	private String color;
	
	public Autobus(int codigo, int numPlazas, double consumoKm, String color) {
		this.codigo = codigo;
		this.numPlazas = numPlazas;
		this.consumoKm = consumoKm;
		this.color = color;
	}
	
	public void crearYMeterAutobuses(Modelo mod) throws NumberFormatException, SQLException {
		for (int i = 0; i < mod.lineas.size(); i++) {
			String consulta = "SELECT * FROM autobus WHERE Cod_bus IN(SELECT Cod_bus FROM `linea_autobus` WHERE cod_Linea IN(SELECT Cod_Linea FROM `linea` WHERE Cod_Linea=\""+mod.lineas.get(i).codigo+"\"))";
			ResultSet result = mod.db.hacerPeticion(consulta);
			while (result.next()) {
				mod.lineas.get(i).listaAutobuses.add(new Autobus(result.getInt("Cod_bus"),result.getInt("N_Plazas"),result.getDouble("Consumo_km"),result.getString("Color")));
				
			}
		}
	}
	
	public Autobus() {}

	public int getCodigo() {
		return this.codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getNumPlazas() {
		return this.numPlazas;
	}
	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}
	public double getConsumoKm() {
		return this.consumoKm;
	}
	public void setConsumoKm(double consumoKm) {
		this.consumoKm = consumoKm;
	}
	public String getColor() {
		return this.color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
