package vueloLogica;

import java.io.Serializable;
import java.util.HashMap;

import aeronaveLogica.Aeronave;
import tripulacionLogica.Tripulacion;

public class Ruta implements Serializable{
	private HashMap<String, String> atributos;
	
	//Constructor
	public Ruta(String origen, String destino, String duracion, String tipoVuelo) {
		
		atributos = new HashMap<>();
		atributos.put("Origen", origen);
		atributos.put("Destino", destino);
		atributos.put("Tipo vuelo",tipoVuelo);
		atributos.put("Duracion", duracion);
	}
	
	//Getters & Setters 
	public HashMap<String, String> getAtributos() {
		return atributos;
	}
	public void setAtributos(HashMap<String, String> atributos) {
		this.atributos = atributos;
	}
}
