package vueloLogica;

import java.io.Serializable;
import java.util.HashMap;

import aeronaveLogica.Aeronave;
import tripulacionLogica.Tripulacion;

public class Vuelo implements Serializable{
	private HashMap<String, String> atributos;
	private Ruta miRuta;
	private Tripulacion miTripulacion;
	private Aeronave miAeronave;
	
	public Vuelo(String fecha, String horaSalida, String horaLlegada, String tiempoAlistamiento, Ruta miRuta) {
		
		atributos = new HashMap<>();
		atributos.put("Fecha", fecha);
		atributos.put("HoraSalida", horaSalida);
		atributos.put("HoraLLegada", horaLlegada);
		atributos.put("TiempoAlistamiento(H)", tiempoAlistamiento);
		
		this.miRuta = miRuta;
	}
	
	public HashMap<String, String> getAtributos() {
		return atributos;
	}
	public void setAtributos(HashMap<String, String> atributos) {
		this.atributos = atributos;
	}
	public Ruta getMiRuta() {
		return miRuta;
	}
	public void setMiRuta(Ruta miRuta) {
		this.miRuta = miRuta;
	}
	public Tripulacion getMiTripulacion() {
		return miTripulacion;
	}
	public void setMiTripulacion(Tripulacion miTripulacion) {
		this.miTripulacion = miTripulacion;
	}
	public Aeronave getMiAeronave() {
		return miAeronave;
	}
	public void setMiAeronave(Aeronave miAeronave) {
		this.miAeronave = miAeronave;
	}
}
