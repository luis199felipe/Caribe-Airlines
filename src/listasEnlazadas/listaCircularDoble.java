package listasEnlazadas;
import java.util.Iterator;



public class listaCircularDoble<T>  implements Iterable<T> {
    private NodoDoble<T> inicio;
    private NodoDoble<T> fin;
    private int tamano;

    public void listaCircular(){
        inicio = null;
        fin = null;
        tamano = 0;
        
    }

	public int getTamano() {
		return tamano;
	}

	public void agregarAlFinal(int valor) {

		NodoDoble nuevo = new NodoDoble (valor);

		if (inicio == null && fin == null) {
			inicio = nuevo;
			fin = nuevo;
			inicio.setAnteriorNodo(fin);
			fin.setAnteriorNodo(inicio);
			fin.setSiguienteNodo(inicio);
		} else {
			
			fin.setSiguienteNodo(nuevo);
			nuevo.setSiguienteNodo(inicio);
			nuevo.setAnteriorNodo(fin);
			fin = nuevo;
			inicio.setAnteriorNodo(fin);
		}

		tamano++;
	}

	public void agregarAlInicio(int valor) {
		NodoDoble nuevo = new NodoDoble (valor);

		if (inicio == null) {
			inicio = nuevo;
			fin = nuevo;
			inicio.setSiguienteNodo(fin);
			fin.setSiguienteNodo(inicio);
			fin.setAnteriorNodo(inicio);
		} else {
			
			nuevo.setSiguienteNodo(inicio);
			nuevo.setAnteriorNodo(fin);
			inicio = nuevo;
			fin.setSiguienteNodo(inicio);
		}
		tamano++;
	}

	public <T> void agregarEnNodoDespues(T vNodo, int valor) {
		NodoDoble nuevo = new NodoDoble (valor);

		if (inicio != null) {

			if (obtenerNodo(vNodo) != null) {

				NodoDoble aux = inicio;

				while (aux.getValorNodo() != vNodo) {
					aux = aux.getSiguienteNodo();
				}
				
				NodoDoble siguiente = aux.getSiguienteNodo();
				siguiente.setAnteriorNodo(nuevo);
				nuevo.setAnteriorNodo(aux);
				aux.setSiguienteNodo(nuevo);
				nuevo.setSiguienteNodo(siguiente);
			}
			tamano++;

		}
	}

	public <T> void agregarEnNodoAntes(T vNodo, int valor) {
		NodoDoble nuevo = new NodoDoble (valor);

		if (inicio != null) {

			if (obtenerNodo(vNodo) != null) {

				NodoDoble aux = inicio;
				int cont = 0;
				while (aux.getSiguienteNodo().getValorNodo() != vNodo && cont<tamano) {
					aux = aux.getSiguienteNodo();
					cont++;
				}
				
				
				
				if (aux == fin.getAnteriorNodo()) {
					nuevo.setSiguienteNodo(fin);
					aux.setSiguienteNodo(nuevo);
					nuevo.setAnteriorNodo(aux);
					fin.setAnteriorNodo(nuevo);
					
				}else {
					aux.getSiguienteNodo().setAnteriorNodo(nuevo);
					nuevo.setSiguienteNodo(aux.getSiguienteNodo());
					nuevo.setAnteriorNodo(aux);
					aux.setSiguienteNodo(nuevo);
					
					
				}

				tamano++;
			}else {
				System.out.println("El Nodo scon valor "+vNodo+" no existe en la lista.");
			}
			
		}
	}

	public <T> Object obtenerValorNodo(int posicion) {

		if (posicion >= 0 && posicion < tamano) {

			if (posicion == 0) {
				return inicio.getValorNodo();
			} else {
				NodoDoble aux = inicio;

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

	public <T> NodoDoble obtenerNodo(T vNodo) {

		NodoDoble aux = inicio;
		while (aux.getValorNodo() != vNodo) {
			aux = aux.getSiguienteNodo();
		}
		return aux;
	}

	public <T> int obtenerPosicionNodo(T vN) {
		// if(obtenerNodo)
		if (inicio != null) {
			NodoDoble aux = inicio;
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
			
			inicio = inicio.getSiguienteNodo();
			inicio.setAnteriorNodo(fin);
			fin.setSiguienteNodo(inicio);
			tamano--;
			
		}
	}

	public void eliminarUltimo() {
		if (!estaVacia()) {
			
			fin = fin.getAnteriorNodo();
			fin.setSiguienteNodo(inicio);
			inicio.setAnteriorNodo(fin);
			tamano--;
		}
	}

	public <T> void eliminarNodo(T vNodo) {

		if (obtenerNodo(vNodo) != null) {

			if (inicio.getValorNodo() == vNodo) {
				this.eliminarPrimero();
			} else if (fin.getValorNodo() == vNodo) {
				this.eliminarUltimo();
			} else {

				NodoDoble aux = inicio;
				int cont = 1;
				while (aux.getSiguienteNodo().getValorNodo() != vNodo && cont <= tamano) {
					aux = aux.getSiguienteNodo();
					cont++;
				}
				
				NodoDoble siguiente = aux.getSiguienteNodo();
				siguiente.getSiguienteNodo().setAnteriorNodo(aux);
				aux.setSiguienteNodo(siguiente.getSiguienteNodo());
	
			}
			tamano--;
		}
	}

	public <T> void eliminarNodoPorPosicion(int posicion) {

		if (posicion >= 0 && posicion < tamano) {

			if (posicion == 0) {
				this.eliminarPrimero();
			} else if(posicion==tamano-1){
				this.eliminarUltimo();
			}else {

				NodoDoble aux = inicio;

				for (int i = 0; i < posicion; i++) {
					aux = aux.getSiguienteNodo();
				}
				this.eliminarNodo(aux.getValorNodo());
			}
		}
	}

	public <T> void modificarNodo(T vN, int nuevoValor) {

		if (obtenerNodo(vN) != null) {

			NodoDoble aux = inicio;

			while (aux.getValorNodo() != vN) {
				aux = aux.getSiguienteNodo();
			}

			aux.setValorNodo(nuevoValor);
		}
	}

	public <T> void modificarPorPosicion(int posicion, T valor) {
		if (posicion >= 0 && posicion < tamano) {
			if (posicion == 0) {
				//inicio.setValorNodo(valor);
			} else {
				NodoDoble aux = inicio;
				for (int i = 0; i < posicion; i++) {
					aux = aux.getSiguienteNodo();
				}
				aux.setValorNodo(valor);
			}
		}
	}

	@Override
	public Iterator<T> iterator() {

		return new IteradorListaCircularDoble(inicio, tamano);
	}

	protected class IteradorListaCircularDoble implements Iterator<T> {

		private NodoDoble<T> nodo;
		private int posicion, tamano;

		
		public IteradorListaCircularDoble(NodoDoble<T> nodo, int tama) {
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
			System.out.println("Valor: "+valor+", nodoAnt: "+nodo.getAnteriorNodo().getValorNodo()+", nodoSig: "+nodo.getSiguienteNodo().getValorNodo());
			nodo = nodo.getSiguienteNodo();
			posicion++;
			return valor;
		}


		/**
		 * Posición actual de la lista
		 * 
		 * @return posición
		 */
		public int getPosicion() {
			return posicion;
		}

	}

}