package listasEnlazadas;


/**
 * Clase nodo aplicando Generics
 * 
 * 
 * 
 * **/


public class NodoDoble <T> {

	private NodoDoble<T> siguienteNodo;
	private NodoDoble<T> anteriorNodo;
	private T valorNodo;
	
	
	/**
	 * Constructor de la clase Nodo
	 * @param dato Elemento que se guarda en el Nodo
	 */
	public NodoDoble(T valorNodo) {
		this.valorNodo = valorNodo;
	}
	
	public NodoDoble(NodoDoble<T> Nodo) {
		this.valorNodo = Nodo.getValorNodo();
		this.siguienteNodo = Nodo.getSiguienteNodo();
		this.anteriorNodo = Nodo.getAnteriorNodo();
	}
	
	
	public NodoDoble(T dato, NodoDoble<T> siguiente,NodoDoble<T> anterior) {
		super();
		this.valorNodo = dato;
		this.siguienteNodo = siguiente;
		this.anteriorNodo = anterior;
	}
	

	public void setValorNodo(T valor) {
		this.valorNodo = valor;
	}


	public NodoDoble<T> getSiguienteNodo() {
		return siguienteNodo;
	}


	public void setSiguienteNodo(NodoDoble<T> siguienteNodo) {
		this.siguienteNodo = siguienteNodo;
	}


	public T getValorNodo() {
		return valorNodo;
	}



	public NodoDoble<T> getAnteriorNodo() {
		return anteriorNodo;
	}


	public void setAnteriorNodo(NodoDoble<T> anteriorNodo) {
		this.anteriorNodo = anteriorNodo;
	}
	
	
	
}
