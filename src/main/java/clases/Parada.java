package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.Ventana;

/**
 * Clase del objeto Parada
 * 
 * @author Yaros
 *
 */
public class Parada {

	public int codigo;
	public String calle;
	public String nombreParada;
	public double latitud;
	public double longitud;

	/**
	 * Constructor vacio
	 */
	public Parada() {

	}

	/**
	 * Constructor con todos los parametros
	 * @param codigo
	 * @param calle
	 * @param nombreParada
	 * @param latit
	 * @param longi
	 */
	public Parada(int codigo, String calle, String nombreParada, float latit, float longi) {
		this.codigo = codigo;
		this.calle = calle;
		this.nombreParada = nombreParada;
		this.latitud = latit;
		this.longitud = longi;
	}

	

	/**
	 * Saca las paradas por cada municipio y las mete al modelo
	 * @param nombreMunicipio nombre del municipio
	 * @param mod
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Parada> arrayParadasPorMunicipio(String nombreMunicipio, Modelo mod) throws SQLException {
		ArrayList<Parada> arrayParadas = new ArrayList<Parada>();
		String consulta = "SELECT * FROM `parada` WHERE Cod_Parada IN (SELECT Cod_Parada FROM `poblacion_parada` where Cod_Postal in(SELECT Cod_Postal from poblacion WHERE Nombre=\"" + nombreMunicipio + "\"))";
		ResultSet result = mod.db.hacerPeticion(consulta);
		while (result.next()) {
			arrayParadas.add(new Parada(result.getInt("Cod_Parada"), result.getString("Calle"), result.getString("Nombre"), result.getFloat("Latitud"), result.getFloat("Longitud")));
		}
		return arrayParadas;
	}

	/**
	 * Introduce las paradas al modelo de una lista
	 * 
	 * @param vis
	 * @param mod
	 * @throws SQLException
	 */
	public void paradasIdaAModelo(Ventana vis, Modelo mod) {
		String query = vis.panelLineas1.listLineas.getSelectedValue().toString().substring(0, 2);
		query = "select nombre,Cod_Parada,Calle,Latitud,Longitud,sqrt(power((longitud-(SELECT Longitud FROM `parada` where Nombre=\"Termibus-Bilbao\")),2)+power((latitud-(SELECT Latitud FROM `parada` where Nombre=\"Termibus-Bilbao\")),2)) distancia from parada WHERE Cod_Parada IN(SELECT Cod_Parada FROM linea_parada where linea_parada.Cod_Linea=\"" + query + "\") order by distancia;";
		ResultSet result = mod.db.hacerPeticion(query);
		mod.arrayParadas.clear();
		try {
			while (result.next()) {
				vis.panelLineas1.modeloParadas.addElement(result.getString("Nombre"));
				mod.arrayParadas.add(new Parada(result.getInt("Cod_Parada"), result.getString("Calle"), result.getString("Nombre"), result.getFloat("Latitud"), result.getFloat("Longitud")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		vis.panelLineas1.modeloParadas.removeElementAt(vis.panelLineas1.modeloParadas.size() - 1);
	}

	/**
	 * Introduce las paradas posibles de destino a una lista
	 * @param mod
	 * @param vis
	 */
	public void paradasLlegadaAModelo(Modelo mod, Ventana vis) {
		int index = vis.panelLineas1.listParadas.getSelectedIndex();
		vis.panelLineas2.modeloListaDestinos.clear();
		for (int i = index + 1; i < mod.arrayParadas.size(); i++) {
			vis.panelLineas2.modeloListaDestinos.addElement(mod.arrayParadas.get(i).nombreParada);
		}
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getnombreParada() {
		return nombreParada;
	}

	public void setnombreParada(String nombreParada) {
		this.nombreParada = nombreParada;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

}
