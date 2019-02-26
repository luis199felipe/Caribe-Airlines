package EmbarqueLogica;

import java.util.ArrayList;
import java.util.List;

import VentaLogica.MaletaEmbarque;
import VentaLogica.MaletaEmbarque;
import colas.Bicola;
import colas.Cola;
import mundo.CaribeAirlines;
import pilas.Pila;

public class Embarque {
	private Bicola<Carro>  carrosEncolados;/// Estos son los carros disponibles 0-N
	private Bicola<Carro> carrosGaraje;// La pila donde se guardan los carros mientras se mueve uno a mantenimiento.
	private Bicola<Carro> carrosMantenimiento;// La pila donde se guardan los carros mientras se mueve uno a mantenimiento.
	private Bicola<Carro> carrosMovidos;
	private ArrayList<MaletaEmbarque> miCargaAvion; // Contiene Las colas de los carros de cada Avion
	private String fecha; // Digamos que cada embarque se hace por dia.
	private ArrayList<MaletaEmbarque> misMaletas;

	public ArrayList<MaletaEmbarque> getMisMaletas() {
		return misMaletas;
	}


	public void setMisMaletas(ArrayList<MaletaEmbarque> misMaletas) {
		this.misMaletas = misMaletas;
	}


	public Embarque(String fecha ) {
		this.carrosEncolados = new Bicola<Carro>();
		this.carrosGaraje = new Bicola<Carro>();
		this.carrosMantenimiento = new Bicola<Carro>();
		this.carrosMovidos = new Bicola<Carro>();
		this.miCargaAvion = new ArrayList<MaletaEmbarque>();
		
		misMaletas =new ArrayList<MaletaEmbarque>();
		crearMisMaletas();
		
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
			
			carrosGaraje.ponerFrente(c);
		}
	}

	public void agregarMantenimiento(String carro) {
		Pila<Carro> aux = new Pila<Carro>();
		boolean encontrado = false;
		while (!encontrado && !carrosEncolados.estaVacia()) {
			Carro c = carrosEncolados.desencolar();
			if (!c.getIdCarro().equals(carro)) {
				aux.push(c);
			}else {
				encontrado = true;
				carrosMantenimiento.encolar(c);
			}
		}
		//System.out.println("Va a empezar a meter de nuevo"+!aux.estaVacia()+" "+aux.getTamano()+" tamaño cola "+carrosGaraje+"");
		while (!aux.estaVacia()) {
			
			Carro c= aux.pop();
			carrosEncolados.ponerFrente(c);
		}
		
	}
	
	
	public String[] obtenerCarrosMantenimiento() {
		String[] c = new String[carrosMantenimiento.getTamano()];
		//	System.out.println("El tamano de carros encolados es  "+c.length);
			Bicola copia = carrosEncolados.clone();
			int cont = 0;
			while (!copia.estaVacia()) {
				c[cont] = copia.desencolar().toString();
				cont++;
			}
			return c;

	}

	public String[] obtenerCarrosMovidos() {
		// TODO Auto-generated method stub
		return null;
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
			//System.out.println("Error "+cont+" "+c.length+" "+copia.getTamano()+" "+!copia.estaVacia());
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
	public Bicola<Carro> getEsperaCarros() {
		return carrosMantenimiento;
	}
	public void setEsperaCarros(Bicola<Carro> carrosMantenimiento2) {
		this.carrosMantenimiento = carrosMantenimiento2;
	}
	public ArrayList<MaletaEmbarque> getMiCargaAvion() {
		return miCargaAvion;
	}
	public void setMiCargaAvion(ArrayList<MaletaEmbarque> miCargaAvion) {
		this.miCargaAvion = miCargaAvion;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void crearMisMaletas() {
		
		MaletaEmbarque m1= new MaletaEmbarque("151","10-10-12", 200);
		MaletaEmbarque m2= new MaletaEmbarque("65","10-22-12", 250);
		MaletaEmbarque m3= new MaletaEmbarque("869","0-0-0", 50);
		

		MaletaEmbarque m4 = new MaletaEmbarque("984","11-15-15", 100);
		MaletaEmbarque m5 = new MaletaEmbarque("15","12-15-15", 100);
		MaletaEmbarque m6 = new MaletaEmbarque("26","13-15-15", 150);
		MaletaEmbarque m7 = new MaletaEmbarque("844","14-15-15", 150);
		
		MaletaEmbarque m8 = new MaletaEmbarque("659","15-12-15", 250 );
		MaletaEmbarque m9 = new MaletaEmbarque("84","15-13-15", 250 );
		
		
		MaletaEmbarque m10 = new MaletaEmbarque("654","15-15-15", 500 );
		
		misMaletas.add(m1);
		misMaletas.add(m2);
		misMaletas.add(m3);
		misMaletas.add(m4);
		misMaletas.add(m5);
		misMaletas.add(m6);
		misMaletas.add(m7);
		misMaletas.add(m8);
		misMaletas.add(m9);
		misMaletas.add(m10);
		
		
	}






	
}
