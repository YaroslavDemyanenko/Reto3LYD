package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JOptionPane;

import interfaces.Ventana;

public class Autobus {
	public int codigo;
	public int numPlazas;
	public double consumoKm;
	public String color;

	public Autobus(int codigo, int numPlazas, double consumoKm, String color) {
		this.codigo = codigo;
		this.numPlazas = numPlazas;
		this.consumoKm = consumoKm;
		this.color = color;
	}

	public Autobus() {
	}

	public void crearYMeterAutobuses(Modelo mod) {
		for (int i = 0; i < mod.lineas.size(); i++) {
			String consulta = "SELECT * FROM autobus WHERE Cod_bus IN(SELECT Cod_bus FROM `linea_autobus` WHERE cod_Linea IN(SELECT Cod_Linea FROM `linea` WHERE Cod_Linea=\"" + mod.lineas.get(i).getCodigo() + "\"))";
			ResultSet result = mod.db.hacerPeticion(consulta);
			try {
				while (result.next()) {
					mod.lineas.get(i).listaAutobuses.add(new Autobus(result.getInt("Cod_bus"), result.getInt("N_Plazas"), result.getDouble("Consumo_km"), result.getString("Color")));

				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error al crear autobuses", "Error", 0);
			}
		}
	}

	public int numeroPlazasRestantes(Modelo mod, Ventana vis) {

		try {
			//mod.billete.informacionGeneralBilletes(mod, vis);
			mod.billeteGeneralIda.linea.codigo="L1";
			String fecha = String.format("%1$tY-%1$tm-%1$td", vis.panelLineas2.calendarioIda.getDate());
			System.out.println(fecha);
			String consulta = "SELECT COUNT(*) FROM billete where Fecha='" + fecha + "' AND Cod_Linea='" + mod.billeteGeneralIda.linea.codigo + "')";
			ResultSet result = mod.db.hacerPeticion(consulta);
			int numBillIda = result.getInt(1);
			fecha = String.format("%1$tY-%1$tm-%1$td", vis.panelLineas2.calendarioVuelta.getDate());
			consulta = "SELECT COUNT(*) FROM billete where Fecha='" + fecha + "' AND Cod_Linea='" + mod.billeteGeneralIda.linea.codigo + "')";
			result = mod.db.hacerPeticion(consulta);
			int numBillVuelta = result.getInt(1);
			if (numBillIda >= numBillVuelta) {
				return numBillVuelta;
			} else
				return numBillIda;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

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
