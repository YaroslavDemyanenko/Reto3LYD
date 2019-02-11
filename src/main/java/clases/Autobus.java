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
			mod.billete.informacionGeneralBilletes(mod, vis);
			String linea = mod.billeteGeneralIda.linea.codigo;
			String fechaIda = String.format("%1$tY-%1$tm-%1$td", mod.billeteGeneralIda.fecha);
			String fechaVuelta = null;
			boolean hayVuelta = mod.isIdaYVuelta();
			int numBillIda, numBillVuelta = 0;

			String consulta = "SELECT COUNT(*) FROM billete where Fecha='" + fechaIda + "' AND Cod_Linea='" + linea + "'";
			ResultSet result = mod.db.hacerPeticion(consulta);
			result.first();
			numBillIda = result.getInt(1);

			if (hayVuelta) {
				fechaVuelta = String.format("%1$tY-%1$tm-%1$td", mod.billeteGeneralVuelta.fecha);
				consulta = "SELECT COUNT(*) FROM billete where Fecha='" + fechaVuelta + "' AND Cod_Linea='" + linea + "'";
				result = mod.db.hacerPeticion(consulta);
				result.first();
				numBillVuelta = result.getInt(1);
			}

			consulta = "SELECT * FROM autobus WHERE Cod_bus IN(SELECT Cod_bus FROM linea_autobus WHERE Cod_Linea='" + linea + "') AND N_plazas>" + numBillIda;
			result = mod.db.hacerPeticion(consulta);
			int plazasRestantesIda = 0;
			int plazasRestantesVuelta = 0;
			result.beforeFirst();
			while (result.next()) {
				plazasRestantesIda += result.getInt("N_plazas") - numBillIda;
				if (hayVuelta) {
					plazasRestantesVuelta += result.getInt("N_plazas") - numBillVuelta;
					if (plazasRestantesIda > 0 && plazasRestantesVuelta > 0) {
						mod.billeteGeneralIda.codAutobus=result.getInt("Cod_bus");
						mod.billeteGeneralVuelta.codAutobus=result.getInt("Cod_bus");
						break;
					}
				} else if (plazasRestantesIda > 0) {
					mod.billeteGeneralIda.codAutobus=result.getInt("Cod_bus");
					break;
				}
			}
			if ((!hayVuelta && plazasRestantesIda < 0) || (hayVuelta && (plazasRestantesIda < 0 || plazasRestantesVuelta <0))) {
				JOptionPane.showMessageDialog(null, "No quedan billetes para este dia, seleccione otro dia", "Billetes agotados", JOptionPane.WARNING_MESSAGE);
				return 0;
			}

			if (hayVuelta && fechaIda.equals(fechaVuelta)) {
				if (plazasRestantesVuelta % 2 == 0) {
					return plazasRestantesVuelta / 2;
				} else
					return (plazasRestantesVuelta - 1) / 2;
			} else if (hayVuelta) {
				if (plazasRestantesIda >= plazasRestantesVuelta) {
					return plazasRestantesVuelta;
				} else {
					return plazasRestantesIda;
				}
			} else if (!hayVuelta) {
				return plazasRestantesIda;
			}
			return 0;
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
