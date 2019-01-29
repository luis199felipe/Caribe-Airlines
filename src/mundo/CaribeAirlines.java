package mundo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

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

public class CaribeAirlines {
	private List<Aeronave> misAeronaves;
	private List<TipoAeronave> misTipoAeronave;
	private List<Ruta> misRutas;
	private List<Tripulacion> misTripulaciones;
	private List<Tripulante> misTripulantes;
	
	//Constructor
	public CaribeAirlines() {
		misAeronaves = new ArrayList<>();
		misTipoAeronave = new ArrayList<>();
		misRutas = new ArrayList<>();
		misTripulantes = new ArrayList<>();
		misTripulaciones = new ArrayList<>();
		Origen creaciones = new Origen(this);
		creaciones.crearMisTipoAeronave();
		creaciones.crearMisAviones(); //SOLO SE DEBE DE EJECUTAR UNA PRIMERA VEZ, ya que queda guardado en el archivo.txt
		creaciones.crearMisTripulantes();//SOLO SE DEBE DE EJECUTAR UNA PRIMERA VEZ, ya que queda guardado en el archivo.txt
		creaciones.crearTripulaciones();//SOLO SE DEBE DE EJECUTAR UNA PRIMERA VEZ, ya que queda guardado en el archivo.txt
		creaciones.crearMisRutas(); //SOLO SE DEBE DE EJECUTAR UNA PRIMERA VEZ, ya que queda guardado en el archivo.txt
		creaciones.RegistroRutas();//SE DEBE DE EJECUTAR CADA VEZ QUE HAY NUEVA RUTA DE VUELO
	}
	
	//Metodos Aeronaves
	
	public List<Aeronave> ordenarFlotaPorTipoAeronave(int tipoAeronave){
		List<Aeronave> flota = new ArrayList<>();
		String idTipoAeronave = "";
		if(tipoAeronave == 0) {
			idTipoAeronave = "air001";
		}else if(tipoAeronave == 1) {
			idTipoAeronave = "air002";
		}else if(tipoAeronave == 2){
			idTipoAeronave = "air003";
		}else {
			System.out.println("ERROR, metodo ordenar flota por tipo aeronave");
		}
		for (int i = 0; i < misAeronaves.size(); i++) {
			if(misAeronaves.get(i).getTipoAeronave().getAtributos().get("idTipoAeronave").equals(idTipoAeronave)) {
				flota.add(misAeronaves.get(i));
			}
		}
		return flota;
	}
	
	public String[][] llenarTablaDeDatosAeronave(int opcion) {
		int filas = misAeronaves.get(0).getTipoAeronave().getAtributos().size();
		String[][] tabla = new String[filas][2];
		
		switch (opcion) {
		case 0:
			HashMap<String, Object> airbus_A320 = misTipoAeronave.get(0).getAtributos();
			int i = 0;
			for (Iterator it = airbus_A320.keySet().iterator(); it.hasNext();) {
				tabla[i][0] = (String)it.next();//key
				tabla[i][1] = (String)airbus_A320.get(tabla[i][0]);//value
				i++;
			}
			break;
		case 1:
			HashMap<String, Object> airbus_A330 = misTipoAeronave.get(1).getAtributos();
			int j = 0;
			for (Iterator it = airbus_A330.keySet().iterator(); it.hasNext();) {
				tabla[j][0] = (String)it.next();//key
				tabla[j][1] = (String)airbus_A330.get(tabla[j][0]);//value
				j++;
			}
			break;
		case 2:
			HashMap<String, Object> boeing_787 = misTipoAeronave.get(2).getAtributos();
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
}
