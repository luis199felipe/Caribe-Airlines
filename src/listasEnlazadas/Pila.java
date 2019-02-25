package listasEnlazadas;

public class Pila <T>{
	Nodo<T> cima;
	int cantidad;
	
	
	public Pila(T valor) {
		cima = new Nodo<>(valor);
		cantidad = 1;
	}
	
	
	public void agregar(T v) {
		Nodo nuevo = new Nodo<>(v);
		nuevo.setSiguienteNodo(cima);
		cima =nuevo;
		
	}
	
	public void quitar() {
		Nodo aux = cima.getSiguienteNodo();
		cima = aux;
	}
	
	
}
