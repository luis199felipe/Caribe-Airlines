package mundo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import aeronaveLogica.Aeronave;
import aeronaveLogica.DistribucionSillas;
import aeronaveLogica.TipoAeronave;
import aeronavesData.DatosAeronave;
import aeronavesInterface.VentanaAeronave;
import rutaData.DatosRuta;
import rutaLogica.Ruta;
import tripulacionData.DatosTripulacion;
import tripulacionData.DatosTripulante;
import tripulacionLogica.Tripulacion;
import tripulacionLogica.Tripulante;

public class CaribeAirlines {
	private List<TipoAeronave> misAeronaves;
	private DatosAeronave datosAeronaves;
	private List<Ruta> misRutas;
	private DatosRuta datosRutas;
	private List<Tripulacion> misTripulaciones;
	private DatosTripulacion datosTripulaciones;
	private List<Tripulante> misTripulantes;
	private DatosTripulante datosTripulantes;
	
	//Constructor
	public CaribeAirlines() {
		misAeronaves = new ArrayList<>();
		datosAeronaves = new DatosAeronave();
		misRutas = new ArrayList<>();
		datosRutas = new DatosRuta();
		misTripulantes = new ArrayList<>();
		datosTripulantes = new DatosTripulante();
		misTripulaciones = new ArrayList<>();
		datosTripulaciones = new DatosTripulacion();
		Origen creaciones = new Origen(this);
		creaciones.crearMisAviones(); //SOLO SE DEBE DE EJECUTAR UNA PRIMERA VEZ, ya que queda guardado en el archivo.txt
		creaciones.crearMisTripulantes();//SOLO SE DEBE DE EJECUTAR UNA PRIMERA VEZ, ya que queda guardado en el archivo.txt
		creaciones.crearTripulaciones();//SOLO SE DEBE DE EJECUTAR UNA PRIMERA VEZ, ya que queda guardado en el archivo.txt
		creaciones.crearMisRutas(); //SOLO SE DEBE DE EJECUTAR UNA PRIMERA VEZ, ya que queda guardado en el archivo.txt
		creaciones.RegistroRutas();//SE DEBE DE EJECUTAR CADA VEZ QUE HAY NUEVA RUTA DE VUELO
	}
	
	//Metodos Aeronaves
	public String[][] llenarTablaDeDatosAeronave(int opcion) {
		int filas = misAeronaves.get(0).getAtributos().size();
		String[][] tabla = new String[filas][2];
		
		switch (opcion) {
		case 0:
			HashMap<String, Object> airbus_A320 = misAeronaves.get(0).getAtributos();
			int i = 0;
			for (Iterator it = airbus_A320.keySet().iterator(); it.hasNext();) {
				tabla[i][0] = (String)it.next();//key
				tabla[i][1] = (String)airbus_A320.get(tabla[i][0]);//value
				i++;
			}
			break;
		case 1:
			HashMap<String, Object> airbus_A330 = misAeronaves.get(1).getAtributos();
			int j = 0;
			for (Iterator it = airbus_A330.keySet().iterator(); it.hasNext();) {
				tabla[j][0] = (String)it.next();//key
				tabla[j][1] = (String)airbus_A330.get(tabla[j][0]);//value
				j++;
			}
			break;
		case 2:
			HashMap<String, Object> boeing_787 = misAeronaves.get(2).getAtributos();
			int k = 0;
			for (Iterator it = boeing_787.keySet().iterator(); it.hasNext();) {
				tabla[k][0] = (String)it.next();//key
				tabla[k][1] = (String)boeing_787.get(tabla[k][0]);//value
				k++;
			}
			break;

		default:
			break;
		}
		return tabla;
	}
	
	public String[][] llenarTablaDeMasDetalles (Ruta miRuta){
		int row = miRuta.getAtributos().size() + miRuta.getMiTripulacion().getAuxiliares().size() + 2;
		String[][] datos = new String[row][2];
		int i = 0;
		for (Iterator it = miRuta.getAtributos().keySet().iterator(); it.hasNext();) {
			datos[i][0] = (String)it.next();//key
			datos[i][1] = (String)miRuta.getAtributos().get(datos[i][0]);//value
			i++;
		}
		String auxiliares = miRuta.getMiTripulacion().getMiTripulacion().get("Auxiliares");
		List<String> mostrar = new ArrayList<>();
		String palabra = "";
		for (int j = 0; j < auxiliares.length(); j++) {
			if (auxiliares.charAt(j) == ',') {
				mostrar.add(palabra);
				palabra = "";
			}else {
				palabra += auxiliares.charAt(j);
			}
		}
		datos[miRuta.getAtributos().size()][0] = "Piloto";
		datos[miRuta.getAtributos().size()][1] = miRuta.getMiTripulacion().getMiTripulacion().get("Piloto");
		datos[miRuta.getAtributos().size()+1][0] = "Copiloto";
		datos[miRuta.getAtributos().size()+1][1] = miRuta.getMiTripulacion().getMiTripulacion().get("Copiloto");
		
		i = 1;
		for (int j = miRuta.getAtributos().size()+2; j < datos.length; j++) {
			datos[j][0] = "auxiliar " + i;
			datos[j][1] = mostrar.get(i-1);
			i++;
		}
		
		return datos;
	}
	
	//Getter & Setter
	public List<TipoAeronave> getMisAeronaves() {
		misAeronaves = datosAeronaves.serializacionIn();
		return misAeronaves;
	}
	public void setMisAeronaves(List<TipoAeronave> misAeronaves) {
		this.misAeronaves = misAeronaves;
		datosAeronaves.serializacionOut(misAeronaves);
	}
	public List<Ruta> getMisRutas() {
		misRutas = datosRutas.serializacionIn();
		return misRutas;
	}

	public void setMisRutas(List<Ruta> misRutas) {
		this.misRutas = misRutas;
		datosRutas.serializacionOut(misRutas);
	}

	public List<Tripulacion> getMisTripulaciones() {
		misTripulaciones = datosTripulaciones.serializacionIn();
		return misTripulaciones;
	}

	public void setMisTripulaciones(List<Tripulacion> misTripulaciones) {
		this.misTripulaciones = misTripulaciones;
		datosTripulaciones.serializacionOut(misTripulaciones);
	}

	public List<Tripulante> getMisTripulantes() {
		misTripulantes = datosTripulantes.serializacionIn();
		return misTripulantes;
	}

	public void setMisTripulantes(List<Tripulante> misTripulantes) {
		this.misTripulantes = misTripulantes;
		datosTripulantes.serializacionOut(misTripulantes);
	}
	
}
