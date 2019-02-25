package listasEnlazadas;


/**
 * Clase nodo aplicando Generics
 * 
 * 
 * 
 * **/


public class Nodo<T> {

	private Nodo<T> siguienteNodo;
	private T valorNodo;
	
	
	/**
	 * Constructor de la clase Nodo
	 * @param dato Elemento que se guarda en el Nodo
	 */
	public Nodo(T valorNodo) {
		this.valorNodo = valorNodo;
	}
	
	public Nodo(Nodo<T> Nodo) {
		this.valorNodo = Nodo.getValorNodo();
		this.siguienteNodo = Nodo.getSiguienteNodo();
	}
	

	public Nodo(T dato, Nodo<T> siguiente) {
		super();
		this.valorNodo = dato;
		this.siguienteNodo = siguiente;
	}
	

	//Metodos get y set de la clase Nodo
	
	public Nodo<T> getSiguienteNodo() {
		return siguienteNodo;
	}


	public void setSiguienteNodo(Nodo<T> siguienteNodo) {
		this.siguienteNodo = siguienteNodo;
	}
	
	

	public T getValorNodo() {
		return valorNodo;
	}


	public void setValorNodo(T valorNodo) {
		this.valorNodo = valorNodo;
	}
}
