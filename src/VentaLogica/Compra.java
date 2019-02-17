package VentaLogica;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import mundo.CaribeAirlines;
import vueloLogica.Ruta;
import vueloLogica.Vuelo;

public class Compra {

	private CaribeAirlines aerolinea;
	private Tiquete miTiquete;

	public Compra() {// Aqui la aerolinea se recibe por parametro. Por ahora creo uno para no entrar
						// a editar la interfaz principal.
		aerolinea = new CaribeAirlines();
		miTiquete = new Tiquete();
	}

	public Cliente getCliente(String text) {
		return aerolinea.getClienteID(text);

	}

	public CaribeAirlines getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(CaribeAirlines aerolinea) {
		this.aerolinea = aerolinea;
	}

	public Tiquete getMiTiquete() {
		return miTiquete;
	}

	public void setMiTiquete(Tiquete miTiquete) {
		this.miTiquete = miTiquete;
	}

	public void agregraCliente(Cliente c) {
		aerolinea.agregarCliente(c);
	}

	public HashMap<String, String> verificarVuelo(String ciudadOrigen,String ciudadDestino, String fecha) {

		List<Vuelo> vuelos = aerolinea.getMisVuelos();

		Iterator<Vuelo> it = vuelos.iterator();

		while (it.hasNext()) {
			Vuelo vuelo = (Vuelo) it.next();
			
			
			
			String vueloFecha = vuelo.getAtributos().get("Fecha");
			String vueloOrigen = vuelo.getMiRuta().getAtributos().get("Origen");
			String vueloDestino = vuelo.getMiRuta().getAtributos().get("Destino");
			boolean f= vueloFecha.equals(fecha);
			boolean cO = vueloOrigen.equals(ciudadOrigen);
			boolean cD= vueloDestino.equals(ciudadDestino);
			
			System.out.println(ciudadOrigen+" "+vueloOrigen+" - "+ciudadDestino+" "+vueloDestino+" - "+fecha+" "+vueloFecha);
			
			if ( f && cO && cO && cD ) {
				return vuelo.getAtributos();
			}
		}

		return null;

	}

	

}
