package aeronaveLogica;

import java.io.Serializable;

public class Aeronave implements Serializable{
	private String idTipoAeronave;
	private String matricula;
	private String registro;

	//Constructor
	public Aeronave(String idTipoAeronave, String matricula, String registro) {
		this.idTipoAeronave = idTipoAeronave;
		this.matricula = matricula;
		this.registro = registro;
	}
	
	//Getter & Setter
	public String getIdTipoAeronave() {
		return idTipoAeronave;
	}
	public void setIdTipoAeronave(String idTipoAeronave) {
		this.idTipoAeronave = idTipoAeronave;
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
