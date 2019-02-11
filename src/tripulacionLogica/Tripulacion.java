package tripulacionLogica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import vueloLogica.Vuelo;

public class Tripulacion implements Serializable{
	private HashMap<String, String> miTripulacion;
	private Tripulante piloto;
	private Tripulante copiloto;
	private String tipoTripulacion;
	private List<Tripulante> auxiliares;
	private List<Vuelo> misVuelos;
	
	//Constructor
	public Tripulacion(String idTripulacion, Tripulante piloto, Tripulante copiloto, List<Tripulante> auxiliares, String tipoTripulacion) {
		
		misVuelos = new ArrayList<>();
		
		this.piloto = piloto;
		this.copiloto = copiloto;
		this.auxiliares = auxiliares;
		this.tipoTripulacion = tipoTripulacion;
		
		miTripulacion = new HashMap<>();
		miTripulacion.put("IdTripulacion", idTripulacion);
		miTripulacion.put("Piloto", "" + piloto.getAtributos().get("Nombre") + "  " + piloto.getAtributos().get("Identificacion"));
		miTripulacion.put("Copiloto", "" + copiloto.getAtributos().get("Nombre") + "  " + copiloto.getAtributos().get("Identificacion"));
		miTripulacion.put("Auxiliares", cadenaAuxiliares());
	}
	
	//Methods
	public String cadenaAuxiliares() {
		String mostrar = "";
		for (int i = 0; i < auxiliares.size(); i++) {
			mostrar += auxiliares.get(i).getAtributos().get("Nombre") + "  " + auxiliares.get(i).getAtributos().get("Identificacion") + ",";
		}
		return mostrar;
	}
	public String toStringAuxiliares() {
		String cadena = "<html>";
		for (int i = 0; i < auxiliares.size(); i++) {
			cadena += auxiliares.get(i).getAtributos().get("Nombre")+"<br>";
		}
		cadena += "</html>";
		return cadena;
	}

	//Getters & Setters
	public HashMap<String, String> getMiTripulacion() {
		return miTripulacion;
	}
	public void setMiTripulacion(HashMap<String, String> miTripulacion) {
		this.miTripulacion = miTripulacion;
	}
	public Tripulante getPiloto() {
		return piloto;
	}
	public void setPiloto(Tripulante piloto) {
		this.piloto = piloto;
	}
	public Tripulante getCopiloto() {
		return copiloto;
	}
	public void setCopiloto(Tripulante copiloto) {
		this.copiloto = copiloto;
	}
	public List<Tripulante> getAuxiliares() {
		return auxiliares;
	}
	public void setAuxiliares(List<Tripulante> auxiliares) {
		this.auxiliares = auxiliares;
	}
	public List<Vuelo> getMisVuelos() {
		return misVuelos;
	}
	public void setMisVuelos(List<Vuelo> misVuelos) {
		this.misVuelos = misVuelos;
	}
	public String getTipoTripulacion() {
		return tipoTripulacion;
	}
	public void setTipoTripulacion(String tipoTripulacion) {
		this.tipoTripulacion = tipoTripulacion;
	}
}
