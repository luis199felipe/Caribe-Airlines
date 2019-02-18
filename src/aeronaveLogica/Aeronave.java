package aeronaveLogica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import vueloLogica.Vuelo;

public class Aeronave implements Serializable{
	private String ubicacion;
	private TipoAeronave tipoAeronave;
	private String matricula;
	private boolean disponible;
	private List<Vuelo> registro;

	//Constructor
	public Aeronave(String ubicacion, TipoAeronave tipoAeronave, String matricula, boolean disponible) {
		this.ubicacion = ubicacion;
		this.tipoAeronave = tipoAeronave;
		this.matricula = matricula;
		this.disponible = disponible;
		registro = new ArrayList<>();
	}
	
	
	
	@Override
	public String toString() {
		return "Aeronave [ubicacion=" + ubicacion + ", tipoAeronave=" + tipoAeronave.getAtributos().get("Marca") + ", matricula=" + matricula+"]";
	}



	//Getter & Setter
	public String getUbicacion() {
		return ubicacion;
	}
	public TipoAeronave getTipoAeronave() {
		return tipoAeronave;
	}

	public void setTipoAeronave(TipoAeronave tipoAeronave) {
		this.tipoAeronave = tipoAeronave;
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
	public List<Vuelo> getRegistro() {
		return registro;
	}
	public void setRegistro(List<Vuelo> registro) {
		this.registro = registro;
	}
}
