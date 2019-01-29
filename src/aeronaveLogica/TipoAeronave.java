package aeronaveLogica;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class TipoAeronave implements Serializable{
	private HashMap<String, String> atributos;
	private DistribucionSillas ubicacionSillas;
	
	//Constructor
	public TipoAeronave(String idTipoAeronave, String tipoVuelo, String marca, String linea, String capacidadCarga,
			String capacidadAsientos, DistribucionSillas ubicacionSillas) {
		
		atributos = new HashMap<>();
		atributos.put("idTipoAeronave", idTipoAeronave);
		atributos.put("TipoVuelo", tipoVuelo);
		atributos.put("Marca", marca);
		atributos.put("Linea", linea);
		atributos.put("CapacidadCarga", capacidadCarga);
		atributos.put("CapacidadAsientos", capacidadAsientos);
		
		this.ubicacionSillas = ubicacionSillas;
		
	}
	//Getter & Setter
	public HashMap getAtributos() {
		return atributos;
	}
	public void setAtributos(HashMap<String, String> atributos) {
		this.atributos = atributos;
	}
	public DistribucionSillas getUbicacionSillas() {
		return ubicacionSillas;
	}
	public void setUbicacionSillas(DistribucionSillas ubicacionSillas) {
		this.ubicacionSillas = ubicacionSillas;
	}
}
