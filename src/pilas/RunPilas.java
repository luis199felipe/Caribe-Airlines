package pilas;

public class RunPilas {

	public static void main(String[] args) {
	
		
		
		Pila<Libro> pila = new Pila<Libro>();

        Libro l1 = new Libro("T�tulo 1", "Autor 1");
        Libro l2 = new Libro("T�tulo 2", "Autor 2");
        Libro l3 = new Libro("T�tulo 3", "Autor 3");

        pila.push(l1); // adiciona un libro a la pila
        pila.push(l2);
        pila.push(l3);

//        System.out.println(pila.peek().getTitulo()); // el �ltimo elemento adicionado

        while (!pila.estaVacia()) { // mostrar pila completa
            System.out.println(pila.pop().getTitulo()); // extrae un elemento de la pila
        }
		
		

	}

}
