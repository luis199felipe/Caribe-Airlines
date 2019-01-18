package aeronaveLogica;

import java.io.Serializable;

public class Aeronave implements Serializable{
	private String ubicacion;
	private String idTipoAeronave;
	private String matricula;
	private String registro;
	private boolean disponible;

	//Constructor
	public Aeronave(String ubicacion, String idTipoAeronave, String matricula, String registro, boolean disponible) {
		this.ubicacion = ubicacion;
		this.idTipoAeronave = idTipoAeronave;
		this.matricula = matricula;
		this.registro = registro;
		this.disponible = disponible;
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
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
}
