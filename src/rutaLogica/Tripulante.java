package rutaLogica;

import java.io.Serializable;
import java.util.HashMap;

public class Tripulante implements Serializable{
	private HashMap<String, String> atributos;
	
	//Constructor
	public Tripulante (String cargo, String identificacion, String nombre, String direccion, String correo,
			String fechaNacimiento, String estudios) {
			
		atributos = new HashMap<>();
		atributos.put("Cargo", cargo);
		atributos.put("Identificacion", identificacion);
		atributos.put("Nombre", nombre);
		atributos.put("Direccion", direccion);
		atributos.put("Correo", correo);
		atributos.put("FechaNacimiento", fechaNacimiento);
		atributos.put("estudios", estudios);
	}

	//Getters & Setters
	public HashMap<String, String> getAtributos() {
		return atributos;
	}
	public void setAtributos(HashMap<String, String> atributos) {
		this.atributos = atributos;
	}
}
