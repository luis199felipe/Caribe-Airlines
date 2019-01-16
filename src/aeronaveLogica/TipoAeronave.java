package aeronaveLogica;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class TipoAeronave implements Serializable{
	private HashMap<String, String> atributos;
	private List<Aeronave> flotaDeAeronaves;
	private DistribucionSillas ubicacionSillas;
	
	//Constructor
	public TipoAeronave(String idTipoAeronave, String tipoVuelo, String marca, String linea, String capacidadCarga,
			String capacidadAsientos, List<Aeronave> flotaDeAeronaves, DistribucionSillas ubicacionSillas) {
		
		atributos = new HashMap<>();
		atributos.put("idTipoAeronave", idTipoAeronave);
		atributos.put("TipoVuelo", tipoVuelo);
		atributos.put("Marca", marca);
		atributos.put("Linea", linea);
		atributos.put("CapacidadCarga", capacidadCarga);
		atributos.put("CapacidadAsientos", capacidadAsientos);
		atributos.put("FlotaDeAeronaves", String.valueOf(flotaDeAeronaves.size()) + " aeronaves");
		
		this.flotaDeAeronaves = flotaDeAeronaves;
		this.ubicacionSillas = ubicacionSillas;
		
	}
	//Getter & Setter
	public HashMap getAtributos() {
		return atributos;
	}
	public void setAtributos(HashMap<String, String> atributos) {
		this.atributos = atributos;
	}
	public List<Aeronave> getFlotaDeAeronaves() {
		return flotaDeAeronaves;
	}
	public void setFlotaDeAeronaves(List<Aeronave> flotaDeAeronaves) {
		this.flotaDeAeronaves = flotaDeAeronaves;
	}
	public DistribucionSillas getUbicacionSillas() {
		return ubicacionSillas;
	}
	public void setUbicacionSillas(DistribucionSillas ubicacionSillas) {
		this.ubicacionSillas = ubicacionSillas;
	}
}
