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

public class CaribeAirlines {
	private List<TipoAeronave> misAeronaves;
	private DatosAeronave datosAeronaves;
	
	//Constructor
	public CaribeAirlines() {
		misAeronaves = new ArrayList<>();
		datosAeronaves = new DatosAeronave();
		//crearMisAviones(); //SOLO SE DEBE DE EJECUTAR UNA PRIMERA VEZ, ya que queda guardado en el archivo.txt
	}
	
	//Metodos Aeronaves
	public void crearMisAviones() {
		
		String idTipoAeronave, tipoVuelo, marca, linea, capacidadCarga, capacidadAsientos;
		
		String matricula, registro;
		
		int tipoAeronave, sillasEjecutiva, sillasEconomica;
		
		registro = "";
		
		idTipoAeronave = "air001";
		tipoVuelo = "Nacional";
		marca = "Airbus";
		linea = "A320";
		capacidadCarga = "19000 kg";
		capacidadAsientos = "<html>150 asientos: 12 Ejecutivos" + "<br>" + "138 Economicos</html>"; //preguntar
		
		matricula = "Av001";
		Aeronave uno = new Aeronave(idTipoAeronave, matricula, registro);
		
		matricula = "Av002";
		Aeronave dos = new Aeronave(idTipoAeronave, matricula, registro);
		
		List<Aeronave> flotaDeAeronavesAirbus_A320 = new ArrayList<>();
		flotaDeAeronavesAirbus_A320.add(uno);
		flotaDeAeronavesAirbus_A320.add(dos);
		
		tipoAeronave = 0;
		sillasEjecutiva = 12;
		sillasEconomica = 138;
		DistribucionSillas ubicacionSillasAirbus_A320 = new DistribucionSillas(tipoAeronave, sillasEjecutiva, sillasEconomica);
		
		TipoAeronave Airbus_A320 = new TipoAeronave(idTipoAeronave, tipoVuelo, marca, linea,
				capacidadCarga, capacidadAsientos, flotaDeAeronavesAirbus_A320, ubicacionSillasAirbus_A320);
	
		idTipoAeronave = "air002";
		tipoVuelo = "Internacional";
		marca = "Airbus";
		linea = "A330";
		capacidadCarga = "52000 kg";
		capacidadAsientos = "<html>252 asientos: 30 Ejecutivos" + "<br>" + "222 Economicos</html>";
		
		matricula = "Av003";
		Aeronave tres = new Aeronave(idTipoAeronave, matricula, registro);
		
		matricula = "Av004";
		Aeronave cuatro = new Aeronave(idTipoAeronave, matricula, registro);
		
		List<Aeronave> flotaDeAeronavesAirbus_A330 = new ArrayList<>();
		flotaDeAeronavesAirbus_A330.add(tres);
		flotaDeAeronavesAirbus_A330.add(cuatro);
		
		tipoAeronave = 1;
		sillasEjecutiva = 30;
		sillasEconomica = 222;
		DistribucionSillas ubicacionSillasAirbus_A330 = new DistribucionSillas(tipoAeronave, sillasEjecutiva, sillasEconomica);
		
		TipoAeronave Airbus_A330 = new TipoAeronave(idTipoAeronave, tipoVuelo, marca, linea,
				capacidadCarga, capacidadAsientos, flotaDeAeronavesAirbus_A330, ubicacionSillasAirbus_A330);
	
		idTipoAeronave = "air003";
		tipoVuelo = "Internacional";
		marca = "Boeing";
		linea = "787";
		capacidadCarga = "50000 kg";
		capacidadAsientos = "<html>250 asientos: 28 Ejecutivos" + "<br>" + "222 Economicos</html>";
		
		matricula = "Av005";
		Aeronave cinco = new Aeronave(idTipoAeronave, matricula, registro);
		
		matricula = "Av006";
		Aeronave seis = new Aeronave(idTipoAeronave, matricula, registro);
		
		List<Aeronave> flotaDeAeronavesBoeing_787 = new ArrayList<>();
		flotaDeAeronavesBoeing_787.add(cinco);
		flotaDeAeronavesBoeing_787.add(seis);
		
		tipoAeronave = 2;
		sillasEjecutiva = 28;
		sillasEconomica = 222;
		DistribucionSillas ubicacionSillasBoeing_787 = new DistribucionSillas(tipoAeronave, sillasEjecutiva, sillasEconomica);
		
		TipoAeronave Boeing_787 = new TipoAeronave(idTipoAeronave, tipoVuelo, marca, linea,
				capacidadCarga, capacidadAsientos, flotaDeAeronavesBoeing_787, ubicacionSillasBoeing_787);
		
		misAeronaves.add(Airbus_A320);
		misAeronaves.add(Airbus_A330);
		misAeronaves.add(Boeing_787);
		
		datosAeronaves.serializacionOut(misAeronaves);
		
	}
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

	public void setMisAeronaves(List<TipoAeronave> misAeronaves) {
		this.misAeronaves = misAeronaves;
		datosAeronaves.serializacionOut(misAeronaves);
	}
}
