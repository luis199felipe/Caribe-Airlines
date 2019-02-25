package listasEnlazadas;

import java.util.Iterator;



public class listaCircular<T> implements Iterable<T> {
	private Nodo inicio;
	private Nodo fin;
	private int tamano;

	public void listaCircular() {
		inicio = null;
		fin = null;
		tamano = 0;
	}

	public int getTamano() {
		return tamano;
	}

	public void agregarAlFinal(int valor) {

		Nodo nuevo = new Nodo(valor);

		if (inicio == null && fin == null) {
			inicio = nuevo;
			fin = nuevo;
			fin.setSiguienteNodo(inicio);
		} else {
			fin.setSiguienteNodo(nuevo);
			nuevo.setSiguienteNodo(inicio);
			fin = nuevo;
		}

		tamano++;
	}

	public void agregarAlInicio(int valor) {
		Nodo nuevo = new Nodo(valor);

		if (inicio == null) {
			inicio = nuevo;
			fin = nuevo;
			fin.setSiguienteNodo(inicio);
		} else {

			nuevo.setSiguienteNodo(inicio);
			inicio = nuevo;
			fin.setSiguienteNodo(inicio);
		}
		tamano++;
	}

	public <T> void agregarEnNodoDespues(T vNodo, int valor) {
		Nodo nuevo = new Nodo(valor);

		if (inicio != null) {

			if (obtenerNodo(vNodo) != null) {
				// Crea ua copia de la lista.
				Nodo aux = inicio;

				while (aux.getValorNodo() != vNodo) {
					aux = aux.getSiguienteNodo();
				}
				Nodo siguiente = aux.getSiguienteNodo();
				aux.setSiguienteNodo(nuevo);
				nuevo.setSiguienteNodo(siguiente);
			}
			// Incrementa el contador de tama�o de la lista.
			tamano++;

		}
	}

	public <T> void agregarEnNodoAntes(T vNodo, int valor) {
		Nodo nuevo = new Nodo(valor);

		if (inicio != null) {

			if (obtenerNodo(vNodo) != null) {

				Nodo aux = inicio;
				int cont = 0;
				while (aux.getSiguienteNodo().getValorNodo() != vNodo && cont<tamano) {
					aux = aux.getSiguienteNodo();
					cont++;
				}
				
				if (aux == fin) {
					aux.setSiguienteNodo(nuevo);
					nuevo.setSiguienteNodo(inicio);
					fin = nuevo;
				}else {
					Nodo siguiente = new Nodo(aux);
					aux.setSiguienteNodo(nuevo);
					nuevo.setSiguienteNodo(siguiente.getSiguienteNodo());	
				}

				tamano++;
			}else {
				System.out.println("El nodo con valor "+vNodo+" no existe en la lista.");
			}
			
		}
	}

	public <T> Object obtenerValorNodo(int posicion) {

		if (posicion >= 0 && posicion < tamano) {

			if (posicion == 0) {
				return inicio.getValorNodo();
			} else {
				Nodo aux = inicio;

				for (int i = 0; i < posicion; i++) {
					
					aux = aux.getSiguienteNodo();
				}

				return aux.getValorNodo();
			}

		} else {
			System.out.println("No existe esa posicion");
			return null;
		}
	}

	public <T> Nodo obtenerNodo(T vNodo) {

		Nodo aux = inicio;
		while (aux.getValorNodo() != vNodo) {
			aux = aux.getSiguienteNodo();
		}
		return aux;
	}

	public <T> int obtenerPosicionNodo(T vN) {
		// if(obtenerNodo)
		if (inicio != null) {
			Nodo aux = inicio;
			int cont = 0;
			while (cont <= tamano && vN != aux.getValorNodo()) {
				cont++;
				aux = aux.getSiguienteNodo();
			}
			if (cont > tamano) {
				return -1;
			} else {
				return cont;
			}

		}
		return -1;
	}

	public boolean estaVacia() {
		if (inicio == null) {
			return true;
		} else {
			return false;
		}
	}

	public void eliminarPrimero() {
		if (!estaVacia()) {
			Nodo aux = inicio.getSiguienteNodo();
			inicio = aux;
			fin.setSiguienteNodo(inicio);
		}
	}

	public void eliminarUltimo() {
		if (!estaVacia()) {
			Nodo aux = inicio;
			while (aux.getSiguienteNodo().getSiguienteNodo() != inicio) {
				aux = aux.getSiguienteNodo();
			}
			aux.setSiguienteNodo(inicio);
			fin = aux;
		}
	}

	public <T> void eliminarNodo(T vNodo) {

		if (obtenerNodo(vNodo) != null) {

			if (inicio.getValorNodo() == vNodo) {
				inicio = inicio.getSiguienteNodo();
				fin.setSiguienteNodo(inicio);
			} else {

				Nodo aux = inicio;
				int cont = 1;
				while (aux.getSiguienteNodo().getValorNodo() != vNodo && cont <= tamano) {
					aux = aux.getSiguienteNodo();
					cont++;
				}
				if (aux.getSiguienteNodo() == fin) {
					aux.setSiguienteNodo(inicio);
					fin = aux;
				} else {
					Nodo siguiente = aux.getSiguienteNodo();
					aux.setSiguienteNodo(siguiente.getSiguienteNodo());
				}
			}
			tamano--;
		}
	}

	
	public <T> void eliminarNodoPorPosicion(int posicion) {

		if (posicion >= 0 && posicion < tamano) {

			if (posicion == 0) {
				inicio = inicio.getSiguienteNodo();
				fin.setSiguienteNodo(inicio);
			} else {

				Nodo aux = inicio;

				for (int i = 0; i < posicion - 1; i++) {
					aux = aux.getSiguienteNodo();
				}
				if (aux.getSiguienteNodo() == fin) {
					aux.setSiguienteNodo(inicio);
					fin = aux;
				} else {
					Nodo siguiente = aux.getSiguienteNodo();

					aux.setSiguienteNodo(siguiente.getSiguienteNodo());

				}
			}
			tamano--;
		}
	}

	
	public void imprimir(){
		int cont = 0;
		Nodo aux = inicio;
		while(aux.getSiguienteNodo() !=null && cont<tamano){
			aux = aux.getSiguienteNodo();
			System.out.println(aux.getValorNodo());
			cont++;
		}
	}

	public <T> void modificarNodo(T vN, int nuevoValor) {

		if (obtenerNodo(vN) != null) {

			Nodo aux = inicio;

			while (aux.getValorNodo() != vN) {
				aux = aux.getSiguienteNodo();
			}

			aux.setValorNodo(nuevoValor);
		}
	}

	public <T> void modificarPorPosicion(int posicion, T valor) {
		if (posicion >= 0 && posicion < tamano) {
			if (posicion == 0) {
				inicio.setValorNodo(valor);
			} else {
				Nodo aux = inicio;
				for (int i = 0; i < posicion; i++) {
					aux = aux.getSiguienteNodo();
				}
				aux.setValorNodo(valor);
			}
		}
	}

	@Override
	public Iterator<T> iterator() {

		return new IteradorListaSimpleCircular(inicio, tamano);
	}

	protected class IteradorListaSimpleCircular implements Iterator<T> {

		private Nodo<T> nodo;
		private int posicion, tamano;

		/**
		 * Constructor de la clase Iterador
		 * 
		 * @param aux
		 *            Primer Nodo de la lista
		 */
		public IteradorListaSimpleCircular(Nodo<T> nodo, int tama) {
			this.nodo = nodo;
			this.tamano = tama;
			this.posicion = 0;
		}

		@Override
		public boolean hasNext() {
			// System.out.println("Posicion has "+posicion+" "+tamano);
			return nodo != null && posicion < tamano;
		}

		@Override
		public T next() {
			// System.out.println(posicion+" "+tamano);

			T valor = nodo.getValorNodo();
			nodo = nodo.getSiguienteNodo();
			posicion++;
			return valor;

		}

		/**
		 * Posici�n actual de la lista
		 * 
		 * @return posici�n
		 */
		public int getPosicion() {
			return posicion;
		}

	}

}