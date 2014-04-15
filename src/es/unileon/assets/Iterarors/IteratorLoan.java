package es.unileon.assets.Iterarors;

import java.awt.Component;
import java.util.Stack;

/**
 * Iterador de los préstmos que implementa la interfaz Iterator para poder recorrerlos.
 * 
 */
public class IteratorLoan implements Iterator{
	
	/**
	 * Pila que contendrá todos los elementos.
	 */
	private Stack<Component> stack;

	/**
	 * Contructor encargado de recibir la pila con todos los componentes. 
	 * @param st Pila con los componentes.
	 */
	public IteratorLoan(Stack<Component> st){
		this.stack = st;
		
	}
	@Override
	public Object next() {
		Object aux = null;
		if (stack.isEmpty()!=true)
			aux = stack.pop();
		
		return aux;
	}

	@Override
	public boolean hasNext() {
	
			if (stack.isEmpty()==false)
				return true;
						
		return false;
	}

}
