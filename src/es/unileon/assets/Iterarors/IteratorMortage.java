package es.unileon.assets.Iterarors;

import java.awt.Component;
import java.util.Stack;

/**
 * Iterador de las hipotecas que implementa la interfaz Iterator para poder recorrerlas.
 * 
 */
public class IteratorMortage implements Iterator{
	
	/**
	 * Pila que contendrá todos los elementos.
	 */
	private Stack<Component> stack;
	
	/**
	 * Contructor encargado de recibir la pila con todos los componentes. 
	 * @param st Pila con los componentes.
	 */
	public IteratorMortage(Stack<Component> st){
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
