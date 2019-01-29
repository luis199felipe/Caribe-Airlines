package aeronaveData;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import aeronaveLogica.Aeronave;

public class DatosAeronave {
	private String archivo;
	public DatosAeronave() {
		archivo = "src/aeronaveData/datosAeronave.txt";
	}
	public void serializacionOut (List<Aeronave> misAeronaves){
		try {
			FileOutputStream fos = new FileOutputStream(archivo);
			ObjectOutput oos = new ObjectOutputStream(fos);
			oos.writeObject(misAeronaves);
			oos.close();
		} catch (Exception e) {
			System.out.println("ERROR; AL ENVIAR ARCHIVO AERONAVE " +e);
		}
		
	}
	public List<Aeronave> serializacionIn (){
		List<Aeronave> misAeronaves = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(archivo);
			ObjectInput ois = new ObjectInputStream(fis);
			misAeronaves = (List<Aeronave>) ois.readObject();
			ois.close();
		} catch (Exception e) {
			System.out.println("ERROR; AL LEER ARCHIVO AERONAVE " +e);
		}
		return misAeronaves;
	}
}
