package mundo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import VentaLogica.Cliente;
import VentaLogica.Tarjeta;
import VentaLogica.Tiquete;
import aeronaveData.DatosAeronave;
import aeronaveInterface.VentanaAeronave;
import aeronaveLogica.Aeronave;
import aeronaveLogica.DistribucionSillas;
import aeronaveLogica.TipoAeronave;
import tripulacionData.DatosTripulacion;
import tripulacionData.DatosTripulante;
import tripulacionLogica.Tripulacion;
import tripulacionLogica.Tripulante;
import vueloData.DatosRuta;
import vueloLogica.Ruta;
import vueloLogica.Vuelo;

public class CaribeAirlines {
	private List<Aeronave> misAeronaves;
	private List<TipoAeronave> misTipoAeronave;
	private List<Vuelo> misVuelos;
	private List<Ruta> misRutas;
	private List<Tripulacion> misTripulaciones;
	private List<Tripulante> misTripulantes;
	private List<Cliente> misClientes;
	private List<Tarjeta> tarjetas;
	private List<Tiquete> misTiquetes;

	// Constructor
	public CaribeAirlines() {
		misAeronaves = new ArrayList<>();
		misTipoAeronave = new ArrayList<>();
		misTripulantes = new ArrayList<>();
		misTripulaciones = new ArrayList<>();
		misVuelos = new ArrayList<>();
		misRutas = new ArrayList<>();
		misClientes = new ArrayList<>();
		tarjetas = new ArrayList<Tarjeta>();
		misTiquetes = new ArrayList<Tiquete>();

		Origen creaciones = new Origen(this);

		creaciones.crearMisRutas(); // SOLO SE DEBE DE EJECUTAR UNA PRIMERA VEZ, ya que queda guardado en el
									// archivo.txt

		creaciones.crearMisTipoAeronave();// SOLO SE DEBE DE EJECUTAR UNA PRIMERA VEZ, ya que queda guardado en el
											// archivo.txt
		creaciones.crearMisAviones(); // SOLO SE DEBE DE EJECUTAR UNA PRIMERA VEZ, ya que queda guardado en el
										// archivo.txt

		creaciones.crearMisTripulantes();// SOLO SE DEBE DE EJECUTAR UNA PRIMERA VEZ, ya que queda guardado en el
											// archivo.txt
		creaciones.crearMisTripulaciones();// SOLO SE DEBE DE EJECUTAR UNA PRIMERA VEZ, ya que queda guardado en el
											// archivo.txt

		creaciones.crearMisVuelos();

		creaciones.RegistroVuelos();

		creaciones.crearMisClientes();
		System.out.println("Debio creear las tarjetas ");
		creaciones.crearTarjetasClientes();
	}

	public List<Aeronave> obtenerAeronaveFiltro(String tipoVuelo) {
		List<Aeronave> misAeronavesFiltradas = new ArrayList<>();
		for (int i = 0; i < misAeronaves.size(); i++) {
			if (misAeronaves.get(i).getTipoAeronave().getAtributos().get("TipoVuelo").equals(tipoVuelo)) {
				misAeronavesFiltradas.add(misAeronaves.get(i));
			}
		}
		return misAeronavesFiltradas;
	}

	public List<Ruta> obtenerRutasFiltro(String tipoVuelo) {
		List<Ruta> misRutasFiltradas = new ArrayList<>();
		for (int i = 0; i < misRutas.size(); i++) {
			if (misRutas.get(i).getAtributos().get("Tipo vuelo").equals(tipoVuelo)) {
				misRutasFiltradas.add(misRutas.get(i));
			}
		}
		return misRutasFiltradas;
	}

	public int contarCantidadDeTripulantesDeMismoCargoEnUnaTripulacion(String cargo, List<Tripulante> miTripulacion) {
		int j = 0;
		for (int i = 0; i < miTripulacion.size(); i++) {
			if (miTripulacion.get(i).getAtributos().get("Cargo").equalsIgnoreCase(cargo)) {
				j++;
			}
		}
		return j;
	}

	public void eliminarPorIdTripulante(String identificacion) {
		List<Tripulante> misNuevosTripulantes = new ArrayList<>();
		for (int i = 0; i < misTripulantes.size(); i++) {
			if (misTripulantes.get(i).getAtributos().get("Identificacion").equals(identificacion)) {
				System.out.println("encontrado");
			} else {
				misNuevosTripulantes.add(misTripulantes.get(i));
			}
		}
		this.setMisTripulantes(misNuevosTripulantes);
	}

	public void eliminarPorIdTripulacion(String idTripulacion) {
		List<Tripulacion> misNuevasTripulaciones = new ArrayList<>();
		for (int i = 0; i < misTripulaciones.size(); i++) {
			if (misTripulaciones.get(i).getMiTripulacion().get("IdTripulacion").equals(idTripulacion)) {
				System.out.println("encontrado");
			} else {
				misNuevasTripulaciones.add(misTripulaciones.get(i));
			}
		}
		this.setMisTripulaciones(misNuevasTripulaciones);
	}

	public List<Tripulante> obtenerListadoFiltroTripulantes(String cargo) {
		List<Tripulante> miTripulantesFiltrados = new ArrayList<>();
		for (int i = 0; i < misTripulantes.size(); i++) {
			if (misTripulantes.get(i).getAtributos().get("Cargo").equalsIgnoreCase(cargo)) {
				miTripulantesFiltrados.add(misTripulantes.get(i));
			}
		}
		return miTripulantesFiltrados;
	}

	public List<Tripulacion> obtenerListadoFiltroTripulaciones(String tipoTripulacion) {
		List<Tripulacion> miTripulantesFiltrados = new ArrayList<>();
		for (int i = 0; i < misTripulaciones.size(); i++) {
			if (misTripulaciones.get(i).getTipoTripulacion().equals(tipoTripulacion)) {
				miTripulantesFiltrados.add(misTripulaciones.get(i));
			}
		}
		return miTripulantesFiltrados;
	}

	public String[][] filtrarTripulante(String cargo) {
		int row = 0;
		for (int i = 0; i < misTripulantes.size(); i++) {
			if (misTripulantes.get(i).getAtributos().get("Cargo").equalsIgnoreCase(cargo)) {
				row++;
			}
		}
		String[][] tabla = new String[row][3];
		int j = 0;
		for (int i = 0; i < misTripulantes.size(); i++) {
			if (misTripulantes.get(i).getAtributos().get("Cargo").equalsIgnoreCase(cargo)) {
				tabla[j][0] = misTripulantes.get(i).getAtributos().get("Nombre");
				tabla[j][1] = misTripulantes.get(i).getAtributos().get("Identificacion");
				tabla[j][2] = misTripulantes.get(i).getAtributos().get("Cargo");
				j++;
			}
		}
		return tabla;
	}

	public String[][] filtrarTripulacion(String tipoTripulacion) {
		int row = 0;
		for (int i = 0; i < misTripulaciones.size(); i++) {
			if (misTripulaciones.get(i).getTipoTripulacion().equals(tipoTripulacion)) {
				row++;
			}
		}
		String[][] tabla = new String[row][3];
		int j = 0;
		for (int i = 0; i < misTripulaciones.size(); i++) {
			if (misTripulaciones.get(i).getTipoTripulacion().equals(tipoTripulacion)) {
				tabla[j][0] = misTripulaciones.get(i).getPiloto().getAtributos().get("Nombre");
				tabla[j][1] = misTripulaciones.get(i).getCopiloto().getAtributos().get("Nombre");
				tabla[j][2] = misTripulaciones.get(i).toStringAuxiliares();
				j++;
			}
		}
		return tabla;
	}

	public List<Aeronave> ordenarFlotaPorTipoAeronave(int tipoAeronave) {
		List<Aeronave> flota = new ArrayList<>();
		String idTipoAeronave = "";
		if (tipoAeronave == 0) {
			idTipoAeronave = "air001";
		} else if (tipoAeronave == 1) {
			idTipoAeronave = "air002";
		} else if (tipoAeronave == 2) {
			idTipoAeronave = "air003";
		} else {
			System.out.println("ERROR, metodo ordenar flota por tipo aeronave");
		}
		for (int i = 0; i < misAeronaves.size(); i++) {
			if (misAeronaves.get(i).getTipoAeronave().getAtributos().get("IdTipoAeronave").equals(idTipoAeronave)) {
				flota.add(misAeronaves.get(i));
			}
		}
		return flota;
	}

	public String[][] llenarTablaDeDatosMasDetallesTripulante(Tripulante miTripulante) {
		String[][] tabla = new String[miTripulante.getAtributos().size()][2];
		int i = 0;
		for (Iterator it = miTripulante.getAtributos().keySet().iterator(); it.hasNext();) {
			tabla[i][0] = (String) it.next();// key
			tabla[i][1] = (String) miTripulante.getAtributos().get(tabla[i][0]);// value
			i++;
		}
		return tabla;
	}

	public String[][] llenarTablaDeDatosMasDetallesTripulacion(Tripulacion miTripulacion) {
		int row = miTripulacion.getMisVuelos().size() + miTripulacion.getAuxiliares().size() + 2 + 1 + 1;
		String[][] tabla = new String[row][2];

		tabla[0][0] = "idTripulacion";
		tabla[0][1] = "Trip" + miTripulacion.getMiTripulacion().get("IdTripulacion");
		tabla[1][0] = "Piloto";
		tabla[1][1] = miTripulacion.getMiTripulacion().get("Piloto");
		tabla[2][0] = "Copiloto";
		tabla[2][1] = miTripulacion.getMiTripulacion().get("Copiloto");

		List<String> mostrar = new ArrayList<>();
		String palabra = "";
		for (int j = 0; j < miTripulacion.cadenaAuxiliares().length(); j++) {
			if (miTripulacion.cadenaAuxiliares().charAt(j) == ',') {
				mostrar.add(palabra);
				palabra = "";
			} else {
				palabra += miTripulacion.cadenaAuxiliares().charAt(j);
			}
		}

		for (int j = 3; j < miTripulacion.getAuxiliares().size() + 2; j++) {
			tabla[j][0] = "auxiliar " + (j - 1);
			tabla[j][1] = mostrar.get(j - 2);
		}

		tabla[3 + miTripulacion.getAuxiliares().size()][0] = "Tipo Tripulacion";
		tabla[3 + miTripulacion.getAuxiliares().size()][1] = miTripulacion.getTipoTripulacion();

		int i = 0;

		for (int j = 3 + miTripulacion.getAuxiliares().size() + 1; j < tabla.length; j++) {
			tabla[j][0] = "Vuelo " + (i + 1);
			tabla[j][1] = miTripulacion.getMisVuelos().get(i).getMiRuta().getAtributos().get("Origen") + " / "
					+ miTripulacion.getMisVuelos().get(i).getMiRuta().getAtributos().get("Destino");
			i++;
		}

		return tabla;
	}

	public String[][] llenarTablaDeDatosTripulaciones() {
		String[][] tabla = new String[misTripulaciones.size()][3];
		for (int i = 0; i < misTripulaciones.size(); i++) {
			tabla[i][0] = misTripulaciones.get(i).getPiloto().getAtributos().get("Nombre");
			tabla[i][1] = misTripulaciones.get(i).getCopiloto().getAtributos().get("Nombre");
			tabla[i][2] = misTripulaciones.get(i).toStringAuxiliares();
		}
		return tabla;
	}

	public String[][] llenarTablaDeDatosTripulantes() {
		String[][] tabla = new String[misTripulantes.size()][3];
		for (int i = 0; i < misTripulantes.size(); i++) {
			tabla[i][0] = misTripulantes.get(i).getAtributos().get("Nombre");
			tabla[i][1] = misTripulantes.get(i).getAtributos().get("Identificacion");
			tabla[i][2] = misTripulantes.get(i).getAtributos().get("Cargo");
		}
		return tabla;
	}

	public String[][] llenarTablaDeDatosVuelo(int posOpcion) {
		String tipoVuelo = "";
		int tamano = 0;

		if (posOpcion == 0) {
			tipoVuelo = "Nacional";
		} else if (posOpcion == 1) {
			tipoVuelo = "Internacional";
		}

		for (int i = 0; i < misVuelos.size(); i++) {
			if (misVuelos.get(i).getMiRuta().getAtributos().get("Tipo vuelo").equalsIgnoreCase(tipoVuelo)) {
				tamano++;
			}
		}

		String[][] tabla = new String[tamano][3];

		int j = 0;
		for (int i = 0; i < misVuelos.size(); i++) {
			if (misVuelos.get(i).getMiRuta().getAtributos().get("Tipo vuelo").equalsIgnoreCase(tipoVuelo)) {
				tabla[j][0] = misVuelos.get(i).getAtributos().get("Fecha");
				tabla[j][1] = misVuelos.get(i).getMiRuta().getAtributos().get("Origen");
				tabla[j][2] = misVuelos.get(i).getMiRuta().getAtributos().get("Destino");
				j++;
			}

		}
		return tabla;
	}

	public String[][] llenarTablaDeDatosAeronave(int opcion) {
		HashMap<String, Object> datos = misTipoAeronave.get(opcion).getAtributos();
		int filas = datos.size();
		String[][] tabla = new String[filas][2];
		int i = 0;
		for (Iterator it = datos.keySet().iterator(); it.hasNext();) {
			tabla[i][0] = (String) it.next();// key
			tabla[i][1] = (String) datos.get(tabla[i][0]);// value
			i++;
		}
		return tabla;
	}

	public String[][] llenarTablaDeMasDetalles(Vuelo miVuelo) {
		int row = miVuelo.getAtributos().size() + miVuelo.getMiRuta().getAtributos().size()
				+ miVuelo.getMiTripulacion().getAuxiliares().size() + 2;
		System.out.println("vuelo"+miVuelo.getAtributos().size());
		System.out.println("ruta"+ miVuelo.getMiRuta().getAtributos().size());
		System.out.println("tripulacion"+ miVuelo.getMiTripulacion().getAuxiliares().size());
		String[][] datos = new String[row][2];
		int i = 0;
		for (Iterator it = miVuelo.getAtributos().keySet().iterator(); it.hasNext();) {
			datos[i][0] = (String) it.next();// key
			datos[i][1] = (String) miVuelo.getAtributos().get(datos[i][0]);// value
			i++;
		}
		for (Iterator it = miVuelo.getMiRuta().getAtributos().keySet().iterator(); it.hasNext();) {
			datos[i][0] = (String) it.next();// key
			datos[i][1] = (String) miVuelo.getMiRuta().getAtributos().get(datos[i][0]);// value
			i++;
		}
		String auxiliares = miVuelo.getMiTripulacion().getMiTripulacion().get("Auxiliares");
		List<String> mostrar = new ArrayList<>();
		String palabra = "";
		for (int j = 0; j < auxiliares.length(); j++) {
			if (auxiliares.charAt(j) == ',') {
				mostrar.add(palabra);
				palabra = "";
			} else {
				palabra += auxiliares.charAt(j);
			}
		}
		datos[miVuelo.getAtributos().size() + miVuelo.getMiRuta().getAtributos().size()][0] = "Piloto";
		datos[miVuelo.getAtributos().size() + miVuelo.getMiRuta().getAtributos().size()][1] = miVuelo.getMiTripulacion()
				.getMiTripulacion().get("Piloto");
		datos[miVuelo.getAtributos().size() + miVuelo.getMiRuta().getAtributos().size() + 1][0] = "Copiloto";
		datos[miVuelo.getAtributos().size() + miVuelo.getMiRuta().getAtributos().size() + 1][1] = miVuelo
				.getMiTripulacion().getMiTripulacion().get("Copiloto");

		i = 1;
		for (int j = miVuelo.getAtributos().size() + miVuelo.getMiRuta().getAtributos().size()
				+ 2; j < datos.length; j++) {
			datos[j][0] = "auxiliar " + i;
			datos[j][1] = mostrar.get(i - 1);
			i++;
		}

		return datos;
	}

	public boolean agregarCliente(Cliente c) {
		System.out.println("Lo agrego " + misClientes.size());
		Iterator<Cliente> it = misClientes.iterator();
		while (it.hasNext()) {
			Cliente cliente = (Cliente) it.next();
			if (cliente.getIdentificacion().equals(c.getIdentificacion())) {
				JOptionPane.showMessageDialog(null,
						"El cliente con la identificacion " + c.getIdentificacion() + " ya existe. No se guarda.");
				return false;
			}
		}
		misClientes.add(c);
		return true;
	}

	public boolean crearTripulante(Tripulante miTripulante) {// si lo encuentra true
		boolean centinela = false;
		String identificacion = miTripulante.getAtributos().get("Identificacion");
		for (int i = 0; i < misTripulantes.size() && centinela == false; i++) {
			if (misTripulantes.get(i).getAtributos().get("Identificacion").equals(identificacion)) {
				centinela = true;
			}
		}
		if (centinela == true) {
			return false;
		} else {
			misTripulantes.add(miTripulante);
			return true;
		}
	}

	public boolean crearVuelo(Vuelo miVueloAgregado) {
		misVuelos.add(miVueloAgregado);
		return true;
	}

	public boolean crearTripulacion(List<Tripulante> miTripulacionAgregada, String tipoTripulacion) {
		List<Tripulante> auxiliares = new ArrayList<>();
		int numeroAuxiliares = 0;
		int numeroPilotos = 0;
		int numeroCopilotos = 0;
		Tripulante piloto = null;
		Tripulante copiloto = null;

		for (int i = 0; i < miTripulacionAgregada.size(); i++) {
			if (miTripulacionAgregada.get(i).getAtributos().get("Cargo").equalsIgnoreCase("piloto")) {
				piloto = miTripulacionAgregada.get(i);
				numeroPilotos++;
			}
			if (miTripulacionAgregada.get(i).getAtributos().get("Cargo").equalsIgnoreCase("copiloto")) {
				copiloto = miTripulacionAgregada.get(i);
				numeroCopilotos++;
			}
			if (miTripulacionAgregada.get(i).getAtributos().get("Cargo").equalsIgnoreCase("auxiliar")) {
				auxiliares.add(miTripulacionAgregada.get(i));
				numeroAuxiliares++;
			}
		}
		if ((tipoTripulacion.equalsIgnoreCase("Nacional") && numeroAuxiliares == 3
				|| tipoTripulacion.equalsIgnoreCase("Internacional") && numeroAuxiliares == 7) && numeroPilotos == 1
				&& numeroCopilotos == 1) {
			String id = misTripulaciones.get(misTripulaciones.size() - 1).getMiTripulacion().get("IdTripulacion");
			int identificacion = Integer.parseInt(id) + 1;
			Tripulacion miTripulacion = new Tripulacion(String.valueOf(identificacion), piloto, copiloto, auxiliares,
					tipoTripulacion);
			miTripulacion.setMisVuelos(new ArrayList<Vuelo>());
			misTripulaciones.add(miTripulacion);
			return true;
		}
		return false;
	}

	// Getter & Setter
	public List<Aeronave> getMisAeronaves() {
		return misAeronaves;
	}

	public void setMisAeronaves(List<Aeronave> misAeronaves) {
		this.misAeronaves = misAeronaves;
	}

	public List<Ruta> getMisRutas() {
		return misRutas;
	}

	public void setMisRutas(List<Ruta> misRutas) {
		this.misRutas = misRutas;
	}

	public List<Tripulacion> getMisTripulaciones() {
		return misTripulaciones;
	}

	public void setMisTripulaciones(List<Tripulacion> misTripulaciones) {
		this.misTripulaciones = misTripulaciones;
	}

	public List<Tripulante> getMisTripulantes() {
		return misTripulantes;
	}

	public void setMisTripulantes(List<Tripulante> misTripulantes) {
		this.misTripulantes = misTripulantes;
	}

	public List<TipoAeronave> getMisTipoAeronave() {
		return misTipoAeronave;
	}

	public void setMisTipoAeronave(List<TipoAeronave> misTipoAeronave) {
		this.misTipoAeronave = misTipoAeronave;
	}

	public List<Vuelo> getMisVuelos() {
		return misVuelos;
	}

	public void setMisVuelos(List<Vuelo> misVuelos) {
		this.misVuelos = misVuelos;
	}

	public void setMisTarjetas(List<Tarjeta> tarj) {
		this.tarjetas = tarj;
	}

	public List<Tarjeta> getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(List<Tarjeta> tarjetas) {
		System.out.println("Se guardaron las tarjetas " + tarjetas.size());
		this.tarjetas = tarjetas;
	}

	public List<Cliente> getMisClientes() {
		return misClientes;
	}

	public void setMisClientes(List<Cliente> misClientes) {
		this.misClientes = misClientes;
	}

	public Cliente getClienteID(String text) {
		Iterator it = misClientes.iterator();

		while (it.hasNext()) {
			Cliente c = (Cliente) it.next();
			if (c.getIdentificacion().equals(text)) {
				return c;
			}
		}
		return null;
	}

	public void agregarTiquete(Tiquete miTiquete) {
		misTiquetes.add(miTiquete);
	}

	public void agregarTarjeta(Tarjeta t) {
		tarjetas.add(t);
	}

}
