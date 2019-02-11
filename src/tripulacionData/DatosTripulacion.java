package tripulacionData;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import tripulacionLogica.Tripulacion;

public class DatosTripulacion {
	private String archivo;
	public DatosTripulacion() {
		archivo = "src/tripulacionData/datosTripulacion.txt";
	}
	public void serializacionOut (List<Tripulacion> misTripulaciones){
		try {
			FileOutputStream fos = new FileOutputStream(archivo);
			ObjectOutput oos = new ObjectOutputStream(fos);
			oos.writeObject(misTripulaciones);
			oos.close();
		} catch (Exception e) {
			System.out.println("ERROR; AL ENVIAR ARCHIVO TRIPULACION " +e);
		}
		
	}
	public List<Tripulacion> serializacionIn (){
		List<Tripulacion> misRutas = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(archivo);
			ObjectInput ois = new ObjectInputStream(fis);
			misRutas = (List<Tripulacion>) ois.readObject();
			ois.close();
		} catch (Exception e) {
			System.out.println("ERROR; AL LEER ARCHIVO TRIPULACION " +e);
		}
		return misRutas;
	}
}
