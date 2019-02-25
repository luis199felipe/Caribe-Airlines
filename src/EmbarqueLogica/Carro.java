package EmbarqueLogica;

import java.util.ArrayList;

import VentaLogica.Maleta;
import aeronaveLogica.Aeronave;

public class Carro {

	private String idCarro;
	private int carga;
	private Aeronave miAvion;
	private ArrayList<Maleta> misMaletas;
	private boolean estado;
	
	
	
	public Carro(String idCarro, int carga, Aeronave miAvion, boolean estado) {
		this.idCarro = idCarro;
		this.carga = carga;
		this.miAvion = miAvion;
		this.estado = estado;
		misMaletas = new ArrayList<Maleta>();
	}
	
	
	public String getIdCarro() {
		return idCarro;
	}
	public void setIdCarro(String idCarro) {
		this.idCarro = idCarro;
	}
	public int getCarga() {
		return carga;
	}
	public void setCarga(int carga) {
		this.carga = carga;
	}
	public Aeronave getMiAvion() {
		return miAvion;
	}
	public void setMiAvion(Aeronave miAvion) {
		this.miAvion = miAvion;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
	
	
}
