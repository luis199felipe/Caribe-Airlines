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
	
	public Vuelo(String idVuelo, String fecha, String horaSalida, String tiempoAlistamiento,
			Ruta miRuta, Tripulacion miTripulacion, Aeronave miAeronave) {
		
		atributos = new HashMap<>();
		atributos.put("IdVuelo",idVuelo);
		atributos.put("Fecha", fecha);
		atributos.put("HoraSalida", horaSalida);
		atributos.put("HoraLLegada", encontrarHoraLlegada(horaSalida, miRuta.getAtributos().get("Duracion")));
		atributos.put("Alistamiento(Horas)", tiempoAlistamiento);
		
		this.miRuta = miRuta;
		this.miTripulacion = miTripulacion;
		this.miAeronave = miAeronave;
	}
	
	
	@Override
	public String toString() {
		return "Vuelo [Hora de Salida=" +atributos.get("HoraSalida") + ", miRuta=" +miRuta.toString() +", " + miAeronave.toString() + "]";
	}


	//Methods
	public String encontrarHoraLlegada(String salida, String duracion) {
		String llegada = "";
		String[] partesLlegada = new String[2];
		String[] partesSalida = salida.split(":");
		String[] partesDuracion = duracion.split(":");
		int horaSalida = Integer.parseInt(partesSalida[0]);
		int horaDuracion = Integer.parseInt(partesDuracion[0]);
		int minutosSalida =  Integer.parseInt(partesSalida[1]);
		int minutosDuracion = Integer.parseInt(partesDuracion[1]);
		int horaAdd = 0;
		if(minutosDuracion + minutosSalida < 60) {
			partesLlegada[1] = String.valueOf(minutosDuracion + minutosSalida);
		}else {
			horaAdd = (minutosDuracion + minutosSalida)/60;
			partesLlegada[1] = String.valueOf((minutosDuracion + minutosSalida)%60);
		}
		int hour = 0;
		if(horaSalida + horaDuracion + horaAdd < 24) {
			hour = horaSalida + horaDuracion + horaAdd ;
			partesLlegada[0] = String.valueOf(hour);
		}else {
			hour = (horaSalida + horaDuracion + horaAdd)%24;
			partesLlegada[0] = String.valueOf(hour);		}
		llegada = partesLlegada[0] + ":" + partesLlegada[1];
		return llegada;
	}
	
	//Getters & Setters
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
