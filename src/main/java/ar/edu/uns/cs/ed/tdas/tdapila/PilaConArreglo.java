package ar.edu.uns.cs.ed.tdas.tdapila;

import ar.edu.uns.cs.ed.tdas.excepciones.EmptyStackException;

public class PilaConArreglo<E> implements Stack<E> {

	private E[] datos;
	private int size;
	
	
	public PilaConArreglo(int MAX) {datos=(E[])new Object[MAX]; size=0;}
	

	public PilaConArreglo() {datos=(E[])new Object[5];size=0;}
		
	public int size() {return size;}

	public boolean isEmpty() {return (size==0);	}

	public E top() {
		if (size==0) throw new EmptyStackException("top(): No se puede ver el tope de la pila vacia.");
		return datos[size-1];		
	}
	
	private E[] copy() {
		    E[] toReturn=(E[]) new Object[datos.length*2];		    
		    int i=0;
		    while (i<datos.length){
		    	toReturn[i]= datos[i];
		    	i++;
		    }		    
		    return toReturn;		    
	}
	
	public void push(E e) {
		if (size==datos.length) datos=copy();
		datos[size]=e; 
		size++; 
	}
	
	
	public E pop() {
		if (size==0) throw new EmptyStackException("pop(): No se puede ver el tope de la pila. La pila se ecuentra vacia.");
		E tope = datos[size-1]; 
		size--;
		datos[size]=null;		
		return tope;		
	}
	
}