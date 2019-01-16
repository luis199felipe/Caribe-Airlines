package aeronavesData;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import aeronaveLogica.Aeronave;
import aeronaveLogica.TipoAeronave;
public class DatosAeronave {
	private String archivo;
	public DatosAeronave() {
		archivo = "src/aeronavesData/datosAeronave.txt";
	}
	public void serializacionOut (List<TipoAeronave> misAeronaves){
		try {
			FileOutputStream fos = new FileOutputStream(archivo);
			ObjectOutput oos = new ObjectOutputStream(fos);
			oos.writeObject(misAeronaves);
			oos.close();
		} catch (Exception e) {
			System.out.println("ERROR; AL ENVIAR ARCHIVO AERONAVE");
		}
		
	}
	public List<TipoAeronave> serializacionIn (){
		List<TipoAeronave> misAeronaves = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(archivo);
			ObjectInput ois = new ObjectInputStream(fis);
			misAeronaves = (List<TipoAeronave>) ois.readObject();
			ois.close();
		} catch (Exception e) {
			System.out.println("ERROR; AL LEER ARCHIVO AERONAVE");
		}
		return misAeronaves;
	}
}
