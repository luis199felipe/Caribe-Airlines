package vueloLogica;

import java.util.HashMap;

import aeronaveLogica.Aeronave;

public class Ruta {
	private HashMap<String, String> atributos;
	private Tripulacion miTripulacion;
	private Aeronave miAeronave;
	
	//Constructor
	public Ruta(String origen, String destino, String duracionHoras, String duracionMinutos, String horaSalida,
			String horaLlegada,String tiempoEsperaHoras, String horaRegreso, Tripulacion miTripulacion,
			Aeronave miAeronave) {
		this.miTripulacion = miTripulacion;
		this.miAeronave = miAeronave;
		atributos = new HashMap<>();
		atributos.put("Origen", origen);
		atributos.put("Destino", destino);
		atributos.put("DuracionHoras", duracionHoras);
		atributos.put("DuracionMinutos", duracionMinutos);
		atributos.put("HoraSalida", horaSalida);
		atributos.put("HoraLLegada", horaLlegada);
		atributos.put("TiempoEsperaHoras", tiempoEsperaHoras);
		atributos.put("HoraRegreso", horaRegreso);
	}
	
	//Getters & Setters
	public HashMap<String, String> getAtributos() {
		return atributos;
	}
	public void setAtributos(HashMap<String, String> atributos) {
		this.atributos = atributos;
	}
}
