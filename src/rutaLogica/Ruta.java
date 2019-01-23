package rutaLogica;

import java.io.Serializable;
import java.util.HashMap;

import aeronaveLogica.Aeronave;
import tripulacionLogica.Tripulacion;

public class Ruta implements Serializable{
	private HashMap<String, String> atributos;
	private Tripulacion miTripulacion;
	private Aeronave miAeronave;
	
	//Constructor
	public Ruta(String fecha, String origen, String destino, String idaRegreso, String duracion, String horaSalida,
			String horaLlegada,String tiempoEsperaHoras, String tipo, Tripulacion miTripulacion,
			Aeronave miAeronave) {
		
		this.miTripulacion = miTripulacion;
		this.miAeronave = miAeronave;
		
		atributos = new HashMap<>();
		atributos.put("Fecha", fecha);
		atributos.put("Origen", origen);
		atributos.put("Destino", destino);
		atributos.put("Tipo",tipo);
		atributos.put("Ida o Regreso", idaRegreso);
		atributos.put("Duracion", duracion);
		atributos.put("HoraSalida", horaSalida);
		atributos.put("HoraLLegada", horaLlegada);
		atributos.put("TiempoEspera(H)", tiempoEsperaHoras);
	}
	
	//Getters & Setters
	public HashMap<String, String> getAtributos() {
		return atributos;
	}
	public void setAtributos(HashMap<String, String> atributos) {
		this.atributos = atributos;
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
