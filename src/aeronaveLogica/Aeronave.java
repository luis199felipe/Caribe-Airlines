package aeronaveLogica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import rutaLogica.Ruta;

public class Aeronave implements Serializable{
	private String ubicacion;
	private String idTipoAeronave;
	private String matricula;
	private boolean disponible;
	private List<Ruta> registro;

	//Constructor
	public Aeronave(String ubicacion, String idTipoAeronave, String matricula, boolean disponible) {
		this.ubicacion = ubicacion;
		this.idTipoAeronave = idTipoAeronave;
		this.matricula = matricula;
		this.disponible = disponible;
		registro = new ArrayList<>();
	}
	
	//Getter & Setter
	public String getIdTipoAeronave() {
		return idTipoAeronave;
	}
	public void setIdTipoAeronave(String idTipoAeronave) {
		this.idTipoAeronave = idTipoAeronave;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public List<Ruta> getRegistro() {
		return registro;
	}
	public void setRegistro(List<Ruta> registro) {
		this.registro = registro;
	}
}
