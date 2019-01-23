package tripulacionData;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import rutaLogica.Ruta;
import tripulacionLogica.Tripulante;

public class DatosTripulante {
	private String archivo;
	public DatosTripulante() {
		archivo = "src/tripulacionData/datosTripulante.txt";
	}
	public void serializacionOut (List<Tripulante> misTripulantes){
		try {
			FileOutputStream fos = new FileOutputStream(archivo);
			ObjectOutput oos = new ObjectOutputStream(fos);
			oos.writeObject(misTripulantes);
			oos.close();
		} catch (Exception e) {
			System.out.println("ERROR; AL ENVIAR ARCHIVO TRIPULANTE " +e);
		}
		
	}
	public List<Tripulante> serializacionIn (){
		List<Tripulante> misTripulantes = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(archivo);
			ObjectInput ois = new ObjectInputStream(fis);
			misTripulantes = (List<Tripulante>) ois.readObject();
			ois.close();
		} catch (Exception e) {
			System.out.println("ERROR; AL LEER ARCHIVO TRIPULANTE" +e);
		}
		return misTripulantes;
	}
}
