package vueloData;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import vueloLogica.Ruta;

public class DatosRuta {
	private String archivo;
	public DatosRuta() {
		archivo = "src/aeronavesData/datosRuta.txt";
	}
	public void serializacionOut (List<Ruta> misRutas){
		try {
			FileOutputStream fos = new FileOutputStream(archivo);
			ObjectOutput oos = new ObjectOutputStream(fos);
			oos.writeObject(misRutas);
			oos.close();
		} catch (Exception e) {
			System.out.println("ERROR; AL ENVIAR ARCHIVO AERONAVE");
		}
		
	}
	public List<Ruta> serializacionIn (){
		List<Ruta> misRutas = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(archivo);
			ObjectInput ois = new ObjectInputStream(fis);
			misRutas = (List<Ruta>) ois.readObject();
			ois.close();
		} catch (Exception e) {
			System.out.println("ERROR; AL LEER ARCHIVO AERONAVE");
		}
		return misRutas;
	}
}
