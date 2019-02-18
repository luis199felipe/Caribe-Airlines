package VentaLogica;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import mundo.CaribeAirlines;
import vueloLogica.Ruta;
import vueloLogica.Vuelo;

public class Compra {

	private CaribeAirlines aerolinea;
	private Tiquete miTiquete;

	public Compra(CaribeAirlines ae) {// Aqui la aerolinea se recibe por parametro. Por ahora creo uno para no entrar
						// a editar la interfaz principal.
		aerolinea = ae;
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

	public Vuelo verificarVuelo(String ciudadOrigen,String ciudadDestino, String fecha) {

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
			
			//System.out.println(ciudadOrigen+" "+vueloOrigen+" - "+ciudadDestino+" "+vueloDestino+" - "+fecha+" "+vueloFecha);
			
			if ( f && cO && cO && cD ) {
				return vuelo;
			}
		}

		return null;

	}

	public boolean verificarCupo(String iden, String num, String cod, String fec, String tipo,double valorCompra) {
		List<Tarjeta> tjs = aerolinea.getTarjetas();
		
		System.out.println(iden+" "+num.substring(1)+" "+cod+" "+fec+" "+tipo);
		
		Iterator<Tarjeta> tj = tjs.iterator();
		
		while (tj.hasNext()) {
			Tarjeta tarjeta = (Tarjeta) tj.next();
			System.out.println(tarjeta.getMiClienteID()+" "+tarjeta.getNumero()+" "+tarjeta.getCodigo()+" "+tarjeta.getFecha()+" "+tarjeta.getTipo()+" ");
			System.out.println(tarjeta.getMiClienteID().equals(iden) +" "+tarjeta.getNumero().equals(num.substring(1)) +" "+tarjeta.getCodigo().equals(cod) +" "+tarjeta.getFecha().equals(fec)+" "+tarjeta.getTipo().equals(tipo) );
			if (tarjeta.getMiClienteID().equals(iden) && tarjeta.getNumero().equals(num.substring(1)) && tarjeta.getCodigo().equals(cod) && tarjeta.getFecha().equals(fec) && tarjeta.getTipo().equals(tipo)) {
				if (tarjeta.getCupo()>valorCompra) {
					return true;	
				}else {
					JOptionPane.showMessageDialog(null, "El precio de la compra excede el cupo de su tarjeta");
				}
			}
		}
		return false;
		
	}

	

}
