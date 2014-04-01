package es.unileon.assets.Iterarors;

/**
 * Interfaz que nos permite recorrer la pila tanto de préstamos como de hipotecas.
 *
 */
public interface Iterator {

	/**
	 * Método encargado de devolver el préstamo o hipoteca en el que nos encontremos actualmente.
	 * @return Préstamo o hipoteca.
	 */
	public Object next();
	
	/**
	 * Método encargado de decirnos si hay mas préstamos o hipotecas en la pila.
	 * @return True si hay al menos un préstamo o hipoteca. False en caso contrario.
	 */
	public boolean hasNext();
}
