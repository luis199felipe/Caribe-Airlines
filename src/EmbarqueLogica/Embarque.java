package EmbarqueLogica;

import java.util.ArrayList;

import VentaLogica.Maleta;
import colas.Bicola;
import colas.Cola;
import listasEnlazadas.Pila;

public class Embarque {
	
	private Bicola<Carro>  misCarros;/// Estos son los carros disponibles 0-N
	private Pila<Carro> esperaCarros;// La pila donde se guardan los carros mientras se mueve uno a mantenimiento.
	private ArrayList<Maleta> miCargaAvion; // Contiene Las colas de los carros de cada Avion
	private String fecha; // Digamos que cada embarque se hace por dia.

	public Embarque(String fecha) {
		this.misCarros = new Bicola<Carro>();
		this.esperaCarros = new Pila<Carro>(null);
		this.miCargaAvion = new ArrayList<Maleta>();
		
		System.out.println("La fecha es "+fecha);
		this.fecha = fecha;
	}
	
	public Bicola<Carro> getMisCarros() {
		return misCarros;
	}
	public void setMisCarros(Bicola<Carro> misCarros) {
		this.misCarros = misCarros;
	}
	public Pila<Carro> getEsperaCarros() {
		return esperaCarros;
	}
	public void setEsperaCarros(Pila<Carro> esperaCarros) {
		this.esperaCarros = esperaCarros;
	}
	public ArrayList<Maleta> getMiCargaAvion() {
		return miCargaAvion;
	}
	public void setMiCargaAvion(ArrayList<Maleta> miCargaAvion) {
		this.miCargaAvion = miCargaAvion;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	
		
	
	
}
