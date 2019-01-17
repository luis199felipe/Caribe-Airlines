package vueloLogica;

import java.util.HashMap;
import java.util.List;

public class Tripulacion {
	private HashMap<String, String> miTripulacion;
	private Tripulante piloto;
	private Tripulante copiloto;
	private List<Tripulante> auxiliares;
	
	//Constructor
	public Tripulacion(Tripulante piloto,Tripulante copiloto, List<Tripulante> auxiliares) {
		this.piloto = piloto;
		this.copiloto = copiloto;
		this.auxiliares = auxiliares;
		miTripulacion = new HashMap<>();
		miTripulacion.put("piloto", piloto.getAtributos().get("Nombre") + piloto.getAtributos().get("Identificacion"));
		miTripulacion.put("copiloto", copiloto.getAtributos().get("Nombre") + copiloto.getAtributos().get("Identificacion"));
		miTripulacion.put("Auxiliares", cadenaAuxiliares());
	}
	
	//Getters & Setters
	public String cadenaAuxiliares() {
		String mostrar = "";
		for (int i = 0; i < auxiliares.size(); i++) {
			mostrar += auxiliares.get(i).getAtributos().get("Nombre") + auxiliares.get(i).getAtributos().get("Identificacion") + ",";
		}
		mostrar.substring(0, mostrar.length()-1);
		System.out.println(mostrar);
		return mostrar;
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
}
