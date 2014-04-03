package es.unileon.assets.Iterarors;

/**
 * Interfaz que nos permite recorrer la pila tanto de pr�stamos como de hipotecas.
 *
 */
public interface Iterator {

	/**
	 * M�todo encargado de devolver el pr�stamo o hipoteca en el que nos encontremos actualmente.
	 * @return Pr�stamo o hipoteca.
	 */
	public Object next();
	
	/**
	 * M�todo encargado de decirnos si hay mas pr�stamos o hipotecas en la pila.
	 * @return True si hay al menos un pr�stamo o hipoteca. False en caso contrario.
	 */
	public boolean hasNext();
}
