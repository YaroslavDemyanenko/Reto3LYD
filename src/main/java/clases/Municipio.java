package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Municipio {
<<<<<<< HEAD
	public String nombre;
	public int codigoPostal;
=======
	private String nombre;
	private int codigoPostal;
>>>>>>> e7df58b121cbdc9d496f9bff596361c27b314a73
	ArrayList<Parada> paradas = new ArrayList<Parada>();

	public Municipio() {

	}

	public Municipio(String nombre, int codigoPostal) {
		this.nombre = nombre;
		this.codigoPostal = codigoPostal;
	}

	/**
	 * Busca y mete los municipios de cada linea en su respectivo array, ademas, rellena los municipios con las paradas que lo componen
	 * @param lineas el arraylist donde se guardan las lineas
	 * @param mod modelo para utilizar funciones
	 * @throws NumberFormatException 
	 * @throws SQLException
	 */
	public void crearYMeterMunicipios(Modelo mod) throws NumberFormatException, SQLException {
		for (int i = 0; i < mod.lineas.size(); i++) {
			String consulta = "SELECT * FROM poblacion where Cod_Postal in(SELECT Cod_Postal from poblacion_parada where Cod_Parada IN(SELECT Cod_Parada FROM linea_parada where linea_parada.Cod_Linea=\"L" + Integer.toString(i + 1) + "\"))";
			ResultSet result = mod.db.hacerPeticion(consulta);
			int cont=0;
			while (result.next()) {
				mod.lineas.get(i).listaMunicipios.add(new Municipio(result.getString("Nombre"), result.getInt("Cod_Postal")));
				mod.lineas.get(i).listaMunicipios.get(cont).paradas=mod.parada.arrayParadasPorMunicipio(mod.lineas.get(i).listaMunicipios.get(cont).getNombre(),mod);
				cont++;
			}
		}
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodigoPostal() {
		return this.codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

}
