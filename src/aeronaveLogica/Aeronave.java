package aeronaveLogica;

import java.io.Serializable;

public class Aeronave implements Serializable{
	private String matricula;
	private String registro;

	//Constructor
	public Aeronave(String matricula, String registro) {
		this.matricula = matricula;
		registro = registro;
	}
	
	//Getter & Setter
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
		registro = registro;
	}
	
}
