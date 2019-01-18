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

public class CaribeAirlines {
	private List<TipoAeronave> misAeronaves;
	private DatosAeronave datosAeronaves;
	private List<Ruta> misRutas;
	private DatosRuta datosRutas;
	
	//Constructor
	public CaribeAirlines() {
		misAeronaves = new ArrayList<>();
		datosAeronaves = new DatosAeronave();
		misRutas = new ArrayList<>();
		datosRutas = new DatosRuta();
		Origen creaciones = new Origen();
		//creaciones.crearMisAviones(misAeronaves, datosAeronaves); //SOLO SE DEBE DE EJECUTAR UNA PRIMERA VEZ, ya que queda guardado en el archivo.txt
		//creaciones.crearMisRutas(misRutas, datosRutas, misAeronaves);
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
	
	public int encontrarPosiciontipoAeronave(String idTipoAeronave){
		int pos = -1;
		for (int i = 0; i < misAeronaves.size(); i++) {
			if(misAeronaves.get(i).getAtributos().get("idTipoAeronave").equals(idTipoAeronave)) {
				pos = i;
			}
		}
			
		return pos;
	}
	
	
	
	//Getter & Setter
	public List<TipoAeronave> getMisAeronaves() {
		misAeronaves = datosAeronaves.serializacionIn();
		return misAeronaves;
	}
	public void setMisAeronaves(List<Ruta> misRutas) {
		this.misRutas = misRutas;
		datosRutas.serializacionOut(misRutas);
	}
	public List<Ruta> getMisRutas() {
		misRutas = datosRutas.serializacionIn();
		return misRutas;
	}

	public void setMisRutas(List<Ruta> misRutas) {
		this.misRutas = misRutas;
		datosRutas.serializacionOut(misRutas);
	}
}
