package mundo;

import java.util.ArrayList;
import java.util.List;

import aeronaveLogica.Aeronave;
import aeronaveLogica.DistribucionSillas;
import aeronaveLogica.TipoAeronave;
import aeronavesData.DatosAeronave;
import vueloData.DatosRuta;
import vueloLogica.Ruta;
import vueloLogica.Tripulacion;
import vueloLogica.Vuelo;

public class Origen {
	
	public Origen() {
		
	}
	public void crearMisRutas(List<Ruta> misRutas,DatosRuta datosRuta, List<TipoAeronave> misAeronaves) {
		String miFecha = "13/01/2019";
		
		Aeronave miAeronave1 = misAeronaves.get(0).getFlotaDeAeronaves().get(0);
		Aeronave miAeronave2 = misAeronaves.get(0).getFlotaDeAeronaves().get(1);
		Aeronave miAeronave3 = misAeronaves.get(1).getFlotaDeAeronaves().get(0);
		Aeronave miAeronave4 = misAeronaves.get(1).getFlotaDeAeronaves().get(1);
		Aeronave miAeronave5 = misAeronaves.get(2).getFlotaDeAeronaves().get(0);
		Aeronave miAeronave6 = misAeronaves.get(2).getFlotaDeAeronaves().get(1);
		
		String origen, destino, duracionHoras,duracionMinutos,horaSalida,horaLlegada,tiempoEsperaHoras,horaRegreso;
		
		origen = "CDMX";
		destino = "Monterrey";
		duracionHoras = "2";duracionMinutos = "45";
		horaSalida = "6:00";
		tiempoEsperaHoras = "3";
		horaRegreso = "11:45";
		
		Ruta miRuta1 = new Ruta(origen, destino, duracionHoras, duracionMinutos,
				horaSalida, horaLlegada, tiempoEsperaHoras, horaRegreso, miTripulacion, miAeronave);
		
	}
	public void crearMisAviones(List<TipoAeronave> misAeronaves,DatosAeronave datosAeronaves) {
		
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
}
