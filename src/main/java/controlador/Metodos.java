package controlador;

import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;

import clases.Cliente;
import clases.Modelo;
import interfaces.Ventana;


public class Metodos{

	public Cliente ingresar(String nombre, String apellido, String dni, String sexo, String contrasenia) {
		
		Cliente cliente = new Cliente();
		cliente.setNombre(nombre);
		cliente.setApellido(apellido);
		cliente.setDni(dni);
		cliente.setSexo(sexo);
		cliente.setContrasenia(contrasenia);
		return cliente;

	}
	
	public void limitarFechasIda(Ventana vis,int numDias) {
		Date fechaLimite=new Date();
		vis.panelLineas2.calendarioIda.setDate(new Date());
		Calendar c = Calendar.getInstance();
		c.setTime(fechaLimite);
		c.add(Calendar.DATE,numDias);
		fechaLimite=c.getTime();
		vis.panelLineas2.calendarioIda.setSelectableDateRange(new Date(),fechaLimite);
	}
	public void limitarFechasVuelta(Ventana vis,int numDias) {
		Date fechaLimite=vis.panelLineas2.calendarioIda.getDate();
		vis.panelLineas2.calendarioVuelta.setDate(fechaLimite);
		Calendar c = Calendar.getInstance();
		c.setTime(fechaLimite);
		c.add(Calendar.DATE,numDias);
		fechaLimite=c.getTime();
		vis.panelLineas2.calendarioVuelta.setSelectableDateRange(vis.panelLineas2.calendarioIda.getDate(),fechaLimite);
	}
	
	public void mostrarResumenTrayecto(Ventana vis,Modelo mod) {
		vis.panelResumen.lblNombreLinea.setText(vis.panelLineas2.lblNombreLinea.getText());
		vis.panelResumen.lblNombrePardaInicio.setText(vis.panelLineas2.lblSal.getText());
		vis.panelResumen.lblNombreParadaFin.setText(vis.panelLineas2.modeloListaDestinos.getElementAt(vis.panelLineas2.listaDestinos.getSelectedIndex()));
		//vis.panelResumen.lblTipoDeTrayecto.setText(if(mod.isIdaYVuelta()) {"Ida y vuelta"}else {"Ida"} );
		
	}
	
	public boolean comprobarDNIenBD(Modelo mod, Cliente cliente) {

		ResultSet rs = null;
		boolean estaRegistrado = true;
		
		/*Comparamos si el DNI insertado consta en la base de datos o no y hay que añadirlo*/
		try {
			String sql = "select DNI from cliente where DNI = " + cliente.getDni();
			rs = mod.db.hacerPeticion(sql);
			/* Si ya existe en la base de datos devuelve un true*/
			if (rs.next()) {
				estaRegistrado = true;
			} 
			/* Si no esta en la base de datos devuelve un false y lo mete en la base de datos  */
			else estaRegistrado = false;
			String sql1 = "insert into DNI values (" + estaRegistrado + ")";
			
		} catch (Exception e) {
			System.out.println("Error en obtener usuario");
		}
		
		return estaRegistrado;
		
	}
	
	public void registrarEnBD(Modelo mod, Cliente cliente) {
		/* Registramos todos los par�metros menos el DNI que lo hemos insertado anteriormente*/
		String sql1 = "insert into Nombre, Apellidos, Sexo, Contrase�a, Fecha_nac values ('" + cliente.getNombre() + "','" + 
					cliente.getApellido() + "','"+ cliente.getSexo()+ "','"+ cliente.getContrasenia() + "','" + 
					cliente.getFecha_nac() + ")";
	}

	public void Login(Modelo mod,String dni, String contrasenia) {
		
		Boolean login = false;
		String LoginDB = "";

		try {

			ResultSet rs;
			
			/*llamamos a la base de datos el DNI y la contrase�a del cliente*/
			LoginDB = "select DNI,Contrase�a from cliente";


			rs = mod.db.hacerPeticion(LoginDB);

			/*Comparamos los datos de la base de datos con los que ha introducido en el login el cliente*/
			if (rs.getString("DNI") == dni){
				/*Este es el caso �ptimo donde tanto el DNI y la contrase�a existen y corresponden al mismo usuario*/
				if(rs.getString("Contrase�a")== contrasenia) {
				login = true;
				}
				/*En este caso el DNI es correcto pero la contrase�a que corresponde a ese usuario es err�nea*/
				else {
					System.out.println("Contraseña incorrecta");
					login = false;
				}
			}
			/*En este caso el DNI que ha metido no est� registrado en la BD*/
			else {
				System.out.println(" Usuario inexistente");
				login = false;
			}

		} catch (Exception e) {
			System.out.println("Error en obtener usuario");
		}

	}
	
	public void PasajeroExtra(Modelo mod, String dni, String nombre, String apellido, String sexo, int CantidadPasajeros) {
		
		Cliente pasajeroExtra[]=new Cliente[CantidadPasajeros];		
		
		/* Genera clientes extra en base a la cantidad de pasajeros extra*/
		while (CantidadPasajeros>0) {
			pasajeroExtra[CantidadPasajeros]=new Cliente (nombre,apellido,dni, sexo);
			CantidadPasajeros=CantidadPasajeros-1;
		}
	}		

}



/**
 * ---------------------------------------------------------------------------------------------------------------------------------------------------------------------
 */

/**
 * Funciones y metodos relacionados con el pago de los productos.
 * 
 *
 */

/*
 * public class FuncionesPago {
 * 
 * NumberFormat nf = NumberFormat.getNumberInstance(Locale.UK); private
 * DecimalFormat dosDec = (DecimalFormat) nf;
 * 
 * 
 **/

/**
 * Comprueba todas las cantidades del parametro inventario y si es mayor que 0.
 * Calcula el precio a pagar.
 * 
 * @param inventario Array de objetos de tipo Producto.
 * @return devuelve el precio total sin IVA (Dinero que debe pagar el cliente).
 */

/*
 * public float PrecioAPagar(Producto[] inventario) { float resultado = 0; for
 * (int i = 0; i < inventario.length; i++) { if (inventario[i].cantidad > 0) {
 * resultado = resultado + inventario[i].cantidad * inventario[i].precio; } }
 * return resultado; }
 **/

/**
 * Dandole un numero y un modelo de lista nos hace una lista del cambio de la
 * forma mas optima (menor numero de monedas).
 * 
 * @param model  El modelo en el cual se guarda la lista de cambios.
 * @param dinero El numero con el cual tiene que calcular el cambio.
 */

/*
 * public void Cambios(DefaultListModel model, float dinero) { int euros = (int)
 * dinero; int decimales = Math.round((dinero - euros) * 100); int[]
 * billetesMonedas = { 500, 200, 100, 50, 20, 10, 5, 2, 1 };
 * Datos.dosDecFormato(dosDec);
 * 
 * for (int i = 0, f = 0,fake=1; i < billetesMonedas.length+fake;i++,f++) {
 * //Mira si tiene que pasar a calcular los decimales if (f==9) { i=3; fake=0; }
 * //Calcula los euros if (euros >= billetesMonedas[i] && f < 9) {
 * model.addElement(billetesMonedas[i] + " �: " + (euros / billetesMonedas[i]));
 * euros = euros % billetesMonedas[i]; } //Calcula los centimos si ha acabado
 * con los euros else if (decimales >= billetesMonedas[i] && f >= 9) {
 * model.addElement((dosDec.format(billetesMonedas[i]/100f)) + " �: " +
 * (decimales / billetesMonedas[i])); decimales = decimales %
 * billetesMonedas[i]; } } }
 * 
 **/

/**
 * ---------------------------------------------------------------------------------------------------------------------------------------------------------------------
 */
