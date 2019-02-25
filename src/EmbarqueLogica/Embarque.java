package EmbarqueLogica;

import java.util.ArrayList;

import VentaLogica.Maleta;
import colas.Bicola;
import colas.Cola;
import pilas.Pila;

public class Embarque {
	
	private Bicola<Carro>  carrosEncolados;/// Estos son los carros disponibles 0-N
	private Bicola<Carro> carrosGaraje;// La pila donde se guardan los carros mientras se mueve uno a mantenimiento.
	private Pila<Carro> esperaCarros;// La pila donde se guardan los carros mientras se mueve uno a mantenimiento.
	private ArrayList<Maleta> miCargaAvion; // Contiene Las colas de los carros de cada Avion
	private String fecha; // Digamos que cada embarque se hace por dia.

	public Embarque(String fecha) {
		this.carrosEncolados = new Bicola<Carro>();
		this.esperaCarros = new Pila<Carro>();
		
		this.miCargaAvion = new ArrayList<Maleta>();
		
		
		this.carrosGaraje = new Bicola<Carro>();
		for (int i = 0; i < 22; i++) {
			carrosGaraje.encolar(new Carro(i+"", 0, null, false));
		}
		
		this.fecha = fecha;
	}
	
	
	public void encolarCarroEmbarque(String buscado) {
		Pila<Carro> aux = new Pila<Carro>();
		boolean encontrado = false;
		while (!encontrado && !carrosGaraje.estaVacia()) {
			Carro c = carrosGaraje.desencolar();
			if (!c.getIdCarro().equals(buscado)) {
				aux.push(c);
			}else {
				encontrado = true;
				carrosEncolados.encolar(c);
			}
		}
		//System.out.println("Va a empezar a meter de nuevo"+!aux.estaVacia()+" "+aux.getTamano()+" tamaño cola "+carrosGaraje+"");
		while (!aux.estaVacia()) {
			
			Carro c= aux.pop();
			System.out.println("encolo "+c.getIdCarro());
			carrosGaraje.ponerFrente(c);
		}
	}
	
	public String[] obtenerCarrosEncolados() {
		String[] c = new String[carrosEncolados.getTamano()];
	//	System.out.println("El tamano de carros encolados es  "+c.length);
		Bicola copia = carrosEncolados.clone();
		int cont = 0;
		while (!copia.estaVacia()) {
			c[cont] = copia.desencolar().toString();
			cont++;
		}
		return c;
	}
	
	public String[] obtenerCarrosGaraje() {
		String[] c = new String[carrosGaraje.getTamano()];
		Bicola copia = carrosGaraje.clone();
		int cont = 0;
		
		while (!copia.estaVacia()) {
			System.out.println("Error "+cont+" "+c.length+" "+copia.getTamano()+" "+!copia.estaVacia());
			c[cont] = copia.desencolar().toString();
			cont++;
		}
		return c;
	}
	
	
	public Bicola<Carro> getCarrosEncolados() {
		return carrosEncolados;
	}


	public void setCarrosEncolados(Bicola<Carro> carrosEncolados) {
		this.carrosEncolados = carrosEncolados;
	}


	public Bicola<Carro> getCarrosGaraje() {
		return carrosGaraje;
	}


	public void setCarrosGaraje(Bicola<Carro> carrosGaraje) {
		this.carrosGaraje = carrosGaraje;
	}

	public void setMisCarros(Bicola<Carro> misCarros) {
		this.carrosEncolados = misCarros;
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
