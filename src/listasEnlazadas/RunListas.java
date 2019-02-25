package listasEnlazadas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;


import listasEnlazadas.ListaSimple.IteradorListaSimple;

public class RunListas {

	public static <T> void main(String[] args) {


//		ArrayList lista1 = new ArrayList();	
//		ListaSimple<Integer> listaEnteros = new ListaSimple<>();
//		listaEnteros.agregarInicio(1);
//		listaEnteros.agregarInicio(6);
//		listaEnteros.agregarInicio(7);
//	
		
		listaCircular<Integer> listaEnterosCircular = new listaCircular<>();
		listaEnterosCircular.agregarAlInicio(1);
		listaEnterosCircular.agregarAlInicio(2);
//		listaEnterosCircular.agregarAlFinal(3);
//		listaEnterosCircular.agregarAlInicio(4);
//		listaEnterosCircular.agregarAlFinal(5);
//		listaEnterosCircular.agregarAlFinal(6);
//		listaEnterosCircular.agregarEnNodoDespues(3, 7);
//		listaEnterosCircular.agregarEnNodoAntes(3,8);
//		
//		System.out.println("En posicion 3 esta el nodo "+listaEnterosCircular.obtenerValorNodo(3)+" ");
//		
//		System.out.println("Obtener el nodo 7 "+listaEnterosCircular.obtenerNodo(7));
//		
//		System.out.println("el nodo con valor 1 esta en la posicion: "+ listaEnterosCircular.obtenerPosicionNodo(1));
//		
//		System.out.println("la lista esta vacia? "+listaEnterosCircular.estaVacia());
//		
//		System.out.println("Eliminar nodo 5 " );
//		listaEnterosCircular.eliminarNodo(5);
//		
//		System.out.println("Eliminar nodo en posicion 1");
//		listaEnterosCircular.eliminarNodoPorPosicion(1);
//		
//		System.out.println("Modificar Nodo 4 por 9 ");
//		listaEnterosCircular.modificarNodo(4, 9);
//		
//		System.out.println("Modificar nodo en la posicion 2 por 88");
//		listaEnterosCircular.modificarPorPosicion(2, 88);
//		
		System.out.println("Iterator: ");
		
		Iterator<Integer> itCir = listaEnterosCircular.iterator();
		
		while (itCir.hasNext()) {
			int n = itCir.next();
			System.out.println(n);
		}
		
//		
//		
//		listaCircularDoble<Integer> listaEnterosCircularDoble = new listaCircularDoble<>();
//		
//		listaEnterosCircularDoble.agregarAlFinal(1);
//		listaEnterosCircularDoble.agregarAlFinal(2);
//		listaEnterosCircularDoble.agregarAlFinal(3);
//		listaEnterosCircularDoble.agregarAlFinal(4);
//		listaEnterosCircularDoble.agregarAlInicio(5);
//		listaEnterosCircularDoble.agregarEnNodoDespues(3, 44);
//		listaEnterosCircularDoble.agregarEnNodoAntes(4, 45);
//		listaEnterosCircularDoble.agregarEnNodoAntes(2, 22);
//		
//		listaEnterosCircularDoble.eliminarPrimero();
//		listaEnterosCircularDoble.eliminarUltimo();
//		listaEnterosCircularDoble.eliminarNodo(3);
//		listaEnterosCircularDoble.eliminarNodoPorPosicion(2);
//		
//		
//		Iterator<Integer> it = listaEnterosCircularDoble.iterator();
//		
//		
//		while (it.hasNext()) {
//			int n = it.next();
//			System.out.println(n);
//			
//		}
//		
//		
		
		
	}
	
	static <T> boolean borrarParesOImpares (Nodo<T> nodo) {
		boolean resul;
		Nodo<T> aux;
		if (nodo != null) {
			aux = nodo;
			nodo = nodo.getSiguienteNodo();
			resul = borrarParesOImpares (nodo);
			if (!resul && (nodo != null))
			{
				aux.setSiguienteNodo(nodo.getSiguienteNodo());
				resul = !resul;
			}

		}
		else resul = true;
		return resul;
	}
	
	static <T> void borrarPosicionesParesOImpares (ListaSimple<T> lista){
		boolean resul = borrarParesOImpares (lista.getNodoPrimero());
		if (!resul)
			lista.setNodoPrimero(lista.getNodoPrimero().getSiguienteNodo());
	}
	
	
	

}
